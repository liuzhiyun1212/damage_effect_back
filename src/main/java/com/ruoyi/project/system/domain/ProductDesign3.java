package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 成品件设计数据对象 product_design_3
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
public class ProductDesign3 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 机型 */
    @Excel(name = "机型")
    private String planeType;

    /** 成品件种类 */
    @Excel(name = "成品件种类")
    private String finishedType;

    /** 成品件名称 */
    @Excel(name = "成品件名称")
    private String finishedName;

    /** 成品件型号 */
    @Excel(name = "成品件型号")
    private String finishedModel;

    /** 成品件制造单位 */
    @Excel(name = "成品件制造单位")
    private String finishedManufacturer;

    /** 框 */
    @Excel(name = "框")
    private Long frame;

    /** 上中下 */
    @Excel(name = "上中下")
    private Long upperMiddleLower;

    /** 左中右 */
    @Excel(name = "左中右")
    private Long leftMiddleRight;

    /** 成品件安装方法 */
    @Excel(name = "成品件安装方法")
    private String installMethod;

    /** 原材料 */
    @Excel(name = "原材料")
    private String rawMaterial;

    /** 零部件 */
    @Excel(name = "零部件")
    private String spareParts;

    /** 成品件改型时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成品件改型时间", width = 30, dateFormat = "yyyy-MM-dd")
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
    public void setFinishedType(String finishedType) 
    {
        this.finishedType = finishedType;
    }

    public String getFinishedType() 
    {
        return finishedType;
    }
    public void setFinishedName(String finishedName) 
    {
        this.finishedName = finishedName;
    }

    public String getFinishedName() 
    {
        return finishedName;
    }
    public void setFinishedModel(String finishedModel) 
    {
        this.finishedModel = finishedModel;
    }

    public String getFinishedModel() 
    {
        return finishedModel;
    }
    public void setFinishedManufacturer(String finishedManufacturer) 
    {
        this.finishedManufacturer = finishedManufacturer;
    }

    public String getFinishedManufacturer() 
    {
        return finishedManufacturer;
    }
    public void setFrame(Long frame) 
    {
        this.frame = frame;
    }

    public Long getFrame() 
    {
        return frame;
    }
    public void setUpperMiddleLower(Long upperMiddleLower) 
    {
        this.upperMiddleLower = upperMiddleLower;
    }

    public Long getUpperMiddleLower() 
    {
        return upperMiddleLower;
    }
    public void setLeftMiddleRight(Long leftMiddleRight) 
    {
        this.leftMiddleRight = leftMiddleRight;
    }

    public Long getLeftMiddleRight() 
    {
        return leftMiddleRight;
    }
    public void setInstallMethod(String installMethod) 
    {
        this.installMethod = installMethod;
    }

    public String getInstallMethod() 
    {
        return installMethod;
    }
    public void setRawMaterial(String rawMaterial) 
    {
        this.rawMaterial = rawMaterial;
    }

    public String getRawMaterial() 
    {
        return rawMaterial;
    }
    public void setSpareParts(String spareParts) 
    {
        this.spareParts = spareParts;
    }

    public String getSpareParts() 
    {
        return spareParts;
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
            .append("finishedType", getFinishedType())
            .append("finishedName", getFinishedName())
            .append("finishedModel", getFinishedModel())
            .append("finishedManufacturer", getFinishedManufacturer())
            .append("frame", getFrame())
            .append("upperMiddleLower", getUpperMiddleLower())
            .append("leftMiddleRight", getLeftMiddleRight())
            .append("installMethod", getInstallMethod())
            .append("rawMaterial", getRawMaterial())
            .append("spareParts", getSpareParts())
            .append("modifyTime", getModifyTime())
            .append("modifyMeasures", getModifyMeasures())
            .toString();
    }
}
