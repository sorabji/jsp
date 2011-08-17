/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.StudentIO;
import exercise.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author laptop
 */
public class ProcessStudentServlet extends HttpServlet {

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
    PrintWriter out = response.getWriter();
    String url = "";
    Student student = new Student();
    String message = "";
    try {
      // get data
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");
      String email = request.getParameter("emailAddress");

      // make object
      student = new Student(firstName, lastName, email);

      request.getSession().setAttribute("student", student);

      // validate
      if (student.getFirstName().equals("")) {
        message += "first name cannot be blank<br />";
      }
      if (student.getLastName().equals("")) {
        message += "last name cannot be blank<br />";
      }
      if (student.getEmail().equals("")) {
        message += "email cannot be blank<br />";
      }
      if (!message.equals("")){
        url = "/views/add_student_2.jsp";
      } else {
        url = "/views/process_student_handler.jsp";
        // get path
        String path = getServletContext().getRealPath("/WEB-INF/student.txt");

        // write the student
        StudentIO.writeToFile(student, path);
      }
    } finally {
//      out.close();
        request.setAttribute("student", student);
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
