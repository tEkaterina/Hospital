<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
    <title>������ �������</title>
</head>
<body>
  <h1><c:out value="����� ����������, ${currentUser.getDoctor().getName()} ${currentUser.getDoctor().getSurname()}!"/></h1>

  <!-- Navigation -->
  <li><a href="/patientsView">C����� ���������</a></li>
  <li><a href="/doctorVisit">��� �������</a></li>

</body>
</html>
