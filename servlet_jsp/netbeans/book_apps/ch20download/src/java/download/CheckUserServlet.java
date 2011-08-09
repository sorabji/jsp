package download;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import business.User;
import data.UserIO;
import util.CookieUtil;

public class CheckUserServlet extends HttpServlet
{   
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {       
        String productCode = request.getParameter("productCode");

        HttpSession session = request.getSession();
        session.setAttribute("productCode", productCode);
        User user = (User) session.getAttribute("user");

        String url = "";

        // if the User object doesn't exist, check for the email cookie       
        if (user == null)
        {
            Cookie[] cookies = request.getCookies();
            String emailAddress =
                    CookieUtil.getCookieValue(cookies, "emailCookie");
            
            // if the email cookie doesn't exist, go to the registration page
            // otherwise, create the User object from the email cookie 
            // and skip the registration page
            if (emailAddress == null || emailAddress.equals(""))
            {
                url = "/register.jsp";
            }            
            else
            {
                ServletContext sc = getServletContext();
                String path = sc.getRealPath("WEB-INF/EmailList.txt");
                user = UserIO.getUser(emailAddress, path);
                session.setAttribute("user", user);
                url = "/" + productCode + "_download.jsp";
            }
        }
        
        // if the User object exists, skip the registration page
        else
        {
            url = "/" + productCode + "_download.jsp";
        }

        // forward to the view
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
