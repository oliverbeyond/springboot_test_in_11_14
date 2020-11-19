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
    <c:forEach items="${pages}" var="pages">
        <tr>
            <td>${pages.bookid}</td>
            <td>${pages.bookname}</td>
            <td>${pages.writer}</td>
            <td>${pages.path}</td>
            <td>${pages.num}</td>
            <td><a href="/editbook?bookid=${pages.bookid}">修改</a>
                <a href="/deletebook?bookid=${pages.bookid}">删除</a></td>

        </tr>
    </c:forEach>
</table>
<button id="previous">上一页</button>

<%--实现分页按钮的关键--%>
<c:forEach var="index" begin="1" end="${pagesnum}" step="1">
    <a id="pagecurrent" href="pages?pageNo=${index}&pagecurrent=${index}">${index}</a>
</c:forEach>

<button id="after">下一页</button>
<script>
    $(document).ready(function () {
        $("#previous").click(function () {
            if(${pagecurrent<=1}){
                alert("本页为第一页,不能去上一页");
            }
            window.location.href = "/pages?pageNo=${pagecurrent<=1?1:pagecurrent-1}&pagecurrent=${pagecurrent<=1?1:pagecurrent-1}";
        });
    })
    $(document).ready(function () {
        $("#after").click(function () {
            if(${pagecurrent==pagesnum}){
                alert("本页为最后一页,不能去下一页");
            }
            window.location.href = "/pages?pageNo=${pagecurrent==pagesnum?pagesnum:pagecurrent+1}&pagecurrent=${pagecurrent==pagesnum?pagesnum:pagecurrent+1}";
        });
    })

</script>
</body>
</html>
