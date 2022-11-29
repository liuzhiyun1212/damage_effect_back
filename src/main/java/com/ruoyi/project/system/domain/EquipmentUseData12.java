package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 12：装备使用数据对象 equipment_use_data_12
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
public class EquipmentUseData12 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 年月 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "年月", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 机型 */
    @Excel(name = "机型")
    private String planeType;

    /** 部队 */
    @Excel(name = "部队")
    private String troops;

    /** 飞行小时 */
    @Excel(name = "飞行小时")
    private Integer flightHours;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }
    public void setPlaneType(String planeType) 
    {
        this.planeType = planeType;
    }

    public String getPlaneType() 
    {
        return planeType;
    }
    public void setTroops(String troops) 
    {
        this.troops = troops;
    }

    public String getTroops() 
    {
        return troops;
    }
    public void setFlightHours(Integer flightHours) 
    {
        this.flightHours = flightHours;
    }

    public Integer getFlightHours() 
    {
        return flightHours;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("date", getDate())
            .append("planeType", getPlaneType())
            .append("troops", getTroops())
            .append("flightHours", getFlightHours())
            .toString();
    }
}
