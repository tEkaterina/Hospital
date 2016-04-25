<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hospital.models.Patient" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title></title>
</head>
<body>
<ul>
<%
  ArrayList<Patient> patients = (ArrayList<Patient>)request.getAttribute("patients");
  for (Patient patient: patients) { %>
     <li><%=patient.getName() + " " + patient.getSurname()%></li>
  <%}
%>
</ul>

</body>
</html>
