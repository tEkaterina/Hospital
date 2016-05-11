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
    <th>Email</th>
  </tr>
  <c:forEach items = "${users}" var="users">
    <tr>
      <td><c:out value="${doctor.getName()}"/></td>
      <td><c:out value="${doctor.getSurname()}"/></td>
      <td><c:out value="${doctor.getCategory()}"/></td>
      <td><c:out value="${doctor.getSpeciality().getName()}"/></td>
      <td><c:out value="${doctor.getTelephone()}"/></td>
      <td><c:out value="${}"/></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>

