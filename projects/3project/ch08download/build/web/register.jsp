<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Murach's Java Servlets and JSP</title>
</head>

<body>

<h1>Download registration</h1>

<p>To register for our downloads, enter your name and email <br>
   address below. Then, click on the Submit button.</p>

<form action="<%= response.encodeURL("registerUser")%>" 
      method="post">

  <table cellspacing="5" border="0">
    <tr>
      <td align="right">First name:</td>
      <td><input type="text" name="firstName"></td>
    </tr>
    <tr>
      <td align="right">Last name:</td>
      <td><input type="text" name="lastName"></td>
    </tr>
    <tr>
      <td align="right">Email address:</td>
      <td><input type="text" name="emailAddress"></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="Submit"></td>
    </tr>
  </table>

</form>
</body>

</html>
