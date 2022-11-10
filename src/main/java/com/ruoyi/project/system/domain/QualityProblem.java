package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * quality_problem对象 quality_problem_1
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
public class QualityProblem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 质量问题标题 */
    @Excel(name = "质量问题标题")
    private String title;

    /** 机型 */
    @Excel(name = "机型")
    private String planeType;

    /** 装备出厂编号 */
    @Excel(name = "装备出厂编号")
    private String devCode;

    /** 装备制造单位 */
    @Excel(name = "装备制造单位")
    private String devUnit;

    /** 装备制造批次 */
    @Excel(name = "装备制造批次")
    private String devManufacture;

    /** 装备出厂时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "装备出厂时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date devFactoryTime;

    /** 装备使用时长 */
    @Excel(name = "装备使用时长")
    private String devUseTime;

    /** 发生时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发生时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date devHappenTime;

    /** 故障件种类 */
    @Excel(name = "故障件种类")
    private String partsType;

    /** 故障件名称 */
    @Excel(name = "故障件名称")
    private String partsName;

    /** 故障件型号 */
    @Excel(name = "故障件型号")
    private String partsModel;

    /** 故障件出厂编号 */
    @Excel(name = "故障件出厂编号")
    private String partsCode;

    /** 故障件制造单位 */
    @Excel(name = "故障件制造单位")
    private String partsUnit;

    /** 故障件制造批次 */
    @Excel(name = "故障件制造批次")
    private String partsManufacture;

    /** 故障件出厂时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "故障件出厂时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date partsFactoryTime;

    /** 故障件使用时长 */
    @Excel(name = "故障件使用时长")
    private String partsUseTime;

    /** 故障现象 */
    @Excel(name = "故障现象")
    private String faultPhenomenon;

    /** 故障模式 */
    @Excel(name = "故障模式")
    private String faultModel;

    /** 发生地理环境 */
    @Excel(name = "发生地理环境")
    private String environment;

    /** 装备是否进行过大修 */
    @Excel(name = "装备是否进行过大修")
    private String devRepaired;

    /** 大修时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "大修时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date repairedTime;

    /** 大修厂 */
    @Excel(name = "大修厂")
    private String repairedFactory;

    /** 大修人员 */
    @Excel(name = "大修人员")
    private String repairedStaff;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
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
    public void setDevFactoryTime(Date devFactoryTime) 
    {
        this.devFactoryTime = devFactoryTime;
    }

    public Date getDevFactoryTime() 
    {
        return devFactoryTime;
    }
    public void setDevUseTime(String devUseTime) 
    {
        this.devUseTime = devUseTime;
    }

    public String getDevUseTime() 
    {
        return devUseTime;
    }
    public void setDevHappenTime(Date devHappenTime) 
    {
        this.devHappenTime = devHappenTime;
    }

    public Date getDevHappenTime() 
    {
        return devHappenTime;
    }
    public void setPartsType(String partsType) 
    {
        this.partsType = partsType;
    }

    public String getPartsType() 
    {
        return partsType;
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
    public void setPartsUnit(String partsUnit) 
    {
        this.partsUnit = partsUnit;
    }

    public String getPartsUnit() 
    {
        return partsUnit;
    }
    public void setPartsManufacture(String partsManufacture) 
    {
        this.partsManufacture = partsManufacture;
    }

    public String getPartsManufacture() 
    {
        return partsManufacture;
    }
    public void setPartsFactoryTime(Date partsFactoryTime) 
    {
        this.partsFactoryTime = partsFactoryTime;
    }

    public Date getPartsFactoryTime() 
    {
        return partsFactoryTime;
    }
    public void setPartsUseTime(String partsUseTime) 
    {
        this.partsUseTime = partsUseTime;
    }

    public String getPartsUseTime() 
    {
        return partsUseTime;
    }
    public void setFaultPhenomenon(String faultPhenomenon) 
    {
        this.faultPhenomenon = faultPhenomenon;
    }

    public String getFaultPhenomenon() 
    {
        return faultPhenomenon;
    }
    public void setFaultModel(String faultModel) 
    {
        this.faultModel = faultModel;
    }

    public String getFaultModel() 
    {
        return faultModel;
    }
    public void setEnvironment(String environment) 
    {
        this.environment = environment;
    }

    public String getEnvironment() 
    {
        return environment;
    }
    public void setDevRepaired(String devRepaired) 
    {
        this.devRepaired = devRepaired;
    }

    public String getDevRepaired() 
    {
        return devRepaired;
    }
    public void setRepairedTime(Date repairedTime) 
    {
        this.repairedTime = repairedTime;
    }

    public Date getRepairedTime() 
    {
        return repairedTime;
    }
    public void setRepairedFactory(String repairedFactory) 
    {
        this.repairedFactory = repairedFactory;
    }

    public String getRepairedFactory() 
    {
        return repairedFactory;
    }
    public void setRepairedStaff(String repairedStaff) 
    {
        this.repairedStaff = repairedStaff;
    }

    public String getRepairedStaff() 
    {
        return repairedStaff;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("planeType", getPlaneType())
            .append("devCode", getDevCode())
            .append("devUnit", getDevUnit())
            .append("devManufacture", getDevManufacture())
            .append("devFactoryTime", getDevFactoryTime())
            .append("devUseTime", getDevUseTime())
            .append("devHappenTime", getDevHappenTime())
            .append("partsType", getPartsType())
            .append("partsName", getPartsName())
            .append("partsModel", getPartsModel())
            .append("partsCode", getPartsCode())
            .append("partsUnit", getPartsUnit())
            .append("partsManufacture", getPartsManufacture())
            .append("partsFactoryTime", getPartsFactoryTime())
            .append("partsUseTime", getPartsUseTime())
            .append("faultPhenomenon", getFaultPhenomenon())
            .append("faultModel", getFaultModel())
            .append("environment", getEnvironment())
            .append("devRepaired", getDevRepaired())
            .append("repairedTime", getRepairedTime())
            .append("repairedFactory", getRepairedFactory())
            .append("repairedStaff", getRepairedStaff())
            .toString();
    }
}
