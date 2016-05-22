<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
    <title>Личный кабинет</title>
</head>
<body>
  <h1><c:out value="Добро пожаловать, ${currentUser.getDoctor().getName()} ${currentUser.getDoctor().getSurname()}!"/></h1>

  <!-- Navigation -->
  <li><a href="/patientsView">Cписок пациентов</a></li>
  <li><a href="/doctorVisit">Мои осмотры</a></li>

</body>
</html>
