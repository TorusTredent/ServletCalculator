<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 27.10.2021
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<c:if test="${sessionScope.user != null}">
    <form action="${pageContext.request.contextPath}/profile" method="post"></form>
    <a href="${pageContext.request.contextPath}/profile"> Personal |</a>
    <a href="${pageContext.request.contextPath}/changer_name"> Change name |</a>
    <a href="${pageContext.request.contextPath}/changer_password"> Change password |</a>
    <a href="${pageContext.request.contextPath}/delete_profile"> Delete account |</a>
    <a href="${pageContext.request.contextPath}/pages/home.jsp"> back </a>
</c:if>

<c:if test="${sessionScope.user == null}">
    <a href="${pageContext.request.contextPath}/pages/home.jsp"> Back to sing in</a>
</c:if>
</body>
</html>
