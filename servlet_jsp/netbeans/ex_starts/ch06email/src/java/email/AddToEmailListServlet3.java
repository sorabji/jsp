package email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddToEmailListServlet3 extends HttpServlet
{    
    protected void doGet(
        HttpServletRequest request, 
        HttpServletResponse response) 
        throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        // synchronize access to the session object
        int sessionCount = 0;
        synchronized(session)
        {        
            // get the sessionCount variable from the session object
            Integer i = (Integer) session.getAttribute("sessionCount");
            if (i == null)
                sessionCount = 0;
            else
                sessionCount = (int) i;

            // update sessionCount variable
            sessionCount++;   // this is not thread-safe

            // set the new sessionCount variable in the session object
            session.setAttribute("sessionCount", sessionCount);        
        }

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
        + "<p>This session has been accessed "
        +  sessionCount + " times.</p>"
        + "</body>\n"
        + "</html>\n");
        
        out.close();
    }
    protected void doPost(
        HttpServletRequest request, 
        HttpServletResponse response) 
        throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}
