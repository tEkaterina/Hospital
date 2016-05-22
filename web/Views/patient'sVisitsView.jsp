<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="content col-sm-10 col-sm-offset-1">
  <label class="form-title">Список визитов пациента: ${patient.getName()} ${patient.getSurname()} </label>
  <c:forEach items = "${visits}" var="visit" varStatus="status">
    <%@include file="Partial/visitView.jsp"%>
  </c:forEach>
  <c:if test="${currentUser.isDoctor()}">
    <table border="2">
    <form action = "/createVisit" method="get">
      <tr >
        <input type="hidden" name="patientId" value="${patient.getId()}">
        <td>Добавить визит</td>
        <td><input type="image" src="/Views/Images/add.png"></td>
      </tr>
    </form>
    </table>
  </c:if>
</div>

