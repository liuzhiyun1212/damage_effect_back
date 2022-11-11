package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.ProductCreateMapper;
import com.ruoyi.project.system.domain.ProductCreate;
import com.ruoyi.project.system.service.IProductCreateService;

/**
 * 产品制造数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
@Service
public class ProductCreateServiceImpl implements IProductCreateService 
{
    @Autowired
    private ProductCreateMapper productCreateMapper;

    /**
     * 查询产品制造数据
     * 
     * @param id 产品制造数据主键
     * @return 产品制造数据
     */
    @Override
    public ProductCreate selectProductCreateById(Long id)
    {
        return productCreateMapper.selectProductCreateById(id);
    }

    /**
     * 查询产品制造数据列表
     * 
     * @param productCreate 产品制造数据
     * @return 产品制造数据
     */
    @Override
    public List<ProductCreate> selectProductCreateList(ProductCreate productCreate)
    {
        return productCreateMapper.selectProductCreateList(productCreate);
    }

    /**
     * 新增产品制造数据
     * 
     * @param productCreate 产品制造数据
     * @return 结果
     */
    @Override
    public int insertProductCreate(ProductCreate productCreate)
    {
        return productCreateMapper.insertProductCreate(productCreate);
    }

    /**
     * 修改产品制造数据
     * 
     * @param productCreate 产品制造数据
     * @return 结果
     */
    @Override
    public int updateProductCreate(ProductCreate productCreate)
    {
        return productCreateMapper.updateProductCreate(productCreate);
    }

    /**
     * 批量删除产品制造数据
     * 
     * @param ids 需要删除的产品制造数据主键
     * @return 结果
     */
    @Override
    public int deleteProductCreateByIds(Long[] ids)
    {
        return productCreateMapper.deleteProductCreateByIds(ids);
    }

    /**
     * 删除产品制造数据信息
     * 
     * @param id 产品制造数据主键
     * @return 结果
     */
    @Override
    public int deleteProductCreateById(Long id)
    {
        return productCreateMapper.deleteProductCreateById(id);
    }
}
