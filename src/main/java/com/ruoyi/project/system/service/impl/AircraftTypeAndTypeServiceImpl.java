package com.ruoyi.project.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.math.MathUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.ruoyi.project.system.domain.AircraftTypeAndTime;
import com.ruoyi.project.system.domain.QualityProblem;
import com.ruoyi.project.system.domain.UseData;
import com.ruoyi.project.system.mapper.AircraftTypeAndTypeMapper;
import com.ruoyi.project.system.service.IAircraftTypeAndTypeService;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/11/10
 */
@Service
public class AircraftTypeAndTypeServiceImpl implements IAircraftTypeAndTypeService {
    //筛选条件变量的前缀
    public static final String PREFIX_CHECKED_METHOD_NAME = "check";

    @Autowired
    private AircraftTypeAndTypeMapper aircraftTypeAndTypeMapper;

    @Override
    public List getCheckList(AircraftTypeAndTime aircraftTypeAndTime) {
        List<AircraftTypeAndTime> list = aircraftTypeAndTypeMapper.selectQuarter();
        //格式化数据
        for (AircraftTypeAndTime item : list) {
            item.setDevHappenTime(DateUtil.date(item.getDevHappenTime()));
        }
        HashMap<String, AircraftTypeAndTime> map = MapUtil.newHashMap();
        //合并季度相同的
        for (int i = 0; i < list.size(); i++) {
            AircraftTypeAndTime item = list.get(i);
            //统计某一时间段的数量
            item.setNum(map.getOrDefault(DateUtil.year(item.getDevHappenTime()) + "-" + item.getQuarter() + "-" + item.getPlaneType(), new AircraftTypeAndTime()).getNum() + 1);
            map.put(DateUtil.year(item.getDevHappenTime()) + "-" + item.getQuarter() + "-" + item.getPlaneType(), item);
        }
        //没有数据的赋零
//        for (AircraftTypeAndTime item : list) {
//            setBlankData(map, list.get(0).getDevHappenTime(), list.get(list.size() - 1).getDevHappenTime(), item);
//        }
        List<AircraftTypeAndTime> numList = new ArrayList(map.values());

        //按机型方式分类
        Map typeNumMap = spliteByAircraft(numList);

//        // 去除数量为0的值
//        Map notBlankTypeNumMap = removeBlankTypeNum(typeNumMap);

        List<Map<String, Object>> tempList = new ArrayList();
        switch (aircraftTypeAndTime.getCheckedMethodName()) {
            case "allCheck":
                tempList = allCheck(typeNumMap, aircraftTypeAndTime);
                break;
            case "check1":
                tempList = check1(typeNumMap, aircraftTypeAndTime);
                break;
            case "check2":
                tempList = check2(typeNumMap, aircraftTypeAndTime);
                break;
            case "check3":
                tempList = check3(typeNumMap, aircraftTypeAndTime);
                break;
        }

        List resList = Lists.newArrayList();
        for (Map mapItem : tempList) {
            Long eldTimeNum = (Long) mapItem.getOrDefault("eldTimeNum", 0);
            Long recentTimeNum = (Long) mapItem.getOrDefault("recentTimeNum", 0);
            if (0 == eldTimeNum || 0 == recentTimeNum) {
                continue;
            }
            resList.add(mapItem);
        }
        return resList;
    }

