$(function () {
    // 多图片上传
    initFileInput("input-id");
})

// 是否上传图片标记
var flag = false;
// 商品id
var productId = "";

// 多图片上传初始化
function initFileInput(ctrlName) {
    var control = $('#' + ctrlName);
    var url = "/fileUpload/head";
    control.fileinput({
        language: 'zh', //设置语言
        uploadUrl: url,
        allowedFileExtensions: ['tif','jpg','png','gif','bmp','txt','html','xml','pdf','doc','xls','ppt','docx','xlsx','pptx','zip','rar','mp3','mov','avi','mpp'],//接收的文件后缀
        maxFilesNum : 2,//上传最大的文件数量
        //uploadExtraData:function(previewId, index) { return extraParams; },
        uploadAsync: true, //默认异步上传
        showUpload: true, //是否显示上传按钮
        showRemove : true, //显示移除按钮
        showPreview : true, //是否显示预览
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        dropZoneEnabled: true,//是否显示拖拽区域
        //minImageWidth: 50, //图片的最小宽度
        //minImageHeight: 50,//图片的最小高度
        //maxImageWidth: 300,//图片的最大宽度
        //maxImageHeight: 200,//图片的最大高度
        maxFileSize: 200,//单位为kb，如果为0表示不限制文件大小
        // minFileCount: 0,
        maxFileCount: 5, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount:true,
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany: "最多只能上传5张照片，你上传了{n}张，请重新操作！",

    }).on('filepreupload', function(event, data, previewId, index) {     //上传中
        var form = data.form, files = data.files, extra = data.extra,
            response = data.response, reader = data.reader;
        console.log('图片正在上传');
    }).on("fileuploaded", function (event, data, previewId, index) {    //一个文件上传成功
        // 返回商品id
        productId = data.response.resultCode;
        $("#productId").val(productId);
        flag = true;
    }).on('fileerror', function(event, data, msg) {  //一个文件上传失败
        console.log('图片上传失败！'+data.id);
    })
}

// 保存提交
function commit() {
    var productId = $("#productId").val();
    var productName = $("#productName").val();
    var price = $("#price").val();
    var productNum = $("#productNum").val();
    var bussAddress = $("#bussAddress").val();
    if (!flag){
        alert("为了店面美观请上传图片！");
        return false;
    }
    if (productName == ""){
        alert("商品名称不能为空");
        return false;
    } else if (price == ""){
        alert("请输入价格");
        return false;
    } else if (productNum == ""){
        alert("库存不能为空");
        return false;
    } else if (bussAddress == ""){
        alert("请输入商家地址");
        return false;
    }
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/product/add" ,//url
        data: $('#productForm').serialize(),
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