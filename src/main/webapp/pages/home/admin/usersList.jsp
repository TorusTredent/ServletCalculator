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
<jsp:include page="/pages/home/_header.jsp"/>
<div class="container">
    <div class="row justify-content-center m-3">
        <div class="col-sm-12">
            <c:if test="${sessionScope.user.status eq 'admin'}">
                <p style="font-weight: bolder; text-align: center">
                    Таблица пользователей
                </p>
                <c:if test="${sessionScope.userList != null}">
                    <ol class="list-group list-group-numbered">
                        <c:forEach begin="0" end="${fn:length(userList) - 1}" var="index">
                            <li class="list-group-item">
                                <form action="/userList" method="post">
                                    <label><input type="text" name="userNumber" hidden value="${index}"></label>
                                    id - ${sessionScope.userList.get(index).id};
                                    username - ${sessionScope.userList.get(index).username};
                                    password - ${sessionScope.userList.get(index).password};
                                    name - ${sessionScope.userList.get(index).name};
                                    status - ${sessionScope.userList.get(index).status};
                                    <c:if test="${sessionScope.user.id != sessionScope.userList.get(index).id}">
                                        <button type="submit" name="operation" class="btn btn-primary" value="history">History</button>
                                        <button type="submit" name="operation" class="btn btn-warning" value="addAdmin">Add admin</button>
                                        <button type="submit" name="operation" class="btn btn-success" value="removeAdmin">Remove admin</button>
                                        <button type="submit" name="operation" class="btn btn-danger" value="deleteUser">delete</button>
                                    </c:if>
                                </form>
                            </li>
                        </c:forEach>
                    </ol>
                </c:if>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
