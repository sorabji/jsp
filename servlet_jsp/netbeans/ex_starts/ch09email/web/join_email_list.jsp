<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>

<body>

<h1>Join our email list</h1>
<p>To join our email list, enter your name and
   email address below. <br>
   Then, click on the Submit button.</p>

<form action="addToEmailList" method="post">
<jsp:useBean id="user" scope="session" class="business.User"/>
<table cellspacing="5" border="0">
    <tr>
        <td align="right">First name:</td>
        <td><input type="text" name="firstName" 
             value="<jsp:getProperty name="user" property="firstName"/>">
        </td>
    </tr>
    <tr>
        <td align="right">Last name:</td>
        <td><input type="text" name="lastName"
             value="<jsp:getProperty name="user" property="lastName"/>">
        </td>
    </tr>
    <tr>
        <td align="right">Email address:</td>
        <td><input type="text" name="emailAddress"
             value="<jsp:getProperty name="user" property="emailAddress"/>">
        </td>
    </tr>
    <tr>
        <td></td>
        <td><br><input type="submit" value="Submit"></td>
    </tr>
</table>
</form>

</body>    
</html>