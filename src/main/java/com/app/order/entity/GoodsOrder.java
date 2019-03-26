package com.app.order.entity;

import com.app.common.entity.AbstractEntity;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsOrder extends AbstractEntity{

    private Long carId;

    private Double totalPrice;

    private String orderNo;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
