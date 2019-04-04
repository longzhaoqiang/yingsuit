// 轮播
$(function () {
    var bussId = $("#bussId").val();
    // 顶部轮播图
    var mySwiper = new Swiper ('.swiper-container', {
        // 如果需要分页器
        autoplay:true,
        pagination: {
            el: '.swiper-pagination'
        }
    });

    // 加载限时商品
    timeGoods(bussId);
    // 加载首页商品
    indexGoods(bussId);

    // 秒杀商品滑动
    var swiper = new Swiper('.seckill-wares', {
        slidesPerView: 3.5,
        spaceBetween: 5,
        freeMode: true
    });
    // 新闻资讯
    var swiper2 = new Swiper('.infoBox', {
        autoplay:true,
        delay: 5000,
        direction: 'vertical'
    });

    // 请求后台查看是否登录,如果没有登录则隐藏footer目录
    var url = "/index_1"
    $.ajax({
        type: "POST",
        url: url,
        success: function (data) {
            var code = data.resultCode;
            var msg = data.resultMsg;
            if (code == "1"){
                $("#isLogin").html(msg);
            }
        }
    })
})

// 我的
function home() {
    var url = "/index_1"
    $.ajax({
        type: "POST",
        url: url,
        success: function (data) {
            var code = data.resultCode;
            if (code == "-1"){
                window.location.href="/yingsu/user/login";
            } else {
                window.location.href="/home";
            }
        }
    })
}

// 加载限时商品
function timeGoods(bussId) {
    // 每次点击时先清空
    $("#goods_time").html("");
    var url = "/product/getList";
    $.ajax({
        type: "POST",
        url: url,
        data: {"timeStatus":1,"bussId":bussId},
        success: function (data) {
            var str = "";
            var result = data.object;
            for (var i = 0;i<result.length;i++){
                str += "<div class='swiper-slide seckill-ware' style='width: 35%'><a href='item.html'>" +
                    "<img src='https://m.360buyimg.com/n1/jfs/t15787/353/109633918/16701/5a8390ef/5a27ae6dNc530b5bb.jpg!q70.jpg'>" +
                    "<p class='red-color'>￥<strong>"+data.object[i].price+"</strong></p><del>￥12000.00</del></a></div>";
            }
            $("#goods_time").append(str);
        }
    })
}

// 加载首页商品
function indexGoods(bussId) {
    // 每次点击时先清空
    $("#index_goods").html("");
    var url = "/product/getList";
    $.ajax({
        type: "POST",
        url: url,
        data: {"productStatus":1,"bussId":bussId},
        success: function (data) {
            var str = "";
            var result = data.object;
            for (var i = 0;i<result.length;i++){
                str += "<li class='col-sm-6 col-xs-6 ware-box'>" +
                    "                    <a href='/item'>" +
                    "                        <div class='ware-img'>" +
                    "                            <img src='https://m.360buyimg.com/n1/jfs/t15787/353/109633918/16701/5a8390ef/5a27ae6dNc530b5bb.jpg!q70.jpg'>" +
                    "                            <span class='ware-vip'>vip专享</span>" +
                    "                        </div>" +
                    "                        <h3 class='ware-title'>"+data.object[i].productName+"</h3>" +
                    "                        <p class='ware-des'>英速网发布</p>" +
                    "                        <span class='ware-prince red-color'>￥"+data.object[i].price+"</span>" +
                    "                    </a>" +
                    "                </li>";
            }
            $("#index_goods").append(str);
        }
    })
}