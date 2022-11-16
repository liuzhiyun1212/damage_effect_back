package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.QualityProblem1Mapper;
import com.ruoyi.project.system.domain.QualityProblem1;
import com.ruoyi.project.system.service.IQualityProblem1Service;

/**
 * 质量问题数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-13
 */
@Service
public class QualityProblem1ServiceImpl implements IQualityProblem1Service 
{
    @Autowired
    private QualityProblem1Mapper qualityProblem1Mapper;

    /**
     * 查询质量问题数据
     * 
     * @param id 质量问题数据主键
     * @return 质量问题数据
     */
    @Override
    public QualityProblem1 selectQualityProblem1ById(Long id)
    {
        return qualityProblem1Mapper.selectQualityProblem1ById(id);
    }

    /**
     * 查询质量问题数据列表
     * 
     * @param qualityProblem1 质量问题数据
     * @return 质量问题数据
     */
    @Override
    public List<QualityProblem1> selectQualityProblem1List(QualityProblem1 qualityProblem1)
    {
        return qualityProblem1Mapper.selectQualityProblem1List(qualityProblem1);
    }

    /**
     * 新增质量问题数据
     * 
     * @param qualityProblem1 质量问题数据
     * @return 结果
     */
    @Override
    public int insertQualityProblem1(QualityProblem1 qualityProblem1)
    {
        return qualityProblem1Mapper.insertQualityProblem1(qualityProblem1);
    }

    /**
     * 修改质量问题数据
     * 
     * @param qualityProblem1 质量问题数据
     * @return 结果
     */
    @Override
    public int updateQualityProblem1(QualityProblem1 qualityProblem1)
    {
        return qualityProblem1Mapper.updateQualityProblem1(qualityProblem1);
    }

    /**
     * 批量删除质量问题数据
     * 
     * @param ids 需要删除的质量问题数据主键
     * @return 结果
     */
    @Override
    public int deleteQualityProblem1ByIds(Long[] ids)
    {
        return qualityProblem1Mapper.deleteQualityProblem1ByIds(ids);
    }

    /**
     * 删除质量问题数据信息
     * 
     * @param id 质量问题数据主键
     * @return 结果
     */
    @Override
    public int deleteQualityProblem1ById(Long id)
    {
        return qualityProblem1Mapper.deleteQualityProblem1ById(id);
    }
}
