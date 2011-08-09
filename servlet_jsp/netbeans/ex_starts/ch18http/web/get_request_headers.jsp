<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>

<h1>Request Headers</h1>

<table cellpadding="5" border="1">

  <tr align="left">
    <th>Name</th>
    <th>Value</th>
  </tr>
<%@ page import="java.util.Enumeration" %>
<%
  Enumeration headerNames = request.getHeaderNames();
  while (headerNames.hasMoreElements())
  {
    String name = (String) headerNames.nextElement();
    String value = request.getHeader(name);
%>
  <tr>
    <td width="120"><%= name %></td>
    <td><%= value %></td>
  </tr>
<% } %>

</table>

</body>
</html>