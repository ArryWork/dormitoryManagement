var isFirst = 1;
$(function () {
    $("#sureUpload").click(upload);
    $("#sureBtn").hide();
    $("#sureBtn").click(sureUpload);
});

function upload() {
    $("#uploadForm").ajaxSubmit(
        {
            type: 'post',
            url: "/manager/checkNewStudent.do",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success:function (data) {
                $("#sureBtn").show();
                data = JSON.parse(data);
                $("#newStudentTable").bootstrapTable("removeAll");
                if(isFirst == 1) {
                    $("#newStudentTable").bootstrapTable({
                        pagination: false,
                        height: 485,
                        clickToSelect: true,
                        data: data,
                        checkbox: true,
                        columns: [
                            {
                                checkbox: true
                            },
                            {
                                field: "flag",
                                title: "信息",
                                formatter: function (data) {
                                    if (data == 1)
                                        return "学号重复"
                                }
                            },
                            {
                                field: 'dormitoryName',
                                title: '宿舍楼'
                            },
                            {
                                field: 'roomOrd',
                                title: "房间号"
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
                                formatter: function (data) {
                                    if (data == "1")
                                        return "是";
                                    else
                                        return "否";
                                }
                            },
                            {
                                field: 'major',
                                title: '专业'
                            }, {
                                field: 'grade',
                                title: '年级'
                            }, {
                                field: 'classNo',
                                title: '班级'
                            }
                        ],
                        onLoadSuccess: function (data) {
                        }
                    });
                    isFirst=0;
                }
                else {
                    $("#newStudentTable").bootstrapTable("load", {data: data});

                }
                $("#myModal").modal("hide");
            }
        })
}
function sureUpload() {
    var students =$("#newStudentTable").bootstrapTable("getSelections");
    $.ajax({
        url: "inputStudent.do",
        method: 'post',
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        data: {
            studentsJson:JSON.stringify(students)
        },
        success: function (data) {
            data = JSON.parse(data);
            swal("成功","成功插入"+data.successCount+"个学生","success");
            $("#newStudentTable").bootstrapTable("load",{data:data.failStudent});
        }
    });
}