<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>Добавление нового анализа</title>
</head>
<body>

<table border ="1">
  <form action = "/createAnalyz" method="POST">
    <table border ="1">
      <tr>
        <td><input type="text" name="hbA1c" placeholder="Уровень hbA1c"></td>
      </tr>
      <tr>
        <td><input type="text" name="cholesterol" placeholder="Общий холестерин "></td>
      </tr>
      <tr>
        <td><input  type="text" name="triglycerides" placeholder="Триглицериды"></td>
      </tr>
    </table>
    <input type="hidden" name="visitId" value="${visitId}">
    <input type="submit" value="Добавить">
  </form>
</table>
</body>
</html>

