package tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import java.text.DateFormat;

public class CurrentDateTag extends TagSupport
{
    public int doStartTag() throws JspException
    {
        Date currentDate = new Date();
        DateFormat shortDate = DateFormat.getDateInstance(DateFormat.SHORT);
        String currentDateFormatted = shortDate.format(currentDate);

        try
        {
            JspWriter out = pageContext.getOut();
            out.print(currentDateFormatted);
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        return SKIP_BODY;
    }
}