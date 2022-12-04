package com.ruoyi.project.system.service;

import cn.hutool.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/11/21
 */
public interface IChangeOfProductionDeviceService {
    public JSONObject getProductionDeviceChartList();

    public JSONObject getMeasuringDeviceChartList();
}
