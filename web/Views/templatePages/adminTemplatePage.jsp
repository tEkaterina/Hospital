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
<div class="container-fluid">
  <div class="row">
    <header>
      <div class="col-sm-5">
        <h1 class="header"><i class="fa fa-heartbeat" aria-hidden="true"></i> Медицинкий центр лечения сахарного диабета</h1>
      </div>
      <div class="col-sm-offset-2 col-sm-5">
        <form class="tool-form pull-right"
              style="margin: 30px 10px 10px 10px !important;
                      font-family: BloggerSans;"
              action="/signOut" method="get">
          <button class="btn btn-default">
            <i class="fa fa-sign-out" aria-hidden="true"></i> Выход
          </button>
        </form>
      </div>
    </header>
  </div>
</div>
<nav>
  <ul id="navbar" class="nav nav-pills">
    <li role="presentation"
        class="dropdown <c:out value="${activeNavPill.equals('patient')? 'active' : ''}"/>">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
        Пациент  <span class="caret"></span>
      </a>
      <ul class="dropdown-menu">
        <li><a href="/patientsView">Показать всех пациентов</a></li>
        <li><a href="/createPatient">Добавить нового пациента</a></li>
      </ul>
    </li>
    <li role="presentation"
        class="dropdown <c:out value="${activeNavPill.equals('doctor')? 'active' : ''}"/>">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
        Доктор  <span class="caret"></span>
      </a>
      <ul class="dropdown-menu">
        <li><a href="/doctorsView">Показать всех докторов</a></li>
        <li><a href="/addNewDoctor">Добавить нового доктора</a></li>
      </ul>
    </li>
    <li role="presentation"
        class="dropdown <c:out value="${activeNavPill.equals('user')? 'active' : ''}"/>">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
        Пользователи системы  <span class="caret"></span>
      </a>
      <ul class="dropdown-menu">
        <li><a href="/usersView">Показать всех пользователей</a></li>
        <li><a href="/addNewAdmin">Добавить нового администратора</a></li>
      </ul>
    </li>
  </ul>
</nav>
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-6 col-sm-offset-3" style="margin-top: 30px;">
      <c:if test="${message != null && messageStatus != null}">
        <div class="alert <c:out value="${message.equals('success') ? 'alert-success' : 'alert-danger'}"/>">
          <a href="#" class="close" data-dismiss="alert" aria-label="close" title="close">X</a>
          <c:out value="${message}"/>
          <c:set var="message" value="${null}" scope="session"/>
          <c:set var="messageStatus" value="${null}" scope="session"/>
        </div>
      </c:if>
    </div>
  </div>
  <c:if test="${partialPage != null && ! partialPage.equals('')}">
    <c:import url="${partialPage}"></c:import>
  </c:if>
</div>
<footer></footer>
</body>
<script src="../../libs/bootstrap/js/jquery-2.2.4.min.js"></script>
<script src="../../libs/bootstrap/js/bootstrap.min.js"></script>
<script src="../../libs/bootstrap/js/npm.js"></script>
<script src="../js/hospitalApp.js"></script>
<script src="../js/pageController.js"></script>
</html>
