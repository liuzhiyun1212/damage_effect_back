package com.ruoyi.project.system.service;

import com.ruoyi.project.system.domain.*;

import java.util.List;

/**
 * quality_problemService接口
 *
 * @author ruoyi
 * @date 2022-11-10
 */
public interface IQualityProblemService
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
     * 批量删除quality_problem
     *
     * @param ids 需要删除的quality_problem主键集合
     * @return 结果
     */
    public int deleteQualityProblemByIds(Long[] ids);

    /**
     * 删除quality_problem信息
     *
     * @param id quality_problem主键
     * @return 结果
     */
    public int deleteQualityProblemById(Long id);

    /**
     * 导入用户数据
     *
     * @param dataManagementList 数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importData(List<QualityProblem> dataManagementList, Boolean isUpdateSupport, String operName);

    /**
     * 季度质量问题发生时间
     *
     * @param
     * @return 统计结果
     */
    public List<Sum> qualityHappenSum(Sum sum);

    /**
     * 年度质量问题发生时间
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
    /**4.2.2.3
     * @Description 高发故障模式涉及到的故障件的生产班组
     * @Author guohuijia
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<GradeCount> selectByGradeFaultModel();
    /**4.2.2.3
     * @Description 生产班组统计质量问题总数
     * @Author guohuijia
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<Sum> qualitySumByGrade();
    /**4.2.2.3
     * @Description 生产班组统计产品总数
     * @Author guohuijia
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<Sum> productSumByGrade();
    /**4.2.2.3
     * @Description 故障件生产班组变更
     * @Author guohuijia
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<ProductModifyData> selectByGradeChanged();
}
