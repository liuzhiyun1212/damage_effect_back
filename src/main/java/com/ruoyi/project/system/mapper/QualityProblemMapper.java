package com.ruoyi.project.system.mapper;

import com.ruoyi.project.system.domain.FaultyPartsCount;
import com.ruoyi.project.system.domain.QualityProblem;
import com.ruoyi.project.system.domain.Sum;

import java.util.List;

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
     * 质量问题季度发生时间
     *
     * @param
     * @return 统计结果
     */
    public List<Sum> qualityHappenSum(Sum sum);
    /**
     * 质量问题年度发生时间
     *
     * @param
     * @return 统计结果
     */
    public List<Sum> yearHappenSum(Sum sum);
    /**
     * 质量问题涉及到的机型
     *
     * @param
     * @return 统计结果
     */
    public List<Sum> sumByplaneType(Sum sum);

    /**
     * @Description 统计所有故障次数
     * @Author guohuijia
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public int selectAllCount();
    /**
     * @Description 统计不同故障件发生故障次数
     * @Author guohuijia
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<FaultyPartsCount> selectCountByName();
    /**
     * @Description 统计故障件数量
     * @Author guohuijia
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public int selectPartsCount();
}
