package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.FaultyPartsCount;
import com.ruoyi.project.system.domain.ProductModify;
import com.ruoyi.project.system.domain.RepairModifyData10;
import com.ruoyi.project.system.mapper.RepairModifyData10Mapper;
import com.ruoyi.project.system.service.IRepairModifyData10Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【1-：维修变更数据】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-11-25
 */
@Service
public class RepairModifyData10ServiceImpl implements IRepairModifyData10Service
{
    @Autowired
    private RepairModifyData10Mapper repairModifyData10Mapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public RepairModifyData10 selectRepairModifyData10ById(Integer id)
    {
        return repairModifyData10Mapper.selectRepairModifyData10ById(id);
    }

    @Override
    public List<RepairModifyData10> selectRepairPeople() {
        return repairModifyData10Mapper.selectRepairPeople();
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param repairModifyData10 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RepairModifyData10> selectRepairModifyData10List(RepairModifyData10 repairModifyData10)
    {
        return repairModifyData10Mapper.selectRepairModifyData10List(repairModifyData10);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param repairModifyData10 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRepairModifyData10(RepairModifyData10 repairModifyData10)
    {
        return repairModifyData10Mapper.insertRepairModifyData10(repairModifyData10);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param repairModifyData10 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRepairModifyData10(RepairModifyData10 repairModifyData10)
    {
        return repairModifyData10Mapper.updateRepairModifyData10(repairModifyData10);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRepairModifyData10ByIds(Integer[] ids)
    {
        return repairModifyData10Mapper.deleteRepairModifyData10ByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRepairModifyData10ById(Integer id)
    {
        return repairModifyData10Mapper.deleteRepairModifyData10ById(id);
    }

    /**
     * @Description导入装备部署数据
     * @Author lfb
     * @Date  2022/11/13
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @Override
    public String importData(List<RepairModifyData10> dataManagementList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dataManagementList) || dataManagementList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<RepairModifyData10> existList = selectRepairModifyData10List(null);
        for (RepairModifyData10 importData : dataManagementList)
        {
            try {
                insertRepairModifyData10((importData));
                successNum++;
                successMsg.append("<br/>" + successNum + "、数据 " + importData.getPartsName() + " 导入成功");
            }catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、数据 " + importData.getPartsName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());

            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
    /**
     * @Description 故障件维修工艺变更时间线
     * @Author guohuijia
     * @Date  2022/12/4
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @Override
    public List<ProductModify> selectRepairWayChange() {
        return repairModifyData10Mapper.selectRepairWayChange();
    }

    @Override
    public List<FaultyPartsCount> selectFaultyCountByRepairWay(){
        // 获取变更类型为维修工艺变更的数量
        List<FaultyPartsCount> list = repairModifyData10Mapper.selectFaultyCountByRepairWay();
        return list;
    }
}
