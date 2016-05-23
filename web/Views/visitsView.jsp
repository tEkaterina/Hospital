<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="content col-sm-offset-1 col-sm-10">
  <c:if test="${patient != null}">
    <div class="row">
      <div class="col-sm-8 text-center">
        <label class="form-title">Список визитов пациента: <strong style="color: crimson">${patient.getName()} ${patient.getSurname()}</strong></label>
      </div>
    </div>
  </c:if>
  <div class="row">
    <c:forEach items = "${visits}" var="visit" varStatus="status">
      <%@include file="Partial/visitView.jsp"%>
    </c:forEach>
  </div>
  <%@include file="Partial/visitForm.jsp"%>
</div>
