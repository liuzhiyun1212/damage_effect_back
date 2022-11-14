package com.ruoyi.project.system.controller;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.EquipmentDesignData;
import com.ruoyi.project.system.domain.QualityProblem;
import com.ruoyi.project.system.domain.RuleConstruction;
import com.ruoyi.project.system.domain.reasonrule.devuptwo;
import com.ruoyi.project.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        RuleConstruction ruleConstruction = new RuleConstruction();
        ruleConstruction.setRule("不同问题装备型号中，某种故障模式质量问题数量存在较大差异");
        List<RuleConstruction> listr = ruleConstructionService.selectRuleConstructionList(ruleConstruction);
        float ruledata = Float.parseFloat(listr.get(0).getRuleData());

        QualityProblem qualityProblem = new QualityProblem();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        List<QualityProblem> list1 = new ArrayList<QualityProblem>();
        List<QualityProblem> listfin = new ArrayList<QualityProblem>();
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
                devuptwo devup2 = new devuptwo();
                devup2.setDevHappenTime(s2);
                devup2.setPlaneType(s1);
                devup2.setdevHappennum(sa);
                list2.add(devup2);
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
                if(halfyear(name1.get(i),ss)&&!plane2.contains(plane1.get(i))){
                    plane2.add(plane1.get(i));
                    name2.add(ss);
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

    public static void main(String[] args)
    {
        String s1 = "2021-1";
        String s2 = "2020-3";
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.substring(s1.length() - 1));
    }
}
