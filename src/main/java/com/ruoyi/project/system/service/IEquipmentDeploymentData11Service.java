package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.EquipmentDeploymentData11;
import com.ruoyi.project.system.domain.ProductQuantity7;

/**
 * 8:装备部署数据Service接口
 * 
 * @author ruoyi
 * @date 2022-11-18
 */
public interface IEquipmentDeploymentData11Service 
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
     * 批量删除8:装备部署数据
     * 
     * @param ids 需要删除的8:装备部署数据主键集合
     * @return 结果
     */
    public int deleteEquipmentDeploymentData11ByIds(Long[] ids);

    /**
     * 删除8:装备部署数据信息
     * 
     * @param id 8:装备部署数据主键
     * @return 结果
     */
    public int deleteEquipmentDeploymentData11ById(Long id);
    /**
     * 导入产品设计数据
     *
     * @param importDataList 数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importData(List<EquipmentDeploymentData11> importDataList, Boolean isUpdateSupport, String operName);
}
