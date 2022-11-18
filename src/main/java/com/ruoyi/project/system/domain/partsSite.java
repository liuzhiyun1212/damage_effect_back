package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

public class partsSite {

    private String finishedName;

    /** 成品件型号 */
    @Excel(name = "成品件型号")
    private String finishedModel;

    private String planeType;


    public String getInstallMethod() {
        return installMethod;
    }

    public void setInstallMethod(String installMethod) {
        this.installMethod = installMethod;
    }

    private String installMethod;

    private String devCode;

    /** 框 */
    @Excel(name = "框")
    private double frame;

    /** 上中下 */
    @Excel(name = "上中下")
    private double upperMiddleLower;

    /** 左中右 */
    @Excel(name = "左中右")
    private double leftMiddleRight;

    private Long num;

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }


    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
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

    public double getFrame() {
        return frame;
    }

    public void setFrame(double frame) {
        this.frame = frame;
    }

    public double getUpperMiddleLower() {
        return upperMiddleLower;
    }

    public void setUpperMiddleLower(double upperMiddleLower) {
        this.upperMiddleLower = upperMiddleLower;
    }

    public double getLeftMiddleRight() {
        return leftMiddleRight;
    }

    public void setLeftMiddleRight(double leftMiddleRight) {
        this.leftMiddleRight = leftMiddleRight;
    }


}
