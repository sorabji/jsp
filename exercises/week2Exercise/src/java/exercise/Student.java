/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.io.Serializable;

/**
 *
 * @author laptop
 */
public class Student implements Serializable{
  String firstName;
  String lastName;
  String email;

  public Student(){
    this.firstName = "";
    this.lastName = "";
    this.email = "";
  }

  public Student(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + '}';
  }







}
