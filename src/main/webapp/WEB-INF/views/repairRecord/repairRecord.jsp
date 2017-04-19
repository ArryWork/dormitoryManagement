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
    <title>报修信息</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="/resources/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/resources/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/resources/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="/resources/css/animate.min.css" rel="stylesheet">
    <link href="${basePath}/resources/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="/resources/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="/resources/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <style >
        .datapicker{
            z-index: 20000;
        }
    </style>
</head>
<body>
<div class="col-sm-12">
    <div class="example-wrap">
        <h4 class="example-title">工具条</h4>
        <div class="example">
            <div class="btn-group hidden-xs" id="exampleToolbar" role="group" style="width: 170%">
                <button id="searchBtn" type="button" class="btn btn-outline btn-default">
                    <i class="glyphicon glyphicon-edit" aria-hidden="true"></i>查询
                </button>
                <button id="solvedBtn" type="button" class="btn btn-outline btn-default">
                    <i class="glyphicon glyphicon-check" aria-hidden="true"></i>已解决
                </button>
                <button id="addRepairRecordBtn" type="button" class="btn btn-outline btn-default">
                    <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>维修登记
                </button>
            </div>
        </div>

        <div class="example-wrap">
            <div>
                <table id="repairRecordTable">
                </table>
            </div>
        </div>

        <div class="modal inmodal" id="searchStudentModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-sm" data-animation="fadeInUp">
                <div class="modal-content animated bounceInRight">
                    <div class="modal-header">
                        请输入报修学生的学号
                    </div>
                    <div class="modal-body" style="height: 80px;">
                        <div class="col-sm-12">
                            <input type="number" id="studentNo" name="name" class="form-control" placeholder="输入学号查找">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="searchStudent">确定</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal inmodal" id="addRecordModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-lg" data-animation="fadeInUp">
                <div class="modal-content animated bounceInRight">
                    <div class="modal-header">
                        详细信息
                    </div>
                    <div class="modal-body" style="height: 160px;">
                        <form method="post" id="addRepairRecordForm">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">学生名：</label>
                                    <div class="col-sm-9">
                                        <input type="text" id="studentName"  name="studentName" class="form-control" readonly="readonly">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">宿舍：</label>
                                    <div class="col-sm-9">
                                        <input type="text" id="dormitory" class="form-control" readonly="readonly">
                                        <input type="hidden" id="repairDormitoryId" name="dormitoryId" class="form-control" readonly="readonly">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">类型：</label>
                                    <div class="col-sm-9">
                                        <select id="type" name="type" class="form-control">
                                            <option></option>
                                            <option value="1">电器</option>
                                            <option value="2">桌椅</option>
                                            <option value="3">水电</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-sm-3  control-label">学号：</label>
                                    <div class="col-sm-9">
                                        <input type="text"  readonly="readonly" id="addStudentNo" name="studentNo" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">宿舍号：</label>
                                    <div class="col-sm-9">
                                        <input type="number" readonly="readonly" maxlength="3" id="repairRoomOrd" name="roomOrd" class="form-control" placeholder="请输入文本">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">详细：</label>
                                    <div class="col-sm-9">
                                        <input type="text" id="reason" name="reason" class="form-control" >
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="submitRepairRecord">确定</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal inmodal" id="searchModal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
            <div class="modal-dialog " data-animation="fadeInUp">
                <div class="modal-content animated bounceInRight">
                    <div class="modal-header">
                        查询
                    </div>
                    <div class="modal-body" style="height: 160px;">

                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">宿舍：</label>
                                <div class="col-sm-9">
                                    <select id="dormitorySlt" style="width: 195px; display: inline-block;" class="form-control">
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">开始时间：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="startTime" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">结束时间：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="endTime" class="form-control">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="searchRecordBtn">确定</button>
                    </div>
                </div>
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
<script src="/resources/js/jquery.form.js"></script>
<script src="/resources/js/plugins/validate/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script src="${basePath}/resources/js/plugins/datapicker/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<script src="${basePath}/resources/js/plugins/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript" src="${basePath}/resources/js/repairRecord/repairRecord.js" ></script>
</body>
</html>
