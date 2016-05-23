<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="col-md-6">
  <div class="panel panel-info" style="margin-top: 20px;">
    <div class="panel-heading" style="height: 50px !important;">
      <label style="vertical-align: bottom">������ �${status.getIndex()+1}
        <span class="pull-right">
          <c:if test="${currentUser.isAdmin() ||currentUser.getDoctor().getId()==visit.getDoctor().getId()}">
            <form class="tool-form" action = "/updateAnalyz" method="get">
              <button type="submit" class="btn btn-default btn-sm tool">
                <i class="fa fa-pencil tool-icon"></i>�������������
              </button>
              <input type="hidden" name="id" value="${analyz.getId()}">
              <input type="hidden" name="visitId" value="${visit.getId()}">
            </form>

            <form class="tool-form" action = "/deleteAnalyzes" method="get">
              <input type="hidden" name="id" value="${analyz.getId()}">
              <input type="hidden" name="visitId" value="${visit.getId()}">
              <button type="submit" class="btn btn-default btn-sm tool">
                <i class="fa fa-user-times" aria-hidden="true"></i>�������
              </button>
            </form>
          </c:if>
        </span>
      </label>
    </div>
    <div class="panel-body" style="padding: 0 !important;">
      <table class="table table-striped table-bordered" style="margin: 0 !important;">
        <tr>
          <td><i class="fa fa-calendar" aria-hidden="true"></i>   ����</td>
          <td></td>
          <td><c:out value="${analyz.getDate()}"/></td>
        </tr>
        <tr>
          <td>������� hbA1c</td>
          <td><c:out value="${analyz.getHbA1c()}"/></td>
          <td><i class="fa fa-percent" aria-hidden="true"></i></td>
        </tr>
        <tr>
          <td>����� ����������</td>
          <td>${analyz.getTotalCholesterol()}</td>
          <td><i class="fa" aria-hidden="true">�����/�</i></td>
        </tr>
        <tr>
          <td>������������</td>
          <td><c:out value="${analyz.getTriglycerides()}"/></td>
          <td><i class="fa" aria-hidden="true">�����/�</i></td>
        </tr>
      </table>
    </div>
  </div>
</div>