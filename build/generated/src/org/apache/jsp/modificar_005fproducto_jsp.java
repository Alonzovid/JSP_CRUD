package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Producto;

public final class modificar_005fproducto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Modificar Producto</h1>\n");
      out.write("        ");
 
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            Producto p = new Producto();
            String[] producto = p.producto_x_id(idProducto);
        
      out.write("\n");
      out.write("        <form action=\"crear_producto\" name=\"frmNuevo\" id=\"frm_nuevo\" method=\"POST\" enctype=\"multipart/form-data\" >\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Nombre:</label></td>\n");
      out.write("                    <td><input type=\"text\" name=\"nombre\" id=\"nombre\" value=\"");
      out.print( producto[1] );
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Descripcion:</label></td>\n");
      out.write("                    <td><textarea cols=\"30\" rows=\"6\" name=\"descripcion\" id=\"descripcion\"></textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Precio:</label></td>\n");
      out.write("                    <td><input type=\"text\" name=\"precio\" id=\"precio\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Categoria:</label></td>\n");
      out.write("                    <td><input type=\"text\" name=\"categoria\" id=\"categoria\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Detalles:</label></td>\n");
      out.write("                    <td><textarea cols=\"30\" rows=\"6\" name=\"detalles\" id=\"detalles\"></textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Review:</label></td>\n");
      out.write("                    <td><textarea cols=\"30\" rows=\"6\" name=\"reviews\" id=\"reviews\"></textarea></td>\n");
      out.write("                </tr>\n");
      out.write("               \n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td><input type=\"submit\" value=\"Modificar Producto\" id=\"btnModificarProducto\"></td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
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
