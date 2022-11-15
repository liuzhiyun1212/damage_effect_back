package com.ruoyi.project.system.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.R;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.AircraftTypeAndTime;
import com.ruoyi.project.system.service.IAircraftTypeAndTypeService;
import com.ruoyi.project.system.service.IQualityProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/11/10
 */
@RestController
@RequestMapping("/qualityAnalysis/")
public class AircraftTypeAndTypeController extends BaseController {
    @Autowired
    IAircraftTypeAndTypeService aircraftTypeAndTypeService;

    @Autowired
    IQualityProblemService qualityProblemService;

    @GetMapping("/aircraftTypeWithTime/getCheckList")
    public TableDataInfo getCheckList(AircraftTypeAndTime aircraftTypeAndTime) {
        List<AircraftTypeAndTime> list;
        list = aircraftTypeAndTypeService.getCheckList(aircraftTypeAndTime);
        return getDataTable(list);
    }

    @GetMapping("/aircraftTypeWithTime/getChartData")
    public R getChartData() {
        return R.ok(aircraftTypeAndTypeService.getChartData());
    }
}
