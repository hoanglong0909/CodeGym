<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/users?action=create">Create new User</a>
</p>
<table border="1" style="text-align: center">
    <tr>
        <td>id</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["userList"]}' var="userList">
        <tr>
            <td><a href="/users?action=view&id=${userList.getId()}">${userList.getId()}</a></td>
            <td>${userList.getUsername()}</td>
            <td>${userList.getPassword()}</td>
            <td><a href="/users?action=edit&id=${userList.getId()}">edit</a></td>
            <td><a href="/users?action=delete&id=${userList.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>