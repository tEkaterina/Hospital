<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
  <c:forEach items = "${users}" var="user">
    <%@include file="Partial/userView.jsp"%>
  </c:forEach>
