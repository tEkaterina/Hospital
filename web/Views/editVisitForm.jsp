<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="row">
  <div class="content col-sm-offset-2 col-sm-8">
    <div class="text-center"><label class="form-title">Комментарий для визита</label></div>
    <form action = "/updateVisit" method="POST">
      <%@include file="Partial/visitForm.jsp"%>
      <input type="hidden" name="id" value="${visit.getId()}">
      <input type="hidden" name="patientId" value="${visit.getPatient().getId()}">
      <div class="form-group text-center">
        <input class="btn btn-success blue" type="submit" value="Сохранить">
      </div>
    </form>
  </div>
</div>