package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.PartsMakeNum9Mapper;
import com.ruoyi.project.system.domain.PartsMakeNum9;
import com.ruoyi.project.system.service.IPartsMakeNum9Service;

/**
 * 9：装备使用数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-18
 */
@Service
public class PartsMakeNum9ServiceImpl implements IPartsMakeNum9Service 
{
    @Autowired
    private PartsMakeNum9Mapper partsMakeNum9Mapper;

    /**
     * 查询9：装备使用数据
     * 
     * @param id 9：装备使用数据主键
     * @return 9：装备使用数据
     */
    @Override
    public PartsMakeNum9 selectPartsMakeNum9ById(Long id)
    {
        return partsMakeNum9Mapper.selectPartsMakeNum9ById(id);
    }

    /**
     * 查询9：装备使用数据列表
     * 
     * @param partsMakeNum9 9：装备使用数据
     * @return 9：装备使用数据
     */
    @Override
    public List<PartsMakeNum9> selectPartsMakeNum9List(PartsMakeNum9 partsMakeNum9)
    {
        return partsMakeNum9Mapper.selectPartsMakeNum9List(partsMakeNum9);
    }

    /**
     * 新增9：装备使用数据
     * 
     * @param partsMakeNum9 9：装备使用数据
     * @return 结果
     */
    @Override
    public int insertPartsMakeNum9(PartsMakeNum9 partsMakeNum9)
    {
        return partsMakeNum9Mapper.insertPartsMakeNum9(partsMakeNum9);
    }

    /**
     * 修改9：装备使用数据
     * 
     * @param partsMakeNum9 9：装备使用数据
     * @return 结果
     */
    @Override
    public int updatePartsMakeNum9(PartsMakeNum9 partsMakeNum9)
    {
        return partsMakeNum9Mapper.updatePartsMakeNum9(partsMakeNum9);
    }

    /**
     * 批量删除9：装备使用数据
     * 
     * @param ids 需要删除的9：装备使用数据主键
     * @return 结果
     */
    @Override
    public int deletePartsMakeNum9ByIds(Long[] ids)
    {
        return partsMakeNum9Mapper.deletePartsMakeNum9ByIds(ids);
    }

    /**
     * 删除9：装备使用数据信息
     * 
     * @param id 9：装备使用数据主键
     * @return 结果
     */
    @Override
    public int deletePartsMakeNum9ById(Long id)
    {
        return partsMakeNum9Mapper.deletePartsMakeNum9ById(id);
    }
}
