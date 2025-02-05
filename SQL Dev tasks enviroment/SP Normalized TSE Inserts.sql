CREATE PROCEDURE InsertsTSENormalizado
AS
BEGIN
----------------------------
INSERT INTO Provincia (provincia_nombre)
SELECT DISTINCT Provincia
FROM [PF_LenguajeDeBD].[dbo].[Distelec]
---------------------------------
INSERT INTO Canton (nombre_canton, provincia_id)
SELECT DISTINCT d.Canton AS nombre_canton, p.provincia_id AS provincia_id
FROM [PF_LenguajeDeBD].[dbo].[Distelec] d
INNER JOIN Provincia p ON d.Provincia = p.provincia_nombre;
-----------------------------------
INSERT INTO Distrito (nombre_distrito, canton_id)
SELECT DISTINCT
d.Distrito AS nombre_distrito,
c.canton_id AS canton_id
FROM [PF_LenguajeDeBD].[dbo].[Distelec] d
INNER JOIN Canton c ON d.Canton = c.nombre_canton
INNER JOIN Provincia p ON d.Provincia = p.provincia_nombre AND c.provincia_id =
p.provincia_id
WHERE d.Distrito IS NOT NULL AND d.Canton IS NOT NULL AND d.Provincia IS NOT NULL;
---------
INSERT INTO LugarElectoral (codigo_electoral, distrito_id)
SELECT DISTINCT DD.CodElectoral AS codigo_electoral, D.distrito_id AS
distrito_id
FROM [PF_LenguajeDeBD].[dbo].[Distelec] DD
INNER JOIN Distrito D ON DD.Distrito = D.nombre_distrito
INNER JOIN Canton C ON DD.Canton = C.nombre_canton AND D.canton_id =
C.canton_id
INNER JOIN Provincia P ON DD.Provincia = P.provincia_nombre AND C.provincia_id
= P.provincia_id;
-----
INSERT INTO Ciudadano (cedula, nombre, primer_apellido, segundo_apellido,
fecha_caducidad, codigo_electoral)
SELECT Cedula, Nombre, Apellido1, Apellido2, FechaCedula, CodElectoral
FROM [PF_LenguajeDeBD].[dbo].[PADRON_COMPLETO]
END;