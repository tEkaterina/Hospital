<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="row">
  <div class="col-sm-offset-4 col-sm-4 content">
    <form action = "/updateAnalyz" method="POST">
      <%@include file="Partial/analysisForm.jsp"%>
      <button type="submit" class="btn btn-success blue">Сохранить</button>
    </form>
  </div>
</div>
