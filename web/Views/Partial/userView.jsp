<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="col-md-4">
  <div class="panel panel-info" style="margin-top: 20px;">
    <div class="panel-heading" style="height: 50px !important;">
      <label style="vertical-align: bottom"><c:out value="${user.getEmail()}"/>
        <c:if test="${user.getActivity() && currentUser.getId()!=user.getId()}">
            <span class="pull-right" style="margin-left: 12px;">
                <form class="tool-form" action = "/block" method="POST">
                  <input type="hidden" name="id" value="${user.getId()}">
                  <button type="submit" class="btn btn-default btn-sm tool">
                    <i class="fa fa-ban" aria-hidden="true"></i>Заблокировать
                  </button>
                </form>
            </span>
        </c:if>
        <c:if test="${!user.getActivity() && currentUser.getId()!=user.getId()}">
            <span class="pull-right" style="margin-left: 12px;">
                <form class="tool-form" action = "/block" method="POST">
                  <input type="hidden" name="id" value="${user.getId()}">
                  <button type="submit" class="btn btn-default btn-sm tool">
                    <i class="fa fa-check" aria-hidden="true"></i>Разблокировать
                  </button>
                </form>
            </span>
        </c:if>
      </label>
    </div>
    <div class="panel-body" style="padding: 0 !important;">
      <table class="table table-striped table-bordered" style="margin: 0 !important;">
        <tr>
          <td><i class="fa fa-user-secret" aria-hidden="true"></i></td>
          <td>Роль</td>
          <td><c:out value="${user.getRoleName()}"/></td>
        </tr>
        <tr>
          <td><i class="fa fa-gavel" aria-hidden="true"></i></td>
          <td>Имеет доступ к системе</td>
          <td><c:out value="${user.getActivity()}"/></td>
        </tr>
      </table>
    </div>
  </div>
</div>