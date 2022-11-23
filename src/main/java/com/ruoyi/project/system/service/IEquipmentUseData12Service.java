package com.ruoyi.project.system.service;

import java.util.List;

import com.ruoyi.project.system.domain.EquipmentDesignData;
import com.ruoyi.project.system.domain.EquipmentUseData12;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
public interface IEquipmentUseData12Service 
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
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteEquipmentUseData12ByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteEquipmentUseData12ById(Long id);
    /**
     * 导入产品设计数据
     *
     * @param importDataList 数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importData(List<EquipmentUseData12> importDataList, Boolean isUpdateSupport, String operName);

}
