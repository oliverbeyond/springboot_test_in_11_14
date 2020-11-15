<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书馆</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/js.cookie.js"></script>
</head>
<body>
<h3>${msg},您好</h3>
<%--这些都是请求,不转jsp页面--%>
<p><a href="/book">查看图书</a></p>
<p><a href="/user">查看用户</a></p>
<p><a href="/quit">退出登录</a></p>
</body>
</html>
