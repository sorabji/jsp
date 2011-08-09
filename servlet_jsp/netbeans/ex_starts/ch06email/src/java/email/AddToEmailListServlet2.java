package email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddToEmailListServlet2 extends HttpServlet
{    
    // declare an instance variable for the page
    int globalCount; // instance variables are not thread-safe
    
    public void init() throws ServletException
    {
        globalCount = 0; // initialize the instance variable
    }

    protected void doPost(
        HttpServletRequest request, 
        HttpServletResponse response) 
        throws ServletException, IOException
    {
        // update global count variable
        globalCount++;   // this is not thread-safe

        // send response to browser
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();        
        out.println(
          "<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n"
        + "<html>\n"
        + "<head>\n"
        + "  <title>Murach's Java Servlets and JSP</title>\n"
        + "</head>\n"
        + "<body>\n"
        + "<h1>Thanks for joining our email list</h1>\n"
        + "<p>This page has been accessed "
        +  globalCount + " times.</p>"
        + "</body>\n"
        + "</html>\n");
        
        out.close();
    }
}
