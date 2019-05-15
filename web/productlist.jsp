<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aurek
  Date: 5/10/2019
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EAurek - Products List</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

<div class="product-table">
    <table border="1px solid">
        <tr>
            <th>Name</th>
            <th>Quantity</th>
            <th>Code</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${products}" var="list">
            <tr>
                <td>${list.name}</td>
                <td>${list.quantity}</td>
                <td>${list.code}</td>
                <td>${list.price}</td>
                <td>
                    <c:url value="/mycart" var="cart">
                        <c:param name="code" value="${list.code}"/>
                    </c:url>
                    <a href="<c:out value="${cart}"/>">Add to Cart</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<p style="text-align: center"> ${errorProducts} </p>
<jsp:include page="footer.jsp"/>

</body>
</html>
