package com.app.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.service.impl.BaseServiceImpl;
import com.app.goods.entity.Goods;
import com.app.goods.mapper.GoodsMapper;
import com.app.goods.service.GoodsService;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void updateGoodsNum(String goodsId, String numFlag) {
        goodsMapper.updateGoodsNum(goodsId, numFlag);
    }
}
