<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
    <title></title>
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
            <div class="col-sm-5" style="text-align: center;">
                <h1 class="header"><i class="fa fa-heartbeat" aria-hidden="true" style="color: crimson"></i> Медицинкий центр лечения сахарного диабета</h1>
            </div>
        </header>
    </div>
</div>
<nav style="height: 40px; margin: 0;">
</nav>
<div class="container-fluid">
    <%@include file="../Partial/alertDialog.jsp"%>
    <div class="content col-sm-offset-3 col-sm-6">
        <div style="text-align: center;">
            <label class="form-title">Вход в систему</label>
        </div>
        <form class="form-horizontal" action = "/" method="POST" style="margin-bottom: 0 !important;">
            <div class="form-group inner-addon left-addon">
                <i class="fa fa-envelope-o fa" aria-hidden="true"></i>
                <input id="login" class="form-control" type = "email" name="login" placeholder="Email">
            </div>
            <div class="form-group inner-addon left-addon">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <input id="password" class="form-control" type="password" name="password" placeholder="Пароль">
            </div>
            <div class="form-group" style="text-align: center; margin-bottom: 0 !important;">
                <input type="submit" class="btn btn-success blue" value="Войти">
            </div>
        </form>
    </div>
</div>
<footer></footer>
</body>
<script src="../../libs/bootstrap/js/jquery-2.2.4.min.js"></script>
<script src="../../libs/bootstrap/js/bootstrap.min.js" ></script>
<script src="../../libs/angularjs/angular.min.js" ></script>
<script src="../../libs/angularjs/angular-route.min.js" ></script>
<script src="../../libs/angularjs/ui-bootstrap-custom-1.3.2.min.js" ></script>
<script src="../../libs/angularjs/ui-bootstrap-custom-tpls-1.3.2.min.js" ></script>
</html>