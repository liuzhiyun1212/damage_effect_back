package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.ProductDesignMapper;
import com.ruoyi.project.system.domain.ProductDesign;
import com.ruoyi.project.system.service.IProductDesignService;

/**
 * 成品件设计数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
@Service
public class ProductDesignServiceImpl implements IProductDesignService 
{
    @Autowired
    private ProductDesignMapper productDesignMapper;

    /**
     * 查询成品件设计数据
     * 
     * @param id 成品件设计数据主键
     * @return 成品件设计数据
     */
    @Override
    public ProductDesign selectProductDesignById(Long id)
    {
        return productDesignMapper.selectProductDesignById(id);
    }

    /**
     * 查询成品件设计数据列表
     * 
     * @param productDesign 成品件设计数据
     * @return 成品件设计数据
     */
    @Override
    public List<ProductDesign> selectProductDesignList(ProductDesign productDesign)
    {
        return productDesignMapper.selectProductDesignList(productDesign);
    }

    /**
     * 新增成品件设计数据
     * 
     * @param productDesign 成品件设计数据
     * @return 结果
     */
    @Override
    public int insertProductDesign(ProductDesign productDesign)
    {
        return productDesignMapper.insertProductDesign(productDesign);
    }

    /**
     * 修改成品件设计数据
     * 
     * @param productDesign 成品件设计数据
     * @return 结果
     */
    @Override
    public int updateProductDesign(ProductDesign productDesign)
    {
        return productDesignMapper.updateProductDesign(productDesign);
    }

    /**
     * 批量删除成品件设计数据
     * 
     * @param ids 需要删除的成品件设计数据主键
     * @return 结果
     */
    @Override
    public int deleteProductDesignByIds(Long[] ids)
    {
        return productDesignMapper.deleteProductDesignByIds(ids);
    }

    /**
     * 删除成品件设计数据信息
     * 
     * @param id 成品件设计数据主键
     * @return 结果
     */
    @Override
    public int deleteProductDesignById(Long id)
    {
        return productDesignMapper.deleteProductDesignById(id);
    }
}
