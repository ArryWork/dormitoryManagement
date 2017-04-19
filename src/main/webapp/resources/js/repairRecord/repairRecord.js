
$(function () {
    initTable();
    $("#addRepairRecordBtn").click(addRecordModal);
    $("#searchStudent").click(searchStudent);
    $("#submitRepairRecord").click(submitRepairRecord);
    $("#searchBtn").click(showSearchModal);
    $("#startTime").datepicker();
    $("#endTime").datepicker();
    $("#searchRecordBtn").click(submitSearch);
    $("#solvedBtn").click(solved);
    validateAddForm();
});
function initTable() {
    $("#repairRecordTable").bootstrapTable({
        pagination:true,
        url:"getRepairRecord.do",
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
                field:"status",
                title:"状态",
                formatter:function (value) {
                    if(value == 0)
                        return "<span style = 'color:red'>未解决</span>";
                    if(value == 1)
                        return "<span style = 'color:green'>已解决</span>"
                }
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
                title: '报修人学号'
            },
            {
                field: 'studentName',
                title: '报修人'
            },{
                field:'reportTime',
                title:'报修日期',
                formatter:formatTime
            },{
                field: 'type',
                title: '报修类型',
                formatter:function (value) {
                    if(value == 1)
                        return "电器损坏";
                    if(value == 2)
                        return "桌椅损坏";
                    if(value == 3)
                        return "水电损坏";
                }
            },{
                field:'reason',
                title:'报修理由',
                width:'300'

            }
        ],
        pageNumber:1,
        pageSize:10,
        onLoadSuccess:function (data) {
        }
    });
}

function addRecordModal() {
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
            $("#repairDormitoryId").val(data.dormitoryId);
            $("#repairStudentId").val(data.id);
            $("#repairRoomOrd").val(data.roomOrd);
            $("#addRecordModal").modal("show");
        },
        error:function () {
            swal("error","没有该学生，请输入正确的学号","error");
        }
    });
}
function submitRepairRecord() {
    $("#addRepairRecordForm").submit();
}
function formatTime(value,data,index) {
    var date = new Date(value);
    var resultDate = (date.getMonth()+1)+"月"+date.getDate()+"日";
    return resultDate;
}

function showSearchModal() {
    buildDormitorySlt("/pub/getDormitory.do","dormitorySlt");
    $("#searchModal").modal("show");
}

function buildDormitorySlt(url,selectId){
    $.ajax({
        type : "POST",
        url : url,
        dataType : 'json',
        success:function (data) {
          for(var i = 0 ; i < data.length; i++){
              $option = $("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
              $("#"+selectId).append($option);
          }
        }
    });
}

function validateAddForm() {
    $("#addRepairRecordForm").validate({
        submitHandler:function () {
            $("#addRepairRecordForm").ajaxSubmit(
                {
                    url: 'addRepairRecord.do',
                    type: 'post',
                    success: function (data) {
                        if (data.fail != null)
                            swal("warning", data.fail, "warning");
                        else
                            swal("success", data.msg, "success");
                        $("#addRepairRecordForm").resetForm();
                        $("#addRecordModal").modal("hide");
                        $("#repairRecordTable").bootstrapTable("refresh");
                    }
                })
        },
        onsubmit:true,// 是否在提交是验证
        onfocusout:true,// 是否在获取焦点时验证
        onkeyup :true,
        rules:{
            reason:"required"
        },
        messages:{
            reason:"请输入详细信息"
        }
    })
}
function submitSearch() {
    var startTime = $("#startTime").val();
    var endTime = $("#endTime").val();
    var dormitoryId = $("#dormitorySlt option:selected").val();
    $.ajax({
        type : "POST",
        url : "/repairRecord/getRepairRecord.do",
        dataType : 'json',
        data:{
            startTime:startTime,
            endTime:endTime,
            dormitoryId:dormitoryId
        },
        success:function (data) {
            $("#repairRecordTable").bootstrapTable('load',data);
            $("#searchModal").modal("hide");
        },
        error:function () {
            swal("error","查询出错,请查询日志","error");
        }
    });
}

function solved() {
    var record = $("#repairRecordTable").bootstrapTable("getSelections")[0];
    if(record==null)
        swal("warning","请选择一条记录","warning");
    if(record.status==1)
        swal("warning","该条报修记录已处理","warning");
    else {
        $.ajax({
            type: "POST",
            url: "/repairRecord/solve.do",
            dataType: 'json',
            data: {
                recordId: record.id
            },
            success: function (data) {
                $("#repairRecordTable").bootstrapTable('refresh');
                swal("success", data.msg, "success");
            },
            error: function () {
                swal("error", "查询出错,请查询日志", "error");
            }
        });
    }
}