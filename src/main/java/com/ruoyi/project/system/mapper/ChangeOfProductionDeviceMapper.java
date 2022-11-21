package com.ruoyi.project.system.mapper;

import com.ruoyi.project.system.domain.ChangeOfProductionDevice;

import java.util.List;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/11/21
 */
public interface ChangeOfProductionDeviceMapper {
    public List<ChangeOfProductionDevice> selectProducedList();
    
    public List<ChangeOfProductionDevice> selectFaultList();
}
