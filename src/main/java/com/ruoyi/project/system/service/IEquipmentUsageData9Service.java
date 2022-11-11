package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.EquipmentUsageData9;

/**
 * 9：装备使用数据Service接口
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
public interface IEquipmentUsageData9Service 
{
    /**
     * 查询9：装备使用数据
     * 
     * @param id 9：装备使用数据主键
     * @return 9：装备使用数据
     */
    public EquipmentUsageData9 selectEquipmentUsageData9ById(Long id);

    /**
     * 查询9：装备使用数据列表
     * 
     * @param equipmentUsageData9 9：装备使用数据
     * @return 9：装备使用数据集合
     */
    public List<EquipmentUsageData9> selectEquipmentUsageData9List(EquipmentUsageData9 equipmentUsageData9);

    /**
     * 新增9：装备使用数据
     * 
     * @param equipmentUsageData9 9：装备使用数据
     * @return 结果
     */
    public int insertEquipmentUsageData9(EquipmentUsageData9 equipmentUsageData9);

    /**
     * 修改9：装备使用数据
     * 
     * @param equipmentUsageData9 9：装备使用数据
     * @return 结果
     */
    public int updateEquipmentUsageData9(EquipmentUsageData9 equipmentUsageData9);

    /**
     * 批量删除9：装备使用数据
     * 
     * @param ids 需要删除的9：装备使用数据主键集合
     * @return 结果
     */
    public int deleteEquipmentUsageData9ByIds(Long[] ids);

    /**
     * 删除9：装备使用数据信息
     * 
     * @param id 9：装备使用数据主键
     * @return 结果
     */
    public int deleteEquipmentUsageData9ById(Long id);
}
