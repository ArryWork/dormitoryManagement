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
    <title>来访管理</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="/resources/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/resources/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/resources/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="/resources/css/animate.min.css" rel="stylesheet">
    <link href="${basePath}/resources/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="/resources/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="/resources/css/plugins/treeview/bootstrap-treeview.css" rel="stylesheet">
    <link href="/resources/css/plugins/steps/jquery.steps.css" rel="stylesheet"/>
</head>
<body>
<div class="col-sm-12">
    <div class="example-wrap">
        <h4 class="example-title"></h4>
        <div class="example">
            <div class="btn-group hidden-xs" id="exampleToolbar" role="group" style="width: 170%">
                <button id="endVisitBtn" type="button" class="btn btn-outline btn-default">
                    <i class="glyphicon glyphicon-edit" aria-hidden="true"></i>访问结束
                </button>
                <button id="addVisitorBtn" type="button" class="btn btn-outline btn-default">
                    <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>新增访问记录
                </button>
            </div>
        </div>

        <div class="example-wrap">
            <div>
                <table id="visitorTable">
                </table>
            </div>
        </div>

        <div class="modal inmodal" id="searchStudentModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-sm" data-animation="fadeInUp">
                <div class="modal-content animated bounceInRight">
                    <div class="modal-header">
                        详细信息
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

        <div class="modal inmodal" id="addVisitorModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-lg" data-animation="fadeInUp">
                <div class="modal-content animated bounceInRight">
                    <div class="modal-header">
                        详细信息
                    </div>
                    <div class="modal-body" style="height: 300px;">
                        <form method="post" id="addVisitorForm">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">学生名：</label>
                                    <div class="col-sm-9">
                                        <input type="text" id="studentName"  name="studentName" class="form-control" readonly="readonly">
                                        <input type="hidden" id="visitStudentId" name="visitStudentId">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">宿舍：</label>
                                    <div class="col-sm-9">
                                        <input type="text" id="dormitory" class="form-control" readonly="readonly">
                                        <input type="hidden" id="visitDormitoryId" name="visitDormitoryId" class="form-control" readonly="readonly">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">访客名字：</label>
                                    <div class="col-sm-9">
                                        <input type="text" id="name" name="name" class="form-control" placeholder="访客的名字">
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
                                        <input type="number" readonly="readonly" maxlength="3" id="visitRoomOrd" name="visitRoomOrd" class="form-control" placeholder="请输入文本">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">访客关系：</label>
                                    <div class="col-sm-9">
                                        <input type="text"  id="relation" name="relation" class="form-control" placeholder="与学生的关系">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="col-sm-2  control-label" style="width:97px;">证件号：</label>
                                    <div class="col-sm-10">
                                        <input type="text"  id="idCardNo" name="idCardNo" class="form-control" placeholder="请输入证件号" style="width: 681px;">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group">
                                <label class="col-sm-2  control-label" style="width:97px;">访问原因：</label>
                                <div class="col-sm-10">
                                    <textarea   id="visitReason" name="visitReason" class="form-control" placeholder="请输入访问原因" style="width: 681px;"></textarea>
                                </div>
                            </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="submitVisitRecord">确定</button>
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
<script src="${basePath}/resources/js/plugins/staps/jquery.steps.min.js"></script>

<script src="/resources/js/plugins/treeview/bootstrap-treeview.js"></script>
<script src="/resources/js/jquery.form.js"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<script src="${basePath}/resources/js/plugins/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript" src="${basePath}/resources/js/visitor/visitor.js" ></script>
</body>
</html>
