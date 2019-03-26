package com.app.goods.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.app.common.controller.BaseController;
import com.app.goods.entity.Goods;

import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/goods")
public class GoodsController extends BaseController<Goods>{

}
