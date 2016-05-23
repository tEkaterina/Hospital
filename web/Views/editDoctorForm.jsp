<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="content col-sm-offset-3 col-sm-6">
  <div style="text-align: center;">
    <label class="form-title">Измените необходимые данные для врача</label>
  </div>
  <form class="form-horizontal" action = "/updateDoctor" method="post">
    <input type="hidden" name="id" value="${doctor.getId()}">
    <%@include file="Partial/doctorForm.jsp"%>
  </form>
</div>

