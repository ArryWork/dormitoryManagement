$(function () {
    initTable();
    $("#addVisitorBtn").click(addVisitRecord);
    $("#searchStudent").click(searchStudent);
    $("#submitVisitRecord").click(submitVisitRecord);
    $("#endVisitBtn").click(endVisit);
});
function initTable() {
    $("#visitorTable").bootstrapTable({
        pagination:true,
        url:"getAllVisitor.do",
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
                field:'name',
                title:'访客',
                width:70
            },{
                field:"student",
                title:"学生",
                width:70
            },{
                field:"dormitory",
                title:"宿舍"
            },
            {
                field:"visitRoomOrd",
                title:"房间号"
            },
            {
                field:'relation',
                title:"关系"
            },
            {
                field: 'idCardNo',
                title: '证件号'
            },
            {
                field: 'visitStatus',
                title: '访问状态',
                formatter:function (value) {
                    if(value==1)
                        return "访问中";
                    else
                        return "访问结束"
                }
            },
            {
                field: 'visitDate',
                title: '访问日期',
                width:150,
                formatter: formatTime
            },{
                field: 'visitReason',
                title: '访问原因',
                width:500
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
    var hour = date.getHours();
    var minute = date.getMinutes();
    if(hour<10)
        hour="0"+hour;
    if(minute<10)
        minute="0"+minute;
    var resultDate = (date.getMonth()+1)+"月"+date.getDate()+"日&nbsp;&nbsp;"+hour+":"+minute;
    return resultDate;
}

function addVisitRecord() {
    $("#studentNo").val("");
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
            $("#visitDormitoryId").val(data.dormitoryId);
            $("#visitStudentId").val(data.id);
            $("#visitRoomOrd").val(data.roomOrd);
            $("#addVisitorModal").modal("show");
        },
        error:function () {
            swal("error","没有该学生，请输入正确的学号","error");
        }
    });
}

function submitVisitRecord() {
    $("#addVisitorForm").ajaxSubmit(
        {
            url:'addVisitRecord.do',
            type: 'post',
            success:function (data) {
                if(data.fail!=null)
                    swal("warning",data.fail,"warning");
                else
                    swal("success",data.msg,"success");
                $("#addVisitorForm").resetForm();
                $("#addVisitorModal").modal("hide");
                $("#visitorTable").bootstrapTable("refresh");
            }
        })
}

function endVisit() {
    var visitRecord = $("#visitorTable").bootstrapTable("getSelections")[0];
    if(visitRecord.visitStatus == 0) {
        swal("warning", "无法结束已结束的访问", "warning");
        return;
    }
    if(visitRecord==null)
        swal("warning","请选择一条记录","warning");
    else{
        $.ajax({
            type : "POST",
            url : "/visitor/endVisit.do",
            dataType : 'json',
            data:{visitId:visitRecord.id},
            success:function (data) {
                if(data.fail!=null)
                    swal("warning",data.fail,"warning");
                else
                    swal("success",data.msg,"success");
                $("#visitorTable").bootstrapTable("refresh");
            },
            error:function () {
                swal("error","没有该学生，请输入正确的学号","error");
            }
        });
    }
}