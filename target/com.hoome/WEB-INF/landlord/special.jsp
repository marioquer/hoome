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
            <div class="nav-wrapper"><a class="page-title">发布优惠</a></div>
        </div>
    </nav>
    <%@ include file="../common/landlord-nav.jsp" %>

</header>

<main>
    <div class="container" style="min-height: 500px;">
        <div class="row">
            <div class="col s12 m12">
                <div class="card white">
                    <div class="card-content row">
                        <div class="input-field col s6">
                            <input id="new_small_price" type="text" placeholder="输入价格">
                            <label for="new_small_price">单人房特价</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="new_big_price" type="text" placeholder="输入价格">
                            <label for="new_big_price">双人房特价</label>
                        </div>
                        <div class="input-field col s12">
                            <input type="date" class="datepicker" id="expire_time">
                            <label for="expire_time">特价有效时间至</label>
                        </div>
                    </div>
                    <div class="card-action">
                        <a onclick="addSpecial(${sessionScope.get("user").getId()})"
                           class="btn teal waves-effect waves-light">立即发布</a>
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
<script>
    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 17, // Creates a dropdown of 15 years to control year
        format: 'yyyy-mm-dd'
    });

    function addSpecial(id) {
        var smallprice = $("#new_small_price").val();
        var bigprice = $("#new_big_price").val();
        var time = $("#expire_time").val();
        alert(time);

    }



</script>
</body>
</html>
