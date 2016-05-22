<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="col-md-4">
  <div class="panel panel-info" style="margin-top: 20px;">
    <div class="panel-heading" style="height: 50px !important;">
      <label style="vertical-align: bottom">Визит №${status.getIndex()+1}
        <span class="pull-right">
          <c:if test="${currentUser.isAdmin() ||currentUser.getDoctor().getId()==visit.getDoctor().getId()}">
          <form class="tool-form" action = "/updateVisit" method="get">
            <button type="submit" class="btn btn-default btn-sm tool">
              <i class="fa fa-pencil tool-icon"></i>Редактировать</button>
            <input type="hidden" name="id" value="${visit.getId()}">
          </form>
          <form id="${patient.getId()}Delete" class="tool-form" action = "/deleteVisit" method="get">
            <input type="hidden" name="id" value="${visit.getId()}">
            <button type="submit" class="btn btn-default btn-sm tool">
              <i class="fa fa-user-times" aria-hidden="true"></i>Удалить
            </button>
          </form>
          </c:if>
        </span>
      </label>
    </div>
    <div class="panel-body" style="padding: 0 !important;">
      <table class="table table-striped table-bordered" style="margin: 0 !important;">
        <tr>
          <td><i class="fa fa-calendar" aria-hidden="true"></i> </td>
          <td>Дата</td>
          <td><c:out value="${visit.getDate()}"/></td>
        </tr>
        <tr>
          <td><i class="fa fa-comment" aria-hidden="true"></i></td>
          <td>Комментарий</td>
          <td><c:out value="${visit.getComment()}"/></td>
        </tr>
        <tr>
          <td><i class="fa fa-user" aria-hidden="true"></i></td>
          <td>ФИО врача</td>
          <td><c:out value="${visit.getDoctor().getName()} ${visit.getDoctor().getSurname()} "/></td>
        </tr>
        <tr>
          <td><i class="fa fa-list-alt" aria-hidden="true"></i></td>
          <td></td>
          <td>
            <form action = "/analyzes" method="get">
              <input type="hidden" name="id" value="${visit.getId()}">
              <input type="submit" value="Просмотр списка анализов">
            </form>
          </td>
        </tr>
      </table>
    </div>
  </div>
</div>