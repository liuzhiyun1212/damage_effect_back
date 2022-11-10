package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.QualityProblem;
import com.ruoyi.project.system.domain.Sum;

/**
 * quality_problemMapper接口
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
public interface QualityProblemMapper 
{
    /**
     * 查询quality_problem
     * 
     * @param id quality_problem主键
     * @return quality_problem
     */
    public QualityProblem selectQualityProblemById(Long id);

    /**
     * 查询quality_problem列表
     * 
     * @param qualityProblem quality_problem
     * @return quality_problem集合
     */
    public List<QualityProblem> selectQualityProblemList(QualityProblem qualityProblem);

    /**
     * 新增quality_problem
     * 
     * @param qualityProblem quality_problem
     * @return 结果
     */
    public int insertQualityProblem(QualityProblem qualityProblem);

    /**
     * 修改quality_problem
     * 
     * @param qualityProblem quality_problem
     * @return 结果
     */
    public int updateQualityProblem(QualityProblem qualityProblem);

    /**
     * 删除quality_problem
     * 
     * @param id quality_problem主键
     * @return 结果
     */
    public int deleteQualityProblemById(Long id);

    /**
     * 批量删除quality_problem
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQualityProblemByIds(Long[] ids);
    /**
     * 质量问题发生时间
     *
     * @param
     * @return 统计结果
     */
    public List<Sum> qualityHappenSum(Sum sum);
}
