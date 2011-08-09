<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Cookies</h1>

<p>All persistent cookies have been removed from this browser.</p>

<p><a href="<c:url value='index.jsp'/>">
    View list of albums</a>.</p>

<p><a href="<c:url value='viewCookies'/>">
    View all cookies</a>.</p>

</body>
</html>