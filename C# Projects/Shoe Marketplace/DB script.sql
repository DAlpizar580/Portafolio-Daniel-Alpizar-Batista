-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, 2012 and Azure
-- --------------------------------------------------
-- Date Created: 02/05/2025 02:28:48
-- Generated from EDMX file: E:\Documentos\Portafolio\Portafolio-Daniel-Alpizar-Batista\Proyectos C#\Marketplace para zapatos\Marketplace_Zapatos\Marketplace_Zapatos\Marketplace_Zapatos\Models\Base de datos.edmx
-- --------------------------------------------------

CREATE DATABASE [ProyectoDiseñoDeAplicaciones];
SET QUOTED_IDENTIFIER OFF;
GO
USE [ProyectoDiseñoDeAplicaciones];
GO
IF SCHEMA_ID(N'dbo') IS NULL EXECUTE(N'CREATE SCHEMA [dbo]');
GO

-- --------------------------------------------------
-- Dropping existing FOREIGN KEY constraints
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[FK_Carrito-Producto_CarritoDeCompras_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Carrito-Producto] DROP CONSTRAINT [FK_Carrito-Producto_CarritoDeCompras_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_Carrito-Producto_Producto_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Carrito-Producto] DROP CONSTRAINT [FK_Carrito-Producto_Producto_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_comprador_CarritoDeCompras_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[comprador] DROP CONSTRAINT [FK_comprador_CarritoDeCompras_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_DireccionComprador_comprador_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[DireccionComprador] DROP CONSTRAINT [FK_DireccionComprador_comprador_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_DireccionVendedor_Vendedor_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[DireccionVendedor] DROP CONSTRAINT [FK_DireccionVendedor_Vendedor_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_Orden]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Vendedor_Orden] DROP CONSTRAINT [FK_Orden];
GO
IF OBJECT_ID(N'[dbo].[FK_Vendedor]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Vendedor_Orden] DROP CONSTRAINT [FK_Vendedor];
GO
IF OBJECT_ID(N'[dbo].[FK_HistorialPedidos_Orden_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[HistorialPedidos] DROP CONSTRAINT [FK_HistorialPedidos_Orden_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_Imagenes_Producto_Producto_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Imagenes_Producto] DROP CONSTRAINT [FK_Imagenes_Producto_Producto_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_Orden_comprador_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Orden] DROP CONSTRAINT [FK_Orden_comprador_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_Producto_Administrador_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Producto] DROP CONSTRAINT [FK_Producto_Administrador_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_Producto_Categoria_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Producto] DROP CONSTRAINT [FK_Producto_Categoria_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_Producto_Marca_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Producto] DROP CONSTRAINT [FK_Producto_Marca_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_Producto_Talla_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Producto] DROP CONSTRAINT [FK_Producto_Talla_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_Producto_Vendedor_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Producto] DROP CONSTRAINT [FK_Producto_Vendedor_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_Producto-Orden_Orden_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Producto-Orden] DROP CONSTRAINT [FK_Producto-Orden_Orden_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_Producto-Orden_Producto_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Producto-Orden] DROP CONSTRAINT [FK_Producto-Orden_Producto_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_ReviewProducto_comprador_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[ReviewProducto] DROP CONSTRAINT [FK_ReviewProducto_comprador_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_ReviewProducto_Producto_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[ReviewProducto] DROP CONSTRAINT [FK_ReviewProducto_Producto_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_ReviewVendedor_comprador_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[ReviewVendedor] DROP CONSTRAINT [FK_ReviewVendedor_comprador_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_ReviewVendedor_Vendedor_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[ReviewVendedor] DROP CONSTRAINT [FK_ReviewVendedor_Vendedor_FK];
GO
IF OBJECT_ID(N'[dbo].[FK_TarjetaCredito_comprador_FK]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[TarjetaCredito] DROP CONSTRAINT [FK_TarjetaCredito_comprador_FK];
GO

-- --------------------------------------------------
-- Dropping existing tables
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[Administrador]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Administrador];
GO
IF OBJECT_ID(N'[dbo].[CarritoDeCompras]', 'U') IS NOT NULL
    DROP TABLE [dbo].[CarritoDeCompras];
GO
IF OBJECT_ID(N'[dbo].[Carrito-Producto]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Carrito-Producto];
GO
IF OBJECT_ID(N'[dbo].[Categoria]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Categoria];
GO
IF OBJECT_ID(N'[dbo].[comprador]', 'U') IS NOT NULL
    DROP TABLE [dbo].[comprador];
GO
IF OBJECT_ID(N'[dbo].[DireccionComprador]', 'U') IS NOT NULL
    DROP TABLE [dbo].[DireccionComprador];
GO
IF OBJECT_ID(N'[dbo].[DireccionVendedor]', 'U') IS NOT NULL
    DROP TABLE [dbo].[DireccionVendedor];
GO
IF OBJECT_ID(N'[dbo].[HistorialPedidos]', 'U') IS NOT NULL
    DROP TABLE [dbo].[HistorialPedidos];
GO
IF OBJECT_ID(N'[dbo].[Imagenes_Producto]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Imagenes_Producto];
GO
IF OBJECT_ID(N'[dbo].[Marca]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Marca];
GO
IF OBJECT_ID(N'[dbo].[Orden]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Orden];
GO
IF OBJECT_ID(N'[dbo].[Producto]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Producto];
GO
IF OBJECT_ID(N'[dbo].[Producto-Orden]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Producto-Orden];
GO
IF OBJECT_ID(N'[dbo].[ReviewProducto]', 'U') IS NOT NULL
    DROP TABLE [dbo].[ReviewProducto];
GO
IF OBJECT_ID(N'[dbo].[ReviewVendedor]', 'U') IS NOT NULL
    DROP TABLE [dbo].[ReviewVendedor];
GO
IF OBJECT_ID(N'[dbo].[Talla]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Talla];
GO
IF OBJECT_ID(N'[dbo].[TarjetaCredito]', 'U') IS NOT NULL
    DROP TABLE [dbo].[TarjetaCredito];
GO
IF OBJECT_ID(N'[dbo].[Vendedor]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Vendedor];
GO
IF OBJECT_ID(N'[dbo].[Vendedor_Orden]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Vendedor_Orden];
GO

-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------

-- Creating table 'Administrador'
CREATE TABLE [dbo].[Administrador] (
    [IdAdministrador] int IDENTITY(1,1) NOT NULL,
    [Correo] varchar(40)  NOT NULL,
    [Nombre] varchar(40)  NOT NULL,
    [Password] varchar(20)  NOT NULL,
    [Telefono] int  NOT NULL,
    [Edad] int  NOT NULL
);
GO

-- Creating table 'CarritoDeCompras'
CREATE TABLE [dbo].[CarritoDeCompras] (
    [IdCarrito] int IDENTITY(1,1) NOT NULL,
    [Precio] int  NOT NULL
);
GO

-- Creating table 'Carrito_Producto'
CREATE TABLE [dbo].[Carrito_Producto] (
    [CarritoDeCompras_IdCarrito] int  NOT NULL,
    [Producto_IdProducto] int  NOT NULL,
    [Cantidad] int  NOT NULL
);
GO

-- Creating table 'Categoria'
CREATE TABLE [dbo].[Categoria] (
    [IdCategoria] int IDENTITY(1,1) NOT NULL,
    [Nombre] varchar(20)  NOT NULL
);
GO

-- Creating table 'comprador'
CREATE TABLE [dbo].[comprador] (
    [IdComprador] int IDENTITY(1,1) NOT NULL,
    [Nombre] varchar(50)  NOT NULL,
    [Correo] varchar(40)  NOT NULL,
    [Password] varchar(40)  NOT NULL,
    [Telefono] int  NOT NULL,
    [Edad] int  NOT NULL,
    [CarritoDeCompras_IdCarrito] int  NOT NULL
);
GO

-- Creating table 'DireccionComprador'
CREATE TABLE [dbo].[DireccionComprador] (
    [Ciudad] varchar(40)  NOT NULL,
    [IdDirreccion] int IDENTITY(1,1) NOT NULL,
    [Pais] varchar(30)  NOT NULL,
    [CodigoPostal] int  NOT NULL,
    [Descripcion] varchar(70)  NOT NULL,
    [comprador_IdComprador] int  NULL
);
GO

-- Creating table 'DireccionVendedor'
CREATE TABLE [dbo].[DireccionVendedor] (
    [IdDirrecionVendedor] int IDENTITY(1,1) NOT NULL,
    [Pais] varchar(30)  NOT NULL,
    [CodigoPostal] int  NOT NULL,
    [Descripcion] varchar(70)  NOT NULL,
    [Ciudad] varchar(30)  NOT NULL,
    [Vendedor_IdVendedor] int  NULL
);
GO

-- Creating table 'HistorialPedidos'
CREATE TABLE [dbo].[HistorialPedidos] (
    [Vendedor] varchar(40)  NOT NULL,
    [DireccionEnvio] varchar(70)  NOT NULL,
    [Fecha] datetime  NOT NULL,
    [MetodoDePago] varchar(40)  NOT NULL,
    [Orden_IdOrden] int  NOT NULL,
    [IdHistorial] int IDENTITY(1,1) NOT NULL
);
GO

-- Creating table 'Marca'
CREATE TABLE [dbo].[Marca] (
    [IdMarca] int IDENTITY(1,1) NOT NULL,
    [Nombre] varchar(30)  NOT NULL
);
GO

-- Creating table 'Producto'
CREATE TABLE [dbo].[Producto] (
    [IdProducto] int IDENTITY(1,1) NOT NULL,
    [Modelo] varchar(50)  NOT NULL,
    [Precio] int  NOT NULL,
    [Stock] int  NOT NULL,
    [Color] varchar(20)  NOT NULL,
    [Disponibilidad] varchar(1)  NOT NULL,
    [Vendedor_IdVendedor] int  NOT NULL,
    [Marca_IdMarca] int  NOT NULL,
    [Talla_IdTalla] int  NOT NULL,
    [Categoria_IdCategoria] int  NOT NULL,
    [Aprobado] bit  NOT NULL,
    [Administrador_IdAdministrador] int  NOT NULL
);
GO

-- Creating table 'Producto_Orden'
CREATE TABLE [dbo].[Producto_Orden] (
    [Producto_IdProducto] int  NOT NULL,
    [Orden_IdOrden] int  NOT NULL,
    [Cantidad] int  NOT NULL
);
GO

-- Creating table 'ReviewProducto'
CREATE TABLE [dbo].[ReviewProducto] (
    [IdReviewProducto] int IDENTITY(1,1) NOT NULL,
    [Comentario] varchar(250)  NOT NULL,
    [Calificacion] int  NOT NULL,
    [comprador_IdComprador] int  NOT NULL,
    [Producto_IdProducto] int  NOT NULL
);
GO

-- Creating table 'ReviewVendedor'
CREATE TABLE [dbo].[ReviewVendedor] (
    [IdReview] int IDENTITY(1,1) NOT NULL,
    [Comentario] varchar(250)  NOT NULL,
    [Calificacion] int  NOT NULL,
    [Vendedor_IdVendedor] int  NOT NULL,
    [comprador_IdComprador] int  NOT NULL
);
GO

-- Creating table 'Talla'
CREATE TABLE [dbo].[Talla] (
    [IdTalla] int IDENTITY(1,1) NOT NULL,
    [Numero] int  NOT NULL,
    [TipoTalla] varchar(10)  NOT NULL
);
GO

-- Creating table 'TarjetaCredito'
CREATE TABLE [dbo].[TarjetaCredito] (
    [NombreTarjetahabiente] varchar(50)  NOT NULL,
    [FechaVencimiento] datetime  NOT NULL,
    [NumeroTarjeta] varchar(20)  NOT NULL,
    [CVV] int  NOT NULL,
    [comprador_IdComprador] int  NOT NULL
);
GO

-- Creating table 'Vendedor'
CREATE TABLE [dbo].[Vendedor] (
    [IdVendedor] int IDENTITY(1,1) NOT NULL,
    [Nombre] varchar(40)  NOT NULL,
    [Correo] varchar(40)  NOT NULL,
    [Password] varchar(30)  NOT NULL,
    [Telefono] int  NOT NULL,
    [Edad] int  NOT NULL
);
GO

-- Creating table 'Orden'
CREATE TABLE [dbo].[Orden] (
    [MontoTotal] decimal(18,0)  NOT NULL,
    [Estado] varchar(15)  NOT NULL,
    [IdOrden] int IDENTITY(1,1) NOT NULL,
    [PrecioEnvio] int  NOT NULL,
    [comprador_IdComprador] int  NOT NULL,
    [FormaDePago] varchar(20)  NOT NULL
);
GO

-- Creating table 'Imagenes_Producto'
CREATE TABLE [dbo].[Imagenes_Producto] (
    [Imagen] varbinary(max)  NULL,
    [Producto_IdProducto] int  NOT NULL
);
GO

-- Creating table 'Vendedor_Orden'
CREATE TABLE [dbo].[Vendedor_Orden] (
    [Orden_IdOrden] int  NOT NULL,
    [Vendedor_IdVendedor] int  NOT NULL
);
GO

-- --------------------------------------------------
-- Creating all PRIMARY KEY constraints
-- --------------------------------------------------

-- Creating primary key on [IdAdministrador] in table 'Administrador'
ALTER TABLE [dbo].[Administrador]
ADD CONSTRAINT [PK_Administrador]
    PRIMARY KEY CLUSTERED ([IdAdministrador] ASC);
GO

-- Creating primary key on [IdCarrito] in table 'CarritoDeCompras'
ALTER TABLE [dbo].[CarritoDeCompras]
ADD CONSTRAINT [PK_CarritoDeCompras]
    PRIMARY KEY CLUSTERED ([IdCarrito] ASC);
GO

-- Creating primary key on [CarritoDeCompras_IdCarrito], [Producto_IdProducto] in table 'Carrito_Producto'
ALTER TABLE [dbo].[Carrito_Producto]
ADD CONSTRAINT [PK_Carrito_Producto]
    PRIMARY KEY CLUSTERED ([CarritoDeCompras_IdCarrito], [Producto_IdProducto] ASC);
GO

-- Creating primary key on [IdCategoria] in table 'Categoria'
ALTER TABLE [dbo].[Categoria]
ADD CONSTRAINT [PK_Categoria]
    PRIMARY KEY CLUSTERED ([IdCategoria] ASC);
GO

-- Creating primary key on [IdComprador] in table 'comprador'
ALTER TABLE [dbo].[comprador]
ADD CONSTRAINT [PK_comprador]
    PRIMARY KEY CLUSTERED ([IdComprador] ASC);
GO

-- Creating primary key on [IdDirreccion] in table 'DireccionComprador'
ALTER TABLE [dbo].[DireccionComprador]
ADD CONSTRAINT [PK_DireccionComprador]
    PRIMARY KEY CLUSTERED ([IdDirreccion] ASC);
GO

-- Creating primary key on [IdDirrecionVendedor] in table 'DireccionVendedor'
ALTER TABLE [dbo].[DireccionVendedor]
ADD CONSTRAINT [PK_DireccionVendedor]
    PRIMARY KEY CLUSTERED ([IdDirrecionVendedor] ASC);
GO

-- Creating primary key on [IdHistorial] in table 'HistorialPedidos'
ALTER TABLE [dbo].[HistorialPedidos]
ADD CONSTRAINT [PK_HistorialPedidos]
    PRIMARY KEY CLUSTERED ([IdHistorial] ASC);
GO

-- Creating primary key on [IdMarca] in table 'Marca'
ALTER TABLE [dbo].[Marca]
ADD CONSTRAINT [PK_Marca]
    PRIMARY KEY CLUSTERED ([IdMarca] ASC);
GO

-- Creating primary key on [IdProducto] in table 'Producto'
ALTER TABLE [dbo].[Producto]
ADD CONSTRAINT [PK_Producto]
    PRIMARY KEY CLUSTERED ([IdProducto] ASC);
GO

-- Creating primary key on [Producto_IdProducto], [Orden_IdOrden] in table 'Producto_Orden'
ALTER TABLE [dbo].[Producto_Orden]
ADD CONSTRAINT [PK_Producto_Orden]
    PRIMARY KEY CLUSTERED ([Producto_IdProducto], [Orden_IdOrden] ASC);
GO

-- Creating primary key on [IdReviewProducto] in table 'ReviewProducto'
ALTER TABLE [dbo].[ReviewProducto]
ADD CONSTRAINT [PK_ReviewProducto]
    PRIMARY KEY CLUSTERED ([IdReviewProducto] ASC);
GO

-- Creating primary key on [IdReview] in table 'ReviewVendedor'
ALTER TABLE [dbo].[ReviewVendedor]
ADD CONSTRAINT [PK_ReviewVendedor]
    PRIMARY KEY CLUSTERED ([IdReview] ASC);
GO

-- Creating primary key on [IdTalla] in table 'Talla'
ALTER TABLE [dbo].[Talla]
ADD CONSTRAINT [PK_Talla]
    PRIMARY KEY CLUSTERED ([IdTalla] ASC);
GO

-- Creating primary key on [NumeroTarjeta], [CVV] in table 'TarjetaCredito'
ALTER TABLE [dbo].[TarjetaCredito]
ADD CONSTRAINT [PK_TarjetaCredito]
    PRIMARY KEY CLUSTERED ([NumeroTarjeta], [CVV] ASC);
GO

-- Creating primary key on [IdVendedor] in table 'Vendedor'
ALTER TABLE [dbo].[Vendedor]
ADD CONSTRAINT [PK_Vendedor]
    PRIMARY KEY CLUSTERED ([IdVendedor] ASC);
GO

-- Creating primary key on [IdOrden] in table 'Orden'
ALTER TABLE [dbo].[Orden]
ADD CONSTRAINT [PK_Orden]
    PRIMARY KEY CLUSTERED ([IdOrden] ASC);
GO

-- Creating primary key on [Producto_IdProducto] in table 'Imagenes_Producto'
ALTER TABLE [dbo].[Imagenes_Producto]
ADD CONSTRAINT [PK_Imagenes_Producto]
    PRIMARY KEY CLUSTERED ([Producto_IdProducto] ASC);
GO

-- Creating primary key on [Orden_IdOrden], [Vendedor_IdVendedor] in table 'Vendedor_Orden'
ALTER TABLE [dbo].[Vendedor_Orden]
ADD CONSTRAINT [PK_Vendedor_Orden]
    PRIMARY KEY CLUSTERED ([Orden_IdOrden], [Vendedor_IdVendedor] ASC);
GO

-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------

-- Creating foreign key on [Administrador_IdAdministrador] in table 'Producto'
ALTER TABLE [dbo].[Producto]
ADD CONSTRAINT [FK_Producto_Administrador_FK]
    FOREIGN KEY ([Administrador_IdAdministrador])
    REFERENCES [dbo].[Administrador]
        ([IdAdministrador])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Producto_Administrador_FK'
CREATE INDEX [IX_FK_Producto_Administrador_FK]
ON [dbo].[Producto]
    ([Administrador_IdAdministrador]);
GO

-- Creating foreign key on [CarritoDeCompras_IdCarrito] in table 'Carrito_Producto'
ALTER TABLE [dbo].[Carrito_Producto]
ADD CONSTRAINT [FK_Carrito_Producto_CarritoDeCompras_FK]
    FOREIGN KEY ([CarritoDeCompras_IdCarrito])
    REFERENCES [dbo].[CarritoDeCompras]
        ([IdCarrito])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating foreign key on [CarritoDeCompras_IdCarrito] in table 'comprador'
ALTER TABLE [dbo].[comprador]
ADD CONSTRAINT [FK_comprador_CarritoDeCompras_FK]
    FOREIGN KEY ([CarritoDeCompras_IdCarrito])
    REFERENCES [dbo].[CarritoDeCompras]
        ([IdCarrito])
    ON DELETE CASCADE ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_comprador_CarritoDeCompras_FK'
CREATE INDEX [IX_FK_comprador_CarritoDeCompras_FK]
ON [dbo].[comprador]
    ([CarritoDeCompras_IdCarrito]);
GO

-- Creating foreign key on [Producto_IdProducto] in table 'Carrito_Producto'
ALTER TABLE [dbo].[Carrito_Producto]
ADD CONSTRAINT [FK_Carrito_Producto_Producto_FK]
    FOREIGN KEY ([Producto_IdProducto])
    REFERENCES [dbo].[Producto]
        ([IdProducto])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Carrito_Producto_Producto_FK'
CREATE INDEX [IX_FK_Carrito_Producto_Producto_FK]
ON [dbo].[Carrito_Producto]
    ([Producto_IdProducto]);
GO

-- Creating foreign key on [Categoria_IdCategoria] in table 'Producto'
ALTER TABLE [dbo].[Producto]
ADD CONSTRAINT [FK_Producto_Categoria_FK]
    FOREIGN KEY ([Categoria_IdCategoria])
    REFERENCES [dbo].[Categoria]
        ([IdCategoria])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Producto_Categoria_FK'
CREATE INDEX [IX_FK_Producto_Categoria_FK]
ON [dbo].[Producto]
    ([Categoria_IdCategoria]);
GO

-- Creating foreign key on [comprador_IdComprador] in table 'DireccionComprador'
ALTER TABLE [dbo].[DireccionComprador]
ADD CONSTRAINT [FK_DireccionComprador_comprador_FK]
    FOREIGN KEY ([comprador_IdComprador])
    REFERENCES [dbo].[comprador]
        ([IdComprador])
    ON DELETE CASCADE ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_DireccionComprador_comprador_FK'
CREATE INDEX [IX_FK_DireccionComprador_comprador_FK]
ON [dbo].[DireccionComprador]
    ([comprador_IdComprador]);
GO

-- Creating foreign key on [comprador_IdComprador] in table 'ReviewProducto'
ALTER TABLE [dbo].[ReviewProducto]
ADD CONSTRAINT [FK_ReviewProducto_comprador_FK]
    FOREIGN KEY ([comprador_IdComprador])
    REFERENCES [dbo].[comprador]
        ([IdComprador])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_ReviewProducto_comprador_FK'
CREATE INDEX [IX_FK_ReviewProducto_comprador_FK]
ON [dbo].[ReviewProducto]
    ([comprador_IdComprador]);
GO

-- Creating foreign key on [comprador_IdComprador] in table 'ReviewVendedor'
ALTER TABLE [dbo].[ReviewVendedor]
ADD CONSTRAINT [FK_ReviewVendedor_comprador_FK]
    FOREIGN KEY ([comprador_IdComprador])
    REFERENCES [dbo].[comprador]
        ([IdComprador])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_ReviewVendedor_comprador_FK'
CREATE INDEX [IX_FK_ReviewVendedor_comprador_FK]
ON [dbo].[ReviewVendedor]
    ([comprador_IdComprador]);
GO

-- Creating foreign key on [comprador_IdComprador] in table 'TarjetaCredito'
ALTER TABLE [dbo].[TarjetaCredito]
ADD CONSTRAINT [FK_TarjetaCredito_comprador_FK]
    FOREIGN KEY ([comprador_IdComprador])
    REFERENCES [dbo].[comprador]
        ([IdComprador])
    ON DELETE CASCADE ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_TarjetaCredito_comprador_FK'
CREATE INDEX [IX_FK_TarjetaCredito_comprador_FK]
ON [dbo].[TarjetaCredito]
    ([comprador_IdComprador]);
GO

-- Creating foreign key on [Vendedor_IdVendedor] in table 'DireccionVendedor'
ALTER TABLE [dbo].[DireccionVendedor]
ADD CONSTRAINT [FK_DireccionVendedor_Vendedor_FK]
    FOREIGN KEY ([Vendedor_IdVendedor])
    REFERENCES [dbo].[Vendedor]
        ([IdVendedor])
    ON DELETE CASCADE ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_DireccionVendedor_Vendedor_FK'
CREATE INDEX [IX_FK_DireccionVendedor_Vendedor_FK]
ON [dbo].[DireccionVendedor]
    ([Vendedor_IdVendedor]);
GO

-- Creating foreign key on [Marca_IdMarca] in table 'Producto'
ALTER TABLE [dbo].[Producto]
ADD CONSTRAINT [FK_Producto_Marca_FK]
    FOREIGN KEY ([Marca_IdMarca])
    REFERENCES [dbo].[Marca]
        ([IdMarca])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Producto_Marca_FK'
CREATE INDEX [IX_FK_Producto_Marca_FK]
ON [dbo].[Producto]
    ([Marca_IdMarca]);
GO

-- Creating foreign key on [Talla_IdTalla] in table 'Producto'
ALTER TABLE [dbo].[Producto]
ADD CONSTRAINT [FK_Producto_Talla_FK]
    FOREIGN KEY ([Talla_IdTalla])
    REFERENCES [dbo].[Talla]
        ([IdTalla])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Producto_Talla_FK'
CREATE INDEX [IX_FK_Producto_Talla_FK]
ON [dbo].[Producto]
    ([Talla_IdTalla]);
GO

-- Creating foreign key on [Vendedor_IdVendedor] in table 'Producto'
ALTER TABLE [dbo].[Producto]
ADD CONSTRAINT [FK_Producto_Vendedor_FK]
    FOREIGN KEY ([Vendedor_IdVendedor])
    REFERENCES [dbo].[Vendedor]
        ([IdVendedor])
    ON DELETE CASCADE ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Producto_Vendedor_FK'
CREATE INDEX [IX_FK_Producto_Vendedor_FK]
ON [dbo].[Producto]
    ([Vendedor_IdVendedor]);
GO

-- Creating foreign key on [Producto_IdProducto] in table 'Producto_Orden'
ALTER TABLE [dbo].[Producto_Orden]
ADD CONSTRAINT [FK_Producto_Orden_Producto_FK]
    FOREIGN KEY ([Producto_IdProducto])
    REFERENCES [dbo].[Producto]
        ([IdProducto])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating foreign key on [Producto_IdProducto] in table 'ReviewProducto'
ALTER TABLE [dbo].[ReviewProducto]
ADD CONSTRAINT [FK_ReviewProducto_Producto_FK]
    FOREIGN KEY ([Producto_IdProducto])
    REFERENCES [dbo].[Producto]
        ([IdProducto])
    ON DELETE CASCADE ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_ReviewProducto_Producto_FK'
CREATE INDEX [IX_FK_ReviewProducto_Producto_FK]
ON [dbo].[ReviewProducto]
    ([Producto_IdProducto]);
GO

-- Creating foreign key on [Vendedor_IdVendedor] in table 'ReviewVendedor'
ALTER TABLE [dbo].[ReviewVendedor]
ADD CONSTRAINT [FK_ReviewVendedor_Vendedor_FK]
    FOREIGN KEY ([Vendedor_IdVendedor])
    REFERENCES [dbo].[Vendedor]
        ([IdVendedor])
    ON DELETE CASCADE ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_ReviewVendedor_Vendedor_FK'
CREATE INDEX [IX_FK_ReviewVendedor_Vendedor_FK]
ON [dbo].[ReviewVendedor]
    ([Vendedor_IdVendedor]);
GO

-- Creating foreign key on [comprador_IdComprador] in table 'Orden'
ALTER TABLE [dbo].[Orden]
ADD CONSTRAINT [FK_Orden_comprador_FK]
    FOREIGN KEY ([comprador_IdComprador])
    REFERENCES [dbo].[comprador]
        ([IdComprador])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Orden_comprador_FK'
CREATE INDEX [IX_FK_Orden_comprador_FK]
ON [dbo].[Orden]
    ([comprador_IdComprador]);
GO

-- Creating foreign key on [Orden_IdOrden] in table 'HistorialPedidos'
ALTER TABLE [dbo].[HistorialPedidos]
ADD CONSTRAINT [FK_HistorialPedidos_Orden_FK]
    FOREIGN KEY ([Orden_IdOrden])
    REFERENCES [dbo].[Orden]
        ([IdOrden])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_HistorialPedidos_Orden_FK'
CREATE INDEX [IX_FK_HistorialPedidos_Orden_FK]
ON [dbo].[HistorialPedidos]
    ([Orden_IdOrden]);
GO

-- Creating foreign key on [Orden_IdOrden] in table 'Producto_Orden'
ALTER TABLE [dbo].[Producto_Orden]
ADD CONSTRAINT [FK_Producto_Orden_Orden_FK]
    FOREIGN KEY ([Orden_IdOrden])
    REFERENCES [dbo].[Orden]
        ([IdOrden])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Producto_Orden_Orden_FK'
CREATE INDEX [IX_FK_Producto_Orden_Orden_FK]
ON [dbo].[Producto_Orden]
    ([Orden_IdOrden]);
GO

-- Creating foreign key on [Orden_IdOrden] in table 'Vendedor_Orden'
ALTER TABLE [dbo].[Vendedor_Orden]
ADD CONSTRAINT [FK_Vendedor_Orden_Orden]
    FOREIGN KEY ([Orden_IdOrden])
    REFERENCES [dbo].[Orden]
        ([IdOrden])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating foreign key on [Vendedor_IdVendedor] in table 'Vendedor_Orden'
ALTER TABLE [dbo].[Vendedor_Orden]
ADD CONSTRAINT [FK_Vendedor_Orden_Vendedor]
    FOREIGN KEY ([Vendedor_IdVendedor])
    REFERENCES [dbo].[Vendedor]
        ([IdVendedor])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Vendedor_Orden_Vendedor'
CREATE INDEX [IX_FK_Vendedor_Orden_Vendedor]
ON [dbo].[Vendedor_Orden]
    ([Vendedor_IdVendedor]);
GO

-- Creating foreign key on [Producto_IdProducto] in table 'Imagenes_Producto'
ALTER TABLE [dbo].[Imagenes_Producto]
ADD CONSTRAINT [FK_Imagenes_Producto_Producto_FK]
    FOREIGN KEY ([Producto_IdProducto])
    REFERENCES [dbo].[Producto]
        ([IdProducto])
    ON DELETE CASCADE ON UPDATE NO ACTION;
GO

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------