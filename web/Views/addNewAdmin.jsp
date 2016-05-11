<%--
  Created by IntelliJ IDEA.
  User: Balashechka
  Date: 10.05.2016
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить нового админа</title>
</head>
<body>
<form action="/addNewAdmin" method="post">
  <p>Email</p>
    <input type="email" name="email">
  <p>Password</p>
    <input type="password" name="password">
  <input type="submit" name="add">
</form>
</body>
</html>
