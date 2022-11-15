package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 装备设计/改型数据对象 equipment_design_data
 *
 * @author ruoyi
 * @date 2022-11-15
 */
public class EquipmentDesignData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 机型 */
    @Excel(name = "机型")
    private String planeType;

    /** 装备改型时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "装备改型时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date remodelDate;

    /** 装备改型措施 */
    @Excel(name = "装备改型措施")
    private String remodelMeasure;

    /** 装备制造单位 */
    @Excel(name = "装备制造单位")
    private String makeUnit;

    /** 型号系列 */
    @Excel(name = "型号系列")
    private String modelSeries;

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
    public void setRemodelDate(Date remodelDate)
    {
        this.remodelDate = remodelDate;
    }

    public Date getRemodelDate()
    {
        return remodelDate;
    }
    public void setRemodelMeasure(String remodelMeasure)
    {
        this.remodelMeasure = remodelMeasure;
    }

    public String getRemodelMeasure()
    {
        return remodelMeasure;
    }
    public void setMakeUnit(String makeUnit)
    {
        this.makeUnit = makeUnit;
    }

    public String getMakeUnit()
    {
        return makeUnit;
    }
    public void setModelSeries(String modelSeries)
    {
        this.modelSeries = modelSeries;
    }

    public String getModelSeries()
    {
        return modelSeries;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("planeType", getPlaneType())
                .append("remodelDate", getRemodelDate())
                .append("remodelMeasure", getRemodelMeasure())
                .append("makeUnit", getMakeUnit())
                .append("modelSeries", getModelSeries())
                .toString();
    }
}
