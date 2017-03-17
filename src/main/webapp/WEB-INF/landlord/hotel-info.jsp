<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <title>Welcome to Hoome!!!</title>
    <!-- CSS  -->
    <link href="/css/materialize.css" type="text/css" rel="stylesheet"
          media="screen,projection"/>
    <link href="/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="/css/common.css" type="text/css" rel="stylesheet">
</head>
<body>

<header>
    <nav class="top-nav blue">
        <div class="container">
            <div class="nav-wrapper"><a class="page-title">客栈信息</a></div>
        </div>
    </nav>
    <%@ include file="../common/landlord-nav.jsp" %>

</header>

<main>
    <div class="container" style="min-height: 500px;">
        <div class="row margin-top-20 new">
            <div class="col s12 m12">
                <div class="card-panel blue-grey">
          <span class="white-text">您还没有开设您的客栈，点击申请按钮立即发出开店申请！
          </span>
                </div>
            </div>

            <a class="margin-left-10 waves-effect waves-light btn blue" href="#create">开店申请</a>
        </div>

        <div class="row apply">
            <div class="col s12 m12">
                <div class="card blue-grey darken-1">
                    <div class="card-content white-text">
                        <span class="card-title" style="font-size: 30px;">老王客栈</span>
                    </div>
                    <div class="divider blue-grey lighten-2"></div>
                    <div class="card-content white-text">
                       <p>申请还未通过，请耐心等待</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="row hotel">
            <div class="col s12 m12">
                <div class="card white">
                    <div class="card-content blue-grey-text text-darken-1">
                        <span class="card-title blue-grey-text text-darken-2" style="font-size: 30px;">老王客栈</span>
                        <div class="margin-top-10" style="float: right">
                            <i class="material-icons">room</i><span class="margin-left-5">南京大学</span>
                            <i class="material-icons margin-left-20">contact_phone</i><span class="margin-left-5">15615161717</span></div>
                    </div>
                    <div class="divider"></div>
                    <div class="card-content blue-grey-text text-darken-1">
                        <p>我的介绍啊啊啊啊啊超级长的啊啊啊啊啊</p>
                    </div>
                    <div class="card-action">
                        <a href="#" class="btn blue waves-effect waves-light">修改客栈信息</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="row room">
            <div class="col s12 m6">
                <div class="card">
                    <div class="card-image">
                        <img src="/image/background.jpg">
                        <span class="card-title">单人房</span>
                        <span class="card-price">￥228</span>
                    </div>
                    <div class="card-content blue-grey-text text-darken-1">
                        <p>单人房能够容纳1-2人入住，极致体验</p>
                    </div>
                    <div class="card-action">
                        <a href="#" class="btn blue waves-effect waves-light">修改房型信息</a>
                    </div>
                </div>
            </div>
            <div class="col s12 m6">
                <div class="card">
                    <div class="card-image">
                        <img src="/image/background.jpg">
                        <span class="card-title">双人房</span>
                        <span class="card-price">￥268</span>
                    </div>
                    <div class="card-content blue-grey-text text-darken-1">
                        <p>双人房为标准房，内设两张小床</p>
                    </div>
                    <div class="card-action">
                        <a href="#" class="btn blue waves-effect waves-light">修改房型信息</a>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <%--<%@ include file="../common/footer.jsp" %>--%>
</main>

<div id="create" class="modal" style="width: 500px;overflow:visible;">
    <div class="modal-content">
        <div class="row">
            <div class="input-field col s6">
                <input id="name" type="text">
                <label for="name">客栈名称</label>
            </div>
            <div class="input-field col s6">
                <input id="phone" type="text">
                <label for="phone">联系电话</label>
            </div>
            <div class="input-field col s6">
                <input id="big_num" type="text">
                <label for="big_num">单人间数目</label>
            </div>
            <div class="input-field col s6">
                <input id="small_num" type="text">
                <label for="small_num">双人间数目</label>
            </div>
            <div class="input-field col s6">
                <input id="big_price" type="text">
                <label for="big_price">单人间价格(元)</label>
            </div>
            <div class="input-field col s6">
                <input id="small_price" type="text">
                <label for="small_price">双人间数目(元)</label>
            </div>
            <div class="input-field col s12">
                <input id="address" type="text">
                <label for="address">详细地址</label>
            </div>
            <div class="input-field col s12">
                <textarea id="introduction" class="materialize-textarea"></textarea>
                <label for="introduction">客栈简介</label>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <a onclick="apply(${sessionScope.get("user").getId()})" href=""
           class=" modal-action waves-effect waves-blue btn blue">提交申请</a>
        <a href="" class="modal-action modal-close waves-effect waves-grey btn-flat">取消</a>
    </div>
</div>

<!--  Scripts-->
<script src="/js/jquery.min.js"></script>
<script src="/js/materialize.js"></script>
<script src="/js/init.js"></script>
<script src="/js/landlord-hotel-info.js"></script>
<script>
    var id = ${sessionScope.get("user").getId()};

    $.ajax({
        method: "post",
        url: "/landlord/myHotel",
        async: false,
        dataType: "json",
        data: {
            "id": id
        },
        success: function (result) {
            switch (result.state) {
                case "approved":
                    //add data

                    $(".hotel").css("display","block");
                    $(".room").css("display","block");
                    $(".new").css("display","none");
                    break;
                case "suspend":
                    //add data

                    $(".apply").css("display","block");
                    $(".new").css("display","none");
                    break;
            }
        },
        error: function () {
            Materialize.toast('请求出错!', 1200);
        }
    });
</script>
</body>
</html>
