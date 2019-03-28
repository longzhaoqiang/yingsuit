$(function () {

})

function loginout() {
    var url = "/yingsu/user/loginout"
    $.ajax({
        type: "POST",
        url: url,
        success: function (data) {
            var code = data.resultCode;
            window.location.href="/";
        }
    })
}