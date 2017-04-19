
$(function () {
    initTable();
    $("#addOutEntryRecordBtn").click(showAddModal);
    $("#searchStudent").click(searchStudent);
    $("#submitRecord").click(submitRecord);
    $("#searchBtn").click(showSearchModal);
    $("#searchRecordBtn").click(submitSearch);
    $("#startTime").datepicker();
    $("#endTime").datepicker();
    validateAddForm();
});
function initTable() {
    $("#outEntryRecordTable").bootstrapTable({
        pagination:true,
        url:"getOutEntryRecord.do",
        height:550,
        clickToSelect: true,
        search:true,
        method:"post",
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        searchOnEnterKey:true,
        showRefresh:true,
        toolbar:"#exampleToolbar",
        columns: [
            {
                radio:true
            },
            {
                field:'dormitory',
                title:'宿舍楼',
                width:'110'
            },
            {
                field:'roomOrd',
                title:"房间号",
                width:'110'
            },
            {
                field: 'studentNo',
                title: '学号'
            },
            {
                field: 'studentName',
                title: '名字'
            },{
                field:'time',
                title:'出入日期',
                formatter:formatTime
            },{
                field: 'type',
                title: '类型',
                formatter:function (value) {
                    if(value == 1)
                        return "出";
                    if(value == 2)
                        return "入";
                }
            },{
                field:'belonging',
                title:'携带物品',
                width:'300'

            }
        ],
        pageNumber:1,
        pageSize:10,
        onLoadSuccess:function (data) {
        }
    });
}

function formatTime(value,data,index) {
    var date = new Date(value);
    var resultDate = (date.getMonth()+1)+"月"+date.getDate()+"日";
    return resultDate;
}

function showAddModal() {
    $("#searchStudentModal").modal("show");
}

function searchStudent() {
    var studentNo = $("#studentNo").val();
    $.ajax({
        type : "POST",
        url : "/student/getStudentByNo.do",
        dataType : 'json',
        data:{studentNo:studentNo},
        success:function (data) {
            $("#searchStudentModal").modal("hide");
            $("#addStudentNo").val(data.studentNo);
            $("#studentName").val(data.name);
            $("#dormitory").val(data.dormitoryName);
            $("#dormitoryId").val(data.dormitoryId);
            $("#roomOrd").val(data.roomOrd);
            $("#addRecordModal").modal("show");
        },
        error:function () {
            swal("error","没有该学生，请输入正确的学号","error");
        }
    });
}

function submitRecord() {
    $("#addOutEntryRecordForm").submit();
}

function validateAddForm() {
    $("#addOutEntryRecordForm").validate({
        submitHandler:function () {
            $("#addOutEntryRecordForm").ajaxSubmit(
                {
                    url: 'addOutEntryRecord.do',
                    type: 'post',
                    success: function (data) {
                        if (data.fail != null)
                            swal("warning", data.fail, "warning");
                        else
                            swal("success", data.msg, "success");
                        $("#addOutEntryRecordForm").resetForm();
                        $("#addRecordModal").modal("hide");
                        $("#outEntryRecordTable").bootstrapTable("refresh");
                    }
                })
        },
        onsubmit:true,// 是否在提交是验证
        onfocusout:true,// 是否在获取焦点时验证
        onkeyup :true,
        rules:{
            belonging:"required"
        },
        messages:{
            belonging:"请输入您携带的物品"
        }
    })
}

function showSearchModal() {
    $("#searchModal").modal("show");
}

function submitSearch() {
    var startTime = $("#startTime").val();
    var endTime = $("#endTime").val();
    $.ajax({
        type : "POST",
        url : "/outEntryRecord/getOutEntryRecord.do",
        dataType : 'json',
        data:{
            startTime:startTime,
            endTime:endTime
        },
        success:function (data) {
            console.log(data);
            $("#outEntryRecordTable").bootstrapTable('load',data);
            $("#searchModal").modal("hide");
        },
        error:function () {
            swal("error","查询出错,请查询日志","error");
        }
    });
}
