/*
 * URL: crear_producto
 */
package Servlet;

import Modelo.Producto;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author dajua
 */
@WebServlet(name = "NuevoProducto", urlPatterns = {"/crear_producto"})
public class NuevoProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            /* IMPORTANTE:
            * Por lo general cuando se recibe campos se hace con request.getParameter();
            * pero como se utiliza entype="multiplart/form-data" no se puede recibir los datos
            * directamente de crea_producto.jsp porque nos enviara datos nulos
            * en este caso se utilizaran OTRAS LIBRERIA para poder recibir los datos.
            * SE ANADE:  COMMMONS
            */
            
            FileItemFactory fif = new DiskFileItemFactory();
            //Subir archivos
            ServletFileUpload sfu = new ServletFileUpload(fif);
            
            //Arreglo para guardar lso campos
            ArrayList<String> campos = new ArrayList<>();
            //Arreglo para guardar los files.
            ArrayList<String> files = new ArrayList<>();
            
            try {
                //Lista para recibir TODOS los datos
                List items = sfu.parseRequest(request);
                //Recorre la lista de items
                for(int i = 0; i<items.size(); i++){
                    //Se le asigna  a fi cada elemento que se vaya recorriendo
                    FileItem fi = (FileItem) items.get(i);
                    
                    /*Si es un campo de formulario o sino lo es 
                    * es decir, campos de formulario: texto, radio, etc.
                    * campos de NO formulario: tipos file
                    */
                    if(!fi.isFormField()){
                        String path = "C:\\Users\\dajua\\Documents\\NetBeansProjects\\JSP_CRUD\\web\\img\\productos\\"+fi.getName();
                        File archivo = new File(path);
                        fi.write(archivo);
                        files.add("img/productos/"+fi.getName());
                    }else{
                        campos.add(fi.getString());                        
                    }
                }
            } catch (Exception e) {
            }
            
            Producto p = new Producto();
            boolean exito = p.crear_producto(campos.get(0), campos.get(1), Float.parseFloat(campos.get(2)), campos.get(3), campos.get(4), campos.get(5), Integer.parseInt(campos.get(6)), campos.get(7), files.get(0), files.get(1), files.get(2), files.get(3), files.get(4));
            if(exito){
                response.getWriter().println("Producto Creado Exitosamente");
            }else{
                response.getWriter().println("ERROR al crear producto");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
