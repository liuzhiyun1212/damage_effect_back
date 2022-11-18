package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Title:
 * @Description:
 * @Date 2022/11/14
 * @Author guohuijia
 * @Version 1.0
 */
public class FaultyPartsCount {
    @Excel(name = "型号-名称")
    private String partsModelName;

    @Excel(name = "数量")
    private int partsCount;

    @Excel(name = "故障件发生数占比")
    private String partsProportion;

    public String getPartsModelName() {
        return partsModelName;
    }

    public void setPartsModelName(String partsModelName) {
        this.partsModelName = partsModelName;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }

    public String getPartsProportion() {
        return partsProportion;
    }

    public void setPartsProportion(String partsProportion) {
        this.partsProportion = partsProportion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("partsModelName", getPartsModelName())
                .append("partsCount", getPartsCount())
                .append("partsProportion", getPartsProportion())
                .toString();
    }
}
