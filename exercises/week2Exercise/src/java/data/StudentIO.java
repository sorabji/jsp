/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import exercise.Student;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author laptop
 */
public class StudentIO {
  public static void writeToFile(Student student,String filepath) throws IOException{
    File file = new File(filepath);
    PrintWriter out = new PrintWriter(new FileWriter(file,true));
    out.println(student.getFirstName()
            +"|"+student.getLastName()
            +"|"+student.getEmail());
    out.close();
  }
  
}
