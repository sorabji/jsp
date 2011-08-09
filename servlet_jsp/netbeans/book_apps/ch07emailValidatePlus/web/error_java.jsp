<%@ include file="/includes/header.html" %>

<%@ page isErrorPage="true" %>

<h1>Java Error</h1>
<p>Sorry, Java has thrown an exception.</p>
<p>To continue, click the Back button.</p>
<br>

<h2>Details</h2>
<p>
    Type: <%= exception.getClass() %><br>
    Message: <%= exception.getMessage() %><br>
</p>

<%@ include file="/includes/footer.jsp" %>