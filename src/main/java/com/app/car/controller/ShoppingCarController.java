package com.app.car.controller;

import com.app.car.service.ShoppingCarService;
import com.app.common.entity.Response;
import com.app.common.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.app.common.controller.BaseController;
import com.app.car.entity.ShoppingCar;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@Scope("prototype")
@RequestMapping("/shoppingCar")
public class ShoppingCarController extends BaseController<ShoppingCar>{

    @Autowired
    private ShoppingCarService shoppingCarService;

    /**
     * 添加至购物车
     * @return
     */
    @RequestMapping("/addGoods")
    public Response addGoods(HttpServletRequest request) {
        String json = super.getJsonFromRequest(request);
        Map<String, String> params = Util.jsonToMap(json);
        shoppingCarService.addGoods(params);
        return new Response().success();
    }
}
