package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.ProductModifyData;
import io.lettuce.core.dynamic.annotation.Param;

/**
 * 产品制造变更数据Mapper接口
 *
 * @author ruoyi
 * @date 2022-11-11
 */
public interface ProductModifyDataMapper
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
     * 删除产品制造变更数据
     *
     * @param id 产品制造变更数据主键
     * @return 结果
     */
    public int deleteProductModifyDataById(Long id);

    /**
     * 批量删除产品制造变更数据
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductModifyDataByIds(Long[] ids);
}
