CREATE PROCEDURE CrearTriggerEvitarInsertProvincia
AS
BEGIN
-- Verificar si el trigger ya existe y eliminarlo
IF EXISTS (SELECT * FROM sysobjects WHERE name = 'TRG_Evitar_Insert_Provincia'
AND xtype = 'TR')
BEGIN
DROP TRIGGER TRG_Evitar_Insert_Provincia;
END;
-- Crear el trigger para evitar inserciones usando SQL dinamico
DECLARE @sql NVARCHAR(MAX);
SET @sql = '
CREATE TRIGGER TRG_Evitar_Insert_Provincia
ON Provincia
INSTEAD OF INSERT
AS
BEGIN
PRINT ''No se permite realizar inserciones en la tabla Provincia.'';
THROW 50001, ''Inserciones no permitidas en la tabla Provincia.'', 1;
END;
';
EXEC sp_executesql @sql;
-- Confirmacion de creacion
PRINT 'Trigger TRG_Evitar_Insert_Provincia creado correctamente.';
END;
