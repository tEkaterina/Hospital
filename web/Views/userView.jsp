<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>������ �������������</title>
</head>
<body>
<c:out value="${currentUser.getRoleName()}"/>
<table border ="1">
  <tr>
    <th>�����</th>
    <th>����</th>
    <th>���������� ������������</th>
    <th>���������� ������������</th>
  </tr>
  <c:forEach items = "${users}" var="user">
    <tr>
      <td><c:out value="${user.getEmail()}"/></td>
      <td><c:out value="${user.getRoleName()}"/></td>
      <td><c:out value="${user.getActivity()}"/></td>

      <c:if test="${user.getActivity() && currentUser.getId()!=user.getId()}">
      <td>
          <form action = "/block" method="GET">
              <input type="hidden" name="id" value="${user.getId()}">
              <input type="submit" value="�������������">
          </form>
      </td>
      </c:if>

      <c:if test="${!user.getActivity() && currentUser.getId()!=user.getId()}">
      <td>
          <form action = "/block" method="POST">
            <input type="hidden" name="id" value="${user.getId()}">
            <input type="submit" value="��������������">
          </form>
      </td>
      </c:if>


    </tr>
  </c:forEach>
</table>

</body>
</html>

