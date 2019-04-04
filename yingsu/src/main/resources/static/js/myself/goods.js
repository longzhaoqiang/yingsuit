$(function () {
    checkLogin();
    getAll();
})

// 获取所有商品
function getAll() {
    // 每次点击时先清空
    $("#goods_all").html("");
    var url = "/product/getList";
    $.ajax({
        type: "POST",
        url: url,
        success: function (data) {
            var str = "";
            var result = data.object;
            for (var i = 0;i<result.length;i++){
                str += "<div class=\"order-group\"><div class=\"order-group-item clearfix\"><div class=\"order-item-box\">"+
                    "<div class=\"media\"><a href=\"\" class=\"pull-left\">"+
                    "<img src=\"https://m.360buyimg.com/n12/jfs/t12352/88/127708421/67468/90baaf73/5a04172aN29f845bf.jpg!q70.jpg\" class=\"media-object order-item-img\">"+
                    "</a><div class=\"media-body\"><div class=\"order-item-info\">"+
                    "<h5 class=\"order-item-title\">"+data.object[i].productName+"</h5>"+
                    "<p class=\"order-item-fare\">可送范围："+data.object[i].sendRange+"</p><div class=\"pull-right text-right order-item-r\">"+
                    "<p class=\"order-item-prince\">￥"+data.object[i].price+"</p><p class=\"order-item-length\">x "+data.object[i].productNum+"</p></div></div></div></div></div>"+
                    "<div class=\"order-item-btn pull-right\"><button class=\"btn btn-sm btn-default\">限时商品</button>"+
                    "<button class=\"btn btn-sm btn-primary theme-bdcolor theme-bgcolor\">首页展示</button></div></div>"+
                    "<HR align=center width=300 color=#987cb9 SIZE=1 style=\"width: 100%;margin-bottom: 20px;margin-top: 1px\"></div>";
            }
            $("#goods_all").append(str);
        }
    })
}

// 获取首页展商品
function getIndexGoods() {
    checkLogin();
    // 每次点击时先清空
    $("#goods_index").html("");
    var url = "/product/getList";
    $.ajax({
        type: "POST",
        url: url,
        data: {"productStatus" : 1},
        success: function (data) {
            var str = "";
            var result = data.object;
            for (var i = 0;i<result.length;i++){
                str += "<div class=\"order-group\"><div class=\"order-group-item clearfix\"><div class=\"order-item-box\">"+
                    "<div class=\"media\"><a href=\"\" class=\"pull-left\">"+
                    "<img src=\"https://m.360buyimg.com/n12/jfs/t12352/88/127708421/67468/90baaf73/5a04172aN29f845bf.jpg!q70.jpg\" class=\"media-object order-item-img\">"+
                    "</a><div class=\"media-body\"><div class=\"order-item-info\">"+
                    "<h5 class=\"order-item-title\">"+data.object[i].productName+"</h5>"+
                    "<p class=\"order-item-fare\">可送范围："+data.object[i].sendRange+"</p><div class=\"pull-right text-right order-item-r\">"+
                    "<p class=\"order-item-prince\">￥"+data.object[i].price+"</p><p class=\"order-item-length\">x "+data.object[i].productNum+"</p></div></div></div></div></div>"+
                    "<div class=\"order-item-btn pull-right\"><button class=\"btn btn-sm btn-default\">限时商品</button>"+
                    "<button class=\"btn btn-sm btn-primary theme-bdcolor theme-bgcolor\">首页展示</button></div></div>"+
                    "<HR align=center width=300 color=#987cb9 SIZE=1 style=\"width: 100%;margin-bottom: 20px;margin-top: 1px\"></div>";
            }
            $("#goods_index").append(str);
        }
    })
}

