
--CREAR BASE DE DATOS
CREATE DATABASE tallerjdbc;

--CREAR TABLA vehiculos
CREATE TABLE vehiculos(
placa VARCHAR(10) PRIMARY KEY,
marca VARCHAR(50) NOT NULL,
modelo VARCHAR(50) NOT NULL,
anio INT NOT NULL,
precio DOUBLE PRECISION NOT NULL,
color VARCHAR(30),
disponible BOOLEAN NOT NULL
);


--INSERT DE PRUEBA

INSERT INTO vehiculos (placa, marca, modelo, anio, precio, color, disponible)
VALUES('ABC123','CHEVROLET','SAIL',2025,15000,'ROJO',true);


--MODIFICAR TABLA PARA AGREGAR CAMPO KILOMETRAJE
ALTER TABLE vehiculos
ADD kilometraje INT;



--DROP TABLE vehiculos;
select * from vehiculos; 