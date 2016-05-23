<%@ page import="hospital.models.Doctor" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="form-group inner-addon left-addon">
  <i class="fa fa-user" aria-hidden="true"></i>
  <input class="form-control" type="text" name="name" placeholder="Имя" value="${doctor.getName()}">
</div>
<div class="form-group inner-addon left-addon">
  <i class="fa fa-user" aria-hidden="true"></i>
  <input class="form-control" type="text" name="surname" placeholder="Фамилия" value="${doctor.getSurname()}">
</div>
<div class="form-group">
  <label class="control-label col-sm-3">Категория</label>
  <div class="col-sm-9">
    <div class="inner-addon left-addon">
      <c:set var="enumValues" value="<%=Doctor.Category.values()%>"/>
      <i class="fa fa-graduation-cap" aria-hidden="true"></i>
      <select class="form-control" name="category">
        <c:if test="${doctor != null}">
          <option value="${doctor.getCategory().toString()}" selected>${doctor.getCategory().toString()}</option>
        </c:if>
        <c:forEach items="${enumValues}" var="enumValue">
          <c:if test="${doctor == null || !doctor.getCategory().equals(enumValue)}">
            <option><c:out value="${enumValue.toString()}"/></option>
          </c:if>
        </c:forEach>
      </select>
    </div>
  </div>
</div>
<div class="form-group">
  <label class="control-label col-sm-3">Специальность</label>
  <div class="col-sm-9">
    <div class="inner-addon left-addon">
      <i class="fa fa-user-md" aria-hidden="true"></i>
      <select class="form-control" name="specialities">
        <c:if test="${doctor != null}">
          <option value="${doctor.getSpeciality().getName()}" selected>${doctor.getSpeciality().getName()}</option>
        </c:if>
        <c:forEach items = "${specialities}" var="speciality">
          <c:if test="${doctor == null || !doctor.getSpeciality().equals(speciality)}">
            <option><c:out value="${speciality.getName()}"/></option>
          </c:if>
        </c:forEach>
      </select>
    </div>
  </div>
</div>
<div class="form-group inner-addon left-addon">
  <i class="fa fa-phone" aria-hidden="true"></i>
  <input class="form-control" type="text" name="phone" placeholder="Телефон" value="${doctor.getTelephone()}">
</div>
<%@include file="userForm.jsp"%>