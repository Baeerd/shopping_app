package com.app.shops.entity;

import com.app.common.entity.AbstractEntity;

import java.math.BigDecimal;
import java.util.Date;

public class Shops extends AbstractEntity{

    private String shopsName;

    private String shopsRemark;

    private Long userId;

    public String getShopsName() {
        return shopsName;
    }

    public void setShopsName(String shopsName) {
        this.shopsName = shopsName;
    }

    public String getShopsRemark() {
        return shopsRemark;
    }

    public void setShopsRemark(String shopsRemark) {
        this.shopsRemark = shopsRemark;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