// 获取限时商品
function getTimeGoods() {
    checkLogin();

    // 每次点击时先清空
    $("#goods_time").html("");
    var url = "/product/getList";
    $.ajax({
        type: "POST",
        url: url,
        data: {"timeStatus" : 1},
        success: function (data) {
            var str = "";
            var result = data.object;
            for (var i = 0;i<result.length;i++){
                str += "<div class=\"order-group\"><div class=\"order-group-item clearfix\"><div class=\"order-item-box\">"+
                    "<div class=\"media\"><a href=\"\" class=\"pull-left\">"+
                    "<img src=\"https://m.360buyimg.com/n12/jfs/t12352/88/127708421/67468/90baaf73/5a04172aN29f845bf.jpg!q70.jpg\" class=\"media-object order-item-img\">"+
                    "</a><div class=\"media-body\"><div class=\"order-item-info\">"+
                    "<h5 class=\"order-item-title\">"+data.object[i].productName+"</h5>"+
                    "<p class=\"order-item-fare\">可送范围："+data.object[i].sendRange+"</p><div class=\"pull-right text-right order-item-r\">"+
                    "<p class=\"order-item-prince\">￥"+data.object[i].price+"</p><p class=\"order-item-length\">x "+data.object[i].productNum+"</p></div></div></div></div></div>"+
                    "<div class=\"order-item-btn pull-right\"><button class=\"btn btn-sm btn-default\">限时商品</button>"+
                    "<button class=\"btn btn-sm btn-primary theme-bdcolor theme-bgcolor\">首页展示</button></div></div>"+
                    "<HR align=center width=300 color=#987cb9 SIZE=1 style=\"width: 100%;margin-bottom: 20px;margin-top: 1px\"></div>";
            }
            $("#goods_time").append(str);
        }
    })
}

// 获取已上架商品
function getUseGoods() {
    checkLogin();

    // 每次点击时先清空
    $("#goods_use").html("");
    var url = "/product/getList";
    $.ajax({
        type: "POST",
        url: url,
        data: {"isUse" : 1},
        success: function (data) {
            var str = "";
            var result = data.object;
            for (var i = 0;i<result.length;i++){
                str += "<div class=\"order-group\"><div class=\"order-group-item clearfix\"><div class=\"order-item-box\">"+
                    "<div class=\"media\"><a href=\"\" class=\"pull-left\">"+
                    "<img src=\"https://m.360buyimg.com/n12/jfs/t12352/88/127708421/67468/90baaf73/5a04172aN29f845bf.jpg!q70.jpg\" class=\"media-object order-item-img\">"+
                    "</a><div class=\"media-body\"><div class=\"order-item-info\">"+
                    "<h5 class=\"order-item-title\">"+data.object[i].productName+"</h5>"+
                    "<p class=\"order-item-fare\">可送范围："+data.object[i].sendRange+"</p><div class=\"pull-right text-right order-item-r\">"+
                    "<p class=\"order-item-prince\">￥"+data.object[i].price+"</p><p class=\"order-item-length\">x "+data.object[i].productNum+"</p></div></div></div></div></div>"+
                    "<div class=\"order-item-btn pull-right\"><button class=\"btn btn-sm btn-default\">限时商品</button>"+
                    "<button class=\"btn btn-sm btn-primary theme-bdcolor theme-bgcolor\">首页展示</button></div></div>"+
                    "<HR align=center width=300 color=#987cb9 SIZE=1 style=\"width: 100%;margin-bottom: 20px;margin-top: 1px\"></div>";
            }
            $("#goods_use").append(str);
        }
    })
}

// 获取未上架商品
function getNoUseGoods() {
    checkLogin();

    // 每次点击时先清空
    $("#goods_nouse").html("");
    var url = "/product/getList";
    $.ajax({
        type: "POST",
        url: url,
        data: {"isUse" : -1},
        success: function (data) {
            var str = "";
            var result = data.object;
            for (var i = 0;i<result.length;i++){
                str += "<div class=\"order-group\"><div class=\"order-group-item clearfix\"><div class=\"order-item-box\">"+
                    "<div class=\"media\"><a href=\"\" class=\"pull-left\">"+
                    "<img src=\"https://m.360buyimg.com/n12/jfs/t12352/88/127708421/67468/90baaf73/5a04172aN29f845bf.jpg!q70.jpg\" class=\"media-object order-item-img\">"+
                    "</a><div class=\"media-body\"><div class=\"order-item-info\">"+
                    "<h5 class=\"order-item-title\">"+data.object[i].productName+"</h5>"+
                    "<p class=\"order-item-fare\">可送范围："+data.object[i].sendRange+"</p><div class=\"pull-right text-right order-item-r\">"+
                    "<p class=\"order-item-prince\">￥"+data.object[i].price+"</p><p class=\"order-item-length\">x "+data.object[i].productNum+"</p></div></div></div></div></div>"+
                    "<div class=\"order-item-btn pull-right\"><button class=\"btn btn-sm btn-default\">限时商品</button>"+
                    "<button class=\"btn btn-sm btn-primary theme-bdcolor theme-bgcolor\">首页展示</button></div></div>"+
                    "<HR align=center width=300 color=#987cb9 SIZE=1 style=\"width: 100%;margin-bottom: 20px;margin-top: 1px\"></div>";
            }
            $("#goods_nouse").append(str);
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