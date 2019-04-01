<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<div class="tpl-left-nav tpl-left-nav-hover">
    <div class="tpl-left-nav-title">
        服装商城菜单
    </div>
    <div class="tpl-left-nav-list">
        <ul class="tpl-left-nav-menu">
            <li class="tpl-left-nav-item">
                <a href="/index.html" class="menuListener nav-link active" id="index">
                    <i class="am-icon-home"></i>
                    <span>首页</span>
                </a>
            </li>

            <li class="tpl-left-nav-item">
                <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                    <i class="am-icon-table"></i>
                    <span>后台管理</span>
                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                </a>
                <ul class="tpl-left-nav-sub-menu" style="display: block;">
                    <li>
                        <a href="/goods/goodsList" class="menuListener" id="goodsList">
                            <i class="am-icon-angle-right"></i>
                            <span>商品管理</span>
                            <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                        </a>

                        <a href="table-images-list.html" class="menuListener">
                            <i class="am-icon-angle-right"></i>
                            <span>商铺管理</span>

                            <a href="form-news.html" class="menuListener">
                                <i class="am-icon-angle-right"></i>
                                <span>商家入驻申请</span>
                                <i class="tpl-left-nav-content tpl-badge-danger">
                                    5
                                </i>
                            </a>

                            <a href="form-news-list.html" class="menuListener">
                                <i class="am-icon-angle-right"></i>
                                <span>订单管理</span>

                            </a>

                            <a href="form-news-list.html" class="menuListener">
                                <i class="am-icon-angle-right"></i>
                                <span>评论管理</span>

                            </a>

                            <a href="/system/userList" class="menuListener" id="userList">
                                <i class="am-icon-angle-right"></i>
                                <span>人员管理</span>

                            </a>

                            <%--<a href="form-news-list.html" class="menuListener">
                                <i class="am-icon-angle-right"></i>
                                <span>商家管理</span>

                            </a>--%>
                    </li>
                </ul>
            </li>

            <li class="tpl-left-nav-item">
                <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                    <i class="am-icon-wpforms"></i>
                    <span>服装商城系统</span>
                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                </a>
                <ul class="tpl-left-nav-sub-menu" style="display: block;">
                    <li>
                        <a href="/goods/goodsListPanel" class="menuListener" id="goodsListPanel">
                            <i class="am-icon-angle-right"></i>
                            <span>服装浏览</span>
                        </a>

                        <a href="/system/registVip?id=${loginUser.id}" class="menuListener" id="registVip">
                            <i class="am-icon-angle-right"></i>
                            <span>会员注册</span>
                        </a>
                        <c:choose>
                            <c:when  test="${loginUser.userType=='2'}">
                                <a href="/shops/shopsListPanel?userId=${loginUser.id}" class="menuListener" id="shopsListPanel">
                                    <i class="am-icon-angle-right"></i>
                                    <span>店铺管理</span>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a href="/system/registSeller?id=${loginUser.id}" class="menuListener" id="registSeller">
                                    <i class="am-icon-angle-right"></i>
                                    <span>申请入驻</span>
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        /**
         * 监听菜单点击事件
         */
        menuClickListener();
        /**
         * 监听菜单选择事件
         */
        menuListener();
    });
    
    function menuListener() {
        // 获取cookie
        var menuSelect = $.cookie('menuSelect');
        console.log(menuSelect);
        if(!menuSelect){
            return;
        }
        // 清空选中状态
        $(".menuListener").removeClass("active");
        $("#"+menuSelect).addClass("active");
    }

    function menuClickListener() {
        $(".menuListener").click(function () {
            var id = $(this).attr("id");
            // 设置cookie
            $.cookie('menuSelect', id);
        });
    }
</script>