CREATE PROCEDURE CursorTelefonos
AS
BEGIN
CREATE TABLE Telefonos_General_V2 (
Cedula VARCHAR(20) PRIMARY KEY,
Nombre VARCHAR(100),
Cantidad_Telefonos INT,
Telefonos VARCHAR(MAX)
);
DECLARE @Cedula VARCHAR(20);
DECLARE @Nombre VARCHAR(100);
DECLARE @Telefono VARCHAR(20);
DECLARE @CedulaActual VARCHAR(20);
DECLARE @NombreActual VARCHAR(100);
DECLARE @Telefonos VARCHAR(MAX);
DECLARE @Cantidad INT;
DECLARE TelefonoCursor CURSOR FOR
SELECT Cedula, Nombre, Telefono
FROM [PF_LenguajeDeBD].[dbo].[Teléfonos_General]
ORDER BY Cedula;
OPEN TelefonoCursor;
SET @CedulaActual = NULL;
SET @Telefonos = '';
SET @Cantidad = 0;
FETCH NEXT FROM TelefonoCursor INTO @Cedula, @Nombre, @Telefono;
WHILE @@FETCH_STATUS = 0
BEGIN
IF @CedulaActual IS NULL OR @CedulaActual <> @Cedula
BEGIN
IF @CedulaActual IS NOT NULL
BEGIN
INSERT INTO Telefonos_General_V2 (Cedula, Nombre,
Cantidad_Telefonos, Telefonos)
VALUES (@CedulaActual, @NombreActual, @Cantidad,
@Telefonos);
END
SET @CedulaActual = @Cedula;
SET @NombreActual = @Nombre;
SET @Telefonos = @Telefono;
SET @Cantidad = 1;
END
ELSE
BEGIN
SET @Telefonos = @Telefonos + ',' + @Telefono;
SET @Cantidad = @Cantidad + 1;
END
FETCH NEXT FROM TelefonoCursor INTO @Cedula, @Nombre, @Telefono;
END
IF @CedulaActual IS NOT NULL
BEGIN
INSERT INTO Telefonos_General_V2 (Cedula, Nombre, Cantidad_Telefonos,
Telefonos)
VALUES (@CedulaActual, @NombreActual, @Cantidad, @Telefonos);
END
CLOSE TelefonoCursor;
DEALLOCATE TelefonoCursor;
SELECT * FROM Telefonos_General_V2;
END;