<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>CD list</h1>

<table cellpadding="5" border=1>

  <tr valign="bottom">
    <td align="left"><b>Description</b></td>
    <td align="left"><b>Price</b></td>
    <td align="left"></td>
  </tr>

  <tr valign="top">
    <td>86 (the band) - True Life Songs and Pictures</td>
    <td>$14.95</td>
    <td><a href="<c:url value='/cart?productCode=8601' />">
        Add To Cart</a></td>
  </tr>

  <tr valign="top">
    <td>Paddlefoot - The first CD</td>
    <td>$12.95</td>
    <td><a href="<c:url value='/cart?productCode=pf01' />">
        Add To Cart</a></td>
  </tr>

  <tr valign="top">
    <td>Paddlefoot - The second CD</td>
    <td>$14.95</td>
    <td><a href="<c:url value='/cart?productCode=pf02' />">
        Add To Cart</a></td>
  </tr>

  <tr valign="top">
    <td>Joe Rut - Genuine Wood Grained Finish</td>
    <td>$14.95</td>
    <td><a href="<c:url value='/cart?productCode=jr01' />">
        Add To Cart</a></td>
  </tr>

</table>

</body>
</html>