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
<div>
    <label for="password">验证码</label>
    <input type="text" class="form-control" id="captcha" placeholder="验证码"><img id="captcha_img" style="cursor:pointer" src="captcha.png">
</div>
<p style="text-align: right;color: #000000;position: absolute" id="info"></p></br>
<button id="loginButton" class="btn btn-primary btn-block">登录</button>
<%--写ajax--%>
<script>
    $(document).ready(function () {
        $("#loginButton").click(function () {
            var username = $("#username").val();
            var password = $("#password").val();
            var thecaptcha = $("#captcha").val();
            $.ajax({
                type: "post",
                url: "/ajaxlogin",
                /*要传给后端的数据*/
                data: {
                    username: username,
                    password: password,
                    captcha: thecaptcha
                },
                dataType: "json",
                success: function (data) {
                    if (data.stateCode.trim() === "0") {
                        $("#info").text("账号或密码不对!")
                    } else if (data.stateCode.trim() === "1") {
                        $("#info").text("正在登录...");
                        window.location.href = "/successlogin";
                    }else if (data.stateCode.trim()==="-1"){
                        $("#info").text("验证码不对!")
                    }
                }
            });

        })
    });
</script>
</body>
</html>
