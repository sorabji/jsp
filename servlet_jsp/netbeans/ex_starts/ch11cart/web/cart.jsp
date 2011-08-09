<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<c:forEach var="item" items="${cart.items}">
  <tr valign="top">
    <td>${item.quantity}</td>
    <td>${item.product.description}</td>
    <td>${item.product.priceCurrencyFormat}</td>
    <td>${item.totalCurrencyFormat}</td>
  </tr>
</c:forEach>
</table>

<br>

<form action="<c:url value='index.jsp' />" method="post">
  <input type="submit" value="Continue Shopping">
</form>

<form action="<c:url value='checkout.jsp' />" method="post">
  <input type="submit" value="Checkout">
</form>

</body>
</html>