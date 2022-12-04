package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.ProductModify;
import com.ruoyi.project.system.mapper.ProductModifyMapper;
import com.ruoyi.project.system.service.IProductModifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

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

    public List<ProductModify> selectProductchange() {
        return productModifyMapper.selectProductchange();
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

    /**
     * @Description导入产品改型数据
     * @Author guohuijia
     * @Date  2022/11/13
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @Override
    public String importData(List<ProductModify> dataManagementList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dataManagementList) || dataManagementList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<ProductModify> existList = selectProductModifyList(null);
        for (ProductModify importData : dataManagementList)
        {
            try {
                insertProductModify((importData));
                successNum++;
                successMsg.append("<br/>" + successNum + "、数据 " + importData.getPlaneType() + " 导入成功");
            }catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、数据 " + importData.getPlaneType() + " 导入失败：";
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
}
