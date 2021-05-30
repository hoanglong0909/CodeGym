<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 25/05/2021
  Time: 4:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            text-align: center;
            justify-content: center;
            font-weight: bold;
        }
        .container P{
            background-color: bisque;
            height: 200px;
            width: 200px;
        }
    </style>
</head>
<body>
<div class="container">
    <p>Product : <%=request.getAttribute("product") %></p>
    <p>Amount : <%=request.getAttribute("amount") %></p>
    <p>Price : <%=request.getAttribute("price") %></p>
    <p>Total : <%=request.getAttribute("total") %></p>
</div>

</body>
</html>
