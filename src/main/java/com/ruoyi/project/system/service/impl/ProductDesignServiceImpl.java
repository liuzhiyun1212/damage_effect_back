package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.ProductDesign;
import com.ruoyi.project.system.domain.install_way;
import com.ruoyi.project.system.domain.partsSite;
import com.ruoyi.project.system.mapper.ProductDesignMapper;
import com.ruoyi.project.system.service.IProductDesignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

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
     * 统计成品件的安装位置和该位置上成品件安装的数量
     *
     *
     * @return
     */
    @Override
    public List<partsSite> selectpartsSite()
    {
        return productDesignMapper.selectPartsSite();
    }


    @Override
    public List<ProductDesign> selectPartsinstall()
    {
        return productDesignMapper.selectPartsinstall();
    }


    @Override
    public List<partsSite> selectPartsqulitynum()
    {
        return productDesignMapper.selectPartsqulitynum();
    }


    @Override
    public List<partsSite> selectPartsinstallnum()
    {
        return productDesignMapper.selectPartsinstallnum();
    }


    @Override
    public List<install_way> selectinstallmethod()
    {
        return productDesignMapper.selectinstallmethod();
    }


    /**
     * 统计成品件的安装位置和该位置上成品件安装的数量
     *
     *
     * @return
     */
    @Override
    public List<partsSite> selectPartsSitenum()
    {
        return productDesignMapper.selectPartsSitenum();
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

    /**
     * @Description导入产品设计数据
     * @Author guohuijia
     * @Date  2022/11/13
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @Override
    public String importData(List<ProductDesign> dataManagementList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dataManagementList) || dataManagementList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<ProductDesign> existList = selectProductDesignList(null);
        for (ProductDesign importData : dataManagementList)
        {
            try {
                insertProductDesign((importData));
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
