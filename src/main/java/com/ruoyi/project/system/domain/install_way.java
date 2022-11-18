package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

public class install_way {
    private String finishedName;

    private String finishedModel;

    private Long num;

    private String installMethod;

    private double averge;

    public double getAverge() {
        return averge;
    }

    public void setAverge(double averge) {
        this.averge = averge;
    }


    public String getFinishedName() {
        return finishedName;
    }

    public void setFinishedName(String finishedName) {
        this.finishedName = finishedName;
    }

    public String getFinishedModel() {
        return finishedModel;
    }

    public void setFinishedModel(String finishedModel) {
        this.finishedModel = finishedModel;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getInstallMethod() {
        return installMethod;
    }

    public void setInstallMethod(String installMethod) {
        this.installMethod = installMethod;
    }



}
