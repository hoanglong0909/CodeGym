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
        <a href="clients?action=clients">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Client
                </h2>
            </caption>
            <c:if test="${client != null}">
                <input type="hidden" name="idClient" value="<c:out value='${client.idClient}' />"/>
            </c:if>
            <tr>
                <th>NameClient:</th>
                <td>
                    <input type="text" name="nameClient" size="45"
                           value="<c:out value='${client.nameClient}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>machine</th>
                <td>
                    <input type="text" name="nameMachine" size="45"
                           value="<c:out value='${client.nameMachine}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>nameProduct:</th>
                <td>
                    <input type="text" name="nameProduct" size="15"
                           value="<c:out value='${client.nameProduct}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>nameProduct:</th>
                <td>
                    <input type="text" name="accountProduct" size="15"
                           value="<c:out value='${client.accountProduct}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>nameProduct:</th>
                <td>
                    <input type="text" name="accountTime" size="15"
                           value="<c:out value='${client.accountTime}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>nameProduct:</th>
                <td>
                    <input type="text" name="totalMoney" size="15"
                           value="<c:out value='${client.totalMoney}' />"
                    />
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