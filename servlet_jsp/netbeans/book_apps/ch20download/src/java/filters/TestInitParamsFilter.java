package filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TestInitParamsFilter implements Filter
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
        ServletContext sc = filterConfig.getServletContext();

        String filterName = filterConfig.getFilterName();

        String logFilename = filterConfig.getInitParameter("logFilename");

        sc.log(filterName  + " | logFilename: " + logFilename);
        
        chain.doFilter(request, response);
    }
    
    public void destroy()
    {
        filterConfig = null;
    }
}