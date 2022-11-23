package com.ruoyi.project.system.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.ruoyi.project.system.domain.ChangeOfProductionDevice;
import com.ruoyi.project.system.mapper.ChangeOfProductionDeviceMapper;
import com.ruoyi.project.system.service.IChangeOfProductionDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/11/21
 */
@Service
public class ChangeOfProductionDeviceServiceImpl implements IChangeOfProductionDeviceService {
    @Autowired
    private ChangeOfProductionDeviceMapper changeOfProductionDeviceMapper;

    @Override
    public JSONObject getChartData() {
        //人员生产设备列表
        List<ChangeOfProductionDevice> producedList = changeOfProductionDeviceMapper.selectProducedList();

        //人员-生产设备数
        HashMap<String, Integer> makeWorkerMap = MapUtil.newHashMap();

        //统计人员生产数
        for (ChangeOfProductionDevice item : producedList) {
            List<String> partsMakePeopleList = new JSONArray(item.getPartsMakePeople()).toList(String.class);
            for (String name : partsMakePeopleList) {
                makeWorkerMap.put(name, 1 + makeWorkerMap.getOrDefault(name, 0));
            }
            item.setPartsMakePeopleList(partsMakePeopleList);
        }

        //人员生产故障设备列表
        List<ChangeOfProductionDevice> faultList = changeOfProductionDeviceMapper.selectFaultList();
        //人员-生产设备故障数
        HashMap<String, Integer> faultWorkerMap = MapUtil.newHashMap();
        //统计人员生产故障数
        for (ChangeOfProductionDevice item : faultList) {
            List<String> partsFaultPeopleList = new JSONArray(item.getPartsMakePeople()).toList(String.class);
            for (String name : partsFaultPeopleList) {
                faultWorkerMap.put(name, 1 + faultWorkerMap.getOrDefault(name, 0));
            }
            item.setPartsFaultPeopleList(partsFaultPeopleList);
        }

        //包装返回值
        JSONObject produceNumObj = new JSONObject();
        JSONObject faultNumObj = new JSONObject();
        JSONArray produceNumArray = new JSONArray();
        JSONArray faultNumArray = new JSONArray();
        JSONArray workerNameArray = new JSONArray();

        //生产人员名称和生产数量要一一对应
        Iterator<String> makeWorkerMapIterator = makeWorkerMap.keySet().iterator();
        while (makeWorkerMapIterator.hasNext()) {
            String workerName = makeWorkerMapIterator.next();
            //工人名列表
            workerNameArray.put(workerName);

            //根据工人放对应生产数\故障数
            produceNumArray.put(makeWorkerMap.get(workerName));
            faultNumArray.put(faultWorkerMap.get(workerName));
        }
        produceNumObj
                .set("name", "设备生产数")
                .set("type", "bar")
                .set("stack", "total")
                .set("label", new JSONObject().set("show", true))
                .set("emphasis", new JSONObject().set("focus", "series"))
                .set("data", produceNumArray);
        faultNumObj
                .set("name", "故障发生数")
                .set("type", "bar")
                .set("stack", "total")
                .set("label", new JSONObject().append("show", true))
                .set("emphasis", new JSONObject().append("focus", "series"))
                .set("data", faultNumArray);

        return new JSONObject()
                .set("workerNameArray", workerNameArray)
                .set("produceNumObj", produceNumObj)
                .set("faultNumObj", faultNumObj);
    }
}
