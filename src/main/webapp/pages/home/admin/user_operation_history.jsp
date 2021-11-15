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
<jsp:include page="/pages/home/_header.jsp"/>
<div class="container">
    <div class="row justify-content-center m-3">
        <div class="col-sm-12">
            <c:if test="${sessionScope.user.status eq 'admin'}">
                <form action="/userOperationList" method="post">
                    <button type="submit" class="btn btn-primary"  name="back" value="back">Back</button>
                    <input type="submit" class="btn btn-primary" value="Show" name="show"/>
                    <input type="submit" class="btn btn-primary" value="Hide" name="hide"/>
                    <c:if test="${sessionScope.adminOperationList != null}">
                        <ul class="list-group list-group-numbered">
                            <c:forEach var="operations" items="${sessionScope.adminOperationList}">
                                <li class="list-group-item"><c:out value="${operations}"/></li>
                            </c:forEach>
                        </ul>
                    </c:if>
                </form>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
