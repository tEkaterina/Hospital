<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>�������������� ���������� �� �������</title>
</head>
<body>
<table border ="1">
  <form action = "/updateAnalyz" method="POST">
    <table border ="1">
      <tr>
        <th>������� hbA1c</th>
        <td><input type="text" name="hbA1c" value="<c:out value="${analyz.getHbA1c()}"/>"></td>
      </tr>
      <tr>
        <th>����� ����������</th>
        <td><input type="text" name="cholesterol" value="<c:out value="${analyz.getTotalCholesterol()}"/>"></td>
      </tr>
      <tr>
        <th>������������</th>
        <td><input  type="text" name="triglycerides" value="<c:out value="${analyz.getTriglycerides()}"/>"></td>
      </tr>
    </table>
    <input type="hidden" name="id" value="${analyz.getId()}">
    <input type="hidden" name="visitId" value="${visitId}">
    <input type="submit" value="���������">
  </form>
</table>
</body>
</html>

