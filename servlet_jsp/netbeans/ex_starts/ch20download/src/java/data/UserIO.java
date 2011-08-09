package data;

import java.io.*;
import java.util.*;

import business.User;

public class UserIO
{
    public static boolean add(User user, String filepath)
    {
        try
        {
            File file = new File(filepath);
            PrintWriter out = new PrintWriter(
                    new FileWriter(file, true));
            out.println(user.getEmailAddress()+ "|"
                    + user.getFirstName() + "|"
                    + user.getLastName());

            out.close();
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static User getUser(String emailAddress, String filepath)
    {
        try
        {
            File file = new File(filepath);
            BufferedReader in = new BufferedReader(
                    new FileReader(file));
            User user = new User();
            String line = in.readLine();
            while (line != null)
            {
                StringTokenizer t = new StringTokenizer(line, "|");
                String email = t.nextToken();
                if (t.countTokens() < 3)
                {
                    return new User("", "", "");
                }
                if (email.equalsIgnoreCase(emailAddress))
                {
                    String firstName = t.nextToken();
                    String lastName = t.nextToken();
                    user.setEmailAddress(emailAddress);
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                }
                line = in.readLine();
            }
            in.close();
            return user;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<User> getUsers(String filepath)
    {
        try
        {
            ArrayList<User> users = new ArrayList<User>();
            BufferedReader in = new BufferedReader(
                    new FileReader(filepath));
            String line = in.readLine();
            while (line != null)
            {
                StringTokenizer t = new StringTokenizer(line, "|");
                String emailAddress = t.nextToken();
                String firstName = t.nextToken();
                String lastName = t.nextToken();
                User user = new User(firstName, lastName, emailAddress);
                users.add(user);
                line = in.readLine();
            }
            in.close();
            return users;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}