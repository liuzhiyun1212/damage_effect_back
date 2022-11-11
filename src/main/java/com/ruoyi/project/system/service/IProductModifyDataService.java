package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.ProductModifyData;

/**
 * 产品制造变更数据Service接口
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
public interface IProductModifyDataService 
{
    /**
     * 查询产品制造变更数据
     * 
     * @param id 产品制造变更数据主键
     * @return 产品制造变更数据
     */
    public ProductModifyData selectProductModifyDataById(Long id);

    /**
     * 查询产品制造变更数据列表
     * 
     * @param productModifyData 产品制造变更数据
     * @return 产品制造变更数据集合
     */
    public List<ProductModifyData> selectProductModifyDataList(ProductModifyData productModifyData);

    /**
     * 新增产品制造变更数据
     * 
     * @param productModifyData 产品制造变更数据
     * @return 结果
     */
    public int insertProductModifyData(ProductModifyData productModifyData);

    /**
     * 修改产品制造变更数据
     * 
     * @param productModifyData 产品制造变更数据
     * @return 结果
     */
    public int updateProductModifyData(ProductModifyData productModifyData);

    /**
     * 批量删除产品制造变更数据
     * 
     * @param ids 需要删除的产品制造变更数据主键集合
     * @return 结果
     */
    public int deleteProductModifyDataByIds(Long[] ids);

    /**
     * 删除产品制造变更数据信息
     * 
     * @param id 产品制造变更数据主键
     * @return 结果
     */
    public int deleteProductModifyDataById(Long id);
}
