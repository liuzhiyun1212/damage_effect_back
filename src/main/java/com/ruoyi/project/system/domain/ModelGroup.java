package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

public class ModelGroup {
    @Excel(name = "故障件名称")
    private String partsName;
    @Excel(name = "故障模式")
    private String faultModel;


    /** 产品维修班组 */
    @Excel(name = "产品维修班组")
    private String partsRepairGroup;

    @Override
    public String toString() {
        return "GradeCount{" +
                "partsName='" + partsName + '\'' +
                ", faultModel='" + faultModel + '\'' +
                ", partsRepairGroup='" + partsRepairGroup + '\'' +
                '}';
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public String getFaultModel() {
        return faultModel;
    }

    public void setFaultModel(String faultModel) {
        this.faultModel = faultModel;
    }

    public String getPartsRepairGroup() {
        return partsRepairGroup;
    }

    public void setPartsRepairGroup(String partsRepairGroup) {
        this.partsRepairGroup = partsRepairGroup;
    }

}
