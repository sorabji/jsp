package http;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;

public class GetRequestHeadersExcelServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {
        StringBuilder returnString = new StringBuilder();
        returnString.append(request.getMethod() + " " 
            + request.getRequestURL() + " " 
            + request.getProtocol() + "\n\n");
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = (String) headerNames.nextElement();
            String value = request.getHeader(name);
            returnString.append(name + "\t" + value + "\n");
        }
        int length = returnString.length();
        response.setContentLength(length);
        response.setContentType("application/vnd.ms-excel");
        response.setIntHeader("cache-control", 60 * 60);

        PrintWriter out = response.getWriter();
        out.println(returnString);
    }
}