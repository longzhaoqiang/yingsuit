$(function () {
    var url = "/yingsu/buss/getVacatList"
    $.ajax({
        type: "POST",
        url: url,
        success: function (data) {
            for(var i=0;i<data.object.length;i++){
                $("#catagoryId").append("<option value='"+data.object[i].id+"'>"+data.object[i].vocationName+"</option>");
            }
        }
    })
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
                window.location.href = "/home";
            } else {
                alert(msg);
            }
        },
        error : function() {
            alert("异常！");
        }
    });

}