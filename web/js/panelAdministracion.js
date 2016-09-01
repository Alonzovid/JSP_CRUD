
$(function(){
    
    function validar_fields(nombre, descripcion, precio, categoria, detalles, reviews, size, color){
        
//        100 fue el maximo que se colocó en la base de datos 
        if(nombre.length > 1 && nombre.length <=100){
            if(descripcion.length > 1 && descripcion.length <=1000){
                 if(precio.length > 0 && precio.length < 10){
                    //funcion para saber si el campo contiene numeros
                    if($.isNumeric(precio)){
                        
                        
                        if(categoria.length>1 && categoria.length<=20){
                            if(detalles.length>1 && detalles.length<=500){
                                if(reviews.length>1 && reviews.length<=500){
                                    return true;
                                }else{
                                    alert("Debe ingresar un detalle valido");
                                }
                            }else{
                                alert("Debe ingresar un detalle valido");
                            }
                        }else{
                            alert("Debe ingresar una categoria correcta");
                        }
                        
                        
                    }else{
                        alert("Debe ingresar un numero valido");
                    }
                }else{
                    alert("El campo precio se encuentra vacio");
                }
            }else{
                alert("Escriba una descripcion correcta");
            }
        }else{
            alert("Escriba un nombre correcto");
        }
        
        return false;
    }
    
    
   $('tr #btn_eliminar').click(function(e){
       e.preventDefault();
       var opcion = confirm("Desea Eliminar el producto");
       if(opcion){
           var fila = $(this).parent().parent();
            //Enlace donde estamos dando click: this
            //doble parent por tr y td
            var idProducto = fila.find('#id_producto').text();
            var data = {idProducto: idProducto};
            $.post("eliminar_producto", data, function(resultado, estado, jqXHR){
                alert(resultado);
                fila.remove();
            });
       }
       
   }) ;
   

    $('#btnModificarProducto').click(function(e){
       e.preventDefault();
       var data = $('#frm_modificar').serialize();       
       $.post("modificar_producto", data, function(res, est, jqXHR){
           alert(res);
           window.location='administracion_producto.jsp';
       });
   });
});

