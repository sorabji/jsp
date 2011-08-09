<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>

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
    <td><a href="<%=response.encodeURL("cart?productCode=8601")%>">Add To Cart</a></td>
  </tr>

  <tr valign="top">
    <td>Paddlefoot - The first CD</td>
    <td>$12.95</td>
    <td><a href="<%=response.encodeURL("cart?productCode=pf01")%>">Add To Cart</a></td>
  </tr>

  <tr valign="top">
    <td>Paddlefoot - The second CD</td>
    <td>$14.95</td>
    <td><a href="<%=response.encodeURL("cart?productCode=pf02")%>">Add To Cart</a></td>
  </tr>

  <tr valign="top">
    <td>Joe Rut - Genuine Wood Grained Finish</td>
    <td>$14.95</td>
    <td><a href="<%=response.encodeURL("cart?productCode=jr01")%>">Add To Cart</a></td>
  </tr>

</table>

</body>
</html>