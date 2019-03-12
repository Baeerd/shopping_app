package com.app.goods.controller;

import com.app.common.exception.MessageException;
import com.app.common.util.BeanUtils;
import com.app.common.util.Util;
import com.app.goods.service.GoodsService;
import com.app.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.app.common.controller.BaseController;
import com.app.goods.entity.Goods;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/goods")
public class GoodsController extends BaseController<Goods>{

    @Autowired
    private GoodsService goodsService;

    /**
     * 添加或更新图片数据
     * @param request
     * @param file
     * @param model
     * @return
     */
    @PostMapping("/upload")
    public String uplaod(HttpServletRequest request, @RequestParam("file") MultipartFile file, Model model) {
        try {
            Goods goods = new Goods();
            BeanUtils.populate(request, goods);//前台传过来的参数映射成实体用于更新或新增至数据库
            // 设置文件名(模块名+时间)
            String fileName = "goods" + Util.getCurrentTime() + "." + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);;
            String imageUrl = "/image/goods/" + fileName;
            // 设置文件路径
            String destFileName = request.getSession().getServletContext().getRealPath("") + imageUrl;
            // 第一次运行的时候，创建文件路径
            File destFile = new File(destFileName);
            // 上传文件
            goodsService.uploadFile(file, destFile);
            goods.setImage(imageUrl);
            // 添加或更新至数据库
            if(goods.getId() != null) {
                goodsService.update(goods);
            } else {
                goodsService.insert(goods);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageException("上传失败," + e.getMessage());
        }
        return "goodsList";
    }
}
