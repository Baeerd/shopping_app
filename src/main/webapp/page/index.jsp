<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>服装商城</title>
    <meta name="description" content="主页">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <%@include file="css.jsp"%>
    <script type="text/javascript">
        $.cookie("menuSelect", "index");

        $(function(){
            $('.am-slider').flexslider({
                playAfterPaused: 3000,
                animation: "fade",
                animationLoop: true,
                smoothHeight: true,
                animationSpeed: 4000
            });
        });

    </script>
</head>

<body>

    <%@include file="top.jsp"%>


    <div class="tpl-page-container tpl-page-header-fixed">

        <%@include file="menu.jsp"%>

        <div class="tpl-content-wrapper">
            <div class="tpl-content-page-title">
                服装商城主页
            </div>
            <ol class="am-breadcrumb">
                <li><a href="/" class="am-icon-home">首页</a></li>
            </ol>
            <div class="tpl-content-scope">
                <div class="note note-info">
                    <h3>Amaze UI 为移动而生
                        <span class="close" data-close="note"></span>
                    </h3>
                    <p> Amaze UI 含近 20 个 CSS 组件、20 余 JS 组件，更有多个包含不同主题的 Web 组件，可快速构建界面出色、体验优秀的跨屏页面，大幅提升开发效率。</p>
                    <p><span class="label label-danger">提示:</span> Amaze UI 关注中文排版，根据用户代理调整字体，实现更好的中文排版效果。
                    </p>
                    <p><span class="label label-danger">提示:</span> Amaze UI 关注中文排版，根据用户代理调整字体，实现更好的中文排版效果。
                    </p>
                    <p><span class="label label-danger">提示:</span> Amaze UI 关注中文排版，根据用户代理调整字体，实现更好的中文排版效果。
                    </p>
                </div>
            </div>

            <br/><br/>

            <div class="row">

                <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                    <div class="am-slider am-slider-default">
                        <ul class="am-slides">
                            <li><img src="/assets/img/32.jpg" width="200px" height="200px"></li>
                            <li><img src="/assets/img/43.jpg" width="200px" height="200px"></li>
                        </ul>
                    </div>
                </div>

                <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                    <div class="am-slider am-slider-default">
                        <ul class="am-slides">
                            <li><img src="/assets/img/32.jpg" width="200px" height="200px"></li>
                            <li><img src="/assets/img/43.jpg" width="200px" height="200px"></li>
                        </ul>
                    </div>
                </div>

                <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                    <div class="am-slider am-slider-default">
                        <ul class="am-slides">
                            <li><img src="/assets/img/32.jpg" width="200px" height="200px"></li>
                            <li><img src="/assets/img/43.jpg" width="200px" height="200px"></li>
                        </ul>
                    </div>
                </div>

                <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                    <div class="am-slider am-slider-default">
                        <ul class="am-slides">
                            <li><img src="/assets/img/32.jpg" width="200px" height="200px"></li>
                            <li><img src="/assets/img/43.jpg" width="200px" height="200px"></li>
                        </ul>
                    </div>
                </div>

            </div>

        </div>

    </div>

</body>

</html>