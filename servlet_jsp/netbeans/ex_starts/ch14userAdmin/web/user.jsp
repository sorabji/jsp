<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>

<script language="JavaScript">
function validate(form) {
    if (form.firstName.value=="") {
        alert("Please fill in your first name");
        form.firstName.focus();
    }
    else if (form.lastName.value=="") {
        alert("Please fill in your last name");
        form.lastName.focus();
    }
    else {
        form.submit();
    }
}
</script>

<body>

<h1>Update User</h1>

<form action="updateUser" method="post">
<table cellspacing="5" border="0">
    <tr>
        <td align="right">First name:</td>
        <td><input type="text" name="firstName" 
                value="${user.firstName}">
        </td>
    </tr>
    <tr>
        <td align="right">Last name:</td>
        <td><input type="text" name="lastName" 
                value="${user.lastName}">
        </td>
    </tr>
    <tr>
        <td align="right">Email address:</td>
        <td>${user.emailAddress}</td>
    </tr>
    <tr>
        <td></td>
        <td><input type="button" value="Submit" 
                   onClick="validate(this.form)"></td>
    </tr>
</table>
</form>

</body>
</html>