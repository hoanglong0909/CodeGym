<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 25/05/2021
  Time: 10:31 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form >
<table>
<thead>
    <th>username</th>
    <th>password</th>
    <th>fullName</th>
    <th>age</th>
    <th>birthDate</th>
    <th>gender</th>
</thead>
    <c:forEach items="${requestScope.user}" var="user" >
    <tbody>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.fullName}</td>
            <td>${user.age}</td>
            <td>${user.birthDate}</td>
            <td>${user.gender}</td>
    </tbody>
    </c:forEach>
</table>
</form>

</body>
</html>
