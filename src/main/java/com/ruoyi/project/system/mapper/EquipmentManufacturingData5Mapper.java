package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.EquipmentManufacturingData5;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-11-16
 */
public interface EquipmentManufacturingData5Mapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public EquipmentManufacturingData5 selectEquipmentManufacturingData5ById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param equipmentManufacturingData5 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<EquipmentManufacturingData5> selectEquipmentManufacturingData5List(EquipmentManufacturingData5 equipmentManufacturingData5);


    public List<EquipmentManufacturingData5> selectEquipmentManufacturingData5withproblem();

    /**
     * 新增【请填写功能名称】
     *
     * @param equipmentManufacturingData5 【请填写功能名称】
     * @return 结果
     */
    public int insertEquipmentManufacturingData5(EquipmentManufacturingData5 equipmentManufacturingData5);

    /**
     * 修改【请填写功能名称】
     *
     * @param equipmentManufacturingData5 【请填写功能名称】
     * @return 结果
     */
    public int updateEquipmentManufacturingData5(EquipmentManufacturingData5 equipmentManufacturingData5);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteEquipmentManufacturingData5ById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipmentManufacturingData5ByIds(Long[] ids);
}
