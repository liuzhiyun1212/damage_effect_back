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
import com.ruoyi.project.system.domain.ProductModifyData;
import com.ruoyi.project.system.service.IProductModifyDataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 产品制造变更数据Controller
 *
 * @author ruoyi
 * @date 2022-11-11
 */
@RestController
@RequestMapping("/system/modifyData")
public class ProductModifyDataController extends BaseController
{
    @Autowired
    private IProductModifyDataService productModifyDataService;

    /**
     * 查询产品制造变更数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:modifyData:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductModifyData productModifyData)
    {
        startPage();
        List<ProductModifyData> list = productModifyDataService.selectProductModifyDataList(productModifyData);
        return getDataTable(list);
    }

    /**
     * 导出产品制造变更数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:modifyData:export')")
    @Log(title = "产品制造变更数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductModifyData productModifyData)
    {
        List<ProductModifyData> list = productModifyDataService.selectProductModifyDataList(productModifyData);
        ExcelUtil<ProductModifyData> util = new ExcelUtil<ProductModifyData>(ProductModifyData.class);
        util.exportExcel(response, list, "产品制造变更数据数据");
    }

    /**
     * 获取产品制造变更数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:modifyData:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(productModifyDataService.selectProductModifyDataById(id));
    }

    /**
     * 新增产品制造变更数据
     */
    @PreAuthorize("@ss.hasPermi('system:modifyData:add')")
    @Log(title = "产品制造变更数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductModifyData productModifyData)
    {
        return toAjax(productModifyDataService.insertProductModifyData(productModifyData));
    }

    /**
     * 修改产品制造变更数据
     */
    @PreAuthorize("@ss.hasPermi('system:modifyData:edit')")
    @Log(title = "产品制造变更数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductModifyData productModifyData)
    {
        return toAjax(productModifyDataService.updateProductModifyData(productModifyData));
    }

    /**
     * 删除产品制造变更数据
     */
    @PreAuthorize("@ss.hasPermi('system:modifyData:remove')")
    @Log(title = "产品制造变更数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productModifyDataService.deleteProductModifyDataByIds(ids));
    }

    /**
     * 导入产品制造变更列表
     */
    @Log(title = "产品制造变更", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ProductModifyData> util = new ExcelUtil<ProductModifyData>(ProductModifyData.class);
        List<ProductModifyData> importDataList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = productModifyDataService.importData(importDataList, updateSupport, operName);
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
        ExcelUtil<ProductModifyData> util = new ExcelUtil<ProductModifyData>(ProductModifyData.class);
        util.importTemplateExcel(response, "产品制造变更数据");
    }
}
