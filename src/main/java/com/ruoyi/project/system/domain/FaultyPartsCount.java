package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

/**
 * @Title:
 * @Description:
 * @Date 2022/11/14
 * @Author guohuijia
 * @Version 1.0
 */
public class FaultyPartsCount {
    @Excel(name = "型号-名称")
    private String partsModelName;

    @Excel(name = "数量")
    private int partsCount;

    @Excel(name = "故障件发生数占比")
    private int partsProportion;

    public String getPartsModelName() {
        return partsModelName;
    }

    public void setPartsModelName(String partsModelName) {
        this.partsModelName = partsModelName;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }

    public int getPartsProportion() {
        return partsProportion;
    }

    public void setPartsProportion(int partsProportion) {
        this.partsProportion = partsProportion;
    }
}
