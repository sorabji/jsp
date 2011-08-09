<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>

<h1>List of albums</h1>

<%@ page import="util.CookieUtil" %>
<%
    Cookie[] cookies = request.getCookies();
    String firstName = CookieUtil.getCookieValue(cookies, "firstNameCookie");
    String welcomeMessage = "";
    if (!firstName.equals(""))
    {
        welcomeMessage += "Welcome back, " + firstName;
    }
%>
<p><%= welcomeMessage %></p>

<p>
<a href="<%=response.encodeURL("checkUser?productCode=8601")%>">
    86 (the band) - True Life Songs and Pictures
</a><br>

<a href="<%=response.encodeURL("checkUser?productCode=pf01")%>">
    Paddlefoot - The first CD
</a><br>

<a href="<%= response.encodeURL("checkUser?productCode=pf02")%>">
    Paddlefoot - The second CD
</a><br>

<a href="<%= response.encodeURL("checkUser?productCode=jr01")%>">
    Joe Rut - Genuine Wood Grained Finish
</a>
</p>

</body>
</html>