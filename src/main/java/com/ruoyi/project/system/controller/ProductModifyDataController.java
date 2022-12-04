package com.ruoyi.project.system.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.ProductModify;
import com.ruoyi.project.system.domain.ProductModifyData;
import com.ruoyi.project.system.domain.QualityProblem1;
import com.ruoyi.project.system.service.IProductModifyDataService;
import com.ruoyi.project.system.service.IQualityProblem1Service;
import com.ruoyi.project.system.service.IQualityProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 产品制造变更数据Controller
 *
 * @author ruoyi
 * @date 2022-11-11
 */
@RestController
@RequestMapping("/system/modifyData")
public class ProductModifyDataController extends BaseController
{
    @Autowired
    private IProductModifyDataService productModifyDataService;
    @Autowired
    private IQualityProblem1Service qualityProblem1Service;
    @Autowired
    private IQualityProblemService qualityProblemService;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8")
    /**
     * 查询产品制造变更数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:modifyData:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductModifyData productModifyData)
    {
        startPage();
        List<ProductModifyData> list = productModifyDataService.selectProductModifyDataList(productModifyData);
        return getDataTable(list);
    }

    /**
     * 导出产品制造变更数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:modifyData:export')")
    @Log(title = "产品制造变更数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductModifyData productModifyData)
    {
        List<ProductModifyData> list = productModifyDataService.selectProductModifyDataList(productModifyData);
        ExcelUtil<ProductModifyData> util = new ExcelUtil<ProductModifyData>(ProductModifyData.class);
        util.exportExcel(response, list, "产品制造变更数据数据");
    }

    /**
     * 获取产品制造变更数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:modifyData:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(productModifyDataService.selectProductModifyDataById(id));
    }

    /**
     * 新增产品制造变更数据
     */
    @PreAuthorize("@ss.hasPermi('system:modifyData:add')")
    @Log(title = "产品制造变更数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductModifyData productModifyData)
    {
        return toAjax(productModifyDataService.insertProductModifyData(productModifyData));
    }

    /**
     * 修改产品制造变更数据
     */
    @PreAuthorize("@ss.hasPermi('system:modifyData:edit')")
    @Log(title = "产品制造变更数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductModifyData productModifyData)
    {
        return toAjax(productModifyDataService.updateProductModifyData(productModifyData));
    }

    /**
     * 删除产品制造变更数据
     */
    @PreAuthorize("@ss.hasPermi('system:modifyData:remove')")
    @Log(title = "产品制造变更数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productModifyDataService.deleteProductModifyDataByIds(ids));
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
    public List<QualityProblem1> get_high_qua(QualityProblem1 qualityProblem1) {
        List<QualityProblem1> list = qualityProblem1Service.selectQualityProblem1List(qualityProblem1);
        List<PartsMakeNum9Controller.ModelCount> listMod = faultStatistics(qualityProblem1);
        List<QualityProblem1> listqua = new ArrayList<>();
        for (QualityProblem1 q : list) {
            for (PartsMakeNum9Controller.ModelCount m : listMod) {
                if (q.getFaultModel().equals(m.getFaultModel())) {
                    listqua.add(q);
                }
            }

        }
        return listqua;
    }

    @GetMapping("/getPeoplechange")
    public List<peopleChange> getPeoplechange(QualityProblem1 qualityProblem1 , ProductModifyData productModifyData){
        List<QualityProblem1> listqua = get_high_qua(qualityProblem1);
        List<ProductModifyData> listpro = productModifyDataService.selectProductModifyDataList(productModifyData);
        List<ProductModifyData> listhigh = new ArrayList<>();   //高发故障模式对应的产品
        List<peopleChange> peoplechange = new ArrayList<>();
        SimpleDateFormat sdfTarget = new SimpleDateFormat("yyyy-MM-dd");
        for(QualityProblem1 l : listqua){
            for(ProductModifyData p : listpro){
                if(l.getPartsName().equals(p.getProductName())&&l.getPartsModel().equals(p.getProductModel())){
                    listhigh.add(p);
                }
            }
        }
        for(ProductModifyData p : listhigh){
            int mark = 0;
            for(peopleChange peo : peoplechange){
                if(peo.getPartsname().equals(p.getProductName())&&peo.getPartsmodel().equals(p.getProductModel())){
                    for(int i =0 ;i<peo.getlistdate().size();i++){
                        if(peo.getlistdate().get(i).equals(sdfTarget.format(p.getModifyTime()))){
                            mark=-1;
                        }
                    }
                    if(mark!=-1){

                        try {
                            Date date = sdfTarget.parse(sdfTarget.format(p.getModifyTime()));
                            peo.add(sdfTarget.format(p.getModifyTime()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Collections.sort(peo.getlistdate());

                    }
                    mark=1;
                }
            }
            if(mark==0){
                peopleChange obj_peo = new peopleChange();
                obj_peo.setPartsmodel(p.getProductModel());
                obj_peo.setPartsname(p.getProductName());
                /*obj_peo.add(p.getModifyTime());*/
                try {
                    Date date = sdfTarget.parse(sdfTarget.format(p.getModifyTime()));
                    obj_peo.add(sdfTarget.format(p.getModifyTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Collections.sort(obj_peo.getlistdate());
                peoplechange.add(obj_peo);
            }
        }
        return peoplechange;
    }


    static class peopleChange{
        private String partsname;
        private String partsmodel;
        private List<String> listdate = new ArrayList<>();


        public void add(String date){
            listdate.add(date);
        }

        public String getPartsname() {
            return partsname;
        }

        public void setPartsname(String partsname) {
            this.partsname = partsname;
        }

        public String getPartsmodel() {
            return partsmodel;
        }

        public void setPartsmodel(String partsmodel) {
            this.partsmodel = partsmodel;
        }

        public List<String> getlistdate() {
            return listdate;
        }

        public void setlistdate(List<String> listdate) {
            this.listdate = listdate;
        }


    }


    /**
     * 导入产品制造变更列表
     */
    @Log(title = "产品制造变更", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ProductModifyData> util = new ExcelUtil<ProductModifyData>(ProductModifyData.class);
        List<ProductModifyData> importDataList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = productModifyDataService.importData(importDataList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    /**
     * @Description 下载导入产品设计模板
     * @Author guohuijia
     * @Date  2022/11/13
     * @Param [response]
     * @Return void
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<ProductModifyData> util = new ExcelUtil<ProductModifyData>(ProductModifyData.class);
        util.importTemplateExcel(response, "产品制造变更数据");
    }

    /**
     * @Description 装备零部件供应商变更时间线
     * @Author guohuijia
     * @Date  2022/12/3
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @PreAuthorize("@ss.hasPermi('system:modifyData:list')")
    @GetMapping("/listPartsManufactureChange")
    public List<ProductModify> listPartsManufactureChange()
    {
        List<ProductModify> list = productModifyDataService.selectPartsManufactureChange();
        return list;
    }
}
