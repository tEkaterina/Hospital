<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<form class="form-horizontal" action = "/createVisit" method="POST">
  <input type="text" name="comment" placeholder="Введите комментарий">
  <input type="hidden" name="patientId" value="${patientId}">
  <input type="submit" value="Сохранить">
</form>