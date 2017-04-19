<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/ by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:16:41 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>管理员 - 主页</title>


    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${basePath}/resources/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${basePath}/resources/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${basePath}/resources/css/animate.min.css" rel="stylesheet">
    <link href="${basePath}/resources/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <style type="text/css">
        .img-circle{
            width: 64px;
            height: 64px;
        }
    </style>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->

    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span><img alt="image" class="img-circle"
                                   src="${basePath}/resources/img/profile_small.jpg"/></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">${sessionScope.manager.name}</strong></span>
                                <span class="text-muted text-xs block">管理员<b class="caret"></b></span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">宿舍管理
                    </div>
                </li>
                <li>
                    <a class="J_menuItem" href="/manager/inputDatePage.do">
                        <i class="fa fa-inbox"></i>
                        <span class="nav-label">资料录入</span></a>
                </li>
                <li>
                    <a class="J_menuItem" href="/student/studentManage.do">
                        <i class="fa fa-user"></i>
                    <span class="nav-label">学生管理</span></a>
                </li>
                <li>
                    <a class="J_menuItem" href="/room/roomManage.do">
                        <i class="fa fa-road"></i>
                    <span class="nav-label">宿舍信息管理</span></a>
                </li>
                <li>
                    <a class="J_menuItem" href="/visitor/visitorManage.do">
                        <i class="fa fa-users"></i>
                        <span class="nav-label">来访管理</span></a>
                </li>
                <li>
                    <a class="J_menuItem" href="/repairRecord/repairRecordPage.do">
                        <i class="fa fa-wrench"></i>
                        <span class="nav-label">报修信息</span></a>
                </li>
                <li>
                    <a class="J_menuItem" href="/outEntryRecord/outEntryRecordPage.do">
                        <i class="fa fa-plane"></i>
                        <span class="nav-label">出入物品登记(大件)</span></a>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav  class="page-tabs J_menuTabs">
                <a class="navbar-minimalize  btn btn-primary " href="#"><i class="fa fa-bars" style="padding: 6px;margin-bottom: 4px;margin-top: 8px;"></i> </a>
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="index_v1.html">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="login.html" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="http://www.baidu.com"
                    frameborder="0" data-id="index_v1.html" seamless></iframe>
        </div>
    </div>
    <!--右侧部分结束-->
</div>
<script src="${basePath}/resources/js/jquery.min.js?v=2.1.4"></script>
<script src="${basePath}/resources/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${basePath}/resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${basePath}/resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${basePath}/resources/js/plugins/layer/layer.min.js"></script>
<script src="${basePath}/resources/js/hplus.min.js?v=4.1.0"></script>
<script type="text/javascript" src="${basePath}/resources/js/contabs.min.js"></script>
<script src="${basePath}/resources/js/plugins/pace/pace.min.js"></script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/ by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:17:11 GMT -->
</html>
