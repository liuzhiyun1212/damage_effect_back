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
import com.ruoyi.project.system.domain.EquipmentDeploymentData8;
import com.ruoyi.project.system.service.IEquipmentDeploymentData8Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 8:装备部署数据Controller
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
@RestController
@RequestMapping("/system/8")
public class EquipmentDeploymentData8Controller extends BaseController
{
    @Autowired
    private IEquipmentDeploymentData8Service equipmentDeploymentData8Service;

    /**
     * 查询8:装备部署数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:8:list')")
    @GetMapping("/list")
    public TableDataInfo list(EquipmentDeploymentData8 equipmentDeploymentData8)
    {
        startPage();
        List<EquipmentDeploymentData8> list = equipmentDeploymentData8Service.selectEquipmentDeploymentData8List(equipmentDeploymentData8);
        return getDataTable(list);
    }

    /**
     * 导出8:装备部署数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:8:export')")
    @Log(title = "8:装备部署数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EquipmentDeploymentData8 equipmentDeploymentData8)
    {
        List<EquipmentDeploymentData8> list = equipmentDeploymentData8Service.selectEquipmentDeploymentData8List(equipmentDeploymentData8);
        ExcelUtil<EquipmentDeploymentData8> util = new ExcelUtil<EquipmentDeploymentData8>(EquipmentDeploymentData8.class);
        util.exportExcel(response, list, "8:装备部署数据数据");
    }

    /**
     * 获取8:装备部署数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:8:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(equipmentDeploymentData8Service.selectEquipmentDeploymentData8ById(id));
    }

    /**
     * 新增8:装备部署数据
     */
    @PreAuthorize("@ss.hasPermi('system:8:add')")
    @Log(title = "8:装备部署数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipmentDeploymentData8 equipmentDeploymentData8)
    {
        return toAjax(equipmentDeploymentData8Service.insertEquipmentDeploymentData8(equipmentDeploymentData8));
    }

    /**
     * 修改8:装备部署数据
     */
    @PreAuthorize("@ss.hasPermi('system:8:edit')")
    @Log(title = "8:装备部署数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipmentDeploymentData8 equipmentDeploymentData8)
    {
        return toAjax(equipmentDeploymentData8Service.updateEquipmentDeploymentData8(equipmentDeploymentData8));
    }

    /**
     * 删除8:装备部署数据
     */
    @PreAuthorize("@ss.hasPermi('system:8:remove')")
    @Log(title = "8:装备部署数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipmentDeploymentData8Service.deleteEquipmentDeploymentData8ByIds(ids));
    }
}
