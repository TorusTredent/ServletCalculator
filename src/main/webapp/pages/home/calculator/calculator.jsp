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
<c:if test="${sessionScope.user != null}">
    <form action="/calc" method="post">
        <input type="text" name="num1" placeholder="Number 1">

        <select name="operation">
            <option disabled selected>operation</option>
            <option value="sum">+</option>
            <option value="sub">-</option>
            <option value="div">/</option>
            <option value="multiply">*</option>
        </select>

        <input type="text" name="num2" placeholder="Number 2">
        <button>Submit</button>
    </form>
    <p>${requestScope.message}</p>
    <a href="/pages/home/calculator/show_calc_history.jsp"> Show history</a>
    <a href="/pages/home/home.jsp"> Back </a>
</c:if>

<c:if test="${sessionScope.user == null}">
    <a href="/pages/home/home.jsp"> Back to sing in</a>
</c:if>
</body>
</html>
