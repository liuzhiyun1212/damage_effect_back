package com.ruoyi.project.system.mapper;

import com.ruoyi.project.system.domain.ChangeOfProductionDevice;

import java.util.List;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/11/21
 */
public interface ChangeOfProductionDeviceMapper {
    //查询生产设备
    public List<ChangeOfProductionDevice> selectProducedList();

    //查询生产有事故的生产设备
    public List<ChangeOfProductionDevice> selectFaultList();

    //查询测量设备
    public List<ChangeOfProductionDevice> selectMeasuringDeviceList();

    //查询测量了发生了故障的装备的测量设备
    public List<ChangeOfProductionDevice> selectFaultMeasuringDeviceList();

    //查询测量设备
    public List<ChangeOfProductionDevice> selectRepairDeviceList();

    //查询测量了发生了故障的装备的测量设备
    public List<ChangeOfProductionDevice> selectFaultRepairDeviceList();
}
