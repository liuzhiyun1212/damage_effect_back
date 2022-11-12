package com.ruoyi.project.system.service.impl;

import java.util.List;

import com.ruoyi.project.system.domain.Sum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.QualityProblemMapper;
import com.ruoyi.project.system.domain.QualityProblem;
import com.ruoyi.project.system.service.IQualityProblemService;

/**
 * quality_problemService业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
@Service
public class QualityProblemServiceImpl implements IQualityProblemService 
{
    @Autowired
    private QualityProblemMapper qualityProblemMapper;

    /**
     * 查询quality_problem
     * 
     * @param id quality_problem主键
     * @return quality_problem
     */
    @Override
    public QualityProblem selectQualityProblemById(Long id)
    {
        return qualityProblemMapper.selectQualityProblemById(id);
    }

    /**
     * 查询quality_problem列表
     * 
     * @param qualityProblem quality_problem
     * @return quality_problem
     */
    @Override
    public List<QualityProblem> selectQualityProblemList(QualityProblem qualityProblem)
    {
        return qualityProblemMapper.selectQualityProblemList(qualityProblem);
    }

    /**
     * 新增quality_problem
     * 
     * @param qualityProblem quality_problem
     * @return 结果
     */
    @Override
    public int insertQualityProblem(QualityProblem qualityProblem)
    {
        return qualityProblemMapper.insertQualityProblem(qualityProblem);
    }

    /**
     * 修改quality_problem
     * 
     * @param qualityProblem quality_problem
     * @return 结果
     */
    @Override
    public int updateQualityProblem(QualityProblem qualityProblem)
    {
        return qualityProblemMapper.updateQualityProblem(qualityProblem);
    }

    /**
     * 批量删除quality_problem
     * 
     * @param ids 需要删除的quality_problem主键
     * @return 结果
     */
    @Override
    public int deleteQualityProblemByIds(Long[] ids)
    {
        return qualityProblemMapper.deleteQualityProblemByIds(ids);
    }

    /**
     * 删除quality_problem信息
     * 
     * @param id quality_problem主键
     * @return 结果
     */
    @Override
    public int deleteQualityProblemById(Long id)
    {
        return qualityProblemMapper.deleteQualityProblemById(id);
    }
    /**
     * 质量问题发生时间
     *
     * @param
     * @return 统计结果
     */
    @Override
    public List<Sum> qualityHappenSum(Sum sum) {
        return qualityProblemMapper.qualityHappenSum(sum);
    }
    /**
     * 年度质量问题发生时间
     *
     * @param
     * @return 统计结果
     */
    @Override
    public List<Sum> yearHappenSum(Sum sum) {
        return qualityProblemMapper.yearHappenSum(sum);
    }
    /**
     * 质量问题涉及到的机型
     *
     * @param
     * @return 统计结果
     */
    @Override
    public List<Sum> sumByplaneType(Sum sum) {
        return qualityProblemMapper.sumByplaneType(sum);
    }
}
