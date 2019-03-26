package com.app.car.entity;

import com.app.common.entity.AbstractEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.Date;

public class ShoppingCar extends AbstractEntity{

    private Long userId;

    private Long goodsId;

    private Integer num;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
