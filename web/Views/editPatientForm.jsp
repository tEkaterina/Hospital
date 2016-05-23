<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="content col-sm-6 col-sm-offset-3">
  <div style="text-align: center;">
    <label class="form-title">¬ведите информацию о новом пациенте</label>
  </div>
  <form class="form-horizontal" action="/updatePatient" method="POST">
    <input type="hidden" name="id" value="${patient.getId()}">
    <input type="hidden" name="addressId" value="${patient.getAddress().getId()}">
    <%@include file="Partial/patientForm.jsp"%>
    <div class="form-group" style="text-align: center;">
      <input type="hidden" name="id" value="${patient.getId()}">
      <input type="submit" class="btn btn-success blue" value="—охранить">
    </div>
  </form>
</div>

