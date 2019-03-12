package com.app.car.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.app.common.controller.BaseController;
import com.app.car.entity.ShoppingCar;

import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/shoppingCar")
public class ShoppingCarController extends BaseController<ShoppingCar>{

}
