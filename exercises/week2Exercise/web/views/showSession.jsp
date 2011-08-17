<%--
    Document   : showSession
    Created on : Aug 17, 2011, 10:26:36 AM
    Author     : laptop
--%>

<%@page import="exercise.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>see session info</h1>
    <%
    Student s = (Student)request.getSession().getAttribute("student");
    %>
    <p><%=s.getFirstName()%></p>
    <p><%=s.getLastName()%></p>
    <p><%=s.getEmail()%></p>
  </body>
</html>
