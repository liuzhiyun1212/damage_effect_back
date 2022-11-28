package com.ruoyi.project.system.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.EquipmentDesignData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.ProductQuantity7Mapper;
import com.ruoyi.project.system.domain.ProductQuantity7;
import com.ruoyi.project.system.service.IProductQuantity7Service;

/**
 * 7：产品生产数量Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
@Service
public class ProductQuantity7ServiceImpl implements IProductQuantity7Service 
{
    @Autowired
    private ProductQuantity7Mapper productQuantity7Mapper;

    /**
     * 查询7：产品生产数量
     * 
     * @param id 7：产品生产数量主键
     * @return 7：产品生产数量
     */
    @Override
    public ProductQuantity7 selectProductQuantity7ById(Long id)
    {
        return productQuantity7Mapper.selectProductQuantity7ById(id);
    }

    /**
     * 查询7：产品生产数量列表
     * 
     * @param productQuantity7 7：产品生产数量
     * @return 7：产品生产数量
     */
    @Override
    public List<ProductQuantity7> selectProductQuantity7List(ProductQuantity7 productQuantity7)
    {
        return productQuantity7Mapper.selectProductQuantity7List(productQuantity7);
    }

    /**
     * 新增7：产品生产数量
     * 
     * @param productQuantity7 7：产品生产数量
     * @return 结果
     */
    @Override
    public int insertProductQuantity7(ProductQuantity7 productQuantity7)
    {
        return productQuantity7Mapper.insertProductQuantity7(productQuantity7);
    }

    /**
     * 修改7：产品生产数量
     * 
     * @param productQuantity7 7：产品生产数量
     * @return 结果
     */
    @Override
    public int updateProductQuantity7(ProductQuantity7 productQuantity7)
    {
        return productQuantity7Mapper.updateProductQuantity7(productQuantity7);
    }

    /**
     * 批量删除7：产品生产数量
     * 
     * @param ids 需要删除的7：产品生产数量主键
     * @return 结果
     */
    @Override
    public int deleteProductQuantity7ByIds(Long[] ids)
    {
        return productQuantity7Mapper.deleteProductQuantity7ByIds(ids);
    }

    /**
     * 删除7：产品生产数量信息
     * 
     * @param id 7：产品生产数量主键
     * @return 结果
     */
    @Override
    public int deleteProductQuantity7ById(Long id)
    {
        return productQuantity7Mapper.deleteProductQuantity7ById(id);
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
    public String importData(List<ProductQuantity7> dataManagementList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dataManagementList) || dataManagementList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<ProductQuantity7> existList = selectProductQuantity7List(null);
        for (ProductQuantity7 importData : dataManagementList)
        {
            try {
                insertProductQuantity7((importData));
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
