<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>������ ���������</title>
</head>
<body>
<c:out value="${currentUser.getRoleName()}"/>
<table border ="1">
  <tr>
    <th>���</th>
    <th>�������</th>
    <th>� ���������</th>
    <th>�����</th>
    <th>���</th>
    <th>������</th>
    <th>��������</th>
    <th>������</th>
    <th>�������</th>
    <th>��������</th>
  </tr>
  <c:forEach items = "${patients}" var="patient">
    <tr>
      <td><c:out value="${patient.getName()}"/></td>
      <td><c:out value="${patient.getSurname()}"/></td>
      <td><c:out value="${patient.getClinicNumber()}"/></td>

      <td><c:out value="${patient.getAddress().getStreet()}"/></td>
      <td><c:out value="${patient.getAddress().getHouse()}"/></td>
      <td><c:out value="${patient.getAddress().getHousing()}"/></td>
      <td><c:out value="${patient.getAddress().getApartment()}"/></td>
      <td>
        <form action = "/patientVisits" method="get">
          <input type="hidden" name="idPatient" value="${patient.getId()}">
          <input type="submit" value="������� ������ �������">
        </form>
      </td>

      <td>
        <form action = "/deletePatient" method="get">
          <input type="hidden" name="id" value="${patient.getId()}">
          <input type="image" src="/Views/Images/remove.png">
        </form>
      </td>

      <td>
        <form action = "/updatePatient" method="get">
          <input type="hidden" name="id" value="${patient.getId()}">
          <input type="image" src="/Views/Images/edit.png">
        </form>
      </td>
    </tr>
  </c:forEach>
  <form action = "/createPatient" method="get">
    <tr >
      <input type="hidden" name="id" value="0">
      <td colspan="9">������� ��������</td>
      <td><input type="image" src="/Views/Images/add.png"></td>
    </tr>
  </form>
</table>

</body>
</html>

