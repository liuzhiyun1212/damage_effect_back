package com.ruoyi.project.system.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
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
    public JSONObject getProductionDeviceChartList() {
        //生产设备列表
        List<ChangeOfProductionDevice> producedList = changeOfProductionDeviceMapper.selectProducedList();

        //设备-生产设备数
        HashMap<String, Integer> makeEquipmentMap = MapUtil.newHashMap();

        //统计生产设备的生产数
        for (ChangeOfProductionDevice item : producedList) {
            String partsMakeQuipment = item.getPartsMakeQuipment();
            partsMakeQuipment = partsMakeQuipment.replace("[", "").replace("]", "");
            String[] splitStr = partsMakeQuipment.split(",");
            List<String> partsMakeEquipmentList = Arrays.asList(splitStr);
            for (String name : partsMakeEquipmentList) {
                makeEquipmentMap.put(name, 1 + makeEquipmentMap.getOrDefault(name, 0));
            }
            item.setPartsMakeQuipmentList(partsMakeEquipmentList);
        }

        //生产设备的生产故障设备列表
        List<ChangeOfProductionDevice> faultList = changeOfProductionDeviceMapper.selectFaultList();
        //生产设备-生产设备故障数
        HashMap<String, Integer> faultWorkerMap = MapUtil.newHashMap();
        //统计生产设备生产故障数
        for (ChangeOfProductionDevice item : faultList) {
            String partsMakeQuipment = item.getPartsMakeQuipment();
            partsMakeQuipment = partsMakeQuipment.replace("[", "").replace("]", "");
            String[] splitStr = partsMakeQuipment.split(",");
            List<String> partsFaultEquipmentList = Arrays.asList(splitStr);
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

        //生产设备名称和生产数量要一一对应
        Iterator<String> makeEquipmentMapIterator = makeEquipmentMap.keySet().iterator();
        while (makeEquipmentMapIterator.hasNext()) {
            String equipmentName = makeEquipmentMapIterator.next();
            //设备名列表
            equipmentNameArray.put(equipmentName);

            //根据生产设备放对应生产数\故障数
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

    @Override
    public JSONObject getMeasuringDeviceChartList() {
        //测量设备列表
        List<ChangeOfProductionDevice> measuringDeviceList = changeOfProductionDeviceMapper.selectMeasuringDeviceList();

        //设备-测量设备数
        HashMap<String, Integer> measuringEquipmentMap = MapUtil.newHashMap();

        //统计测量设备的检测数
        for (ChangeOfProductionDevice item : measuringDeviceList) {
            String partsMeasuringQuipment = item.getPartsMeasuringQuipment();
            partsMeasuringQuipment = partsMeasuringQuipment.replace("[", "").replace("]", "");
            String[] splitStr = partsMeasuringQuipment.split(",");
            List<String> partsMeasuringEquipmentList = Arrays.asList(splitStr);
            for (String name : partsMeasuringEquipmentList) {
                measuringEquipmentMap.put(name, 1 + measuringEquipmentMap.getOrDefault(name, 0));
            }
            item.setPartsMeasuringQuipmentList(partsMeasuringEquipmentList);
        }

        //测量设备的测量故障设备列表
        List<ChangeOfProductionDevice> faultList = changeOfProductionDeviceMapper.selectFaultMeasuringDeviceList();
        //测量设备-测量设备故障数
        HashMap<String, Integer> faultDeviceMap = MapUtil.newHashMap();
        //统计测量设备测量故障数
        for (ChangeOfProductionDevice item : faultList) {
            String partsMeasuringQuipment = item.getPartsMeasuringQuipment();
            partsMeasuringQuipment = partsMeasuringQuipment.replace("[", "").replace("]", "");
            String[] splitStr = partsMeasuringQuipment.split(",");
            List<String> partsFaultEquipmentList = Arrays.asList(splitStr);
            for (String name : partsFaultEquipmentList) {
                faultDeviceMap.put(name, 1 + faultDeviceMap.getOrDefault(name, 0));
            }
            item.setPartsFaultQuipmentList(partsFaultEquipmentList);
        }

        //包装返回值
        JSONObject produceNumObj = new JSONObject();
        JSONObject faultNumObj = new JSONObject();
        JSONArray produceNumArray = new JSONArray();
        JSONArray faultNumArray = new JSONArray();
        JSONArray equipmentNameArray = new JSONArray();

        //测量设备名称和测量数量要一一对应
        Iterator<String> makeEquipmentMapIterator = measuringEquipmentMap.keySet().iterator();
        while (makeEquipmentMapIterator.hasNext()) {
            String equipmentName = makeEquipmentMapIterator.next();
            //设备名列表
            equipmentNameArray.put(equipmentName);

            //根据测量设备放对应测量数\故障数
            produceNumArray.put(measuringEquipmentMap.get(equipmentName));
            faultNumArray.put(faultDeviceMap.get(equipmentName));
        }
        produceNumObj
                .set("name", "设备测量数")
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

    @Override
    public JSONObject getRepairDeviceChartList() throws Exception {
        //维修设备列表
        List<ChangeOfProductionDevice> repairDeviceList = changeOfProductionDeviceMapper.selectRepairDeviceList();

        //设备-维修设备数
        HashMap<String, Integer> repairEquipmentMap = MapUtil.newHashMap();

        //统计维修设备的检测数
        for (ChangeOfProductionDevice item : repairDeviceList) {
            String partsRepairQuipment = item.getPartsRepairQuipment();
            if(StrUtil.isBlank(partsRepairQuipment)){
                throw new Exception("无维修设备的检测记录");
            }
            partsRepairQuipment = partsRepairQuipment.replace("[", "").replace("]", "");
            String[] splitStr = partsRepairQuipment.split(",");
            List<String> partsRepairEquipmentList = Arrays.asList(splitStr);
            for (String name : partsRepairEquipmentList) {
                repairEquipmentMap.put(name, 1 + repairEquipmentMap.getOrDefault(name, 0));
            }
            item.setPartsRepairQuipmentList(partsRepairEquipmentList);
        }

        //维修设备的维修故障设备列表
        List<ChangeOfProductionDevice> faultList = changeOfProductionDeviceMapper.selectFaultRepairDeviceList();
        //维修设备-维修设备故障数
        HashMap<String, Integer> faultWorkerMap = MapUtil.newHashMap();
        //统计维修设备维修故障数
        for (ChangeOfProductionDevice item : faultList) {
            String partsRepairQuipment = item.getPartsRepairQuipment();
            if(StrUtil.isBlank(partsRepairQuipment)){
                throw new Exception("无维修设备的故障记录");
            }
            partsRepairQuipment = partsRepairQuipment.replace("[", "").replace("]", "");
            String[] splitStr = partsRepairQuipment.split(",");
            List<String> partsFaultEquipmentList = Arrays.asList(splitStr);
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

        //维修设备名称和维修数量要一一对应
        Iterator<String> repairEquipmentMapIterator = repairEquipmentMap.keySet().iterator();
        while (repairEquipmentMapIterator.hasNext()) {
            String equipmentName = repairEquipmentMapIterator.next();
            //设备名列表
            equipmentNameArray.put(equipmentName);

            //根据维修设备放对应维修数\故障数
            produceNumArray.put(repairEquipmentMap.get(equipmentName));
            faultNumArray.put(faultWorkerMap.get(equipmentName));
        }
        produceNumObj
                .set("name", "设备维修数")
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
                .set("repairNumObj", produceNumObj)
                .set("faultNumObj", faultNumObj);
    }
}
