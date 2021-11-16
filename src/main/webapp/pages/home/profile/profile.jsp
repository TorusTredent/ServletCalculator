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
<jsp:include page="/pages/home/_header.jsp"/>
<c:if test="${sessionScope.user != null}">
    <jsp:include page="/pages/home/_profileHeader.jsp"/>
</c:if>
</body>
</html>
