<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>�������������� ���������� � ������</title>
</head>
<body>
<table border ="1">
  <form action = "/updateVisit" method="POST">
    <table border ="1">
      <tr>
        <th>�����������</th>
        <td><input type="text" name="comment" value="<c:out value="${visit.getComment()}"/>"></td>
      </tr>
    </table>
    <input type="hidden" name="id" value="${visit.getId()}">
    <input type="submit" value="���������">
  </form>
</table>
</body>
</html>

