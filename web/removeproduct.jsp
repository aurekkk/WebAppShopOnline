<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aurek
  Date: 5/16/2019
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./css/style.css" rel="stylesheet" type="css">
<html>
<head>
    <title>EAurek - Remove Product</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <jsp:include page="menu.jsp"/>
    <div class="removeproduct-form" >
        <c:choose>
        <c:when test="${delete == null}">
        <form method="post" action="removeitem">
        <label>Enter the code of the product you want to remove:</label>
        <input type="text" name="code" width="20px">
        <input type="submit" value="Remove Product">
        <input type="reset" value="Clear">
        </form>
        </c:when>
        <c:otherwise>
            <p style="color: red;"> ${delete} </p>
        </c:otherwise>
        </c:choose>

    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
