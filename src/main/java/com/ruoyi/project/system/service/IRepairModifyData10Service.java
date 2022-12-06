package com.ruoyi.project.system.service;

import com.ruoyi.project.system.domain.FaultyPartsCount;
import com.ruoyi.project.system.domain.ProductModify;
import com.ruoyi.project.system.domain.RepairModifyData10;

import java.util.List;

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

    public List<RepairModifyData10> selectRepairPeople();

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

    /**
     * @Description 故障件维修工艺变更时间线
     * @Author guohuijia
     * @Date  2022/12/3
     * @Param []
     * @Return java.util.List<com.ruoyi.project.system.domain.ProductModify>
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<ProductModify>  selectRepairWayChange();
    /**
     * @Description 获取高发故障模式涉及到的维修工艺
     * @Author guohuijia
     * @Date  2022/12/5
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<FaultyPartsCount>  selectFaultyCountByRepairWay();
}
