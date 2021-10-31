<%@ page import="by.tms.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 31.10.2021
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>User profile</title>
</head>
<body>
<c:if test="${sessionScope.user != null}">
    <form action="/profile" method="post">
        <button>Show</button>
        <c:if test="${sessionScope.userProfile != null}">
            <c:forEach begin="0" end="${fn:length(userProfile) - 1}" var="index">
                <br>
                <tr>
                    <td><c:out value="${userProfile[index]}"/></td>
                </tr>
            </c:forEach>
        </c:if>
    </form>
    <a href="${pageContext.request.contextPath}/pages/home/profile/profile.jsp"> Back </a>
</c:if>

<c:if test="${sessionScope.user == null}">
    <a href="${pageContext.request.contextPath}/pages/home/home.jsp"> Back to sing in</a>
</c:if>
</body>
</html>
