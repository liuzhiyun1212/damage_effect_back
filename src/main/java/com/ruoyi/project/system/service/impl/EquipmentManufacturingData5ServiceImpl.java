package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.EquipmentManufacturingData5;
import com.ruoyi.project.system.mapper.EquipmentManufacturingData5Mapper;
import com.ruoyi.project.system.service.IEquipmentManufacturingData5Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-11-16
 */
@Service
public class EquipmentManufacturingData5ServiceImpl implements IEquipmentManufacturingData5Service
{
    @Autowired
    private EquipmentManufacturingData5Mapper equipmentManufacturingData5Mapper;
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public EquipmentManufacturingData5 selectEquipmentManufacturingData5ById(Long id)
    {
        return equipmentManufacturingData5Mapper.selectEquipmentManufacturingData5ById(id);
    }

    @Override
    public List<EquipmentManufacturingData5> selectEquipmentManufacturingData5withproblem()
    {
        return equipmentManufacturingData5Mapper.selectEquipmentManufacturingData5withproblem();
    }




    /**
     * 查询【请填写功能名称】列表
     *
     * @param equipmentManufacturingData5 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<EquipmentManufacturingData5> selectEquipmentManufacturingData5List(EquipmentManufacturingData5 equipmentManufacturingData5)
    {
        return equipmentManufacturingData5Mapper.selectEquipmentManufacturingData5List(equipmentManufacturingData5);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param equipmentManufacturingData5 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertEquipmentManufacturingData5(EquipmentManufacturingData5 equipmentManufacturingData5)
    {
        return equipmentManufacturingData5Mapper.insertEquipmentManufacturingData5(equipmentManufacturingData5);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param equipmentManufacturingData5 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateEquipmentManufacturingData5(EquipmentManufacturingData5 equipmentManufacturingData5)
    {
        return equipmentManufacturingData5Mapper.updateEquipmentManufacturingData5(equipmentManufacturingData5);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentManufacturingData5ByIds(Long[] ids)
    {
        return equipmentManufacturingData5Mapper.deleteEquipmentManufacturingData5ByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentManufacturingData5ById(Long id)
    {
        return equipmentManufacturingData5Mapper.deleteEquipmentManufacturingData5ById(id);
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
    public String importData(List<EquipmentManufacturingData5> dataManagementList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dataManagementList) || dataManagementList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<EquipmentManufacturingData5> existList = selectEquipmentManufacturingData5List(null);
        for (EquipmentManufacturingData5 importData : dataManagementList)
        {
            try {
                insertEquipmentManufacturingData5((importData));
                successNum++;
                successMsg.append("<br/>" + successNum + "、数据 " + importData.getPlaneType() + " 导入成功");
            }catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、数据 " + importData.getPlaneType() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
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
