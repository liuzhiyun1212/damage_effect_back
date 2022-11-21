package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipmentDeploymentData11Mapper;
import com.ruoyi.project.system.domain.EquipmentDeploymentData11;
import com.ruoyi.project.system.service.IEquipmentDeploymentData11Service;

/**
 * 8:装备部署数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-18
 */
@Service
public class EquipmentDeploymentData11ServiceImpl implements IEquipmentDeploymentData11Service 
{
    @Autowired
    private EquipmentDeploymentData11Mapper equipmentDeploymentData11Mapper;

    /**
     * 查询8:装备部署数据
     * 
     * @param id 8:装备部署数据主键
     * @return 8:装备部署数据
     */
    @Override
    public EquipmentDeploymentData11 selectEquipmentDeploymentData11ById(Long id)
    {
        return equipmentDeploymentData11Mapper.selectEquipmentDeploymentData11ById(id);
    }

    /**
     * 查询8:装备部署数据列表
     * 
     * @param equipmentDeploymentData11 8:装备部署数据
     * @return 8:装备部署数据
     */
    @Override
    public List<EquipmentDeploymentData11> selectEquipmentDeploymentData11List(EquipmentDeploymentData11 equipmentDeploymentData11)
    {
        return equipmentDeploymentData11Mapper.selectEquipmentDeploymentData11List(equipmentDeploymentData11);
    }

    /**
     * 新增8:装备部署数据
     * 
     * @param equipmentDeploymentData11 8:装备部署数据
     * @return 结果
     */
    @Override
    public int insertEquipmentDeploymentData11(EquipmentDeploymentData11 equipmentDeploymentData11)
    {
        return equipmentDeploymentData11Mapper.insertEquipmentDeploymentData11(equipmentDeploymentData11);
    }

    /**
     * 修改8:装备部署数据
     * 
     * @param equipmentDeploymentData11 8:装备部署数据
     * @return 结果
     */
    @Override
    public int updateEquipmentDeploymentData11(EquipmentDeploymentData11 equipmentDeploymentData11)
    {
        return equipmentDeploymentData11Mapper.updateEquipmentDeploymentData11(equipmentDeploymentData11);
    }

    /**
     * 批量删除8:装备部署数据
     * 
     * @param ids 需要删除的8:装备部署数据主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentDeploymentData11ByIds(Long[] ids)
    {
        return equipmentDeploymentData11Mapper.deleteEquipmentDeploymentData11ByIds(ids);
    }

    /**
     * 删除8:装备部署数据信息
     * 
     * @param id 8:装备部署数据主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentDeploymentData11ById(Long id)
    {
        return equipmentDeploymentData11Mapper.deleteEquipmentDeploymentData11ById(id);
    }
}
