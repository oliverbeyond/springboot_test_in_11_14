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
<form action="/upbook" method="post" enctype="multipart/form-data">
    <div>
        <label for="bookname">书名</label>
        <input type="text" class="form-control" id="bookname" placeholder="书名" name="bookname">
    </div>
    <div>
        <label for="writer">作者</label>
        <input type="text" class="form-control" id="writer" placeholder="作者" name="writer">
    </div>
    <div>
        <label for="path">路径</label>
        <input type="text" class="form-control" id="path" placeholder="路径" name="path">
    </div>
    <div>
        <label for="num">数量</label>
        <input type="text" class="form-control" id="num" placeholder="数量" name="num">
    </div>
    <div>
        <label for="file">上传图片</label>
        <input type="file" class="form-control" id="file" placeholder="图片" name="file">
    </div>
    <input type="submit" value="form提交">
</form>
<button id="upbook">ajax提交</button>
<script>
    $(document).ready(function () {
        $("#upbook").click(function () {
            var bookname = $("#bookname").val();
            var writer = $("#writer").val();
            var path = $("#path").val();
            var num = $("#num").val();
/*
            var pic = $("#pic").val();
*/
            $.ajax({
                type: "post",
                url: "/upbook",
                /*要传给后端的数据*/
                data: {
                    bookname: bookname,
                    writer: writer,
                    path: path,
                    num: num
/*
                    pic: pic
*/
                },
                dataType: "json",
                success: function (data) {
                    if (data.stateCode.trim() === "1") {
                        window.location.href = "/pages?pageNo=1&pagecurrent=1";
                        alert("添加成功");
                    } else if (data.stateCode.trim() === "-1") {
                        alert("添加失败");
                        window.location.href = "/pages?pageNo=1&pagecurrent=1";
                    }
                }
            });
        })
    })
</script>
</body>
</html>
