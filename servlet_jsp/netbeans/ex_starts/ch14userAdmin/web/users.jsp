<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>

<h1>Users List</h1>

<table cellpadding="5" border=1>

  <tr valign="bottom">
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email Address</th>
  </tr>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:forEach var="user" items="${users}">
  <tr valign="top">
    <td><p>${user.firstName}</td>
    <td><p>${user.lastName}</td>
    <td><p>${user.emailAddress}</td>
    <td><a href="displayUser?emailAddress=${user.emailAddress}">Update</a></td>
    <td><a href="deleteUser?emailAddress=${user.emailAddress}">Delete</a></td>
  </tr>
  </c:forEach>

</table>
    
</body>
</html>