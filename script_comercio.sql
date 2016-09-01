CREATE DATABASE comercio;
USE comercio;

CREATE TABLE producto(
	id_producto INT AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(1000) NOT NULL,
    precio FLOAT NOT NULL,
    categoria VARCHAR(20) NOT NULL,
    detalles VARCHAR(500) NOT NULL,
    reviews VARCHAR(1000) NOT NULL,
    size INT NOT NULL,
    color VARCHAR(20) NOT NULL,
    imagen_1 VARCHAR(100) NOT NULL,
    imagen_2 VARCHAR(100) NOT NULL,
    imagen_3 VARCHAR(100) NOT NULL,
    imagen_4 VARCHAR(100) NOT NULL,
    imagen_5 VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_producto)
);

DELIMITER //
CREATE PROCEDURE insertProducto(
	IN 	
		_nombre VARCHAR(100),
		_descripcion VARCHAR(1000),
		_precio FLOAT,
		_categoria VARCHAR(20),
		_detalles VARCHAR(500),
		_reviews VARCHAR(1000),
		_size INT,
		_color VARCHAR(20),
		_imagen_1 VARCHAR(100),
		_imagen_2 VARCHAR(100),
		_imagen_3 VARCHAR(100),
		_imagen_4 VARCHAR(100),
		_imagen_5 VARCHAR(100)
)BEGIN
	INSERT INTO producto(nombre, descripcion, precio, categoria, detalles, reviews, 
    size, color, imagen_1, imagen_2, imagen_3, imagen_4, imagen_5)
    VALUES(_nombre, _descripcion, _precio, _categoria, _detalles, _reviews, _size, _color, 
    _imagen_1, _imagen_2, _imagen_3, _imagen_4, _imagen_5);
END
//DELIMITER ;

CALL insertProducto(
	"Camisa X",
    "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. 
    Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, 
    cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una 
    galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen.",
    39.99,
    "Ropa",
    "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. 
    Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, 
    cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una 
    galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen.",
    "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. 
    Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, 
    cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una 
    galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen.",
    7,
    "Negro", 
    "img/img_1.jpg",
    "img/img_2.jpg",
    "img/img_3.jpg",
    "img/img_4.jpg",
    "img/img_5.jpg"
);


DELIMITER // 
CREATE PROCEDURE selectAllProductos(
	
)BEGIN 
 SELECT * FROM producto;
END 
//DELIMITER ;

CALL selectAllProductos();


DELIMITER //
CREATE PROCEDURE deleteProducto(
	IN _id_producto INT
)BEGIN 
	DELETE FROM producto WHERE id_producto = _id_producto;
END
//DELIMITER ;

DELIMITER //
CREATE PROCEDURE updateProducto(
	IN _id_producto INT,
		_nombre VARCHAR(100),
		_descripcion VARCHAR(1000),
		_precio FLOAT,
		_categoria VARCHAR(20),
		_detalles VARCHAR(500),
		_reviews VARCHAR(1000)
)BEGIN 
	UPDATE producto SET nombre = _nombre, descripcion = _descripcion, precio = _precio, 
    categoria = _categoria, detalles = _detalles, reviews = _reviews WHERE id_producto = _id_producto;
END
//DELIMITER ;


