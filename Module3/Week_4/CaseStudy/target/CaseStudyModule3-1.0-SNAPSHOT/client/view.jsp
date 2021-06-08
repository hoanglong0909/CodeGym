<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View customer</title>
</head>
<body>
<h1>Customer details</h1>
<p>
    <a href="clients">Back to customer list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["client"].getNameClient()}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${requestScope["client"].getMachineStatus()}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${requestScope["client"].getNameProduct()}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${requestScope["client"].getAccountProduct()}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${requestScope["client"].getAccountTime()}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${requestScope["client"].getTotalMoney()}</td>
    </tr>

</table>
</body>
</html>