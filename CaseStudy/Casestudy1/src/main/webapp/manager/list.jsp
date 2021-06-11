<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link href="../body/css/sweetalert2.min.css">
</head>
<center>
    <h1 style="padding-bottom: 100px">Kho quản lý sản phẩm của: ${sessionScope.account.userName}</h1>
    <div align="center">
        <table class="table">
            <thead class="table-primary">
            <tr>
                <th><a href="electronics"><button type="button" class="btn btn-primary" ><h4>Trở về trang chủ</h4></button></a></th>
                <th></th>
                <th>
                </th>
                <th></th>
                <th><a href="/electronics?action=create"><button type="button" class="btn btn-success" ><h4>Add new com</h4></button></a></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>ID</th>
                <th>Tên sản phẩm</th>
                <th>Ảnh sản phẩm</th>
                <th>Giá sản phẩm</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="electronic" items="${elist}">
                <tr>
                    <td><c:out value="${electronic.id}"/></td>
                    <td><c:out value="${electronic.name}"/></td>
                    <td><img  class="img-circle" width="304" height="236" src="${electronic.image}" alt=""></td>
                    <td><c:out value="${electronic.price}"/> vnd</td>
                    <td>
                        <a href="/electronics?action=edit&id=${electronic.id}"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTm1wnBtIMKC_sDnu7EfA5ddRwT2AirWzVYqI57qD-A2EwsD9y--uiZd-OKw8TyHzObfg&usqp=CAU" style="height: 45px; width: 45px;"></a>
<%--                        <a href="/delete?action=delete&id=${electronic.id}"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTL_TeGQVJUJRdiSVIu4yHxlqqF7-Z1ikFM6A&usqp=CAU" style="width: 50px ; height: 50px"></a>--%>
                        <a><button type="button" onclick="deleteProduct(${electronic.id})"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTL_TeGQVJUJRdiSVIu4yHxlqqF7-Z1ikFM6A&usqp=CAU" style="width: 50px ; height: 50px"></button></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <script>
        function deleteProduct(id){
            Swal.fire({
                title: 'Are you sure?',
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href ='/delete?action=delete&id='+ id;
                    Swal.fire(
                        'Deleted!',
                        'Your file has been deleted.',
                        'success'
                    )
                }
            })
        }
    </script>
    <script src="../body/js/sweetalert2.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</html>