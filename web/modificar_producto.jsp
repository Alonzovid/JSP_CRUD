<%-- 
    Document   : modificar_producto
    Created on : 31/08/2016, 09:36:30 PM
    Author     : dajua
--%>

<%@page import="Modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/panelAdministracion.js"></script>
        <title>Actualizar datos de un producto</title>
    </head>
    <body>
        <h1>Modificar Producto</h1>
        <% 
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            Producto p = new Producto();
            String[] producto = p.producto_x_id(idProducto);
        %>
        <form action="modificar_producto" name="frmModificar" id="frm_modificar" method="GET" enctype="multipart/form-data" >
            <table>
                <tr>
                    <td><label for="">ID:</label></td>
                    <td><input type="text" name="idProducto" id="id_producto" value="<%= producto[0] %>"></td>
                </tr>
                <tr>
                    <td><label for="">Nombre:</label></td>
                    <td><input type="text" name="nombre" id="nombre" value="<%= producto[1] %>"></td>
                </tr>
                <tr>
                    <td><label for="">Descripcion:</label></td>
                    <td><textarea cols="30" rows="6" name="descripcion" id="descripcion"><%= producto[2] %></textarea></td>
                </tr>
                <tr>
                    <td><label for="">Precio:</label></td>
                    <td><input type="text" name="precio" id="precio" value="<%= producto[3] %>"></td>
                </tr>
                <tr>
                    <td><label for="">Categoria:</label></td>
                    <td><input type="text" name="categoria" id="categoria" value="<%= producto[4] %>"></td>
                </tr>
                <tr>
                    <td><label for="">Detalles:</label></td>
                    <td><textarea cols="30" rows="6" name="detalles" id="detalles"><%= producto[5] %></textarea></td>
                </tr>
                <tr>
                    <td><label for="">Review:</label></td>
                    <td><textarea cols="30" rows="6" name="reviews" id="reviews"><%= producto[6] %></textarea></td>
                </tr>
                <!--
                <tr>
                    <td><label for="">Imagen</label></td>
                    <td>
                        <img src="<%= producto[9] %>"/>
                    </td>
                </tr>
                -->
                <tr>
                    <td></td>
                    <td><input type="submit" value="Modificar Producto" id="btnModificarProducto"></td>
                </tr>
                
                
            </table>
        </form>
    </body>
</html>
