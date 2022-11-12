package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 rule_construction
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
public class RuleConstruction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 变更项名称 */
    @Excel(name = "变更项名称")
    private String changeName;

    /** 判明准则 */
    @Excel(name = "判明准则")
    private String rule;

    /** 规则数值 */
    @Excel(name = "规则数值")
    private String ruleData;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setChangeName(String changeName) 
    {
        this.changeName = changeName;
    }

    public String getChangeName() 
    {
        return changeName;
    }
    public void setRule(String rule) 
    {
        this.rule = rule;
    }

    public String getRule() 
    {
        return rule;
    }
    public void setRuleData(String ruleData) 
    {
        this.ruleData = ruleData;
    }

    public String getRuleData() 
    {
        return ruleData;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("changeName", getChangeName())
            .append("rule", getRule())
            .append("ruleData", getRuleData())
            .toString();
    }
}
