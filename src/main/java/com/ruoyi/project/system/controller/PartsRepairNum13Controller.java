package com.ruoyi.project.system.controller;

import java.util.*;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.project.system.domain.PartsMakeNum9;
import com.ruoyi.project.system.domain.QualityProblem1;
import com.ruoyi.project.system.service.IQualityProblem1Service;
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
import com.ruoyi.project.system.domain.PartsRepairNum13;
import com.ruoyi.project.system.service.IPartsRepairNum13Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2022-12-02
 */
@RestController
@RequestMapping("/system/13")
public class PartsRepairNum13Controller extends BaseController
{
    @Autowired
    private IPartsRepairNum13Service partsRepairNum13Service;
    @Autowired
    private IQualityProblem1Service qualityProblem1Service;
    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:13:list')")
    @GetMapping("/list")
    public TableDataInfo list(PartsRepairNum13 partsRepairNum13)
    {
        startPage();
        List<PartsRepairNum13> list = partsRepairNum13Service.selectPartsRepairNum13List(partsRepairNum13);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:13:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PartsRepairNum13 partsRepairNum13)
    {
        List<PartsRepairNum13> list = partsRepairNum13Service.selectPartsRepairNum13List(partsRepairNum13);
        ExcelUtil<PartsRepairNum13> util = new ExcelUtil<PartsRepairNum13>(PartsRepairNum13.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:13:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(partsRepairNum13Service.selectPartsRepairNum13ById(id));
    }


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



    public List<PartsMakeNum9Controller.ModelCount> faultStatistics(QualityProblem1 qualityProblem1)
    {
        Set<String> modelName = new HashSet<>();
        List<QualityProblem1> list = qualityProblem1Service.selectQualityProblem1List(qualityProblem1);
        List<PartsMakeNum9Controller.ModelCount> listMC = new ArrayList<>();
        List<PartsMakeNum9Controller.ModelCount> listMod = new ArrayList<>();
        double averge = 0;
        int sum=0;
        int count;
        for(QualityProblem1 q:list){
            modelName.add(q.getFaultModel());
        }

        for (String s:modelName) {
            count = 0;
            PartsMakeNum9Controller.ModelCount modelCount = new PartsMakeNum9Controller.ModelCount();
            for (QualityProblem1 q : list) {
                if (Objects.equals(s, q.getFaultModel())) {
                    modelCount.setFaultModel(s);
                    count++;
                    modelCount.setModelCount(count);
                }
            }
            listMC.add(modelCount);
        }
        for(PartsMakeNum9Controller.ModelCount m : listMC){
            sum+=m.getModelCount();
        }
        averge = sum/listMC.size()*0.1;
        for(PartsMakeNum9Controller.ModelCount m : listMC){
            if(m.getModelCount()>averge){
                listMod.add(m);
            }
        }
        return listMod;
    }

    //获取所有故障模式为高发故障模式的质量问题
    public  List<QualityProblem1> get_high_qua(QualityProblem1 qualityProblem1){
        List<QualityProblem1> list = qualityProblem1Service.selectQualityProblem1List(qualityProblem1);
        List<PartsMakeNum9Controller.ModelCount> listMod= faultStatistics(qualityProblem1);
        List<QualityProblem1> listqua = new ArrayList<>();
        for(QualityProblem1 q : list){
            for(PartsMakeNum9Controller.ModelCount m : listMod){
                if(q.getFaultModel().equals(m.getFaultModel())){
                    listqua.add(q);
                }
            }

        }
        return  listqua;
    }





    //对数据13中的产品制造人员进行处理  返回所有维修人员
    public List<String>  get_all_person(PartsRepairNum13 partsRepairNum13){
        List<PartsRepairNum13> list = partsRepairNum13Service.selectPartsRepairNum13List(partsRepairNum13);
        List<String> person = new ArrayList<>();
        for(PartsRepairNum13 p : list){
            String personlist= p.getPartsRepairPeople();
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


    //返回  人员名字  质量问题数  维修产品数  产品编号列表
    @GetMapping("/Countrepair")
    public List<person_quailty_num> Countqua(QualityProblem1 qualityProblem1, PartsRepairNum13 partsRepairNum13){
        List<PartsRepairNum13> list = partsRepairNum13Service.selectPartsRepairNum13List(partsRepairNum13);
        // List<QualityProblem1> list3 = qualityProblem1Service.selectQualityProblem1List(qualityProblem1);
        List<QualityProblem1> list2 = get_high_qua(qualityProblem1);
        List<String> person = get_all_person(partsRepairNum13);
        List<person_quailty_num> person_quailty_num = new ArrayList<>();
        for(String s : person){
            person_quailty_num p = new person_quailty_num();
            p.setPerson(s);
            p.setRepaire(0);
            p.setQuality(0);
            person_quailty_num.add(p);
        }
        for(PartsRepairNum13 p: list){
            String personlist= p.getPartsRepairPeople();
            StringBuilder stringBuffer = new StringBuilder(personlist);
            stringBuffer.deleteCharAt(0);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
            personlist=stringBuffer.toString();
            String[] persons = personlist.split(",");
            for(int i=0;i<persons.length;i++){
                for(person_quailty_num per : person_quailty_num){
                    if(per.getPerson().equals(persons[i])){
                        //  per.setQuality(per.getQuality()+1);
                        per.setRepaire(per.getRepaire()+1);
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
            System.out.println(p.getRepaire());
            System.out.println(p.getQuality());
            System.out.println("---------");
        }
        System.out.println(person_quailty_num);*/
        return person_quailty_num;

    }







    static class person_quailty_num{

        private String person;
        private int quality;
        private int repaire;
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

        public int getRepaire() {
            return repaire;
        }

        public void setRepaire(int repaire) {
            this.repaire = repaire;
        }

        public List<String> getCode() {
            return code;
        }

        public void setCode(List<String> code) {
            this.code = code;
        }
    }




    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:13:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PartsRepairNum13 partsRepairNum13)
    {
        return toAjax(partsRepairNum13Service.insertPartsRepairNum13(partsRepairNum13));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:13:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PartsRepairNum13 partsRepairNum13)
    {
        return toAjax(partsRepairNum13Service.updatePartsRepairNum13(partsRepairNum13));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:13:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(partsRepairNum13Service.deletePartsRepairNum13ByIds(ids));
    }
}
