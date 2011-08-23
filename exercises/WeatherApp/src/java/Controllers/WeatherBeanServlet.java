/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Data.WeatherBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author laptop
 */
@WebServlet(name = "WeatherBeanServlet", urlPatterns = {"/WeatherBean"})
public class WeatherBeanServlet extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    WeatherBean weather = null;
    String url = "";
    String message = "";
    try {
      // validate
      if (request.getParameter("temp").equals("")){
        message += "Temperature cannot be blank<br />";
      }
      if (request.getParameter("humidity").equals("")){
        message += "Humidity cannot be blank<br />";
      }
      if (request.getParameter("pressure").equals("")){
        message += "Pressure cannot be blank<br />";
      }
      if (!message.equals("")){
        url = "/views/input.jsp";
        weather = new WeatherBean(0,0,0);
      } else {
        //url = "/views/process_student_handler.jsp";
        url = "/views/DisplayWeather.jsp";
        message = "good job!";
        // get data
        double temp = Double.parseDouble(request.getParameter("temp"));
        double humidity = Double.parseDouble(request.getParameter("humidity"));
        double pressure = Double.parseDouble(request.getParameter("pressure"));

        // make object
        weather = new WeatherBean(temp,humidity,pressure);

      }
    } catch (Exception e){
      message = "you entered some values that cannot be parsed into numbers!";


    } finally {
        request.setAttribute("weather", weather);
        request.setAttribute("message", message);
        request.getRequestDispatcher(url).forward(request, response);
    }


  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
}
