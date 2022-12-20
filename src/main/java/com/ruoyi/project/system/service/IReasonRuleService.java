package com.ruoyi.project.system.service;

import com.ruoyi.project.system.domain.reasonrule.devupone;
import com.ruoyi.project.system.domain.reasonrule.devuptwo;

import java.util.List;

public interface IReasonRuleService {

    public List<devupone> selectDevUpOne();

    public List<devuptwo> selectDevUpTwo();

    public List<devuptwo> selectDevCapUpTwo();

    public List<devuptwo> selectProChangeOne();

    public List<devupone> selectProChangeTwo();

    public List<devupone> selectProChangeThree();

    public List<devuptwo> selectProChangeFour();

    public List<devupone> selectProTeamOne();

    public List<devupone> selectProPersonOne();

    public List<devupone> selectProMakeDevOne();

    public List<devupone> selectProMeasuringDevOne();

    public List<devupone> selectProMakePlaceOne();

    public List<devupone> selectProMakePlaceTwo();

    public List<devupone> selectProMakeWorkmanshipOne();

    public List<devupone> selectProRepairTeamOne();

    public List<devupone> selectProRepairWorkmanshipOne();

    public List<devupone> selectProRepairPeopleOne();

    public List<devupone> selectDevStatusOne();

    public List<devupone> selectDevStatusTwo();

    public List<devupone> selectDevEnvironmentOne();

    public List<devuptwo> selectMakeLine();

    public List<devuptwo> selectdevusechangeQuarter();

    public List<devuptwo> selectdevusechangeYear();

    public List<devuptwo> selectQuarterLine();

    public List<devuptwo> selectYearLine();

    public List<String> selectSeries();

    public List<String> selectPlane();

    public List<String> selectMPlane();

    public List<String> selectFaultModel();

    public List<String> selectCapabilityStatus();

    public List<String> selectPartsName();

    public List<String> selectPP();

}
