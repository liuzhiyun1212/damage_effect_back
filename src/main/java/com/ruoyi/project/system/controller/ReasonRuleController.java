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
    private IProductCreateService productCreateService;

    @Autowired
    private IProductModifyDataService productModifyDataService;

    @Autowired
    private IProductQuantity7Service productQuantity7Service;

    @Autowired
    private IEquipmentDeploymentData8Service equipmentDeploymentData8Service;

    @Autowired
    private IEquipmentUsageData9Service equipmentUsageData9Service;

    @Autowired
    private IRuleConstructionService ruleConstructionService;

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
        List<String> series = new ArrayList<String>();//机型
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
            for(int ii=0;ii<listed.size();ii++){
                name.add(simpleDateFormat.format(listed.get(ii).getRemodelDate()));
            }
            Collections.sort(name);
            for(devupone d:list1){
                if(d.getModelSeries().equals(s1)){
                    for(int a1=0;a1< name.size();a1++){
                        if(a1==name.size()-1){
                            if(d.getDevHappenTime().compareTo(name.get(a1))<0&&d.getDevHappenTime().compareTo(name.get(a1-1))>=0){
                                devupone devup2 = new devupone();
                                devup2.setFaultModel(d.getFaultModel());
                                devup2.setDevHappenTime(String.valueOf(a1));
                                devup2.setPlaneType(d.getPlaneType());
                                devup2.setModelSeries(s1);
                                devup2.setdevHappennum(1);
                                list2.add(devup2);
                            }else if(d.getDevHappenTime().compareTo(name.get(a1))>=0){
                                devupone devup2 = new devupone();
                                devup2.setFaultModel(d.getFaultModel());
                                devup2.setDevHappenTime(String.valueOf(a1+1));
                                devup2.setPlaneType(d.getPlaneType());
                                devup2.setModelSeries(s1);
                                devup2.setdevHappennum(1);
                                list2.add(devup2);
                            }
                        }else if(a1==0){
                            if(d.getDevHappenTime().compareTo(name.get(a1))<0){
                                devupone devup2 = new devupone();
                                devup2.setFaultModel(d.getFaultModel());
                                devup2.setDevHappenTime(String.valueOf(a1));
                                devup2.setPlaneType(d.getPlaneType());
                                devup2.setModelSeries(s1);
                                devup2.setdevHappennum(1);
                                list2.add(devup2);
                            }
                        }else{
                            if(d.getDevHappenTime().compareTo(name.get(a1))<0&&d.getDevHappenTime().compareTo(name.get(a1-1))>=0){
                                devupone devup2 = new devupone();
                                devup2.setFaultModel(d.getFaultModel());
                                devup2.setDevHappenTime(String.valueOf(a1));
                                devup2.setPlaneType(d.getPlaneType());
                                devup2.setModelSeries(s1);
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
                devuptwo devup2 = new devuptwo();
                devup2.setDevHappenTime(s2);
                devup2.setPlaneType(s3);
                devup2.setModelSeries(s1);
                devup2.setdevHappennum(sa);
                list2.add(devup2);
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

    public boolean halfyear(String s1,String s2){
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
}
