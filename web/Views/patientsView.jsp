<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>Список пациентов</title>
</head>
<body>
<c:out value="${currentUser.getRoleName()}"/>
<table border ="1">
  <tr>
    <th>Имя</th>
    <th>Фамилия</th>
    <th>№ клининики</th>
    <th>Улица</th>
    <th>Дом</th>
    <th>Корпус</th>
    <th>Квартира</th>
    <th>Визиты</th>
    <c:if test="${currentUser.isAdmin()}">
      <th>Удалить</th>
      <th>Изменить</th>
    </c:if>
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
          <input type="submit" value="Открыть список визитов">
        </form>
      </td>
      <c:if test="${currentUser.isAdmin()}">
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
      </c:if>
    </tr>
  </c:forEach>
  <c:if test="${currentUser.isAdmin()}">
    <form action = "/createPatient" method="get">
      <tr >
        <input type="hidden" name="id" value="0">
        <td colspan="9">Создать пациента</td>
        <td><input type="image" src="/Views/Images/add.png"></td>
      </tr>
    </form>
  </c:if>
</table>

</body>
</html>

