package com.ruoyi.project.system.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.ruoyi.project.system.domain.ChangeOfProductionDevice;
import com.ruoyi.project.system.mapper.ChangeOfProductionDeviceMapper;
import com.ruoyi.project.system.service.IChangeOfProductionDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        HashMap<String, Integer> makeEquipmentMap = MapUtil.newHashMap();

        //统计人员生产数
        for (ChangeOfProductionDevice item : producedList) {
            String partsMakeQuipment = item.getPartsMakeQuipment();
            partsMakeQuipment = partsMakeQuipment.replace("[","").replace("]","");
            String[] splitStr = partsMakeQuipment.split(",");
            List<String> partsMakeEquipmentList = Arrays.asList(splitStr);
            for (String name : partsMakeEquipmentList) {
                makeEquipmentMap.put(name, 1 + makeEquipmentMap.getOrDefault(name, 0));
            }
            item.setPartsMakeQuipmentList(partsMakeEquipmentList);
        }

        //人员生产故障设备列表
        List<ChangeOfProductionDevice> faultList = changeOfProductionDeviceMapper.selectFaultList();
        //人员-生产设备故障数
        HashMap<String, Integer> faultWorkerMap = MapUtil.newHashMap();
        //统计人员生产故障数
        for (ChangeOfProductionDevice item : faultList) {
            String partsMakeQuipment = item.getPartsMakeQuipment();
            partsMakeQuipment = partsMakeQuipment.replace("[","").replace("]","");
            String[] splitStr = partsMakeQuipment.split(",");
            List<String> partsFaultEquipmentList =Arrays.asList(splitStr);
            for (String name : partsFaultEquipmentList) {
                faultWorkerMap.put(name, 1 + faultWorkerMap.getOrDefault(name, 0));
            }
            item.setPartsFaultQuipmentList(partsFaultEquipmentList);
        }

        //包装返回值
        JSONObject produceNumObj = new JSONObject();
        JSONObject faultNumObj = new JSONObject();
        JSONArray produceNumArray = new JSONArray();
        JSONArray faultNumArray = new JSONArray();
        JSONArray equipmentNameArray = new JSONArray();

        //生产人员名称和生产数量要一一对应
        Iterator<String> makeEquipmentMapIterator = makeEquipmentMap.keySet().iterator();
        while (makeEquipmentMapIterator.hasNext()) {
            String equipmentName = makeEquipmentMapIterator.next();
            //工人名列表
            equipmentNameArray.put(equipmentName);

            //根据工人放对应生产数\故障数
            produceNumArray.put(makeEquipmentMap.get(equipmentName));
            faultNumArray.put(faultWorkerMap.get(equipmentName));
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
                .set("equipmentNameArray", equipmentNameArray)
                .set("produceNumObj", produceNumObj)
                .set("faultNumObj", faultNumObj);
    }
}
