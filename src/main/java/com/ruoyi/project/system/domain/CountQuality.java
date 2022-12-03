package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

public class CountQuality {
    /** 产品名称 */
    private String partsName;

    /** 产品型号 */
    private String partsModel;

    /** 数量 */
    private int partsNum;

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public String getPartsModel() {
        return partsModel;
    }

    public void setPartsModel(String partsModel) {
        this.partsModel = partsModel;
    }

    public int getPartsNum() {
        return partsNum;
    }

    public void setPartsNum(int partsNum) {
        this.partsNum = partsNum;
    }

    @Override
    public String toString() {
        return "CountQuality{" +
                "partsName='" + partsName + '\'' +
                ", partsModel='" + partsModel + '\'' +
                ", partsNum=" + partsNum +
                '}';
    }
}
