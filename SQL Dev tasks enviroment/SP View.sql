CREATE PROCEDURE CrearYConsultarVistaVisualizarConsulta
AS
BEGIN
-- Verificar si la vista ya existe y eliminarla
IF EXISTS (SELECT * FROM sysobjects WHERE name = 'Visualizar_Consulta' AND
xtype = 'V')
BEGIN
DROP VIEW Visualizar_Consulta;
END;
-- Crear la vista usando SQL dinamico
DECLARE @sql NVARCHAR(MAX);
SET @sql = '
CREATE VIEW Visualizar_Consulta AS
SELECT
c.cedula,
c.nombre AS nombre_ciudadano,
c.primer_apellido,
c.segundo_apellido,
prov.provincia_nombre AS provincia,
cant.nombre_canton AS canton,
dist.nombre_distrito AS distrito,
COUNT(t.telefono) AS cantidad_telefonos
FROM Ciudadano c
INNER JOIN LugarElectoral le ON c.codigo_electoral = le.codigo_electoral
INNER JOIN Distrito dist ON le.distrito_id = dist.distrito_id
INNER JOIN Canton cant ON dist.canton_id = cant.canton_id
INNER JOIN Provincia prov ON cant.provincia_id = prov.provincia_id
LEFT JOIN Teléfonos_General t ON c.cedula = t.cedula
WHERE prov.provincia_nombre = ''Cartago''
GROUP BY
c.cedula, c.nombre, c.primer_apellido, c.segundo_apellido,
prov.provincia_nombre, cant.nombre_canton, dist.nombre_distrito
HAVING COUNT(t.telefono) > 0;
';
EXEC sp_executesql @sql;
-- Confirmacion de creacion
PRINT 'Vista Visualizar_Consulta creada correctamente.';
-- Consultar los datos de la vista
SELECT * FROM Visualizar_Consulta;
END;
