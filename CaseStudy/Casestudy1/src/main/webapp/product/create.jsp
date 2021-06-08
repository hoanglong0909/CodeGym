<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>User Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <style>
        body{
            margin: auto 20%;
        }
        .submit{
            padding-left: 100px;
            border-left-width: 22px;
            margin-left: 260px;
            padding-right: 100px;
            margin-right: 0px;
        }
    </style>
</head>
<body>
<center>
    <h1>Thêm mới sản phẩm</h1>
    <h2>
         <a href="${sessionScope.account.isAdmin == 1 ? "electronics?action=listProduct" :"managers"}"><button type="submit" class="btn btn-primary">Quay trở lại kho hàng</button></a>
    </h2>


</center>
<p class="alert alert-success">${mess}</p>
<div style="">
<%--    style="width: 500px ;height: 1000px ;"--%>
    <div >
        <form class="row g-3" method="post">
            <div class="col-12">
                <label for="inputName" class="form-label">Tên sản phẩm</label>
                <input name="name" type="text" class="form-control" id="inputName" placeholder="name">
            </div>
            <div class="col-12">
                <label for="inputImage" class="form-label">Ảnh</label>
                <input name="image" type="text" class="form-control" id="inputImage" placeholder="image">
            </div>
            <div class="col-12">
                <label for="inputPrice" class="form-label">Giá sản phẩm</label>
                <input name="price" type="text" class="form-control" id="inputPrice" placeholder="Nhập giá">
            </div>
            <div class="col-md-12">
                <label class="form-label">Loại sản phẩm</label>
                <select name="category"  id="inputCategory" class="form-select">
                    <c:forEach items="${categoryList}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
            </div>
<%--            <div class="col-12">--%>
<%--                <label for="input id" class="form-label">id người bán hàng</label>--%>
<%--                <input name="sell_id" type="text" class="form-control" id="input id" placeholder="Nhập id người bán hàng">--%>
<%--            </div>--%>
            <div class="col-12 submit">
                <button type="submit" class="btn btn-success">Thêm sản phẩm</button>
            </div>
        </form>
    </div>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
        integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
        crossorigin="anonymous"></script>
</html>