<%@ page import="hospital.models.Doctor" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="form-group inner-addon left-addon">
  <i class="fa fa-user" aria-hidden="true"></i>
  <input class="form-control" type="text" name="name" placeholder="Имя">
</div>
<div class="form-group inner-addon left-addon">
  <i class="fa fa-user" aria-hidden="true"></i>
  <input class="form-control" type="text" name="surname" placeholder="Фамилия">
</div>
<div class="form-group">
  <label class="control-label col-sm-3">Категория</label>
  <div class="col-sm-9">
    <div class="inner-addon left-addon">
      <c:set var="enumValues" value="<%=Doctor.Category.values()%>"/>
      <i class="fa fa-graduation-cap" aria-hidden="true"></i>
      <select class="form-control" name="category">
        <c:forEach items="${enumValues}" var="enumValue">
          <option><c:out value="${enumValue.toString()}"/></option>
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
        <c:forEach items = "${specialities}" var="speciality">
          <option><c:out value="${speciality.getName()}"/></option>
        </c:forEach>
      </select>
    </div>
  </div>
</div>
<div class="form-group inner-addon left-addon">
  <i class="fa fa-phone" aria-hidden="true"></i>
  <input class="form-control" type="text" name="phone" placeholder="Телефон">
</div>
<%@include file="userForm.jsp"%>