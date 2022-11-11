package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 产品改型数据对象 product_modify_4
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
public class ProductModify extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 机型 */
    @Excel(name = "机型")
    private String planeType;

    /** 产品种类 */
    @Excel(name = "产品种类")
    private String productType;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 产品型号 */
    @Excel(name = "产品型号")
    private String productModel;

    /** 产品改型时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "产品改型时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 成品件改型措施 */
    @Excel(name = "成品件改型措施")
    private String modifyMeasures;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPlaneType(String planeType) 
    {
        this.planeType = planeType;
    }

    public String getPlaneType() 
    {
        return planeType;
    }
    public void setProductType(String productType) 
    {
        this.productType = productType;
    }

    public String getProductType() 
    {
        return productType;
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
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }
    public void setModifyMeasures(String modifyMeasures) 
    {
        this.modifyMeasures = modifyMeasures;
    }

    public String getModifyMeasures() 
    {
        return modifyMeasures;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planeType", getPlaneType())
            .append("productType", getProductType())
            .append("productName", getProductName())
            .append("productModel", getProductModel())
            .append("modifyTime", getModifyTime())
            .append("modifyMeasures", getModifyMeasures())
            .toString();
    }
}
