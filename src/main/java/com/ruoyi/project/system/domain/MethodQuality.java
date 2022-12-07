package com.ruoyi.project.system.domain;

public class MethodQuality {
    private String finishedName;
    private String finishedModel;
    private String installMethod;
    private int methodNum;

    @Override
    public String toString() {
        return "MethodQuality{" +
                "finishedName='" + finishedName + '\'' +
                ", finishedModel='" + finishedModel + '\'' +
                ", installMethod='" + installMethod + '\'' +
                ", methodNum=" + methodNum +
                '}';
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

    public String getInstallMethod() {
        return installMethod;
    }

    public void setInstallMethod(String installMethod) {
        this.installMethod = installMethod;
    }

    public int getMethodNum() {
        return methodNum;
    }

    public void setMethodNum(int methodNum) {
        this.methodNum = methodNum;
    }
}
