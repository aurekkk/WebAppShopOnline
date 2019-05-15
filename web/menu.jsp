<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aurek
  Date: 5/10/2019
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<div class="menu-container">

    <a href="index">Home</a>
    |
    <a href="productlist">
        Product List
    </a>
    |
    <a href="${pageContext.request.contextPath}/cart.jsp">
        My Cart
    </a>

    <c:if test="${sessionScope.role == 'admin'}">
        |
        <a href="${pageContext.request.contextPath}/asd.jsp">
            Add Product
        </a>
        |
        <a href="${pageContext.request.contextPath}/asd.jsp">
            Edit Product
        </a>
        |
        <a href="${pageContext.request.contextPath}/asd.jsp">
            Remove Product
        </a>
    </c:if>

</div>
