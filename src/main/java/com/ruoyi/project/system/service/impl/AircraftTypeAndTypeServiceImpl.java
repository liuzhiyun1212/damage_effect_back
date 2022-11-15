package com.ruoyi.project.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.math.MathUtil;
import cn.hutool.core.util.StrUtil;
import com.ruoyi.project.system.domain.AircraftTypeAndTime;
import com.ruoyi.project.system.domain.QualityProblem;
import com.ruoyi.project.system.mapper.AircraftTypeAndTypeMapper;
import com.ruoyi.project.system.mapper.QualityProblemMapper;
import com.ruoyi.project.system.service.IAircraftTypeAndTypeService;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.compress.utils.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    private QualityProblemMapper qualityProblemMapper;

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
        for (AircraftTypeAndTime item : list) {
            setBlankData(map, list.get(0).getDevHappenTime(), list.get(list.size() - 1).getDevHappenTime(), item);
        }
        List<AircraftTypeAndTime> numList = new ArrayList(map.values());

        //按机型方式分类
        Map typeNumMap = spliteByAircraft(numList);

        List<Map> resList = new ArrayList();
        switch (aircraftTypeAndTime.getCheckedMethodName()) {
            case "allCheck":
                resList = allCheck(typeNumMap, aircraftTypeAndTime);
                break;
            case "check1":
                resList = check1(typeNumMap, aircraftTypeAndTime);
                break;
            case "check2":
                resList = check2(typeNumMap, aircraftTypeAndTime);
                break;
            case "check3":
                resList = check3(typeNumMap, aircraftTypeAndTime);
                break;
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
                        tableMap.put("eldTime", DateUtil.year(numList.get(i - 2).getDevHappenTime()) + "年第" + numList.get(i - 1).getQuarter() + "季度");
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

    //todo 先对map进行遍历，key是机型，value是数量情况，按照不同机型进行计算

    /**
     * 较上一时间增加或减少50%以上，该时间为质量问题发生故障件变化时间
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
                    if(i>=2 && isChange20PercentTwoTime(numList.get(i - 2).getNum(), numList.get(i - 1).getNum(), numList.get(i).getNum())){
                        checkCondition = checkCondition+",2";
                    }
                    //是否符合条件3
                    if(i>=3 && isMonotonicVariation(numList.get(i - 3).getNum(), numList.get(i - 2).getNum(), numList.get(i - 1).getNum(), numList.get(i).getNum())){
                        checkCondition = checkCondition+",3";
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
                    if(isChange50Percent(numList.get(i - 1).getNum(), numList.get(i).getNum())){
                        checkCondition = "1,"+checkCondition;
                    }
                    //是否符合条件3
                    if(i>=3 && isMonotonicVariation(numList.get(i - 3).getNum(), numList.get(i - 2).getNum(), numList.get(i - 1).getNum(), numList.get(i).getNum())){
                        checkCondition = checkCondition+",3";
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
                    if(isChange50Percent(numList.get(i - 1).getNum(), numList.get(i).getNum())){
                        checkCondition = "1,"+checkCondition;
                    }
                    //是否符合条件2
                    if(i>=2 && isChange20PercentTwoTime(numList.get(i - 2).getNum(), numList.get(i - 1).getNum(), numList.get(i).getNum())){
                        checkCondition = checkCondition+",2";
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
    public Map getChartData() {
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

        HashMap<Object, Object> resultMap = MapUtil.newHashMap();
        resultMap.put("xdata", xData);
        resultMap.put("list", resList);
        return resultMap;
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
     * 较上一时间增加或减少50%以上，该时间为质量问题发生故障件变化时间
     *
     * @param preVal
     * @param val
     * @return
     */
    boolean isChange50Percent(double preVal, double val) {
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
}
