package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 8:装备部署数据对象 equipment_deployment_data_11
 * 
 * @author ruoyi
 * @date 2022-11-18
 */
public class EquipmentDeploymentData11 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 机型 */
    @Excel(name = "机型")
    private String planeType;

    /** 部队 */
    @Excel(name = "部队")
    private String troops;

    /** 部署时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "部署时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deploymentTime;

    /** 部署数量 */
    @Excel(name = "部署数量")
    private Long deploymentQuantity;

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
    public void setTroops(String troops) 
    {
        this.troops = troops;
    }

    public String getTroops() 
    {
        return troops;
    }
    public void setDeploymentTime(Date deploymentTime) 
    {
        this.deploymentTime = deploymentTime;
    }

    public Date getDeploymentTime() 
    {
        return deploymentTime;
    }
    public void setDeploymentQuantity(Long deploymentQuantity) 
    {
        this.deploymentQuantity = deploymentQuantity;
    }

    public Long getDeploymentQuantity() 
    {
        return deploymentQuantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planeType", getPlaneType())
            .append("troops", getTroops())
            .append("deploymentTime", getDeploymentTime())
            .append("deploymentQuantity", getDeploymentQuantity())
            .toString();
    }
}
