package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 parts_repair_num_13
 * 
 * @author ruoyi
 * @date 2022-12-02
 */
public class PartsRepairNum13 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String planeType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String partsName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String partsModel;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String partsCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date partsFactoryTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String partsManufacture;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String partsRepairGroup;

    /** 产品维修班组 */
    @Excel(name = "产品维修班组")
    private String partsRepairPeople;

    /** 产品维修人员 */
    @Excel(name = "产品维修人员")
    private String partsRepairQuipment;

    /** 产品加工设备 */
    @Excel(name = "产品加工设备")
    private String partsMeasuringQuipment;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String rawMaterialPlace;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sparePartsPlace;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String partsMakeWorkmanship;

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
    public void setPartsName(String partsName) 
    {
        this.partsName = partsName;
    }

    public String getPartsName() 
    {
        return partsName;
    }
    public void setPartsModel(String partsModel) 
    {
        this.partsModel = partsModel;
    }

    public String getPartsModel() 
    {
        return partsModel;
    }
    public void setPartsCode(String partsCode) 
    {
        this.partsCode = partsCode;
    }

    public String getPartsCode() 
    {
        return partsCode;
    }
    public void setPartsFactoryTime(Date partsFactoryTime) 
    {
        this.partsFactoryTime = partsFactoryTime;
    }

    public Date getPartsFactoryTime() 
    {
        return partsFactoryTime;
    }
    public void setPartsManufacture(String partsManufacture) 
    {
        this.partsManufacture = partsManufacture;
    }

    public String getPartsManufacture() 
    {
        return partsManufacture;
    }
    public void setPartsRepairGroup(String partsRepairGroup) 
    {
        this.partsRepairGroup = partsRepairGroup;
    }

    public String getPartsRepairGroup() 
    {
        return partsRepairGroup;
    }
    public void setPartsRepairPeople(String partsRepairPeople) 
    {
        this.partsRepairPeople = partsRepairPeople;
    }

    public String getPartsRepairPeople() 
    {
        return partsRepairPeople;
    }
    public void setPartsRepairQuipment(String partsRepairQuipment) 
    {
        this.partsRepairQuipment = partsRepairQuipment;
    }

    public String getPartsRepairQuipment() 
    {
        return partsRepairQuipment;
    }
    public void setPartsMeasuringQuipment(String partsMeasuringQuipment) 
    {
        this.partsMeasuringQuipment = partsMeasuringQuipment;
    }

    public String getPartsMeasuringQuipment() 
    {
        return partsMeasuringQuipment;
    }
    public void setRawMaterialPlace(String rawMaterialPlace) 
    {
        this.rawMaterialPlace = rawMaterialPlace;
    }

    public String getRawMaterialPlace() 
    {
        return rawMaterialPlace;
    }
    public void setSparePartsPlace(String sparePartsPlace) 
    {
        this.sparePartsPlace = sparePartsPlace;
    }

    public String getSparePartsPlace() 
    {
        return sparePartsPlace;
    }
    public void setPartsMakeWorkmanship(String partsMakeWorkmanship) 
    {
        this.partsMakeWorkmanship = partsMakeWorkmanship;
    }

    public String getPartsMakeWorkmanship() 
    {
        return partsMakeWorkmanship;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planeType", getPlaneType())
            .append("partsName", getPartsName())
            .append("partsModel", getPartsModel())
            .append("partsCode", getPartsCode())
            .append("partsFactoryTime", getPartsFactoryTime())
            .append("partsManufacture", getPartsManufacture())
            .append("partsRepairGroup", getPartsRepairGroup())
            .append("partsRepairPeople", getPartsRepairPeople())
            .append("partsRepairQuipment", getPartsRepairQuipment())
            .append("partsMeasuringQuipment", getPartsMeasuringQuipment())
            .append("rawMaterialPlace", getRawMaterialPlace())
            .append("sparePartsPlace", getSparePartsPlace())
            .append("partsMakeWorkmanship", getPartsMakeWorkmanship())
            .toString();
    }
}
