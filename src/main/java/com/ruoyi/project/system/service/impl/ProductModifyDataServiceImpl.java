package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.ProductModify;
import com.ruoyi.project.system.domain.ProductModifyData;
import com.ruoyi.project.system.mapper.ProductModifyDataMapper;
import com.ruoyi.project.system.service.IProductModifyDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

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

    /**
     * @Description导入产品制造变更数据
     * @Author guohuijia
     * @Date  2022/11/13
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @Override
    public String importData(List<ProductModifyData> dataManagementList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dataManagementList) || dataManagementList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<ProductModifyData> existList = selectProductModifyDataList(null);
        for (ProductModifyData importData : dataManagementList)
        {
            try {
                insertProductModifyData((importData));
                successNum++;
                successMsg.append("<br/>" + successNum + "、数据 " + importData.getProductName() + " 导入成功");
            }catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、数据 " + importData.getProductName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    /**
     * @Description 装备零部件供应商变更时间线
     * @Author guohuijia
     * @Date  2022/12/3
     * @Param []
     * @Return java.util.List<com.ruoyi.project.system.domain.ProductModify>
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @Override
    public List<ProductModify> selectPartsManufactureChange() {
        return productModifyDataMapper.selectPartsManufactureChange();
    }
}
