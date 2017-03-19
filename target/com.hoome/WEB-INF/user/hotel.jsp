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
            User user = (User) session.getAttribute("user");
            if (user.getIsVip() != (byte) 2) {
        %>
        <div class="row margin-top-20 new">
            <div class="col s12 m12">
                <div class="card-panel blue-grey">
          <span class="white-text">您还没有开设会员卡或还未生效，无法查看房间，点击按钮查看您的会员卡！
          </span>
                </div>
            </div>
            <a class="margin-left-10 waves-effect waves-light btn teal" href="/user/account">立即查看</a>
        </div>
        <%
        } else {
        %>
        <div class="row">
            <div class="col s12 m12">
                <div class="card white">
                    <div class="card-content row">
                        <div class="input-field col s4">
                            <input type="date" class="datepicker" id="begin_time">
                            <label for="begin_time">开始日期</label>
                        </div>
                        <div class="input-field col s4">
                            <input type="date" class="datepicker" id="end_time">
                            <label for="end_time">结束日期</label>
                        </div>
                        <div class="input-field col s4">
                            <select id="room_style">
                                <option value="" disabled selected>选择房型</option>
                                <option value="0">单人房</option>
                                <option value="1">双人房</option>
                            </select>
                            <label>房间类型</label>
                        </div>

                    </div>
                    <div class="card-action">
                        <a onclick="searchRooms()"
                           class="btn teal waves-effect waves-light">查找房间</a>
                    </div>
                </div>
            </div>
        </div>
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
<script>
    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 17, // Creates a dropdown of 15 years to control year
        format: 'yyyy-mm-dd'
    });


    function searchRooms() {
        var beginTime = $("#begin_time").val();
        var endTime = $("#end_time").val();
        var roomType = $("#room_style");

        if (beginTime == "" || endTime == "" || roomType == "") {
            Materialize.toast("请输入完整信息！", 1200);
        } else {
            $.ajax({
                method: "post",
                url: "/user/getMyVip",
                async: false,
                dataType: "json",
                data: {
                    "id": id,
                },
                success: function (result) {
                    var moneyHtml = $("#money_record_pattern").html();
                    var pointHtml = $("#point_record_pattern").html();
                    var vipRecordsList = result.vipRecords;
                    var pointRecordsList = result.point;

                    var vipCard = result.vipCard;
                    var idString = vipCard.id.toString();
                    var idLength = idString.length;
                    for (var i = 0; i < (7 - idLength); i++) {
                        idString = "0" + idString;
                    }

                    //all topUp record
                    for (var i = 0; i < vipRecordsList.length; i++) {
                        var li = document.createElement("li");
                        li.className = "collection-item blue-grey-text text-darken-1";
                        li.innerHTML = moneyHtml;
                        li.getElementsByClassName("money-balance-record")[0].innerHTML = vipRecordsList[i].balance;
                        li.getElementsByClassName("in-out")[0].innerHTML = vipRecordsList[i].inOut > 0 ? ("+" + vipRecordsList[i].inOut) : vipRecordsList[i].inOut;
                        if (vipRecordsList[i].type == 1)
                            li.getElementsByClassName("in-out-type")[0].innerHTML = "积分兑换";
                        $("#money_balance_container").append(li);
                    }
                },
                error: function () {
                    Materialize.toast('请求出错!', 1200);
                }
            });

        }

    }


</script>
</body>
</html>
