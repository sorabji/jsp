<%--
    Document   : index
    Created on : Sep 13, 2011, 9:07:28 AM
    Author     : laptop
--%>

<%@page import="java.sql.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <%
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:4667/testing","root","c@rds52c@rds52");
    %>
    <h1>Hello World!</h1>
  </body>
</html>
