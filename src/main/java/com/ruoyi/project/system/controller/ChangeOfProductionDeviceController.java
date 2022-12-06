package com.ruoyi.project.system.controller;

import cn.hutool.json.JSONObject;
import com.ruoyi.framework.web.domain.R;
import com.ruoyi.project.system.service.IChangeOfProductionDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/11/21
 */
@RestController
@RequestMapping("/qualityChange/")
public class ChangeOfProductionDeviceController {
    @Autowired
    IChangeOfProductionDeviceService deviceService;

    @GetMapping("/changeOfProductionDevice/getChartData")
    public R<JSONObject> getProductionDeviceChartList() {
        return R.ok(deviceService.getProductionDeviceChartList());
    }

    @GetMapping("/changeOfMeasuringDevice/getMeasuringDeviceChart")
    public R<JSONObject> getMeasuringDeviceChartList() {
        return R.ok(deviceService.getMeasuringDeviceChartList());
    }

    @GetMapping("/changeOfRepairDevice/getRepairDeviceChart")
    public R<JSONObject> getRepairDeviceChartList() throws Exception {
        return R.ok(deviceService.getRepairDeviceChartList());
    }
}
