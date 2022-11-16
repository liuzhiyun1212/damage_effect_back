package com.ruoyi.project.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.project.system.domain.EquipmentManufacturingData5;
import com.ruoyi.project.system.service.IEquipmentManufacturingData5Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

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
}
