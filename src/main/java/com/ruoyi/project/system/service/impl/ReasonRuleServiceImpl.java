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
    public List<String> selectSeries(){
        return reasonRuleMapper.selectSeries();
    }

    @Override
    public List<String> selectPlane(){
        return reasonRuleMapper.selectPlane();
    }

    @Override
    public List<String> selectTime(){
        return reasonRuleMapper.selectTime();
    }

    @Override
    public List<String> selectFaultModel(){
        return reasonRuleMapper.selectFaultModel();
    }
}
