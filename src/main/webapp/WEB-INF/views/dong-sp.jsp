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
        }

        table, th, td {
            border: 1px solid #ddd;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
        }

        .form-control {
            height: 40px;
            width: 100%;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="left-panel">
        <p style="font-size: 24px; font-weight: bold; color: #007bff; margin: 10px 0;">DÒNG SẢN PHẨM</p>
        <form:form method="post" action="/dong-sp/add" modelAttribute="dong-sp">
            <div class="form-label">Id DSP:</div>
            <form:input path="id" class="form-control" style="height: 40px"/><br/>

            <div>
                <div class="form-label">Mã DSP:</div>
                <form:input path="ma" class="form-control" style="height: 40px"/><br/>
                <form:errors path="ma" cssStyle="color: #b36605"/>
            </div>
            <div>
                <label class="form-label">Tên DSP:</label><br/>
                <form:input path="ten" class="form-control" style="height: 40px"/><br/>
                <form:errors path="ten" cssStyle="color: #b36605"/>
            </div>
            <button type="submit">Lưu</button>
        </form:form>
    </div>
    <div class="right-panel">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã DSP</th>
                <th scope="col">Tên DSP</th>
                <th scope="col">Action</th>
                <th scope="col">Action</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="dongSp">
                <tr>
                    <td>${dongSp.ma}</td>
                    <td>${dongSp.ten}</td>
                    <td><a class="btn btn-primary" href="/dong-sp/delete/${dongSp.id}">Delete</a></td>
                    <td><a class="btn btn-primary" href="/dong-sp/detail/${dongSp.id}">Detail</a></td>
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