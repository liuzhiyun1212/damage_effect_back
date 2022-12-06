package com.ruoyi.project.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.project.system.domain.EquipmentDeploymentData11;
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
import com.ruoyi.project.system.domain.EquipmentUseData12;
import com.ruoyi.project.system.service.IEquipmentUseData12Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 12：装备使用数据Controller
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
@RestController
@RequestMapping("/system/12")
public class EquipmentUseData12Controller extends BaseController
{
    @Autowired
    private IEquipmentUseData12Service equipmentUseData12Service;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:12:list')")
    @GetMapping("/list")
    public TableDataInfo list(EquipmentUseData12 equipmentUseData12)
    {
        startPage();
        List<EquipmentUseData12> list = equipmentUseData12Service.selectEquipmentUseData12List(equipmentUseData12);
        return getDataTable(list);
    }

    /**
     * 查询所有数据 wdh
     */
    @GetMapping("/listAll")
    public TableDataInfo listAll(EquipmentUseData12 equipmentUseData12)
    {
        List<EquipmentUseData12> list = equipmentUseData12Service.selectEquipmentUseData12List(equipmentUseData12);
        return getDataTable(list);
    }

    /**
     * 导出【装备使用数据】列表
     */
    @PreAuthorize("@ss.hasPermi('system:12:export')")
    @Log(title = "12：装备使用数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EquipmentUseData12 equipmentUseData12)
    {
        List<EquipmentUseData12> list = equipmentUseData12Service.selectEquipmentUseData12List(equipmentUseData12);
        ExcelUtil<EquipmentUseData12> util = new ExcelUtil<EquipmentUseData12>(EquipmentUseData12.class);
        util.exportExcel(response, list, "12：装备使用数据");
    }

    /**
     * 获取12：装备使用数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:12:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(equipmentUseData12Service.selectEquipmentUseData12ById(id));
    }

    /**
     * 新增12：装备使用数据
     */
    @PreAuthorize("@ss.hasPermi('system:12:add')")
    @Log(title = "12：装备使用数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipmentUseData12 equipmentUseData12)
    {
        return toAjax(equipmentUseData12Service.insertEquipmentUseData12(equipmentUseData12));
    }

    /**
     * 修改12：装备使用数据
     */
    @PreAuthorize("@ss.hasPermi('system:12:edit')")
    @Log(title = "12：装备使用数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipmentUseData12 equipmentUseData12)
    {
        return toAjax(equipmentUseData12Service.updateEquipmentUseData12(equipmentUseData12));
    }

    /**
     * 删除12：装备使用数据
     */
    @PreAuthorize("@ss.hasPermi('system:12:remove')")
    @Log(title = "12：装备使用数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipmentUseData12Service.deleteEquipmentUseData12ByIds(ids));
    }
    /**
     * 导入产品改型列表
     */
    @Log(title = "装备使用", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<EquipmentUseData12> util = new ExcelUtil<EquipmentUseData12>(EquipmentUseData12.class);
        List<EquipmentUseData12> importDataList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = equipmentUseData12Service.importData(importDataList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    /**
     * @Description 下载导入装备使用数据模板
     * @Author 李芳伯
     * @Date  2022/11/13
     * @Param [response]
     * @Return void
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<EquipmentUseData12> util = new ExcelUtil<EquipmentUseData12>(EquipmentUseData12.class);
        util.importTemplateExcel(response, "装备使用数据");
    }
}
