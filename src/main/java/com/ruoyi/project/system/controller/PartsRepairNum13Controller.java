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
