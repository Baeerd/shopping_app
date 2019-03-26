package com.app.goods.entity;

import com.app.common.entity.AbstractEntity;

import java.math.BigDecimal;
import java.util.Date;

public class Goods extends AbstractEntity{

    private String name;

    private String remark;

    private Integer num;

    private Double price;

    private String image;

    private String goodsType;

    private Long shopsId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public Long getShopsId() {
        return shopsId;
    }

    public void setShopsId(Long shopsId) {
        this.shopsId = shopsId;
    }
}
