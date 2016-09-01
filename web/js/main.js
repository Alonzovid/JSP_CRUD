
$(function(){
    //alert();
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
                                    if(size !== "Seleccione una opcion"){
                                        if(color.length>1 && color.length<20){
                                            
                                            //Empezamos con la validacion del file
                                            var archivos = document.getElementById('archivos').files;
                                            
                                            if(archivos.length == 5){
                                                for(var i = 0; i<archivos.length; i++){
                                                    var name = archivos[i].name;
                                                    var ext = name.substring(name.lastIndexOf('.')+1).toLowerCase();
                                                    if(ext != 'jpg' && ext!='png'){
                                                        alert('Archivo '+name+' incorrecto, solo imagenes jpg o png');
                                                        return false;
                                                    }
                                                }
                                                return true;
                                            }else{
                                                alert("Por favor seleccionar 5 imagenes");
                                            }
                                            
                                            
                                        }else{
                                            alert("Debe ingresar un color");
                                        }
                                    }else{
                                        alert("Seleccione un tamaño");
                                    }
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
    
    // #btnCrearProducto > nombre del ID del boton
    // # hace referencia a que es un ID
    $('#btnCrearProducto').click(function(e){
        e.preventDefault();
        var nombre = $('#nombre').val();
        var descripcion = $('#descripcion').val();
        var precio = $('#precio').val();
        var categoria = $('#categoria').val();
        var detalles = $('#detalles').val();
        var reviews = $('#reviews').val();
        var size = $('#size').val();
        var color = $('#color').val();
        
        if(validar_fields(nombre, descripcion, precio, categoria, detalles, reviews, size, color)){
            
            //funcion ajax para enviar lso datos
            var data = new FormData($('#frm_nuevo')[0]);
            $.ajax({
               url : "crear_producto",
               type : "post",
               data : data,
               contentType: false,
               processData: false,
               success : function(data){
                   alert(data);
               }
            });   
        }
    });
});


