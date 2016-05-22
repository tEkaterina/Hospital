<%@ page import="hospital.models.Doctor" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="hospitalApp" ng-controller="pageController">
<head>
  <title>Новый врач</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
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
    <li role="presentation"><a href="/patientsView">Cписок пациентов</a></li>
    <li role="presentation"><a href="/doctorsView">Список врачей</a></li>
    <li role="presentation" class="active"><a href="/addNewDoctor">Добавить врача</a></li>
    <li role="presentation"><a href="/addNewAdmin">Добавить администратора</a></li>
    <li role="presentation"><a href="/usersView">Список пользователей системы</a></li>
  </ul>
</nav>
<div class="container-fluid">
  <div class="content col-sm-offset-3 col-sm-6">
    <div style="text-align: center;">
      <label class="form-title">Введите данные для нового врача</label>
    </div>
    <form class="form-horizontal" action = "/addNewDoctor" method="post">
      <div class="form-group inner-addon left-addon">
        <i class="fa fa-user" aria-hidden="true"></i>
        <input class="form-control" type="text" name="name" placeholder="Имя">
      </div>
      <div class="form-group inner-addon left-addon">
        <i class="fa fa-user" aria-hidden="true"></i>
        <input class="form-control" type="text" name="surname" placeholder="Фамилия">
      </div>
      <div class="form-group">
        <label class="control-label col-sm-3">Категория</label>
        <div class="col-sm-9">
          <div class="inner-addon left-addon">
            <c:set var="enumValues" value="<%=Doctor.Category.values()%>"/>
            <i class="fa fa-graduation-cap" aria-hidden="true"></i>
            <select class="form-control" name="category">
              <c:forEach items="${enumValues}" var="enumValue">
                <option><c:out value="${enumValue.toString()}"/></option>
              </c:forEach>
            </select>
          </div>
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-3">Специальность</label>
        <div class="col-sm-9">
          <div class="inner-addon left-addon">
            <i class="fa fa-user-md" aria-hidden="true"></i>
            <select class="form-control" name="specialities">
              <c:forEach items = "${specialities}" var="speciality">
                <option><c:out value="${speciality.getName()}"/></option>
              </c:forEach>
            </select>
          </div>
        </div>
      </div>
      <div class="form-group inner-addon left-addon">
        <i class="fa fa-phone" aria-hidden="true"></i>
        <input class="form-control" type="text" name="phone" placeholder="Телефон">
      </div>
      <%@include file="Partial/newUserForm.jsp"%>
    </form>
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
