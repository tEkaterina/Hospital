<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="content col-sm-offset-3 col-sm-6">
  <div style="text-align: center;">
    <label class="form-title">¬ведите данные дл€ нового врача</label>
  </div>
  <form class="form-horizontal" action = "/addNewDoctor" method="post">
    <%@include file="Partial/doctorForm.jsp"%>
  </form>
</div>