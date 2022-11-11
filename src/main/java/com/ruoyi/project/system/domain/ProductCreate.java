package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 产品制造数据对象 product_create_5
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
public class ProductCreate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 产品型号 */
    @Excel(name = "产品型号")
    private String productModel;

    /** 产品制造单位 */
    @Excel(name = "产品制造单位")
    private String productManufacturer;

    /** 产品制造批次 */
    @Excel(name = "产品制造批次")
    private Long productBatch;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductModel(String productModel) 
    {
        this.productModel = productModel;
    }

    public String getProductModel() 
    {
        return productModel;
    }
    public void setProductManufacturer(String productManufacturer) 
    {
        this.productManufacturer = productManufacturer;
    }

    public String getProductManufacturer() 
    {
        return productManufacturer;
    }
    public void setProductBatch(Long productBatch) 
    {
        this.productBatch = productBatch;
    }

    public Long getProductBatch() 
    {
        return productBatch;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productName", getProductName())
            .append("productModel", getProductModel())
            .append("productManufacturer", getProductManufacturer())
            .append("productBatch", getProductBatch())
            .toString();
    }
}
