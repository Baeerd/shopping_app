package com.app.category.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.app.common.controller.BaseController;
import com.app.category.entity.GoodsCategory;

import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/goodsCategory")
public class GoodsCategoryController extends BaseController<GoodsCategory>{

}
