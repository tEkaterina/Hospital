<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>Doctors</title>
</head>
<body>

<table border ="1">
  <tr>
    <th>Name</th>
    <th>Surname</th>
    <th>Category</th>
    <th>Speciality</th>
    <th>Telephone</th>
    <th>Delete</th>
    <th>Edit</th>
  </tr>
  <c:forEach items = "${doctors}" var="doctor">
    <tr>
      <td><c:out value="${doctor.getName()}"/></td>
      <td><c:out value="${doctor.getSurname()}"/></td>
      <td><c:out value="${doctor.getCategory()}"/></td>
      <td><c:out value="${doctor.getSpeciality().getName()}"/></td>
      <td><c:out value="${doctor.getTelephone()}"/></td>

      <td>
        <form action = "/deleteDoctor" method="get">
          <input type="hidden" name="id" value="${doctor.getId()}">
          <input type="image" src="/Views/Images/remove.png">
        </form>
      </td>

      <td>
        <form action = "/updateDoctor" method="get">
          <input type="hidden" name="id" value="${doctor.getId()}">
          <input type="image" src="/Views/Images/edit.png">
        </form>
      </td>
    </tr>
  </c:forEach>
  <form action = "/updateDoctor" method="get">
    <tr >
      <input type="hidden" name="id" value="0">
      <td colspan="6">Add</td>
      <td><input type="image" src="/Views/Images/add.png"></td>
    </tr>
  </form>
</table>

</body>
</html>

