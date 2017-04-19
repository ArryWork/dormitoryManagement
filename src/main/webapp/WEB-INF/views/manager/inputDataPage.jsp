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
    <title>信息导入</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="/resources/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/resources/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/resources/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="/resources/css/animate.min.css" rel="stylesheet">
    <link href="${basePath}/resources/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="/resources/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <style type="text/css">
        #inputDateBtn,#sureBtn{
            width: 120px;
            height: 51px;
            font-size: 25px;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<div class="col-sm-12">
    <div class="example-wrap">
        <button id="inputDateBtn" data-toggle="modal" data-target="#myModal" class="btn btn-primary  dim btn-large-dim" type="button"><i class="fa fa-plus-square"></i>导入</button>
        <button id="sureBtn" data-toggle="modal" class="btn btn-primary  dim btn-large-dim" type="button"><i class="fa fa-check"></i>确定</button>

        <div class="example-wrap">
            <div>
                <table id="newStudentTable">
                </table>
            </div>
        </div>
    </div>

<div class="col-sm-12">
    <div class="example-wrap">
        <div class="modal inmodal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content animated bounceInRight">
                    <div class="modal-body">
                        <form id="uploadForm" enctype="application/x-www-form-urlencoded">
                            <input type="file" name="file" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                        <button id="sureUpload" type="button" class="btn btn-primary">确定</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/resources/js/jquery.min.js?v=2.1.4"></script>
<script src="/resources/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/resources/js/content.min.js?v=1.0.0"></script>
<script src="/resources/js/jquery.form.js"></script>
<script src="/resources/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="/resources/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="/resources/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<script src="/resources/js/manager/inputDate.js"></script>
<script src="${basePath}/resources/js/plugins/sweetalert/sweetalert.min.js"></script>

</body>
</html>
