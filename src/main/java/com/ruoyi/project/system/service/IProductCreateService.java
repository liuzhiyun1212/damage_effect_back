package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.ProductCreate;

/**
 * 产品制造数据Service接口
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
public interface IProductCreateService 
{
    /**
     * 查询产品制造数据
     * 
     * @param id 产品制造数据主键
     * @return 产品制造数据
     */
    public ProductCreate selectProductCreateById(Long id);

    /**
     * 查询产品制造数据列表
     * 
     * @param productCreate 产品制造数据
     * @return 产品制造数据集合
     */
    public List<ProductCreate> selectProductCreateList(ProductCreate productCreate);

    /**
     * 新增产品制造数据
     * 
     * @param productCreate 产品制造数据
     * @return 结果
     */
    public int insertProductCreate(ProductCreate productCreate);

    /**
     * 修改产品制造数据
     * 
     * @param productCreate 产品制造数据
     * @return 结果
     */
    public int updateProductCreate(ProductCreate productCreate);

    /**
     * 批量删除产品制造数据
     * 
     * @param ids 需要删除的产品制造数据主键集合
     * @return 结果
     */
    public int deleteProductCreateByIds(Long[] ids);

    /**
     * 删除产品制造数据信息
     * 
     * @param id 产品制造数据主键
     * @return 结果
     */
    public int deleteProductCreateById(Long id);
}
