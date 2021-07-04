<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/electronics?action=create">Add New User</a>
    </h2>
    <form method="get" action="electronics">
        <input type="hidden" name="action" value="search"/>
        <input type="text" name="search" placeholder="Enter country"/>
        <input type="submit" value="Search"/>
    </form>
    <%--    <form method="get" action="users">--%>
    <%--        <input type="hidden" name="action" value="sort"/>--%>
    <%--        <input type="submit" name="sort" value="Sort User">--%>
    <%--    </form>--%>
</center>
<div align="center">
    <table class="table">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>image</th>
            <th>price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${electronicList}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.image}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td>
                    <a href="/electronics?action=edit&id=${user.id}">Edit</a>
                    <a href="/electronics?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</html>