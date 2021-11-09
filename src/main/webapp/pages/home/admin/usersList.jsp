<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 09.11.2021
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<c:if test="${sessionScope.userStatus == admin}">
    <form action="/profile" method="post">
        <p>Таблица пользователей</p>
        <a href="/pages/home/home.jsp"> Back </a>
        <c:if test="${sessionScope.userList != null}">
            <ol>
                <c:forEach begin="0" end="${fn:length(userList) - 1}" var="index">
                    <br>
                    <tr>
                        <td><c:out value="${userList[index]}"/></td>
                        <td>
                            <form action="removeBookFromCart" method="post">
                                <input type="submit" value="Remove"/>
                                <input type="hidden" name="remove" value="${cartItem.bookId}"/>
                            </form>
                        </td>
                        <input type="button" value="history" name="h${index}">
                        <input type="button" value="personal" name="p${index}">
                        <input type="button" value="make admin" name="a${index}">
                    </tr>
                </c:forEach>
            </ol>
        </c:if>

        <c:if test="${sessionScope.userList == null}">
            <button>Show</button>
        </c:if>
    </form>
</c:if>

<p>${requestScope.message}</p>

</body>
</html>
