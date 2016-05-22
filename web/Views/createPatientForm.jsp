<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="content col-sm-6 col-sm-offset-3">
    <div style="text-align: center;">
        <label class="form-title">Введите информацию о новом пациенте</label>
    </div>
    <form class="form-horizontal" action="/createPatient" method="POST">
        <%@include file="Partial/patientForm.jsp"%>
        <div class="form-group" style="text-align: center;">
            <input type="hidden" name="id" value="${patient.getId()}">
            <input type="submit" class="btn btn-success blue" value="Добавить">
        </div>
    </form>
</div>