package http;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;
import java.sql.*;
import java.util.zip.*;

import data.*;

public class ReturnUserTableWithGZIPServlet extends HttpServlet
{    
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {
        String encodingString = request.getHeader("accept-encoding");
        PrintWriter out;
        if (encodingString != null && encodingString.indexOf("gzip") > -1)
        {
            OutputStream outputStream = response.getOutputStream();
            out = new PrintWriter(
                    new GZIPOutputStream(outputStream), false);
            response.setHeader("content-encoding", "gzip");
            // System.out.println("User table encoded with gzip");
        }
        else
        {
            out = response.getWriter();
            // System.out.println("User table not encoded with gzip");
        }
        
        String query = "SELECT * FROM User ORDER BY UserID";
        String d = "\t";
        StringBuilder report = new StringBuilder("The User table\n\n"
                + "UserID" + d
                + "LastName" + d
                + "FirstName" + d
                + "EmailAddress" + "\n");
        try
        {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next())
            {
                report.append(results.getInt("UserID") + d
                        + results.getString("LastName")+ d
                        + results.getString("FirstName") + d
                        + results.getString("EmailAddress") + "\n");
            }
            results.close();
            statement.close();
            connection.close();
        }
        catch(SQLException e)
        {
            this.log(e.toString());
        }
        
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("cache-control", "300");
        
        out.println(report);
        out.close();
    }    
}