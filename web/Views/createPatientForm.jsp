<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>���������� ������ ��������</title>
</head>
<body>

<table border ="1">
  <form action = "/createPatient" method="POST">
    <input type="hidden" name="action" value="edit">
    <table border ="1">
      <tr>
        <td><input type="text" name="name" placeholder="���"></td>
      </tr>
      <tr>
        <td><input type="text" name="surname" placeholder="�������"></td>
      </tr>
      <tr>
        <td><input type="text" name="clinic" placeholder="� �������"></td>
      </tr>
      <tr>
        <td><input  type="text" name="street" placeholder="�����"></td>
      </tr>
      <tr>
        <td><input  type="text" name="house" placeholder="���"></td>
      </tr>
      <tr>
        <td><input  type="text" name="housing" placeholder="������"></td>
      </tr>
      <tr>
        <td><input  type="text" name="apartment" placeholder="��������"></td>
      </tr>
    </table>
    <input type="hidden" name="id" value="${patient.getId()}">
    <input type="submit" value="��������">
  </form>
</table>
</body>
</html>

