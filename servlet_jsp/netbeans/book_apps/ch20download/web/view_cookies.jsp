<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Cookies</h1>

<p>Here's a table with all of the cookies that this <br>
browser is sending to the current server.</p>

<table cellpadding="5" border="1">
  <tr>
    <td align="right"><b>Name</b></td>
    <td><b>Value</b></td>
  </tr>

<!-- NOTE: You can't use cookie as the var attribute
because it's a reserved keyword in EL -->
<c:forEach var="c" items="${requestScope.cookies}"> 
  <tr>
    <td align="right">${c.name}</td>
    <td>${c.value}</td>
  </tr>
</c:forEach>


</table>

<p><a href="<c:url value='index.jsp'/>">
    View list of albums</a>.</p>

<p><a href="<c:url value='deleteCookies'/>">
    Delete all cookies</a>.</p>

</body>
</html>