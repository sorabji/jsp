<%--
    Document   : process_student_handler
    Created on : Aug 9, 2011, 2:55:44 PM
    Author     : laptop
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>process student handler</title>
    </head>
    <body>
        <h1>process student handler</h1>
        <%@page import="exercise.Student" %>
        <%
        Student s = (Student) request.getAttribute("student");
        Enumeration attNames = request.getAttributeNames();
        %>
        <p>infoz: </p><br />
        <p><%= s.getFirstName() %></p>
        <p><%= s.getLastName() %></p>
        <p><%= s.getEmail() %></p>
        <a href="<%=response.encodeURL("/week2Exercise/views/showSession.jsp")%>">see session info</a><br />
        <%
        while(attNames.hasMoreElements()){
          String name = (String) attNames.nextElement();
          out.println("<p>"+name+"</p>");
          out.println("<p>"+request.getSession().getAttribute(name) +"</p>");
        }
        %>
    </body>
</html>
