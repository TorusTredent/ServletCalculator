<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Show calc history</title>
</head>
<body>
<c:if test="${sessionScope.user != null}">
    <a href="${pageContext.request.contextPath}/pages/home/calculator/calculator.jsp"> Back</a>
    <a href="${pageContext.request.contextPath}/remove_history"> Delete history</a>
    <form action="/show_history" method="post">
        <input type="submit" value="Show" name="show"/>
        <input type="submit" value="Hide" name="hide"/>
        <c:if test="${sessionScope.operationList != null}">
            <c:forEach begin="0" end="${fn:length(operationList) - 1}" var="index">
                <br>
                <tr>
                    <td><c:out value="${operationList[index]}"/></td>
                </tr>
            </c:forEach>
        </c:if>
    </form>
</c:if>

<c:if test="${sessionScope.user == null}">
    <a href="/pages/home/home.jsp"> Back to sing in</a>
</c:if>
</body>
</html>
