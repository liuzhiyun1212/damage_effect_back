package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.RuleConstructionMapper;
import com.ruoyi.project.system.domain.RuleConstruction;
import com.ruoyi.project.system.service.IRuleConstructionService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
@Service
public class RuleConstructionServiceImpl implements IRuleConstructionService 
{
    @Autowired
    private RuleConstructionMapper ruleConstructionMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public RuleConstruction selectRuleConstructionById(Long id)
    {
        return ruleConstructionMapper.selectRuleConstructionById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ruleConstruction 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RuleConstruction> selectRuleConstructionList(RuleConstruction ruleConstruction)
    {
        return ruleConstructionMapper.selectRuleConstructionList(ruleConstruction);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param ruleConstruction 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRuleConstruction(RuleConstruction ruleConstruction)
    {
        return ruleConstructionMapper.insertRuleConstruction(ruleConstruction);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param ruleConstruction 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRuleConstruction(RuleConstruction ruleConstruction)
    {
        return ruleConstructionMapper.updateRuleConstruction(ruleConstruction);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRuleConstructionByIds(Long[] ids)
    {
        return ruleConstructionMapper.deleteRuleConstructionByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRuleConstructionById(Long id)
    {
        return ruleConstructionMapper.deleteRuleConstructionById(id);
    }
}
