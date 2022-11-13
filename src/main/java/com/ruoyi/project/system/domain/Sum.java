package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

public class Sum {
//    季度
@Excel(name = "季度")
    private String quarter;
//    总数
@Excel(name = "总数")
    private int sum;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    //条件
@Excel(name = "条件")
    private String condition;

    @Override
    public String toString() {
        return "Sum{" +
                "quarter='" + quarter + '\'' +
                ", sum=" + sum +", condition=" + condition+
                '}';
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
