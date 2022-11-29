package com.ruoyi.project.system.mapper;

import com.ruoyi.project.system.domain.FaultyPartsCount;
import com.ruoyi.project.system.domain.PartsTypeCount;
import com.ruoyi.project.system.domain.QualityProblem;
import com.ruoyi.project.system.domain.Sum;
import com.ruoyi.project.system.domain.*;

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
    public int selectPartsTypeCount();

    public List<PartsTypeCount> selectCountByType();
    /**4.2.2.3
     * @Description 高发故障模式涉及到的故障件的生产班组
     * @Author lixin
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<GradeCount> selectByGradeFaultModel();
    /**4.2.2.3
     * @Description 生产班组统计质量问题总数
     * @Author lixin
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<Sum> qualitySumByGrade();
    /**4.2.2.3
     * @Description 生产班组统计产品总数
     * @Author lixin
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<Sum> productSumByGrade();
    /**4.2.2.3
     * @Description 故障件生产班组变更
     * @Author lixin
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<ProductModifyData> selectByGradeChanged();

    /**
     * 4.2.2.6.故障件生产设备变更情况
     * @return
     */
    public List<ProductModifyData> selectByProduceDeviceChanged();

    /**4.2.2.16
     * @Description 不同使用环境中装备数量
     * @Author lixin
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<Sum> selectDevByEnvironment();
    /**4.2.2.16
     * @Description 不同使用环境中对应质量问题数
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<Sum> selectQualityByEnvironment();
    /**4.2.2.16
     * @Description (根据dev_use_time)不同状态装备的故障件数量
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<Sum> selectTroubleByState1();
    public List<Sum> selectTroubleByState2();
    /**4.2.2.16
     * @Description (根据dev_repaired)不同状态装备的质量问题数量
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<Sum> selectQualityByState1();
    public List<Sum> selectQualityByState2();

    /**4.2.2.16
     * @Description  (根据dev_use_time)不同状态故障模式
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<DevState> selectState1();
//    (根据dev_repaired)不同状态故障模式
    public List<DevState> selectState2();
    /**4.2.1.6
     * @Description  质量问题故障模式随时间变化情况
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<Sum> faultModelByQuarter();
    public List<Sum> faultModelByYear();
    /**4.2.1.6
     * @Description      4.2.1.7质量问题发生地理环境
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<Sum> sumByEnvironment();
    /**4.2.1.10
     * @Description      4.2.1.10故障件名称随时间变化情况
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<Sum> nameAndModelByYear();
    public List<Sum> nameAndModelByQuarter();


}
