package com.ruoyi.project.system.mapper;

import com.ruoyi.project.system.domain.AircraftTypeAndTime;
import com.ruoyi.project.system.domain.UseData;

import java.util.List;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/11/10
 */
public interface AircraftTypeAndTypeMapper {
    public List<AircraftTypeAndTime> selectQuarter();

    public List<UseData> selectUseTime();
}
