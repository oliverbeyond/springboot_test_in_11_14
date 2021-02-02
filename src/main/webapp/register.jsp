<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书馆登录</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/js.cookie.js"></script>
</head>
<body>
<%--写登录面板--%>
<div>
    <label for="username">账号</label>
    <input type="text" class="form-control" id="username" placeholder="账号">
</div>
<div>
    <label for="password">密码</label>
    <input type="password" class="form-control" id="password" placeholder="密码">
</div>
<p style="text-align: right;color: #000000;position: absolute" id="info"></p></br>
<button id="registerSubmitButton" class="btn btn-primary btn-block">提交</button>
<button id="phoneregister" class="btn btn-primary btn-block">手机号注册</button>

<%--写ajax--%>
<script>


    $(document).ready(function () {
        $("#registerSubmitButton").click(function () {
            var username = $("#username").val();
            var password = $("#password").val();
            $.ajax({
                type: "post",
                url: "/ajaxregister",
                /*要传给后端的数据*/
                data: {
                    username: username,
                    password: password
                },
                dataType: "json",
                success: function (data) {
                    if (data.stateCode.trim() === "0") {
                        $("#info").text("该账号有人注册了!")
                    } else if (data.stateCode.trim() === "1") {
                        $("#info").text("正在注册...");
                        window.location.href = "/quit";
                    } else if (data.stateCode.trim() === "-1") {
                        $("#info").text("密码格式不对,长度8-18位,包含数字和字母!")
                    }
                }
            });

        })

        /*手机号注册ajax方式*/
        $("#phoneregister").click(function () {
            window.location.href = "/phoneregister";
        })
    });


</script>
</body>
</html>
