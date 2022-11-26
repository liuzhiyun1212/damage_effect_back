package com.ruoyi.project.system.controller;

import java.util.*;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.project.system.domain.QualityProblem;
import com.ruoyi.project.system.domain.QualityProblem1;
import com.ruoyi.project.system.service.IQualityProblem1Service;
import com.ruoyi.project.system.service.IQualityProblemService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.domain.PartsMakeNum9;
import com.ruoyi.project.system.service.IPartsMakeNum9Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 9：装备使用数据Controller
 *
 * @author ruoyi
 * @date 2022-11-18
 */
@RestController
@RequestMapping("/system/9")
public class PartsMakeNum9Controller extends BaseController
{
    @Autowired
    private IPartsMakeNum9Service partsMakeNum9Service;
    @Autowired
    private IQualityProblem1Service qualityProblem1Service;
    @Autowired
    private IQualityProblemService qualityProblemService;

    static class ModelCount {
        public String getFaultModel() {
            return faultModel;
        }

        public void setFaultModel(String faultModel) {
            this.faultModel = faultModel;
        }

        public int getModelCount() {
            return modelCount;
        }

        public void setModelCount(int modelCount) {
            this.modelCount = modelCount;
        }

        private String faultModel;
        private int modelCount;
    }



    public List<ModelCount> faultStatistics(QualityProblem1 qualityProblem1)
    {
        Set<String> modelName = new HashSet<>();
        List<QualityProblem1> list = qualityProblem1Service.selectQualityProblem1List(qualityProblem1);
        List<ModelCount> listMC = new ArrayList<>();
        List<ModelCount> listMod = new ArrayList<>();
        double averge = 0;
        int sum=0;
        int count;
        for(QualityProblem1 q:list){
            modelName.add(q.getFaultModel());
        }

        for (String s:modelName) {
            count = 0;
            ModelCount modelCount = new ModelCount();
            for (QualityProblem1 q : list) {
                if (Objects.equals(s, q.getFaultModel())) {
                    modelCount.setFaultModel(s);
                    count++;
                    modelCount.setModelCount(count);
                }
            }
            listMC.add(modelCount);
        }
        for(ModelCount m : listMC){
            sum+=m.getModelCount();
        }
        averge = sum/listMC.size()*0.1;
        for(ModelCount m : listMC){
            if(m.getModelCount()>averge){
                listMod.add(m);
            }
        }
        return listMod;
    }

    //获取所有故障模式为高发故障模式的质量问题
    public List<QualityProblem1> get_high_qua(QualityProblem1 qualityProblem1){
        List<QualityProblem1> list = qualityProblem1Service.selectQualityProblem1List(qualityProblem1);
        List<ModelCount> listMod= faultStatistics(qualityProblem1);
        List<QualityProblem1> listqua = new ArrayList<>();
        for(QualityProblem1 q : list){
            for(ModelCount m : listMod){
                if(q.getFaultModel().equals(m.getFaultModel())){
                    listqua.add(q);
                }
            }

        }
        return  listqua;
    }
    //对数据9中的产品制造人员进行处理
    public List<String>  get_all_person(PartsMakeNum9 partsMakeNum9){
        List<PartsMakeNum9> list = partsMakeNum9Service.selectPartsMakeNum9List(partsMakeNum9);
        List<String> person = new ArrayList<>();
        for(PartsMakeNum9 p : list){
            String personlist= p.getPartsMakePeople();
            StringBuilder stringBuffer = new StringBuilder(personlist);
            stringBuffer.deleteCharAt(0);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
            personlist=stringBuffer.toString();
            String[] persons = personlist.split(",");
            person.addAll(Arrays.asList(persons));
        }
        HashSet set = new HashSet(person);
        //把List集合所有元素清空
        person.clear();
        //把HashSet对象添加至List集合
        person.addAll(set);
        return person;
    }

