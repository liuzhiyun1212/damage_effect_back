package com.ruoyi.project.system.mapper;

import com.ruoyi.project.system.domain.EquipmentDeploymentData11;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 8:装备部署数据Mapper接口
 *
 * @author ruoyi
 * @date 2022-11-18
 */
@Component
public interface EquipmentDeploymentData11Mapper
{
    /**
     * 查询8:装备部署数据
     *
     * @param id 8:装备部署数据主键
     * @return 8:装备部署数据
     */
    public EquipmentDeploymentData11 selectEquipmentDeploymentData11ById(Long id);

    /**
     * 查询8:装备部署数据列表
     *
     * @param equipmentDeploymentData11 8:装备部署数据
     * @return 8:装备部署数据集合
     */
    public List<EquipmentDeploymentData11> selectEquipmentDeploymentData11List(EquipmentDeploymentData11 equipmentDeploymentData11);

    /**
     * 新增8:装备部署数据
     *
     * @param equipmentDeploymentData11 8:装备部署数据
     * @return 结果
     */
    public int insertEquipmentDeploymentData11(EquipmentDeploymentData11 equipmentDeploymentData11);

    /**
     * 修改8:装备部署数据
     *
     * @param equipmentDeploymentData11 8:装备部署数据
     * @return 结果
     */
    public int updateEquipmentDeploymentData11(EquipmentDeploymentData11 equipmentDeploymentData11);

    /**
     * 删除8:装备部署数据
     *
     * @param id 8:装备部署数据主键
     * @return 结果
     */
    public int deleteEquipmentDeploymentData11ById(Long id);

    /**
     * 批量删除8:装备部署数据
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipmentDeploymentData11ByIds(Long[] ids);
}
