<%-- 
    Document   : crear_producto
    Created on : 30/08/2016, 09:46:52 PM
    Author     : dajua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
        <title>Crear Producto</title>
    </head>
    <body>
        <h1>Nuevo Producto</h1>
        <form action="crear_producto" name="frmNuevo" id="frm_nuevo" method="POST" enctype="multipart/form-data" >
            <table>
                <tr>
                    <td><label for="">Nombre:</label></td>
                    <td><input type="text" name="nombre" id="nombre"></td>
                </tr>
                <tr>
                    <td><label for="">Descripcion:</label></td>
                    <td><textarea cols="30" rows="6" name="descripcion" id="descripcion"></textarea></td>
                </tr>
                <tr>
                    <td><label for="">Precio:</label></td>
                    <td><input type="text" name="precio" id="precio"></td>
                </tr>
                <tr>
                    <td><label for="">Categoria:</label></td>
                    <td><input type="text" name="categoria" id="categoria"></td>
                </tr>
                <tr>
                    <td><label for="">Detalles:</label></td>
                    <td><textarea cols="30" rows="6" name="detalles" id="detalles"></textarea></td>
                </tr>
                <tr>
                    <td><label for="">Review:</label></td>
                    <td><textarea cols="30" rows="6" name="reviews" id="reviews"></textarea></td>
                </tr>
                <tr>
                    <td><label for="">Size:</label></td>
                    <td>
                        <select name="size" id="size">
                            <option value="Seleccione una opcion">Seleccione una opcion</option>
                            <% for(int i = 1; i<=20; i++){ %>
                            <option value ='<%= i %>' > <%= i %> </option>
                            <% }%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for="">Color:</label></td>
                    <td><input type="text" name="color" id="color"></td>
                </tr>
                <tr>
                    <td><label for="">Imagenes:</label></td>
                    <!-- el multiple sirve para seleccionar varios archivos -->
                    <td><input type="file" name="file[]" id="archivos" multiple></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Crear Producto" id="btnCrearProducto"></td>
                </tr>
                
                
            </table>
        </form>
    </body>
</html>
