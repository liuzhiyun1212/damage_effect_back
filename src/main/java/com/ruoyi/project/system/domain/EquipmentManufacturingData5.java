package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 equipment_manufacturing_data5
 * 
 * @author ruoyi
 * @date 2022-11-16
 */
public class EquipmentManufacturingData5 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 机型 */
    @Excel(name = "机型")
    private String planeType;

    /** 装备出厂编号 */
    @Excel(name = "装备出厂编号")
    private String devCode;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 生产/升级时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产/升级时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productionUpgradeTime;

    /** 装备制造单位 */
    @Excel(name = "装备制造单位")
    private String devUnit;

    /** 装备制造批次 */
    @Excel(name = "装备制造批次")
    private String devManufacture;

    /** 能力状态 */
    @Excel(name = "能力状态")
    private String capabilityStatus;

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
    public void setDevCode(String devCode) 
    {
        this.devCode = devCode;
    }

    public String getDevCode() 
    {
        return devCode;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setProductionUpgradeTime(Date productionUpgradeTime) 
    {
        this.productionUpgradeTime = productionUpgradeTime;
    }

    public Date getProductionUpgradeTime() 
    {
        return productionUpgradeTime;
    }
    public void setDevUnit(String devUnit) 
    {
        this.devUnit = devUnit;
    }

    public String getDevUnit() 
    {
        return devUnit;
    }
    public void setDevManufacture(String devManufacture) 
    {
        this.devManufacture = devManufacture;
    }

    public String getDevManufacture() 
    {
        return devManufacture;
    }
    public void setCapabilityStatus(String capabilityStatus) 
    {
        this.capabilityStatus = capabilityStatus;
    }

    public String getCapabilityStatus() 
    {
        return capabilityStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planeType", getPlaneType())
            .append("devCode", getDevCode())
            .append("type", getType())
            .append("productionUpgradeTime", getProductionUpgradeTime())
            .append("devUnit", getDevUnit())
            .append("devManufacture", getDevManufacture())
            .append("capabilityStatus", getCapabilityStatus())
            .toString();
    }
}
