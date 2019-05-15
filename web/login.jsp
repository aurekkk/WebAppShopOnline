<%--
  Created by IntelliJ IDEA.
  User: Aurek
  Date: 4/28/2019
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./css/style.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>MyOnlineShop</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="login-form">
        <form action="login" method="post">

            <label>Username:</label>
            <input type="text" name="username" width="30"/><br>
            <label>Password:</label>
            <input type="password" name="password" width="10"><br>
            <input type="submit" value="Login" name="login">
            <input type="reset" value="Clear" name="clear">

        </form>
    </div>
<p style="color: red">${error}</p>

    <jsp:include page="footer.jsp" />
</body>
</html>
