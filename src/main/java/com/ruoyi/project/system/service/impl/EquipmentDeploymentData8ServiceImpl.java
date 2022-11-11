package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipmentDeploymentData8Mapper;
import com.ruoyi.project.system.domain.EquipmentDeploymentData8;
import com.ruoyi.project.system.service.IEquipmentDeploymentData8Service;

/**
 * 8:装备部署数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
@Service
public class EquipmentDeploymentData8ServiceImpl implements IEquipmentDeploymentData8Service 
{
    @Autowired
    private EquipmentDeploymentData8Mapper equipmentDeploymentData8Mapper;

    /**
     * 查询8:装备部署数据
     * 
     * @param id 8:装备部署数据主键
     * @return 8:装备部署数据
     */
    @Override
    public EquipmentDeploymentData8 selectEquipmentDeploymentData8ById(Long id)
    {
        return equipmentDeploymentData8Mapper.selectEquipmentDeploymentData8ById(id);
    }

    /**
     * 查询8:装备部署数据列表
     * 
     * @param equipmentDeploymentData8 8:装备部署数据
     * @return 8:装备部署数据
     */
    @Override
    public List<EquipmentDeploymentData8> selectEquipmentDeploymentData8List(EquipmentDeploymentData8 equipmentDeploymentData8)
    {
        return equipmentDeploymentData8Mapper.selectEquipmentDeploymentData8List(equipmentDeploymentData8);
    }

    /**
     * 新增8:装备部署数据
     * 
     * @param equipmentDeploymentData8 8:装备部署数据
     * @return 结果
     */
    @Override
    public int insertEquipmentDeploymentData8(EquipmentDeploymentData8 equipmentDeploymentData8)
    {
        return equipmentDeploymentData8Mapper.insertEquipmentDeploymentData8(equipmentDeploymentData8);
    }

    /**
     * 修改8:装备部署数据
     * 
     * @param equipmentDeploymentData8 8:装备部署数据
     * @return 结果
     */
    @Override
    public int updateEquipmentDeploymentData8(EquipmentDeploymentData8 equipmentDeploymentData8)
    {
        return equipmentDeploymentData8Mapper.updateEquipmentDeploymentData8(equipmentDeploymentData8);
    }

    /**
     * 批量删除8:装备部署数据
     * 
     * @param ids 需要删除的8:装备部署数据主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentDeploymentData8ByIds(Long[] ids)
    {
        return equipmentDeploymentData8Mapper.deleteEquipmentDeploymentData8ByIds(ids);
    }

    /**
     * 删除8:装备部署数据信息
     * 
     * @param id 8:装备部署数据主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentDeploymentData8ById(Long id)
    {
        return equipmentDeploymentData8Mapper.deleteEquipmentDeploymentData8ById(id);
    }
}
