package com.app.car.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.app.common.mapper.BaseMapper;
import com.app.car.entity.ShoppingCar;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShoppingCarMapper extends BaseMapper<ShoppingCar>{

}
