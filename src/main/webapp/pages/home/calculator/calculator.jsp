<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 29.10.2021
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<jsp:include page="/pages/home/_header.jsp"/>
<div class="container">
    <div class="row justify-content-center m-3">
        <div class="col-sm-10">
            <c:if test="${sessionScope.user != null}">
                <form action="/calc" method="post">
                    <div class="col-sm-5">
                        <div class="row m-2">
                            <input type="text" name="num1" class="form-control" placeholder="Number 1">
                        </div>
                    </div>
                    <div class="col-sm-5">
                        <div class="row m-2">
                            <select class="form-select" name="operation" aria-label=".form-select-sm example">
                                <option disabled selected>operation</option>
                                <option value="sum">+</option>
                                <option value="sub">-</option>
                                <option value="div">/</option>
                                <option value="multiply">*</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-5">
                        <div class="row m-2">
                            <input type="text" name="num2" class="form-control" placeholder="Number 2">
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="row m-2">
                            <button type="submit" class="btn btn-outline-primary">Submit</button>
                        </div>
                    </div>
                </form>
                <form action="/remove_history" method="get">
                    <div class="col-sm-2">
                        <div class="row m-2">
                            <button type="submit" class="btn btn-outline-primary">Delete hostory</button>
                        </div>
                    </div>
                </form>
                <c:if test="${requestScope.calcMessage != null}">
                    <div class="alert alert-success" role="alert">
                            ${requestScope.calcMessage}
                    </div>
                </c:if>
                <c:if test="${requestScope.alert != null}">
                    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
                        <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
                            <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"></path>
                        </symbol>
                    </svg>
                    <div class="alert alert-danger d-flex align-items-center" role="alert">
                        <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:">
                            <use xlink:href="#exclamation-triangle-fill"></use>
                        </svg>
                        <div>
                                ${requestScope.alert}
                        </div>
                    </div>
                </c:if>
                <c:if test="${sessionScope.operationList != null}">
                    <div>
                        <ol class="list-group list-group-numbered">
                            <c:forEach var="operations" items="${sessionScope.operationList}">
                                <li class="list-group-item"><c:out value="${operations}"/></li>
                            </c:forEach>
                        </ol>
                    </div>
                </c:if>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
