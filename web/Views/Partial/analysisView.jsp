<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="col-sm-6">
  <div class="table-responsive">
    <table class="table table-striped table-bordered">
      <tr>������ �${status.getIndex()+1}</tr>
      <tr>
        <th>����</th>
        <td><c:out value="${analyz.getDate()}"/></td>
      </tr>
      <tr>
        <th>������� hbA1c</th>
        <td><c:out value="${analyz.getHbA1c()}%"/></td>
      </tr>
      <tr>
        <th>����� ����������</th>
        <td><c:out value="${analyz.getTotalCholesterol()} �����/�."/></td>
      </tr>
      <tr>
        <th>������������</th>
        <td><c:out value="${analyz.getTriglycerides()} �����/�."/></td>
      </tr>

      <c:if test="${currentUser.isAdmin() ||currentUser.getDoctor().getId()==visit.getDoctor().getId()}">
        <tr>
          <td>
            <form action = "/deleteAnalyzes" method="get">
              <input type="hidden" name="id" value="${analyz.getId()}">
              <input type="image" src="/Views/Images/remove.png">
            </form>
          </td>
          <td>
            <form action = "/updateAnalyz" method="get">
              <input type="hidden" name="id" value="${analyz.getId()}">
              <input type="hidden" name="visitId" value="${visit.getId()}">
              <input type="image" src="/Views/Images/edit.png">
            </form>
          </td>
        </tr>
      </c:if>
    </table>
  </div>
</div>