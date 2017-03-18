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
    <nav class="top-nav teal">
        <div class="container">
            <div class="nav-wrapper"><a class="page-title">会员账户</a></div>
        </div>
    </nav>
    <%@ include file="../common/user-nav.jsp" %>

</header>

<main>
    <div class="container" style="min-height: 500px;">
        <div class="row vip_form">
            <div class="col s12 m12">
                <div class="card white">
                    <div class="card-content blue-grey-text text-darken-1">
                        <span class="card-title blue-grey-text text-darken-2" style="font-size: 30px;">申请会员卡</span>
                    </div>
                    <div class="divider"></div>
                    <div class="card-content">
                        <p>注册为普通会员能在此平台订购房间，且需一次性充值1000元以上进行激活，因平台不支持第三方支付，故不办理会员卡不能进行房间预定，银卡和金卡会员更能享受最低9折订房优惠，欢迎办理。</p></div>
                    <%--<div class="card-content row">--%>
                    <%--<div class="input-field col s6">--%>
                    <%--<input id="bank_card" type="text">--%>
                    <%--<label for="bank_card">银行卡账号</label>--%>
                    <%--</div>--%>
                    <%--<div class="input-field col s6">--%>
                    <%--<input id="balance" type="text" placeholder="1000元以上才能">--%>
                    <%--<label for="balance">开卡充值金额</label>--%>
                    <%--</div>--%>
                    <%--</div>--%>

                    <div class="card-action">
                        <a href="#" class="btn teal waves-effect waves-light">申请开办</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%--<%@ include file="../common/footer.jsp" %>--%>
</main>

<!--  Scripts-->
<script src="/js/jquery.min.js"></script>
<script src="/js/materialize.js"></script>
<script src="/js/init.js"></script>
</body>
</html>
