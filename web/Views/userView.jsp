<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>Список пользователей</title>
</head>
<body>
<c:out value="${currentUser.getRoleName()}"/>
<table border ="1">
  <tr>
    <th>Логин</th>
    <th>Роль</th>
  </tr>
  <c:forEach items = "${users}" var="user">
    <tr>
      <td><c:out value="${user.getEmail()}"/></td>
      <td><c:out value="${user.getRoleName()}"/></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>

