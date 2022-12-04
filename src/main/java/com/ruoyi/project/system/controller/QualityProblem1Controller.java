package com.ruoyi.project.system.controller;

import java.util.*;
import javax.servlet.http.HttpServletResponse;

//import org.junit.Test;
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
import com.ruoyi.project.system.domain.QualityProblem1;
import com.ruoyi.project.system.service.IQualityProblem1Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 质量问题数据Controller
 *
 * @author ruoyi
 * @date 2022-11-13
 */
@RestController
@RequestMapping("/system/qualityProblem1")
public class QualityProblem1Controller extends BaseController
{
    @Autowired
    private IQualityProblem1Service qualityProblem1Service;

    /**
     * 查询质量问题数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:qualityProblem1:list')")
    @GetMapping("/list")
    public TableDataInfo list(QualityProblem1 qualityProblem1)
    {
        startPage();
        List<QualityProblem1> list = qualityProblem1Service.selectQualityProblem1List(qualityProblem1);
        return getDataTable(list);
    }

    /**
     * 故障模式和个数
     */
    static class ModelCount {
        public String getFaultModel() {
            return faultModel;
        }

        public void setFaultModel(String faultModel) {
            this.faultModel = faultModel;
        }

        public int getModelCount() {
            return modelCount;
        }

        public void setModelCount(int modelCount) {
            this.modelCount = modelCount;
        }

        private String faultModel;
        private int modelCount;

        @Override
        public String toString() {
            return "ModelCount{" +
                    "faultModel='" + faultModel + '\'' +
                    ", modelCount=" + modelCount +
                    '}';
        }
//        @Override
//        public String toString() {
//            return "ModelCount{" +
//                    "faultModel='" + faultModel + '\'' +
//                    ", modelCount=" + modelCount +
//                    '}';
//        }
    }


    @GetMapping("/faultStatistics")
    public List<ModelCount> faultStatistics(QualityProblem1 qualityProblem1)
    {
        Set<String> modelName = new HashSet<>();
        List<QualityProblem1> list = qualityProblem1Service.selectQualityProblem1List(qualityProblem1);
        List<ModelCount> listMC = new ArrayList<>();

        int count;
        for(QualityProblem1 q:list){
            modelName.add(q.getFaultModel());
        }

        for (String s:modelName) {
            count = 0;
            ModelCount modelCount = new ModelCount();
            for (QualityProblem1 q : list) {
                if (Objects.equals(s, q.getFaultModel())) {
                    modelCount.setFaultModel(s);
                    count++;
                    modelCount.setModelCount(count);
                }
            }
            listMC.add(modelCount);
        }

        return listMC;
    }





    /**
     * 导出质量问题数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:qualityProblem1:export')")
    @Log(title = "质量问题数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, QualityProblem1 qualityProblem1)
    {
        List<QualityProblem1> list = qualityProblem1Service.selectQualityProblem1List(qualityProblem1);
        ExcelUtil<QualityProblem1> util = new ExcelUtil<QualityProblem1>(QualityProblem1.class);
        util.exportExcel(response, list, "质量问题数据数据");
    }

    /**
     * 获取质量问题数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:qualityProblem1:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(qualityProblem1Service.selectQualityProblem1ById(id));
    }

    /**
     * 新增质量问题数据
     */
    @PreAuthorize("@ss.hasPermi('system:qualityProblem1:add')")
    @Log(title = "质量问题数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody QualityProblem1 qualityProblem1)
    {
        return toAjax(qualityProblem1Service.insertQualityProblem1(qualityProblem1));
    }

    /**
     * 修改质量问题数据
     */
    @PreAuthorize("@ss.hasPermi('system:qualityProblem1:edit')")
    @Log(title = "质量问题数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QualityProblem1 qualityProblem1)
    {
        return toAjax(qualityProblem1Service.updateQualityProblem1(qualityProblem1));
    }

    /**
     * 删除质量问题数据
     */
    @PreAuthorize("@ss.hasPermi('system:qualityProblem1:remove')")
    @Log(title = "质量问题数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(qualityProblem1Service.deleteQualityProblem1ByIds(ids));
    }
}
