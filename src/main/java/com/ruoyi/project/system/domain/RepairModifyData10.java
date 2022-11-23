package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 repair_modify_data_10
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
public class RepairModifyData10 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Integer id;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String partsName;

    /** 产品型号 */
    @Excel(name = "产品型号")
    private String partsModel;

    /** 变更时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "变更时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 变更类型 */
    @Excel(name = "变更类型")
    private String modifyType;

    /** 变更方式 */
    @Excel(name = "变更方式")
    private String modifyMethod;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
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
            .append("partsName", getPartsName())
            .append("partsModel", getPartsModel())
            .append("modifyTime", getModifyTime())
            .append("modifyType", getModifyType())
            .append("modifyMethod", getModifyMethod())
            .toString();
    }
}
