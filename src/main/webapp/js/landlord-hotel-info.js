/**
 * Created by marioquer on 2017/3/17.
 */
function apply(id){
    var name = $("#name").val();
    var small_num = $("#small_num").val();
    var big_num = $("#big_num").val();
    var address = $("#address").val();
    var introduction = $("#introduction").val();
    var phone = $("#phone").val();
    var big_price = $("#big_price").val();
    var small_price = $("#small_price").val();

    $.ajax({
        method: "post",
        url: "/landlord/create",
        async: false,
        data: {
            "phone": phone,
            "name": name,
            "small_num": small_num,
            "big_num": big_num,
            "address":address,
            "introduction":introduction,
            "big_price":big_price,
            "small_price":small_price
        },
        success: function (result) {
            if (result == "success") {
                Materialize.toast('申请成功!', 1800);
                setInterval((function () {
                    window.location.reload();
                }()),1800);
            } else {
                Materialize.toast('操作失败!', 1200);
            }
        },
        error: function () {
            Materialize.toast('请求出错!', 1200);
        }
    });
}