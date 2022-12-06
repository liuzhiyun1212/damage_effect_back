package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.FaultyPartsCount;
import com.ruoyi.project.system.domain.ProductModify;
import com.ruoyi.project.system.domain.RepairModifyData10;
import com.ruoyi.project.system.service.IRepairModifyData10Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 10:维修变更数据Controller
 *
 * @author ruoyi
 *  2022-11-25
 */
@RestController
@RequestMapping("/system/10")
public class RepairModifyData10Controller extends BaseController
{
    @Autowired
    private IRepairModifyData10Service repairModifyData10Service;


    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:10:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepairModifyData10 repairModifyData10)
    {
        startPage();
        List<RepairModifyData10> list = repairModifyData10Service.selectRepairModifyData10List(repairModifyData10);
        return getDataTable(list);
    }

    @GetMapping("/repairPeople")
    public List<RepairModifyData10> list()
    {
        List<RepairModifyData10> list = repairModifyData10Service.selectRepairPeople();
        return list;
    }





    /**
     * 导出【10：维修变更数据】列表
     */
    @PreAuthorize("@ss.hasPermi('system:10:export')")
    @Log(title = "【10：维修变更数据】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepairModifyData10 repairModifyData10)
    {
        List<RepairModifyData10> list = repairModifyData10Service.selectRepairModifyData10List(repairModifyData10);
        ExcelUtil<RepairModifyData10> util = new ExcelUtil<RepairModifyData10>(RepairModifyData10.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【10：维修变更数据】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:10:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(repairModifyData10Service.selectRepairModifyData10ById(id));
    }

    /**
     * 新增【10：维修变更数据】
     */
    @PreAuthorize("@ss.hasPermi('system:10:add')")
    @Log(title = "【10：维修变更数据】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepairModifyData10 repairModifyData10)
    {
        return toAjax(repairModifyData10Service.insertRepairModifyData10(repairModifyData10));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:10:edit')")
    @Log(title = "【10：维修变更数据】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepairModifyData10 repairModifyData10)
    {
        return toAjax(repairModifyData10Service.updateRepairModifyData10(repairModifyData10));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:10:remove')")
    @Log(title = "【10：维修变更数据】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(repairModifyData10Service.deleteRepairModifyData10ByIds(ids));
    }
    /**
     * 导入产品改型列表
     */
    @Log(title = "维修变更", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<RepairModifyData10> util = new ExcelUtil<RepairModifyData10>(RepairModifyData10.class);
        List<RepairModifyData10> importDataList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = repairModifyData10Service.importData(importDataList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    /**
     * @Description 下载导入装备部署模板
     * @Author ；lfb
     * @Date  2022/11/13
     * @Param [response]
     * @Return void
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<RepairModifyData10> util = new ExcelUtil<RepairModifyData10>(RepairModifyData10.class);
        util.importTemplateExcel(response, "维修变更数据");
    }

    /**
     * @Description 装备零部件供应商变更时间线
     * @Author guohuijia
     * @Date  2022/12/3
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @PreAuthorize("@ss.hasPermi('system:10:list')")
    @GetMapping("/listRepairWayChange")
    public List<ProductModify> listRepairWayChange()
    {
        List<ProductModify> list = repairModifyData10Service.selectRepairWayChange();
        return list;
    }


    /**
     * @Description 获取高发故障模式涉及到的维修工艺生成故障件数目
     * @Author guohuijia
     * @Date  2022/12/4
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/listFaultyCountByRepairWay")
    public List<FaultyPartsCount> selectFaultyCountByRepairWay(){
        List<FaultyPartsCount> list = repairModifyData10Service.selectFaultyCountByRepairWay();
//        QualityProblemController qualityProblemController = new QualityProblemController();
//        List<FaultyPartsCount> faultyPartsCountList = qualityProblemController.selectFaultyCount();
//        List<String> faultyNameList = new ArrayList<>();
//        for (FaultyPartsCount i : faultyPartsCountList){
//            if(!faultyNameList.contains(i.getPartsModelName())){
//                faultyNameList.add(i.getPartsModelName());
//            }
//        }
//        for(FaultyPartsCount i : list){
//            if (!faultyNameList.contains(i.getPartsModelName())){
//                list.remove(i);
//            }
//        }
        return list;
    }

}
