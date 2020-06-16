<%--
  Created by IntelliJ IDEA.
  User: Vaibhav
  Date: 6/13/2020
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head>
<body>
<div class="loginBox">
    <h1>Login Here</h1>
    <form action="loginServlet" method="get">
<%--        <p>Username</p>--%>
        <input type="text" name="name" placeholder="Enter Username">
<%--        <p>Password</p>--%>
        <input type="password" name="password" placeholder="Enter Password">
        <input type="submit" name="submit" value="Login">
    </form>
    <form action="register" method="get">
        <input type="submit" name="submit" value="Register">
    </form>
</div>
<c:if test = "${isError}">
<script>
    $(document).ready(function() {
        swal ( 'Login Unsuccessful' ,  'Wrong UserName Or Password!' ,  'error' );
    });
</script>
</c:if>
</body>
</html>
