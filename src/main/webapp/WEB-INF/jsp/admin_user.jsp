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
<table border="1">
    <tr>
        <thead>
        <td>用户id</td>
        <td>用户名</td>
        <td>用户权限</td>
        </thead>
    </tr>
    <c:forEach items="${user}" var="user">
        <tr>
            <td>${user.userid}</td>
            <td>${user.username}</td>
            <td>${user.roleid}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
