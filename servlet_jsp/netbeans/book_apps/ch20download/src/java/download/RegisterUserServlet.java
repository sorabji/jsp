package download;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import business.User;
import data.UserIO;

public class RegisterUserServlet extends HttpServlet
{    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {      
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");
        
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmailAddress(emailAddress);

        ServletContext sc = getServletContext();
        String path = sc.getRealPath("WEB-INF/EmailList.txt");

        UserIO.add(user, path);
        
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        String productCode = (String) session.getAttribute("productCode");
        
        Cookie emailCookie = new Cookie("emailCookie", emailAddress);
        emailCookie.setMaxAge(60*60*24*365*2); //set its age to 2 years
        emailCookie.setPath("/"); //allow the entire application to access it
        response.addCookie(emailCookie);
        
        String url = "/" + productCode + "_download.jsp";
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);        
    }
}
