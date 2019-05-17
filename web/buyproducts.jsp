<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" %>
<%--
  Created by IntelliJ IDEA.
  User: Aurek
  Date: 5/17/2019
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./css/style.css" type="css" rel="stylesheet"/>
<html>
<head>
    <title>EAurek - Finalize your order</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

    <div class="buy-form">
        <c:choose>
        <c:when test="${order == null}">
        <form method="post" action="buyproducts">
            <label>Name:</label>
            <input type="text" name="name" width="30px"><br>
            <label>Address:</label>
            <input type="text" name="address" width="30px"><br>
            <label>Email:</label>
            <input type="text" name="email" width="30px"><br>
            <label>Mobile number:</label>
            <input type="text" name="mobile" width="30px"><br>
            <label>Total:</label><p style="display: table-cell"><c:out value="${param.total}"/></p><input type="hidden" name="total" value="<c:out value="${param.total}"/>">
            <input type="submit" value="Submit your order">
            <input type="reset" value="Clear">
        </form>
        </c:when>
        <c:otherwise>
            <div class="order-form" style="display: inline-block">
            <h3>Customer Information:</h3>
            <ul>
                <li>Name: <p>${oname}</p></li>
                <li>Email: <p>${oemail}</p></li>
                <li>Phone: <p>${omobile}</p></li>
                <li>Address: <p>${oaddress}</p></li>
            </ul>
            <h3>Order Summary:</h3>
            <ul>
                <li>Total:
                    <p>${ototal}</p>
               </span>
                </li>
            </ul>
            </div>
        </c:otherwise>
        </c:choose>
    </div>

<jsp:include page="footer.jsp"/>


</body>
</html>
