<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 13.11.2021
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User operation history</title>
</head>
<body>
    <c:if test="${sessionScope.user.status eq 'admin'}">
        <form action="/userOperationList" method="post">
            <button type="submit" name="back" value="back">Back</button>
            <input type="submit" value="Show" name="show"/>
            <input type="submit" value="Hide" name="hide"/>
            <c:if test="${sessionScope.adminOperationList != null}">
                <ul>
                    <c:forEach var="operations" items="${sessionScope.adminOperationList}">
                        <li><c:out value="${operations}"/></li>
                    </c:forEach>
                </ul
            </c:if>
        </form>
    </c:if>


<c:if test="${!sessionScope.user.status eq 'admin'}">
    <a href="/pages/home/home.jsp"> Back to sing in</a>
</c:if>
</body>
</html>
