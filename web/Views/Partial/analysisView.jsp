<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="col-sm-6">
  <div class="table-responsive">
    <table class="table table-striped table-bordered">
      <tr>Анализ №${status.getIndex()+1}</tr>
      <tr>
        <th>Дата</th>
        <td><c:out value="${analyz.getDate()}"/></td>
      </tr>
      <tr>
        <th>Уровень hbA1c</th>
        <td><c:out value="${analyz.getHbA1c()}%"/></td>
      </tr>
      <tr>
        <th>Общий холестерин</th>
        <td><c:out value="${analyz.getTotalCholesterol()} ммоль/л."/></td>
      </tr>
      <tr>
        <th>Триглицериды</th>
        <td><c:out value="${analyz.getTriglycerides()} ммоль/л."/></td>
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