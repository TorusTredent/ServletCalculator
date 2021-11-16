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
<jsp:include page="/pages/home/_header.jsp"/>
<c:if test="${sessionScope.user != null}">
    <jsp:include page="/pages/home/_profileHeader.jsp"/>
    <div class="container">
        <div class="row justify-content-center m-3">
            <div class="col-sm-12">
                <form action="/profile" method="post">
                    <button class="btn btn-primary">Show</button>
                    <c:if test="${sessionScope.userProfile != null}">
                        <ul class="list-group list-group-flush">
                            <c:forEach var="profile" items="${sessionScope.userProfile}">
                                <li class="list-group-item"><c:out value="${profile}"/></li>
                            </c:forEach>
                        </ul>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</c:if>
</body>
</html>
