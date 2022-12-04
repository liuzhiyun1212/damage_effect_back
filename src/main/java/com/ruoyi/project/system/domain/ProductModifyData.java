package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 产品制造变更数据对象 product_modify_data_6
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
public class ProductModifyData extends BaseEntity
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

    /** 装备改型时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 变更类型 */
    @Excel(name = "变更类型")
    private String modifyType;

    /** 变更方式 */
    @Excel(name = "变更方式")
    private String modifyMethod;

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
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }
    public void setModifyType(String modifyType) 
    {
        this.modifyType = modifyType;
    }

    public String getModifyType() 
    {
        return modifyType;
    }
    public void setModifyMethod(String modifyMethod) 
    {
        this.modifyMethod = modifyMethod;
    }

    public String getModifyMethod() 
    {
        return modifyMethod;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productName", getProductName())
            .append("productModel", getProductModel())
            .append("modifyTime", getModifyTime())
            .append("modifyType", getModifyType())
            .append("modifyMethod", getModifyMethod())
            .toString();
    }
}
