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

        .form-container {
            float: left;
            width: 30%;
            padding: 20px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
        }

        .table-container {
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
    <div class="form-container">
        <p style="font-size: 24px; font-weight: bold; color: #007bff; margin: 10px 0;">CHỨC VỤ</p>
        <form:form method="post" action="/chuc-vu/add" modelAttribute="chuc-vu">
            <div class="form-label">Id Chức Vụ:</div>
            <form:input path="id" class="form-control" style="height: 40px"/><br/>

            <div>
                <div class="form-label">Mã Chức Vụ:</div>
                <form:input path="ma" class="form-control" style="height: 40px"/><br/>
                <form:errors path="ma" cssStyle="color: #b36605"/>
            </div>
            <div>
                <label class="form-label">Tên Chức Vụ:</label><br/>
                <form:input path="ten" class="form-control" style="height: 40px"/><br/>
                <form:errors path="ten" cssStyle="color: #b36605"/>
            </div>
            <button type="submit">Lưu</button>
        </form:form>
    </div>
    <div class="table-container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã Chức Vụ</th>
                <th scope="col">Tên Chức Vụ</th>
                <th scope="col">Action</th>
                <th scope="col">Action</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="chucVu">
                <tr>
                    <td>${chucVu.ma}</td>
                    <td>${chucVu.ten}</td>
                    <td><a class="btn btn-primary" href="/chuc-vu/delete/${chucVu.id}">Delete</a></td>
                    <td><a class="btn btn-primary" href="/chuc-vu/detail/${chucVu.id}">Detail</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>