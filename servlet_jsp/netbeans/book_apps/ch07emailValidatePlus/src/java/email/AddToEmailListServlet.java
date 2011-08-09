package email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import business.User;
import data.UserIO;

public class AddToEmailListServlet extends HttpServlet
{    
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException
    {
        // get parameters from the form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        // create user from the parameters
        User user = new User(firstName, lastName, emailAddress);

        // validate the parameters
        String message = "";
        String url = "";
        if (firstName.length() == 0 || 
            lastName.length() == 0  ||
            emailAddress.length() == 0)
        {
            message = "Please fill out all three text boxes.";
            url = "/join_email_list.jsp";
        }
        else
        {
            message = "";

            // read the relative path from the web.xml file
            ServletConfig config = this.getServletConfig();
            String relativePath = config.getInitParameter("relativePathToFile");

            // write the data to the file
            ServletContext context = getServletContext();
            String path = context.getRealPath(relativePath);
            UserIO.addRecord(user, path);

            // test the context init parameter
            String custServEmail = context.getInitParameter("custServEmail");
            System.out.println("custServEmail: " + custServEmail);

            // NOTE: If you want to test the error_java.jsp page,
            // you can cause Java to throw a runtime exception
            // by removing the front slash from the following url
            url = "/display_email_entry.jsp";
        }
        request.setAttribute("user", user);
        request.setAttribute("message", message);

        // forward request and response to the view
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);        
    }    
}
