<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 29.10.2021
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change name</title>
</head>
<body>
<c:if test="${sessionScope.user != null}">
    <form action="${pageContext.request.contextPath}/changer_name" method="post">
        <input type="text" name="name" placeholder="Name">
        <button>Submit</button>
    </form>
    <a href="${pageContext.request.contextPath}/pages/profile.jsp"> Back </a>
    <p>${requestScope.message}</p>
</c:if>

<c:if test="${sessionScope.user == null}">
    <a href="${pageContext.request.contextPath}/pages/home.jsp"> Back to sing in</a>
</c:if>

</body>
</html>
