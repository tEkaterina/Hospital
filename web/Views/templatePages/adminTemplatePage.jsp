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
        <c:if test="${activeNavPill.equals('patientsView')}">
          class="active"
        </c:if>
        ><a href="/patientsView">C����� ���������</a></li>
    <li role="presentation"
        <c:if test="${activeNavPill.equals('doctorsView')}">
          class="active"
        </c:if>
        ><a href="/doctorsView">������ ������</a></li>
    <li role="presentation"
      <c:if test="${activeNavPill.equals('addNewDoctor')}">
        class="active"
      </c:if>
      ><a href="/addNewDoctor">�������� �����</a></li>
    <li role="presentation"
      <c:if test="${activeNavPill.equals('addNewAdmin')}">
        class="active"
      </c:if>
      ><a href="/addNewAdmin">�������� ��������������</a></li>
    <li role="presentation"
      <c:if test="${activeNavPill.equals('usersView')}">
        class="active"
      </c:if>
      ><a href="/usersView">������ ������������� �������</a></li>
  </ul>
</nav>
<div class="container-fluid">
  <c:if test="${partialPage != null && ! partialPage.equals('')}">
    <c:import url="${partialPage}"></c:import>
  </c:if>
</div>
<footer></footer>
</body>
<script src="../../libs/bootstrap/js/jquery-2.2.4.min.js"/>
<script src="../../libs/bootstrap/js/bootstrap.min.js" />
<script src="../../libs/angularjs/angular.min.js" />
<script src="../../libs/angularjs/angular-route.min.js" />
<script src="../../libs/angularjs/ui-bootstrap-custom-1.3.2.min.js" />
<script src="../../libs/angularjs/ui-bootstrap-custom-tpls-1.3.2.min.js" />
<script src="../js/hospitalApp.js"/>
<script src="../js/pageController.js"/>
</html>
