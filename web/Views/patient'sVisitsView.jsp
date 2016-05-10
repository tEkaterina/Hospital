<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>������ �������</title>
</head>
<body>
  <h1>������ ������� ��������: ${patient.getName()} ${patient.getSurname()} </h1>
  <c:forEach items = "${visits}" var="visit" varStatus="status">
  <table border ="1">
    <tr>����� �${status.getIndex()+1}</tr>
    <tr>
      <th>����</th>
      <td><c:out value="${visit.getDate()}"/></td>
    </tr>
    <tr>
      <th>�����������</th>
      <td><c:out value="${visit.getComment()}"/></td>
    </tr>
    <tr>
      <th>��� �����</th>
      <td><c:out value="${visit.getDoctor().getName()} ${visit.getDoctor().getSurname()} "/></td>
    </tr>
    <tr>
      <td colspan="2">
      <form action = "/analyzes" method="get">
        <input type="hidden" name="id" value="${visit.getId()}">
        <input type="submit" value="�������� ������ ��������">
      </form>
      </td>
    </tr>
    <c:if test="${currentUser.isAdmin() ||currentUser.getDoctor().getId()==visit.getDoctor().getId()}">
    <tr>
      <td>
        <form action = "/deleteVisit" method="get">
          <input type="hidden" name="id" value="${visit.getId()}">
          <input type="image" src="/Views/Images/remove.png">
        </form>
      </td>
      <td>
        <form action = "/updateVisit" method="get">
          <input type="hidden" name="id" value="${visit.getId()}">
          <input type="image" src="/Views/Images/edit.png">
        </form>
      </td>
    </tr>
    </c:if>
  </table>
  </c:forEach>

  <c:if test="${currentUser.isDoctor()}">
    <table border="2">
    <form action = "/createVisit" method="get">
      <tr >
        <input type="hidden" name="patientId" value="${patient.getId()}">
        <td>�������� �����</td>
        <td><input type="image" src="/Views/Images/add.png"></td>
      </tr>
    </form>
    </table>
  </c:if>
</body>
</html>

