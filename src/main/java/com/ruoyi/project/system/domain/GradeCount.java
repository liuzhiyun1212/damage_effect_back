package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

public class GradeCount {
    @Excel(name = "故障件名称")
    private String partsName;
    @Excel(name = "故障模式")
    private String faultModel;
    /** 产品制造班组 */
    @Excel(name = "产品制造班组")
    private String productMakeGroup;

    @Override
    public String toString() {
        return "GradeCount{" +
                "partsName='" + partsName + '\'' +
                ", faultModel='" + faultModel + '\'' +
                ", productMakeGroup='" + productMakeGroup + '\'' +
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

    public String getProductMakeGroup() {
        return productMakeGroup;
    }

    public void setProductMakeGroup(String productMakeGroup) {
        this.productMakeGroup = productMakeGroup;
    }
}
