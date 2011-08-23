<%--
    Document   : DisplayWeather
    Created on : Aug 23, 2011, 10:34:51 AM
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
    <h1>Weather Info</h1>
    <img src="<jsp:getProperty name='weather' property='image'/>" alt="<jsp:getProperty name='weather' property='image'/>"/>
    <br />
    <hr />
    <br />
    <p>Temp:  <jsp:getProperty name="weather" property="temp"/></p>
    <p>Humidity:  <jsp:getProperty name="weather" property="humidity"/></p>
    <p>Pressure:  <jsp:getProperty name="weather" property="pressure"/></p>
  </body>
</html>
