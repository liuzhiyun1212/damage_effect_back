package com.ruoyi.project.system.service.impl;

import java.util.List;

import com.ruoyi.project.system.domain.install_way;
import com.ruoyi.project.system.domain.partsSite;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.ProductDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipmentDesignDataMapper;
import com.ruoyi.project.system.domain.EquipmentDesignData;
import com.ruoyi.project.system.service.IEquipmentDesignDataService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * 装备设计/改型数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
@Service
public class EquipmentDesignDataServiceImpl implements IEquipmentDesignDataService 
{
    @Autowired
    private EquipmentDesignDataMapper equipmentDesignDataMapper;

    /**
     * 查询装备设计/改型数据
     * 
     * @param id 装备设计/改型数据主键
     * @return 装备设计/改型数据
     */
    @Override
    public EquipmentDesignData selectEquipmentDesignDataById(Long id)
    {
        return equipmentDesignDataMapper.selectEquipmentDesignDataById(id);
    }

    /**
     * 查询装备设计/改型数据列表
     * 
     * @param equipmentDesignData 装备设计/改型数据
     * @return 装备设计/改型数据
     */
    @Override
    public List<EquipmentDesignData> selectEquipmentDesignDataList(EquipmentDesignData equipmentDesignData)
    {
        return equipmentDesignDataMapper.selectEquipmentDesignDataList(equipmentDesignData);
    }

    /**
     * 新增装备设计/改型数据
     * 
     * @param equipmentDesignData 装备设计/改型数据
     * @return 结果
     */
    @Override
    public int insertEquipmentDesignData(EquipmentDesignData equipmentDesignData)
    {
        return equipmentDesignDataMapper.insertEquipmentDesignData(equipmentDesignData);
    }

    /**
     * 修改装备设计/改型数据
     * 
     * @param equipmentDesignData 装备设计/改型数据
     * @return 结果
     */
    @Override
    public int updateEquipmentDesignData(EquipmentDesignData equipmentDesignData)
    {
        return equipmentDesignDataMapper.updateEquipmentDesignData(equipmentDesignData);
    }

    /**
     * 批量删除装备设计/改型数据
     * 
     * @param ids 需要删除的装备设计/改型数据主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentDesignDataByIds(Long[] ids)
    {
        return equipmentDesignDataMapper.deleteEquipmentDesignDataByIds(ids);
    }

    /**
     * 删除装备设计/改型数据信息
     * 
     * @param id 装备设计/改型数据主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentDesignDataById(Long id)
    {
        return equipmentDesignDataMapper.deleteEquipmentDesignDataById(id);
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
    public String importData(List<EquipmentDesignData> dataManagementList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dataManagementList) || dataManagementList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<EquipmentDesignData> existList = selectEquipmentDesignDataList(null);
        for (EquipmentDesignData importData : dataManagementList)
        {
            try {
                insertEquipmentDesignData((importData));
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

