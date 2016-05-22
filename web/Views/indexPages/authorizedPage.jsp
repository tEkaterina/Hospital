<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="hospitalApp" ng-controller="pageController">
<head>
  <title></title>
  <meta http-equiv="content-language" content="ru">
  <meta name="description" content="">
  <link rel="stylesheet" href="../../libs/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="../../libs/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="../css/site.css">
</head>
<body>
<header>
  <h1 class="header"><i class="fa fa-heartbeat" aria-hidden="true"></i> HOSPITAL</h1>
</header>
<nav>
  <ul id="navbar" class="nav nav-pills">
    <li role="presentation" ng-click="chooseNavbarItem(this)"><a href="#">Home</a></li>
    <li role="presentation" ng-click="chooseNavbarItem(this)"><a href="#">Profile</a></li>
    <li role="presentation" ng-click="chooseNavbarItem(this)"><a href="#">Messages</a></li>
  </ul>
  <div ng-view>

  </div>
</nav>
<content></content>
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