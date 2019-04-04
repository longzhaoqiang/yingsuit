$(function () {
    checkLogin();
    getCatagoryList();
})

function registerBuss() {
    var vocation = $("#vocation").val();
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/yingsu/buss/addbuss" ,//url
        data: $('#bussForm').serialize(),
        success: function (result) {
            var code = result.resultCode;
            var msg = result.resultMsg;
            if (code == "1"){
                // window.location.href = "/home";
            } else {
                alert(msg);
            }
        },
        error : function() {
            alert("异常！");
        }
    });
}

// 获取商家分类列表
function getCatagoryList() {
    var url = "/yingsu/buss/getCatagoryList"
    $.ajax({
        type: "POST",
        url: url,
        success: function (data) {
            for(var i=0;i<data.object.length;i++){
                $("#catagoryId").append("<option value='"+data.object[i].id+"'>"+data.object[i].catagoryName+"</option>");
            }
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