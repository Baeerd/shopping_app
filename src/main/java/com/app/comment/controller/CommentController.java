package com.app.comment.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.app.common.controller.BaseController;
import com.app.comment.entity.Comment;

import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/comment")
public class CommentController extends BaseController<Comment>{

}
