CREATE PROCEDURE CrearLogUpdate
AS
BEGIN
-- Verificar si ya existe el trigger y eliminarlo si es necesario
IF EXISTS (SELECT * FROM sysobjects WHERE name = 'log_update' AND xtype = 'TR')
BEGIN
DROP TRIGGER log_update;
END;
-- Crear el trigger para acciones UPDATE usando SQL dinamico
DECLARE @sql NVARCHAR(MAX);
SET @sql = '
CREATE TRIGGER log_update
ON Ciudadano
AFTER UPDATE
AS
BEGIN
INSERT INTO log_acciones (usuario, tipo_accion)
VALUES (SYSTEM_USER, ''UPDATE'');
END;
';
-- Ejecutar el SQL dinamico
EXEC sp_executesql @sql;
PRINT 'Trigger log_update creado correctamente.';
END;
execute CrearLogUpdate
CREATE PROCEDURE CrearLogInsert
AS
BEGIN
-- Verificar si ya existe el trigger y eliminarlo si es necesario
IF EXISTS (SELECT * FROM sysobjects WHERE name = 'log_insert' AND xtype = 'TR')
BEGIN
DROP TRIGGER log_insert;
END;
-- Crear el trigger para acciones INSERT usando SQL dinamico
DECLARE @sql NVARCHAR(MAX);
SET @sql = '
CREATE TRIGGER log_insert
ON Ciudadano
AFTER INSERT
AS
BEGIN
INSERT INTO log_acciones (usuario, tipo_accion)
VALUES (SYSTEM_USER, ''INSERT'');
END;
';
-- Ejecutar el SQL dinamico
EXEC sp_executesql @sql;
PRINT 'Trigger log_insert creado correctamente.';
END;
execute CrearLogInsert
CREATE PROCEDURE CrearLogDelete
AS
BEGIN
-- Verificar si ya existe el trigger y eliminarlo si es necesario
IF EXISTS (SELECT * FROM sysobjects WHERE name = 'log_delete' AND xtype = 'TR')
BEGIN
DROP TRIGGER log_delete;
END;
-- Crear el trigger para acciones DELETE usando SQL dinamico
DECLARE @sql NVARCHAR(MAX);
SET @sql = '
CREATE TRIGGER log_delete
ON Ciudadano
AFTER DELETE
AS
BEGIN
INSERT INTO log_acciones (usuario, tipo_accion)
VALUES (SYSTEM_USER, ''DELETE'');
END;
';
-- Ejecutar el SQL dinamico
EXEC sp_executesql @sql;
PRINT 'Trigger log_delete creado correctamente.';
END;
execute CrearLogDelete