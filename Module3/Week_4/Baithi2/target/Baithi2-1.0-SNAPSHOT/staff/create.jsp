<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1> Come back StaffManager</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <h2>
        <a href="staffs?action=staffs">StaffManager</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New staff</h2>
            </caption>
            <tr>

                <div class="form-group">
                    <th><label for="exampleInputEmail1">groupStaff</label></th>
                    <td><input type="text" name ="groupStaff"  id="groupStaff" class="form-control" placeholder="Enter groupStaff">
                </div>
            </tr>

            <tr>
                <div class="form-group">
                    <th><label for="exampleInputEmail1">fullName</label></th>
                    <td><input type="text" name ="fullName"  id="fullName" class="form-control" placeholder="Enter fullName">
                </div>
            </tr>
            <tr>
                <div class="form-group">
                    <th><label for="exampleInputEmail1">Gender</label></th>
                    <td><input type="text" name ="gender"  id="gender" class="form-control" placeholder="Enter Gender">
                </div>
            </tr>
            <tr>
                <th><label for="example-tel-input">Telephone</label></th>
                <td><input type="tel" name ="phoneNumber"  id="phoneNumber" class="form-control" id="example-tel-input" placeholder="Enter telephone">
            </tr>
            <tr>
                <div class="form-group">
                    <th><label for="exampleInputEmail1">dob</label></th>
                    <td><input type="date" name ="dob"  id="dob" class="form-control" placeholder="Enter dob">
                </div>
            </tr>
            <tr>
                <div class="form-group">
                    <th><label for="exampleInputEmail1">cmndNumber</label></th>
                    <td><input type="number" name ="cmndNumber"  id="cmndNumber" class="form-control" placeholder="Enter cmnd">
                </div>
            </tr>
            <tr>
                <div class="form-group">
                    <th><label for="exampleInputEmail1">Email</label></th>
                    <td><input type="email" name ="email"  id="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                </div>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input class="btn btn-secondary btn-sm" type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</html>
