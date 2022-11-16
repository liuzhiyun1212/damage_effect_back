package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.QualityProblem1;

/**
 * 质量问题数据Service接口
 * 
 * @author ruoyi
 * @date 2022-11-13
 */
public interface IQualityProblem1Service 
{
    /**
     * 查询质量问题数据
     * 
     * @param id 质量问题数据主键
     * @return 质量问题数据
     */
    public QualityProblem1 selectQualityProblem1ById(Long id);

    /**
     * 查询质量问题数据列表
     * 
     * @param qualityProblem1 质量问题数据
     * @return 质量问题数据集合
     */
    public List<QualityProblem1> selectQualityProblem1List(QualityProblem1 qualityProblem1);

    /**
     * 新增质量问题数据
     * 
     * @param qualityProblem1 质量问题数据
     * @return 结果
     */
    public int insertQualityProblem1(QualityProblem1 qualityProblem1);

    /**
     * 修改质量问题数据
     * 
     * @param qualityProblem1 质量问题数据
     * @return 结果
     */
    public int updateQualityProblem1(QualityProblem1 qualityProblem1);

    /**
     * 批量删除质量问题数据
     * 
     * @param ids 需要删除的质量问题数据主键集合
     * @return 结果
     */
    public int deleteQualityProblem1ByIds(Long[] ids);

    /**
     * 删除质量问题数据信息
     * 
     * @param id 质量问题数据主键
     * @return 结果
     */
    public int deleteQualityProblem1ById(Long id);
}
