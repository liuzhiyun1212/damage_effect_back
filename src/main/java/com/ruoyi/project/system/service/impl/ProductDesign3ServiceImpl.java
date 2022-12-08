package com.ruoyi.project.system.service.impl;

import java.util.List;

import com.ruoyi.project.system.domain.MethodQuality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.ProductDesign3Mapper;
import com.ruoyi.project.system.domain.ProductDesign3;
import com.ruoyi.project.system.service.IProductDesign3Service;

/**
 * 成品件设计数据Service业务层处理
 *
 * @author ruoyi
 * @date 2022-11-10
 */
@Service
class ProductDesign3ServiceImpl implements IProductDesign3Service
{
    @Autowired
    private ProductDesign3Mapper productDesign3Mapper;

    /**
     * 查询成品件设计数据
     *
     * @param id 成品件设计数据主键
     * @return 成品件设计数据
     */
    @Override
    public ProductDesign3 selectProductDesign3ById(Long id)
    {
        return productDesign3Mapper.selectProductDesign3ById(id);
    }

    @Override
    public List<MethodQuality> selectMethodQuality() {
        return productDesign3Mapper.selectMethodQuality();
    }

    /**
     * 查询成品件设计数据列表
     *
     * @param productDesign3 成品件设计数据
     * @return 成品件设计数据
     */
    @Override
    public List<ProductDesign3> selectProductDesign3List(ProductDesign3 productDesign3)
    {
        return productDesign3Mapper.selectProductDesign3List(productDesign3);
    }

    /**
     * 新增成品件设计数据
     *
     * @param productDesign3 成品件设计数据
     * @return 结果
     */
    @Override
    public int insertProductDesign3(ProductDesign3 productDesign3)
    {
        return productDesign3Mapper.insertProductDesign3(productDesign3);
    }

    /**
     * 修改成品件设计数据
     *
     * @param productDesign3 成品件设计数据
     * @return 结果
     */
    @Override
    public int updateProductDesign3(ProductDesign3 productDesign3)
    {
        return productDesign3Mapper.updateProductDesign3(productDesign3);
    }

    /**
     * 批量删除成品件设计数据
     *
     * @param ids 需要删除的成品件设计数据主键
     * @return 结果
     */
    @Override
    public int deleteProductDesign3ByIds(Long[] ids)
    {
        return productDesign3Mapper.deleteProductDesign3ByIds(ids);
    }

    /**
     * 删除成品件设计数据信息
     *
     * @param id 成品件设计数据主键
     * @return 结果
     */
    @Override
    public int deleteProductDesign3ById(Long id)
    {
        return productDesign3Mapper.deleteProductDesign3ById(id);
    }
}
