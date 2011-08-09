package email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.mail.MessagingException;

import business.User;
import data.UserIO;
import util.*;

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

        // create the User object and write it to a file
        User user = new User(firstName, lastName, emailAddress);
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/EmailList.txt");
        UserIO.addRecord(user, path);
        
        // store the User object in the session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        
        // send email to user
        String to = emailAddress;
        String from = "email_list@murach.com";
        String subject = "Welcome to our email list";
        String body = "Dear " + firstName + ",\n\n" +
            "Thanks for joining our email list. We'll make sure to send " +
            "you announcements about new products and promotions.\n" +
            "Have a great day and thanks again!\n\n" +
            "Kelly Slivkoff\n" +
            "Mike Murach & Associates";
        boolean isBodyHTML = false;

        try
        {
            MailUtilLocal.sendMail(to, from, subject, body, isBodyHTML);
        }
        catch (MessagingException e)
        {
            String errorMessage = 
                "ERROR: Unable to send email. " + 
                    "Check Tomcat logs for details.<br>" +
                "NOTE: You may need to configure your system " + 
                    "as described in chapter 15.<br>" +
                "ERROR MESSAGE: " + e.getMessage();
            request.setAttribute("errorMessage", errorMessage);
            this.log(
                "Unable to send email. \n" +
                "Here is the email you tried to send: \n" +
                "=====================================\n" +
                "TO: " + emailAddress + "\n" +
                "FROM: " + from + "\n" +
                "SUBJECT: " + subject + "\n" +
                "\n" +
                body + "\n\n");
        }
        
        // forward request and response to JSP page
        String url = "/display_email_entry.jsp";
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);        
    }    
}