    /**
     * 按机型方式分成多个数组，每个数组保存同一机型的数量情况，并对数组按故障发生时间排序
     *
     * @param list 包含所有机型的数量情况
     * @return
     */
    Map spliteByAircraft(List<AircraftTypeAndTime> list) {
        //保存“机型-数组”关系。数组中保存多个包含故障数的实体类
        HashMap<String, List> typeMap = MapUtil.newHashMap();
        for (AircraftTypeAndTime item : list) {
            List numlist = typeMap.getOrDefault(item.getPlaneType(), Lists.newArrayList());
            numlist.add(item);
            typeMap.put(item.getPlaneType(), numlist);
        }

        Iterator<Map.Entry<String, List>> iterator = typeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List> next = iterator.next();
            List<AircraftTypeAndTime> typeList = next.getValue();
            //按照时间顺序排序
            typeList.sort((o1, o2) -> {
                if (o1.getDevHappenTime().getTime() - o2.getDevHappenTime().getTime() > 0) {
                    return 1;
                } else if (o1.getDevHappenTime().getTime() - o2.getDevHappenTime().getTime() == 0 && Long.parseLong(o1.getQuarter()) - Long.parseLong(o2.getQuarter()) > 0) {
                    return 1;
                } else if (o1.getDevHappenTime().getTime() - o2.getDevHappenTime().getTime() < 0) {
                    return -1;
                } else if (o1.getDevHappenTime().getTime() - o2.getDevHappenTime().getTime() == 0 && Long.parseLong(o1.getQuarter()) - Long.parseLong(o2.getQuarter()) < 0) {
                    return -1;
                } else
                    return 0;
            });

        }
        return typeMap;
    }

    /**
     * 按机型方式分成多个数组，每个数组保存同一机型的数量情况，并对数组按故障发生时间排序
     *
     * @param list 包含所有机型的数量情况
     * @return
     */
    Map spliteByUseData(List<UseData> list) {
        //保存“机型-数组”关系。数组中保存多个包含故障数的实体类
        HashMap<String, List> typeMap = MapUtil.newHashMap();
        for (UseData item : list) {
            List numlist = typeMap.getOrDefault(item.getPlaneType(), Lists.newArrayList());
            numlist.add(item);
            typeMap.put(item.getPlaneType(), numlist);
        }

        Iterator<Map.Entry<String, List>> iterator = typeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List> next = iterator.next();
            List<UseData> typeList = next.getValue();
            //按照时间顺序排序
            typeList.sort((o1, o2) -> {
                if (o1.getDate().getTime() - o2.getDate().getTime() > 0) {
                    return 1;
                } else if (o1.getDate().getTime() - o2.getDate().getTime() == 0 && Long.parseLong(o1.getQuarter()) - Long.parseLong(o2.getQuarter()) > 0) {
                    return 1;
                } else if (o1.getDate().getTime() - o2.getDate().getTime() < 0) {
                    return -1;
                } else if (o1.getDate().getTime() - o2.getDate().getTime() == 0 && Long.parseLong(o1.getQuarter()) - Long.parseLong(o2.getQuarter()) < 0) {
                    return -1;
                } else
                    return 0;
            });

        }
        return typeMap;
    }


    /**
     * 除去数量为0的值
     *
     * @param typeNumMap
     * @return
     */
    JSONObject removeBlankTypeNum(Map typeNumMap) {

        return null;
    }

    List allCheck(Map<String, List<AircraftTypeAndTime>> typeMap, AircraftTypeAndTime paramObj) {
        List resList = Lists.newArrayList();
        Iterator<Map.Entry<String, List<AircraftTypeAndTime>>> iterator = typeMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<AircraftTypeAndTime>> next = iterator.next();
            String key = next.getKey();
            List<AircraftTypeAndTime> numList = next.getValue();
            //计算符合三个条件的
            for (int i = 1; i < numList.size(); i++) {
                HashMap<String, Object> tableMap = MapUtil.newHashMap();
                if (isChange50Percent(numList.get(i - 1).getNum(), numList.get(i).getNum())) {
                    tableMap.put("aircraftType", numList.get(i).getPlaneType());
                    tableMap.put("changeRange", wrapChangeRange(getChangeRangeNonnegative(numList.get(i - 1).getNum(), numList.get(i).getNum())));
                    tableMap.put("eldTime", DateUtil.year(numList.get(i - 1).getDevHappenTime()) + "年第" + numList.get(i - 1).getQuarter() + "季度");
                    tableMap.put("eldTimeNum", numList.get(i - 1).getNum());
                    tableMap.put("recentTime", DateUtil.year(numList.get(i).getDevHappenTime()) + "年第" + numList.get(i).getQuarter() + "季度");
                    tableMap.put("recentTimeNum", numList.get(i).getNum());
                    //去掉指定前缀
                    tableMap.put("checkCondition", "1");
                }
                if (i >= 2 && isChange20PercentTwoTime(numList.get(i - 2).getNum(), numList.get(i - 1).getNum(), numList.get(i).getNum())) {
                    if (tableMap.isEmpty()) {
                        tableMap.put("aircraftType", numList.get(i).getPlaneType());
                        tableMap.put("changeRange", "第一次变化幅度：" + wrapChangeRange(getChangeRange(numList.get(i - 2).getNum(), numList.get(i - 1).getNum())) + ",第二次变化幅度：" + wrapChangeRange(getChangeRange(numList.get(i - 1).getNum(), numList.get(i).getNum())));
                        tableMap.put("eldTime", DateUtil.year(numList.get(i - 2).getDevHappenTime()) + "年第" + numList.get(i - 2).getQuarter() + "季度");
                        tableMap.put("eldTimeNum", numList.get(i - 2).getNum());
                        tableMap.put("recentTime", DateUtil.year(numList.get(i).getDevHappenTime()) + "年第" + numList.get(i).getQuarter() + "季度");
                        tableMap.put("recentTimeNum", numList.get(i).getNum());
                        //去掉指定前缀
                        String s = (String) tableMap.getOrDefault("checkCondition", "");
                        s = StrUtil.isBlank(s) ? StrUtil.EMPTY : (s + ",");
                        tableMap.put("checkCondition", s + "2");
                    } else {
                        //去掉指定前缀
                        String s = (String) tableMap.getOrDefault("checkCondition", "");
                        s = StrUtil.isBlank(s) ? StrUtil.EMPTY : (s + ",");
                        tableMap.put("checkCondition", s + "2");
                    }
                }
                if (i >= 3 && isMonotonicVariation(numList.get(i - 3).getNum(), numList.get(i - 2).getNum(), numList.get(i - 1).getNum(), numList.get(i).getNum())) {
                    if (tableMap.isEmpty()) {
                        tableMap.put("aircraftType", numList.get(i).getPlaneType());
                        tableMap.put("changeRange", "");
                        tableMap.put("eldTime", DateUtil.year(numList.get(i - 3).getDevHappenTime()) + "年第" + numList.get(i - 3).getQuarter() + "季度");
                        tableMap.put("eldTimeNum", numList.get(i - 3).getNum());
                        tableMap.put("recentTime", DateUtil.year(numList.get(i).getDevHappenTime()) + "年第" + numList.get(i).getQuarter() + "季度");
                        tableMap.put("recentTimeNum", numList.get(i).getNum());
                        //去掉指定前缀
                        String s = (String) tableMap.getOrDefault("checkCondition", "");
                        s = StrUtil.isBlank(s) ? StrUtil.EMPTY : (s + ",");
                        tableMap.put("checkCondition", s + "3");
                    } else {
                        String s = (String) tableMap.getOrDefault("checkCondition", "");
                        s = StrUtil.isBlank(s) ? StrUtil.EMPTY : (s + ",");
                        tableMap.put("checkCondition", s + "3");
                    }
                }
                if (!CollectionUtil.isEmpty(tableMap)) {
                    resList.add(tableMap);
                }
            }
        }
        return resList;
    }

    List allCheckUseData(Map<String, List<UseData>> typeMap, AircraftTypeAndTime paramObj){
        List resList = Lists.newArrayList();
        Iterator<Map.Entry<String, List<UseData>>> iterator = typeMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<UseData>> next = iterator.next();
            String key = next.getKey();
            List<UseData> numList = next.getValue();
            //计算符合三个条件的
            for (int i = 1; i < numList.size(); i++) {
                HashMap<String, Object> tableMap = MapUtil.newHashMap();
                if (isChange50Percent(numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())) {
                    tableMap.put("aircraftType", numList.get(i).getPlaneType());
                    tableMap.put("changeRange", wrapChangeRange(getChangeRangeNonnegative(numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())));
                    tableMap.put("eldTime", DateUtil.year(numList.get(i - 1).getDate()) + "年第" + DateUtil.quarter(numList.get(i - 1).getDate()) + "季度");
                    tableMap.put("eldTimeNum", numList.get(i - 1).getFlightHours());
                    tableMap.put("recentTime", DateUtil.year(numList.get(i).getDate()) + "年第" + DateUtil.quarter(numList.get(i).getDate()) + "季度");
                    tableMap.put("recentTimeNum", numList.get(i).getFlightHours());
                    //去掉指定前缀
                    tableMap.put("checkCondition", "1");
                }
                if (i >= 2 && isChange20PercentTwoTime(numList.get(i - 2).getFlightHours(), numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())) {
                    if (tableMap.isEmpty()) {
                        tableMap.put("aircraftType", numList.get(i).getPlaneType());
                        tableMap.put("changeRange", "第一次变化幅度：" + wrapChangeRange(getChangeRange(numList.get(i - 2).getFlightHours(), numList.get(i - 1).getFlightHours())) + ",第二次变化幅度：" + wrapChangeRange(getChangeRange(numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())));
                        tableMap.put("eldTime", DateUtil.year(numList.get(i - 2).getDate()) + "年第" + DateUtil.quarter(numList.get(i - 2).getDate()) + "季度");
                        tableMap.put("eldTimeNum", numList.get(i - 2).getFlightHours());
                        tableMap.put("recentTime", DateUtil.year(numList.get(i).getDate()) + "年第" + numList.get(i).getQuarter() + "季度");
                        tableMap.put("recentTimeNum", numList.get(i).getFlightHours());
                        //去掉指定前缀
                        String s = (String) tableMap.getOrDefault("checkCondition", "");
                        s = StrUtil.isBlank(s) ? StrUtil.EMPTY : (s + ",");
                        tableMap.put("checkCondition", s + "2");
                    } else {
                        //去掉指定前缀
                        String s = (String) tableMap.getOrDefault("checkCondition", "");
                        s = StrUtil.isBlank(s) ? StrUtil.EMPTY : (s + ",");
                        tableMap.put("checkCondition", s + "2");
                    }
                }
                if (i >= 3 && isMonotonicVariation(numList.get(i - 3).getFlightHours(), numList.get(i - 2).getFlightHours(), numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())) {
                    if (tableMap.isEmpty()) {
                        tableMap.put("aircraftType", numList.get(i).getPlaneType());
                        tableMap.put("changeRange", "");
                        tableMap.put("eldTime", DateUtil.year(numList.get(i - 3).getDate()) + "年第" + DateUtil.quarter(numList.get(i - 3).getDate()) + "季度");
                        tableMap.put("eldTimeNum", numList.get(i - 3).getFlightHours());
                        tableMap.put("recentTime", DateUtil.year(numList.get(i).getDate()) + "年第" + DateUtil.quarter(numList.get(i).getDate()) + "季度");
                        tableMap.put("recentTimeNum", numList.get(i).getFlightHours());
                        //去掉指定前缀
                        String s = (String) tableMap.getOrDefault("checkCondition", "");
                        s = StrUtil.isBlank(s) ? StrUtil.EMPTY : (s + ",");
                        tableMap.put("checkCondition", s + "3");
                    } else {
                        String s = (String) tableMap.getOrDefault("checkCondition", "");
                        s = StrUtil.isBlank(s) ? StrUtil.EMPTY : (s + ",");
                        tableMap.put("checkCondition", s + "3");
                    }
                }
                if (!CollectionUtil.isEmpty(tableMap)) {
                    resList.add(tableMap);
                }
            }
        }
        return resList;
    }


    /**
     * 较上一时间增加或减少50%以上，该时间为质量问题发生故障件变化时间。
     * 先对map进行遍历，key是机型，value是数量情况，按照不同机型进行计算
     *
     * @return
     */
    List check1(Map<String, List<AircraftTypeAndTime>> typeMap, AircraftTypeAndTime paramObj) {
        List resList = Lists.newArrayList();
        Iterator<Map.Entry<String, List<AircraftTypeAndTime>>> iterator = typeMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<AircraftTypeAndTime>> next = iterator.next();
            String key = next.getKey();
            List<AircraftTypeAndTime> numList = next.getValue();
            //计算较上一时间增加或减少50%以上
            for (int i = 1; i < numList.size(); i++) {
                if (isChange50Percent(numList.get(i - 1).getNum(), numList.get(i).getNum())) {
                    HashMap<String, Object> tableMap = MapUtil.newHashMap();
                    tableMap.put("aircraftType", numList.get(i).getPlaneType());
                    tableMap.put("changeRange", wrapChangeRange(getChangeRangeNonnegative(numList.get(i - 1).getNum(), numList.get(i).getNum())));
                    tableMap.put("eldTime", DateUtil.year(numList.get(i - 1).getDevHappenTime()) + "年第" + numList.get(i - 1).getQuarter() + "季度");
                    tableMap.put("eldTimeNum", numList.get(i - 1).getNum());
                    tableMap.put("recentTime", DateUtil.year(numList.get(i).getDevHappenTime()) + "年第" + numList.get(i).getQuarter() + "季度");
                    tableMap.put("recentTimeNum", numList.get(i).getNum());

                    String checkCondition = StrUtil.removePrefix(paramObj.getCheckedMethodName(), PREFIX_CHECKED_METHOD_NAME);
                    //是否符合条件2
                    if (i >= 2 && isChange20PercentTwoTime(numList.get(i - 2).getNum(), numList.get(i - 1).getNum(), numList.get(i).getNum())) {
                        checkCondition = checkCondition + ",2";
                    }
                    //是否符合条件3
                    if (i >= 3 && isMonotonicVariation(numList.get(i - 3).getNum(), numList.get(i - 2).getNum(), numList.get(i - 1).getNum(), numList.get(i).getNum())) {
                        checkCondition = checkCondition + ",3";
                    }
                    //去掉指定前缀
                    tableMap.put("checkCondition", checkCondition);
                    resList.add(tableMap);
                }
            }
        }
        return resList;
    }

    List check1UseData(Map<String, List<UseData>> typeMap, AircraftTypeAndTime paramObj) {
        List resList = Lists.newArrayList();
        Iterator<Map.Entry<String, List<UseData>>> iterator = typeMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<UseData>> next = iterator.next();
            String key = next.getKey();
            List<UseData> numList = next.getValue();
            //计算较上一时间增加或减少50%以上
            for (int i = 1; i < numList.size(); i++) {
                if (isChange50Percent(numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())) {
                    HashMap<String, Object> tableMap = MapUtil.newHashMap();
                    tableMap.put("aircraftType", numList.get(i).getPlaneType());
                    tableMap.put("changeRange", wrapChangeRange(getChangeRangeNonnegative(numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())));
                    tableMap.put("eldTime", DateUtil.year(numList.get(i - 1).getDate()) + "年第" + DateUtil.quarter(numList.get(i - 1).getDate()) + "季度");
                    tableMap.put("eldTimeNum", numList.get(i - 1).getFlightHours());
                    tableMap.put("recentTime", DateUtil.year(numList.get(i).getDate()) + "年第" + DateUtil.quarter(numList.get(i).getDate()) + "季度");
                    tableMap.put("recentTimeNum", numList.get(i).getFlightHours());

                    String checkCondition = StrUtil.removePrefix(paramObj.getCheckedMethodName(), PREFIX_CHECKED_METHOD_NAME);
                    //是否符合条件2
                    if (i >= 2 && isChange20PercentTwoTime(numList.get(i - 2).getFlightHours(), numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())) {
                        checkCondition = checkCondition + ",2";
                    }
                    //是否符合条件3
                    if (i >= 3 && isMonotonicVariation(numList.get(i - 3).getFlightHours(), numList.get(i - 2).getFlightHours(), numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())) {
                        checkCondition = checkCondition + ",3";
                    }
                    //去掉指定前缀
                    tableMap.put("checkCondition", checkCondition);
                    resList.add(tableMap);
                }
            }
        }
        return resList;
    }

    List check2(Map<String, List<AircraftTypeAndTime>> typeMap, AircraftTypeAndTime paramObj) {
        List resList = Lists.newArrayList();
        Iterator<Map.Entry<String, List<AircraftTypeAndTime>>> iterator = typeMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<AircraftTypeAndTime>> next = iterator.next();
            String key = next.getKey();
            List<AircraftTypeAndTime> numList = next.getValue();
            //连续两个时间段增加或减少20%以上
            for (int i = 2; i < numList.size(); i++) {
                if (isChange20PercentTwoTime(numList.get(i - 2).getNum(), numList.get(i - 1).getNum(), numList.get(i).getNum())) {
                    HashMap<String, Object> tableMap = MapUtil.newHashMap();
                    tableMap.put("aircraftType", numList.get(i).getPlaneType());
                    tableMap.put("changeRange", "第一次变化幅度：" + wrapChangeRange(getChangeRange(numList.get(i - 2).getNum(), numList.get(i - 1).getNum())) + ",第二次变化幅度：" + wrapChangeRange(getChangeRange(numList.get(i - 1).getNum(), numList.get(i).getNum())));
                    tableMap.put("eldTime", DateUtil.year(numList.get(i - 2).getDevHappenTime()) + "年第" + numList.get(i - 2).getQuarter() + "季度");
                    tableMap.put("eldTimeNum", numList.get(i - 2).getNum());
                    tableMap.put("recentTime", DateUtil.year(numList.get(i).getDevHappenTime()) + "年第" + numList.get(i).getQuarter() + "季度");
                    tableMap.put("recentTimeNum", numList.get(i).getNum());

                    String checkCondition = StrUtil.removePrefix(paramObj.getCheckedMethodName(), PREFIX_CHECKED_METHOD_NAME);
                    //是否符合条件1
                    if (isChange50Percent(numList.get(i - 1).getNum(), numList.get(i).getNum())) {
                        checkCondition = "1," + checkCondition;
                    }
                    //是否符合条件3
                    if (i >= 3 && isMonotonicVariation(numList.get(i - 3).getNum(), numList.get(i - 2).getNum(), numList.get(i - 1).getNum(), numList.get(i).getNum())) {
                        checkCondition = checkCondition + ",3";
                    }
                    //去掉指定前缀
                    tableMap.put("checkCondition", checkCondition);
                    resList.add(tableMap);
                }
            }
        }
        return resList;
    }

    List check2UseData(Map<String, List<UseData>> typeMap, AircraftTypeAndTime paramObj) {
        List resList = Lists.newArrayList();
        Iterator<Map.Entry<String, List<UseData>>> iterator = typeMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<UseData>> next = iterator.next();
            String key = next.getKey();
            List<UseData> numList = next.getValue();
            //连续两个时间段增加或减少20%以上
            for (int i = 2; i < numList.size(); i++) {
                if (isChange20PercentTwoTime(numList.get(i - 2).getFlightHours(), numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())) {
                    HashMap<String, Object> tableMap = MapUtil.newHashMap();
                    tableMap.put("aircraftType", numList.get(i).getPlaneType());
                    tableMap.put("changeRange", "第一次变化幅度：" + wrapChangeRange(getChangeRange(numList.get(i - 2).getFlightHours(), numList.get(i - 1).getFlightHours())) + ",第二次变化幅度：" + wrapChangeRange(getChangeRange(numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())));
                    tableMap.put("eldTime", DateUtil.year(numList.get(i - 2).getDate()) + "年第" + DateUtil.quarter(numList.get(i - 2).getDate()) + "季度");
                    tableMap.put("eldTimeNum", numList.get(i - 2).getFlightHours());
                    tableMap.put("recentTime", DateUtil.year(numList.get(i).getDate()) + "年第" + DateUtil.quarter(numList.get(i).getDate()) + "季度");
                    tableMap.put("recentTimeNum", numList.get(i).getFlightHours());

                    String checkCondition = StrUtil.removePrefix(paramObj.getCheckedMethodName(), PREFIX_CHECKED_METHOD_NAME);
                    //是否符合条件1
                    if (isChange50Percent(numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())) {
                        checkCondition = "1," + checkCondition;
                    }
                    //是否符合条件3
                    if (i >= 3 && isMonotonicVariation(numList.get(i - 3).getFlightHours(), numList.get(i - 2).getFlightHours(), numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())) {
                        checkCondition = checkCondition + ",3";
                    }
                    //去掉指定前缀
                    tableMap.put("checkCondition", checkCondition);
                    resList.add(tableMap);
                }
            }
        }
        return resList;
    }

    List check3(Map<String, List<AircraftTypeAndTime>> typeMap, AircraftTypeAndTime paramObj) {
        List resList = Lists.newArrayList();
        Iterator<Map.Entry<String, List<AircraftTypeAndTime>>> iterator = typeMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<AircraftTypeAndTime>> next = iterator.next();
            String key = next.getKey();
            List<AircraftTypeAndTime> numList = next.getValue();

            //连续三个时间段呈单调变化趋势
            for (int i = 3; i < numList.size(); i++) {
                if (isMonotonicVariation(numList.get(i - 3).getNum(), numList.get(i - 2).getNum(), numList.get(i - 1).getNum(), numList.get(i).getNum())) {
                    HashMap<String, Object> tableMap = MapUtil.newHashMap();
                    tableMap.put("aircraftType", numList.get(i).getPlaneType());
                    tableMap.put("changeRange", "");
                    tableMap.put("eldTime", DateUtil.year(numList.get(i - 3).getDevHappenTime()) + "年第" + numList.get(i - 3).getQuarter() + "季度");
                    tableMap.put("eldTimeNum", numList.get(i - 3).getNum());
                    tableMap.put("recentTime", DateUtil.year(numList.get(i).getDevHappenTime()) + "年第" + numList.get(i).getQuarter() + "季度");
                    tableMap.put("recentTimeNum", numList.get(i).getNum());

                    String checkCondition = StrUtil.removePrefix(paramObj.getCheckedMethodName(), PREFIX_CHECKED_METHOD_NAME);
                    //是否符合条件1
                    if (isChange50Percent(numList.get(i - 1).getNum(), numList.get(i).getNum())) {
                        checkCondition = "1," + checkCondition;
                    }
                    //是否符合条件2
                    if (i >= 2 && isChange20PercentTwoTime(numList.get(i - 2).getNum(), numList.get(i - 1).getNum(), numList.get(i).getNum())) {
                        checkCondition = checkCondition + ",2";
                    }
                    //去掉指定前缀
                    tableMap.put("checkCondition", checkCondition);
                    resList.add(tableMap);
                }
            }
        }
        return resList;
    }

    List check3UseData(Map<String, List<UseData>> typeMap, AircraftTypeAndTime paramObj) {
        List resList = Lists.newArrayList();
        Iterator<Map.Entry<String, List<UseData>>> iterator = typeMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<UseData>> next = iterator.next();
            String key = next.getKey();
            List<UseData> numList = next.getValue();

            //连续三个时间段呈单调变化趋势
            for (int i = 3; i < numList.size(); i++) {
                if (isMonotonicVariation(numList.get(i - 3).getFlightHours(), numList.get(i - 2).getFlightHours(), numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())) {
                    HashMap<String, Object> tableMap = MapUtil.newHashMap();
                    tableMap.put("aircraftType", numList.get(i).getPlaneType());
                    tableMap.put("changeRange", "");
                    tableMap.put("eldTime", DateUtil.year(numList.get(i - 3).getDate()) + "年第" + numList.get(i - 3).getQuarter() + "季度");
                    tableMap.put("eldTimeNum", numList.get(i - 3).getFlightHours());
                    tableMap.put("recentTime", DateUtil.year(numList.get(i).getDate()) + "年第" + numList.get(i).getQuarter() + "季度");
                    tableMap.put("recentTimeNum", numList.get(i).getFlightHours());

                    String checkCondition = StrUtil.removePrefix(paramObj.getCheckedMethodName(), PREFIX_CHECKED_METHOD_NAME);
                    //是否符合条件1
                    if (isChange50Percent(numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())) {
                        checkCondition = "1," + checkCondition;
                    }
                    //是否符合条件2
                    if (i >= 2 && isChange20PercentTwoTime(numList.get(i - 2).getFlightHours(), numList.get(i - 1).getFlightHours(), numList.get(i).getFlightHours())) {
                        checkCondition = checkCondition + ",2";
                    }
                    //去掉指定前缀
                    tableMap.put("checkCondition", checkCondition);
                    resList.add(tableMap);
                }
            }
        }
        return resList;
    }

    @Override
    public Map getChartData() throws Exception {
        List<AircraftTypeAndTime> list = aircraftTypeAndTypeMapper.selectQuarter();
        //todo 为什么实体类中的devHappenTime的@JsonFormat不起作用
        //格式化数据
        for (AircraftTypeAndTime item : list) {
            item.setDevHappenTime(DateUtil.date(item.getDevHappenTime()));
        }

        HashMap<String, AircraftTypeAndTime> map = MapUtil.newHashMap();

        //合并季度相同的
        for (AircraftTypeAndTime item : list) {
            //统计某一时间段的不同机型的数量
            item.setNum(map.getOrDefault(DateUtil.year(item.getDevHappenTime()) + "-" + item.getQuarter() + "-" + item.getPlaneType(), new AircraftTypeAndTime()).getNum() + 1);
            map.put(DateUtil.year(item.getDevHappenTime()) + "-" + item.getQuarter() + "-" + item.getPlaneType(), item);
        }

        //没有数据的赋零
        for (AircraftTypeAndTime item : list) {
            setBlankData(map, list.get(0).getDevHappenTime(), list.get(list.size() - 1).getDevHappenTime(), item);
        }

        List<AircraftTypeAndTime> numList = new ArrayList(map.values());
        //按照时间顺序排序
        numList.sort(Comparator.comparing(QualityProblem::getDevHappenTime));

        //结果的对象
        HashMap<String, Object> resMap = MapUtil.newHashMap();

        //相同机型的根据时间顺序放进list
        HashMap<String, Object> distinctNameMap = MapUtil.newHashMap();
        HashMap<String, Object> typeMap = MapUtil.newHashMap();
        for (AircraftTypeAndTime item : numList) {
            //一个机型里存所有季度的数量
            ArrayList<Object> numList2 = (ArrayList<Object>) typeMap.getOrDefault(item.getPlaneType(), Lists.newArrayList());
            numList2.add(item.getNum());
            typeMap.put(item.getPlaneType(), numList2);
            resMap = MapUtil.newHashMap();
            resMap.put("name", item.getPlaneType());
            resMap.put("type", "line");
            resMap.put("data", numList2);
            //添加到list中的是不同机型的map
            distinctNameMap.put(item.getPlaneType(), resMap);
        }

        //todo 这里和上面的的功能不需要同步，可以用多线程来做，只要最后都放到res就行了
        List xData = getXData(list);
        List<AircraftTypeAndTime> resList = new ArrayList(distinctNameMap.values());

        JSONObject jsonObject = new JSONObject();
        jsonObject.set("xdata", xData)
                .set("list", resList);
        return removeBlankItem(jsonObject);
    }

    //去除空值
    JSONObject removeBlankItem(JSONObject jsonObject) throws Exception {
        if (CollectionUtil.isEmpty((Iterable<?>) jsonObject)) {
            throw new Exception("数据不能为空");
        }
        List xList = (List) jsonObject.get("xdata");
        List<JSONObject> ylist = (List<JSONObject>) jsonObject.get("list");

        //查出数值不为0的索引值，每次遍历时都保留数据表中的这个索引值对应的值
        List notBlankIndexList = Lists.newArrayList();
        for (JSONObject item : ylist) {
            List<Long> series = (List) item.get("data");
            for (int i = 0; i < series.size(); i++) {
                Long yItem = series.get(i);
                if (yItem != 0) {
                    notBlankIndexList.add(i);
                }
            }
        }
        Collections.sort(notBlankIndexList);
        notBlankIndexList = (List) notBlankIndexList.stream().distinct().collect(Collectors.toList());
        //一列有一个不为空的就把这一列都放进结果中
        List resXList = Lists.newArrayList();
        for (JSONObject item : ylist) {
            List<Long> series = (List) item.get("data");
            List<Long> resYList = Lists.newArrayList();
            int index = 0;
            for (int i = 0; i < series.size(); i++) {
                Long yItem = series.get(i);
                if (index >= notBlankIndexList.size()) {
                    break;
                }
                //如果索引值存在于notBlankIndexList中，表示这一列有不为0的值，所以保留这行的数据
                if (notBlankIndexList.get(index).equals(i)) {
                    resYList.add(yItem);
                    resXList.add(xList.get(i));
                    index++;
                }
            }
            item.set("data", resYList);
        }

        //去重
        resXList = (List) resXList.stream().distinct().collect(Collectors.toList());
        JSONObject resObj = new JSONObject();
        resObj.set("xdata", resXList)
                .set("list", ylist);
        return resObj;
    }

    //去除空值
    JSONObject removeBlankItemUseData(JSONObject jsonObject) throws Exception {
        if (CollectionUtil.isEmpty((Iterable<?>) jsonObject)) {
            throw new Exception("数据不能为空");
        }
        List xList = (List) jsonObject.get("xdata");
        List<JSONObject> ylist = (List<JSONObject>) jsonObject.get("list");

        //查出数值不为0的索引值，每次遍历时都保留数据表中的这个索引值对应的值
        List notBlankIndexList = Lists.newArrayList();
        for (JSONObject item : ylist) {
            List<Long> series = (List) item.get("data");
            for (int i = 0; i < series.size(); i++) {
                Long yItem = series.get(i);
                if (yItem != 0) {
                    notBlankIndexList.add(i);
                }
            }
        }
        Collections.sort(notBlankIndexList);
        notBlankIndexList = (List) notBlankIndexList.stream().distinct().collect(Collectors.toList());
        //一列有一个不为空的就把这一列都放进结果中
        List resXList = Lists.newArrayList();
        for (JSONObject item : ylist) {
            List<Long> series = (List) item.get("data");
            List<Long> resYList = Lists.newArrayList();
            int index = 0;
            for (int i = 0; i < series.size(); i++) {
                Long yItem = series.get(i);
                if (index >= notBlankIndexList.size()) {
                    break;
                }
                //如果索引值存在于notBlankIndexList中，表示这一列有不为0的值，所以保留这行的数据
                if (notBlankIndexList.get(index).equals(i)) {
                    resYList.add(yItem);
                    resXList.add(xList.get(i));
                    index++;
                }
            }
            item.set("data", resYList);
        }

        //去重
        resXList = (List) resXList.stream().distinct().collect(Collectors.toList());
        JSONObject resObj = new JSONObject();
        resObj.set("xdata", resXList)
                .set("list", ylist);
        return resObj;
    }

    @Override
    public List getUseIntensityCheckList(AircraftTypeAndTime aircraftTypeAndTime) {
        List<UseData> list = aircraftTypeAndTypeMapper.selectUseTime();
        //格式化数据
        for (UseData item : list) {
            item.setDate(DateUtil.date(item.getDate()));
        }
        HashMap<String, UseData> map = MapUtil.newHashMap();
        //合并季度相同的
        for (int i = 0; i < list.size(); i++) {
            UseData item = list.get(i);
            //统计某一时间段的数量
            item.setFlightHours(map.getOrDefault(DateUtil.year(item.getDate()) + "-" + DateUtil.quarter(item.getDate()) + "-" + item.getPlaneType(), new UseData()).getFlightHours() + item.getFlightHours());
            map.put(DateUtil.year(item.getDate()) + "-" + DateUtil.quarter(item.getDate()) + "-" + item.getPlaneType(), item);
        }

        List<UseData> useDataList = new ArrayList(map.values());

        //按机型方式分类
        Map typeNumMap = spliteByUseData(useDataList);

        List<Map<String, Object>> tempList = new ArrayList();
        switch (aircraftTypeAndTime.getCheckedMethodName()) {
            case "allCheck":
                tempList = allCheckUseData(typeNumMap, aircraftTypeAndTime);
                break;
            case "check1":
                tempList = check1UseData(typeNumMap, aircraftTypeAndTime);
                break;
            case "check2":
                tempList = check2UseData(typeNumMap, aircraftTypeAndTime);
                break;
            case "check3":
                tempList = check3UseData(typeNumMap, aircraftTypeAndTime);
                break;
        }

        List resList = Lists.newArrayList();
        for (Map mapItem : tempList) {
            Long eldTimeNum = (Long) mapItem.getOrDefault("eldTimeNum", 0);
            Long recentTimeNum = (Long) mapItem.getOrDefault("recentTimeNum", 0);
            if (0 == eldTimeNum || 0 == recentTimeNum) {
                continue;
            }
            resList.add(mapItem);
        }
        return resList;
    }

    @Override
    public Map getUseIntensityChartData() throws Exception {
        List<UseData> list = aircraftTypeAndTypeMapper.selectUseTime();
        //格式化数据
        for (UseData item : list) {
            item.setDate(DateUtil.date(item.getDate()));
        }

        HashMap<String, UseData> map = MapUtil.newHashMap();

        //合并季度相同的
        for (UseData item : list) {
            //统计某一时间段的不同机型的飞行小时
            item.setFlightHours(map.getOrDefault(DateUtil.year(item.getDate()) + "-" + DateUtil.quarter(item.getDate()) + "-" + item.getPlaneType(), new UseData()).getFlightHours()+item.getFlightHours());
            map.put(DateUtil.year(item.getDate()) + "-" + DateUtil.quarter(item.getDate()) + "-" + item.getPlaneType(), item);
        }

        //没有数据的赋零
        for (UseData item : list) {
            setBlankData(map, list.get(0).getDate(), list.get(list.size() - 1).getDate(), item);
        }

        List<UseData> filledBlankList = new ArrayList(map.values());
        //按照时间顺序排序
        filledBlankList.sort(Comparator.comparing(UseData::getDate));

        //结果的对象
        HashMap<String, Object> resMap = MapUtil.newHashMap();

        //相同机型的根据时间顺序放进list
        HashMap<String, Object> distinctNameMap = MapUtil.newHashMap();
        HashMap<String, Object> typeMap = MapUtil.newHashMap();
        for (UseData item : filledBlankList) {
            //一个机型里存所有季度的数量
            ArrayList<Object> useDataList = (ArrayList<Object>) typeMap.getOrDefault(item.getPlaneType(), Lists.newArrayList());
            useDataList.add(item.getFlightHours());
            typeMap.put(item.getPlaneType(), useDataList);
            resMap = MapUtil.newHashMap();
            resMap.put("name", item.getPlaneType());
            resMap.put("type", "line");
            resMap.put("data", useDataList);
//            resMap.put("stack", "Total");
//            resMap.put("areaStyle", new JSONObject());
//            resMap.put("emphasis", new JSONObject().append("focus", "series"));
            //添加到list中的是不同机型的map
            distinctNameMap.put(item.getPlaneType(), resMap);
        }

        //todo 这里和上面的的功能不需要同步，可以用多线程来做，只要最后都放到res就行了
        List xData = getXDataUseData(list);
        List<UseData> resList = new ArrayList(distinctNameMap.values());

        return removeBlankItemUseData(new JSONObject().set("xdata", xData).set("list", resList));
    }

    List getXData(List<AircraftTypeAndTime> typeList) {
        int oldYear = DateUtil.year(typeList.get(0).getDevHappenTime());
        int newYear = DateUtil.year(typeList.get(typeList.size() - 1).getDevHappenTime());
        ArrayList<Object> list = Lists.newArrayList();
        int quarter = 1;
        while (oldYear <= newYear) {
            String str = oldYear + "年第" + quarter + "季度";
            list.add(str);

            if (quarter == 4) {
                quarter = 1;
                oldYear++;
            } else {
                quarter++;
            }
        }
        return list;
    }

    /**
     * todo getXDataUseData与getXData可以合并
     *
     * @param typeList
     * @return
     */
    List getXDataUseData(List<UseData> typeList) {
        int oldYear = DateUtil.year(typeList.get(0).getDate());
        int newYear = DateUtil.year(typeList.get(typeList.size() - 1).getDate());
        ArrayList<Object> list = Lists.newArrayList();
        int quarter = 1;
        while (oldYear <= newYear) {
            String str = oldYear + "年第" + quarter + "季度";
            list.add(str);

            if (quarter == 4) {
                quarter = 1;
                oldYear++;
            } else {
                quarter++;
            }
        }
        return list;
    }

    /**
     * 较上一时间增加或减少50%以上，该时间为质量问题发生故障件变化时间
     * 不能为零
     *
     * @param preVal
     * @param val
     * @return
     */
    boolean isChange50Percent(double preVal, double val) {
        if (0 == preVal || 0 == val) {
            return false;
        }
        return getChangeRangeNonnegative(preVal, val) > 0.5;
    }

    /**
     * 返回值非负
     *
     * @param preVal
     * @param val
     * @return 取绝对值，所以返回值非负
     */
    double getChangeRangeNonnegative(double preVal, double val) {
        return Math.abs((val - preVal) / preVal);
    }

    String wrapChangeRange(double val) {
        if (val == Double.POSITIVE_INFINITY) {
            return "上个时间点无数据";
        } else
            return val * 100 + "%";
    }

    boolean isChange20PercentTwoTime(double prePreVal, double preVal, double val) {
        if (0 == prePreVal || 0 == preVal || 0 == val) {
            return false;
        }
        if (getChangeRange(prePreVal, preVal) > 0.2 && getChangeRange(preVal, val) > 0.2) {
            return true;
        } else if (getChangeRange(prePreVal, preVal) < -0.2 && getChangeRange(preVal, val) < -0.2) {
            return true;
        }
        return false;
    }

    /**
     * @param preVal
     * @param val
     * @return 返回值没有加绝对值
     */
    double getChangeRange(double preVal, double val) {
        return (val - preVal) / preVal;
    }


    /**
     * 是否三个时间段单调变化
     *
     * @return
     */
    boolean isMonotonicVariation(double firstNum, double secondNum, double thirdnum, double fourthNum) {
        if (firstNum == 0 || secondNum == 0 || thirdnum == 0 || fourthNum == 0) {
            return false;
        }
        if (firstNum - secondNum >= 0 && secondNum - thirdnum >= 0 && thirdnum - fourthNum >= 0) {
            return true;
        } else if (firstNum - secondNum <= 0 && secondNum - thirdnum <= 0 && thirdnum - fourthNum <= 0) {
            return true;
        }
        return false;
    }

    /**
     * 某年某季没有数据的map的数量赋0
     * map的key为年份-季度-机型，
     *
     * @param map
     * @param oldTime 最开始显示的时间
     * @param newTime 最后显示的时间
     * @param item
     */
    void setBlankData(Map map, Date oldTime, Date newTime, AircraftTypeAndTime item) {
        int oldYear = DateUtil.year(oldTime);
        int oldQuarter = DateUtil.quarter(oldTime);
        int newYear = DateUtil.year(newTime);
        int newQuarter = DateUtil.quarter(newTime);

        int tempYear = oldYear, tempQuarter = oldQuarter;
        while (tempYear <= newYear) {
            String str = tempYear + "-" + tempQuarter + "-" + item.getPlaneType();
            //如果表中存在表示有数据，不存在则赋0值
            if (!map.containsKey(str)) {
                AircraftTypeAndTime tempObj = new AircraftTypeAndTime();
                tempObj.setQuarter(String.valueOf(tempQuarter));
                //放虚拟日期数据
                tempObj.setDevHappenTime(DateTime.of(String.valueOf(tempYear) + "-" + tempQuarter * 3, "yyyy-MM"));
                tempObj.setPlaneType(item.getPlaneType());
                map.put(str, tempObj);
            }
            if (tempQuarter == 4) {
                tempQuarter = 1;
                tempYear++;
            } else {
                tempQuarter++;
            }
        }
    }

    /**
     * todo 这两个代码可以合并
     * 某年某季没有数据的map的数量赋0
     * map的key为年份-季度-机型，
     *
     * @param map
     * @param oldTime 最开始显示的时间
     * @param newTime 最后显示的时间
     * @param item
     */
    void setBlankData(Map map, Date oldTime, Date newTime, UseData item) {
        int oldYear = DateUtil.year(oldTime);
        int oldQuarter = DateUtil.quarter(oldTime);
        int newYear = DateUtil.year(newTime);
        int newQuarter = DateUtil.quarter(newTime);

        int tempYear = oldYear, tempQuarter = oldQuarter;
        while (tempYear <= newYear) {
            String str = tempYear + "-" + tempQuarter + "-" + item.getPlaneType();
            //如果表中存在表示有数据，不存在则赋0值
            if (!map.containsKey(str)) {
                UseData tempObj = new UseData();
                tempObj.setQuarter(String.valueOf(tempQuarter));
                //放虚拟日期数据
                tempObj.setDate(DateTime.of(String.valueOf(tempYear) + "-" + tempQuarter * 3, "yyyy-MM"));
                tempObj.setPlaneType(item.getPlaneType());
                tempObj.setFlightHours(0L);
                map.put(str, tempObj);
            }
            if (tempQuarter == 4) {
                tempQuarter = 1;
                tempYear++;
            } else {
                tempQuarter++;
            }
        }
    }
}
