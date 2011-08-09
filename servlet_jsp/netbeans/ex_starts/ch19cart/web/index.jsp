<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
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


<c:forEach var="product" items="${applicationScope.products}">
  <tr valign="top">
    <td>${product.description}</td>
    <td>${product.priceCurrencyFormat}</td>
    <td><a href="<c:url value='/cart?productCode=${product.code}' />">
        Add To Cart</a></td>
</tr>
</c:forEach>

</table>

<p>
For customer service, please send an email to ${custServEmail}.
</p>

<p>
&copy; Copyright ${currentYear} Mike Murach &amp; Associates, Inc.
All rights reserved.
</p>

</body>
</html>