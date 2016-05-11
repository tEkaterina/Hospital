<%--
  Created by IntelliJ IDEA.
  User: Balashechka
  Date: 09.05.2016
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<form action="/success" method = "post">
<b>Welcome, dear ladies and gentlemen!</b>
  <input type = "submit" value="Добавить нового пользователя">
  <p><input type="radio" name="user" value="admin">Admin</p>
  <p><input type="radio" name="user" value="doctor">Doctor</p>
  <p>
  </form>
</body>
</html>
