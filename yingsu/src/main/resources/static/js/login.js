$(function () {

})

function commit() {
    var mobile = $("#mobile").val();
    var password = $("#password").val();

    $.ajax({
        url: "/yingsu/user/userLogin",
        type: "POST",
        data: {"mobile":mobile,"password":password},
        success: function (data) {
            var result = data;
            var resultCode = result.resultCode;
            if (resultCode == "1"){
                window.location.href="/yingsu/user/index";
            } else {
                alert(data.resultMsg);
            }
        }
    })
}

// 用户注册
function registerUser() {
    var mobile = $("#mobile").val();
    var password = $("#password").val();
    var repassword = $("#repassword").val();

    if (mobile == ""){
        alert("用户名不能为空");
        return false;
    } else if (password == ""){
        alert("密码不能为空");
        return false;
    } else if (password != repassword){
        alert("两次密码不一致");
        return false;
    }

    $.ajax({
        url: "/yingsu/user/userRegister",
        type: "POST",
        data: {"mobile":mobile,"password":password},
        success: function (data) {
            var result = data;
            var resultCode = result.resultCode;
            if (resultCode == "1"){
                window.location.href="/yingsu/user/login";
            } else {
                alert(data.resultMsg);
            }
        }
    })
}