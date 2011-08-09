<%-- 
    Document   : display_music_choices
    Created on : Aug 8, 2011, 3:00:51 PM
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
    <%
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");

      String[] musicChoices = request.getParameterValues("musicChoices");

    %>
    <h1>Thanks for joining our email list, <%=firstName%> <%=lastName%></h1>
    <p>We'll use email to notify you whenever we have new releases for these types of music</p>

    <%
      for (String s: musicChoices){
        out.println("<p>"+s+"</p>");
      }
    %>

  </body>
</html>
