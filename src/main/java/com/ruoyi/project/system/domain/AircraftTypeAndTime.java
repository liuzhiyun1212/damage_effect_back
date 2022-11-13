package com.ruoyi.project.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/11/10
 */
public class AircraftTypeAndTime extends QualityProblem{
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
}
