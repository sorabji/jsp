<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>

<h1>Your cart</h1>
<table border="1" cellpadding="5">
  <tr>
    <th>Quantity</th>
    <th>Description</th>
    <th>Price</th>
    <th>Amount</th>
  </tr>

<%@ taglib uri="/WEB-INF/murach.tld" prefix="mma" %>
<mma:cart>
  <tr valign="top">
    <td><%= quantity %></td>
    <td><%= productDescription %></td>
    <td><%= productPrice %></td>
    <td><%= total %></td>
  </tr>
</mma:cart>

</table>

<br>

<form action="<%= response.encodeURL("index.jsp")%>" method="post">
  <input type="submit" value="Continue Shopping">
</form>

<form action="<%= response.encodeURL("checkout.jsp")%>" method="post">
  <input type="submit" value="Checkout">
</form>

</body>
</html>