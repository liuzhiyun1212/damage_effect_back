package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipmentDesignDataMapper;
import com.ruoyi.project.system.domain.EquipmentDesignData;
import com.ruoyi.project.system.service.IEquipmentDesignDataService;

/**
 * 装备设计/改型数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
@Service
public class EquipmentDesignDataServiceImpl implements IEquipmentDesignDataService 
{
    @Autowired
    private EquipmentDesignDataMapper equipmentDesignDataMapper;

    /**
     * 查询装备设计/改型数据
     * 
     * @param id 装备设计/改型数据主键
     * @return 装备设计/改型数据
     */
    @Override
    public EquipmentDesignData selectEquipmentDesignDataById(Long id)
    {
        return equipmentDesignDataMapper.selectEquipmentDesignDataById(id);
    }

    /**
     * 查询装备设计/改型数据列表
     * 
     * @param equipmentDesignData 装备设计/改型数据
     * @return 装备设计/改型数据
     */
    @Override
    public List<EquipmentDesignData> selectEquipmentDesignDataList(EquipmentDesignData equipmentDesignData)
    {
        return equipmentDesignDataMapper.selectEquipmentDesignDataList(equipmentDesignData);
    }

    /**
     * 新增装备设计/改型数据
     * 
     * @param equipmentDesignData 装备设计/改型数据
     * @return 结果
     */
    @Override
    public int insertEquipmentDesignData(EquipmentDesignData equipmentDesignData)
    {
        return equipmentDesignDataMapper.insertEquipmentDesignData(equipmentDesignData);
    }

    /**
     * 修改装备设计/改型数据
     * 
     * @param equipmentDesignData 装备设计/改型数据
     * @return 结果
     */
    @Override
    public int updateEquipmentDesignData(EquipmentDesignData equipmentDesignData)
    {
        return equipmentDesignDataMapper.updateEquipmentDesignData(equipmentDesignData);
    }

    /**
     * 批量删除装备设计/改型数据
     * 
     * @param ids 需要删除的装备设计/改型数据主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentDesignDataByIds(Long[] ids)
    {
        return equipmentDesignDataMapper.deleteEquipmentDesignDataByIds(ids);
    }

    /**
     * 删除装备设计/改型数据信息
     * 
     * @param id 装备设计/改型数据主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentDesignDataById(Long id)
    {
        return equipmentDesignDataMapper.deleteEquipmentDesignDataById(id);
    }
}
