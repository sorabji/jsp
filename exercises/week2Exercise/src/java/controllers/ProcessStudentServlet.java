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
    try {
      // get data
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");
      String email = request.getParameter("emailAddress");

      // make object
      Student student = new Student(firstName, lastName, email);

      // get path
      String path = getServletContext().getRealPath("/WEB-INF/student.txt");

      // write the student
      StudentIO.writeToFile(student, path);
      request.setAttribute("student", student);

//      out.println("<html>");
//      out.println("<head>");
//      out.println("<title>info for new student</title>");
//      out.println("</head>");
//      out.println("<body>");
//      out.println("<h1>info for new student</h1>");
//      out.println("<table border=\"1\"><tr><td>");
//      out.println("first name: </td><td>");
//      out.println(student.getFirstName());
//      out.println("</td></tr><tr><td>");
//      out.println("last name: </td><td>");
//      out.println(student.getLastName());
//      out.println("</td></tr><tr><td>");
//      out.println("email address: </td><td>");
//      out.println(student.getEmail());
//      out.println("</td></tr>");
//      out.println("</table>");
//      out.println("</body>");
//      out.println("</html>");
    } finally {
//      out.close();
      request.getRequestDispatcher("views/process_student_handler.jsp").forward(request, response);
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
