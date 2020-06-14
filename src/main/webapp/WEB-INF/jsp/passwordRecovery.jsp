<%--
  Created by IntelliJ IDEA.
  User: Vaibhav
  Date: 6/7/2020
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="loginBox">
    <h1>Password Recovery</h1>
    <form action="passwordRecovery" method="post">
        <p>Username</p>
        <input type="text" name="name" placeholder="Enter Username">
        <p>Email Address</p>
        <input type="email" name="email" placeholder="Enter Email">
        <p>Password</p>
        <input type="password" name="password" placeholder="Enter Password">
        <p>Confirm Password</p>
        <input type="password" name="confirmPassword" placeholder="Enter Password">
        <input type="submit" name="submit" value="Set Password">
    </form>
    <form action="login.jsp" method="post">
        <input type="submit" name="submit" value="Login">
    </form>
</div>
</body>
</html>
