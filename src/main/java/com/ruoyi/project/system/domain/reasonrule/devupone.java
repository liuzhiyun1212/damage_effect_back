package com.ruoyi.project.system.domain.reasonrule;

public class devupone {

    /** 机型 */
    private String planeType;

    /** 发生时间 */
    private String devHappenTime;

    private int devHappennum;

    /** 故障模式 */
    private String faultModel;

    /** 型号系列 */
    private String modelSeries;

    /** 能力状态 */
    private String capabilityStatus;

    /** 装备出厂编号 */
    private String devCode;

    /** 成品件安装方法 */
    private String installMethod;

    /** 成品件安装方法 */
    private String installWhere;

    /** 故障件名称 */
    private String partsName;

    /** 故障件型号 */
    private String partsModel;

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

    public void setInstallWhere(String installWhere)
    {
        this.installWhere = installWhere;
    }

    public String getInstallWhere()
    {
        return installWhere;
    }

    public void setInstallMethod(String installMethod)
    {
        this.installMethod = installMethod;
    }

    public String getInstallMethod()
    {
        return installMethod;
    }

    public void setDevCode(String devCode)
    {
        this.devCode = devCode;
    }

    public String getDevCode()
    {
        return devCode;
    }

    public void setFaultModel(String faultModel)
    {
        this.faultModel = faultModel;
    }

    public String getFaultModel()
    {
        return faultModel;
    }

    public void setPlaneType(String planeType)
    {
        this.planeType = planeType;
    }

    public String getPlaneType()
    {
        return planeType;
    }

    public void setDevHappenTime(String devHappenTime)
    {
        this.devHappenTime = devHappenTime;
    }

    public String getDevHappenTime()
    {
        return devHappenTime;
    }

    public void setdevHappennum(int devHappenTime)
    {
        this.devHappennum = devHappenTime;
    }

    public int getdevHappennum()
    {
        return devHappennum;
    }

    public void setModelSeries(String modelSeries)
    {
        this.modelSeries = modelSeries;
    }

    public String getModelSeries()
    {
        return modelSeries;
    }

    public void setCapabilityStatus(String capabilityStatus)
    {
        this.capabilityStatus = capabilityStatus;
    }

    public String getCapabilityStatus()
    {
        return capabilityStatus;
    }
}
