<%--
    Document   : index
    Created on : Aug 23, 2011, 9:39:35 AM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>

  <jsp:useBean id="weather" scope="request" class="Data.WeatherBean"/>
  <jsp:useBean id="message" scope="request" class="java.lang.String"/>

    <h1>enter the weather data</h1>
    <p><%= request.getAttribute("message") %></p>
    <form action="/WeatherApp/WeatherBean" method="post">
    <table cellspacing="5" border="0">
        <tr>
            <td align="right">Temperature:</td>
            <td><input type="text"
                       name="temp"
                       value="<jsp:getProperty name='weather' property='temp'/>"></td>
        </tr>
        <tr>
            <td align="right">Humidity:</td>
            <td><input type="text"
                       name="humidity"
                       value="<jsp:getProperty name='weather' property='humidity'/>"></td>
        </tr>
        <tr>
            <td align="right">Pressure:</td>
            <td><input type="text"
                       name="pressure"
                       value="<jsp:getProperty name='weather' property='pressure'/>"></td>
        </tr>
        <tr>
            <td></td>
            <td><br><input type="submit" value="Submit"></td>
        </tr>
    </table>
    </form>

  </body>
</html>
