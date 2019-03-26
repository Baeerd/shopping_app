package com.app.order.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.app.common.controller.BaseController;
import com.app.order.entity.GoodsOrder;

import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/goodsOrder")
public class GoodsOrderController extends BaseController<GoodsOrder>{

}
