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
        <td>编号</td>
        <td>书名</td>
        <td>作者</td>
        <td>路径</td>
        <td>剩余</td>
        <td>操作</td>
        </thead>
    </tr>
    <c:forEach items="${book}" var="book">
        <tr>
            <td>${book.bookid}</td>
            <td>${book.bookname}</td>
            <td>${book.writer}</td>
            <td>${book.path}</td>
            <td>${book.num}</td>
            <td><a href="/editbook?bookid=${book.bookid}">修改</a>
                <a href="/deletebook">删除</a></td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
