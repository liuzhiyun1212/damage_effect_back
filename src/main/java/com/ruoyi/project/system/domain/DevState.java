package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

public class DevState {
    @Excel(name = "故障件模式")
    private String partsModel;
    @Excel(name = "状态")
    private String state;

    @Override
    public String toString() {
        return "DevState{" +
                "partsModel='" + partsModel + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getPartsModel() {
        return partsModel;
    }

    public void setPartsModel(String partsModel) {
        this.partsModel = partsModel;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
