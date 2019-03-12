package com.app.category.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.app.common.mapper.BaseMapper;
import com.app.category.entity.GoodsCategory;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsCategoryMapper extends BaseMapper<GoodsCategory>{

}
