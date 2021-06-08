<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Staff Management Application</title>

</head>
<body>
<center>
    <h1>Staff Management</h1>
    <h2>
        <a href="/staffs?action=staffs">SEARCH  Staff</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>groupStaff</th>
            <th>fullName</th>
            <th>gender</th>
            <th>phoneNumber</th>
        </tr>
        <c:forEach var="staff" items="${staffList}">
            <tr>
                <td><c:out value="${staff.id}"/></td>
                <td><c:out value="${staff.groupStaff}"/></td>
                <td><c:out value="${staff.fullName}"/></td>
                <td><c:out value="${staff.gender}"/></td>
                <td><c:out value="${staff.phoneNumber}"/></td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>

</html>