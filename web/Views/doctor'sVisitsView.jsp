<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>Список визитов</title>
</head>
<body>
<c:forEach items = "${visits}" var="visit" varStatus="status">
  <table border ="1">
    <tr>Визит №${status.getIndex()+1}</tr>
    <tr>
      <th>Пациент</th>
      <td><c:out value="${visit.getPatient().getName()} ${visit.getPatient().getSurname()}"/></td>
    </tr>
    <tr>
      <th>Дата</th>
      <td><c:out value="${visit.getDate()}"/></td>
    </tr>
    <tr>
      <th>Комментарий</th>
      <td><c:out value="${visit.getComment()}"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <form action = "/analyzes" method="get">
          <input type="hidden" name="id" value="${visit.getId()}">
          <input type="submit" value="Просмотр списка анализов">
        </form>
      </td>
    </tr>
    <tr>
      <td>
        <form action = "/deleteVisit" method="get">
          <input type="hidden" name="id" value="${visit.getId()}">
          <input type="image" src="/Views/Images/remove.png">
        </form>
      </td>
      <td>
        <form action = "/updateVisit" method="get">
          <input type="hidden" name="id" value="${visit.getId()}">
          <input type="image" src="/Views/Images/edit.png">
        </form>
      </td>
    </tr>

  </table>
</c:forEach>
</body>
</html>

