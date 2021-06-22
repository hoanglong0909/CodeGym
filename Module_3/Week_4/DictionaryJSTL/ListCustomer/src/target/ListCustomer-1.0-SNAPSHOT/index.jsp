<jsp:useBean id="Customer" scope="request" type="javax.xml.stream.util.StreamReaderDelegate"/>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<tr>
    <th>Tên </th>
    <th>Ngày sinh</th>
    <th>Địa chỉ</th>
    <th>Ảnh </th>
</tr>
<tr>
    <td>${Customer.name}</td>
    <td></td>
    <td></td>
    <td></td>

</tr>

</body>
</html>