<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Simple Dictionary</title>
</head>
<body>
<%!
    Map<String, String> dic = new HashMap<>();
%>

<%
    dic.put("hello", "Xin chào");
    dic.put("how", "Thế nào");
    dic.put("book", "Quyển vở");
    dic.put("computer", "Máy tính");

    String search = request.getParameter("searchtxt");

    String result = dic.get(search);

    if (result != null) {
        out.println("Word: " + search);
        out.println("Result: " + result);
    } else {
        out.println("<h1> Not found</h1>");
    }

%>

</body>
</html>