package filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TestFilter2 implements Filter
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

        String filterName = filterConfig.getFilterName();
        String servletPath = "Servlet path: " + httpRequest.getServletPath();

        sc.log(filterName  + " | " + servletPath + " | before request");
        
        chain.doFilter(httpRequest, response);

        sc.log(filterName  + " | " + servletPath + " | after request");
    }
    
    public void destroy()
    {
         filterConfig = null;
   }
}