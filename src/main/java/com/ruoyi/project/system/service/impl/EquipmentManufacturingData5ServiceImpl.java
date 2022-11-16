package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipmentManufacturingData5Mapper;
import com.ruoyi.project.system.domain.EquipmentManufacturingData5;
import com.ruoyi.project.system.service.IEquipmentManufacturingData5Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-16
 */
@Service
public class EquipmentManufacturingData5ServiceImpl implements IEquipmentManufacturingData5Service 
{
    @Autowired
    private EquipmentManufacturingData5Mapper equipmentManufacturingData5Mapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public EquipmentManufacturingData5 selectEquipmentManufacturingData5ById(Long id)
    {
        return equipmentManufacturingData5Mapper.selectEquipmentManufacturingData5ById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param equipmentManufacturingData5 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<EquipmentManufacturingData5> selectEquipmentManufacturingData5List(EquipmentManufacturingData5 equipmentManufacturingData5)
    {
        return equipmentManufacturingData5Mapper.selectEquipmentManufacturingData5List(equipmentManufacturingData5);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param equipmentManufacturingData5 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertEquipmentManufacturingData5(EquipmentManufacturingData5 equipmentManufacturingData5)
    {
        return equipmentManufacturingData5Mapper.insertEquipmentManufacturingData5(equipmentManufacturingData5);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param equipmentManufacturingData5 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateEquipmentManufacturingData5(EquipmentManufacturingData5 equipmentManufacturingData5)
    {
        return equipmentManufacturingData5Mapper.updateEquipmentManufacturingData5(equipmentManufacturingData5);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentManufacturingData5ByIds(Long[] ids)
    {
        return equipmentManufacturingData5Mapper.deleteEquipmentManufacturingData5ByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentManufacturingData5ById(Long id)
    {
        return equipmentManufacturingData5Mapper.deleteEquipmentManufacturingData5ById(id);
    }
}
