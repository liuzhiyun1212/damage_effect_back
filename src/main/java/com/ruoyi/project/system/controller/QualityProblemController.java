package com.ruoyi.project.system.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.framework.web.domain.server.Sys;
import com.ruoyi.project.system.domain.Sum;
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
     * 质量问题发生时间
     *
     * @param
     * @return 统计结果
     */
    @GetMapping("/qualityHappenSum")
    public List<Sum> qualityHappenSum(Sum sum) {
        List<Sum> list = qualityProblemService.qualityHappenSum(sum);
        System.out.println("aaaaaaa" + list);
        return list;
    }



    public List<Sum> oneQuality(List<Sum> list){
        List<Sum> list1=new ArrayList<>();
        for(int i=1;i<list.size();i++){
            if(list.get(i).getSum()<list.get(i-1).getSum()/2||list.get(i).getSum()>list.get(i-1).getSum()*1.5){
                list1.add(list.get(i));
            }
        }
        return list1;
    }
    public List<Sum> twoTime(List<Sum> list){
        List<Sum> list2=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if((list.get(i).getSum()*1.2<list.get(i+1).getSum() && list.get(i+1).getSum()*1.2<list.get(i+2).getSum()) ||
                    (list.get(i).getSum()*0.8>list.get(i+1).getSum() && list.get(i+1).getSum()*0.8>list.get(i+2).getSum())){
                list2.add(list.get(i));
            }
        }
        return list2;
    }
    public List<Sum> ThreeTime(List<Sum> list){
        return null;
    }
}
