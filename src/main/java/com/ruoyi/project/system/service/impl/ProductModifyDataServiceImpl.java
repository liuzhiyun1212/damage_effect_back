package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.ProductModifyDataMapper;
import com.ruoyi.project.system.domain.ProductModifyData;
import com.ruoyi.project.system.service.IProductModifyDataService;

/**
 * 产品制造变更数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
@Service
public class ProductModifyDataServiceImpl implements IProductModifyDataService 
{
    @Autowired
    private ProductModifyDataMapper productModifyDataMapper;

    /**
     * 查询产品制造变更数据
     * 
     * @param id 产品制造变更数据主键
     * @return 产品制造变更数据
     */
    @Override
    public ProductModifyData selectProductModifyDataById(Long id)
    {
        return productModifyDataMapper.selectProductModifyDataById(id);
    }

    /**
     * 查询产品制造变更数据列表
     * 
     * @param productModifyData 产品制造变更数据
     * @return 产品制造变更数据
     */
    @Override
    public List<ProductModifyData> selectProductModifyDataList(ProductModifyData productModifyData)
    {
        return productModifyDataMapper.selectProductModifyDataList(productModifyData);
    }

    /**
     * 新增产品制造变更数据
     * 
     * @param productModifyData 产品制造变更数据
     * @return 结果
     */
    @Override
    public int insertProductModifyData(ProductModifyData productModifyData)
    {
        return productModifyDataMapper.insertProductModifyData(productModifyData);
    }

    /**
     * 修改产品制造变更数据
     * 
     * @param productModifyData 产品制造变更数据
     * @return 结果
     */
    @Override
    public int updateProductModifyData(ProductModifyData productModifyData)
    {
        return productModifyDataMapper.updateProductModifyData(productModifyData);
    }

    /**
     * 批量删除产品制造变更数据
     * 
     * @param ids 需要删除的产品制造变更数据主键
     * @return 结果
     */
    @Override
    public int deleteProductModifyDataByIds(Long[] ids)
    {
        return productModifyDataMapper.deleteProductModifyDataByIds(ids);
    }

    /**
     * 删除产品制造变更数据信息
     * 
     * @param id 产品制造变更数据主键
     * @return 结果
     */
    @Override
    public int deleteProductModifyDataById(Long id)
    {
        return productModifyDataMapper.deleteProductModifyDataById(id);
    }
}
