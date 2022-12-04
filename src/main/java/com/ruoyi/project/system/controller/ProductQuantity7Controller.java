package com.ruoyi.project.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.project.system.domain.EquipmentDesignData;
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
import com.ruoyi.project.system.domain.ProductQuantity7;
import com.ruoyi.project.system.service.IProductQuantity7Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 7：产品生产数量Controller
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
@RestController
@RequestMapping("/system/7")
public class ProductQuantity7Controller extends BaseController
{
    @Autowired
    private IProductQuantity7Service productQuantity7Service;

    /**
     * 查询7：产品生产数量列表
     */
    @PreAuthorize("@ss.hasPermi('system:7:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductQuantity7 productQuantity7)
    {
        startPage();
        List<ProductQuantity7> list = productQuantity7Service.selectProductQuantity7List(productQuantity7);
        return getDataTable(list);
    }

    /**
     * 导出7：产品生产数量列表
     */
    @PreAuthorize("@ss.hasPermi('system:7:export')")
    @Log(title = "7：产品生产数量", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductQuantity7 productQuantity7)
    {
        List<ProductQuantity7> list = productQuantity7Service.selectProductQuantity7List(productQuantity7);
        ExcelUtil<ProductQuantity7> util = new ExcelUtil<ProductQuantity7>(ProductQuantity7.class);
        util.exportExcel(response, list, "7：产品生产数量数据");
    }

    /**
     * 获取7：产品生产数量详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:7:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(productQuantity7Service.selectProductQuantity7ById(id));
    }

    /**
     * 新增7：产品生产数量
     */
    @PreAuthorize("@ss.hasPermi('system:7:add')")
    @Log(title = "7：产品生产数量", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductQuantity7 productQuantity7)
    {
        return toAjax(productQuantity7Service.insertProductQuantity7(productQuantity7));
    }

    /**
     * 修改7：产品生产数量
     */
    @PreAuthorize("@ss.hasPermi('system:7:edit')")
    @Log(title = "7：产品生产数量", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductQuantity7 productQuantity7)
    {
        return toAjax(productQuantity7Service.updateProductQuantity7(productQuantity7));
    }

    /**
     * 删除7：产品生产数量
     */
    @PreAuthorize("@ss.hasPermi('system:7:remove')")
    @Log(title = "7：产品生产数量", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productQuantity7Service.deleteProductQuantity7ByIds(ids));
    }
}
