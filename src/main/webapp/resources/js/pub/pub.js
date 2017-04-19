/**
 * Created by 林强 on 2017-04-14.
 */
function buildSelect(url,selectId){
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