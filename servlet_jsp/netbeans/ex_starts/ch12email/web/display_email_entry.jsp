<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>

<body>

<h1>Thanks for joining our email list</h1>

<p>Here is the information that you entered:</p>

<table cellspacing="5" cellpadding="5" border="1">
    <tr>
        <td align="right">First name:</td>
        <td>${user.firstName}</td>
    </tr>
    <tr>
        <td align="right">Last name:</td>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <td align="right">Email address:</td>
        <td>${user.emailAddress}</td>
    </tr>
</table>

<p>This email was added to our list on <!-- TODO: Add custom currentDate tag -->.</p>

<p>To enter another email address, click on the Back <br>
button in your browser or the Return button shown <br>
below.</p>

<form action="join_email_list.jsp" method="post">
    <input type="submit" value="Return">
</form>

</body>
</html>