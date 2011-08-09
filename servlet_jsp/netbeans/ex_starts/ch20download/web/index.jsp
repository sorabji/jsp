<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>List of albums</h1>

<p>
<a href="<c:url value='checkUser?productCode=8601'/>">
    86 (the band) - True Life Songs and Pictures
</a><br>

<a href="<c:url value='checkUser?productCode=pf01'/>">
    Paddlefoot - The first CD
</a><br>

<a href="<c:url value='checkUser?productCode=pf02'/>">
    Paddlefoot - The second CD
</a><br>

<a href="<c:url value='checkUser?productCode=jr01'/>">
    Joe Rut - Genuine Wood Grained Finish
</a>
</p>

</body>
</html>