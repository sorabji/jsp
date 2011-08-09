<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>

<jsp:useBean id="product" scope="session" class="business.Product"/>    

<h1>Downloads</h1>

<table cellpadding="5" border="1">
<tr><td colspan="2"><b><jsp:getProperty name="product" property="description"/></b></td></tr>
<tr><td width="200"><b>Song title</b></td>
    <td width="150"><b>Audio Format</b></td>
</tr>
<tr><td>Neon Lights</td>
    <td><a href="/musicStore/sound/<jsp:getProperty name="product" property="code"/>/neon.mp3">MP3</a></td>
</tr>
<tr><td>Tank Hill</td>
    <td><a href="/musicStore/sound/<jsp:getProperty name="product" property="code"/>/tank.mp3">MP3</a></td>
</tr>
</table>

<p><a href="<%= response.encodeURL("index.jsp")%>">
    View list of albums</a>.</p>

<p><a href="<%= response.encodeURL("view_cookies.jsp")%>">
    View all cookies</a>.</p>

</body>
</html>