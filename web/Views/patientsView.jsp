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
    <th>Delete</th>
    <th>Edit</th>
  </tr>
  <c:forEach items = "${patients}" var="patient">
    <tr>
      <td>${patient.getName()}</td>
      <td>${patient.getSurname()}</td>
      <td>${patient.getClinicNumber()}</td>

      <td>${patient.getAddress().getStreet()}</td>
      <td>${patient.getAddress().getHouse()}</td>
      <td>${patient.getAddress().getHousing()}</td>
      <td>${patient.getAddress().getApartment()}</td>
      <td>
        <form action = "/visits" method="get">
          <input type="hidden" name="id" value="${patient.getId()}">
          <input type="submit" value="Visits">
        </form>
      </td>

      <td>
        <form action = "/delete" method="get">
          <input type="hidden" name="id" value="${patient.getId()}">
          <input type="image" src="/Views/Images/remove.png">
        </form>
      </td>

      <td>
        <form action = "/edit" method="get">
          <input type="hidden" name="id" value="${patient.getId()}">
          <input type="image" src="/Views/Images/edit.png">
        </form>
      </td>
    </tr>
  </c:forEach>

  <form action = "/add" method="post">
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

