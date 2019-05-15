<%--
  Created by IntelliJ IDEA.
  User: Aurek
  Date: 5/2/2019
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./css/style.css" type="text/css" rel="stylesheet">
<html>
<head>
    <title>Home page</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <jsp:include page="menu.jsp"/>

    <p>A mers logarea, ${username}</p>
    <p>Your role is ${role}</p>
    <a href="index">index</a>
</body>
</html>
