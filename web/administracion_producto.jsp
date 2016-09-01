<%-- 
    Document   : administracion_producto
    Created on : 30/08/2016, 10:32:58 PM
    Author     : dajua
--%>

<%@page import="Modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery.min.js"></script>
        <script src="js/panelAdministracion.js"></script>
        <title>Página de Administración</title>
    </head>
    <body>
        <% String[][] datos = null;
            Producto p = new Producto();
            datos = p.producto_x_todas();
            if(datos.length != 0){
                
            
        %>
        <h1>Panel de Administracion</h1>
        
        <table border="1">
	<tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Categoria</th>
            <th>Acciones</th>
	</tr>
        <%  
            for(int i = 0; i<datos.length; i++){
        %>
	<tr>
            <td id='id_producto'  ><%= datos[i][0] %></td>
            <td><%= datos[i][1] %></td>
            <td><%= datos[i][3] %></td>
            <td><%= datos[i][4] %></td>
            <td><a id='btn_eliminar' href='eliminar_producto?idProducto=<%= datos[i][0] %>' >Eliminar</a> <a id='btn_modificar' href='modificar_producto.jsp?idProducto=<%= datos[i][0] %>'>Modificar</a></td>
	</tr>
        <%  } 
            }else{
        %>
        <h1>No day datos en la BD...</h1>
        <%
            }
        %>
</table>
    </body>
</html>
