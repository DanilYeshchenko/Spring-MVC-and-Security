<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.06.2017
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/edit" method="get">
    <input hidden="true" type="text" name="catId" value="${cat.catId}">
    <input type="text" name="name" value="${cat.name}">
    <input type="text" name="weight" value="${cat.weight}">
    <input type="submit" value="Edit">
</form>
</body>
</html>