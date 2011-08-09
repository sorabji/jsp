package email;

public class JSSETest
{
    public static void main(String[] args)
    {
        try
        {
            Class.forName("com.sun.net.ssl.internal.ssl.Provider");
            System.out.println("JSSE is installed correctly.");
        }
        catch(Exception e)
        {
            System.out.println("JSSE is NOT installed correctly.");
        }        
    }
}
