package email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import business.User;
import data.UserIO;

public class AddToEmailListServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException
    {
        // get parameters from the request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        // create the User object
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmailAddress(emailAddress);

        // write the User object to a file
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/EmailList.txt");
        UserIO.addRecord(user, path);

        // store the User object in the session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        /*****************************************
         * Some extra examples
        ***************************************/
        
        // create the Date object and store it in the request
        Date currentDate = new Date();
        request.setAttribute("currentDate", currentDate);
        
        // create an array of strings
        String[] colors = {"red", "green", "blue"};
        ServletContext application = this.getServletContext();
        application.setAttribute("colors", colors);        
        
        // create users list and store it in the session
        ArrayList<User> users = UserIO.getUsers(path);
        session.setAttribute("users", users);
        
        // create users map and store it in the session
        HashMap<String, User> usersMap = UserIO.getUsersMap(path);
        session.setAttribute("usersMap", usersMap);

        // store the email address in the session
        session.setAttribute("emailAddress", emailAddress);
        
        // store an array of email addresses in the session
        String[] emailAddresses = {"jsmith@gmail.com", "joel@murach.com"};
        session.setAttribute("emailAddresses", emailAddresses);
        
        // set the email cookie
        Cookie c = new Cookie("emailCookie", emailAddress);
        c.setMaxAge(60*60); //set its age to 1 hour
        c.setPath("/"); //allow the entire application to access it
        response.addCookie(c);

        // store an int value as an attribute
        int userID = 8;
        session.setAttribute("userID", userID);

        // forward request and response to JSP page
        String url = "/display_email_entry.jsp";
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException
    {
        this.doPost(request, response);
    }
}
