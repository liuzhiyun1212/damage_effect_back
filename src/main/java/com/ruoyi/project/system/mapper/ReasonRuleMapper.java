package com.ruoyi.project.system.mapper;

import com.ruoyi.project.system.domain.reasonrule.devupone;
import com.ruoyi.project.system.domain.reasonrule.devuptwo;

import java.util.List;

public interface ReasonRuleMapper {

    public List<devupone> selectDevUpOne();

    public List<devuptwo> selectDevUpTwo();

    public List<String> selectSeries();

    public List<String> selectPlane();

    public List<String> selectTime();

    public List<String> selectFaultModel();
}
