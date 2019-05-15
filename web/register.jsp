<%--
  Created by IntelliJ IDEA.
  User: Aurek
  Date: 5/2/2019
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./css/style.css" type="text/css" rel="stylesheet">
<html>
<head>
    <title>EAurek - Registration Page</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="registration-form" style="text-align: center">

        <form action="register" method="post">
            <label>Username:</label>
            <input type="text" name="username" width="30"/><br>
            <label>Password:</label>
            <input type="password" name="password" width="10"><br>
            <input type="submit" value="Register" name="register">
            <input type="reset" value="Clear" name="clear">
        </form>
        <p style="color: red;"> ${errorRegister} </p>
    </div>


    <jsp:include page="footer.jsp" />

</body>
</html>
