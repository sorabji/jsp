package email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.Date;

import business.User;
import data.UserIO;

/**
 * @author Joel Murach
 */
public class AddToEmailListServlet extends HttpServlet
{    
    /**
     * @param request servlet request
     * @param response servlet response
     * 
     * Should this method be a doPost instead??
     * Should we discuss the differences in this chapter? Or in the previous chapter?
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // get parameters from the request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        // create the User object and write it to a file
        User user = new User(firstName, lastName, emailAddress);
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/EmailList.txt");
        UserIO.addRecord(user, path);
        
        // store the User object in the session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        
        // create the Date object and store it in the request
        Date currentDate = new Date();
        request.setAttribute("currentDate", currentDate);
        
        // forward request and response to JSP page
        String url = "/display_email_entry.jsp";
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);        
    }    
}
