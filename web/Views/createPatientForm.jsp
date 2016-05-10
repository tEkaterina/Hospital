<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>Добавление нового пациента</title>
</head>
<body>

<table border ="1">
  <form action = "/createPatient" method="POST">
    <input type="hidden" name="action" value="edit">
    <table border ="1">
      <tr>
        <td><input type="text" name="name" placeholder="Имя"></td>
      </tr>
      <tr>
        <td><input type="text" name="surname" placeholder="Фамилия"></td>
      </tr>
      <tr>
        <td><input type="text" name="clinic" placeholder="№ клиники"></td>
      </tr>
      <tr>
        <td><input  type="text" name="street" placeholder="Улица"></td>
      </tr>
      <tr>
        <td><input  type="text" name="house" placeholder="Дом"></td>
      </tr>
      <tr>
        <td><input  type="text" name="housing" placeholder="Корпус"></td>
      </tr>
      <tr>
        <td><input  type="text" name="apartment" placeholder="Квартира"></td>
      </tr>
    </table>
    <input type="hidden" name="id" value="${patient.getId()}">
    <input type="submit" value="Добавить">
  </form>
</table>
</body>
</html>

