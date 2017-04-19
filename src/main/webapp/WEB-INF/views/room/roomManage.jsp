<%--
  Created by IntelliJ IDEA.
  User: 林强
  Date: 2016-12-23
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宿舍管理</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="/resources/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/resources/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/resources/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="/resources/css/animate.min.css" rel="stylesheet">
    <link href="${basePath}/resources/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="/resources/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body>
<div class="col-sm-12">
    <div class="example-wrap">
        <h4 class="example-title">工具条</h4>
        <div class="example">
            <div class="btn-group hidden-xs" id="exampleToolbar" role="group" style="width: 170%">
                <button id="showMemberBtn" type="button" class="btn btn-outline btn-default">
                    <i class="glyphicon glyphicon-heart" aria-hidden="true"></i>宿舍人员
                </button>
                <select id="dormitory" class="form-control" style="width: 40%;"></select>
            </div>
        </div>

        <div class="example-wrap">
            <div>
                <table id="roomTable">
                </table>
            </div>
        </div>
    </div>

</div>
<div class="modal inmodal" id="memberModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content animated bounceInRight">
            <div class="modal-header">
                宿舍信息
            </div>
            <div class="modal-body">
                <table id="memberTable"></table>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

<script src="${basePath}/resources/js/jquery.min.js?v=2.1.4"></script>
<script src="${basePath}/resources/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${basePath}/resources/js/content.min.js?v=1.0.0"></script>
<script src="${basePath}/resources/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${basePath}/resources/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${basePath}/resources/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<script src="${basePath}/resources/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="${basePath}/resources/js/pub/pub.js"></script>
<script type="text/javascript" src="${basePath}/resources/js/room/roomManage.js" ></script>
</body>
</html>
