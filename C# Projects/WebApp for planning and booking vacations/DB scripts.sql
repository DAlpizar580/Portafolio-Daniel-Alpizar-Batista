CREATE DATABASE [Proyecto_Final_Diseño_Web]
GO
USE [Proyecto_Final_Diseño_Web]
GO
/****** Object:  Table [dbo].[Actividades_Destino]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Actividades_Destino](
	[IdActividad] [numeric](28, 0) IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](150) NULL,
	[Descripcion] [varchar](300) NULL,
	[Fecha] [date] NULL,
	[Destinos_IdDestino] [numeric](28, 0) NOT NULL,
	[Precio] [numeric](28, 0) NULL,
 CONSTRAINT [Actividades_Destino_PK] PRIMARY KEY CLUSTERED 
(
	[IdActividad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Actividades_Itinerario]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Actividades_Itinerario](
	[Descripcion] [varchar](300) NULL,
	[Fecha_actividad] [date] NULL,
	[Destinos_IdDestino] [numeric](28, 0) NOT NULL,
	[Actividades_Destino_IdActividad] [numeric](28, 0) NOT NULL,
	[Itinerarios_IdItinerario] [numeric](28, 0) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Actividades_Paquete]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Actividades_Paquete](
	[Paquetes_de_viaje_IdPaquete] [numeric](28, 0) NOT NULL,
	[Actividades_Destino_IdActividad] [numeric](28, 0) NOT NULL,
	[nulo] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Descuentos]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Descuentos](
	[IdDescuento] [numeric](28, 0) IDENTITY(1,1) NOT NULL,
	[Porcentaje] [numeric](28, 0) NULL,
	[Actividades_Destino_IdActividad] [numeric](28, 0) NOT NULL,
 CONSTRAINT [Descuentos_PK] PRIMARY KEY CLUSTERED 
(
	[IdDescuento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Destinos]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Destinos](
	[IdDestino] [numeric](28, 0) IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
	[Provincia] [varchar](10) NULL,
	[Categoria] [varchar](20) NULL,
	[Precio_Minimo] [numeric](28, 0) NULL,
	[Precio_Maximo] [numeric](28, 0) NULL,
	[Descripcion] [varchar](100) NULL,
	[Direccion] [varchar](200) NULL,
	[Imagen] [image] NULL,
 CONSTRAINT [Destinos_PK] PRIMARY KEY CLUSTERED 
(
	[IdDestino] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Itinerarios]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Itinerarios](
	[IdItinerario] [numeric](28, 0) NOT NULL,
	[Nombre] [varchar](70) NULL,
	[Usuarios_Id] [numeric](28, 0) NOT NULL,
 CONSTRAINT [Itinerarios_PK] PRIMARY KEY CLUSTERED 
(
	[IdItinerario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Paquetes_de_viaje]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Paquetes_de_viaje](
	[IdPaquete] [numeric](28, 0) IDENTITY(1,1) NOT NULL,
	[Nombre_del_paquete] [varchar](30) NULL,
	[Descripcion] [varchar](300) NULL,
	[Precio] [numeric](28, 0) NULL,
	[Destinos_IdDestino] [numeric](28, 0) NOT NULL,
 CONSTRAINT [Paquetes_de_viaje_PK] PRIMARY KEY CLUSTERED 
(
	[IdPaquete] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Reseñas]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reseñas](
	[IdReseña] [numeric](28, 0) IDENTITY(1,1) NOT NULL,
	[Calificacion] [numeric](1, 0) NULL,
	[Comentario] [varchar](200) NULL,
	[Usuarios_Id] [numeric](28, 0) NOT NULL,
	[Destinos_IdDestino] [numeric](28, 0) NOT NULL,
 CONSTRAINT [Reseñas_PK] PRIMARY KEY CLUSTERED 
(
	[IdReseña] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Reservas]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reservas](
	[IdReserva] [numeric](28, 0) IDENTITY(1,1) NOT NULL,
	[Fecha_de_inicio] [date] NULL,
	[Fecha_final] [date] NULL,
	[Tipo_de_servicio] [varchar](50) NULL,
	[Precio] [numeric](28, 0) NULL,
	[Estado_de_la_reserva] [varchar](50) NULL,
	[Actividades_Destino_IdActividad] [numeric](28, 0) NOT NULL,
	[Usuarios_Id] [numeric](28, 0) NOT NULL,
 CONSTRAINT [Reservas_PK] PRIMARY KEY CLUSTERED 
(
	[IdReserva] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tarjetas]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tarjetas](
	[IdTarjeta] [numeric](28, 0) IDENTITY(1,1) NOT NULL,
	[Numero_de_tarjeta] [numeric](28, 0) NOT NULL,
	[Fecha_de_vencimiento] [date] NOT NULL,
	[Codigo_de_seguridad] [numeric](28, 0) NOT NULL,
	[Usuarios_Id] [numeric](28, 0) NOT NULL,
 CONSTRAINT [Tarjetas_PK] PRIMARY KEY CLUSTERED 
(
	[IdTarjeta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuarios]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuarios](
	[Id] [numeric](28, 0) NOT NULL,
	[Correo] [varchar](255) NOT NULL,
	[Contraseña] [varchar](12) NOT NULL,
	[Fecha_de_nacimiento] [date] NULL,
	[Genero] [varchar](1) NULL,
	[Rol] [varchar](1) NULL,
	[Telefono] [numeric](28, 0) NULL,
	[Cedula] [varchar](30) NOT NULL,
	[Nombre] [varchar](50) NULL,
	[Apellidos] [varchar](100) NULL,
	[Nombre_Completo] [varchar](255) NULL,
	[Preferencias_de_Viaje] [varchar](500) NULL,
 CONSTRAINT [Usuarios_PK] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Actividades_Destino]  WITH CHECK ADD  CONSTRAINT [Actividades_Destino_Destinos_FK] FOREIGN KEY([Destinos_IdDestino])
REFERENCES [dbo].[Destinos] ([IdDestino])
GO
ALTER TABLE [dbo].[Actividades_Destino] CHECK CONSTRAINT [Actividades_Destino_Destinos_FK]
GO
ALTER TABLE [dbo].[Actividades_Itinerario]  WITH CHECK ADD  CONSTRAINT [Actividades_Itinerario_Actividades_Destino_FK] FOREIGN KEY([Actividades_Destino_IdActividad])
REFERENCES [dbo].[Actividades_Destino] ([IdActividad])
GO
ALTER TABLE [dbo].[Actividades_Itinerario] CHECK CONSTRAINT [Actividades_Itinerario_Actividades_Destino_FK]
GO
ALTER TABLE [dbo].[Actividades_Itinerario]  WITH CHECK ADD  CONSTRAINT [Actividades_Itinerario_Destinos_FK] FOREIGN KEY([Destinos_IdDestino])
REFERENCES [dbo].[Destinos] ([IdDestino])
GO
ALTER TABLE [dbo].[Actividades_Itinerario] CHECK CONSTRAINT [Actividades_Itinerario_Destinos_FK]
GO
ALTER TABLE [dbo].[Actividades_Itinerario]  WITH CHECK ADD  CONSTRAINT [Actividades_Itinerario_Itinerarios_FK] FOREIGN KEY([Itinerarios_IdItinerario])
REFERENCES [dbo].[Itinerarios] ([IdItinerario])
GO
ALTER TABLE [dbo].[Actividades_Itinerario] CHECK CONSTRAINT [Actividades_Itinerario_Itinerarios_FK]
GO
ALTER TABLE [dbo].[Actividades_Paquete]  WITH CHECK ADD  CONSTRAINT [Actividades_Paquete_Actividades_Destino_FK] FOREIGN KEY([Actividades_Destino_IdActividad])
REFERENCES [dbo].[Actividades_Destino] ([IdActividad])
GO
ALTER TABLE [dbo].[Actividades_Paquete] CHECK CONSTRAINT [Actividades_Paquete_Actividades_Destino_FK]
GO
ALTER TABLE [dbo].[Actividades_Paquete]  WITH CHECK ADD  CONSTRAINT [Actividades_Paquete_Paquetes_de_viaje_FK] FOREIGN KEY([Paquetes_de_viaje_IdPaquete])
REFERENCES [dbo].[Paquetes_de_viaje] ([IdPaquete])
GO
ALTER TABLE [dbo].[Actividades_Paquete] CHECK CONSTRAINT [Actividades_Paquete_Paquetes_de_viaje_FK]
GO
ALTER TABLE [dbo].[Descuentos]  WITH CHECK ADD  CONSTRAINT [Descuentos_Actividades_Destino_FK] FOREIGN KEY([Actividades_Destino_IdActividad])
REFERENCES [dbo].[Actividades_Destino] ([IdActividad])
GO
ALTER TABLE [dbo].[Descuentos] CHECK CONSTRAINT [Descuentos_Actividades_Destino_FK]
GO
ALTER TABLE [dbo].[Itinerarios]  WITH CHECK ADD  CONSTRAINT [Itinerarios_Usuarios_FK] FOREIGN KEY([Usuarios_Id])
REFERENCES [dbo].[Usuarios] ([Id])
GO
ALTER TABLE [dbo].[Itinerarios] CHECK CONSTRAINT [Itinerarios_Usuarios_FK]
GO
ALTER TABLE [dbo].[Paquetes_de_viaje]  WITH CHECK ADD  CONSTRAINT [Paquetes_de_viaje_Destinos_FK] FOREIGN KEY([Destinos_IdDestino])
REFERENCES [dbo].[Destinos] ([IdDestino])
GO
ALTER TABLE [dbo].[Paquetes_de_viaje] CHECK CONSTRAINT [Paquetes_de_viaje_Destinos_FK]
GO
ALTER TABLE [dbo].[Reseñas]  WITH CHECK ADD  CONSTRAINT [Reseñas_Destinos_FK] FOREIGN KEY([Destinos_IdDestino])
REFERENCES [dbo].[Destinos] ([IdDestino])
GO
ALTER TABLE [dbo].[Reseñas] CHECK CONSTRAINT [Reseñas_Destinos_FK]
GO
ALTER TABLE [dbo].[Reseñas]  WITH CHECK ADD  CONSTRAINT [Reseñas_Usuarios_FK] FOREIGN KEY([Usuarios_Id])
REFERENCES [dbo].[Usuarios] ([Id])
GO
ALTER TABLE [dbo].[Reseñas] CHECK CONSTRAINT [Reseñas_Usuarios_FK]
GO
ALTER TABLE [dbo].[Reservas]  WITH CHECK ADD  CONSTRAINT [Reservas_Actividad_FK] FOREIGN KEY([Actividades_Destino_IdActividad])
REFERENCES [dbo].[Actividades_Destino] ([IdActividad])
GO
ALTER TABLE [dbo].[Reservas] CHECK CONSTRAINT [Reservas_Actividad_FK]
GO
ALTER TABLE [dbo].[Reservas]  WITH CHECK ADD  CONSTRAINT [Reservas_Usuarios_FK] FOREIGN KEY([Usuarios_Id])
REFERENCES [dbo].[Usuarios] ([Id])
GO
ALTER TABLE [dbo].[Reservas] CHECK CONSTRAINT [Reservas_Usuarios_FK]
GO
ALTER TABLE [dbo].[Tarjetas]  WITH CHECK ADD  CONSTRAINT [Tarjetas_Usuarios_FK] FOREIGN KEY([Usuarios_Id])
REFERENCES [dbo].[Usuarios] ([Id])
GO
ALTER TABLE [dbo].[Tarjetas] CHECK CONSTRAINT [Tarjetas_Usuarios_FK]
GO
/****** Object:  StoredProcedure [dbo].[DeleteActividadesItinerario]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[DeleteActividadesItinerario]
    @Destinos_IdDestino NUMERIC(28),
    @Actividades_Destino_IdActividad NUMERIC(28),
    @Itinerarios_IdItinerario NUMERIC(28)
AS
BEGIN
    DELETE FROM dbo.Actividades_Itinerario
    WHERE Destinos_IdDestino = @Destinos_IdDestino
      AND Actividades_Destino_IdActividad = @Actividades_Destino_IdActividad
      AND Itinerarios_IdItinerario = @Itinerarios_IdItinerario;
END
GO
/****** Object:  StoredProcedure [dbo].[DeleteActividadesPaquete]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[DeleteActividadesPaquete]
    @Paquetes_de_viaje_IdPaquete NUMERIC,
    @Actividades_Destino_IdActividad NUMERIC
AS
BEGIN
    DELETE FROM dbo.Actividades_Paquete
    WHERE Paquetes_de_viaje_IdPaquete = @Paquetes_de_viaje_IdPaquete
    AND Actividades_Destino_IdActividad = @Actividades_Destino_IdActividad;
END

GO
/****** Object:  StoredProcedure [dbo].[InsertActividadesItinerario]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[InsertActividadesItinerario]
    @Descripcion VARCHAR(300),
    @Fecha_actividad DATE,
    @Destinos_IdDestino NUMERIC(28),
    @Actividades_Destino_IdActividad NUMERIC(28),
    @Itinerarios_IdItinerario NUMERIC(28)
AS
BEGIN
    INSERT INTO dbo.Actividades_Itinerario 
    (Descripcion, Fecha_actividad, Destinos_IdDestino, Actividades_Destino_IdActividad, Itinerarios_IdItinerario)
    VALUES 
    (@Descripcion, @Fecha_actividad, @Destinos_IdDestino, @Actividades_Destino_IdActividad, @Itinerarios_IdItinerario);
END
GO
/****** Object:  StoredProcedure [dbo].[InsertActividadesPaquete]    Script Date: 5/2/2025 02:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[InsertActividadesPaquete]
    @Paquetes_de_viaje_IdPaquete NUMERIC,
    @Actividades_Destino_IdActividad NUMERIC,
    @nulo INT -- O el tipo de dato adecuado
AS
BEGIN
    INSERT INTO dbo.Actividades_Paquete (Paquetes_de_viaje_IdPaquete, Actividades_Destino_IdActividad, nulo)
    VALUES (@Paquetes_de_viaje_IdPaquete, @Actividades_Destino_IdActividad, @nulo);
END

GO
