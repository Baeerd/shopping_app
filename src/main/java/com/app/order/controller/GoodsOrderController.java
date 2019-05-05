package com.app.order.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.common.controller.BaseController;
import com.app.common.entity.Response;
import com.app.common.util.Util;
import com.app.goods.entity.Goods;
import com.app.order.entity.GoodsOrder;
import com.app.order.entity.GoodsOrderVo;
import com.app.order.service.GoodsOrderService;

@Controller
@Scope("prototype")
@RequestMapping("/goodsOrder")
public class GoodsOrderController extends BaseController<GoodsOrder>{
	@Autowired
	private GoodsOrderService goodsOrderService;
	
	@RequestMapping("/orderList")
    public ModelAndView orderList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/order/orderList");
        Map<String, String> params = new HashMap<>();
        if(request != null) {
            String json = super.getJsonFromRequest(request);
            params = Util.jsonToMap(json);
        }
        List<GoodsOrder> goodsOrderList = goodsOrderService.findByParam(params);
        //如果订单号&&商家名&&创建时间&&订单状态 一致则算是一条订单
        Map<String,List<Goods>> orderMap = new HashMap<>();
        for (GoodsOrder goodsOrder : goodsOrderList) {
        	String orderNo = goodsOrder.getOrderNo();//订单号
        	String shopsName = goodsOrder.getGoods().getShopsIdView();//商家名
        	String createdDtView = goodsOrder.getCreatedDtView();//创建时间
        	String orderTypeView = goodsOrder.getOrderTypeView();//订单状态
        	String key = createdDtView+"#"+orderNo+"#"+shopsName+"#"+orderTypeView;
        	List<Goods> list = orderMap.get(key);
        	if(list!=null&&!list.isEmpty()) {
        		list.add(goodsOrder.getGoods());
        	}else {
        		List<Goods> goodsList = new ArrayList<>();
        		goodsList.add(goodsOrder.getGoods());
        		orderMap.put(key, goodsList);
        	}
        	
		}
        
        List<GoodsOrderVo> goodsOrderVoList = new ArrayList<>();
        for (Entry<String, List<Goods>> entry : orderMap.entrySet()) {
        	GoodsOrderVo goodsOrderVo = new GoodsOrderVo();
			goodsOrderVo.setGoodsList(entry.getValue());
			String key = entry.getKey();//key中内容为 创建时间+#+订单号+#+商铺名称+#+订单状态
			String[] split = key.split("#");
			goodsOrderVo.setCreatDt(split[0]);
			goodsOrderVo.setOrderNo(split[1]);
			goodsOrderVo.setShopsName(split[2]);
			goodsOrderVo.setOrderTypeView(split[3]);
			Double totalPrice = new Double(0);
			for (GoodsOrder goodsOrder : goodsOrderList) {
				if(split[1].equals(goodsOrder.getOrderNo())) {
					//如果为同一订单号,金额累加
					totalPrice+=goodsOrder.getTotalPrice();
				}
			}
			goodsOrderVo.setTotalPrice(totalPrice);
			goodsOrderVoList.add(goodsOrderVo);
		}
        
        // 按照订单号进行降序排列 
        Collections.sort(goodsOrderVoList, new Comparator<GoodsOrderVo>() {  
            public int compare(GoodsOrderVo o1, GoodsOrderVo o2) {  
                if (Long.parseLong(o1.getOrderNo()) > Long.parseLong(o2.getOrderNo())) {  
                    return -1;  
                }  
                if (Long.parseLong(o1.getOrderNo()) == Long.parseLong(o2.getOrderNo())) {  
                    return 0;  
                }  
                return 1;  
            }  
        });
        
        modelAndView.addObject("goodsOrderVoList", goodsOrderVoList);
        return modelAndView;
    }
	
	//付款
	@RequestMapping("/payment")
    public Response payment(HttpServletRequest request) {
		String orderNo = request.getParameter("orderNo");//前台传递的订单号
		Map<String,String> params = new HashMap<>();
		params.put("orderNo", orderNo);
		List<GoodsOrder> goodsOrderList = goodsOrderService.findByParam(params);
		for (GoodsOrder goodsOrder : goodsOrderList) {
			goodsOrder.setOrderType("1");
			goodsOrderService.update(goodsOrder);
		}
		return new Response().success();
	}
	
	//取消订单
	@RequestMapping("/clearOrder")
	public Response clearOrder(HttpServletRequest request) {

		String orderNo = request.getParameter("orderNo");//前台传递的订单号
		Map<String,String> params = new HashMap<>();
		params.put("orderNo", orderNo);
		List<GoodsOrder> goodsOrderList = goodsOrderService.findByParam(params);
		for (GoodsOrder goodsOrder : goodsOrderList) {
			goodsOrder.setOrderType("2");
			goodsOrderService.update(goodsOrder);
		}
		return new Response().success();
	
	}
	
}
