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
import com.ruoyi.project.system.domain.EquipmentUsageData9;
import com.ruoyi.project.system.service.IEquipmentUsageData9Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 9：装备使用数据Controller
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
@RestController
@RequestMapping("/system/9")
public class EquipmentUsageData9Controller extends BaseController
{
    @Autowired
    private IEquipmentUsageData9Service equipmentUsageData9Service;

    /**
     * 查询9：装备使用数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:9:list')")
    @GetMapping("/list")
    public TableDataInfo list(EquipmentUsageData9 equipmentUsageData9)
    {
        startPage();
        List<EquipmentUsageData9> list = equipmentUsageData9Service.selectEquipmentUsageData9List(equipmentUsageData9);
        return getDataTable(list);
    }

    /**
     * 导出9：装备使用数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:9:export')")
    @Log(title = "9：装备使用数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EquipmentUsageData9 equipmentUsageData9)
    {
        List<EquipmentUsageData9> list = equipmentUsageData9Service.selectEquipmentUsageData9List(equipmentUsageData9);
        ExcelUtil<EquipmentUsageData9> util = new ExcelUtil<EquipmentUsageData9>(EquipmentUsageData9.class);
        util.exportExcel(response, list, "9：装备使用数据数据");
    }

    /**
     * 获取9：装备使用数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:9:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(equipmentUsageData9Service.selectEquipmentUsageData9ById(id));
    }

    /**
     * 新增9：装备使用数据
     */
    @PreAuthorize("@ss.hasPermi('system:9:add')")
    @Log(title = "9：装备使用数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipmentUsageData9 equipmentUsageData9)
    {
        return toAjax(equipmentUsageData9Service.insertEquipmentUsageData9(equipmentUsageData9));
    }

    /**
     * 修改9：装备使用数据
     */
    @PreAuthorize("@ss.hasPermi('system:9:edit')")
    @Log(title = "9：装备使用数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipmentUsageData9 equipmentUsageData9)
    {
        return toAjax(equipmentUsageData9Service.updateEquipmentUsageData9(equipmentUsageData9));
    }

    /**
     * 删除9：装备使用数据
     */
    @PreAuthorize("@ss.hasPermi('system:9:remove')")
    @Log(title = "9：装备使用数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipmentUsageData9Service.deleteEquipmentUsageData9ByIds(ids));
    }
}
