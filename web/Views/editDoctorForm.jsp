<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>Edit doctor</title>
</head>
<body>

<table border ="1">
  <form action = "/updateDoctor" method="POST">
    <table border ="1">
      <tr>
        <th>Name</th>
        <td><input type="text" name="name" value="<c:out value="${doctor.getName()}"/>"></td>
      </tr>
      <tr>
        <th>Surname</th>
        <td><input type="text" name="surname" value="<c:out value="${doctor.getSurname()}"/>"></td>
      </tr>
      <tr>
        <th>Category</th> <!--TODO add in category and speciality select checked value -->
        <td><select name="category">
          <option><c:out value="Первая"/></option>
          <option><c:out value="Вторая"/></option>
          <option><c:out value="Высшая"/></option>
        </select>
        </td>
      </tr>
      <tr>
        <th>Speciality</th>
        <td><select name="specialities">
          <c:forEach items = "${specialities}" var="speciality">
            <option><c:out value="${speciality.getName()}"/></option>
          </c:forEach>
        </select>
        </td>
      </tr>
      <tr>
        <th>Telephone</th>
        <td><input type="text" name="phone" value="<c:out value="${doctor.getTelephone()}"/>"></td>
      </tr>
    </table>
    <input type="hidden" name="id" value="${doctor.getId()}">
    <input type="submit" value="Save changes">
  </form>
</table>
</body>
</html>

