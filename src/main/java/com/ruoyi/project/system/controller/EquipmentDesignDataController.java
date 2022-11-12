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
import com.ruoyi.project.system.domain.EquipmentDesignData;
import com.ruoyi.project.system.service.IEquipmentDesignDataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 装备设计/改型数据Controller
 *
 * @author ruoyi
 * @date 2022-11-10
 */
@RestController
@RequestMapping("/system/data")
public class EquipmentDesignDataController extends BaseController {
    @Autowired
    private IEquipmentDesignDataService equipmentDesignDataService;

    /**
     * 查询装备设计/改型数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:data:list')")
    @GetMapping("/list")
    public TableDataInfo list(EquipmentDesignData equipmentDesignData) {
        startPage();
        List<EquipmentDesignData> list = equipmentDesignDataService.selectEquipmentDesignDataList(equipmentDesignData);
        return getDataTable(list);
    }


    @GetMapping("/listall")
    public List<EquipmentDesignData> listall(EquipmentDesignData equipmentDesignData) {
        List<EquipmentDesignData> list = equipmentDesignDataService.selectEquipmentDesignDataList(equipmentDesignData);
        return list;
    }


    /**
     * 导出装备设计/改型数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:data:export')")
    @Log(title = "装备设计/改型数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EquipmentDesignData equipmentDesignData) {
        List<EquipmentDesignData> list = equipmentDesignDataService.selectEquipmentDesignDataList(equipmentDesignData);
        ExcelUtil<EquipmentDesignData> util = new ExcelUtil<EquipmentDesignData>(EquipmentDesignData.class);
        util.exportExcel(response, list, "装备设计/改型数据数据");
    }

    /**
     * 获取装备设计/改型数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:data:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(equipmentDesignDataService.selectEquipmentDesignDataById(id));
    }

    /**
     * 新增装备设计/改型数据
     */
    @PreAuthorize("@ss.hasPermi('system:data:add')")
    @Log(title = "装备设计/改型数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipmentDesignData equipmentDesignData) {
        return toAjax(equipmentDesignDataService.insertEquipmentDesignData(equipmentDesignData));
    }

    /**
     * 修改装备设计/改型数据
     */
    @PreAuthorize("@ss.hasPermi('system:data:edit')")
    @Log(title = "装备设计/改型数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipmentDesignData equipmentDesignData) {
        return toAjax(equipmentDesignDataService.updateEquipmentDesignData(equipmentDesignData));
    }

    /**
     * 删除装备设计/改型数据
     */
    @PreAuthorize("@ss.hasPermi('system:data:remove')")
    @Log(title = "装备设计/改型数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(equipmentDesignDataService.deleteEquipmentDesignDataByIds(ids));
    }
}
