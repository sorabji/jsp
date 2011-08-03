<%-- 
    Document   : index
    Created on : Aug 2, 2011, 10:40:41 PM
    Author     : home
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

	<form action="process.jsp" method="post">
		<p>name: <input type="text" name="fullname"/></p>
		<p>address: <input type="text" name="address"/></p>
		<p>phone: <input type="text" name="phone"/></p>
		<p><input type="submit" name="submit"/></p>
	</form>
    </body>
</html>
