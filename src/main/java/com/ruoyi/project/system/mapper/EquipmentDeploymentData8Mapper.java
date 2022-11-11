package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.EquipmentDeploymentData8;

/**
 * 8:装备部署数据Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
public interface EquipmentDeploymentData8Mapper 
{
    /**
     * 查询8:装备部署数据
     * 
     * @param id 8:装备部署数据主键
     * @return 8:装备部署数据
     */
    public EquipmentDeploymentData8 selectEquipmentDeploymentData8ById(Long id);

    /**
     * 查询8:装备部署数据列表
     * 
     * @param equipmentDeploymentData8 8:装备部署数据
     * @return 8:装备部署数据集合
     */
    public List<EquipmentDeploymentData8> selectEquipmentDeploymentData8List(EquipmentDeploymentData8 equipmentDeploymentData8);

    /**
     * 新增8:装备部署数据
     * 
     * @param equipmentDeploymentData8 8:装备部署数据
     * @return 结果
     */
    public int insertEquipmentDeploymentData8(EquipmentDeploymentData8 equipmentDeploymentData8);

    /**
     * 修改8:装备部署数据
     * 
     * @param equipmentDeploymentData8 8:装备部署数据
     * @return 结果
     */
    public int updateEquipmentDeploymentData8(EquipmentDeploymentData8 equipmentDeploymentData8);

    /**
     * 删除8:装备部署数据
     * 
     * @param id 8:装备部署数据主键
     * @return 结果
     */
    public int deleteEquipmentDeploymentData8ById(Long id);

    /**
     * 批量删除8:装备部署数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipmentDeploymentData8ByIds(Long[] ids);
}
