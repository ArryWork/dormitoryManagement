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
    <title>用户管理</title>
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
                <button id="modifyBtn" type="button" class="btn btn-outline btn-default">
                    <i class="glyphicon glyphicon-edit" aria-hidden="true"></i>信息修正
                </button>
                <button id="addStudentBtn" type="button" class="btn btn-outline btn-default">
                    <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>新增学生
                </button>
                <button type="button" data-toggle="modal" data-target="#queryModal" class="btn btn-outline btn-default">
                    <i class="glyphicon glyphicon-search"  aria-hidden="true"></i>查找
                </button>
                <select id="gradeSlt" class="form-control" style="width: 40%;">
                    <option value="0">全部</option>
                </select>
            </div>
        </div>

        <div class="example-wrap">
            <div>
                <table id="studentTable">
                </table>
            </div>
        </div>

        <div class="modal inmodal" id="studentInfoModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-lg" data-animation="fadeInUp">
                <div class="modal-content animated bounceInRight">
                    <div class="modal-header">
                        详细信息
                    </div>
                    <div class="modal-body" style="height: 210px;">
                        <form id="modifyStudentForm" method="post">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">名字：</label>
                                    <div class="col-sm-9">
                                        <input type="text" id="name" name="name" class="form-control" placeholder="请输入文本">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">年级：</label>
                                    <div class="col-sm-9">
                                        <select id="modifyGradeSlt" name="grade" class="form-control">
                                        </select>
                                        <%--<input type="hidden"  id="grade" name="grade" class="form-control" placeholder="请输入文本">--%>
                                    </div>
                                </div>

                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-sm-3  control-label">学号：</label>
                                    <div class="col-sm-9">
                                        <input type="text"  id="studentNo" name="studentNo" class="form-control" placeholder="请输入文本">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">专业：</label>
                                    <div class="col-sm-9">
                                        <input type="text" id="major" name="major" class="form-control" placeholder="请输入文本">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">宿舍楼：</label>
                                    <input id="id" type="hidden" name="id"/>
                                    <div class="col-sm-9">
                                        <%--<input type="text" id="dormitory"  name="dormitory" class="form-control" placeholder="请输入文本">--%>
                                        <select id="dormitory" name="dormitoryId" class="form-control">
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">宿舍号：</label>
                                    <div class="col-sm-9">
                                        <input type="number" maxlength="3" id="roomOrd" name="roomOrd" class="form-control" placeholder="请输入文本">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">班级：</label>
                                    <div class="col-sm-9">
                                        <input type="text" id="classNo" maxlength="1" name="classNo" class="form-control" placeholder="请输入文本">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">是否舍长：</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" id="isHeadSlt" name="isHead">
                                            <option value="1">是</option>
                                            <option value="0">否</option>
                                        </select>
                                        <%--<input type="hidden" id="isHead" name="isHead" class="form-control" placeholder="请输入文本">--%>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="ensureModifyBtn">确定</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal inmodal" id="queryModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-lg" data-animation="fadeInUp">
                <div class="modal-content animated bounceInRight">
                    <div class="modal-header">
                        详细查找
                    </div>
                    <div class="modal-body" style="height: 210px;">
                        <form id="queryForm" method="post">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">名字：</label>
                                    <div class="col-sm-9">
                                        <input type="text" name="name" class="form-control" placeholder="请输入文本">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">年级：</label>
                                    <div class="col-sm-9">
                                        <select id="qryGrade" name="grade" class="form-control">
                                        </select>
                                    </div>
                                </div>

                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-sm-3  control-label">学号：</label>
                                    <div class="col-sm-9">
                                        <input type="text"  name="studentNo" class="form-control" placeholder="请输入文本">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">专业：</label>
                                    <div class="col-sm-9">
                                        <select  name="major" class="form-control" placeholder="请输入文本">
                                            <option value="">请选择</option>
                                            <option value="计算机科学与技术" >计算机科学与技术</option>
                                            <option value="网络工程">网络工程</option>
                                            <option value="电子信息工程">电子信息工程</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">宿舍楼：</label>
                                    <div class="col-sm-9">
                                        <select id="qryDomitory" name="dormitoryId" class="form-control"><option value="">请选择</option></select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">宿舍号：</label>
                                    <div class="col-sm-9">
                                        <input type="number" maxlength="3"  name="roomOrd" class="form-control" placeholder="请输入文本">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">班级：</label>
                                    <div class="col-sm-9">
                                        <select name="classNo" class="form-control" placeholder="请输入文本">
                                            <option value="0">请选择</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>

                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">是否舍长：</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" name="isHead">
                                            <option value="2">请选择</option>
                                            <option value="1">是</option>
                                            <option value="0">否</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="submitQuery">确定</button>
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
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<script src="${basePath}/resources/js/plugins/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript" src="${basePath}/resources/js/student/studentManage.js" ></script>
<script src="${basePath}/resources/js/pub/pub.js"></script>
</body>
</html>
