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
        // get parameters from the request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        // create the User object
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmailAddress(emailAddress);

        // store the User object in the session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        String url = "";
        if (firstName.length() == 0  || firstName == null ||
            lastName.length() == 0   || lastName == null ||
            emailAddress.length()==0 || emailAddress == null)
        {
            // forward to the view to get missing parameters
            url = "/join_email_list.jsp";
        }
        else
        {
            // write the User object to a file
            ServletContext sc = getServletContext();
            String path = sc.getRealPath("/WEB-INF/EmailList.txt");
            UserIO.addRecord(user, path);

            // forward to the view
            url = "/display_email_entry.jsp";
        }        

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