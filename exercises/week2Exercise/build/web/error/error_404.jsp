<%--
    Document   : error_404
    Created on : Aug 16, 2011, 11:03:45 AM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <%@page isErrorPage="true" %>
    <%= exception.getMessage()%>
    <h1>404 error</h1>
  </body>
</html>
