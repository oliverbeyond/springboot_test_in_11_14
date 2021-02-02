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
    <label for="username">手机号</label>
    <input type="text" class="form-control" id="username" placeholder="账号">
    <button id="sendcaptcha">点击发送验证码</button>
</div>
<div>
    <label for="password">密码</label>
    <input type="password" class="form-control" id="password" placeholder="密码">
</div>
<div>
    <label for="captcha">验证码</label>
    <input type="text" class="form-control" id="captcha" placeholder="验证码">
</div>
<p style="text-align: right;color: #000000;position: absolute" id="info"></p></br>
<button id="registerSubmitButton" class="btn btn-primary btn-block">提交</button>

<%--写ajax--%>
<script>
    $(document).ready(function () {
        $("#registerSubmitButton").click(function () {
            var username = $("#username").val();
            var password = $("#password").val();
            var captcha = $("#captcha").val();
            $.ajax({
                type: "post",
                url: "/ajaxregister",
                /*要传给后端的数据*/
                data: {
                    username: username,
                    password: password,
                    captcha: captcha
                },
                dataType: "json",
                success: function (data) {
                    if (data.stateCode.trim() === "0") {
                        $("#info").text("该手机号已被注册了!")
                    } else if (data.stateCode.trim() === "1") {
                        $("#info").text("正在注册...");
                        window.location.href = "/quit";
                    } else if (data.stateCode.trim() === "-1") {
                        $("#info").text("验证码错误,请30秒后重试")
                    }
                }
            });
        })
        $("#sendcaptcha").click(function () {
            var username = $("#username").val();
            $.ajax({
                type: "post",
                url: "/sendcaptcha",
                /*要传给后端的数据*/
                data: {
                    username: username,
                },
                dataType: "json",
                success: function (data) {
                    if (data.stateCode.trim() === "1") {
                        alert("发送验证码成功!");
                    }else if (data.stateCode.trim() === "-1") {
                        alert("手机号位数不对,11位!");
                    }
                }
            })
        })
    });
</script>
</body>
</html>
