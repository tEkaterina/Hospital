<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<c:if test="${currentUser.isAdmin()}">
  <div class="col-md-4">
    <div class="panel panel-info" style="margin-top: 20px;">
      <div class="panel-heading" style="height: 50px !important;">
        <label style="vertical-align: bottom"><c:out value="${doctor.getName()}"/> <c:out value="${doctor.getSurname()}"/></label>
        <span class="pull-right">
          <form class="tool-form" action = "/updateDoctor" method="get">
            <button type="submit" class="btn btn-default btn-sm tool">
            <i class="fa fa-pencil tool-icon"></i>Редактировать</button>
            <input type="hidden" name="id" value="${patient.getId()}">
          </form>
          <form id="${patient.getId()}Delete" class="tool-form" action = "/deleteDoctor" method="get">
            <input type="hidden" name="id" value="${patient.getId()}">
            <input type="hidden" name="addressId" value="${patient.getAddress().getId()}">
            <button type="submit" class="btn btn-default btn-sm tool">
              <i class="fa fa-user-times" aria-hidden="true"></i>Удалить
            </button>
          </form>
        </span>
      </div>
      <div class="panel-body" style="padding: 0 !important;">
        <table class="table table-striped table-bordered" style="margin: 0 !important;">
          <tr>
            <td><i class="fa fa-graduation-cap" aria-hidden="true"></i></td>
            <td>Категория</td>
            <td><c:out value="${doctor.getCategory()}"/></td>
          </tr>
          <tr>
            <td><i class="fa fa-user-md" aria-hidden="true"></i></td>
            <td>Специальность</td>
            <td><c:out value="${doctor.getSpeciality().getName()}"/></td>
          </tr>
          <tr>
            <td><i class="fa fa-phone" aria-hidden="true"></i></td>
            <td>Телефон</td>
            <td><c:out value="${doctor.getTelephone()}"/></td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</c:if>

