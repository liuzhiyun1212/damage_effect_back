package com.ruoyi.project.system.service.impl;

import java.util.List;
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
}
