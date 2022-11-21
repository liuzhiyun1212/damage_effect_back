package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 9：装备使用数据对象 parts_make_num_9
 *
 * @author ruoyi
 * @date 2022-11-21
 */
public class PartsMakeNum9 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 机型 */
    @Excel(name = "机型")
    private String planeType;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String partsName;

    /** 产品型号 */
    @Excel(name = "产品型号")
    private String partsModel;

    /** 出厂编号 */
    @Excel(name = "出厂编号")
    private String partsCode;

    /** 出厂时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出厂时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date partsFactoryTime;

    /** 产品批次 */
    @Excel(name = "产品批次")
    private String partsManufacture;

    /** 制造班组 */
    @Excel(name = "制造班组")
    private String partsMakeGroup;

    /** 制造人员 */
    @Excel(name = "制造人员")
    private String partsMakePeople;

    /** 加工设备 */
    @Excel(name = "加工设备")
    private String partsMakeQuipment;

    /** 测量设备 */
    @Excel(name = "测量设备")
    private String partsMeasuringQuipment;

    /** 原材料来源 */
    @Excel(name = "原材料来源")
    private String rawMaterialPlace;

    /** 零部件来源 */
    @Excel(name = "零部件来源")
    private String sparePartsPlace;

    /** 生产工艺 */
    @Excel(name = "生产工艺")
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
    public void setPartsMakeGroup(String partsMakeGroup)
    {
        this.partsMakeGroup = partsMakeGroup;
    }

    public String getPartsMakeGroup()
    {
        return partsMakeGroup;
    }
    public void setPartsMakePeople(String partsMakePeople)
    {
        this.partsMakePeople = partsMakePeople;
    }

    public String getPartsMakePeople()
    {
        return partsMakePeople;
    }
    public void setPartsMakeQuipment(String partsMakeQuipment)
    {
        this.partsMakeQuipment = partsMakeQuipment;
    }

    public String getPartsMakeQuipment()
    {
        return partsMakeQuipment;
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
                .append("partsMakeGroup", getPartsMakeGroup())
                .append("partsMakePeople", getPartsMakePeople())
                .append("partsMakeQuipment", getPartsMakeQuipment())
                .append("partsMeasuringQuipment", getPartsMeasuringQuipment())
                .append("rawMaterialPlace", getRawMaterialPlace())
                .append("sparePartsPlace", getSparePartsPlace())
                .append("partsMakeWorkmanship", getPartsMakeWorkmanship())
                .toString();
    }
}
