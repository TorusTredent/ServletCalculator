<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 14.11.2021
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/pages/home/home.jsp">CalcApp</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <c:if test="${sessionScope.user == null}">
                    <a class="nav-link" href="/authorization">Authorization</a>
                    <a class="nav-link" href="/registration">Registration</a>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <c:if test="${sessionScope.user.status eq 'user'}">
                        <a class="nav-link" href="/pages/home/profile/profile.jsp">Profile</a>
                        <a class="nav-link " href="/calc">Calculator</a>
                        <a class="nav-link" href="/log_out">Log out</a>
                    </c:if>

                    <c:if test="${sessionScope.user.status eq 'admin'}">
                        <a class="nav-link" href="/pages/home/admin/usersList.jsp">Users</a>
                        <a class="nav-link" href="/pages/home/profile/profile.jsp">Profile</a>
                        <a class="nav-link" href="/calc">Calculator</a>
                        <a class="nav-link" href="/log_out">Log out</a>
                    </c:if>
                </c:if>
            </div>
        </div>
    </div>
</nav>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
