<%--
    Document   : join_email_list
    Created on : Aug 17, 2011, 3:42:19 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
    <title>Murach's Java Servlets and JSP</title>
</head>

<body>
  <jsp:include page="/includes/header.html" />
  <%@page import="business.User"%>
  <%
  User u = (User)request.getAttribute("user");
  String msg = (String)request.getAttribute("msg");

  if (u == null) u = new User();
  if (msg == null) msg = "";

  %>
  <h1>Join our email list</h1>
  <p>To join our email list, enter your name and
     email address below. <br>
     Then, click on the Submit button.</p>

     <p><i><%=msg%></p></i>

  <form action="addToEmailList" method="post">
  <table cellspacing="5" border="0">
    <tr>
      <td align="right">First name:</td>
      <td><input type="text" name="firstName"></td>
    </tr>
    <tr>
      <td align="right">Last name:</td>
      <td><input type="text" name="lastName"></td>
    </tr>
    <tr>
      <td align="right">Email address:</td>
      <td><input type="text" name="emailAddress"></td>
    </tr>
    <tr>
      <td></td>
      <td><br><input type="submit" value="Submit"></td>
    </tr>
  </table>
  </form>
  <jsp:include page="/includes/footer.jsp" />