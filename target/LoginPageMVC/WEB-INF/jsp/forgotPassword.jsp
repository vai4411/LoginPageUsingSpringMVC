<%--
  Created by IntelliJ IDEA.
  User: Vaibhav
  Date: 6/7/2020
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="loginBox">
    <h1>Forgot Password</h1>
    <form action="ForgotPasswordServlet" method="post">
        <p>Username</p>
        <input type="text" name="name" placeholder="Enter Username">
        <p>Email</p>
        <input type="email" name="email" placeholder="Enter Email">
        <input type="submit" name="submit" value="Check Account">
    </form>
    <form action="register.jsp" method="post">
        <input type="submit" name="submit" value="Register">
    </form>
</div>
</body>
</html>
