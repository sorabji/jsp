package filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogRequestFilter implements Filter
{    
    private FilterConfig filterConfig = null;
    
    public void init(FilterConfig filterConfig)
    {        
        this.filterConfig = filterConfig;
    }

    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        ServletContext sc = filterConfig.getServletContext();
        
        String logString = filterConfig.getFilterName() + " | ";
        logString += "Servlet path: " + httpRequest.getServletPath() + " | ";

        Cookie[] cookies = httpRequest.getCookies();
        String emailAddress = util.CookieUtil.getCookieValue(
                cookies, "emailCookie");
        logString += "Email cookie: ";
        if (emailAddress.length() != 0)
            logString += emailAddress;
        else
            logString += "Not found";

        sc.log(logString);
        
        chain.doFilter(httpRequest, response);
    }
     
    public void destroy()
    {
        filterConfig = null;
    }
}