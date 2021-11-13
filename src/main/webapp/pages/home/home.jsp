<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 29.10.2021
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>

</head>
<body>
<p>
    <c:if test="${sessionScope.user == null}">
        <a href="${pageContext.request.contextPath}/registration"> Registration |</a>
        <a href="${pageContext.request.contextPath}/authorization"> Authorization</a>
    </c:if>
    <c:if test="${sessionScope.user != null}">
        <c:if test="${sessionScope.user.status eq 'user'}">
            <a href="${pageContext.request.contextPath}/pages/home/profile/profile.jsp"> Profile |</a>
            <a href="${pageContext.request.contextPath}/calc"> Calculator |</a>
            <a href="${pageContext.request.contextPath}/log_out"> Log out |</a>
        </c:if>

        <c:if test="${sessionScope.user.status eq 'admin'}">
            <a href="${pageContext.request.contextPath}/pages/home/admin/usersList.jsp"> Users |</a>
            <a href="${pageContext.request.contextPath}/pages/home/profile/profile.jsp"> Profile |</a>
            <a href="${pageContext.request.contextPath}/calc"> Calculator |</a>
            <a href="${pageContext.request.contextPath}/log_out"> Log out |</a>
        </c:if>
    </c:if>
</p>

</body>
</html>
