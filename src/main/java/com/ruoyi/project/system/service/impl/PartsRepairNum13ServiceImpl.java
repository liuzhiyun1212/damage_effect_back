package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.PartsRepairNum13Mapper;
import com.ruoyi.project.system.domain.PartsRepairNum13;
import com.ruoyi.project.system.service.IPartsRepairNum13Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-12-02
 */
@Service
public class PartsRepairNum13ServiceImpl implements IPartsRepairNum13Service 
{
    @Autowired
    private PartsRepairNum13Mapper partsRepairNum13Mapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public PartsRepairNum13 selectPartsRepairNum13ById(Long id)
    {
        return partsRepairNum13Mapper.selectPartsRepairNum13ById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param partsRepairNum13 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PartsRepairNum13> selectPartsRepairNum13List(PartsRepairNum13 partsRepairNum13)
    {
        return partsRepairNum13Mapper.selectPartsRepairNum13List(partsRepairNum13);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param partsRepairNum13 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPartsRepairNum13(PartsRepairNum13 partsRepairNum13)
    {
        return partsRepairNum13Mapper.insertPartsRepairNum13(partsRepairNum13);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param partsRepairNum13 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePartsRepairNum13(PartsRepairNum13 partsRepairNum13)
    {
        return partsRepairNum13Mapper.updatePartsRepairNum13(partsRepairNum13);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePartsRepairNum13ByIds(Long[] ids)
    {
        return partsRepairNum13Mapper.deletePartsRepairNum13ByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePartsRepairNum13ById(Long id)
    {
        return partsRepairNum13Mapper.deletePartsRepairNum13ById(id);
    }
}
