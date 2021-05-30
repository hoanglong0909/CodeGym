<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/student?action=create">Add New User</a>
    </h2>
    <form method="get">
        <input type="hidden" name="action" value="search">
        <input type="text" name="search" placeholder="Enter your text !">
        <input type="submit" name ="search">
    </form>
    <form>
        <input type="hidden" name="action" value="sort">
        <input type="submit" name="sort">
    </form>

</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>gender</th>
            <th>email</th>
            <th>phone</th>
            <th>age</th>
            <th>edit,delete</th>
        </tr>
        <c:forEach var="student" items="${student}">
            <tr>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.gender}"/></td>
                <td><c:out value="${student.email}"/></td>
                <td><c:out value="${student.phone}"/></td>
                <td><c:out value="${student.age}"/></td>
                <td>
                    <a href="/student?action=edit&id=${student.id}">Edit</a>
                    <a href="/student?action=delete&id=${student.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>