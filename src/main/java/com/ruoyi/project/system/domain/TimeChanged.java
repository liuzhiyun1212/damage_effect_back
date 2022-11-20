package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

public class TimeChanged {
    //    季度
    @Excel(name = "名字")
    private String name;
    //    总数
    @Excel(name = "时间")
    private int time;

    @Override
    public String toString() {
        return "TimeChanged{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
