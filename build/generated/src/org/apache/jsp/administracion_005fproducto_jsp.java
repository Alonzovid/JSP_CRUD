package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Producto;

public final class administracion_005fproducto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/panelAdministracion.js\"></script>\n");
      out.write("        <title>Página de Administración</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 String[][] datos = null;
            Producto p = new Producto();
            datos = p.producto_x_todas();
            int a =0;
            if(!datos.equals("Sin resultados")){
                
            
        
      out.write("\n");
      out.write("        <h1>Panel de Administracion</h1>\n");
      out.write("        \n");
      out.write("        <table border=\"1\">\n");
      out.write("\t<tr>\n");
      out.write("            <th>ID</th>\n");
      out.write("            <th>Nombre</th>\n");
      out.write("            <th>Precio</th>\n");
      out.write("            <th>Categoria</th>\n");
      out.write("            <th>Acciones</th>\n");
      out.write("\t</tr>\n");
      out.write("        ");
  
            for(int i = 0; i<datos.length; i++){
        
      out.write("\n");
      out.write("\t<tr>\n");
      out.write("            <td id='id_producto'  >");
      out.print( datos[i][0] );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( datos[i][1] );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( datos[i][3] );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( datos[i][4] );
      out.write("</td>\n");
      out.write("            <td><a id='btn_eliminar' href='eliminar_producto?idProducto=");
      out.print( datos[i][0] );
      out.write("' >Eliminar</a> <a id='btn_modificar' href='modificar_producto.jsp?idProducto=");
      out.print( datos[i][0] );
      out.write("'>Modificar</a></td>\n");
      out.write("\t</tr>\n");
      out.write("        ");
  } 
            }else{
        
      out.write("\n");
      out.write("        <h1>No day datos en la BD...</h1>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("</table>\n");
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
