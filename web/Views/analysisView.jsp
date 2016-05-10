<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>������ ��������</title>
</head>
<body>
<c:forEach items = "${analyzes}" var="analyz" varStatus="status">
  <table border ="1">
    <tr>������ �${status.getIndex()+1}</tr>
    <tr>
      <th>����</th>
      <td><c:out value="${analyz.getDate()}"/></td>
    </tr>
    <tr>
      <th>������� hbA1c</th>
      <td><c:out value="${analyz.getHbA1c()}%"/></td>
    </tr>
    <tr>
      <th>����� ����������</th>
      <td><c:out value="${analyz.getTotalCholesterol()} �����/�."/></td>
    </tr>
    <tr>
      <th>������������</th>
      <td><c:out value="${analyz.getTriglycerides()} �����/�."/></td>
    </tr>

    <c:if test="${currentUser.isAdmin() ||currentUser.getDoctor().getId()==visit.getDoctor().getId()}">
      <tr>
        <td>
          <form action = "/deleteAnalyzes" method="get">
            <input type="hidden" name="id" value="${analyz.getId()}">
            <input type="image" src="/Views/Images/remove.png">
          </form>
        </td>
        <td>
          <form action = "/updateAnalyz" method="get">
            <input type="hidden" name="id" value="${analyz.getId()}">
            <input type="hidden" name="visitId" value="${visit.getId()}">
            <input type="image" src="/Views/Images/edit.png">
          </form>
        </td>
      </tr>
    </c:if>
  </table>
</c:forEach>

<c:if test="${currentUser.getDoctor().getId()==visit.getDoctor().getId()}">
  <table border="2">
    <form action = "/createAnalyz" method="get">
      <tr >
        <td>�������� ������</td>
        <td><input type="image" src="/Views/Images/add.png"></td>
        <input type="hidden" name="visitId" value="${visit.getId()}">
      </tr>
    </form>
  </table>
</c:if>
</body>
</html>