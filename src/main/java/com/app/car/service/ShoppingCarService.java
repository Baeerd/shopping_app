package com.app.car.service;

import com.app.common.service.BaseService;
import com.app.car.entity.ShoppingCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShoppingCarService extends BaseService<ShoppingCar>{

    /**
     * 添加至购物车
     * @param params
     */
    void addGoods(Map<String, String> params);

    /**
     * 增加或减少购物车商品数量
     * @param id
     * @param numFlag
     */
    void updateCarNum(String id, String numFlag);
}
