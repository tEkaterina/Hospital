<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>���������� ������</title>
</head>
<body>
<table border ="1">
  <form action = "/createVisit" method="POST">
    <table border ="1">
      <tr>
        <th>�����������</th>
        <td><input type="text" name="comment" placeholder="������� �����������"></td>
      </tr>
    </table>
    <input type="hidden" name="patientId" value="${patientId}">
    <input type="submit" value="���������">
  </form>
</table>
</body>
</html>