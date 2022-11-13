package com.ruoyi.project.system.service;

import com.ruoyi.project.system.domain.AircraftTypeAndTime;

import java.util.List;
import java.util.Map;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/11/10
 */
public interface IAircraftTypeAndTypeService {
    public List getCheckList(AircraftTypeAndTime aircraftTypeAndTime);

    public Map getChartData();
}
