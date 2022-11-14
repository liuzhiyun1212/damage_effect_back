package com.ruoyi.project.system.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);


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

    /**
     * @Description导入产品制造数据
     * @Author guohuijia
     * @Date  2022/11/13
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @Override
    public String importData(List<ProductCreate> dataManagementList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dataManagementList) || dataManagementList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<ProductCreate> existList = selectProductCreateList(null);
        for (ProductCreate importData : dataManagementList)
        {
            try {
                insertProductCreate((importData));
                successNum++;
                successMsg.append("<br/>" + successNum + "、数据 " + importData.getProductName() + " 导入成功");
            }catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + importData.getProductName() + " 导入失败：";
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
