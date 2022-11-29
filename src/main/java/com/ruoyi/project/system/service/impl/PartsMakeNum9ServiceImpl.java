package com.ruoyi.project.system.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.ProductQuantity7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.PartsMakeNum9Mapper;
import com.ruoyi.project.system.domain.PartsMakeNum9;
import com.ruoyi.project.system.service.IPartsMakeNum9Service;

/**
 * 9：装备使用数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-18
 */
@Service
public class PartsMakeNum9ServiceImpl implements IPartsMakeNum9Service 
{
    @Autowired
    private PartsMakeNum9Mapper partsMakeNum9Mapper;

    /**
     * 查询9：装备使用数据
     * 
     * @param id 9：装备使用数据主键
     * @return 9：装备使用数据
     */
    @Override
    public PartsMakeNum9 selectPartsMakeNum9ById(Long id)
    {
        return partsMakeNum9Mapper.selectPartsMakeNum9ById(id);
    }

    /**
     * 查询9：装备使用数据列表
     * 
     * @param partsMakeNum9 9：装备使用数据
     * @return 9：装备使用数据
     */
    @Override
    public List<PartsMakeNum9> selectPartsMakeNum9List(PartsMakeNum9 partsMakeNum9)
    {
        return partsMakeNum9Mapper.selectPartsMakeNum9List(partsMakeNum9);
    }

    /**
     * 新增9：装备使用数据
     * 
     * @param partsMakeNum9 9：装备使用数据
     * @return 结果
     */
    @Override
    public int insertPartsMakeNum9(PartsMakeNum9 partsMakeNum9)
    {
        return partsMakeNum9Mapper.insertPartsMakeNum9(partsMakeNum9);
    }

    /**
     * 修改9：装备使用数据
     * 
     * @param partsMakeNum9 9：装备使用数据
     * @return 结果
     */
    @Override
    public int updatePartsMakeNum9(PartsMakeNum9 partsMakeNum9)
    {
        return partsMakeNum9Mapper.updatePartsMakeNum9(partsMakeNum9);
    }

    /**
     * 批量删除9：装备使用数据
     * 
     * @param ids 需要删除的9：装备使用数据主键
     * @return 结果
     */
    @Override
    public int deletePartsMakeNum9ByIds(Long[] ids)
    {
        return partsMakeNum9Mapper.deletePartsMakeNum9ByIds(ids);
    }

    /**
     * 删除9：装备使用数据信息
     * 
     * @param id 9：装备使用数据主键
     * @return 结果
     */
    @Override
    public int deletePartsMakeNum9ById(Long id)
    {
        return partsMakeNum9Mapper.deletePartsMakeNum9ById(id);
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
    public String importData(List<PartsMakeNum9> dataManagementList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dataManagementList) || dataManagementList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<PartsMakeNum9> existList = selectPartsMakeNum9List(null);
        for (PartsMakeNum9 importData : dataManagementList)
        {
            try {
                insertPartsMakeNum9((importData));
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
