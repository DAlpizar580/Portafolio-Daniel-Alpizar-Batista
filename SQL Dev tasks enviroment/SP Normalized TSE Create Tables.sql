CREATE PROCEDURE CrearTablasTSENormalizado
AS
BEGIN
-- Tabla: Provincia
CREATE TABLE Provincia (
provincia_id INT IDENTITY(1,1) PRIMARY KEY,
provincia_nombre VARCHAR(50) NOT NULL UNIQUE
);
-- Tabla: Canton
CREATE TABLE Canton (
canton_id INT IDENTITY(1,1) PRIMARY KEY,
nombre_canton VARCHAR(50) NOT NULL,
provincia_id INT NOT NULL,
CONSTRAINT FK_Canton_Provincia FOREIGN KEY (provincia_id) REFERENCES
Provincia(provincia_id)
);
-- Tabla: Distrito
CREATE TABLE Distrito (
distrito_id INT IDENTITY(1,1) PRIMARY KEY,
nombre_distrito VARCHAR(50) NOT NULL,
canton_id INT NOT NULL,
CONSTRAINT FK_Distrito_Canton FOREIGN KEY (canton_id) REFERENCES
Canton(canton_id)
);
CREATE TABLE LugarElectoral (
codigo_electoral INT PRIMARY KEY,
distrito_id INT NOT NULL,
CONSTRAINT FK_LugarElectoral_Distrito FOREIGN KEY (distrito_id) REFERENCES
Distrito(distrito_id)
);
CREATE TABLE Ciudadano (
cedula INT PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
primer_apellido VARCHAR(50) NOT NULL,
segundo_apellido VARCHAR(50) NOT NULL,
fecha_caducidad DATE NOT NULL,
codigo_electoral INT NOT NULL,
CONSTRAINT FK_Ciudadano_LugarElectoral FOREIGN KEY (codigo_electoral)
REFERENCES LugarElectoral(codigo_electoral)
);
END;
