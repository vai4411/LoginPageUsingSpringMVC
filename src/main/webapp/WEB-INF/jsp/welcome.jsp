<%--
  Created by IntelliJ IDEA.
  User: Vaibhav
  Date: 6/5/2020
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head>
<body>
<div class="loginBox">
<form action="logout" method="get">
    <h1>Welcome...</h1>
    <h3>Welcome,${name}<br><br>
    Your registration id is ${id}<br><br>
    Your entry date and time is ${date}<br><br>
    Your email address is ${email}<br><br>
    </h3>
    <input type="submit" name="submit" value="Logout">
</form>
</div>
<c:if test = "${isSuccess}">
    <script>
        $(document).ready(function() {
            swal ( 'Login Successful' ,  '' ,  'success' );
        });
    </script>
</c:if>
</body>
</html>
