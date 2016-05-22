<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java"%>
<div class="row">
  <c:forEach items = "${patients}" var="patient">
    <%@include file="Partial/patientView.jsp"%>
  </c:forEach>
</div>