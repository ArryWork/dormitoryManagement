$(function () {
    initTable();
    $("#showMemberBtn").click(showMember);
    buildSelect("/pub/getDormitory.do","dormitory");
    $("#dormitory").change(getRoomByDormitory)
});
function initTable() {
    $("#roomTable").bootstrapTable({
        pagination:true,
        url:"getRoom.do",
        height:550,
        method:"post",
        clickToSelect: true,
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        search:true,
        searchOnEnterKey:true,
        showRefresh:true,
        toolbar:"#exampleToolbar",
        columns: [
            {radio:true},
            {
                field:'dormitory',
                title:'宿舍楼'
            },
            {
                field:'roomOrd',
                title:"房间号"
            },
            {
                field: 'head',
                title: '舍长'
            }
        ],
        pageNumber:1,
        pageSize:10,
        onLoadSuccess:function (data) {
        }
    });
    $("#memberTable").bootstrapTable({
        height:400,
        method:"post",
        striped:true,
        searchOnEnterKey:true,
        contentType : "application/x-www-form-urlencoded",
        columns: [
            {
                field:"name",
                title:"名字"
            },
            {
                field: 'studentNo',
                title: '学号'
            },
            {
                field:'grade',
                title:"年级"
            },
            {
                field: 'classNo',
                title: '班级'
            },{
                field:"isHead",
                title:"操作",
                formatter:function (value, row, index) {
                    if(value=="0")
                        return "<button type=\"button\" onclick='setHead(this)' studentId = "+row.id+" class=\"btn setHeadBtn btn-outline btn-default\">设为舍长</button> ";
                    else
                        return "--";
                }
            }
        ],
        onLoadSuccess:function () {
            $("#memberModal").modal("show");
            $("#memberTable").bootstrapTable('resetView');
        }
    });
}

function showMember() {
    var room = $("#roomTable").bootstrapTable("getSelections")[0];
    if(room==null)
        swal("warning","请选择一间宿舍","warning");
    else {
        $("#memberTable").bootstrapTable("refresh",{
            url:"getMembersByRoom.do",
            query:{
                    roomOrd: room.roomOrd,
                    dormitoryId: room.dormitoryId
            }
        });
    }
}

function setHead(btn) {
    var roomHeadId = btn.getAttribute("studentId");
    $.ajax({
        type : "POST",
        url : "setHead.do",
        dataType : 'json',
        data:{
            roomHeadId:roomHeadId,
            roomId:$("#roomTable").bootstrapTable("getSelections")[0].id
        },
        success:function (data) {
            $("#roomTable").bootstrapTable("refresh",{query:{dormitoryId:$("#dormitory").val()}});
            if(data.error == null) {
                swal("success", data.msg, "success");
                $("#memberModal").modal("hide");
            }
            else {
                swal("warning", data.error, "warning");
                $("#memberModal").modal("hide");
            }
        }
    });
}

function getRoomByDormitory() {
    var dormitoryId = $("#dormitory").val();
    $("#roomTable").bootstrapTable("refresh",
        {
            query: {dormitoryId: dormitoryId}
        });
}