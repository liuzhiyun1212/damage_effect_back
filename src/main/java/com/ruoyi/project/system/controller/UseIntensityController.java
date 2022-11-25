package com.ruoyi.project.system.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.R;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.AircraftTypeAndTime;
import com.ruoyi.project.system.service.IAircraftTypeAndTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/11/15
 */
@RestController
@RequestMapping("/qualityAnalysis/")
public class UseIntensityController extends BaseController {
    @Autowired
    IAircraftTypeAndTypeService aircraftTypeAndTypeService;

    @GetMapping("/useIntensity/getCheckList")
    public TableDataInfo getUseIntensityCheckList(AircraftTypeAndTime aircraftTypeAndTime) {
        List<AircraftTypeAndTime> list;
        list = aircraftTypeAndTypeService.getCheckList(aircraftTypeAndTime);
        return getDataTable(list);
    }

    @GetMapping("/useIntensity/getChartData")
    public R getUseIntensityChartData() throws Exception {
        return R.ok(aircraftTypeAndTypeService.getUseIntensityChartData());
    }
}
