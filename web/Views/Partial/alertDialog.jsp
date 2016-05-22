<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="row">
  <div class="col-sm-6 col-sm-offset-3" style="margin-top: 30px;">
    <c:if test="${message != null && messageStatus != null}">
      <div class="alert <c:out value="${messageStatus.equals('success') ? 'alert-success' : 'alert-danger'}"/>">
      <a href="#" class="close" data-dismiss="alert" aria-label="close" title="close">
        <i class="fa fa-times"></i></a>
      <c:out value="${message}"/>
      <c:set var="message" value="${null}" scope="session"/>
      <c:set var="messageStatus" value="${null}" scope="session"/>
  </div>
  </c:if>
  </div>
</div>