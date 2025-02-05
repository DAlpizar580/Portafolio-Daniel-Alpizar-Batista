EXEC CrearTablas;
EXEC CrearTablasTSENormalizado;
EXEC DropTables;
EXEC DropTablesTSENormalizado;
EXEC InsertEnTablas;
EXEC InsertsTSENormalizado;
EXEC CursorTelefonos;
EXEC CrearTriggerEvitarInsertProvincia;
INSERT INTO [PF_LenguajeDeBD].[dbo].[Provincia] (provincia_nombre)
VALUES ('Prueba');
EXEC CrearYConsultarVistaVisualizarConsulta;
EXEC CrearLogUpdate;
EXEC CrearLogInsert;
EXEC CrearLogDelete;
CREATE TABLE log_acciones (
id_log INT IDENTITY(1,1) PRIMARY KEY,
usuario VARCHAR(50),
tipo_accion VARCHAR(50),
fecha_hora DATETIME DEFAULT GETDATE()
);
INSERT INTO Ciudadano (cedula, nombre, primer_apellido, segundo_apellido,
fecha_caducidad, codigo_electoral)
VALUES (12345, 'Juan', 'Perez', 'Rodriguez', '2025-12-31', 101001);
UPDATE Ciudadano
SET nombre = 'Juan Carlos'
WHERE cedula = 12345;
DELETE FROM Ciudadano
WHERE cedula = 12345;
