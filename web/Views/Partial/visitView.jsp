<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="col-md-6">
  <div class="panel panel-info" style="margin-top: 20px;">
    <div class="panel-heading" style="height: 50px !important;">
      <label style="vertical-align: bottom">Визит №${status.getIndex()+1}
        <span class="pull-right">
          <c:if test="${currentUser.isAdmin() ||currentUser.getDoctor().getId()==visit.getDoctor().getId()}">
            <form class="tool-form" action = "/updateVisit" method="get">
              <button type="submit" class="btn btn-default btn-sm tool">
                <i class="fa fa-pencil tool-icon"></i>Редактировать
              </button>
              <input type="hidden" name="id" value="${visit.getId()}">
              <c:if test="${patient != null}">
                <input type="hidden" name="patientId" value="${patient.getId()}">
              </c:if>
            </form>

            <form class="tool-form" action = "/deleteVisit" method="get">
              <input type="hidden" name="id" value="${visit.getId()}">
              <button type="submit" class="btn btn-default btn-sm tool">
                <i class="fa fa-user-times" aria-hidden="true"></i>Удалить
              </button>
              <c:if test="${patient != null}">
                <input type="hidden" name="patientId" value="${patient.getId()}">
              </c:if>
            </form>
          </c:if>
        </span>
      </label>
    </div>
    <div class="panel-body" style="padding: 0 !important;">
      <table class="table table-striped table-bordered" style="margin: 0 !important;">
        <c:if test="${patient == null}">
          <tr>
            <td><i class="fa fa-user"></i></td>
            <td>Пациент</td>
            <td><label><c:out value="${visit.getPatient().getName()}"/> <c:out value="${visit.getPatient().getSurname()}"/></label></td>
          </tr>
        </c:if>
        <tr>
          <td><i class="fa fa-calendar" aria-hidden="true"></i> </td>
          <td>Дата</td>
          <td><c:out value="${visit.getDate()}"/></td>
        </tr>
        <tr>
          <td><i class="fa fa-comment" aria-hidden="true"></i></td>
          <td>Комментарий</td>
          <td>
            <textarea cols="40" rows="5" class="description" readonly><c:out value="${visit.getComment()}"/></textarea>
          </td>
        </tr>
        <tr>
          <td><i class="fa fa-user-md" aria-hidden="true"></i></td>
          <td>Врач</td>
          <td><c:out value="${visit.getDoctor().getName()} ${visit.getDoctor().getSurname()} "/></td>
        </tr>
        <tr>
          <td><i class="fa fa-list-alt" aria-hidden="true"></i></td>
          <td></td>
          <td>
            <form action = "/analyzes" method="get">
              <input type="hidden" name="id" value="${visit.getId()}">
              <input type="submit" class="btn btn-success blue" value="Просмотр списка анализов">
            </form>
          </td>
        </tr>
      </table>
    </div>
  </div>
</div>