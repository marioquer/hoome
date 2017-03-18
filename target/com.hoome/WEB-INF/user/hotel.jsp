<%@ page import="entity.User" %>
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
            <div class="nav-wrapper"><a class="page-title">所有房源</a></div>
        </div>
    </nav>
    <%@ include file="../common/user-nav.jsp" %>

</header>

<main>
    <div class="container" style="min-height: 500px;">
        <%
            User user = (User)session.getAttribute("user");
            if (user.getIsVip()==0){
        %>
        <div class="row margin-top-20 new">
            <div class="col s12 m12">
                <div class="card-panel blue-grey">
          <span class="white-text">您还没有开设会员卡，无法查看房间，点击申请按钮立即发出会员卡申请！
          </span>
                </div>
            </div>
            <a class="margin-left-10 waves-effect waves-light btn teal" href="/user/account">申请会员卡</a>
        </div>
        <%
            }else{
        %>
        <div class=""></div>
        <%
            }
        %>


    </div>
    <%--<%@ include file="../common/footer.jsp" %>--%>
</main>

<!--  Scripts-->
<script src="/js/jquery.min.js"></script>
<script src="/js/materialize.js"></script>
<script src="/js/init.js"></script>
</body>
</html>
