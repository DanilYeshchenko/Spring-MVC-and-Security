<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Cat Database</title>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
  <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
</head>
<body>
<form action="/add" method="get">
  <input type="text" name="name">
  <input type="text" name="weight">
  <input type="submit" value="Add to Database">
</form>

<table id="example" class="display" width="100%" cellspacing="0">
  <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Weight</th>
      <th>Delete</th>
      <th>Edit</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${catList}" var="cat">
      <tr>
        <td>${cat.catId}</td>
        <td>${cat.name}</td>
        <td>${cat.weight}</td>
        <td><a href="/delete/${cat.catId}">Delete</a></td>
        <td><a href="/edit/${cat.catId}">Edit</a></td>
      </tr>
    </c:forEach>
  </tbody>
</table>


<c:url value="/j_spring_security_logout" var="logoutUrl" />

<!-- csrt for log out-->
<form action="${logoutUrl}" method="post" id="logoutForm">
  <input type="hidden"
         name="${_csrf.parameterName}"
         value="${_csrf.token}" />
</form>

<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<c:if test="${pageContext.request.userPrincipal.name != null}">
  <h2>
    Welcome : ${pageContext.request.userPrincipal.name} | <a
          href="javascript:formSubmit()"> Logout</a>
  </h2>
</c:if>
<a href="<c:url value="j_spring_security_logout" />" > Logout</a>

<script>
    $(function(){
        $("#example").dataTable();
    });
</script>
</body>
</html>
