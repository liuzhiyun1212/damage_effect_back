package com.ruoyi.project.system.mapper;

import com.ruoyi.project.system.domain.FaultyPartsCount;
import com.ruoyi.project.system.domain.ProductModify;
import com.ruoyi.project.system.domain.RepairModifyData10;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-11-25
 */
public interface RepairModifyData10Mapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public RepairModifyData10 selectRepairModifyData10ById(Integer id);


    /**
     * 故障件维修人员变更时间线
     */
    public List<RepairModifyData10> selectRepairPeople();

    /**
     * 查询【请填写功能名称】列表
     *
     * @param repairModifyData10 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RepairModifyData10> selectRepairModifyData10List(RepairModifyData10 repairModifyData10);

    /**
     * 新增【请填写功能名称】
     *
     * @param repairModifyData10 【请填写功能名称】
     * @return 结果
     */
    public int insertRepairModifyData10(RepairModifyData10 repairModifyData10);

    /**
     * 修改【请填写功能名称】
     *
     * @param repairModifyData10 【请填写功能名称】
     * @return 结果
     */
    public int updateRepairModifyData10(RepairModifyData10 repairModifyData10);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteRepairModifyData10ById(Integer id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRepairModifyData10ByIds(Integer[] ids);

    /**
     * 故障件维修工艺变更时间线
     */
    public List<ProductModify> selectRepairWayChange();
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
