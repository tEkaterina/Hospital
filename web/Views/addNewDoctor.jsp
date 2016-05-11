<%--
  Created by IntelliJ IDEA.
  User: Balashechka
  Date: 09.05.2016
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
  <title>Add new doctor</title>>
</head>
<body>

  <form action = "/addNewDoctor" method="post">
    <p>Enter user's data</p>
      <p>Name</p>
        <input type="text" name="name">
      <p>Surname</p>
        <input type="text" name="surname">
      <p>Category</p>
        <select name="category">
          <option><c:out value="Первая"/></option>
          <option><c:out value="Вторая"/></option>
          <option><c:out value="Высшая"/></option>
        </select>
      <p>Speciality</p>
         <select name="specialities">
           <c:forEach items = "${specialities}" var="speciality">
             <option><c:out value="${speciality.getName()}"/></option>
          </c:forEach>
         </select>
      <p>Telephone</p>
        <input type="text" name="phone">
      <p>Email</p>
        <input type="text" name="email">
      <p>Password</p>
        <input type="password" name="password">
      <input type="submit" name="add">



  </form>
</body>
</html>
