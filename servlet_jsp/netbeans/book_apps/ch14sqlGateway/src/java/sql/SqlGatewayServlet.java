package sql;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

public class SqlGatewayServlet extends HttpServlet
{    
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response)
                          throws ServletException, IOException
    {        
        String sqlStatement = request.getParameter("sqlStatement");
        String sqlResult = "";
        
        try
        {
            // get a connection
            String dbURL = "jdbc:mysql://localhost:3306/murach";
            String username = "root";
            String password = "sesame";
            Connection connection = DriverManager.getConnection(
                dbURL, username, password);

            // create a statement
            Statement statement = connection.createStatement();

            // parse the SQL string
            sqlStatement = sqlStatement.trim();
            if (sqlStatement.length() >= 6)
            {
                String sqlType = sqlStatement.substring(0, 6);
                if  (sqlType.equalsIgnoreCase("select"))
                {
                    // create the HTML for the result set
                    ResultSet resultSet = 
                            statement.executeQuery(sqlStatement);
                    sqlResult = SQLUtil.getHtmlTable(resultSet);
                    resultSet.close();
                }
                else
                {
                    int i = statement.executeUpdate(sqlStatement);
                    if (i == 0) // a DDL statement
                        sqlResult = "The statement executed successfully.";
                    else        // an INSERT, UPDATE, or DELETE statement
                        sqlResult = "The statement executed successfully.<br>"
                                + i + " row(s) affected.";
                }
            }
            statement.close();
            connection.close();            
        }
        catch(SQLException e)
        {
            sqlResult = "Error executing the SQL statement: <br>"
                    + e.getMessage();
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("sqlResult", sqlResult);
        session.setAttribute("sqlStatement", sqlStatement);
        
        String url = "/sql_gateway.jsp";
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }    
}