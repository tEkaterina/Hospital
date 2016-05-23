<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="content col-sm-offset-4 col-sm-4">
  <div class="text-center">
    <label class="form-title">Новый анализ</label>
  </div>
  <form class="form-horizontal" action = "/createAnalyz" method="POST">
    <%@include file="Partial/analysisForm.jsp"%>
    <div class="form-group text-center">
      <button class="btn btn-success blue" type="submit">Добавить</button>
    </div>
  </form>
</div>