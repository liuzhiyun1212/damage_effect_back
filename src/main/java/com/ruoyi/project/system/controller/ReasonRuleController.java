package com.ruoyi.project.system.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.*;
import com.ruoyi.project.system.domain.reasonrule.devupone;
import com.ruoyi.project.system.domain.reasonrule.devuptwo;
import com.ruoyi.project.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/system/reasonrule")
public class ReasonRuleController extends BaseController
{
    @Autowired
    private IQualityProblemService qualityProblemService;

    @Autowired
    private IEquipmentDesignDataService equipmentDesignDataService;

    @Autowired
    private IProductDesignService productDesignService;

    @Autowired
    private IProductModifyService productModifyService;

    @Autowired
    private IProductModifyDataService productModifyDataService;

    @Autowired
    private IPartsMakeNum9Service partsMakeNum9Service;

    @Autowired
    private IRuleConstructionService ruleConstructionService;

    @Autowired
    private IEquipmentManufacturingData5Service equipmentManufacturingData5Service;

    @Autowired
    private IReasonRuleService reasonRuleService;

    /**
     * 不同问题装备型号中，某种故障模式质量问题数量存在较大差异
     */
    @GetMapping("/devup1")
    public TableDataInfo devup1()
    {
        RuleConstruction ruleConstruction = new RuleConstruction();
        ruleConstruction.setRule("不同问题装备型号中，某种故障模式质量问题数量存在较大差异");
        List<RuleConstruction> listr = ruleConstructionService.selectRuleConstructionList(ruleConstruction);
        float ruledata = Float.parseFloat(listr.get(0).getRuleData());
        List<String> series = reasonRuleService.selectSeries();
        List<String> model = reasonRuleService.selectFaultModel();//故障模式
        List<devupone> list3 = reasonRuleService.selectDevUpOne();
        List<String> model1 = new ArrayList<String>();//故障模式
        List<String> series1 = new ArrayList<String>();//机型
        for(String s1: series){
            for(String s2: model){
                List<devupone> list4 = new ArrayList<devupone>();
                for(devupone d:list3){
                    if(d.getModelSeries().equals(s1)&&d.getFaultModel().equals(s2)&&d.getdevHappennum()>0){
                        list4.add(d);
                    }
                }
                for(int i=0;i<list4.size();i++){
                    if(i>0&&list4.get(i).getdevHappennum()>list4.get(i-1).getdevHappennum()*ruledata){
                        model1.add(list4.get(i).getFaultModel());
                        series1.add(list4.get(i).getModelSeries());
                    }
                    if(i>0&&list4.get(i).getdevHappennum()*ruledata<list4.get(i-1).getdevHappennum()){
                        model1.add(list4.get(i).getFaultModel());
                        series1.add(list4.get(i).getModelSeries());
                    }
                }
            }
        }
        List<devupone> listfin = new ArrayList<devupone>();
        for(int i=0;i<series1.size();i++){
            for(devupone d:list3){
                if(d.getModelSeries().equals(series1.get(i))&&d.getFaultModel().equals(model1.get(i))){
                    listfin.add(d);
                }
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 问题装备型号技术状态进行升级时间与质量问题变化时间一致或不超过一定范围
     */
    @GetMapping("/devup2")
    public TableDataInfo devup2()
    {
        List<devuptwo> list2 = reasonRuleService.selectDevUpTwo();
        List<String> series = reasonRuleService.selectSeries();
        List<String> name1 = new ArrayList<String>();
        List<String> series1 = new ArrayList<String>();
        for(String s1: series){
            List<devuptwo> list3 = new ArrayList<devuptwo>();
            for(devuptwo d:list2){
                if(d.getModelSeries().equals(s1)&&d.getdevHappennum()>0){
                    list3.add(d);
                }
            }
            for(int i=0;i<list3.size();i++){
                if(i>0&&list3.get(i).getdevHappennum()>list3.get(i-1).getdevHappennum()*1.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    series1.add(list3.get(i).getModelSeries());
                }
                if(i>0&&list3.get(i).getdevHappennum()<list3.get(i-1).getdevHappennum()*0.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    series1.add(list3.get(i).getModelSeries());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()*1.2&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()*1.2){
                    name1.add(list3.get(i).getDevHappenTime());
                    series1.add(list3.get(i).getModelSeries());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()*0.8&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()*0.8){
                    name1.add(list3.get(i).getDevHappenTime());
                    series1.add(list3.get(i).getModelSeries());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()>list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    series1.add(list3.get(i).getModelSeries());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()<list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    series1.add(list3.get(i).getModelSeries());
                }
            }
        }
        List<String> name2 = new ArrayList<String>();//时间
        List<String> series2 = new ArrayList<String>();//时间
        for(int i=0;i<series1.size();i++){
            List<String> time = new ArrayList<String>();
            for(devuptwo d:list2){
                if(d.getModelSeries().equals(series1.get(i))&&!time.contains(d.getDevHappenTime())){
                    time.add(d.getDevHappenTime());
                }
            }
            int t = time.size();
            EquipmentDesignData equipmentDesignData = new EquipmentDesignData();
            equipmentDesignData.setModelSeries(series1.get(i));
            List<EquipmentDesignData> listed = equipmentDesignDataService.selectEquipmentDesignDataList(equipmentDesignData);
            for(int ii=0;ii<listed.size();ii++){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(listed.get(ii).getRemodelDate());
                int a = calendar.get(Calendar.MONTH)+1;
                if(a>0&&a<4){
                    a=1;
                } else if(a>3&&a<7){
                    a=2;
                } else if(a>6&&a<10){
                    a=3;
                } else if(a>9&&a<13){
                    a=4;
                }
                String ss = calendar.get(Calendar.YEAR)+"-"+a;
                if(halfyear(name1.get(i),ss)){
                    if(time.indexOf(ss)==t-1){
                        continue;
                    }
                    name2.add(ss);
                    series2.add(series1.get(i));
                }
            }
        }
        List<devuptwo> listfin = new ArrayList<devuptwo>();
        for(String s1: series2){
            for(devuptwo d:list2){
                if(d.getModelSeries().equals(s1)&&!listfin.contains(d)){
                    listfin.add(d);
                }
            }
        }
        for(int i =0;i<series2.size();i++){
            boolean iffind = false;
            for(devuptwo d:list2){
                if(d.getDevHappenTime().equals(name2.get(i))&&d.getModelSeries().equals(series2.get(i))){
                    iffind = true;
                    devuptwo devup3 = new devuptwo();
                    devup3.setDevHappenTime(name2.get(i));
                    devup3.setModelSeries(series2.get(i));
                    devup3.setdevHappennum(-1);
                    listfin.add(devup3);
                }
            }
            if(iffind==false){
                devuptwo devup2 = new devuptwo();
                devup2.setDevHappenTime(name2.get(i));
                devup2.setModelSeries(series2.get(i));
                devup2.setdevHappennum(0);
                listfin.add(devup2);

                devuptwo devup3 = new devuptwo();
                devup3.setDevHappenTime(name2.get(i));
                devup3.setModelSeries(series2.get(i));
                devup3.setdevHappennum(-1);
                listfin.add(devup3);
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 同一型号的不同能力状态中，某种故障模式质量问题数量存在较大差异
     */
    @GetMapping("/devcapup1")
    public TableDataInfo devcapup1()
    {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        RuleConstruction ruleConstruction = new RuleConstruction();
        ruleConstruction.setRule("同一型号的不同能力状态中，某种故障模式质量问题数量存在较大差异");
        List<RuleConstruction> listr = ruleConstructionService.selectRuleConstructionList(ruleConstruction);
        float ruledata = Float.parseFloat(listr.get(0).getRuleData());
        QualityProblem qualityProblem = new QualityProblem();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        List<devupone> list1 = new ArrayList<devupone>();
        List<String> plane = reasonRuleService.selectPlane();
        List<String> mplane = reasonRuleService.selectMPlane();
        List<String> model = reasonRuleService.selectFaultModel();//故障模式
        List<String> series = reasonRuleService.selectCapabilityStatus();
        for(QualityProblem i: list){
            devupone devup1 = new devupone();
            devup1.setDevHappenTime(simpleDateFormat.format(i.getDevHappenTime()));
            devup1.setPlaneType(i.getPlaneType());
            devup1.setFaultModel(i.getFaultModel());
            devup1.setDevCode(i.getDevCode());
            devup1.setdevHappennum(1);
            list1.add(devup1);
        }
        List<devupone> list2 = new ArrayList<devupone>();
        HashMap<String, String> Sites = new HashMap<String, String>();
        int max = 0;
        for(String as1: mplane){
            if(as1!=null){
                String s1 = as1.split(";")[0];
                String s2 = as1.split(";")[1];
                List<String> name = new ArrayList<String>();//时间
                EquipmentManufacturingData5 equipmentManufacturingData5 = new EquipmentManufacturingData5();
                equipmentManufacturingData5.setPlaneType(s1);
                equipmentManufacturingData5.setDevCode(s2);
                List<EquipmentManufacturingData5> listed = equipmentManufacturingData5Service.selectEquipmentManufacturingData5List(equipmentManufacturingData5);
                if(listed.size()!=0){
                    for(int ii=0;ii<listed.size();ii++){
                        name.add(simpleDateFormat.format(listed.get(ii).getProductionUpgradeTime()));
                        Sites.put(simpleDateFormat.format(listed.get(ii).getProductionUpgradeTime()),listed.get(ii).getCapabilityStatus());
                    }
                    Collections.sort(name);
                    for(devupone d:list1){
                        if(d.getPlaneType().equals(s1)&&d.getDevCode().equals(s2)){
                            for(int a1=0;a1< name.size();a1++){
                                if(a1==name.size()-1){
                                    if(a1!=0&&d.getDevHappenTime().compareTo(name.get(a1))<0&&d.getDevHappenTime().compareTo(name.get(a1-1))>=0){
                                        devupone devup2 = new devupone();
                                        devup2.setFaultModel(d.getFaultModel());
                                        devup2.setDevHappenTime(String.valueOf(a1));
                                        devup2.setCapabilityStatus(Sites.get(name.get(a1-1)));
                                        devup2.setPlaneType(s1);
                                        devup2.setdevHappennum(1);
                                        list2.add(devup2);
                                    }else if(d.getDevHappenTime().compareTo(name.get(a1))>=0){
                                        devupone devup2 = new devupone();
                                        devup2.setFaultModel(d.getFaultModel());
                                        devup2.setDevHappenTime(String.valueOf(a1+1));
                                        devup2.setCapabilityStatus(Sites.get(name.get(a1)));
                                        devup2.setPlaneType(s1);
                                        devup2.setdevHappennum(1);
                                        list2.add(devup2);
                                    }
                                }else if(a1==0){
                                    if(d.getDevHappenTime().compareTo(name.get(a1))<0){
                                        devupone devup2 = new devupone();
                                        devup2.setFaultModel(d.getFaultModel());
                                        devup2.setDevHappenTime(String.valueOf(a1));
                                        devup2.setCapabilityStatus(Sites.get(name.get(a1)));
                                        devup2.setPlaneType(s1);
                                        devup2.setdevHappennum(1);
                                        list2.add(devup2);
                                    }
                                }else{
                                    if(d.getDevHappenTime().compareTo(name.get(a1))<0&&d.getDevHappenTime().compareTo(name.get(a1-1))>=0){
                                        devupone devup2 = new devupone();
                                        devup2.setFaultModel(d.getFaultModel());
                                        devup2.setDevHappenTime(String.valueOf(a1));
                                        devup2.setCapabilityStatus(Sites.get(name.get(a1-1)));
                                        devup2.setPlaneType(s1);
                                        devup2.setdevHappennum(1);
                                        list2.add(devup2);
                                    }
                                }
                            }
                        }
                    }
                    if(name.size()>max){
                        max= name.size();
                    }
                }
            }
        }
        List<devupone> list3 = new ArrayList<devupone>();
        for(String s1: plane){
            for(String sss:series){
                for(String s2: model){
                    int sa = 0;
                    for(devupone d:list2){
                        if(d.getPlaneType().equals(s1)&&d.getCapabilityStatus().equals(sss)&&d.getFaultModel().equals(s2)){
                            sa++;
                        }
                    }
                    if(sa>0){
                        devupone devup2 = new devupone();
                        devup2.setFaultModel(s2);
                        devup2.setCapabilityStatus(sss);
                        devup2.setPlaneType(s1);
                        devup2.setdevHappennum(sa);
                        list3.add(devup2);
                    }
                }
            }
        }
        List<String> model1 = new ArrayList<String>();//故障模式
        List<String> plane1 = new ArrayList<String>();//机型
        for(String s1: plane){
            for(String s2: model){
                List<devupone> list4 = new ArrayList<devupone>();
                for(devupone d:list3){
                    if(d.getPlaneType().equals(s1)&&d.getFaultModel().equals(s2)&&d.getdevHappennum()>0){
                        list4.add(d);
                    }
                }
                for(int i=0;i<list4.size();i++){
                    if(i>0&&list4.get(i).getdevHappennum()>list4.get(i-1).getdevHappennum()*ruledata){
                        model1.add(list4.get(i).getFaultModel());
                        plane1.add(list4.get(i).getPlaneType());
                    }
                    if(i>0&&list4.get(i).getdevHappennum()*ruledata<list4.get(i-1).getdevHappennum()){
                        model1.add(list4.get(i).getFaultModel());
                        plane1.add(list4.get(i).getPlaneType());
                    }
                }
            }
        }
        List<devupone> listfin = new ArrayList<devupone>();
        for(int i=0;i<plane1.size();i++){
            for(devupone d:list3){
                if(d.getPlaneType().equals(plane1.get(i))&&d.getFaultModel().equals(model1.get(i))){
                    listfin.add(d);
                }
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 问题装备型号能力提升时间与质量问题变化时间一致或不超过一定范围
     */
    @GetMapping("/devcapup2")
    public TableDataInfo devcapup2()
    {
        List<devuptwo> list2 = reasonRuleService.selectDevCapUpTwo();
        List<String> plane = reasonRuleService.selectPlane();//机型
        List<String> name1 = new ArrayList<String>();//时间
        List<String> plane1 = new ArrayList<String>();//机型
        for(String s1: plane){
            List<devuptwo> list3 = new ArrayList<devuptwo>();
            for(devuptwo d:list2){
                if(d.getPlaneType().equals(s1)&&d.getdevHappennum()>0){
                    list3.add(d);
                }
            }
            for(int i=0;i<list3.size();i++){
                if(i>0&&list3.get(i).getdevHappennum()>list3.get(i-1).getdevHappennum()*1.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPlaneType());
                }
                if(i>0&&list3.get(i).getdevHappennum()<list3.get(i-1).getdevHappennum()*0.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPlaneType());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()*1.2&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()*1.2){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPlaneType());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()*0.8&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()*0.8){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPlaneType());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()>list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPlaneType());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()<list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPlaneType());
                }
            }
        }
        List<String> plane2 = new ArrayList<String>();//机型
        List<String> name2 = new ArrayList<String>();//时间
        for(int i=0;i<plane1.size();i++){
            List<String> time = new ArrayList<String>();
            for(devuptwo d:list2){
                if(d.getPlaneType().equals(plane1.get(i))&&!time.contains(d.getDevHappenTime())){
                    time.add(d.getDevHappenTime());
                }
            }
            int t = time.size();
            EquipmentManufacturingData5 equipmentManufacturingData5 = new EquipmentManufacturingData5();
            equipmentManufacturingData5.setPlaneType(plane1.get(i));
            equipmentManufacturingData5.setType("能力提升");
            List<EquipmentManufacturingData5> listed = equipmentManufacturingData5Service.selectEquipmentManufacturingData5List(equipmentManufacturingData5);
            if(listed.size()!=0){
                for(int ii=0;ii<listed.size();ii++){
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(listed.get(ii).getProductionUpgradeTime());
                    int a = calendar.get(Calendar.MONTH)+1;
                    if(a>0&&a<4){
                        a=1;
                    } else if(a>3&&a<7){
                        a=2;
                    } else if(a>6&&a<10){
                        a=3;
                    } else if(a>9&&a<13){
                        a=4;
                    }
                    String ss = calendar.get(Calendar.YEAR)+"-"+a;
                    if(halfyear(name1.get(i),ss)){
                        if(time.indexOf(ss)==t-1){
                            continue;
                        }
                        plane2.add(plane1.get(i));
                        name2.add(ss);
                    }
                }
            }
        }
        List<devuptwo> listfin = new ArrayList<devuptwo>();
        for(String s1: plane2){
            for(devuptwo d:list2){
                if(d.getPlaneType().equals(s1)){
                    listfin.add(d);
                }
            }
        }
        for(int i =0;i<plane2.size();i++){
            boolean iffind = false;
            for(devuptwo d:list2){
                if(d.getPlaneType().equals(plane2.get(i))&&d.getDevHappenTime().equals(name2.get(i))){
                    iffind = true;
                    devuptwo devup3 = new devuptwo();
                    devup3.setDevHappenTime(name2.get(i));
                    devup3.setPlaneType(plane2.get(i));
                    devup3.setdevHappennum(-1);
                    listfin.add(devup3);
                }
            }
            if(iffind==false){
                devuptwo devup2 = new devuptwo();
                devup2.setDevHappenTime(name2.get(i));
                devup2.setPlaneType(plane2.get(i));
                devup2.setdevHappennum(0);
                listfin.add(devup2);

                devuptwo devup3 = new devuptwo();
                devup3.setDevHappenTime(name2.get(i));
                devup3.setPlaneType(plane2.get(i));
                devup3.setdevHappennum(-1);
                listfin.add(devup3);
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 不同故障件型号中，某种故障模式质量问题数量存在较大差异
     */
    @GetMapping("/prochaange1")
    public TableDataInfo prochaange1()
    {
        RuleConstruction ruleConstruction = new RuleConstruction();
        ruleConstruction.setRule("不同故障件型号中，某种故障模式质量问题数量存在较大差异");
        List<RuleConstruction> listr = ruleConstructionService.selectRuleConstructionList(ruleConstruction);
        float ruledata = Float.parseFloat(listr.get(0).getRuleData());
        List<String> series = reasonRuleService.selectPartsName();
        List<String> model = reasonRuleService.selectFaultModel();
        List<devuptwo> list3 = reasonRuleService.selectProChangeOne();
        List<String> model1 = new ArrayList<String>();
        List<String> series1 = new ArrayList<String>();
        for(String s1: series){
            for(String s2: model){
                List<devuptwo> list4 = new ArrayList<devuptwo>();
                for(devuptwo d:list3){
                    if(d.getPartsName().equals(s1)&&d.getFaultModel().equals(s2)&&d.getdevHappennum()>0){
                        list4.add(d);
                    }
                }
                for(int i=0;i<list4.size();i++){
                    if(i>0&&list4.get(i).getdevHappennum()>list4.get(i-1).getdevHappennum()*ruledata){
                        model1.add(list4.get(i).getFaultModel());
                        series1.add(list4.get(i).getPartsName());
                    }
                    if(i>0&&list4.get(i).getdevHappennum()*ruledata<list4.get(i-1).getdevHappennum()){
                        model1.add(list4.get(i).getFaultModel());
                        series1.add(list4.get(i).getPartsName());
                    }
                }
            }
        }
        List<devuptwo> listfin = new ArrayList<devuptwo>();
        for(int i=0;i<series1.size();i++){
            for(devuptwo d:list3){
                if(d.getPartsName().equals(series1.get(i))&&d.getFaultModel().equals(model1.get(i))){
                    listfin.add(d);
                }
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 相同故障件型号的不同安装方式中，某种故障模式质量问题数量存在较大差异
     */
    @GetMapping("/prochaange2")
    public TableDataInfo prochaange2()
    {
        RuleConstruction ruleConstruction = new RuleConstruction();
        ruleConstruction.setRule("相同故障件型号的不同安装方式中，某种故障模式质量问题数量存在较大差异");
        List<RuleConstruction> listr = ruleConstructionService.selectRuleConstructionList(ruleConstruction);
        float ruledata = Float.parseFloat(listr.get(0).getRuleData());
        List<String> mplane = reasonRuleService.selectPP();
        List<String> model = reasonRuleService.selectFaultModel();
        List<devupone> list3 = reasonRuleService.selectProChangeTwo();
        List<String> model1 = new ArrayList<String>();//故障模式
        List<String> plane1 = new ArrayList<String>();//机型
        for(String as1: mplane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            for(String s2: model){
                List<devupone> list4 = new ArrayList<devupone>();
                for(devupone d:list3){
                    if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(s2)&&d.getdevHappennum()>0){
                        list4.add(d);
                    }
                }
                for(int i=0;i<list4.size();i++){
                    if(i>0&&list4.get(i).getdevHappennum()>list4.get(i-1).getdevHappennum()*ruledata){
                        model1.add(list4.get(i).getFaultModel());
                        plane1.add(list4.get(i).getPartsName()+"/"+list4.get(i).getPartsModel());
                    }
                    if(i>0&&list4.get(i).getdevHappennum()*ruledata<list4.get(i-1).getdevHappennum()){
                        model1.add(list4.get(i).getFaultModel());
                        plane1.add(list4.get(i).getPartsName()+"/"+list4.get(i).getPartsModel());
                    }
                }
            }
        }
        List<devupone> listfin = new ArrayList<devupone>();
        for(int i=0;i<plane1.size();i++){
            String s1 = plane1.get(i).split("/")[0];
            String ss = plane1.get(i).split("/")[1];
            for(devupone d:list3){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(model1.get(i))){
                    listfin.add(d);
                }
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 相同故障件型号的不同安装位置中，某种故障模式质量问题数量存在较大差异
     */
    @GetMapping("/prochaange3")
    public TableDataInfo prochaange3()
    {
        RuleConstruction ruleConstruction = new RuleConstruction();
        ruleConstruction.setRule("相同故障件型号的不同安装位置中，某种故障模式质量问题数量存在较大差异");
        List<RuleConstruction> listr = ruleConstructionService.selectRuleConstructionList(ruleConstruction);
        float ruledata = Float.parseFloat(listr.get(0).getRuleData());
        List<String> mplane = reasonRuleService.selectPP();
        List<String> model = reasonRuleService.selectFaultModel();
        List<devupone> list3 = reasonRuleService.selectProChangeThree();
        List<String> model1 = new ArrayList<String>();//故障模式
        List<String> plane1 = new ArrayList<String>();//机型
        for(String as1: mplane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            for(String s2: model){
                List<devupone> list4 = new ArrayList<devupone>();
                for(devupone d:list3){
                    if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(s2)&&d.getdevHappennum()>0){
                        list4.add(d);
                    }
                }
                for(int i=0;i<list4.size();i++){
                    if(i>0&&list4.get(i).getdevHappennum()>list4.get(i-1).getdevHappennum()*ruledata){
                        model1.add(list4.get(i).getFaultModel());
                        plane1.add(list4.get(i).getPartsName()+"/"+list4.get(i).getPartsModel());
                    }
                    if(i>0&&list4.get(i).getdevHappennum()*ruledata<list4.get(i-1).getdevHappennum()){
                        model1.add(list4.get(i).getFaultModel());
                        plane1.add(list4.get(i).getPartsName()+"/"+list4.get(i).getPartsModel());
                    }
                }
            }
        }
        List<devupone> listfin = new ArrayList<devupone>();
        for(int i=0;i<plane1.size();i++){
            String s1 = plane1.get(i).split("/")[0];
            String ss = plane1.get(i).split("/")[1];
            for(devupone d:list3){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(model1.get(i))){
                    listfin.add(d);
                }
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 故障件型号技术状态升级时间与质量问题数量变化时间一致或不超过一定范围
     */
    @GetMapping("/prochaange4")
    public TableDataInfo prochaange4()
    {
        List<devuptwo> list2 = reasonRuleService.selectProChangeFour();
        List<String> series = reasonRuleService.selectPartsName();//故障件名称
        List<String> name1 = new ArrayList<String>();//时间
        List<String> series1 = new ArrayList<String>();//机型
        for(String s1: series){
            List<devuptwo> list3 = new ArrayList<devuptwo>();
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getdevHappennum()>0){
                    list3.add(d);
                }
            }
            for(int i=0;i<list3.size();i++){
                if(i>0&&list3.get(i).getdevHappennum()>list3.get(i-1).getdevHappennum()*1.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    series1.add(list3.get(i).getPartsName());
                }
                if(i>0&&list3.get(i).getdevHappennum()<list3.get(i-1).getdevHappennum()*0.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    series1.add(list3.get(i).getPartsName());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()*1.2&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()*1.2){
                    name1.add(list3.get(i).getDevHappenTime());
                    series1.add(list3.get(i).getPartsName());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()*0.8&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()*0.8){
                    name1.add(list3.get(i).getDevHappenTime());
                    series1.add(list3.get(i).getPartsName());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()>list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    series1.add(list3.get(i).getPartsName());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()<list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    series1.add(list3.get(i).getPartsName());
                }
            }
        }
        List<String> name2 = new ArrayList<String>();//时间
        List<String> series2 = new ArrayList<String>();//时间
        for(int i=0;i<series1.size();i++){
            List<String> time = new ArrayList<String>();
            for(devuptwo d:list2){
                if(d.getPartsName().equals(series1.get(i))&&!time.contains(d.getDevHappenTime())){
                    time.add(d.getDevHappenTime());
                }
            }
            int t = time.size();
            ProductModify equipmentDesignData = new ProductModify();
            equipmentDesignData.setProductName(series1.get(i));
            List<ProductModify> listed = productModifyService.selectProductModifyList(equipmentDesignData);
            for(int ii=0;ii<listed.size();ii++){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(listed.get(ii).getModifyTime());
                int a = calendar.get(Calendar.MONTH)+1;
                if(a>0&&a<4){
                    a=1;
                } else if(a>3&&a<7){
                    a=2;
                } else if(a>6&&a<10){
                    a=3;
                } else if(a>9&&a<13){
                    a=4;
                }
                String ss = calendar.get(Calendar.YEAR)+"-"+a;
                if(halfyear(name1.get(i),ss)){
                    if(time.indexOf(ss)==t-1){
                        continue;
                    }
                    name2.add(ss);
                    series2.add(series1.get(i));
                }
            }
        }
        List<devuptwo> listfin = new ArrayList<devuptwo>();
        for(String s1: series2){
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&!listfin.contains(d)){
                    listfin.add(d);
                }
            }
        }
        for(int i =0;i<series2.size();i++){
            boolean iffind = false;
            for(devuptwo d:list2){
                if(d.getDevHappenTime().equals(name2.get(i))&&d.getPartsName().equals(series2.get(i))){
                    iffind = true;
                    devuptwo devup3 = new devuptwo();
                    devup3.setDevHappenTime(name2.get(i));
                    devup3.setPartsName(series2.get(i));
                    devup3.setdevHappennum(-1);
                    listfin.add(devup3);
                }
            }
            if(iffind==false){
                devuptwo devup2 = new devuptwo();
                devup2.setDevHappenTime(name2.get(i));
                devup2.setPartsName(series2.get(i));
                devup2.setdevHappennum(0);
                listfin.add(devup2);

                devuptwo devup3 = new devuptwo();
                devup3.setDevHappenTime(name2.get(i));
                devup3.setPartsName(series2.get(i));
                devup3.setdevHappennum(-1);
                listfin.add(devup3);
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 不同生产班组生产的相同故障件型号中，某种故障模式质量问题数量存在较大差异
     */
    @GetMapping("/proteam1")
    public TableDataInfo proteam1()
    {
        RuleConstruction ruleConstruction = new RuleConstruction();
        ruleConstruction.setRule("不同生产班组生产的相同故障件型号中，某种故障模式质量问题数量存在较大差异");
        List<RuleConstruction> listr = ruleConstructionService.selectRuleConstructionList(ruleConstruction);
        float ruledata = Float.parseFloat(listr.get(0).getRuleData());
        List<String> mplane = reasonRuleService.selectPP();
        List<String> model = reasonRuleService.selectFaultModel();
        List<String> series = reasonRuleService.selectPartsMakeGroup();
        List<devupone> list3 = reasonRuleService.selectProTeamOne();
        List<String> model1 = new ArrayList<String>();//故障模式
        List<String> plane1 = new ArrayList<String>();//机型
        for(String as1: mplane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            for(String s2: model){
                List<devupone> list4 = new ArrayList<devupone>();
                for(devupone d:list3){
                    if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(s2)&&d.getdevHappennum()>0){
                        list4.add(d);
                    }
                }
                for(int i=0;i<list4.size();i++){
                    if(i>0&&list4.get(i).getdevHappennum()>list4.get(i-1).getdevHappennum()*ruledata){
                        model1.add(list4.get(i).getFaultModel());
                        plane1.add(list4.get(i).getPartsName()+"/"+list4.get(i).getPartsModel());
                    }
                    if(i>0&&list4.get(i).getdevHappennum()*ruledata<list4.get(i-1).getdevHappennum()){
                        model1.add(list4.get(i).getFaultModel());
                        plane1.add(list4.get(i).getPartsName()+"/"+list4.get(i).getPartsModel());
                    }
                }
            }
        }
        List<devupone> listfin = new ArrayList<devupone>();
        for(int i=0;i<plane1.size();i++){
            String s1 = plane1.get(i).split("/")[0];
            String ss = plane1.get(i).split("/")[1];
            for(devupone d:list3){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(model1.get(i))){
                    int a1 = series.indexOf(d.getPartsMakeGroup());
                    d.setDevHappenTime(String.valueOf(a1));
                    listfin.add(d);
                }
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 某故障件型号生产班组发生调整时间与质量问题数量变化时间一致或不超过一定范围
     */
    @GetMapping("/proteam2")
    public TableDataInfo proteam2()
    {
        List<devuptwo> list2 = reasonRuleService.selectMakeLine();
        List<String> plane = reasonRuleService.selectPP();//机型
        List<String> name1 = new ArrayList<String>();//时间
        List<String> plane1 = new ArrayList<String>();//机型
        List<String> series1 = new ArrayList<String>();//机型
        for(String as1: plane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            List<devuptwo> list3 = new ArrayList<devuptwo>();
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getdevHappennum()>0){
                    list3.add(d);
                }
            }
            for(int i=0;i<list3.size();i++){
                if(i>0&&list3.get(i).getdevHappennum()>list3.get(i-1).getdevHappennum()*1.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i>0&&list3.get(i).getdevHappennum()<list3.get(i-1).getdevHappennum()*0.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()*1.2&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()*1.2){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()*0.8&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()*0.8){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()>list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()<list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
            }
        }
        List<String> plane2 = new ArrayList<String>();
        List<String> series2 = new ArrayList<String>();
        List<String> name2 = new ArrayList<String>();
        for(int i=0;i<plane1.size();i++){
            List<String> time = new ArrayList<String>();
            for(devuptwo d:list2){
                if(d.getPartsName().equals(plane1.get(i))&&d.getPartsModel().equals(series1.get(i))&&!time.contains(d.getDevHappenTime())){
                    time.add(d.getDevHappenTime());
                }
            }
            int t = time.size();
            ProductModifyData equipmentManufacturingData5 = new ProductModifyData();
            equipmentManufacturingData5.setProductName(plane1.get(i));
            equipmentManufacturingData5.setProductModel(series1.get(i));
            equipmentManufacturingData5.setModifyType("生产班组变更");
            List<ProductModifyData> listed = productModifyDataService.selectProductModifyDataList(equipmentManufacturingData5);
            if(listed.size()!=0){
                for(int ii=0;ii<listed.size();ii++){
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(listed.get(ii).getModifyTime());
                    int a = calendar.get(Calendar.MONTH)+1;
                    if(a>0&&a<4){
                        a=1;
                    } else if(a>3&&a<7){
                        a=2;
                    } else if(a>6&&a<10){
                        a=3;
                    } else if(a>9&&a<13){
                        a=4;
                    }
                    String ss = calendar.get(Calendar.YEAR)+"-"+a;
                    if(halfyear(name1.get(i),ss)){
                        if(time.indexOf(ss)==t-1){
                            continue;
                        }
                        plane2.add(plane1.get(i));
                        series2.add(series1.get(i));
                        name2.add(ss);
                    }
                }
            }
        }
        List<devuptwo> listfin = new ArrayList<devuptwo>();
        for(int i=0;i<plane2.size();i++){
            String s1 =  plane2.get(i);
            String ss =  series2.get(i);
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)){
                    listfin.add(d);
                }
            }
        }
        for(int i =0;i<plane2.size();i++){
            boolean iffind = false;
            String s1 =  plane2.get(i);
            String ss =  series2.get(i);
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getDevHappenTime().equals(name2.get(i))){
                    iffind = true;
                    devuptwo devup3 = new devuptwo();
                    devup3.setDevHappenTime(name2.get(i));
                    devup3.setPartsName(plane2.get(i));
                    devup3.setPartsModel(series2.get(i));
                    devup3.setdevHappennum(-1);
                    listfin.add(devup3);
                }
            }
            if(iffind==false){
                devuptwo devup2 = new devuptwo();
                devup2.setDevHappenTime(name2.get(i));
                devup2.setPartsName(plane2.get(i));
                devup2.setPartsModel(series2.get(i));
                devup2.setdevHappennum(0);
                listfin.add(devup2);

                devuptwo devup3 = new devuptwo();
                devup3.setDevHappenTime(name2.get(i));
                devup3.setPartsName(plane2.get(i));
                devup3.setPartsModel(series2.get(i));
                devup3.setdevHappennum(-1);
                listfin.add(devup3);
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 不同生产人员生产的相同故障件中，某种故障模式质量问题数量存在较大差异
     */
    @GetMapping("/properson1")
    public TableDataInfo properson1()
    {
        RuleConstruction ruleConstruction = new RuleConstruction();
        ruleConstruction.setRule("不同生产人员生产的相同故障件中，某种故障模式质量问题数量存在较大差异");
        List<RuleConstruction> listr = ruleConstructionService.selectRuleConstructionList(ruleConstruction);
        float ruledata = Float.parseFloat(listr.get(0).getRuleData());
        List<String> mplane = reasonRuleService.selectPP();
        List<String> model = reasonRuleService.selectFaultModel();
        List<String> series = reasonRuleService.selectPartsMakePeople();
        List<devupone> list3 = reasonRuleService.selectProPersonOne();
        List<String> model1 = new ArrayList<String>();//故障模式
        List<String> plane1 = new ArrayList<String>();//机型
        for(String as1: mplane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            for(String s2: model){
                List<devupone> list4 = new ArrayList<devupone>();
                for(devupone d:list3){
                    if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(s2)&&d.getdevHappennum()>0){
                        list4.add(d);
                    }
                }
                for(int i=0;i<list4.size();i++){
                    if(i>0&&list4.get(i).getdevHappennum()>list4.get(i-1).getdevHappennum()*ruledata){
                        model1.add(list4.get(i).getFaultModel());
                        plane1.add(list4.get(i).getPartsName()+"/"+list4.get(i).getPartsModel());
                    }
                    if(i>0&&list4.get(i).getdevHappennum()*ruledata<list4.get(i-1).getdevHappennum()){
                        model1.add(list4.get(i).getFaultModel());
                        plane1.add(list4.get(i).getPartsName()+"/"+list4.get(i).getPartsModel());
                    }
                }
            }
        }
        List<devupone> listfin = new ArrayList<devupone>();
        for(int i=0;i<plane1.size();i++){
            String s1 = plane1.get(i).split("/")[0];
            String ss = plane1.get(i).split("/")[1];
            for(devupone d:list3){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(model1.get(i))){
                    int a1 = series.indexOf(d.getPartsMakePeople());
                    d.setDevHappenTime(String.valueOf(a1));
                    listfin.add(d);
                }
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 大量生产新员工入职或老员工离职/换岗与质量问题数量变化时间一致或不超过一定范围
     */
    @GetMapping("/properson2")
    public TableDataInfo properson2()
    {
        List<devuptwo> list2 = reasonRuleService.selectMakeLine();
        List<String> plane = reasonRuleService.selectPP();//机型
        List<String> name1 = new ArrayList<String>();//时间
        List<String> plane1 = new ArrayList<String>();//机型
        List<String> series1 = new ArrayList<String>();//机型
        for(String as1: plane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            List<devuptwo> list3 = new ArrayList<devuptwo>();
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getdevHappennum()>0){
                    list3.add(d);
                }
            }
            for(int i=0;i<list3.size();i++){
                if(i>0&&list3.get(i).getdevHappennum()>list3.get(i-1).getdevHappennum()*1.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i>0&&list3.get(i).getdevHappennum()<list3.get(i-1).getdevHappennum()*0.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()*1.2&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()*1.2){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()*0.8&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()*0.8){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()>list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()<list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
            }
        }
        List<String> plane2 = new ArrayList<String>();
        List<String> series2 = new ArrayList<String>();
        List<String> name2 = new ArrayList<String>();
        List<String> type2 = new ArrayList<String>();
        for(int i=0;i<plane1.size();i++){
            List<String> time = new ArrayList<String>();
            for(devuptwo d:list2){
                if(d.getPartsName().equals(plane1.get(i))&&d.getPartsModel().equals(series1.get(i))&&!time.contains(d.getDevHappenTime())){
                    time.add(d.getDevHappenTime());
                }
            }
            int t = time.size();
            ProductModifyData equipmentManufacturingData5 = new ProductModifyData();
            equipmentManufacturingData5.setProductName(plane1.get(i));
            equipmentManufacturingData5.setProductModel(series1.get(i));
            equipmentManufacturingData5.setModifyType("生产人员变更");
            List<ProductModifyData> listed = productModifyDataService.selectProductModifyDataList(equipmentManufacturingData5);
            if(listed.size()!=0){
                for(int ii=0;ii<listed.size();ii++){
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(listed.get(ii).getModifyTime());
                    int a = calendar.get(Calendar.MONTH)+1;
                    if(a>0&&a<4){
                        a=1;
                    } else if(a>3&&a<7){
                        a=2;
                    } else if(a>6&&a<10){
                        a=3;
                    } else if(a>9&&a<13){
                        a=4;
                    }
                    String ss = calendar.get(Calendar.YEAR)+"-"+a;
                    if(halfyear(name1.get(i),ss)){
                        if(time.indexOf(ss)==t-1){
                            continue;
                        }
                        plane2.add(plane1.get(i));
                        series2.add(series1.get(i));
                        name2.add(ss);
                        type2.add(listed.get(ii).getModifyMethod());
                    }
                }
            }
        }
        List<devuptwo> listfin = new ArrayList<devuptwo>();
        for(int i=0;i<plane2.size();i++){
            String s1 =  plane2.get(i);
            String ss =  series2.get(i);
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)){
                    listfin.add(d);
                }
            }
        }
        for(int i =0;i<plane2.size();i++){
            boolean iffind = false;
            String s1 =  plane2.get(i);
            String ss =  series2.get(i);
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getDevHappenTime().equals(name2.get(i))){
                    iffind = true;
                    devuptwo devup3 = new devuptwo();
                    devup3.setDevHappenTime(name2.get(i));
                    devup3.setPartsName(plane2.get(i));
                    devup3.setPartsModel(series2.get(i));
                    devup3.setInstallMethod(type2.get(i));
                    devup3.setdevHappennum(-1);
                    listfin.add(devup3);
                }
            }
            if(iffind==false){
                devuptwo devup2 = new devuptwo();
                devup2.setDevHappenTime(name2.get(i));
                devup2.setPartsName(plane2.get(i));
                devup2.setPartsModel(series2.get(i));
                devup2.setdevHappennum(0);
                listfin.add(devup2);

                devuptwo devup3 = new devuptwo();
                devup3.setDevHappenTime(name2.get(i));
                devup3.setPartsName(plane2.get(i));
                devup3.setPartsModel(series2.get(i));
                devup3.setInstallMethod(type2.get(i));
                devup3.setdevHappennum(-1);
                listfin.add(devup3);
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 不同生产设备生产的相同故障件中，某种故障模式质量问题数量存在较大差异
     */
    @GetMapping("/promakedev1")
    public TableDataInfo promakedev1()
    {
        RuleConstruction ruleConstruction = new RuleConstruction();
        ruleConstruction.setRule("不同生产设备生产的相同故障件中，某种故障模式质量问题数量存在较大差异");
        List<RuleConstruction> listr = ruleConstructionService.selectRuleConstructionList(ruleConstruction);
        float ruledata = Float.parseFloat(listr.get(0).getRuleData());
        List<String> mplane = reasonRuleService.selectPP();
        List<String> model = reasonRuleService.selectFaultModel();
        List<String> series = reasonRuleService.selectPartsMakeQuipment();
        List<devupone> list3 = reasonRuleService.selectProMakeDevOne();
        List<String> model1 = new ArrayList<String>();//故障模式
        List<String> plane1 = new ArrayList<String>();//机型
        for(String as1: mplane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            for(String s2: model){
                List<devupone> list4 = new ArrayList<devupone>();
                for(devupone d:list3){
                    if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(s2)&&d.getdevHappennum()>0){
                        list4.add(d);
                    }
                }
                for(int i=0;i<list4.size();i++){
                    if(i>0&&list4.get(i).getdevHappennum()>list4.get(i-1).getdevHappennum()*ruledata){
                        model1.add(list4.get(i).getFaultModel());
                        plane1.add(list4.get(i).getPartsName()+"/"+list4.get(i).getPartsModel());
                    }
                    if(i>0&&list4.get(i).getdevHappennum()*ruledata<list4.get(i-1).getdevHappennum()){
                        model1.add(list4.get(i).getFaultModel());
                        plane1.add(list4.get(i).getPartsName()+"/"+list4.get(i).getPartsModel());
                    }
                }
            }
        }
        List<devupone> listfin = new ArrayList<devupone>();
        for(int i=0;i<plane1.size();i++){
            String s1 = plane1.get(i).split("/")[0];
            String ss = plane1.get(i).split("/")[1];
            for(devupone d:list3){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(model1.get(i))){
                    int a1 = series.indexOf(d.getPartsMakeQuipment());
                    d.setDevHappenTime(String.valueOf(a1));
                    listfin.add(d);
                }
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 生产线大量新设备开始使用时间与质量问题数量变化时间一致或不超过一定范围
     */
    @GetMapping("/promakedev2")
    public TableDataInfo promakedev2()
    {
        List<devuptwo> list2 = reasonRuleService.selectMakeLine();
        List<String> plane = reasonRuleService.selectPP();//机型
        List<String> name1 = new ArrayList<String>();//时间
        List<String> plane1 = new ArrayList<String>();//机型
        List<String> series1 = new ArrayList<String>();//机型
        for(String as1: plane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            List<devuptwo> list3 = new ArrayList<devuptwo>();
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getdevHappennum()>0){
                    list3.add(d);
                }
            }
            for(int i=0;i<list3.size();i++){
                if(i>0&&list3.get(i).getdevHappennum()>list3.get(i-1).getdevHappennum()*1.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i>0&&list3.get(i).getdevHappennum()<list3.get(i-1).getdevHappennum()*0.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()*1.2&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()*1.2){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()*0.8&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()*0.8){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()>list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()<list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
            }
        }
        List<String> plane2 = new ArrayList<String>();
        List<String> series2 = new ArrayList<String>();
        List<String> name2 = new ArrayList<String>();
        for(int i=0;i<plane1.size();i++){
            List<String> time = new ArrayList<String>();
            for(devuptwo d:list2){
                if(d.getPartsName().equals(plane1.get(i))&&d.getPartsModel().equals(series1.get(i))&&!time.contains(d.getDevHappenTime())){
                    time.add(d.getDevHappenTime());
                }
            }
            int t = time.size();
            ProductModifyData equipmentManufacturingData5 = new ProductModifyData();
            equipmentManufacturingData5.setProductName(plane1.get(i));
            equipmentManufacturingData5.setProductModel(series1.get(i));
            equipmentManufacturingData5.setModifyType("生产设备变更");
            equipmentManufacturingData5.setModifyMethod("生产线大量新设备开始使用");
            List<ProductModifyData> listed = productModifyDataService.selectProductModifyDataList(equipmentManufacturingData5);
            if(listed.size()!=0){
                for(int ii=0;ii<listed.size();ii++){
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(listed.get(ii).getModifyTime());
                    int a = calendar.get(Calendar.MONTH)+1;
                    if(a>0&&a<4){
                        a=1;
                    } else if(a>3&&a<7){
                        a=2;
                    } else if(a>6&&a<10){
                        a=3;
                    } else if(a>9&&a<13){
                        a=4;
                    }
                    String ss = calendar.get(Calendar.YEAR)+"-"+a;
                    if(halfyear(name1.get(i),ss)){
                        if(time.indexOf(ss)==t-1){
                            continue;
                        }
                        plane2.add(plane1.get(i));
                        series2.add(series1.get(i));
                        name2.add(ss);
                    }
                }
            }
        }
        List<devuptwo> listfin = new ArrayList<devuptwo>();
        for(int i=0;i<plane2.size();i++){
            String s1 =  plane2.get(i);
            String ss =  series2.get(i);
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)){
                    listfin.add(d);
                }
            }
        }
        for(int i =0;i<plane2.size();i++){
            boolean iffind = false;
            String s1 =  plane2.get(i);
            String ss =  series2.get(i);
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getDevHappenTime().equals(name2.get(i))){
                    iffind = true;
                    devuptwo devup3 = new devuptwo();
                    devup3.setDevHappenTime(name2.get(i));
                    devup3.setPartsName(plane2.get(i));
                    devup3.setPartsModel(series2.get(i));
                    devup3.setdevHappennum(-1);
                    listfin.add(devup3);
                }
            }
            if(iffind==false){
                devuptwo devup2 = new devuptwo();
                devup2.setDevHappenTime(name2.get(i));
                devup2.setPartsName(plane2.get(i));
                devup2.setPartsModel(series2.get(i));
                devup2.setdevHappennum(0);
                listfin.add(devup2);

                devuptwo devup3 = new devuptwo();
                devup3.setDevHappenTime(name2.get(i));
                devup3.setPartsName(plane2.get(i));
                devup3.setPartsModel(series2.get(i));
                devup3.setdevHappennum(-1);
                listfin.add(devup3);
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 生产线进行升级或更换时间与质量问题数量变化时间一致或不超过一定范围
     */
    @GetMapping("/promakedev3")
    public TableDataInfo promakedev3()
    {
        List<devuptwo> list2 = reasonRuleService.selectMakeLine();
        List<String> plane = reasonRuleService.selectPP();//机型
        List<String> name1 = new ArrayList<String>();//时间
        List<String> plane1 = new ArrayList<String>();//机型
        List<String> series1 = new ArrayList<String>();//机型
        for(String as1: plane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            List<devuptwo> list3 = new ArrayList<devuptwo>();
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getdevHappennum()>0){
                    list3.add(d);
                }
            }
            for(int i=0;i<list3.size();i++){
                if(i>0&&list3.get(i).getdevHappennum()>list3.get(i-1).getdevHappennum()*1.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i>0&&list3.get(i).getdevHappennum()<list3.get(i-1).getdevHappennum()*0.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()*1.2&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()*1.2){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()*0.8&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()*0.8){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()>list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()<list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
            }
        }
        List<String> plane2 = new ArrayList<String>();
        List<String> series2 = new ArrayList<String>();
        List<String> name2 = new ArrayList<String>();
        for(int i=0;i<plane1.size();i++){
            List<String> time = new ArrayList<String>();
            for(devuptwo d:list2){
                if(d.getPartsName().equals(plane1.get(i))&&d.getPartsModel().equals(series1.get(i))&&!time.contains(d.getDevHappenTime())){
                    time.add(d.getDevHappenTime());
                }
            }
            int t = time.size();
            ProductModifyData equipmentManufacturingData5 = new ProductModifyData();
            equipmentManufacturingData5.setProductName(plane1.get(i));
            equipmentManufacturingData5.setProductModel(series1.get(i));
            equipmentManufacturingData5.setModifyType("生产设备变更");
            equipmentManufacturingData5.setModifyMethod("生产线进行升级或更换");
            List<ProductModifyData> listed = productModifyDataService.selectProductModifyDataList(equipmentManufacturingData5);
            if(listed.size()!=0){
                for(int ii=0;ii<listed.size();ii++){
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(listed.get(ii).getModifyTime());
                    int a = calendar.get(Calendar.MONTH)+1;
                    if(a>0&&a<4){
                        a=1;
                    } else if(a>3&&a<7){
                        a=2;
                    } else if(a>6&&a<10){
                        a=3;
                    } else if(a>9&&a<13){
                        a=4;
                    }
                    String ss = calendar.get(Calendar.YEAR)+"-"+a;
                    if(halfyear(name1.get(i),ss)){
                        if(time.indexOf(ss)==t-1){
                            continue;
                        }
                        plane2.add(plane1.get(i));
                        series2.add(series1.get(i));
                        name2.add(ss);
                    }
                }
            }
        }
        List<devuptwo> listfin = new ArrayList<devuptwo>();
        for(int i=0;i<plane2.size();i++){
            String s1 =  plane2.get(i);
            String ss =  series2.get(i);
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)){
                    listfin.add(d);
                }
            }
        }
        for(int i =0;i<plane2.size();i++){
            boolean iffind = false;
            String s1 =  plane2.get(i);
            String ss =  series2.get(i);
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getDevHappenTime().equals(name2.get(i))){
                    iffind = true;
                    devuptwo devup3 = new devuptwo();
                    devup3.setDevHappenTime(name2.get(i));
                    devup3.setPartsName(plane2.get(i));
                    devup3.setPartsModel(series2.get(i));
                    devup3.setdevHappennum(-1);
                    listfin.add(devup3);
                }
            }
            if(iffind==false){
                devuptwo devup2 = new devuptwo();
                devup2.setDevHappenTime(name2.get(i));
                devup2.setPartsName(plane2.get(i));
                devup2.setPartsModel(series2.get(i));
                devup2.setdevHappennum(0);
                listfin.add(devup2);

                devuptwo devup3 = new devuptwo();
                devup3.setDevHappenTime(name2.get(i));
                devup3.setPartsName(plane2.get(i));
                devup3.setPartsModel(series2.get(i));
                devup3.setdevHappennum(-1);
                listfin.add(devup3);
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 不同测量设备测量的相同故障件中，某种故障模式质量问题数量存在较大差异
     */
    @GetMapping("/promeasuringdev1")
    public TableDataInfo promeasuringdev1()
    {
        RuleConstruction ruleConstruction = new RuleConstruction();
        ruleConstruction.setRule("不同测量设备测量的相同故障件中，某种故障模式质量问题数量存在较大差异");
        List<RuleConstruction> listr = ruleConstructionService.selectRuleConstructionList(ruleConstruction);
        float ruledata = Float.parseFloat(listr.get(0).getRuleData());
        List<String> mplane = reasonRuleService.selectPP();
        List<String> model = reasonRuleService.selectFaultModel();
        List<String> series = reasonRuleService.selectPartsMeasuringQuipment();
        List<devupone> list3 = reasonRuleService.selectProMeasuringDevOne();
        List<String> model1 = new ArrayList<String>();//故障模式
        List<String> plane1 = new ArrayList<String>();//机型
        for(String as1: mplane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            for(String s2: model){
                List<devupone> list4 = new ArrayList<devupone>();
                for(devupone d:list3){
                    if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(s2)&&d.getdevHappennum()>0){
                        list4.add(d);
                    }
                }
                for(int i=0;i<list4.size();i++){
                    if(i>0&&list4.get(i).getdevHappennum()>list4.get(i-1).getdevHappennum()*ruledata){
                        model1.add(list4.get(i).getFaultModel());
                        plane1.add(list4.get(i).getPartsName()+"/"+list4.get(i).getPartsModel());
                    }
                    if(i>0&&list4.get(i).getdevHappennum()*ruledata<list4.get(i-1).getdevHappennum()){
                        model1.add(list4.get(i).getFaultModel());
                        plane1.add(list4.get(i).getPartsName()+"/"+list4.get(i).getPartsModel());
                    }
                }
            }
        }
        List<devupone> listfin = new ArrayList<devupone>();
        for(int i=0;i<plane1.size();i++){
            String s1 = plane1.get(i).split("/")[0];
            String ss = plane1.get(i).split("/")[1];
            for(devupone d:list3){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(model1.get(i))){
                    int a1 = series.indexOf(d.getPartsMeasuringQuipment());
                    d.setDevHappenTime(String.valueOf(a1));
                    listfin.add(d);
                }
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 故障件生产中测量设备批量更换时间与质量问题数量变化时间一致或不超过一定范围
     */
    @GetMapping("/promeasuringdev2")
    public TableDataInfo promeasuringdev2()
    {
        List<devuptwo> list2 = reasonRuleService.selectMakeLine();
        List<String> plane = reasonRuleService.selectPP();//机型
        List<String> name1 = new ArrayList<String>();//时间
        List<String> plane1 = new ArrayList<String>();//机型
        List<String> series1 = new ArrayList<String>();//机型
        for(String as1: plane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            List<devuptwo> list3 = new ArrayList<devuptwo>();
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getdevHappennum()>0){
                    list3.add(d);
                }
            }
            for(int i=0;i<list3.size();i++){
                if(i>0&&list3.get(i).getdevHappennum()>list3.get(i-1).getdevHappennum()*1.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i>0&&list3.get(i).getdevHappennum()<list3.get(i-1).getdevHappennum()*0.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()*1.2&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()*1.2){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()*0.8&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()*0.8){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()>list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()<list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
            }
        }
        List<String> plane2 = new ArrayList<String>();
        List<String> series2 = new ArrayList<String>();
        List<String> name2 = new ArrayList<String>();
        for(int i=0;i<plane1.size();i++){
            List<String> time = new ArrayList<String>();
            for(devuptwo d:list2){
                if(d.getPartsName().equals(plane1.get(i))&&d.getPartsModel().equals(series1.get(i))&&!time.contains(d.getDevHappenTime())){
                    time.add(d.getDevHappenTime());
                }
            }
            int t = time.size();
            ProductModifyData equipmentManufacturingData5 = new ProductModifyData();
            equipmentManufacturingData5.setProductName(plane1.get(i));
            equipmentManufacturingData5.setProductModel(series1.get(i));
            equipmentManufacturingData5.setModifyType("检测设备变更");
            equipmentManufacturingData5.setModifyMethod("故障件生产中测量设备批量更换");
            List<ProductModifyData> listed = productModifyDataService.selectProductModifyDataList(equipmentManufacturingData5);
            if(listed.size()!=0){
                for(int ii=0;ii<listed.size();ii++){
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(listed.get(ii).getModifyTime());
                    int a = calendar.get(Calendar.MONTH)+1;
                    if(a>0&&a<4){
                        a=1;
                    } else if(a>3&&a<7){
                        a=2;
                    } else if(a>6&&a<10){
                        a=3;
                    } else if(a>9&&a<13){
                        a=4;
                    }
                    String ss = calendar.get(Calendar.YEAR)+"-"+a;
                    if(halfyear(name1.get(i),ss)){
                        if(time.indexOf(ss)==t-1){
                            continue;
                        }
                        plane2.add(plane1.get(i));
                        series2.add(series1.get(i));
                        name2.add(ss);
                    }
                }
            }
        }
        List<devuptwo> listfin = new ArrayList<devuptwo>();
        for(int i=0;i<plane2.size();i++){
            String s1 =  plane2.get(i);
            String ss =  series2.get(i);
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)){
                    listfin.add(d);
                }
            }
        }
        for(int i =0;i<plane2.size();i++){
            boolean iffind = false;
            String s1 =  plane2.get(i);
            String ss =  series2.get(i);
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getDevHappenTime().equals(name2.get(i))){
                    iffind = true;
                    devuptwo devup3 = new devuptwo();
                    devup3.setDevHappenTime(name2.get(i));
                    devup3.setPartsName(plane2.get(i));
                    devup3.setPartsModel(series2.get(i));
                    devup3.setdevHappennum(-1);
                    listfin.add(devup3);
                }
            }
            if(iffind==false){
                devuptwo devup2 = new devuptwo();
                devup2.setDevHappenTime(name2.get(i));
                devup2.setPartsName(plane2.get(i));
                devup2.setPartsModel(series2.get(i));
                devup2.setdevHappennum(0);
                listfin.add(devup2);

                devuptwo devup3 = new devuptwo();
                devup3.setDevHappenTime(name2.get(i));
                devup3.setPartsName(plane2.get(i));
                devup3.setPartsModel(series2.get(i));
                devup3.setdevHappennum(-1);
                listfin.add(devup3);
            }
        }
        return getDataTable(listfin);
    }

    /**
     * 故障件出厂检测的测量设备批量更换时间与质量问题数量变化时间一致或不超过一定范围
     */
    @GetMapping("/promeasuringdev3")
    public TableDataInfo promeasuringdev3()
    {
        List<devuptwo> list2 = reasonRuleService.selectMakeLine();
        List<String> plane = reasonRuleService.selectPP();//机型
        List<String> name1 = new ArrayList<String>();//时间
        List<String> plane1 = new ArrayList<String>();//机型
        List<String> series1 = new ArrayList<String>();//机型
        for(String as1: plane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            List<devuptwo> list3 = new ArrayList<devuptwo>();
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getdevHappennum()>0){
                    list3.add(d);
                }
            }
            for(int i=0;i<list3.size();i++){
                if(i>0&&list3.get(i).getdevHappennum()>list3.get(i-1).getdevHappennum()*1.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i>0&&list3.get(i).getdevHappennum()<list3.get(i-1).getdevHappennum()*0.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()*1.2&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()*1.2){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()*0.8&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()*0.8){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()>list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()<list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPartsName());
                    series1.add(list3.get(i).getPartsModel());
                }
            }
        }
        List<String> plane2 = new ArrayList<String>();
        List<String> series2 = new ArrayList<String>();
        List<String> name2 = new ArrayList<String>();
        for(int i=0;i<plane1.size();i++){
            List<String> time = new ArrayList<String>();
            for(devuptwo d:list2){
                if(d.getPartsName().equals(plane1.get(i))&&d.getPartsModel().equals(series1.get(i))&&!time.contains(d.getDevHappenTime())){
                    time.add(d.getDevHappenTime());
                }
            }
            int t = time.size();
            ProductModifyData equipmentManufacturingData5 = new ProductModifyData();
            equipmentManufacturingData5.setProductName(plane1.get(i));
            equipmentManufacturingData5.setProductModel(series1.get(i));
            equipmentManufacturingData5.setModifyType("检测设备变更");
            equipmentManufacturingData5.setModifyMethod("故障件出厂检测的测量设备批量更换");
            List<ProductModifyData> listed = productModifyDataService.selectProductModifyDataList(equipmentManufacturingData5);
            if(listed.size()!=0){
                for(int ii=0;ii<listed.size();ii++){
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(listed.get(ii).getModifyTime());
                    int a = calendar.get(Calendar.MONTH)+1;
                    if(a>0&&a<4){
                        a=1;
                    } else if(a>3&&a<7){
                        a=2;
                    } else if(a>6&&a<10){
                        a=3;
                    } else if(a>9&&a<13){
                        a=4;
                    }
                    String ss = calendar.get(Calendar.YEAR)+"-"+a;
                    if(halfyear(name1.get(i),ss)){
                        if(time.indexOf(ss)==t-1){
                            continue;
                        }
                        plane2.add(plane1.get(i));
                        series2.add(series1.get(i));
                        name2.add(ss);
                    }
                }
            }
        }
        List<devuptwo> listfin = new ArrayList<devuptwo>();
        for(int i=0;i<plane2.size();i++){
            String s1 =  plane2.get(i);
            String ss =  series2.get(i);
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)){
                    listfin.add(d);
                }
            }
        }
        for(int i =0;i<plane2.size();i++){
            boolean iffind = false;
            String s1 =  plane2.get(i);
            String ss =  series2.get(i);
            for(devuptwo d:list2){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getDevHappenTime().equals(name2.get(i))){
                    iffind = true;
                    devuptwo devup3 = new devuptwo();
                    devup3.setDevHappenTime(name2.get(i));
                    devup3.setPartsName(plane2.get(i));
                    devup3.setPartsModel(series2.get(i));
                    devup3.setdevHappennum(-1);
                    listfin.add(devup3);
                }
            }
            if(iffind==false){
                devuptwo devup2 = new devuptwo();
                devup2.setDevHappenTime(name2.get(i));
                devup2.setPartsName(plane2.get(i));
                devup2.setPartsModel(series2.get(i));
                devup2.setdevHappennum(0);
                listfin.add(devup2);

                devuptwo devup3 = new devuptwo();
                devup3.setDevHappenTime(name2.get(i));
                devup3.setPartsName(plane2.get(i));
                devup3.setPartsModel(series2.get(i));
                devup3.setdevHappennum(-1);
                listfin.add(devup3);
            }
        }
        return getDataTable(listfin);
    }

    public boolean halfyear(String s1,String s2)
    {
        if(s1.substring(0,4).equals(s2.substring(0,4))){
            if(s1.compareTo(s2)<=2&&s1.compareTo(s2)>=0){
                return true;
            }
        }
        String sa1 = s1.substring(0,4);
        String sa2 = s2.substring(0,4);
        int a1 = Integer.parseInt(sa1);
        int a2 = Integer.parseInt(sa2);
        if(a1-a2==1){
            String ss1 = s1.substring(s1.length() - 1);
            String ss2 = s2.substring(s1.length() - 1);
            if(ss2.compareTo(ss1)>=2){
                return true;
            }
        }
        return false;
    }
}
