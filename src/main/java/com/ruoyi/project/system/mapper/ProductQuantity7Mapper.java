package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.ProductQuantity7;

/**
 * 7：产品生产数量Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
public interface ProductQuantity7Mapper 
{
    /**
     * 查询7：产品生产数量
     * 
     * @param id 7：产品生产数量主键
     * @return 7：产品生产数量
     */
    public ProductQuantity7 selectProductQuantity7ById(Long id);

    /**
     * 查询7：产品生产数量列表
     * 
     * @param productQuantity7 7：产品生产数量
     * @return 7：产品生产数量集合
     */
    public List<ProductQuantity7> selectProductQuantity7List(ProductQuantity7 productQuantity7);

    /**
     * 新增7：产品生产数量
     * 
     * @param productQuantity7 7：产品生产数量
     * @return 结果
     */
    public int insertProductQuantity7(ProductQuantity7 productQuantity7);

    /**
     * 修改7：产品生产数量
     * 
     * @param productQuantity7 7：产品生产数量
     * @return 结果
     */
    public int updateProductQuantity7(ProductQuantity7 productQuantity7);

    /**
     * 删除7：产品生产数量
     * 
     * @param id 7：产品生产数量主键
     * @return 结果
     */
    public int deleteProductQuantity7ById(Long id);

    /**
     * 批量删除7：产品生产数量
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductQuantity7ByIds(Long[] ids);
}
