package com.ruoyi.project.system.service.impl;

import com.ruoyi.project.system.domain.reasonrule.devupone;
import com.ruoyi.project.system.domain.reasonrule.devuptwo;
import com.ruoyi.project.system.mapper.ReasonRuleMapper;
import com.ruoyi.project.system.service.IReasonRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReasonRuleServiceImpl implements IReasonRuleService {

    @Autowired
    private ReasonRuleMapper reasonRuleMapper;

    @Override
    public List<devupone> selectDevUpOne(){
        return reasonRuleMapper.selectDevUpOne();
    }

    @Override
    public List<devuptwo> selectDevUpTwo(){
        return reasonRuleMapper.selectDevUpTwo();
    }

    @Override
    public List<devuptwo> selectDevCapUpTwo(){
        return reasonRuleMapper.selectDevCapUpTwo();
    }

    @Override
    public List<devuptwo> selectProChangeOne(){
        return reasonRuleMapper.selectProChangeOne();
    }

    @Override
    public List<devupone> selectProChangeTwo(){
        return reasonRuleMapper.selectProChangeTwo();
    }

    @Override
    public List<devupone> selectProChangeThree(){
        return reasonRuleMapper.selectProChangeThree();
    }

    @Override
    public List<devuptwo> selectProChangeFour(){
        return reasonRuleMapper.selectProChangeFour();
    }

    @Override
    public List<devupone> selectProTeamOne(){
        return reasonRuleMapper.selectProTeamOne();
    }

    @Override
    public List<devupone> selectProPersonOne(){
        return reasonRuleMapper.selectProPersonOne();
    }

    @Override
    public List<devupone> selectProMakeDevOne(){
        return reasonRuleMapper.selectProMakeDevOne();
    }

    @Override
    public List<devuptwo> selectMakeLine(){
        return reasonRuleMapper.selectMakeLine();
    }

    @Override
    public List<String> selectSeries(){
        return reasonRuleMapper.selectSeries();
    }

    @Override
    public List<String> selectPlane(){
        return reasonRuleMapper.selectPlane();
    }

    @Override
    public List<String> selectMPlane(){
        return reasonRuleMapper.selectMPlane();
    }

    @Override
    public List<String> selectFaultModel(){
        return reasonRuleMapper.selectFaultModel();
    }

    @Override
    public List<String> selectCapabilityStatus(){
        return reasonRuleMapper.selectCapabilityStatus();
    }

    @Override
    public List<String> selectPartsName(){
        return reasonRuleMapper.selectPartsName();
    }

    @Override
    public List<String> selectPartsMakeGroup(){
        return reasonRuleMapper.selectPartsMakeGroup();
    }

    @Override
    public List<String> selectPartsMakePeople(){
        return reasonRuleMapper.selectPartsMakePeople();
    }

    @Override
    public List<String> selectPartsMakeQuipment(){
        return reasonRuleMapper.selectPartsMakeQuipment();
    }

    @Override
    public List<String> selectPP(){
        return reasonRuleMapper.selectPP();
    }
}
