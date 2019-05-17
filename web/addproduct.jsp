<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aurek
  Date: 5/16/2019
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./css/style.css" rel="stylesheet" type="css">
<html>
<head>
    <title>EAurek - Add Product</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

    <div class="addproduct-form">
     <c:choose>
        <c:when test="${insert == null}">
            <form method="post" action="addproduct">
                <label>Name:</label>
                <input type="text" name="name" width="20px"><br>
                <label>Price:</label>
                <input type="text" name="price" width="20px"><br>
                <label>Quantity:</label>
                <input type="text" name="quantity" width="5px"><br>
                <input type="submit" value="Add Product"/>
                <input type="reset" value="Clear"/>
            </form>
        </c:when>
        <c:otherwise>
            <p style="color: black"> ${insert} </p>
        </c:otherwise>
     </c:choose>

    </div>


<jsp:include page="footer.jsp"/>

</body>
</html>
