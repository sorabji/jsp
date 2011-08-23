package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class input_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>JSP Page</title>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("\n");
      out.write("  ");
      Data.WeatherBean weather = null;
      synchronized (request) {
        weather = (Data.WeatherBean) _jspx_page_context.getAttribute("weather", PageContext.REQUEST_SCOPE);
        if (weather == null){
          weather = new Data.WeatherBean();
          _jspx_page_context.setAttribute("weather", weather, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("    <h1>enter the weather data</h1>\n");
      out.write("    <form action=\"\" method=\"post\">\n");
      out.write("    <table cellspacing=\"5\" border=\"0\">\n");
      out.write("        <tr>\n");
      out.write("            <td align=\"right\">Temperature:</td>\n");
      out.write("            <td><input type=\"text\"\n");
      out.write("                       name=\"temp\"\n");
      out.write("                       value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Data.WeatherBean)_jspx_page_context.findAttribute("weather")).getTemp())));
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td align=\"right\">Humidity:</td>\n");
      out.write("            <td><input type=\"text\"\n");
      out.write("                       name=\"humidity\"\n");
      out.write("                       value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Data.WeatherBean)_jspx_page_context.findAttribute("weather")).getHumidity())));
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td align=\"right\">Pressure:</td>\n");
      out.write("            <td><input type=\"text\"\n");
      out.write("                       name=\"pressure\"\n");
      out.write("                       value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Data.WeatherBean)_jspx_page_context.findAttribute("weather")).getPressure())));
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td></td>\n");
      out.write("            <td><br><input type=\"submit\" value=\"Submit\"></td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
