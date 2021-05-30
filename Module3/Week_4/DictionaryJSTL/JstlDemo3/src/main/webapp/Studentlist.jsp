<%--
    Document   : studentList
    Created on : Aug 14, 2020, 8:52:51 PM
    Author     : Diep
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Student Management!</h1>
<table border = "1">
    <thead>
    <tr>
        <th>No</th>
        <th>RollNo</th>
        <th>Fullname</th>
        <th>Email</th>
        <th>Birthday</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${studentList}" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${item.rollno}</td>
            <td>${item.fullname}</td>
            <td>${item.email}</td>
            <td>${item.birthday}</td>
            <td>${item.address}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
