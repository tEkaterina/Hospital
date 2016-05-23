<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="row">
    <c:if test="${currentUser.getDoctor().getId()==visit.getDoctor().getId()}">
        <form class="form-inline" action = "/createAnalyz" method="get">
            <div class="form-group">
                <button type="submit" class="btn btn-success blue">Добавить новый анализ</button>
                <input type="hidden" name="visitId" value="${visit.getId()}">
            </div>
        </form>
    </c:if>
  <c:forEach items = "${analyzes}" var="analyz" varStatus="status">
  <%@ include file="Partial/analysisView.jsp"%>
  </c:forEach>
</div>