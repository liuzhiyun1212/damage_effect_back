package com.ruoyi.project.system.domain.reasonrule;

public class devupone {

    /** 机型 */
    private String planeType;

    /** 发生时间 */
    private String devHappenTime;

    private int devHappennum;

    /** 故障模式 */
    private String faultModel;

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
}
