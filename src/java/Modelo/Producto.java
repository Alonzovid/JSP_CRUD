/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author dajua
 */
public class Producto extends Conector {

    private String tabla = "producto";
    public boolean crear_producto(String nombre, String descripcion, float precio, String categoria,
            String detalles, String reviews, int size, String color, String img1, String img2, String img3,
            String img4, String img5) {
        boolean flag = false;

        nombre = comilla + nombre + comilla;
        descripcion = comilla + descripcion + comilla;
        categoria = comilla + categoria + comilla;
        detalles = comilla + detalles + comilla;
        reviews = comilla + reviews + comilla;
        color = comilla + color + comilla;
        img1 = comilla + img1 + comilla;
        img2 = comilla + img2 + comilla;
        img3 = comilla + img3 + comilla;
        img4 = comilla + img4 + comilla;
        img5 = comilla + img5 + comilla;

        String SQL2 = "CALL insertProducto(" + nombre + "," + descripcion + "," + precio + "," + categoria + "," + detalles + "," + reviews + ","
                + "" + size + "," + color + "," + img1 + "," + img2 + "," + img3 + "," + img4 + "," + img5 + ")";
        
        String SQL = "INSERT INTO "+tabla+"(nombre, descripcion, precio, categoria, detalles, reviews, "
                + "    size, color, imagen_1, imagen_2, imagen_3, imagen_4, imagen_5)"
                + "    VALUES(" + nombre + "," + descripcion + "," + precio + "," + categoria + "," + detalles + "," + reviews + ","
                + "" + size + "," + color + "," + img1 + "," + img2 + "," + img3 + "," + img4 + "," + img5 + ");";
        
        int resultado = this.insertar_AI(SQL);
        if (resultado != 0) {
            flag = true;
        }

        System.out.println(SQL);
        System.out.println(flag);
        return flag;
    }
    
    public String[][] producto_x_todas(){
        String[][] datosSQL= null;
//        String SQL2 = "SELECT * FROM "+tabla+";";
        String SQL = "CALL selectAllProductos();";
        datosSQL = this.consulta_registros(SQL);
        return datosSQL;        
    }
    
    public String[] producto_x_id(int idProducto){
        String[] dato = null;
        String[][] datosSQL=null;
        String SQL = "SELECT * FROM producto WHERE id_producto = "+idProducto+";";
        datosSQL = this.consulta_registros(SQL);
        dato = datosSQL[0];
        return dato;
    }
    /**
     * IMPORTANTE:
     * A causa de necesitar saber si una consulta tuvo exito se modifico
     * consulta_vacia del conector a booleano para así saber si la ejecución
     * era verdadera o falsa
     * Esto a causa que en los servlet se necesita saber si tuvo exito o no para
     * que despliegue un mensaje con AJAX.
    */
    public boolean actualizar_producto(int idProducto, String nombre, String descripcion, 
            float precio, String categoria, String detalle, String review){
        
        boolean flag = false;
        nombre = comilla + nombre + comilla;
        descripcion = comilla + descripcion + comilla;
        categoria = comilla + categoria + comilla;
        detalle = comilla + detalle + comilla;
        review = comilla + review + comilla;
        String SQL = "CALL updateProducto("+idProducto+","+nombre+","+descripcion+","+precio+","+categoria+","
                +detalle+","+review+");";
        if(this.consulta_vacia(SQL)){
            flag = true;
        }
        
        return flag;
    }    
    
    /**
     * IMPORTANTE:
     * A causa de necesitar saber si una consulta tuvo exito se modifico
     * consulta_vacia del conector a booleano para así saber si la ejecución
     * era verdadera o falsa
     * Esto a causa que en los servlet se necesita saber si tuvo exito o no para
     * que despliegue un mensaje con AJAX.
    */
    
    public boolean eliminar_producto(int idProducto){
        boolean flag = false;
        String SQL = "CALL deleteProducto("+idProducto+");";
        if(this.consulta_vacia(SQL)){
            flag = true;
        }
        System.out.println(SQL);
        return flag;
    }
    /*
    public static void main(String[] args) {
        Producto p = new Producto();
        p.crear_producto(
                "Camisa X",
                "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. "
                + "    Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, "
                + "    cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una "
                + "    galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen.",
                39.99f,
                "Ropa",
                "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. "
                + "    Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, "
                + "    cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una "
                + "    galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen.",
                "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. "
                + "    Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, "
                + "    cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una "
                + "    galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen.",
                7,
                "Negro",
                "img/img_1.jpg",
                "img/img_2.jpg",
                "img/img_3.jpg",
                "img/img_4.jpg",
                "img/img_5.jpg"
        );
    }
    */
}
