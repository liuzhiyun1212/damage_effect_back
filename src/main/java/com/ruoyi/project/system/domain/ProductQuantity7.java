package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 7：产品生产数量对象 product_quantity_7
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
public class ProductQuantity7 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 机型 */
    @Excel(name = "机型")
    private String planeType;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 产品型号 */
    @Excel(name = "产品型号")
    private String productModel;

    /** 产品出厂编号 */
    @Excel(name = "产品出厂编号")
    private String productFactoryNumber;

    /** 产品出厂时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "产品出厂时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productFactoryDate;

    /** 产品批次 */
    @Excel(name = "产品批次")
    private String productBatch;

    /** 产品制造班组 */
    @Excel(name = "产品制造班组")
    private String productMakeGroup;

    /** 产品制造人员 */
    @Excel(name = "产品制造人员")
    private String productMakePeople;

    /** 产品加工设备 */
    @Excel(name = "产品加工设备")
    private String productProcessEquipment;

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
    public void setProductFactoryNumber(String productFactoryNumber) 
    {
        this.productFactoryNumber = productFactoryNumber;
    }

    public String getProductFactoryNumber() 
    {
        return productFactoryNumber;
    }
    public void setProductFactoryDate(Date productFactoryDate) 
    {
        this.productFactoryDate = productFactoryDate;
    }

    public Date getProductFactoryDate() 
    {
        return productFactoryDate;
    }
    public void setProductBatch(String productBatch) 
    {
        this.productBatch = productBatch;
    }

    public String getProductBatch() 
    {
        return productBatch;
    }
    public void setProductMakeGroup(String productMakeGroup) 
    {
        this.productMakeGroup = productMakeGroup;
    }

    public String getProductMakeGroup() 
    {
        return productMakeGroup;
    }
    public void setProductMakePeople(String productMakePeople) 
    {
        this.productMakePeople = productMakePeople;
    }

    public String getProductMakePeople() 
    {
        return productMakePeople;
    }
    public void setProductProcessEquipment(String productProcessEquipment) 
    {
        this.productProcessEquipment = productProcessEquipment;
    }

    public String getProductProcessEquipment() 
    {
        return productProcessEquipment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planeType", getPlaneType())
            .append("productName", getProductName())
            .append("productModel", getProductModel())
            .append("productFactoryNumber", getProductFactoryNumber())
            .append("productFactoryDate", getProductFactoryDate())
            .append("productBatch", getProductBatch())
            .append("productMakeGroup", getProductMakeGroup())
            .append("productMakePeople", getProductMakePeople())
            .append("productProcessEquipment", getProductProcessEquipment())
            .toString();
    }
}
