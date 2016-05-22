<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" pageEncoding="WINDOWS-1251"%>
<html ng-app="hospitalApp" ng-controller="pageController">
<head>
  <title>������ �������</title>
  <meta http-equiv="content-language" content="ru">
  <meta name="description" content="">
  <link rel="stylesheet" href="../../libs/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="../../libs/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="../../Views/css/site.css">
</head>
<body>
<header>
  <h1 class="header"><i class="fa fa-heartbeat" aria-hidden="true"></i> HOSPITAL</h1>
</header>
<nav>
  <ul id="navbar" class="nav nav-pills">
    <li role="presentation"
        class="dropdown <c:out value="${activeNavPill.equals('patient')? 'active' : ''}"/>">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
        �������  <span class="caret"></span>
      </a>
      <ul class="dropdown-menu">
        <li><a href="/patientsView">�������� ���� ���������</a></li>
        <li><a href="/createPatient">�������� ������ ��������</a></li>
      </ul>
    </li>
    <li role="presentation"
        class="dropdown <c:out value="${activeNavPill.equals('doctor')? 'active' : ''}"/>">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
        ������  <span class="caret"></span>
      </a>
      <ul class="dropdown-menu">
        <li><a href="/doctorsView">�������� ���� ��������</a></li>
        <li><a href="/addNewDoctor">�������� ������ �������</a></li>
      </ul>
    </li>
    <li role="presentation"
        class="dropdown <c:out value="${activeNavPill.equals('user')? 'active' : ''}"/>">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
        ������������ �������  <span class="caret"></span>
      </a>
      <ul class="dropdown-menu">
        <li><a href="/usersView">�������� ���� �������������</a></li>
        <li><a href="/addNewAdmin">�������� ������ ��������������</a></li>
      </ul>
    </li>
  </ul>
</nav>
<div class="container-fluid">
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
