CREATE PROCEDURE DropTablesTSENormalizado
AS
BEGIN
-- Desactivar las restricciones de clave foranea para evitar errores de dependencia
EXEC sp_MSforeachtable "ALTER TABLE ? NOCHECK CONSTRAINT ALL";
-- Eliminar las tablas en el orden adecuado (de las dependientes a las independientes)
DROP TABLE Ciudadano
DROP TABLE LugarElectoral
DROP TABLE Distrito
DROP TABLE Canton
DROP TABLE Provincia
-- Volver a activar las restricciones de clave foranea
EXEC sp_MSforeachtable "ALTER TABLE ? CHECK CONSTRAINT ALL";
PRINT 'Tablas eliminadas correctamente.';
END;
