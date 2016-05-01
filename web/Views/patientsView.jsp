<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Patients</title>
</head>
<body>

<table border ="1">
  <tr>
    <th>Name</th>
    <th>Surname</th>
    <th>Clinic number</th>
    <th>Street</th>
    <th>House</th>
    <th>Housing</th>
    <th>Apartment</th>
    <th>Visits</th>
    <th>Delete</th>
    <th>Edit</th>
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
        <form action = "/visits" method="get">
          <input type="hidden" name="id" value="${patient.getId()}">
          <input type="submit" value="Visits">
        </form>
      </td>

      <td>
        <form action = "/deletePatient" method="get">
          <input type="hidden" name="id" value="${patient.getId()}">
          <input type="image" src="/Views/Images/remove.png">
        </form>
      </td>

      <td>
        <form action = "/editPatient" method="get">
          <input type="hidden" name="id" value="${patient.getId()}">
          <input type="image" src="/Views/Images/edit.png">
        </form>
      </td>
    </tr>
  </c:forEach>

  <form action = "/addPatient" method="post">
    <tr>
      <td><input  type="text" name="name"></td>
      <td><input  type="text" name="surname"></td>
      <td><input  type="text" name="clinic"></td>
      <td><input  type="text" name="street"></td>
      <td><input  type="text" name="house"></td>
      <td><input  type="text" name="housing"></td>
      <td><input  type="text" name="apartment"></td>
      <td>
        <input type="image" src="/Views/Images/add.png">
      </td>
    </tr>
  </form>
</table>

</body>
</html>

