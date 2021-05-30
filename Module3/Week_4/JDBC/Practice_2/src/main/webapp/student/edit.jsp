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
        <a href="student?action=student">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit User
                </h2>
            </caption>
            <c:if test="${students != null}">
                <input type="hidden" name="id" value="<c:out value='${students.id}' />"/>
            </c:if>
            <tr>
                <th>Student Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${students.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Student gender:</th>
                <td>
                    <input type="text" name="gender" size="45"
                           value="<c:out value='${students.gender}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Student Email:</th>
                <td>
                    <input type="text" name="email" size="15"
                           value="<c:out value='${students.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Student phone:</th>
                <td>
                    <input type="text" name="phone" size="15"
                           value="<c:out value='${students.phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Student age:</th>
                <td>
                    <input type="text" name="age" size="15"
                           value="<c:out value='${students.age}' />"
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