<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Staff Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>Staff Management</h1>
    <h2>
        <a href="/staffs?action=create">Add New Staff</a>
    </h2>

        <form method="get" action="staffs">
            <input type="hidden" name="action" value="search"/>
            <input type="text" name="search" placeholder="Enter productName or id"/>
            <input type="submit" value="Search"/>
        </form>

</center>
<div align="center">
    <table class="table">
        <thead class="table-dark">
        <tr>
            <th>code Staff</th>
            <th>groupStaff</th>
            <th>fullName</th>
            <th>gender</th>
            <th>phoneNumber</th>
            <th>option</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="staff" items="${staffList}">
            <tr>
                <td><c:out value="${staff.id}"/></td>
                <td><c:out value="${staff.groupStaff}"/></td>
                <td><c:out value="${staff.fullName}"/></td>
                <td><c:out value="${staff.gender}"/></td>
                <td><c:out value="${staff.phoneNumber}"/></td>
                <td>
                    <a href="/staffs?action=edit&id=${staff.id}">edit</a>
                    <a href="/staffs?action=delete&id=${staff.id}">Delete</a>
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