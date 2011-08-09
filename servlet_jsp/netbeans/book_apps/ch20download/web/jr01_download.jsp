<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Downloads</h1>

<table cellpadding="5" border="1">
<tr><td colspan="2"><b>Joe Rut - Genuine Wood Grained Finish</b></td></tr>
<tr><td width="200"><b>Song title</b></td>
    <td width="150"><b>Audio Format</b></td>
</tr>
<tr><td>Filter</td>
    <td><a href="/musicStore/sound/${productCode}/filter.mp3">MP3</a></td>
</tr>
<tr><td>So Long Lazy Ray</td>
    <td><a href="/musicStore/sound/${productCode}/so_long.mp3">MP3</a></td>
</tr>
</table>

<p><a href="<c:url value='index.jsp'/>">
    View list of albums</a>.</p>

<p><a href="<c:url value='viewCookies'/>">
    View all cookies</a>.</p>

</body>
</html>