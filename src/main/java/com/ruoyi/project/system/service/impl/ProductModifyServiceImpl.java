package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.ProductModifyMapper;
import com.ruoyi.project.system.domain.ProductModify;
import com.ruoyi.project.system.service.IProductModifyService;

/**
 * 产品改型数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
@Service
public class ProductModifyServiceImpl implements IProductModifyService 
{
    @Autowired
    private ProductModifyMapper productModifyMapper;

    /**
     * 查询产品改型数据
     * 
     * @param id 产品改型数据主键
     * @return 产品改型数据
     */
    @Override
    public ProductModify selectProductModifyById(Long id)
    {
        return productModifyMapper.selectProductModifyById(id);
    }

    /**
     * 查询产品改型数据列表
     * 
     * @param productModify 产品改型数据
     * @return 产品改型数据
     */
    @Override
    public List<ProductModify> selectProductModifyList(ProductModify productModify)
    {
        return productModifyMapper.selectProductModifyList(productModify);
    }

    /**
     * 新增产品改型数据
     * 
     * @param productModify 产品改型数据
     * @return 结果
     */
    @Override
    public int insertProductModify(ProductModify productModify)
    {
        return productModifyMapper.insertProductModify(productModify);
    }

    /**
     * 修改产品改型数据
     * 
     * @param productModify 产品改型数据
     * @return 结果
     */
    @Override
    public int updateProductModify(ProductModify productModify)
    {
        return productModifyMapper.updateProductModify(productModify);
    }

    /**
     * 批量删除产品改型数据
     * 
     * @param ids 需要删除的产品改型数据主键
     * @return 结果
     */
    @Override
    public int deleteProductModifyByIds(Long[] ids)
    {
        return productModifyMapper.deleteProductModifyByIds(ids);
    }

    /**
     * 删除产品改型数据信息
     * 
     * @param id 产品改型数据主键
     * @return 结果
     */
    @Override
    public int deleteProductModifyById(Long id)
    {
        return productModifyMapper.deleteProductModifyById(id);
    }
}
