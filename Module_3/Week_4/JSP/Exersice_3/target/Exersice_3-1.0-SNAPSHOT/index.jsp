<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "\n" +
        "Phonestore" %>
</h1>
<br/>
<form action="ServletProduct" method="post">
    <label>Product:</label><br/>
    <input type="text" name="product" placeholder="name product" ><br/>
    <label>sl:</label><br/>
    <input type="text" name="amount" placeholder="amount" ><br/>
    <label>Price:</label><br/>
    <input type="text" name="price" placeholder="price" ><br/>
    <input type = "submit" id = "submit" value = "into money"/>


</form>

</body>
</html>