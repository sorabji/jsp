<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

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

    <p>To enter another email address, click on the Back <br>
    button in your browser or the Return button shown <br>
    below.</p>

    <form action="http://localhost:8080/ch16email/index.jsp" method="post">
        <input type="submit" value="Return">
    </form>

    <p>
        This email address was added to our list on 
        ${requestScope.currentDate}
    </p>

</body>
</html>