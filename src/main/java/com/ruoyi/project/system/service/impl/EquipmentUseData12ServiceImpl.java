package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.EquipmentUseData12;
import com.ruoyi.project.system.mapper.EquipmentUseData12Mapper;
import com.ruoyi.project.system.service.IEquipmentUseData12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
@Service
public class EquipmentUseData12ServiceImpl implements IEquipmentUseData12Service 
{
    @Autowired
    private EquipmentUseData12Mapper equipmentUseData12Mapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public EquipmentUseData12 selectEquipmentUseData12ById(Long id)
    {
        return equipmentUseData12Mapper.selectEquipmentUseData12ById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param equipmentUseData12 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<EquipmentUseData12> selectEquipmentUseData12List(EquipmentUseData12 equipmentUseData12)
    {
        return equipmentUseData12Mapper.selectEquipmentUseData12List(equipmentUseData12);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param equipmentUseData12 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertEquipmentUseData12(EquipmentUseData12 equipmentUseData12)
    {
        return equipmentUseData12Mapper.insertEquipmentUseData12(equipmentUseData12);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param equipmentUseData12 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateEquipmentUseData12(EquipmentUseData12 equipmentUseData12)
    {
        return equipmentUseData12Mapper.updateEquipmentUseData12(equipmentUseData12);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentUseData12ByIds(Long[] ids)
    {
        return equipmentUseData12Mapper.deleteEquipmentUseData12ByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentUseData12ById(Long id)
    {
        return equipmentUseData12Mapper.deleteEquipmentUseData12ById(id);
    }

    /**
     * @Description导入产品设计数据
     * @Author guohuijia
     * @Date  2022/11/13
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @Override
    public String importData(List<EquipmentUseData12> dataManagementList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dataManagementList) || dataManagementList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<EquipmentUseData12> existList = selectEquipmentUseData12List(null);
        for (EquipmentUseData12 importData : dataManagementList)
        {
            try {
                insertEquipmentUseData12((importData));
                successNum++;
                successMsg.append("<br/>" + successNum + "、数据 " + importData.getPlaneType() + " 导入成功");
            }catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、数据 " + importData.getPlaneType() + " 导入失败：";
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
}

