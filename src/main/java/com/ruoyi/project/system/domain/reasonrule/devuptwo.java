package com.ruoyi.project.system.domain.reasonrule;

public class devuptwo {

    /** 机型 */
    private String planeType;

    /** 发生时间 */
    private String devHappenTime;

    private int devHappennum;

    /** 型号系列 */
    private String modelSeries;

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
}
