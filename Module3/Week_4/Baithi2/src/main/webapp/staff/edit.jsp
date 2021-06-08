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
        <a href="staffs?action=staffs">List All Staff</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Staff
                </h2>
            </caption>
            <c:if test="${staff != null}">
                <input type="hidden" name="id" value="<c:out value='${staff.id}' />"/>
            </c:if>
            <tr>
                <th>groupStaff:</th>
                <td>
                    <input type="text" name="groupStaff" size="45"
                           value="<c:out value='${staff.groupStaff}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>fullName</th>
                <td>
                    <input type="text" name="fullName" size="45"
                           value="<c:out value='${staff.fullName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>gender:</th>
                <td>
                    <input type="text" name="gender" size="15"
                           value="<c:out value='${staff.gender}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>phoneNumber:</th>
                <td>
                    <input type="number" name="phoneNumber" size="15"
                           value="<c:out value='${staff.phoneNumber}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>dob:</th>
                <td>
                    <input type="date" name="dob" size="15"
                           value="<c:out value='${staff.dob}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>cmndNumber:</th>
                <td>
                    <input type="number" name="cmndNumber" size="15"
                           value="<c:out value='${staff.cmndNumber}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>email:</th>
                <td>
                    <input type="email" name="email" size="15"
                           value="<c:out value='${staff.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>