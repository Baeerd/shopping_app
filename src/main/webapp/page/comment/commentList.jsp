<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商品详情</title>
    <meta name="description" content="商品详情">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <%@include file="../css.jsp"%>
</head>

<body data-type="generalComponents">

    <%@include file="../top.jsp"%>

    <div class="tpl-page-container tpl-page-header-fixed">

        <%@include file="../menu.jsp"%>

        <div class="tpl-content-wrapper">
            <div class="tpl-content-page-title">
                商品详情
            </div>
            <ol class="am-breadcrumb">
                <li><a href="/index.html" class="am-icon-home">首页</a></li>
                <li class="am-active">商品详情</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 商品详情
                    </div>

                </div>
                <div class="tpl-block">
                    <div class="am-g">

                        <div class="am-u-sm-12 am-u-md-6">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <span class="am-icon-plus"></span>
                                </div>
                            </div>
                        </div>

                        <form action="/comment/commentList">

                            <input type="hidden" name="pageNum">
                            <input type="hidden" name="pageSize">

                            <div class="am-u-sm-12 am-u-md-3">
                                <div class="am-form-group">
                                    <select data-am-selected="{btnSize: 'sm'}" name="goodsId" class="initSelect" tableName="goods" displayName="name" displayValue="id">
                                        <option value="">所有商品</option>
                                        <option value="#value">#name</option>
                                    </select>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-3">
                                <div class="am-input-group am-input-group-sm">
                                    <input type="text" name="goodsName" class="am-form-field">
                                    <span class="am-input-group-btn">
                                        <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="submit"></button>
                                    </span>
                                </div>
                            </div>
                        </form>
                    </div>

                        <div class="am-u-sm-12 am-u-md-6 am-u-lg-4" style="z-index:2000;">
                            <div class="tpl-table-images-content">
                                <div class="tpl-table-images-content-i-time">发布时间：${goods.createdDtView}</div>
                                <div class="tpl-i-title">
                                        ${goods.name}
                                </div>
                                <a href="javascript:;" class="tpl-table-images-content-i">
                                    <div class="tpl-table-images-content-i-info">
                                            <span class="ico">
                                                <img src="../assets/img/userLogo.jpg" alt="">${goods.createdBy}
                                             </span>

                                    </div>
                                    <span class="tpl-table-images-content-i-shadow"></span>
                                    <img src="${goods.image}" alt="" width="300" height="450px;">
                                </a>
                                <div class="tpl-table-images-content-block">
                                    <div class="tpl-i-font">
                                        详细信息：${goods.remark}
                                    </div>
                                    <div class="tpl-i-font">
                                        单价：<span style="color: blue; ">${goods.price}</span>
                                    </div>
                                    <div class="tpl-i-font">
                                        <c:choose>
                                            <c:when test="${goods.num < 1}">
                                                <span style="color: red; ">已断货</span>
                                            </c:when>
                                            <c:otherwise>
                                                剩余：<span style="color: red; ">${goods.num}</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs tpl-edit-content-btn">
                                            <button type="button" class="am-btn am-btn-default am-btn-warning" onclick="buyGoods(${goods.id});">
                                                <span class="am-icon-archive">添加购物车</span>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    评论列表：
                    <ul class="tpl-task-list tpl-task-remind">

                        <c:forEach items="${page.list}" var="comment">
                            <li>
                                <div class="cosB">
                                    ${comment.createdDtView}
                                </div>
                                <div class="cosA">
                                <span class="cosIco">
                                <i class="am-icon-bell-o"></i>
                            </span>
                                    <span> ${comment.content}</span>
                                    <c:choose>
                                        <c:when test="${loginUser.username == comment.createdBy}">
                                            <span class="tpl-label-import"> ${comment.createdBy} </span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="tpl-label-info"> ${comment.createdBy} </span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </li>
                        </c:forEach>

                    </ul>

                    <div class="am-u-lg-12">
                        <%@include file="../page.jsp"%>

                        <hr>
                    </div>

                </div>

            </div>


        </div>

    </div>


    <script type="text/javascript">

        /**
         * 添加至购物车
         */
        function buyGoods(goodsId) {
            if(!goodsId) {
                return;
            }
            $.post("/shoppingCar/addGoods", {"goodsId" : goodsId}, function (data) {
                if(!data.success) {
                    alert(data.data);
                } else {
                    alert('添加购物车成功！');
                }
            });
        }
    </script>

</body>

</html>