package com.ruoyi.project.system.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Date;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/11/28
 */
public class UseData extends BaseEntity {
    private Long id;
    private Date date;
    private String planeType;
    private String troops;
    private Long flightHours = 0L;
    private String year;
    private String quarter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public String getTroops() {
        return troops;
    }

    public void setTroops(String troops) {
        this.troops = troops;
    }

    public Long getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(Long flightHours) {
        this.flightHours = flightHours;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }
}
