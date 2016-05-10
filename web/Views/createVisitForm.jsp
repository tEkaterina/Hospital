<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>Добавление визита</title>
</head>
<body>
<table border ="1">
  <form action = "/createVisit" method="POST">
    <table border ="1">
      <tr>
        <th>Комментарий</th>
        <td><input type="text" name="comment" placeholder="Введите комментарий"></td>
      </tr>
    </table>
    <input type="hidden" name="patientId" value="${patientId}">
    <input type="submit" value="Сохранить">
  </form>
</table>
</body>
</html>