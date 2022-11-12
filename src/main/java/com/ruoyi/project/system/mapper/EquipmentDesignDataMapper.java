package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.EquipmentDesignData;

/**
 * 装备设计/改型数据Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
public interface EquipmentDesignDataMapper 
{
    /**
     * 查询装备设计/改型数据
     * 
     * @param id 装备设计/改型数据主键
     * @return 装备设计/改型数据
     */
    public EquipmentDesignData selectEquipmentDesignDataById(Long id);

    /**
     * 查询装备设计/改型数据列表
     * 
     * @param equipmentDesignData 装备设计/改型数据
     * @return 装备设计/改型数据集合
     */
    public List<EquipmentDesignData> selectEquipmentDesignDataList(EquipmentDesignData equipmentDesignData);

    /**
     * 新增装备设计/改型数据
     * 
     * @param equipmentDesignData 装备设计/改型数据
     * @return 结果
     */
    public int insertEquipmentDesignData(EquipmentDesignData equipmentDesignData);

    /**
     * 修改装备设计/改型数据
     * 
     * @param equipmentDesignData 装备设计/改型数据
     * @return 结果
     */
    public int updateEquipmentDesignData(EquipmentDesignData equipmentDesignData);

    /**
     * 删除装备设计/改型数据
     * 
     * @param id 装备设计/改型数据主键
     * @return 结果
     */
    public int deleteEquipmentDesignDataById(Long id);

    /**
     * 批量删除装备设计/改型数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipmentDesignDataByIds(Long[] ids);
}
