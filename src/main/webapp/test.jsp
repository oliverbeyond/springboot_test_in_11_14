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
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span2">
        </div>
        <div class="span6">
            <h1>
                图书馆系统
            </h1>
            <form class="form-horizontal">
                <div class="control-group">
                    <label class="control-label" for="inputEmail">邮箱</label>
                    <div class="controls">
                        <input id="inputEmail" type="text" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputPassword">密码</label>
                    <div class="controls">
                        <input id="inputPassword" type="password" />
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <label class="checkbox"><input type="checkbox" /> Remember me</label> <button type="submit" class="btn">登陆</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="span4">
        </div>
    </div>
</div>
</body>
</html>