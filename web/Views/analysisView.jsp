<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
  <div style="text-align: center;">
    <label class="form-title">Список анализов</label>
  </div>
  <c:forEach items = "${analyzes}" var="analyz" varStatus="status">
    <%@ include file="Partial/analysisView.jsp"%>
  </c:forEach>
  <c:if test="${currentUser.getDoctor().getId()==visit.getDoctor().getId()}">
    <table border="2">
      <form action = "/createAnalyz" method="get">
        <tr >
          <td>Добавить анализ</td>
          <td><input type="image" src="/Views/Images/add.png"></td>
          <input type="hidden" name="visitId" value="${visit.getId()}">
        </tr>
      </form>
    </table>
  </c:if>
</div>