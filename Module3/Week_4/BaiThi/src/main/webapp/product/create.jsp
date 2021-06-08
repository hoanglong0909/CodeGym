

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
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <h2>
        <a href="products?action=products">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post" action="${pageContext.request.contextPath}/products?action=create">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Product</h2>
            </caption>
            <tr>
                <th>product Name:</th>
                <td>
                    <input type="text" name="nameProduct" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="number" name="price" id="price" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="number" name="quantity" id="quantity" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Color:</th>
                <td>
                    <input type="text" name="color" id="color" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Catelogy: </th>
                <td>
                    <select name="category">
                    <c:forEach var="category" items="${categories}">
                        <option value="${category.id}">${category.categoryName}</option>
                    </c:forEach>
                    <option value=""></option>
                    </select>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
