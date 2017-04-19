$(function () {
    $("#loginBtn").click(login)
});
function login() {
    $.ajax({
        type : "POST",
        url : "manager/login.do",
        dataType : 'json',
        data:{
            account:$("#account").val(),
            password:$("#password").val()
        },
        success:function (data) {
            if(data.error!=null){
                toastr.options = {
                    "closeButton": true,
                    "debug": false,
                    "progressBar": true,
                    "positionClass": "toast-top-right",
                    "onclick": null,
                    "showDuration": "400",
                    "hideDuration": "1000",
                    "timeOut": "3000",
                    "extendedTimeOut": "1000",
                    "showEasing": "swing",
                    "hideEasing": "linear",
                    "showMethod": "fadeIn",
                    "hideMethod": "fadeOut"
                    };
                toastr.warning(data.error,"提示");

            }else if (data.url!=null){
                window.location.href=data.url;
            }
        }
    });
}


