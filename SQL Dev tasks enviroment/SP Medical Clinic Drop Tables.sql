CREATE PROCEDURE DropTables
AS
BEGIN
-- Desactivar las restricciones de clave foranea para evitar errores de dependencia
EXEC sp_MSforeachtable "ALTER TABLE ? NOCHECK CONSTRAINT ALL";
-- Eliminar las tablas en el orden adecuado (de las dependientes a las independientes)
DROP TABLE PrescripcionMedicamento;
DROP TABLE Prescripcion;
DROP TABLE Citas;
DROP TABLE HistorialMedico;
DROP TABLE Especialidades;
DROP TABLE Personas;
DROP TABLE Roles;
DROP TABLE Consultorios;
DROP TABLE Medicamentos;
-- Volver a activar las restricciones de clave foranea
EXEC sp_MSforeachtable "ALTER TABLE ? CHECK CONSTRAINT ALL";
PRINT 'Tablas eliminadas correctamente.';
END;
