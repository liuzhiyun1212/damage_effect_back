package com.ruoyi.project.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.security.LoginUser;
import com.ruoyi.project.system.domain.SysUser;
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
import com.ruoyi.project.system.domain.QualityProblem;
import com.ruoyi.project.system.service.IQualityProblemService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * quality_problemController
 *
 * @author ruoyi
 * @date 2022-11-10
 */
@RestController
@RequestMapping("/system/dev")
public class QualityProblemController extends BaseController
{
    @Autowired
    private IQualityProblemService qualityProblemService;

    /**
     * 查询quality_problem列表
     */
    @PreAuthorize("@ss.hasPermi('system:dev:list')")
    @GetMapping("/list")
    public TableDataInfo list(QualityProblem qualityProblem)
    {
        startPage();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        return getDataTable(list);
    }

    @GetMapping("/listAll")
    public TableDataInfo listAll(QualityProblem qualityProblem)
    {
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        return getDataTable(list);
    }


    /**
     * 导出quality_problem列表
     */
    @PreAuthorize("@ss.hasPermi('system:dev:export')")
    @Log(title = "quality_problem", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, QualityProblem qualityProblem)
    {
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        ExcelUtil<QualityProblem> util = new ExcelUtil<QualityProblem>(QualityProblem.class);
        util.exportExcel(response, list, "quality_problem数据");
    }

    /**
     * 获取quality_problem详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:dev:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(qualityProblemService.selectQualityProblemById(id));
    }

    /**
     * 新增quality_problem
     */
    @PreAuthorize("@ss.hasPermi('system:dev:add')")
    @Log(title = "quality_problem", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody QualityProblem qualityProblem)
    {
        return toAjax(qualityProblemService.insertQualityProblem(qualityProblem));
    }

    /**
     * 修改quality_problem
     */
    @PreAuthorize("@ss.hasPermi('system:dev:edit')")
    @Log(title = "quality_problem", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QualityProblem qualityProblem)
    {
        return toAjax(qualityProblemService.updateQualityProblem(qualityProblem));
    }

    /**
     * 删除quality_problem
     */
    @PreAuthorize("@ss.hasPermi('system:dev:remove')")
    @Log(title = "quality_problem", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(qualityProblemService.deleteQualityProblemByIds(ids));
    }
    /**
     * 导入数据管理列表
     */
    @Log(title = "数据管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<QualityProblem> util = new ExcelUtil<QualityProblem>(QualityProblem.class);
        List<QualityProblem> QualityProblemList = util.importExcel(file.getInputStream());
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = getUsername();
        String message = qualityProblemService.importData(QualityProblemList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<QualityProblem> util = new ExcelUtil<QualityProblem>(QualityProblem.class);
        util.importTemplateExcel(response, "质量问题数据");
    }
}
