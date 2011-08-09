<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>
    <title>Murach's Java Servlets and JSP</title>
</head>

<body>

<h1>Join our email list</h1>
<p>To join our email list, enter your name and
   email address below. <br>
   Then, click on the Submit button.</p>

<%@ taglib prefix="mma" uri="/WEB-INF/murach.tld" %>
<jsp:useBean id="user" scope="session" class="business.User"/>

<p><mma:ifEmptyMark color="blue" field=""/> marks required fields</p>
   
<form action="addToEmailList" method="post">
<table cellspacing="5" border="0">
    <tr>
        <td align="right">First name:</td>
        <td><input type="text" name="firstName" 
             value="<jsp:getProperty name="user" property="firstName"/>">
             <mma:ifEmptyMark color="blue" field="<%= user.getFirstName() %>"/>
        </td>
    </tr>
    <tr>
        <td align="right">Last name:</td>
        <td><input type="text" name="lastName"
             value="<jsp:getProperty name="user" property="lastName"/>">
             <mma:ifEmptyMark color="blue" field="<%= user.getLastName() %>"/>
        </td>
    </tr>
    <tr>
        <td align="right">Email address:</td>
        <td><input type="text" name="emailAddress"
             value="<jsp:getProperty name="user" property="emailAddress"/>">
             <mma:ifEmptyMark color="blue" field="<%= user.getEmailAddress() %>"/>
        </td>
    </tr>
    <tr>
        <td></td>
        <td><br><input type="submit" value="Submit"></td>
    </tr>
</table>
</form>

<p>The current date is <mma:currentDate />.</p>

<mma:ifWeekday>
   <p>Live support available at 1-800-555-2222</p>
</mma:ifWeekday>

</body>
</html>