package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipmentUsageData9Mapper;
import com.ruoyi.project.system.domain.EquipmentUsageData9;
import com.ruoyi.project.system.service.IEquipmentUsageData9Service;

/**
 * 9：装备使用数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
@Service
public class EquipmentUsageData9ServiceImpl implements IEquipmentUsageData9Service 
{
    @Autowired
    private EquipmentUsageData9Mapper equipmentUsageData9Mapper;

    /**
     * 查询9：装备使用数据
     * 
     * @param id 9：装备使用数据主键
     * @return 9：装备使用数据
     */
    @Override
    public EquipmentUsageData9 selectEquipmentUsageData9ById(Long id)
    {
        return equipmentUsageData9Mapper.selectEquipmentUsageData9ById(id);
    }

    /**
     * 查询9：装备使用数据列表
     * 
     * @param equipmentUsageData9 9：装备使用数据
     * @return 9：装备使用数据
     */
    @Override
    public List<EquipmentUsageData9> selectEquipmentUsageData9List(EquipmentUsageData9 equipmentUsageData9)
    {
        return equipmentUsageData9Mapper.selectEquipmentUsageData9List(equipmentUsageData9);
    }

    /**
     * 新增9：装备使用数据
     * 
     * @param equipmentUsageData9 9：装备使用数据
     * @return 结果
     */
    @Override
    public int insertEquipmentUsageData9(EquipmentUsageData9 equipmentUsageData9)
    {
        return equipmentUsageData9Mapper.insertEquipmentUsageData9(equipmentUsageData9);
    }

    /**
     * 修改9：装备使用数据
     * 
     * @param equipmentUsageData9 9：装备使用数据
     * @return 结果
     */
    @Override
    public int updateEquipmentUsageData9(EquipmentUsageData9 equipmentUsageData9)
    {
        return equipmentUsageData9Mapper.updateEquipmentUsageData9(equipmentUsageData9);
    }

    /**
     * 批量删除9：装备使用数据
     * 
     * @param ids 需要删除的9：装备使用数据主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentUsageData9ByIds(Long[] ids)
    {
        return equipmentUsageData9Mapper.deleteEquipmentUsageData9ByIds(ids);
    }

    /**
     * 删除9：装备使用数据信息
     * 
     * @param id 9：装备使用数据主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentUsageData9ById(Long id)
    {
        return equipmentUsageData9Mapper.deleteEquipmentUsageData9ById(id);
    }
}
