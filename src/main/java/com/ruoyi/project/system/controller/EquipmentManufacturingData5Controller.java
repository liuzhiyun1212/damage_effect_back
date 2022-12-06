package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.EquipmentManufacturingData5;
import com.ruoyi.project.system.domain.QualityProblem;
import com.ruoyi.project.system.domain.QualityProblem1;
import com.ruoyi.project.system.service.IEquipmentManufacturingData5Service;
import com.ruoyi.project.system.service.IQualityProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2022-11-16
 */
@RestController
@RequestMapping("/system/data5")
public class EquipmentManufacturingData5Controller extends BaseController
{
    @Autowired
    private IEquipmentManufacturingData5Service equipmentManufacturingData5Service;
    @Autowired
    private IQualityProblemService qualityProblemService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:data5:list')")
    @GetMapping("/list")
    public TableDataInfo list(EquipmentManufacturingData5 equipmentManufacturingData5)
    {
        startPage();
        List<EquipmentManufacturingData5> list = equipmentManufacturingData5Service.selectEquipmentManufacturingData5List(equipmentManufacturingData5);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:data5:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EquipmentManufacturingData5 equipmentManufacturingData5)
    {
        List<EquipmentManufacturingData5> list = equipmentManufacturingData5Service.selectEquipmentManufacturingData5List(equipmentManufacturingData5);
        ExcelUtil<EquipmentManufacturingData5> util = new ExcelUtil<EquipmentManufacturingData5>(EquipmentManufacturingData5.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:data5:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(equipmentManufacturingData5Service.selectEquipmentManufacturingData5ById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:data5:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipmentManufacturingData5 equipmentManufacturingData5)
    {
        return toAjax(equipmentManufacturingData5Service.insertEquipmentManufacturingData5(equipmentManufacturingData5));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:data5:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipmentManufacturingData5 equipmentManufacturingData5)
    {
        return toAjax(equipmentManufacturingData5Service.updateEquipmentManufacturingData5(equipmentManufacturingData5));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:data5:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipmentManufacturingData5Service.deleteEquipmentManufacturingData5ByIds(ids));
    }


    /**
     * 导入产品制造数据
     */
    @Log(title = "产品制造", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<EquipmentManufacturingData5> util = new ExcelUtil<EquipmentManufacturingData5>(EquipmentManufacturingData5.class);
        List<EquipmentManufacturingData5> importDataList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = equipmentManufacturingData5Service.importData(importDataList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    /**
     * @Description 下载导入模板
     * @Author guohuijia
     * @Date  2022/11/24
     * @Param [response]
     * @Return void
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<EquipmentManufacturingData5> util = new ExcelUtil<EquipmentManufacturingData5>(EquipmentManufacturingData5.class);
        util.importTemplateExcel(response, "产品制造数据");
    }

    //4.2.2.2的折线图
    @GetMapping("/getEquipmentability")
    public List<Equipmentability> getEquipmentability(){
        List<EquipmentManufacturingData5> list = equipmentManufacturingData5Service.selectEquipmentManufacturingData5withproblem();
        List<Equipmentability> list_ability = new ArrayList<>();
        SimpleDateFormat sdfTarget = new SimpleDateFormat("yyyy-MM-dd");
        for(EquipmentManufacturingData5 e : list){
            int mark=0;
            for(Equipmentability b : list_ability){
                if(e.getPlaneType().equals(b.getPlaneType())&&e.getDevCode().equals(b.getDevCode())){
                    b.add(sdfTarget.format(e.getProductionUpgradeTime()));
                    mark=-1;
                }
            }
            if(mark==0){
                Equipmentability obj = new Equipmentability();
                obj.setPlaneType(e.getPlaneType());
                obj.setDevCode(e.getDevCode());
                obj.add(sdfTarget.format(e.getProductionUpgradeTime()));
                list_ability.add(obj);
            }
        }
        for(Equipmentability e : list_ability){
            Collections.sort(e.getList());
        }
        return list_ability;
    }

    //4.2.2.2对比图数据处理
    @GetMapping("/getEquipmentabilitycompare")
    public List<EquipmentAbilitycount> countAbility(QualityProblem qualityProblem){
       List<EquipmentManufacturingData5> list =equipmentManufacturingData5Service.selectEquipmentManufacturingData5withproblem();
       List<QualityProblem> listpro = qualityProblemService.selectQualityProblemList(qualityProblem);
        List<EquipmentAbilitycount> listequ = new ArrayList<>();
       for(EquipmentManufacturingData5 e : list){
           int mark=0;
            for(EquipmentAbilitycount equ : listequ){
                if(e.getPlaneType().equals(equ.getPlaneType())&&e.getDevCode().equals(equ.getDevCode())){
                    addImprovetime(e, equ);
                    mark=-1;
                }
            }
            if(mark==0){
                EquipmentAbilitycount count = new EquipmentAbilitycount();
                count.setDevCode(e.getDevCode());
                count.setPlaneType(e.getPlaneType());
                addImprovetime(e, count);
                listequ.add(count);
            }
       }
       for(QualityProblem e : listpro){
            for(EquipmentAbilitycount equ : listequ){
                if(e.getPlaneType().equals(equ.getPlaneType())&&e.getDevCode().equals(equ.getDevCode())){
                    if(e.getDevHappenTime().compareTo(equ.getFirst())<0)
                        equ.setOne(equ.getOne()+1);
                    else if(e.getDevHappenTime().compareTo(equ.getFirst())>0&&e.getDevHappenTime().compareTo(equ.getSecond())<0)
                        equ.setTwo(equ.getTwo()+1);
                    else if(e.getDevHappenTime().compareTo(equ.getSecond())>0&&e.getDevHappenTime().compareTo(equ.getThird())<0)
                        equ.setThree(equ.getThree()+1);
                    else if(e.getDevHappenTime().compareTo(equ.getThird())>0&&e.getDevHappenTime().compareTo(equ.getFourth())<0)
                        equ.setFour(equ.getFour()+1);
                }
            }
       }
       return listequ;
    }

    //4.2.2.2对比图用添加能力提升时间节点
    private void addImprovetime(EquipmentManufacturingData5 e, EquipmentAbilitycount equ) {
        switch (e.getCapabilityStatus()){
            case "2.0" :
                equ.setFirst(e.getProductionUpgradeTime());
                break;
            case "3.0" :
                equ.setSecond(e.getProductionUpgradeTime());
                break;
            case "4.0" :
                equ.setThird(e.getProductionUpgradeTime());
                break;
         /*   case "4.0" :
                equ.setFourth(e.getProductionUpgradeTime());
                break;*/
        }
    }

    //4.2.2.2对比图用内部实体类
    static class EquipmentAbilitycount{
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        private String devCode;
        private String planeType;
        private int one = 0;
        private int two = 0;
        private int three = 0;
        private int four = 0;
        private Date first;

        {
            try {
                first = dateformat.parse("2099-12-30");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        private Date second = null;
        {
            try {
                second = dateformat.parse("2099-12-30");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        private Date third = null;
        {
            try {
                third = dateformat.parse("2099-12-30");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        private Date fourth = null;
        {
            try {
                fourth = dateformat.parse("2099-12-30");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        public String getPlaneType() {
            return planeType;
        }

        public void setPlaneType(String planeType) {
            this.planeType = planeType;
        }

        public String getDevCode() {
            return devCode;
        }

        public void setDevCode(String devCode) {
            this.devCode = devCode;
        }

        public Date getFirst() {
            return first;
        }

        public void setFirst(Date first) {
            this.first = first;
        }

        public Date getSecond() {
            return second;
        }

        public void setSecond(Date second) {
            this.second = second;
        }

        public Date getThird() {
            return third;
        }

        public void setThird(Date third) {
            this.third = third;
        }

        public Date getFourth() {
            return fourth;
        }

        public void setFourth(Date fourth) {
            this.fourth = fourth;
        }


        public int getOne() {
            return one;
        }

        public void setOne(int one) {
            this.one = one;
        }

        public int getTwo() {
            return two;
        }

        public void setTwo(int two) {
            this.two = two;
        }

        public int getThree() {
            return three;
        }

        public void setThree(int three) {
            this.three = three;
        }

        public int getFour() {
            return four;
        }

        public void setFour(int four) {
            this.four = four;
        }
    }

//4.2.2.2折线图用内部实体类
    static class Equipmentability  { //extends EquipmentManufacturingData5


    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    private String planeType;


    private String devCode;

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        public void add(String date){
            list.add(date);
        }

        private List<String> list=new ArrayList<>();

    }
}
