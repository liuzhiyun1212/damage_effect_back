package com.ruoyi.project.system.service;

import com.ruoyi.project.system.domain.EquipmentManufacturingData5;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2022-11-16
 */
public interface IEquipmentManufacturingData5Service
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public EquipmentManufacturingData5 selectEquipmentManufacturingData5ById(Long id);



    //查询有质量问题的装备制造数据
    public List<EquipmentManufacturingData5> selectEquipmentManufacturingData5withproblem();




    /**
     * 查询【请填写功能名称】列表
     *
     * @param equipmentManufacturingData5 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<EquipmentManufacturingData5> selectEquipmentManufacturingData5List(EquipmentManufacturingData5 equipmentManufacturingData5);

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
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteEquipmentManufacturingData5ByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteEquipmentManufacturingData5ById(Long id);
    /**
     * 导入产品制造数据
     *
     * @param importDataList 数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importData(List<EquipmentManufacturingData5> importDataList, Boolean isUpdateSupport, String operName);
}
