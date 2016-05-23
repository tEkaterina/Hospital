<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" pageEncoding="WINDOWS-1251"%>
<html ng-app="hospitalApp" ng-controller="pageController">
<head>
  <title>Личный кабинет</title>
  <meta http-equiv="content-language" content="ru">
  <meta name="description" content="">
  <link rel="stylesheet" href="../../libs/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="../../libs/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="../../Views/css/site.css">
</head>
<body>
<%@include file="../Partial/header.jsp"%>
<nav>
  <ul id="navbar" class="nav nav-pills">
    <li role="presentation"
        class="dropdown <c:out value="${activeNavPill.equals('patient')? 'active' : ''}"/>">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
        Пациент  <i class="fa fa-caret-down"></i>
      </a>
      <ul class="dropdown-menu">
        <li><a href="/patientsView">Показать всех пациентов</a></li>
        <li><a href="/createPatient">Добавить нового пациента</a></li>
      </ul>
    </li>
    <li role="presentation" class="<c:out value="${activeNavPill.equals('view') ? 'active': ''}"/>">
      <a href="/doctorVisit">Мои осмотры</a>
    </li>
  </ul>
</nav>
<div class="container-fluid">
  <%@include file="../Partial/alertDialog.jsp"%>
  <c:if test="${partialPage != null && ! partialPage.equals('')}">
    <c:import url="${partialPage}"></c:import>
  </c:if>
</div>
<%@include file="../Partial/footer.jsp"%>
</body>
<script src="../../libs/bootstrap/js/jquery-2.2.4.min.js"></script>
<script src="../../libs/bootstrap/js/bootstrap.min.js"></script>
<script src="../../libs/bootstrap/js/npm.js"></script>
</html>
