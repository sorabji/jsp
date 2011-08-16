<%--
    Document   : add_student_2
    Created on : Aug 16, 2011, 9:06:11 AM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>
    <title>add a student</title>
</head>

<body>
  <%@page import="exercise.Student" %>
  <%
   Student s = (Student)request.getAttribute("student") ;
   String message = (String)request.getAttribute("message");

   if (s==null) s = new Student();
   if (message==null) message = "";
  %>
    <h1>add a student with postback</h1>
    <p>to add a student, enter his name and email address</p>

    <p><%= message %></p>

    <form action="/week2Exercise/processStudent" method="post">
    <table cellspacing="5" border="0">
        <tr>
            <td align="right">First name:</td>
            <td><input type="text"
                       name="firstName"
                       value="<%= s.getFirstName()%>"></td>
        </tr>
        <tr>
            <td align="right">Last name:</td>
            <td><input type="text"
                       name="lastName"
                       value="<%= s.getLastName()%>"></td>
        </tr>
        <tr>
            <td align="right">Email address:</td>
            <td><input type="text"
                       name="emailAddress"
                       value="<%= s.getEmail()%>"></td>
        </tr>
        <tr>
            <td></td>
            <td><br><input type="submit" value="Submit"></td>
        </tr>
    </table>
    </form>
</body>
</html>