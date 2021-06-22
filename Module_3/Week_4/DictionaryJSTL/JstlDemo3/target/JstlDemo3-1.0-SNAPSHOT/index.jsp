<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        div{
            width: 50%;
            margin: auto;
        }
        h1{
            text-transform: uppercase;
            margin: .5em auto;
            text-align: center;
        }
        ul > li{
            list-style: none;
        }
        ul > li > p{
            width: 25%;
            float: left;
            margin-bottom: 0;
            line-height: 91px;
        }
        ul > li > p > img{
            width: 60%;
            margin: auto;
        }
        .avatar{
            text-align: center;
        }
        .active > p{
            line-height: 25px;
        }
    </style>
    <title>ShowCustomer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<h1 align="center">Welcome ToanDz</h1>
<div>
    <br>
    <ul class="list-group">
        <li class="list-group-item active">
            <p>Tên</p>
            <p>Ngày sinh</p>
            <p>Địa chỉ</p>
            <p>Ảnh đại diện</p>
        </li>
        <c:forEach items="${customers}" var="Customer">
            <li class='list-group-item'>
                <p><c:out value="${Customer.getName()}"></c:out></p>
                <p><c:out value="${Customer.getBirthday()}"></c:out></p>
                <p><c:out value="${Customer.getAddress()}"></c:out></p>
                <p class='avatar'>
                    <img src="<c:out value="${Customer.getPictureLink()}"></c:out>">
                </p>
            </li>
        </c:forEach>

    </ul>
</div>


</body>
</html>