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
import com.ruoyi.project.system.domain.ProductModify;
import com.ruoyi.project.system.service.IProductModifyService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 产品改型数据Controller
 *
 * @author ruoyi
 * @date 2022-11-11
 */
@RestController
@RequestMapping("/system/modify")
public class ProductModifyController extends BaseController
{
    @Autowired
    private IProductModifyService productModifyService;

    /**
     * 查询产品改型数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:modify:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductModify productModify)
    {
        startPage();
        List<ProductModify> list = productModifyService.selectProductModifyList(productModify);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('system:modify:list')")
    @GetMapping("/listProductChange")
    public List<ProductModify> listProductChange()
    {
        List<ProductModify> list = productModifyService.selectProductchange();
        return list;
    }






    /**
     * 导出产品改型数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:modify:export')")
    @Log(title = "产品改型数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductModify productModify)
    {
        List<ProductModify> list = productModifyService.selectProductModifyList(productModify);
        ExcelUtil<ProductModify> util = new ExcelUtil<ProductModify>(ProductModify.class);
        util.exportExcel(response, list, "产品改型数据数据");
    }

    /**
     * 获取产品改型数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:modify:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(productModifyService.selectProductModifyById(id));
    }

    /**
     * 新增产品改型数据
     */
    @PreAuthorize("@ss.hasPermi('system:modify:add')")
    @Log(title = "产品改型数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductModify productModify)
    {
        return toAjax(productModifyService.insertProductModify(productModify));
    }

    /**
     * 修改产品改型数据
     */
    @PreAuthorize("@ss.hasPermi('system:modify:edit')")
    @Log(title = "产品改型数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductModify productModify)
    {
        return toAjax(productModifyService.updateProductModify(productModify));
    }

    /**
     * 删除产品改型数据
     */
    @PreAuthorize("@ss.hasPermi('system:modify:remove')")
    @Log(title = "产品改型数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productModifyService.deleteProductModifyByIds(ids));
    }

    /**
     * 导入产品改型列表
     */
    @Log(title = "产品改型", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ProductModify> util = new ExcelUtil<ProductModify>(ProductModify.class);
        List<ProductModify> importDataList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = productModifyService.importData(importDataList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    /**
     * @Description 下载导入产品改型模板
     * @Author guohuijia
     * @Date  2022/11/13
     * @Param [response]
     * @Return void
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<ProductModify> util = new ExcelUtil<ProductModify>(ProductModify.class);
        util.importTemplateExcel(response, "产品改型数据");
    }
}
