<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<%@ page pageEncoding="WINDOWS-1251"%>
<html ng-app="hospitalApp" ng-controller="pageController">
<head>
  <title>������ �������</title>
  <meta http-equiv="content-language" content="ru">
  <meta name="description" content="">
  <link rel="stylesheet" href="../libs/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="../libs/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="../Views/css/site.css">
</head>
<body>
<header>
  <h1 class="header"><i class="fa fa-heartbeat" aria-hidden="true"></i> HOSPITAL</h1>
</header>
<nav>
  <ul id="navbar" class="nav nav-pills">
    <li role="presentation"><a href="/patientsView">C����� ���������</a></li>
    <li role="presentation"><a href="/doctorsView">������ ������</a></li>
    <li role="presentation"><a href="/addNewDoctor">�������� �����</a></li>
    <li role="presentation"><a href="/addNewAdmin">�������� ��������������</a></li>
    <li role="presentation"><a href="/usersView">������ ������������� �������</a></li>
  </ul>
</nav>
<div class="container-fluid">
  <div class="content col-sm-offset-3 col-sm-6">
    <div style="text-align: center;">
      <label class="form-title"></label>
    </div>
    <c:forEach items = "${analyzes}" var="analyz" varStatus="status">
      <%@ include file="Partial/analysisView.jsp"%>
    </c:forEach>
    <c:if test="${currentUser.getDoctor().getId()==visit.getDoctor().getId()}">
      <table border="2">
        <form action = "/createAnalyz" method="get">
          <tr >
            <td>�������� ������</td>
            <td><input type="image" src="/Views/Images/add.png"></td>
            <input type="hidden" name="visitId" value="${visit.getId()}">
          </tr>
        </form>
      </table>
    </c:if>
  </div>
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