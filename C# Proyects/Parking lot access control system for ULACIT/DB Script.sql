
-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, 2012 and Azure
-- --------------------------------------------------
-- Date Created: 02/05/2025 02:38:04
-- Generated from EDMX file: E:\Documentos\Portafolio\Portafolio-Daniel-Alpizar-Batista\Proyectos C#\Sistema de control de ingreso para parqueos de ULACIT\ParqueoULACIT\Models\Model1.edmx
-- --------------------------------------------------

CREATE DATABASE [SistemaParqueo];
SET QUOTED_IDENTIFIER OFF;
GO
USE [SistemaParqueo];
GO
IF SCHEMA_ID(N'dbo') IS NULL EXECUTE(N'CREATE SCHEMA [dbo]');
GO

-- --------------------------------------------------
-- Dropping existing FOREIGN KEY constraints
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[FK_Bitacora_Movimiento]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Bitacora] DROP CONSTRAINT [FK_Bitacora_Movimiento];
GO
IF OBJECT_ID(N'[dbo].[FK_Bitacora_Parqueo]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Bitacora] DROP CONSTRAINT [FK_Bitacora_Parqueo];
GO
IF OBJECT_ID(N'[dbo].[FK_Bitacora_Tipo_Vehiculo]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Bitacora] DROP CONSTRAINT [FK_Bitacora_Tipo_Vehiculo];
GO
IF OBJECT_ID(N'[dbo].[FK_Usuario_Rol]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Usuario] DROP CONSTRAINT [FK_Usuario_Rol];
GO
IF OBJECT_ID(N'[dbo].[FK_Vehiculo_Tipo]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Vehiculo] DROP CONSTRAINT [FK_Vehiculo_Tipo];
GO
IF OBJECT_ID(N'[dbo].[FK_Vehiculo_Usuario]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Vehiculo] DROP CONSTRAINT [FK_Vehiculo_Usuario];
GO

-- --------------------------------------------------
-- Dropping existing tables
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[Bitacora]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Bitacora];
GO
IF OBJECT_ID(N'[dbo].[Movimiento]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Movimiento];
GO
IF OBJECT_ID(N'[dbo].[Parqueo]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Parqueo];
GO
IF OBJECT_ID(N'[dbo].[Rol]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Rol];
GO
IF OBJECT_ID(N'[dbo].[Tipo_Vehiculo]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Tipo_Vehiculo];
GO
IF OBJECT_ID(N'[dbo].[Usuario]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Usuario];
GO
IF OBJECT_ID(N'[dbo].[Vehiculo]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Vehiculo];
GO

-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------

-- Creating table 'Bitacora'
CREATE TABLE [dbo].[Bitacora] (
    [ID_Bitacora] int IDENTITY(1,1) NOT NULL,
    [Fecha] datetime  NOT NULL,
    [Hora] time  NOT NULL,
    [Numero_Placa] nvarchar(50)  NOT NULL,
    [ID_Movimiento] int  NOT NULL,
    [ID_Parqueo] int  NOT NULL,
    [ID_Tipo] int  NOT NULL
);
GO

-- Creating table 'Movimiento'
CREATE TABLE [dbo].[Movimiento] (
    [ID_Movimiento] int IDENTITY(1,1) NOT NULL,
    [Tipo_Movimiento] nvarchar(100)  NOT NULL
);
GO

-- Creating table 'Parqueo'
CREATE TABLE [dbo].[Parqueo] (
    [ID_Parqueo] int IDENTITY(1,1) NOT NULL,
    [Nombre] nvarchar(100)  NOT NULL,
    [Capacidad_Espacios_Regulares] int  NOT NULL,
    [Capacidad_Espacios_Moto] int  NOT NULL,
    [Capacidad_Espacios_7600] int  NOT NULL
);
GO

-- Creating table 'Rol'
CREATE TABLE [dbo].[Rol] (
    [ID_Rol] int IDENTITY(1,1) NOT NULL,
    [Nombre_Rol] nvarchar(50)  NOT NULL
);
GO

-- Creating table 'Tipo_Vehiculo'
CREATE TABLE [dbo].[Tipo_Vehiculo] (
    [ID_Tipo] int IDENTITY(1,1) NOT NULL,
    [Tipo] nvarchar(50)  NOT NULL
);
GO

-- Creating table 'Usuario'
CREATE TABLE [dbo].[Usuario] (
    [ID_Usuario] int IDENTITY(1,1) NOT NULL,
    [Nombre] nvarchar(50)  NOT NULL,
    [Apellido_1] nvarchar(50)  NOT NULL,
    [Apellido_2] nvarchar(50)  NULL,
    [Correo] nvarchar(50)  NOT NULL,
    [Contrasena] nvarchar(200)  NOT NULL,
    [Fecha_Nacimiento] datetime  NOT NULL,
    [Identificacion] nvarchar(20)  NOT NULL,
    [Numero_Carne] nvarchar(20)  NOT NULL,
    [ID_Rol] int  NOT NULL,
    [Estado] bit  NOT NULL
);
GO

-- Creating table 'Vehiculo'
CREATE TABLE [dbo].[Vehiculo] (
    [ID_Vehiculo] int IDENTITY(1,1) NOT NULL,
    [Marca] nvarchar(30)  NOT NULL,
    [Color] nvarchar(50)  NOT NULL,
    [Numero_Placa] nvarchar(50)  NOT NULL,
    [ID_Tipo] int  NOT NULL,
    [ID_Usuario] int  NOT NULL,
    [Espacio_7600] bit  NOT NULL,
    [Estado] bit  NOT NULL
);
GO

-- --------------------------------------------------
-- Creating all PRIMARY KEY constraints
-- --------------------------------------------------

-- Creating primary key on [ID_Bitacora] in table 'Bitacora'
ALTER TABLE [dbo].[Bitacora]
ADD CONSTRAINT [PK_Bitacora]
    PRIMARY KEY CLUSTERED ([ID_Bitacora] ASC);
GO

-- Creating primary key on [ID_Movimiento] in table 'Movimiento'
ALTER TABLE [dbo].[Movimiento]
ADD CONSTRAINT [PK_Movimiento]
    PRIMARY KEY CLUSTERED ([ID_Movimiento] ASC);
GO

-- Creating primary key on [ID_Parqueo] in table 'Parqueo'
ALTER TABLE [dbo].[Parqueo]
ADD CONSTRAINT [PK_Parqueo]
    PRIMARY KEY CLUSTERED ([ID_Parqueo] ASC);
GO

-- Creating primary key on [ID_Rol] in table 'Rol'
ALTER TABLE [dbo].[Rol]
ADD CONSTRAINT [PK_Rol]
    PRIMARY KEY CLUSTERED ([ID_Rol] ASC);
GO

-- Creating primary key on [ID_Tipo] in table 'Tipo_Vehiculo'
ALTER TABLE [dbo].[Tipo_Vehiculo]
ADD CONSTRAINT [PK_Tipo_Vehiculo]
    PRIMARY KEY CLUSTERED ([ID_Tipo] ASC);
GO

-- Creating primary key on [ID_Usuario] in table 'Usuario'
ALTER TABLE [dbo].[Usuario]
ADD CONSTRAINT [PK_Usuario]
    PRIMARY KEY CLUSTERED ([ID_Usuario] ASC);
GO

-- Creating primary key on [ID_Vehiculo] in table 'Vehiculo'
ALTER TABLE [dbo].[Vehiculo]
ADD CONSTRAINT [PK_Vehiculo]
    PRIMARY KEY CLUSTERED ([ID_Vehiculo] ASC);
GO

-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------

-- Creating foreign key on [ID_Movimiento] in table 'Bitacora'
ALTER TABLE [dbo].[Bitacora]
ADD CONSTRAINT [FK_Bitacora_Movimiento]
    FOREIGN KEY ([ID_Movimiento])
    REFERENCES [dbo].[Movimiento]
        ([ID_Movimiento])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Bitacora_Movimiento'
CREATE INDEX [IX_FK_Bitacora_Movimiento]
ON [dbo].[Bitacora]
    ([ID_Movimiento]);
GO

-- Creating foreign key on [ID_Parqueo] in table 'Bitacora'
ALTER TABLE [dbo].[Bitacora]
ADD CONSTRAINT [FK_Bitacora_Parqueo]
    FOREIGN KEY ([ID_Parqueo])
    REFERENCES [dbo].[Parqueo]
        ([ID_Parqueo])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Bitacora_Parqueo'
CREATE INDEX [IX_FK_Bitacora_Parqueo]
ON [dbo].[Bitacora]
    ([ID_Parqueo]);
GO

-- Creating foreign key on [ID_Tipo] in table 'Bitacora'
ALTER TABLE [dbo].[Bitacora]
ADD CONSTRAINT [FK_Bitacora_Tipo_Vehiculo]
    FOREIGN KEY ([ID_Tipo])
    REFERENCES [dbo].[Tipo_Vehiculo]
        ([ID_Tipo])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Bitacora_Tipo_Vehiculo'
CREATE INDEX [IX_FK_Bitacora_Tipo_Vehiculo]
ON [dbo].[Bitacora]
    ([ID_Tipo]);
GO

-- Creating foreign key on [ID_Rol] in table 'Usuario'
ALTER TABLE [dbo].[Usuario]
ADD CONSTRAINT [FK_Usuario_Rol]
    FOREIGN KEY ([ID_Rol])
    REFERENCES [dbo].[Rol]
        ([ID_Rol])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Usuario_Rol'
CREATE INDEX [IX_FK_Usuario_Rol]
ON [dbo].[Usuario]
    ([ID_Rol]);
GO

-- Creating foreign key on [ID_Tipo] in table 'Vehiculo'
ALTER TABLE [dbo].[Vehiculo]
ADD CONSTRAINT [FK_Vehiculo_Tipo]
    FOREIGN KEY ([ID_Tipo])
    REFERENCES [dbo].[Tipo_Vehiculo]
        ([ID_Tipo])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Vehiculo_Tipo'
CREATE INDEX [IX_FK_Vehiculo_Tipo]
ON [dbo].[Vehiculo]
    ([ID_Tipo]);
GO

-- Creating foreign key on [ID_Usuario] in table 'Vehiculo'
ALTER TABLE [dbo].[Vehiculo]
ADD CONSTRAINT [FK_Vehiculo_Usuario]
    FOREIGN KEY ([ID_Usuario])
    REFERENCES [dbo].[Usuario]
        ([ID_Usuario])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Vehiculo_Usuario'
CREATE INDEX [IX_FK_Vehiculo_Usuario]
ON [dbo].[Vehiculo]
    ([ID_Usuario]);
GO

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------