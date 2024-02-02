<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"--%>
<%--          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="col-4 offset-4 mt-3" >--%>
<%--    <form:form method="post" action="/san-pham/add" modelAttribute="san-pham" enctype="multipart/form-data">--%>
<%--        <div class="form-label">Id Sản Phẩm:</div>--%>
<%--        <form:input path="id" class="form-control" style="height: 40px; width:400px;"/><br/>--%>

<%--        <div class="form-label">Mã Sản Phẩm:</div>--%>
<%--        <form:input path="ma" class="form-control" style="height: 40px; width:400px;"/><br/>--%>
<%--        <form:errors path="ma" cssStyle="color: #b36605"/>--%>
<%--        <div>--%>
<%--            <label class="form-label">Tên Sản Phẩm:</label><br/>--%>
<%--            <form:input path="ten" class="form-control" style="height: 40px; width:400px;"/><br/>--%>
<%--            <form:errors path="ten" cssStyle="color: #b36605"/>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <div class="form-label">Ảnh Sản Phẩm:</div>--%>
<%--            <input type="file" name="image" class="form-control" style="height: 40px; width:400px;"/><br/>--%>
<%--        </div>--%>
<%--        <button type="submit">Lưu</button>--%>
<%--    </form:form>--%>
<%--</div>--%>
<%--<table class="table">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th scope="col">Mã Sản Phẩm</th>--%>
<%--        <th scope="col">Tên Sản Phẩm</th>--%>
<%--&lt;%&ndash;        <th scope="col">Hình Ảnh</th> <!-- Thêm cột cho hình ảnh -->&ndash;%&gt;--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach items="${list}" var="cuaHang">--%>
<%--        <tr>--%>
<%--            <td>${cuaHang.ma}</td>--%>
<%--            <td>${cuaHang.ten}</td>--%>
<%--            <td>--%>
<%--                <!-- Hiển thị ảnh sản phẩm -->--%>
<%--&lt;%&ndash;                <img src="${cuaHang.images}" alt="Ảnh sản phẩm" width="100">&ndash;%&gt;--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <a class="btn btn-primary" href="/san-pham/delete/${cuaHang.id}">Delete</a>--%>
<%--                <a class="btn btn-primary" href="/san-pham/detail/${cuaHang.id}">Detail</a>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>

<%--</body>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"--%>
<%--        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"--%>
<%--        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--</html>--%>












<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body {
            background-color: #f2f2f2;
        }

        .container {
            margin: 20px;
        }

        .left-panel {
            float: left;
            width: 30%;
            padding: 20px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
        }

        .right-panel {
            float: left;
            width: 70%;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
        }

        table {
            width: 100%;
            background-color: #4ecbcb;
        }

        table, th, td {
            border: 1px solid #ddd;
            border-collapse: collapse;
        }
        th{
            background-color: blue;
        }
        th, td {
            padding: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="left-panel">
        <p style="font-size: 24px; font-weight: bold; color: #007bff; margin: 10px 0;">SẢN PHẨM</p>

        <form:form method="post" action="/san-pham/add" modelAttribute="san-pham" enctype="multipart/form-data">
            <div class="form-label">Id Sản Phẩm:</div>
            <form:input path="id" class="form-control" /><br/>

            <div class="form-label">Mã Sản Phẩm:</div>
            <form:input path="ma" class="form-control"/><br/>
            <form:errors path="ma" cssStyle="color: #b36605"/>

            <label class="form-label">Tên Sản Phẩm:</label><br/>
            <form:input path="ten" class="form-control" /><br/>
            <form:errors path="ten" cssStyle="color: #b36605"/>

            <div class="form-label">Ảnh Sản Phẩm:</div>
            <input type="file" name="image" class="form-control" style="height: 40px; width:200px;"/><br/>

            <button type="submit">Lưu</button>
        </form:form>
    </div>
    <div class="right-panel">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã Sản Phẩm</th>
                <th scope="col">Tên Sản Phẩm</th>
                <th scope="col">Action</th>
                <th scope="col">Action</th>

                <!-- Thêm các cột khác nếu cần -->
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="cuaHang">
                <tr>
                    <td>${cuaHang.ma}</td>
                    <td>${cuaHang.ten}</td>
                    <td><a class="btn btn-primary" href="/san-pham/delete/${cuaHang.id}">Delete</a></td>
                    <td><a class="btn btn-primary" href="/san-pham/detail/${cuaHang.id}">Detail</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>