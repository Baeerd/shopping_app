package com.app.car.service.impl;

import com.app.common.util.LoginUtil;
import com.app.goods.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.service.impl.BaseServiceImpl;
import com.app.car.entity.ShoppingCar;
import com.app.car.mapper.ShoppingCarMapper;
import com.app.car.service.ShoppingCarService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCarServiceImpl extends BaseServiceImpl<ShoppingCar> implements ShoppingCarService {

    @Autowired
    private ShoppingCarMapper shoppingCarMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 逻辑：
     * 1 判断当前登录人是否已经有购物车
     * 2 如果没有，则新增购物车并将商品添加进去（同时商品库存-1）
     * 3 如果已经存在购物车，判断购物车中是否有此商品
     * 4 如果没有此商品，则将商品添加至此购物车（同时商品库存-1）
     * 5 如果有此商品，则将商品的数量+1（同时商品库存-1）
     * @param params
     */
    @Override
    public void addGoods(Map<String, String> params) {
        String goodsId = params.get("goodsId");
        // 判断当前登录人是否已经有购物车
        Map<String, String> carParams = new HashMap<>();
        carParams.put("userId", LoginUtil.getUserId());
        List<ShoppingCar> userCarList = shoppingCarMapper.find(carParams);
        if(userCarList == null || userCarList.size() == 0) {
            // 如果没有，则新增购物车并将商品添加进去
            addGoodsToShoppingCar(goodsId);
        } else {
            // 如果已经存在购物车，判断购物车中是否有此商品
            carParams.put("goodsId", goodsId);
            List<ShoppingCar> userGoodsCarList = shoppingCarMapper.find(carParams);
            // 如果没有此商品，则将商品添加至此购物车
            if(userGoodsCarList == null || userGoodsCarList.size() == 0) {
                addGoodsToShoppingCar(goodsId);
            } else {
                // 如果有此商品，则将商品的数量+1
                ShoppingCar shoppingCar = userGoodsCarList.get(0);
                shoppingCar.setNum(shoppingCar.getNum()+1);
                shoppingCarMapper.update(shoppingCar);
                // 同时商品库存-1
                goodsMapper.updateGoodsNum(goodsId, "-1");
            }
        }
    }

    /**
     * 将商品添加至当前登录人的购物车
     * @param goodsId
     */
    private void addGoodsToShoppingCar(String goodsId) {
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setCreatedDt(new Date());
        shoppingCar.setCreatedBy(LoginUtil.getUserName());
        shoppingCar.setGoodsId(Long.valueOf(goodsId));
        shoppingCar.setNum(1);
        shoppingCar.setUserId(Long.valueOf(LoginUtil.getUserId()));
        shoppingCarMapper.insert(shoppingCar);

        // 同时商品库存-1
        goodsMapper.updateGoodsNum(goodsId, "-1");
    }

}
