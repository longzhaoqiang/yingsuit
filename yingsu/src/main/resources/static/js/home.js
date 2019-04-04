$(function () {
    // 检查是否登录
    checkLogin();
})

// 退出登录
function loginout() {
    var url = "/yingsu/user/loginout";
    $.ajax({
        type: "POST",
        url: url,
        success: function (data) {
            var code = data.resultCode;
            window.location.href="/";
        }
    })
}


// 检查是否登录
function checkLogin() {
    // 检查是否登录
    var url = "/yingsu/user/checkLogin";
    $.ajax({
        type: "POST",
        url: url,
        success: function (data) {
            var code = data.resultCode;
            var msg = data.resultMsg;
            if (code == "-12"){
                var flag = confirm(msg);
                if (flag){
                    window.location.href = "/login";
                }
            }
        }
    })
}