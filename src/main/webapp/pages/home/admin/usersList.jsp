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
<c:if test="${sessionScope.user.status eq 'admin'}">
    <p>Таблица пользователей
        <a href="/pages/home/home.jsp">Back </a>
    </p>
    <c:if test="${sessionScope.userList != null}">
        <ol>
            <c:forEach begin="0" end="${fn:length(userList) - 1}" var="index">
                <li>
                    <form action="/userList" method="post">
                        <p>
                            <label>
                                <input type="text" name="userNumber" hidden value="${index}">
                            </label>
                            id - ${sessionScope.userList.get(index).id};
                            username - ${sessionScope.userList.get(index).username};
                            password - ${sessionScope.userList.get(index).password};
                            name - ${sessionScope.userList.get(index).name};
                            status - ${sessionScope.userList.get(index).status};
                            <c:if test="${sessionScope.user.id != sessionScope.userList.get(index).id}">
                                <button type="submit" name="operation" value="history">History</button>
                                <button type="submit" name="operation" value="addAdmin">Add admin</button>
                                <button type="submit" name="operation" value="removeAdmin">Remove admin</button>
                                <button type="submit" name="operation" value="deleteUser">delete</button>
                            </c:if>
                        </p>
                    </form>
                </li>
            </c:forEach>
        </ol>
    </c:if>
</c:if>
<p>${requestScope.message}</p>

</body>
</html>