    //返回  人员名字  质量问题数  生产产品数  产品编号列表
    @GetMapping("/Countqua")
    public List<person_quailty_num> Countqua(QualityProblem1 qualityProblem1,PartsMakeNum9 partsMakeNum9){
        List<PartsMakeNum9> list = partsMakeNum9Service.selectPartsMakeNum9List(partsMakeNum9);
       // List<QualityProblem1> list3 = qualityProblem1Service.selectQualityProblem1List(qualityProblem1);
        List<QualityProblem1> list2 = get_high_qua(qualityProblem1);
        List<String> person = get_all_person(partsMakeNum9);
        List<person_quailty_num> person_quailty_num = new ArrayList<>();
        for(String s : person){
            person_quailty_num p = new person_quailty_num();
            p.setPerson(s);
            p.setProduct(0);
            p.setQuality(0);
            person_quailty_num.add(p);
        }
        for(PartsMakeNum9 p: list){
            String personlist= p.getPartsMakePeople();
            StringBuilder stringBuffer = new StringBuilder(personlist);
            stringBuffer.deleteCharAt(0);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
            personlist=stringBuffer.toString();
            String[] persons = personlist.split(",");
            for(int i=0;i<persons.length;i++){
                for(person_quailty_num per : person_quailty_num){
                    if(per.getPerson().equals(persons[i])){
                      //  per.setQuality(per.getQuality()+1);
                        per.setProduct(per.getProduct()+1);
                        per.addcode(p.getPartsCode());
                    }
                }
            }

        }
        for(QualityProblem1 q : list2){
            for(person_quailty_num p : person_quailty_num){
                for(String s : p.getCode()){
                    if(q.getPartsCode().equals(s)){
                        p.setQuality(p.getQuality()+1);
                    }
                }
            }
        }
        /*for(person_quailty_num p : person_quailty_num){
            System.out.println(p.getCode());
            System.out.println(p.getPerson());
            System.out.println(p.getProduct());
            System.out.println(p.getQuality());
            System.out.println("---------");
        }
        System.out.println(person_quailty_num);*/
    return person_quailty_num;

    }

    static class person_quailty_num{

        private String person;
        private int quality;
        private int product;
        private List<String> code = new ArrayList<>();


        public void addcode(String s){
            code.add(s);
        }

        public String getPerson() {
            return person;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        public int getQuality() {
            return quality;
        }

        public void setQuality(int quality) {
            this.quality = quality;
        }

        public int getProduct() {
            return product;
        }

        public void setProduct(int product) {
            this.product = product;
        }

        public List<String> getCode() {
            return code;
        }

        public void setCode(List<String> code) {
            this.code = code;
        }
    }





    /**
     * 查询9：装备使用数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:9:list')")
    @GetMapping("/list")
    public TableDataInfo list(PartsMakeNum9 partsMakeNum9)
    {
        startPage();
        List<PartsMakeNum9> list = partsMakeNum9Service.selectPartsMakeNum9List(partsMakeNum9);
        return getDataTable(list);
    }

    /**
     * 导出9：装备使用数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:9:export')")
    @Log(title = "9：装备使用数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PartsMakeNum9 partsMakeNum9)
    {
        List<PartsMakeNum9> list = partsMakeNum9Service.selectPartsMakeNum9List(partsMakeNum9);
        ExcelUtil<PartsMakeNum9> util = new ExcelUtil<PartsMakeNum9>(PartsMakeNum9.class);
        util.exportExcel(response, list, "9：装备使用数据数据");
    }

    /**
     * 获取9：装备使用数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:9:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(partsMakeNum9Service.selectPartsMakeNum9ById(id));
    }

    /**
     * 新增9：装备使用数据
     */
    @PreAuthorize("@ss.hasPermi('system:9:add')")
    @Log(title = "9：装备使用数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PartsMakeNum9 partsMakeNum9)
    {
        return toAjax(partsMakeNum9Service.insertPartsMakeNum9(partsMakeNum9));
    }

    /**
     * 修改9：装备使用数据
     */
    @PreAuthorize("@ss.hasPermi('system:9:edit')")
    @Log(title = "9：装备使用数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PartsMakeNum9 partsMakeNum9)
    {
        return toAjax(partsMakeNum9Service.updatePartsMakeNum9(partsMakeNum9));
    }

    /**
     * 删除9：装备使用数据
     */
    @PreAuthorize("@ss.hasPermi('system:9:remove')")
    @Log(title = "9：装备使用数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(partsMakeNum9Service.deletePartsMakeNum9ByIds(ids));
    }
}
