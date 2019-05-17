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
    <title>EAurek - MyCart</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>
    <div class="mycart-table" style="display: inline-block">
        <c:choose>
        <c:when test="${!empty listofproducts}">
            <form method="post" action="updatequantity">
                <table border="1px solid" style="margin-top: 20px">
                    <tr>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Code</th>
                        <th>Price</th>
                    </tr>
                    <tr>
                        <c:forEach items="${listofproducts}" var="list">
                        <c:set var="total" value="${total + list.getBuyersquantity() * list.price }"></c:set>
                            <tr>
                                <td>${list.name}</td>
                                <td><input type="text" value="${list.getBuyersquantity()}" name="newquantity"></td>
                                <td>
                                <c:url value="/removeitemcart" var="cart">
                                    <c:param name="code" value="${list.code}"/>
                                </c:url>
                                    <a href="<c:out value="${cart}"/>">Delete Item</a>
                                </td>
                                <td>
                                <input type="hidden" value="${list.code}" name="code">
                                <input type="submit" value="Update">
                                </td>
                                <td>Price: ${list.getBuyersquantity() * list.price}</td>
                            </tr>
                        </c:forEach>
                    </tr>
                    <tr>
                        <td colspan="5" align="right">Total</td>
                        <input type="hidden" value="${total}" name="total"/>
                        <td>${total}</td>
                    </tr>
                </table>
            </form>
            <p style="color: red; display: inline-block" > ${toomany} </p>

            <a href="productlist">Continue shopping</a>
            or
            <c:url value="/buyproducts.jsp" var="cart">
                <c:param name="total" value="${total}"/>
            </c:url>
            <a href="<c:out value="${cart}"/>">GO AND BUY THEM</a>
        </c:when>
        <c:otherwise>
            <p> No products to list </p>
        </c:otherwise>
         </c:choose>
    </div>
    <P>${gen}</P>
<jsp:include page="footer.jsp"/>

</body>
</html>
