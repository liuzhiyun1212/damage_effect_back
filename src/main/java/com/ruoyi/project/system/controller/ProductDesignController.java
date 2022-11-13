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
import com.ruoyi.project.system.domain.ProductDesign;
import com.ruoyi.project.system.service.IProductDesignService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 成品件设计数据Controller
 *
 * @author ruoyi
 * @date 2022-11-11
 */
@RestController
@RequestMapping("/system/design")
public class ProductDesignController extends BaseController
{
    @Autowired
    private IProductDesignService productDesignService;

    /**
     * 查询成品件设计数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:design:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductDesign productDesign)
    {
        startPage();
        List<ProductDesign> list = productDesignService.selectProductDesignList(productDesign);
        return getDataTable(list);
    }

    /**
     * 导出成品件设计数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:design:export')")
    @Log(title = "成品件设计数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductDesign productDesign)
    {
        List<ProductDesign> list = productDesignService.selectProductDesignList(productDesign);
        ExcelUtil<ProductDesign> util = new ExcelUtil<ProductDesign>(ProductDesign.class);
        util.exportExcel(response, list, "成品件设计数据数据");
    }

    /**
     * 获取成品件设计数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:design:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(productDesignService.selectProductDesignById(id));
    }

    /**
     * 新增成品件设计数据
     */
    @PreAuthorize("@ss.hasPermi('system:design:add')")
    @Log(title = "成品件设计数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductDesign productDesign)
    {
        return toAjax(productDesignService.insertProductDesign(productDesign));
    }

    /**
     * 修改成品件设计数据
     */
    @PreAuthorize("@ss.hasPermi('system:design:edit')")
    @Log(title = "成品件设计数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductDesign productDesign)
    {
        return toAjax(productDesignService.updateProductDesign(productDesign));
    }

    /**
     * 删除成品件设计数据
     */
    @PreAuthorize("@ss.hasPermi('system:design:remove')")
    @Log(title = "成品件设计数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productDesignService.deleteProductDesignByIds(ids));
    }

    /**
     * 导入产品设计列表
     */
    @Log(title = "产品设计", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ProductDesign> util = new ExcelUtil<ProductDesign>(ProductDesign.class);
        List<ProductDesign> importDataList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = productDesignService.importData(importDataList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    /**
     * @Description 下载导入产品设计模板
     * @Author guohuijia
     * @Date  2022/11/13
     * @Param [response]
     * @Return void
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<ProductDesign> util = new ExcelUtil<ProductDesign>(ProductDesign.class);
        util.importTemplateExcel(response, "产品设计数据");
    }
}
