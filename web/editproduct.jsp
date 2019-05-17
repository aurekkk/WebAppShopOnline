<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aurek
  Date: 5/16/2019
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./css/style.css" rel="stylesheet" type="css">
<html>
<head>
    <title>EAurek - Edit Product</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>
<div class="editproduct-form">
    <c:choose>
        <c:when test="${edit == null}">
            <form method="post" action="editproduct">
                <label>Id:</label>
                <input type="text" name="code" width="20px"><br>
                <label>Name:</label>
                <input type="text" name="name" width="20px"><br>
                <label>Price:</label>
                <input type="text" name="price" width="20px"><br>
                <label>Quantity:</label>
                <input type="text" name="quantity" width="5px"><br>
                <input type="submit" value="Edit Product"/>
                <input type="reset" value="Clear"/>
            </form>
        </c:when>
        <c:otherwise>
            <p style="color: black"> ${edit} </p>
        </c:otherwise>
    </c:choose>

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
