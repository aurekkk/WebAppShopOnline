<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aurek
  Date: 4/26/2019
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Aurek
  Date: 4/26/2019
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./css/style.css" rel="stylesheet" type="css">

<div class="header-container">
    <div class="name">EAurek</div>

    <div class="login-logout">

        <c:choose>
            <c:when test="${sessionScope.user != null}">
                <p>Hello, ${user}</p>
                <a href="logout">Logout</a>
            </c:when>

            <c:otherwise>
                <a href="${pageContext.request.contextPath}/login.jsp">
                    Login
                </a>
                Or
                <a href="${pageContext.request.contextPath}/register.jsp">
                    Register
                </a>
            </c:otherwise>
        </c:choose>

    </div>


</div>