<%-- 
    Document   : process
    Created on : Aug 2, 2011, 10:47:29 PM
    Author     : home
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>JSP Page</title>

		<% 
		String name = request.getParameter("fullname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		%>
		
	</head>
	<body>
		<h1>Hello <%=name %></h1>
		<p>find you at <%=address%></p>
		<p>call you at <%=phone%></p>
	</body>
</html>
