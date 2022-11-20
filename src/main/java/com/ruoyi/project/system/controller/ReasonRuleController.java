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

    /**
     * 不同问题装备型号中，某种故障模式质量问题数量存在较大差异
     */
    @GetMapping("/devup1")
    public TableDataInfo devup1()
    {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        RuleConstruction ruleConstruction = new RuleConstruction();
        ruleConstruction.setRule("不同问题装备型号中，某种故障模式质量问题数量存在较大差异");
        List<RuleConstruction> listr = ruleConstructionService.selectRuleConstructionList(ruleConstruction);
        float ruledata = Float.parseFloat(listr.get(0).getRuleData());
        QualityProblem qualityProblem = new QualityProblem();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        EquipmentDesignData equipmentDesignData1 = new EquipmentDesignData();
        List<EquipmentDesignData> listing = equipmentDesignDataService.selectEquipmentDesignDataList(equipmentDesignData1);
        List<devupone> list1 = new ArrayList<devupone>();
        List<String> plane = new ArrayList<String>();//机型
        List<String> series = new ArrayList<String>();
        List<String> model = new ArrayList<String>();//故障模式
        for(EquipmentDesignData i: listing){
            if(!series.contains(i.getModelSeries())){
                series.add(i.getModelSeries());
            }
        }
        for(QualityProblem i: list){
            devupone devup1 = new devupone();
            devup1.setDevHappenTime(simpleDateFormat.format(i.getDevHappenTime()));
            devup1.setPlaneType(i.getPlaneType());
            devup1.setFaultModel(i.getFaultModel());
            devup1.setdevHappennum(1);
            boolean iffind = false;
            for(EquipmentDesignData ii: listing){
                if(ii.getPlaneType().equals(i.getPlaneType())){
                    devup1.setModelSeries(ii.getModelSeries());
                    iffind = true;
                    break;
                }
            }
            if(iffind==false){
                for(String ii: series){
                    int ai = ii.length();
                    String s = i.getPlaneType().substring(0,ai);
                    if(s.equals(ii)){
                        devup1.setModelSeries(s);
                    }
                }
            }
            list1.add(devup1);
            if(!plane.contains(i.getPlaneType())){
                plane.add(i.getPlaneType());
            }
            if(!model.contains(i.getFaultModel())){
                model.add(i.getFaultModel());
            }
        }
        List<devupone> list2 = new ArrayList<devupone>();
        int max = 0;
        for(String s1: series){
            List<String> name = new ArrayList<String>();//时间
            EquipmentDesignData equipmentDesignData = new EquipmentDesignData();
            equipmentDesignData.setModelSeries(s1);
            List<EquipmentDesignData> listed = equipmentDesignDataService.selectEquipmentDesignDataList(equipmentDesignData);
            HashMap<String, String> Sites = new HashMap<String, String>();
            for(int ii=0;ii<listed.size();ii++){
                name.add(simpleDateFormat.format(listed.get(ii).getRemodelDate()));
                Sites.put(listed.get(ii).getPlaneType(),simpleDateFormat.format(listed.get(ii).getRemodelDate()));
            }
            Collections.sort(name);
            for(devupone d:list1){
                if(d.getModelSeries().equals(s1)){
                    devupone devup2 = new devupone();
                    devup2.setFaultModel(d.getFaultModel());
                    int a1 = name.indexOf(Sites.get(d.getPlaneType()));
                    devup2.setDevHappenTime(String.valueOf(a1));
                    devup2.setPlaneType(d.getPlaneType());
                    devup2.setModelSeries(s1);
                    devup2.setdevHappennum(1);
                    list2.add(devup2);
                }
            }
            if(name.size()>max){
                max= name.size();
            }
        }
        List<devupone> list3 = new ArrayList<devupone>();
        for(String s1: series){
            for(String s2: model){
                for(int a2=0;a2<max+1;a2++){
                    String aa2 = String.valueOf(a2);
                    int sa = 0;
                    String aa3 = "";
                    for(devupone d:list2){
                        if(d.getModelSeries().equals(s1)&&d.getDevHappenTime().equals(aa2)&&d.getFaultModel().equals(s2)){
                            sa++;
                            aa3 = d.getPlaneType();
                        }
                    }
                    if(sa>0){
                        devupone devup2 = new devupone();
                        devup2.setDevHappenTime(aa2);
                        devup2.setFaultModel(s2);
                        devup2.setModelSeries(s1);
                        devup2.setPlaneType(aa3);
                        devup2.setdevHappennum(sa);
                        list3.add(devup2);
                    }
                }
            }
        }
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
        QualityProblem qualityProblem = new QualityProblem();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        EquipmentDesignData equipmentDesignData1 = new EquipmentDesignData();
        List<EquipmentDesignData> listing = equipmentDesignDataService.selectEquipmentDesignDataList(equipmentDesignData1);
        List<devuptwo> list1 = new ArrayList<devuptwo>();
        List<devuptwo> list2 = new ArrayList<devuptwo>();
        List<String> name = new ArrayList<String>();//时间
        List<String> series = new ArrayList<String>();//机型
        List<String> plane = new ArrayList<String>();//机型
        HashMap<String, String> Sites = new HashMap<String, String>();
        for(EquipmentDesignData i: listing){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(i.getRemodelDate());
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
            String s1 = calendar.get(Calendar.YEAR)+"-"+a;
            String s2 = i.getModelSeries();
            String s3 = i.getPlaneType();
            Sites.put(s2+s1,s3);
            if(!series.contains(i.getModelSeries())){
                series.add(i.getModelSeries());
            }
        }
        for(QualityProblem i: list){
            devuptwo devup1 = new devuptwo();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(i.getDevHappenTime());
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
            devup1.setDevHappenTime(calendar.get(Calendar.YEAR)+"-"+a);
            devup1.setPlaneType(i.getPlaneType());
            devup1.setdevHappennum(1);
            boolean iffind = false;
            String s2 = "";
            for(EquipmentDesignData ii: listing){
                if(ii.getPlaneType().equals(i.getPlaneType())){
                    devup1.setModelSeries(ii.getModelSeries());
                    iffind = true;
                    s2 = ii.getModelSeries();
                    break;
                }
            }
            if(iffind==false){
                for(String ii: series){
                    int ai = ii.length();
                    String s = i.getPlaneType().substring(0,ai);
                    if(s.equals(ii)){
                        devup1.setModelSeries(s);
                        s2 = ii;
                    }
                }
            }
            String s1 = calendar.get(Calendar.YEAR)+"-"+a;
            String s3 = i.getPlaneType();
            Sites.put(s2+s1,s3);
            list1.add(devup1);
            if(!name.contains(calendar.get(Calendar.YEAR)+"-"+a)){
                name.add(calendar.get(Calendar.YEAR)+"-"+a);
            }
            if(!plane.contains(i.getPlaneType())){
                plane.add(i.getPlaneType());
            }
        }
        Collections.sort(name);
        for(String s1: series){
            for(String s2: name){
                String s3 = Sites.get(s1+s2);
                int sa = 0;
                for(devuptwo d:list1){
                    if(d.getDevHappenTime().equals(s2)&&d.getModelSeries().equals(s1)){
                        sa++;
                    }
                }
                if(sa>0){
                    devuptwo devup2 = new devuptwo();
                    devup2.setDevHappenTime(s2);
                    devup2.setPlaneType(s3);
                    devup2.setModelSeries(s1);
                    devup2.setdevHappennum(sa);
                    list2.add(devup2);
                }
            }
        }
        List<String> name1 = new ArrayList<String>();//时间
        List<String> plane1 = new ArrayList<String>();//机型
        List<String> series1 = new ArrayList<String>();//机型
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
                    plane1.add(list3.get(i).getPlaneType());
                    series1.add(list3.get(i).getModelSeries());
                }
                if(i>0&&list3.get(i).getdevHappennum()<list3.get(i-1).getdevHappennum()*0.5){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPlaneType());
                    series1.add(list3.get(i).getModelSeries());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()*1.2&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()*1.2){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPlaneType());
                    series1.add(list3.get(i).getModelSeries());
                }
                if(i+2<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()*0.8&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()*0.8){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPlaneType());
                    series1.add(list3.get(i).getModelSeries());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()>list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()>list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()>list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPlaneType());
                    series1.add(list3.get(i).getModelSeries());
                }
                if(i+3<list3.size()&&list3.get(i+1).getdevHappennum()<list3.get(i).getdevHappennum()&&list3.get(i+2).getdevHappennum()<list3.get(i+1).getdevHappennum()&&list3.get(i+3).getdevHappennum()<list3.get(i+2).getdevHappennum()){
                    name1.add(list3.get(i).getDevHappenTime());
                    plane1.add(list3.get(i).getPlaneType());
                    series1.add(list3.get(i).getModelSeries());
                }
            }
        }
        List<String> plane2 = new ArrayList<String>();//机型
        List<String> name2 = new ArrayList<String>();//时间
        List<String> series2 = new ArrayList<String>();//时间
        for(int i=0;i<plane1.size();i++){
            EquipmentDesignData equipmentDesignData = new EquipmentDesignData();
            equipmentDesignData.setPlaneType(plane1.get(i));
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
                    plane2.add(plane1.get(i));
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
        for(int i =0;i<plane2.size();i++){
            boolean iffind = false;
            for(devuptwo d:list2){
                if(d.getDevHappenTime().equals(name2.get(i))&&d.getModelSeries().equals(series2.get(i))){
                    iffind = true;
                    devuptwo devup3 = new devuptwo();
                    devup3.setDevHappenTime(name2.get(i));
                    devup3.setPlaneType(plane2.get(i));
                    devup3.setModelSeries(series2.get(i));
                    devup3.setdevHappennum(-1);
                    listfin.add(devup3);
                }
            }
            if(iffind==false){
                devuptwo devup2 = new devuptwo();
                devup2.setDevHappenTime(name2.get(i));
                devup2.setPlaneType(plane2.get(i));
                devup2.setModelSeries(series2.get(i));
                devup2.setdevHappennum(0);
                listfin.add(devup2);

                devuptwo devup3 = new devuptwo();
                devup3.setDevHappenTime(name2.get(i));
                devup3.setPlaneType(plane2.get(i));
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
        List<String> plane = new ArrayList<String>();
        List<String> mplane = new ArrayList<String>();
        List<String> model = new ArrayList<String>();
        List<String> series = new ArrayList<String>();
        EquipmentManufacturingData5 equipmentManufacturingData51 = new EquipmentManufacturingData5();
        List<EquipmentManufacturingData5> listing = equipmentManufacturingData5Service.selectEquipmentManufacturingData5List(equipmentManufacturingData51);
        for(EquipmentManufacturingData5 i: listing){
            if(!series.contains(i.getCapabilityStatus())){
                series.add(i.getCapabilityStatus());
            }
        }
        Collections.sort(series);
        for(QualityProblem i: list){
            devupone devup1 = new devupone();
            devup1.setDevHappenTime(simpleDateFormat.format(i.getDevHappenTime()));
            devup1.setPlaneType(i.getPlaneType());
            devup1.setFaultModel(i.getFaultModel());
            devup1.setDevCode(i.getDevCode());
            devup1.setdevHappennum(1);
            list1.add(devup1);
            if(!plane.contains(i.getPlaneType())){
                plane.add(i.getPlaneType());
            }
            if(!mplane.contains(i.getPlaneType()+";"+i.getDevCode())){
                mplane.add(i.getPlaneType()+";"+i.getDevCode());
            }
            if(!model.contains(i.getFaultModel())){
                model.add(i.getFaultModel());
            }
        }
        List<devupone> list2 = new ArrayList<devupone>();
        HashMap<String, String> Sites = new HashMap<String, String>();
        int max = 0;
        for(String as1: mplane){
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
        QualityProblem qualityProblem = new QualityProblem();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        List<devuptwo> list1 = new ArrayList<devuptwo>();
        List<devuptwo> list2 = new ArrayList<devuptwo>();
        List<String> name = new ArrayList<String>();//时间
        List<String> plane = new ArrayList<String>();//机型
        for(QualityProblem i: list){
            devuptwo devup1 = new devuptwo();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(i.getDevHappenTime());
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
            devup1.setDevHappenTime(calendar.get(Calendar.YEAR)+"-"+a);
            devup1.setPlaneType(i.getPlaneType());
            devup1.setdevHappennum(1);
            list1.add(devup1);
            if(!name.contains(calendar.get(Calendar.YEAR)+"-"+a)){
                name.add(calendar.get(Calendar.YEAR)+"-"+a);
            }
            if(!plane.contains(i.getPlaneType())){
                plane.add(i.getPlaneType());
            }
        }
        Collections.sort(name);
        for(String s1: plane){
            for(String s2: name){
                int sa = 0;
                for(devuptwo d:list1){
                    if(d.getPlaneType().equals(s1)&&d.getDevHappenTime().equals(s2)){
                        sa++;
                    }
                }
                if(sa>0){
                    devuptwo devup2 = new devuptwo();
                    devup2.setDevHappenTime(s2);
                    devup2.setPlaneType(s1);
                    devup2.setdevHappennum(sa);
                    list2.add(devup2);
                }
            }
        }
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
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        RuleConstruction ruleConstruction = new RuleConstruction();
        ruleConstruction.setRule("不同故障件型号中，某种故障模式质量问题数量存在较大差异");
        List<RuleConstruction> listr = ruleConstructionService.selectRuleConstructionList(ruleConstruction);
        float ruledata = Float.parseFloat(listr.get(0).getRuleData());
        QualityProblem qualityProblem = new QualityProblem();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        List<devuptwo> list1 = new ArrayList<devuptwo>();
        List<String> plane = new ArrayList<String>();
        List<String> series = new ArrayList<String>();
        List<String> model = new ArrayList<String>();
        for(QualityProblem i: list){
            devuptwo devup1 = new devuptwo();
            devup1.setDevHappenTime(simpleDateFormat.format(i.getDevHappenTime()));
            devup1.setPlaneType(i.getPartsModel());
            devup1.setFaultModel(i.getFaultModel());
            devup1.setPartsName(i.getPartsName());
            devup1.setdevHappennum(1);
            list1.add(devup1);
            if(!plane.contains(i.getPartsModel())){
                plane.add(i.getPartsModel());
            }
            if(!model.contains(i.getFaultModel())){
                model.add(i.getFaultModel());
            }
            if(!series.contains(i.getPartsName())){
                series.add(i.getPartsName());
            }
        }
        List<devuptwo> list2 = new ArrayList<devuptwo>();
        int max = 0;
        for(String s1: series) {
            List<String> name = new ArrayList<String>();//时间
            ProductModify equipmentDesignData = new ProductModify();
            equipmentDesignData.setProductName(s1);
            List<ProductModify> listed = productModifyService.selectProductModifyList(equipmentDesignData);
            HashMap<String, String> Sites = new HashMap<String, String>();
            for(int ii=0;ii<listed.size();ii++){
                name.add(simpleDateFormat.format(listed.get(ii).getModifyTime()));
                Sites.put(listed.get(ii).getProductModel(),simpleDateFormat.format(listed.get(ii).getModifyTime()));
            }
            Collections.sort(name);
            for(devuptwo d:list1){
                if(d.getPartsName().equals(s1)){
                    devuptwo devup2 = new devuptwo();
                    devup2.setFaultModel(d.getFaultModel());
                    int a1 = name.indexOf(Sites.get(d.getPlaneType()));
                    devup2.setDevHappenTime(String.valueOf(a1));
                    devup2.setPlaneType(d.getPlaneType());
                    devup2.setPartsName(s1);
                    devup2.setdevHappennum(1);
                    list2.add(devup2);
                }
            }
            if(name.size()>max){
                max= name.size();
            }
        }
        List<devuptwo> list3 = new ArrayList<devuptwo>();
        for(String s1: series){
            for(String s2: model){
                for(int a2=0;a2<max+1;a2++){
                    String aa2 = String.valueOf(a2);
                    int sa = 0;
                    String aa3 = "";
                    for(devuptwo d:list2){
                        if(d.getPartsName().equals(s1)&&d.getDevHappenTime().equals(aa2)&&d.getFaultModel().equals(s2)){
                            sa++;
                            aa3 = d.getPlaneType();
                        }
                    }
                    if(sa>0){
                        devuptwo devup2 = new devuptwo();
                        devup2.setDevHappenTime(aa2);
                        devup2.setFaultModel(s2);
                        devup2.setPartsName(s1);
                        devup2.setPlaneType(aa3);
                        devup2.setdevHappennum(sa);
                        list3.add(devup2);
                    }
                }
            }
        }
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
        QualityProblem qualityProblem = new QualityProblem();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        List<devupone> list1 = new ArrayList<devupone>();
        List<String> plane = new ArrayList<String>();
        List<String> mplane = new ArrayList<String>();
        List<String> model = new ArrayList<String>();
        List<String> series = new ArrayList<String>();
        ProductDesign equipmentManufacturingData51 = new ProductDesign();
        List<ProductDesign> listing = productDesignService.selectProductDesignList(equipmentManufacturingData51);
        for(ProductDesign i: listing){
            if(!series.contains(i.getInstallMethod())){
                series.add(i.getInstallMethod());
            }
        }
        for(QualityProblem i: list){
            devupone devup1 = new devupone();
            devup1.setPlaneType(i.getPlaneType());
            devup1.setFaultModel(i.getFaultModel());
            devup1.setPartsName(i.getPartsName());
            devup1.setPartsModel(i.getPartsModel());
            devup1.setdevHappennum(1);
            list1.add(devup1);
            if(!plane.contains(i.getPlaneType()+"/"+i.getPartsName()+"/"+i.getPartsModel())){
                plane.add(i.getPlaneType()+"/"+i.getPartsName()+"/"+i.getPartsModel());
            }
            if(!mplane.contains(i.getPartsName()+"/"+i.getPartsModel())){
                mplane.add(i.getPartsName()+"/"+i.getPartsModel());
            }
            if(!model.contains(i.getFaultModel())){
                model.add(i.getFaultModel());
            }
        }
        List<devupone> list2 = new ArrayList<devupone>();
        for(String as1: plane){
            String s1 = as1.split("/")[0];
            String s2 = as1.split("/")[1];
            String s3 = as1.split("/")[2];
            String name = "";//时间
            ProductDesign equipmentManufacturingData5 = new ProductDesign();
            equipmentManufacturingData5.setPlaneType(s1);
            equipmentManufacturingData5.setFinishedName(s2);
            equipmentManufacturingData5.setFinishedModel(s3);
            List<ProductDesign> listed = productDesignService.selectProductDesignList(equipmentManufacturingData5);
            if(listed.size()>0){
                name=listed.get(0).getInstallMethod();
                for(devupone d:list1){
                    if(d.getPlaneType().equals(s1)&&d.getPartsName().equals(s2)&&d.getPartsModel().equals(s3)){
                        devupone devup2 = new devupone();
                        devup2.setFaultModel(d.getFaultModel());
                        devup2.setPlaneType(s1);
                        devup2.setPartsName(s2);
                        devup2.setPartsModel(s3);
                        devup2.setInstallMethod(name);
                        devup2.setdevHappennum(1);
                        list2.add(devup2);
                    }
                }
            }
        }
        List<devupone> list3 = new ArrayList<devupone>();
        for(String as1: mplane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            for(String sss:series){
                for(String s2: model){
                    int sa = 0;
                    for(devupone d:list2){
                        if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getInstallMethod().equals(sss)&&d.getFaultModel().equals(s2)){
                            sa++;
                        }
                    }
                    if(sa>0){
                        devupone devup2 = new devupone();
                        devup2.setPartsName(s1);
                        devup2.setPartsModel(ss);
                        devup2.setInstallMethod(sss);
                        devup2.setFaultModel(s2);
                        devup2.setdevHappennum(sa);
                        list3.add(devup2);
                    }
                }
            }
        }
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
            ProductDesign equipmentManufacturingData5 = new ProductDesign();
            equipmentManufacturingData5.setFinishedName(s1);
            equipmentManufacturingData5.setFinishedModel(ss);
            List<ProductDesign> listed = productDesignService.selectProductDesignList(equipmentManufacturingData5);
            List<String> name = new ArrayList<String>();
            for(ProductDesign ii: listed){
                if(!name.contains(ii.getInstallMethod())){
                    name.add(ii.getInstallMethod());
                }
            }
            for(devupone d:list3){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(model1.get(i))){
                    int a1 = name.indexOf(d.getInstallMethod());
                    d.setDevHappenTime(String.valueOf(a1));
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
        QualityProblem qualityProblem = new QualityProblem();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        List<devupone> list1 = new ArrayList<devupone>();
        List<String> plane = new ArrayList<String>();
        List<String> mplane = new ArrayList<String>();
        List<String> model = new ArrayList<String>();
        List<String> series = new ArrayList<String>();
        ProductDesign equipmentManufacturingData51 = new ProductDesign();
        List<ProductDesign> listing = productDesignService.selectProductDesignList(equipmentManufacturingData51);
        for(ProductDesign i: listing){
            if(!series.contains(i.getFrame()+"/"+i.getUpperMiddleLower()+"/"+i.getLeftMiddleRight())){
                series.add(i.getFrame()+"/"+i.getUpperMiddleLower()+"/"+i.getLeftMiddleRight());
            }
        }
        for(QualityProblem i: list){
            devupone devup1 = new devupone();
            devup1.setPlaneType(i.getPlaneType());
            devup1.setFaultModel(i.getFaultModel());
            devup1.setPartsName(i.getPartsName());
            devup1.setPartsModel(i.getPartsModel());
            devup1.setdevHappennum(1);
            list1.add(devup1);
            if(!plane.contains(i.getPlaneType()+"/"+i.getPartsName()+"/"+i.getPartsModel())){
                plane.add(i.getPlaneType()+"/"+i.getPartsName()+"/"+i.getPartsModel());
            }
            if(!mplane.contains(i.getPartsName()+"/"+i.getPartsModel())){
                mplane.add(i.getPartsName()+"/"+i.getPartsModel());
            }
            if(!model.contains(i.getFaultModel())){
                model.add(i.getFaultModel());
            }
        }
        List<devupone> list2 = new ArrayList<devupone>();
        for(String as1: plane){
            String s1 = as1.split("/")[0];
            String s2 = as1.split("/")[1];
            String s3 = as1.split("/")[2];
            String name = "";//时间
            ProductDesign equipmentManufacturingData5 = new ProductDesign();
            equipmentManufacturingData5.setPlaneType(s1);
            equipmentManufacturingData5.setFinishedName(s2);
            equipmentManufacturingData5.setFinishedModel(s3);
            List<ProductDesign> listed = productDesignService.selectProductDesignList(equipmentManufacturingData5);
            if(listed.size()>0){
                name=listed.get(0).getFrame()+"/"+listed.get(0).getUpperMiddleLower()+"/"+listed.get(0).getLeftMiddleRight();
                for(devupone d:list1){
                    if(d.getPlaneType().equals(s1)&&d.getPartsName().equals(s2)&&d.getPartsModel().equals(s3)){
                        devupone devup2 = new devupone();
                        devup2.setFaultModel(d.getFaultModel());
                        devup2.setPlaneType(s1);
                        devup2.setPartsName(s2);
                        devup2.setPartsModel(s3);
                        devup2.setInstallWhere(name);
                        devup2.setdevHappennum(1);
                        list2.add(devup2);
                    }
                }
            }
        }
        List<devupone> list3 = new ArrayList<devupone>();
        for(String as1: mplane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            for(String sss:series){
                for(String s2: model){
                    int sa = 0;
                    for(devupone d:list2){
                        if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getInstallWhere().equals(sss)&&d.getFaultModel().equals(s2)){
                            sa++;
                        }
                    }
                    if(sa>0){
                        devupone devup2 = new devupone();
                        devup2.setPartsName(s1);
                        devup2.setPartsModel(ss);
                        devup2.setInstallWhere(sss);
                        devup2.setFaultModel(s2);
                        devup2.setdevHappennum(sa);
                        list3.add(devup2);
                    }
                }
            }
        }
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
            ProductDesign equipmentManufacturingData5 = new ProductDesign();
            equipmentManufacturingData5.setFinishedName(s1);
            equipmentManufacturingData5.setFinishedModel(ss);
            List<ProductDesign> listed = productDesignService.selectProductDesignList(equipmentManufacturingData5);
            List<String> name = new ArrayList<String>();
            for(ProductDesign ii: listed){
                if(!name.contains(ii.getFrame()+"/"+ii.getUpperMiddleLower()+"/"+ii.getLeftMiddleRight())){
                    name.add(ii.getFrame()+"/"+ii.getUpperMiddleLower()+"/"+ii.getLeftMiddleRight());
                }
            }
            for(devupone d:list3){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(model1.get(i))){
                    int a1 = name.indexOf(d.getInstallWhere());
                    d.setDevHappenTime(String.valueOf(a1));
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
        QualityProblem qualityProblem = new QualityProblem();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        List<devuptwo> list1 = new ArrayList<devuptwo>();
        List<devuptwo> list2 = new ArrayList<devuptwo>();
        List<String> name = new ArrayList<String>();//时间
        List<String> series = new ArrayList<String>();//故障件名称
        for(QualityProblem i: list){
            devuptwo devup1 = new devuptwo();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(i.getDevHappenTime());
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
            devup1.setDevHappenTime(calendar.get(Calendar.YEAR)+"-"+a);
            devup1.setPartsName(i.getPartsName());
            devup1.setdevHappennum(1);
            list1.add(devup1);
            if(!name.contains(calendar.get(Calendar.YEAR)+"-"+a)){
                name.add(calendar.get(Calendar.YEAR)+"-"+a);
            }
            if(!series.contains(i.getPartsName())){
                series.add(i.getPartsName());
            }
        }
        Collections.sort(name);
        for(String s1: series){
            for(String s2: name){
                int sa = 0;
                for(devuptwo d:list1){
                    if(d.getDevHappenTime().equals(s2)&&d.getPartsName().equals(s1)){
                        sa++;
                    }
                }
                if(sa>0){
                    devuptwo devup2 = new devuptwo();
                    devup2.setDevHappenTime(s2);
                    devup2.setPartsName(s1);
                    devup2.setdevHappennum(sa);
                    list2.add(devup2);
                }
            }
        }
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
        QualityProblem qualityProblem = new QualityProblem();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        List<devupone> list1 = new ArrayList<devupone>();
        List<String> plane = new ArrayList<String>();
        List<String> mplane = new ArrayList<String>();
        List<String> model = new ArrayList<String>();
        List<String> series = new ArrayList<String>();
        PartsMakeNum9 equipmentManufacturingData51 = new PartsMakeNum9();
        List<PartsMakeNum9> listing = partsMakeNum9Service.selectPartsMakeNum9List(equipmentManufacturingData51);
        for(PartsMakeNum9 i: listing){
            if(!series.contains(i.getPartsMakeGroup())){
                series.add(i.getPartsMakeGroup());
            }
        }
        for(QualityProblem i: list){
            devupone devup1 = new devupone();
            devup1.setPlaneType(i.getPlaneType());
            devup1.setFaultModel(i.getFaultModel());
            devup1.setPartsName(i.getPartsName());
            devup1.setPartsModel(i.getPartsModel());
            devup1.setPartsCode(i.getPartsCode());
            devup1.setdevHappennum(1);
            list1.add(devup1);
            if(!plane.contains(i.getPlaneType()+"/"+i.getPartsName()+"/"+i.getPartsModel()+"/"+i.getPartsCode())){
                plane.add(i.getPlaneType()+"/"+i.getPartsName()+"/"+i.getPartsModel()+"/"+i.getPartsCode());
            }
            if(!mplane.contains(i.getPartsName()+"/"+i.getPartsModel())){
                mplane.add(i.getPartsName()+"/"+i.getPartsModel());
            }
            if(!model.contains(i.getFaultModel())){
                model.add(i.getFaultModel());
            }
        }
        List<devupone> list2 = new ArrayList<devupone>();
        for(String as1: plane){
            String s1 = as1.split("/")[0];
            String s2 = as1.split("/")[1];
            String s3 = as1.split("/")[2];
            String s4 = as1.split("/")[3];
            String name = "";
            PartsMakeNum9 equipmentManufacturingData5 = new PartsMakeNum9();
            equipmentManufacturingData5.setPlaneType(s1);
            equipmentManufacturingData5.setPartsName(s2);
            equipmentManufacturingData5.setPartsModel(s3);
            equipmentManufacturingData5.setPartsCode(s4);
            List<PartsMakeNum9> listed = partsMakeNum9Service.selectPartsMakeNum9List(equipmentManufacturingData5);
            if(listed.size()>0){
                name=listed.get(0).getPartsMakeGroup();
                for(devupone d:list1){
                    if(d.getPlaneType().equals(s1)&&d.getPartsName().equals(s2)&&d.getPartsModel().equals(s3)&&d.getPartsCode().equals(s4)){
                        devupone devup2 = new devupone();
                        devup2.setFaultModel(d.getFaultModel());
                        devup2.setPartsMakeGroup(name);
                        devup2.setPlaneType(s1);
                        devup2.setPartsName(s2);
                        devup2.setPartsModel(s3);
                        devup2.setdevHappennum(1);
                        list2.add(devup2);
                    }
                }
            }
        }
        List<devupone> list3 = new ArrayList<devupone>();
        for(String as1: mplane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            for(String sss:series){
                for(String s2: model){
                    int sa = 0;
                    for(devupone d:list2){
                        if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getPartsMakeGroup().equals(sss)&&d.getFaultModel().equals(s2)){
                            sa++;
                        }
                    }
                    if(sa>0){
                        devupone devup2 = new devupone();
                        devup2.setPartsName(s1);
                        devup2.setPartsModel(ss);
                        devup2.setPartsMakeGroup(sss);
                        devup2.setFaultModel(s2);
                        devup2.setdevHappennum(sa);
                        list3.add(devup2);
                    }
                }
            }
        }
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
            PartsMakeNum9 equipmentManufacturingData5 = new PartsMakeNum9();
            equipmentManufacturingData5.setPartsName(s1);
            equipmentManufacturingData5.setPartsModel(ss);
            List<PartsMakeNum9> listed = partsMakeNum9Service.selectPartsMakeNum9List(equipmentManufacturingData5);
            List<String> name = new ArrayList<String>();
            for(PartsMakeNum9 ii: listed){
                if(!name.contains(ii.getPartsMakeGroup())){
                    name.add(ii.getPartsMakeGroup());
                }
            }
            for(devupone d:list3){
                if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getFaultModel().equals(model1.get(i))){
                    int a1 = name.indexOf(d.getPartsMakeGroup());
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
        QualityProblem qualityProblem = new QualityProblem();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        List<devuptwo> list1 = new ArrayList<devuptwo>();
        List<devuptwo> list2 = new ArrayList<devuptwo>();
        List<String> name = new ArrayList<String>();//时间
        List<String> plane = new ArrayList<String>();//机型
        for(QualityProblem i: list){
            devuptwo devup1 = new devuptwo();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(i.getDevHappenTime());
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
            devup1.setDevHappenTime(calendar.get(Calendar.YEAR)+"-"+a);
            devup1.setPartsName(i.getPartsName());
            devup1.setPartsModel(i.getPartsModel());
            devup1.setdevHappennum(1);
            list1.add(devup1);
            if(!name.contains(calendar.get(Calendar.YEAR)+"-"+a)){
                name.add(calendar.get(Calendar.YEAR)+"-"+a);
            }
            if(!plane.contains(i.getPartsName()+"/"+i.getPartsModel())){
                plane.add(i.getPartsName()+"/"+i.getPartsModel());
            }
        }
        Collections.sort(name);
        for(String as1: plane){
            String s1 = as1.split("/")[0];
            String ss = as1.split("/")[1];
            for(String s2: name){
                int sa = 0;
                for(devuptwo d:list1){
                    if(d.getPartsName().equals(s1)&&d.getPartsModel().equals(ss)&&d.getDevHappenTime().equals(s2)){
                        sa++;
                    }
                }
                if(sa>0){
                    devuptwo devup2 = new devuptwo();
                    devup2.setDevHappenTime(s2);
                    devup2.setPartsName(s1);
                    devup2.setPartsModel(ss);
                    devup2.setdevHappennum(sa);
                    list2.add(devup2);
                }
            }
        }
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
            if(s1.compareTo(s2)<=2){
                return true;
            }
        }
        if(s1.substring(0,4).compareTo(s2.substring(0,4))==1){
            String ss1 = s1.substring(s1.length() - 1);
            String ss2 = s2.substring(s1.length() - 1);
            if(ss2.compareTo(ss1)>=2){
                return true;
            }
        }
        return false;
    }

    Comparator<devupone> stuComparator1 = new Comparator<devupone>() {
        @Override
        public int compare(devupone o1, devupone o2) {
            return o1.getdevHappennum() - o2.getdevHappennum();
        }
    };

    Comparator<devuptwo> stuComparator2 = new Comparator<devuptwo>() {
        @Override
        public int compare(devuptwo o1, devuptwo o2) {
            return o1.getdevHappennum() - o2.getdevHappennum();
        }
    };
}
