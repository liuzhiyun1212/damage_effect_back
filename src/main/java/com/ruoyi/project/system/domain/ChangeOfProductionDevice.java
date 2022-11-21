package com.ruoyi.project.system.domain;

import java.util.List;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/11/21
 */
public class ChangeOfProductionDevice {
    private String id;
    private String planeType;
    private String partsCode;
    private String partsMakePeople;
    //生产设备人员列表
    private List partsMakePeopleList;
    //生产设备故障人员列表
    private List partsFaultPeopleList;
    private String partsMakeQuipment;
    private List partsMakeQuipmentList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public String getPartsCode() {
        return partsCode;
    }

    public void setPartsCode(String partsCode) {
        this.partsCode = partsCode;
    }

    public String getPartsMakePeople() {
        return partsMakePeople;
    }

    public void setPartsMakePeople(String partsMakePeople) {
        this.partsMakePeople = partsMakePeople;
    }

    public String getPartsMakeQuipment() {
        return partsMakeQuipment;
    }

    public void setPartsMakeQuipment(String partsMakeQuipment) {
        this.partsMakeQuipment = partsMakeQuipment;
    }

    public List getPartsMakePeopleList() {
        return partsMakePeopleList;
    }

    public void setPartsMakePeopleList(List partsMakePeopleList) {
        this.partsMakePeopleList = partsMakePeopleList;
    }

    public List getPartsMakeQuipmentList() {
        return partsMakeQuipmentList;
    }

    public void setPartsMakeQuipmentList(List partsMakeQuipmentList) {
        this.partsMakeQuipmentList = partsMakeQuipmentList;
    }

    public List getPartsFaultPeopleList() {
        return partsFaultPeopleList;
    }

    public void setPartsFaultPeopleList(List partsFaultPeopleList) {
        this.partsFaultPeopleList = partsFaultPeopleList;
    }
}
