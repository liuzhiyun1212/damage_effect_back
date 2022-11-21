package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

public class PartsTypeCount {
    @Excel(name = "种类")
    private String partsType;

    @Excel(name = "数量")
    private int partsCount;

    @Excel(name = "故障件发生数占比")
    private String partsProportion;

    public String getPartsType() {
        return partsType;
    }

    public void setPartsType(String partsType) {
        this.partsType = partsType;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }

    public String getPartsProportion() {
        return partsProportion;
    }

    public void setPartsProportion(String partsProportion) {
        this.partsProportion = partsProportion;
    }


}
