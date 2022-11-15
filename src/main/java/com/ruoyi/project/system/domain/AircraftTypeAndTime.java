package com.ruoyi.project.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/11/10
 */
public class AircraftTypeAndTime extends QualityProblem {
    private String quarter;
    private Long num = 0L;
    private String checkedMethod;
    private String checkedMethodName;

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getCheckedMethod() {
        return checkedMethod;
    }

    public void setCheckedMethod(String checkedMethod) {
        this.checkedMethod = checkedMethod;
    }

    public String getCheckedMethodName() {
        return checkedMethodName;
    }

    public void setCheckedMethodName(String checkedMethodName) {
        this.checkedMethodName = checkedMethodName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("planeType", getPlaneType())
                .append("devCode", getDevCode())
                .append("devUnit", getDevUnit())
                .append("devManufacture", getDevManufacture())
                .append("devFactoryTime", getDevFactoryTime())
                .append("devUseTime", getDevUseTime())
                .append("devHappenTime", getDevHappenTime())
                .append("partsType", getPartsType())
                .append("partsName", getPartsName())
                .append("partsModel", getPartsModel())
                .append("partsCode", getPartsCode())
                .append("partsUnit", getPartsUnit())
                .append("partsManufacture", getPartsManufacture())
                .append("partsFactoryTime", getPartsFactoryTime())
                .append("partsUseTime", getPartsUseTime())
                .append("faultPhenomenon", getFaultPhenomenon())
                .append("faultModel", getFaultModel())
                .append("environment", getEnvironment())
                .append("devRepaired", getDevRepaired())
                .append("repairedTime", getRepairedTime())
                .append("repairedFactory", getRepairedFactory())
                .append("repairedStaff", getRepairedStaff())
                .append("quarter", getQuarter())
                .append("num", getNum())
                .append("checkedMethod", getCheckedMethod())
                .append("checkedMethodName", getCheckedMethodName())
                .toString();
    }
}
