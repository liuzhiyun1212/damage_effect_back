package com.ruoyi.project.system.service;

import java.util.List;

import com.ruoyi.project.system.domain.EquipmentDeploymentData11;
import com.ruoyi.project.system.domain.RepairModifyData10;

/**
 * 【10：维修变更数据】Service接口
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
public interface IRepairModifyData10Service 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【10：维修变更数据】主键
     * @return 【10：维修变更数据】
     */
    public RepairModifyData10 selectRepairModifyData10ById(Integer id);

    /**
     * 查询【10：维修变更数据】列表
     * 
     * @param repairModifyData10 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RepairModifyData10> selectRepairModifyData10List(RepairModifyData10 repairModifyData10);

    /**
     * 新增【10：维修变更数据】
     * 
     * @param repairModifyData10 【请填写功能名称】
     * @return 结果
     */
    public int insertRepairModifyData10(RepairModifyData10 repairModifyData10);

    /**
     * 修改【10：维修变更数据】
     * 
     * @param repairModifyData10 【请填写功能名称】
     * @return 结果
     */
    public int updateRepairModifyData10(RepairModifyData10 repairModifyData10);

    /**
     * 批量删除【10：维修变更数据】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteRepairModifyData10ByIds(Integer[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteRepairModifyData10ById(Integer id);
    /**
     * 导入产品设计数据
     *
     * @param importDataList 数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importData(List<RepairModifyData10> importDataList, Boolean isUpdateSupport, String operName);
}
