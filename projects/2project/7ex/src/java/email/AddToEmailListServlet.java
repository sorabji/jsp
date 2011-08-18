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

        //yay for relative paths?
        ServletConfig config = this.getServletConfig();
        String path = config.getInitParameter("EmailListPath");
        path = getServletContext().getRealPath(path);

        // get a relative file name
        //ServletContext context = getServletContext();
        //String path = context.getRealPath("/WEB-INF/EmailList.txt");

        // use regular Java classes
        User user = new User(firstName, lastName, emailAddress);


        UserIO.addRecord(user, path);

        String msg,url;
        if(firstName.equals("") || lastName.equals("") || emailAddress.equals("")){
            url = "/join_email_list.jsp";
            msg = "please fill out the form properly";
        } else {
            url = "/display_email_entry.jsp";
            msg = "";
        }

        // store the User object in the request object
        request.setAttribute("user", user);
        request.setAttribute("msg", msg);

        // forward request and response objects to JSP page
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
