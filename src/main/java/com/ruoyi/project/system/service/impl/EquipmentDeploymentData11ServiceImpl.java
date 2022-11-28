package com.ruoyi.project.system.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.ProductQuantity7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipmentDeploymentData11Mapper;
import com.ruoyi.project.system.domain.EquipmentDeploymentData11;
import com.ruoyi.project.system.service.IEquipmentDeploymentData11Service;

/**
 * 8:装备部署数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-18
 */
@Service
public class EquipmentDeploymentData11ServiceImpl implements IEquipmentDeploymentData11Service 
{
    @Autowired
    private EquipmentDeploymentData11Mapper equipmentDeploymentData11Mapper;

    /**
     * 查询8:装备部署数据
     * 
     * @param id 8:装备部署数据主键
     * @return 8:装备部署数据
     */
    @Override
    public EquipmentDeploymentData11 selectEquipmentDeploymentData11ById(Long id)
    {
        return equipmentDeploymentData11Mapper.selectEquipmentDeploymentData11ById(id);
    }

    /**
     * 查询8:装备部署数据列表
     * 
     * @param equipmentDeploymentData11 8:装备部署数据
     * @return 8:装备部署数据
     */
    @Override
    public List<EquipmentDeploymentData11> selectEquipmentDeploymentData11List(EquipmentDeploymentData11 equipmentDeploymentData11)
    {
        return equipmentDeploymentData11Mapper.selectEquipmentDeploymentData11List(equipmentDeploymentData11);
    }

    /**
     * 新增8:装备部署数据
     * 
     * @param equipmentDeploymentData11 8:装备部署数据
     * @return 结果
     */
    @Override
    public int insertEquipmentDeploymentData11(EquipmentDeploymentData11 equipmentDeploymentData11)
    {
        return equipmentDeploymentData11Mapper.insertEquipmentDeploymentData11(equipmentDeploymentData11);
    }

    /**
     * 修改8:装备部署数据
     * 
     * @param equipmentDeploymentData11 8:装备部署数据
     * @return 结果
     */
    @Override
    public int updateEquipmentDeploymentData11(EquipmentDeploymentData11 equipmentDeploymentData11)
    {
        return equipmentDeploymentData11Mapper.updateEquipmentDeploymentData11(equipmentDeploymentData11);
    }

    /**
     * 批量删除8:装备部署数据
     * 
     * @param ids 需要删除的8:装备部署数据主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentDeploymentData11ByIds(Long[] ids)
    {
        return equipmentDeploymentData11Mapper.deleteEquipmentDeploymentData11ByIds(ids);
    }

    /**
     * 删除8:装备部署数据信息
     * 
     * @param id 8:装备部署数据主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentDeploymentData11ById(Long id)
    {
        return equipmentDeploymentData11Mapper.deleteEquipmentDeploymentData11ById(id);
    }

    /**
     * @Description导入装备部署数据
     * @Author guohuijia
     * @Date  2022/11/13
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @Override
    public String importData(List<EquipmentDeploymentData11> dataManagementList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dataManagementList) || dataManagementList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<EquipmentDeploymentData11> existList = selectEquipmentDeploymentData11List(null);
        for (EquipmentDeploymentData11 importData : dataManagementList)
        {
            try {
                insertEquipmentDeploymentData11((importData));
                successNum++;
                successMsg.append("<br/>" + successNum + "、数据 " + importData.getPlaneType() + " 导入成功");
            }catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + importData.getPlaneType() + " 导入失败：";
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
