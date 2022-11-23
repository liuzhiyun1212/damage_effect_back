package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.EquipmentUseData12;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
public interface EquipmentUseData12Mapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public EquipmentUseData12 selectEquipmentUseData12ById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param equipmentUseData12 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<EquipmentUseData12> selectEquipmentUseData12List(EquipmentUseData12 equipmentUseData12);

    /**
     * 新增【请填写功能名称】
     * 
     * @param equipmentUseData12 【请填写功能名称】
     * @return 结果
     */
    public int insertEquipmentUseData12(EquipmentUseData12 equipmentUseData12);

    /**
     * 修改【请填写功能名称】
     * 
     * @param equipmentUseData12 【请填写功能名称】
     * @return 结果
     */
    public int updateEquipmentUseData12(EquipmentUseData12 equipmentUseData12);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteEquipmentUseData12ById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipmentUseData12ByIds(Long[] ids);
}
