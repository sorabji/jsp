<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>

<h1>Cookies</h1>

<p>Here's a table with all of the cookies that this <br>
browser is sending to the current server.</p>

<table cellpadding="5" border="1">
  <tr>
    <td align="right"><b>Name</b></td>
    <td><b>Value</b></td>
  </tr>
<%
  Cookie[] cookies = request.getCookies();
  for (Cookie c : cookies)
  {
%>
  <tr>
    <td align="right"><%= c.getName() %></td>
    <td><%= c.getValue() %></td>
  </tr>
<%
  }
%>
</table>

<p><a href="<%= response.encodeURL("index.jsp")%>">
    View list of albums</a>.</p>

<p><a href="<%= response.encodeURL("deleteCookies")%>">
    Delete all persistent cookies</a>.</p>

</body>
</html>