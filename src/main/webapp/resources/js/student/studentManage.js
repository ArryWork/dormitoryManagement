$(function () {
    initTable();
    buildGrade();
    $("#modifyBtn").click(modifyInfo);
    $("#addStudentBtn").click(addStudent);
    $("#submitQuery").click(submitQuery);
    buildSelect("/pub/getDormitory.do","dormitory");
    buildSelect("/pub/getDormitory.do","qryDomitory");
});
function initTable() {
    $("#studentTable").bootstrapTable({
        pagination:true,
        url:"getAllStudent.do",
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
                field:'dormitoryName',
                title:'宿舍楼'
            },
            {
                field:'roomOrd',
                title:"房间号"
            },
            {
                field: 'studentNo',
                title: '学号'
            },
            {
                field: 'name',
                title: '名字'
            },
            {
                field: 'isHead',
                title: '是否为舍长',
                formatter:function (data) {
                    if(data=="1")
                        return"是";
                    else
                        return "否";
                }
            },
            {
                field: 'major',
                title: '专业'
            },{
                field: 'grade',
                title: '年级'
            },{
                field:'classNo',
                title:'班级'
            }
        ],
        pageNumber:1,
        pageSize:10,
        onLoadSuccess:function (data) {
        }
    });
}

function buildGrade() {
    var modifyGradeSlt = $("#modifyGradeSlt");
    var qryGrade = $("#qryGrade");
    for(var j = new Date().getFullYear() ; j >new Date().getFullYear()-5 ; j-- ){
        $option = $("<option value = \""+j+"\">"+j+"级</option>");
        modifyGradeSlt.append($option);
        qryGrade.append($option);
    }
    modifyGradeSlt.change(function () {
        var grade = $("#modifyGradeSlt option:selected").val();
        $("#grade").val(grade);
    });
    var gradeSlt = $("#gradeSlt");
    for(var i = new Date().getFullYear() ; i >new Date().getFullYear()-5 ; i-- ){
        $option = $("<option value = \""+i+"\">"+i+"级</option>");
        gradeSlt.append($option);
    }
    gradeSlt.change(function () {
       var grade = $("#gradeSlt").val();
       $("#studentTable").bootstrapTable("refresh",
           {
               query: {grade: grade}
           });
    })
}
function modifyInfo() {
    var student = $("#studentTable").bootstrapTable("getSelections")[0];
    $("#id").val(student.id);
    $("#dormitory").val(student.dormitoryId);
    $("#grade").val(student.grade)
    $("#modifyGradeSlt").val(student.grade);
    $("#studentNo").val(student.studentNo);
    $("#studentNo").attr("readonly","readonly");
    $("#roomOrd").val(student.roomOrd);
    $("#name").val(student.name);
    $("#classNo").val(student.classNo);
    $("#major").val(student.major);
    $("#isHead").val(student.isHead);
    $("#isHeadSlt").val(student.isHead);
    $("#studentInfoModal").modal("show");
    $("#ensureModifyBtn").click(submitModify);

}
function submitModify() {
    $("#modifyStudentForm").ajaxSubmit(
        {
            url:'modifyStudent.do',
            type: 'post',
            success:function (data) {
                if(data.fail!=null)
                    swal("warning",data.fail,"warning");
                else
                    swal("success",data.msg,"success");
                $("#studentInfoModal").modal("hide");
                $("#studentTable").bootstrapTable("refresh");
            }
        })
}

function addStudent() {
    $("#modifyStudentForm").resetForm();
    $("#studentInfoModal").modal("show");
    $("#ensureModifyBtn").click(submitAdd);
    $("#studentNo").removeAttr("readonly");
}
function submitAdd() {
    $("#modifyStudentForm").ajaxSubmit(
        {
            url:'addStudent.do',
            type: 'post',
            success:function (data) {
                if(data.fail!=null)
                    swal("warning",data.fail,"warning");
                else
                    swal("success",data.msg,"success");
                $("#studentInfoModal").modal("hide");
                $("#studentTable").bootstrapTable("refresh");
            }
    })
}
function submitQuery() {
    $("#queryForm").ajaxSubmit(
        {
            url:'getAllStudent.do',
            type: 'post',
            success:function (data) {
                data = JSON.parse(data);
                $("#queryModal").modal("hide");
                $("#studentTable").bootstrapTable("load",data);
            }
        })
}