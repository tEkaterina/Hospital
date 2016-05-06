<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit patient</title>
</head>
<body>

<table border ="1">
<form action = "/editPatient" method="POST">
  <input type="hidden" name="action" value="edit">
  <table border ="1">
    <tr>
      <th>Name</th>
      <td><input type="text" name="name" value="<c:out value="${patient.getName()}"/>"></td>
    </tr>
    <tr>
      <th>Surname</th>
      <td><input type="text" name="surname" value="<c:out value="${patient.getSurname()}"/>"></td>
    </tr>
    <tr>
      <th>Clinic</th>
      <td><input type="text" name="clinic" value="<c:out value="${patient.getClinicNumber()}"/>"></td>
    </tr>
    <tr>
      <th>Street</th>
      <td><input  type="text" name="street" value="<c:out value="${patient.getAddress().getStreet()}"/>"></td>
    </tr>
    <tr>
      <th>House</th>
      <td><input  type="text" name="house"value="<c:out value="${patient.getAddress().getHouse()}"/>"></td>
    </tr>
    <tr>
      <th>Housing</th>
      <td><input  type="text" name="housing"value="<c:out value="${patient.getAddress().getHousing()}"/>"></td>
    </tr>
    <tr>
      <th>Apartment</th>
      <td><input  type="text" name="apartment"value="<c:out value="${patient.getAddress().getApartment()}"/>"></td>
    </tr>
  </table>
  <input type="hidden" name="id" value="${patient.getId()}">
  <input type="submit" value="Save changes">
</form>
</table>
</body>
</html>

