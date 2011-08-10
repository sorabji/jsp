<%--
    Document   : process_student_handler
    Created on : Aug 9, 2011, 2:55:44 PM
    Author     : laptop
--%>

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
        %>
        <p>infoz: </p><br />
        <p><%= s.getFirstName() %></p>
        <p><%= s.getLastName() %></p>
        <p><%= s.getEmail() %></p>
    </body>
</html>
