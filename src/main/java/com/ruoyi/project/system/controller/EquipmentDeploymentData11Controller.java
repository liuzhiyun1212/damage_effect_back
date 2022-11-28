package com.ruoyi.project.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.project.system.domain.ProductQuantity7;
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
import com.ruoyi.project.system.domain.EquipmentDeploymentData11;
import com.ruoyi.project.system.service.IEquipmentDeploymentData11Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 8:装备部署数据Controller
 * 
 * @author ruoyi
 * @date 2022-11-18
 */
@RestController
@RequestMapping("/system/11")
public class EquipmentDeploymentData11Controller extends BaseController
{
    @Autowired
    private IEquipmentDeploymentData11Service equipmentDeploymentData11Service;

    /**
     * 查询8:装备部署数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:11:list')")
    @GetMapping("/list")
    public TableDataInfo list(EquipmentDeploymentData11 equipmentDeploymentData11)
    {
        startPage();
        List<EquipmentDeploymentData11> list = equipmentDeploymentData11Service.selectEquipmentDeploymentData11List(equipmentDeploymentData11);
        return getDataTable(list);
    }

    /**
     * 导出8:装备部署数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:11:export')")
    @Log(title = "8:装备部署数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EquipmentDeploymentData11 equipmentDeploymentData11)
    {
        List<EquipmentDeploymentData11> list = equipmentDeploymentData11Service.selectEquipmentDeploymentData11List(equipmentDeploymentData11);
        ExcelUtil<EquipmentDeploymentData11> util = new ExcelUtil<EquipmentDeploymentData11>(EquipmentDeploymentData11.class);
        util.exportExcel(response, list, "8:装备部署数据数据");
    }

    /**
     * 获取8:装备部署数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:11:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(equipmentDeploymentData11Service.selectEquipmentDeploymentData11ById(id));
    }

    /**
     * 新增8:装备部署数据
     */
    @PreAuthorize("@ss.hasPermi('system:11:add')")
    @Log(title = "8:装备部署数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipmentDeploymentData11 equipmentDeploymentData11)
    {
        return toAjax(equipmentDeploymentData11Service.insertEquipmentDeploymentData11(equipmentDeploymentData11));
    }

    /**
     * 修改8:装备部署数据
     */
    @PreAuthorize("@ss.hasPermi('system:11:edit')")
    @Log(title = "8:装备部署数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipmentDeploymentData11 equipmentDeploymentData11)
    {
        return toAjax(equipmentDeploymentData11Service.updateEquipmentDeploymentData11(equipmentDeploymentData11));
    }

    /**
     * 删除8:装备部署数据
     */
    @PreAuthorize("@ss.hasPermi('system:11:remove')")
    @Log(title = "8:装备部署数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipmentDeploymentData11Service.deleteEquipmentDeploymentData11ByIds(ids));
    }
    /**
     * 导入产品改型列表
     */
    @Log(title = "装备部署", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<EquipmentDeploymentData11> util = new ExcelUtil<EquipmentDeploymentData11>(EquipmentDeploymentData11.class);
        List<EquipmentDeploymentData11> importDataList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = equipmentDeploymentData11Service.importData(importDataList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    /**
     * @Description 下载导入装备部署模板
     * @Author guohuijia
     * @Date  2022/11/13
     * @Param [response]
     * @Return void
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<EquipmentDeploymentData11> util = new ExcelUtil<EquipmentDeploymentData11>(EquipmentDeploymentData11.class);
        util.importTemplateExcel(response, "装备部署数据");
    }
}
