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
import com.ruoyi.project.system.domain.ProductCreate;
import com.ruoyi.project.system.service.IProductCreateService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 产品制造数据Controller
 *
 * @author ruoyi
 * @date 2022-11-11
 */
@RestController
@RequestMapping("/system/create")
public class ProductCreateController extends BaseController
{
    @Autowired
    private IProductCreateService productCreateService;

    /**
     * 查询产品制造数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:create:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductCreate productCreate)
    {
        startPage();
        List<ProductCreate> list = productCreateService.selectProductCreateList(productCreate);
        return getDataTable(list);
    }

    /**
     * 导出产品制造数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:create:export')")
    @Log(title = "产品制造数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductCreate productCreate)
    {
        List<ProductCreate> list = productCreateService.selectProductCreateList(productCreate);
        ExcelUtil<ProductCreate> util = new ExcelUtil<ProductCreate>(ProductCreate.class);
        util.exportExcel(response, list, "产品制造数据数据");
    }

    /**
     * 获取产品制造数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:create:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(productCreateService.selectProductCreateById(id));
    }

    /**
     * 新增产品制造数据
     */
    @PreAuthorize("@ss.hasPermi('system:create:add')")
    @Log(title = "产品制造数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductCreate productCreate)
    {
        return toAjax(productCreateService.insertProductCreate(productCreate));
    }

    /**
     * 修改产品制造数据
     */
    @PreAuthorize("@ss.hasPermi('system:create:edit')")
    @Log(title = "产品制造数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductCreate productCreate)
    {
        return toAjax(productCreateService.updateProductCreate(productCreate));
    }

    /**
     * 删除产品制造数据
     */
    @PreAuthorize("@ss.hasPermi('system:create:remove')")
    @Log(title = "产品制造数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productCreateService.deleteProductCreateByIds(ids));
    }

    /**
     * 导入产品制造列表
     */
    @Log(title = "产品制造", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ProductCreate> util = new ExcelUtil<ProductCreate>(ProductCreate.class);
        List<ProductCreate> importDataList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = productCreateService.importData(importDataList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    /**
     * @Description 下载导入产品制造模板
     * @Author guohuijia
     * @Date  2022/11/13
     * @Param [response]
     * @Return void
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<ProductCreate> util = new ExcelUtil<ProductCreate>(ProductCreate.class);
        util.importTemplateExcel(response, "产品制造数据");
    }
}
