package com.ruoyi.project.system.domain.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: lvXingFeng
 * @Description:
 * @Date: Created in 2022/12/5
 */
public class ChangeOfEquipmentVo {
    private String name;
    private Date time;
    private String productModel;
    private List<Date> list;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public List<Date> getList() {
        return list;
    }

    public void setList(List<Date> list) {
        this.list = list;
    }
}
