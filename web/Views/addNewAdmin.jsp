<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="content col-sm-6 col-sm-offset-3">
  <div style="text-align: center;">
    <label class="form-title">Новый администратор</label>
  </div>
  <form class="form-horizontal" action="/addNewAdmin" method="post">
    <%@include  file="Partial/userForm.jsp" %>
  </form>
</div>