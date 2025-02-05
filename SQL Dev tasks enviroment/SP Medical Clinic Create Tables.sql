CREATE PROCEDURE CrearTablas
AS
BEGIN
CREATE TABLE Medicamentos (
IdMedicamento VARCHAR(50) PRIMARY KEY,
Nombre VARCHAR(100),
Descripcion TEXT,
Tamaño VARCHAR(50)
);
CREATE TABLE Consultorios (
IdConsultorio VARCHAR(50) PRIMARY KEY,
NombreConsultorio VARCHAR(100),
Ubicacion VARCHAR(255)
);
CREATE TABLE Roles (
IdRol VARCHAR(50) PRIMARY KEY,
NombreRol VARCHAR(50),
);
CREATE TABLE Personas (
IdPersona VARCHAR(50) PRIMARY KEY,
Nombre VARCHAR(100),
Apellido1 VARCHAR(150),
Apellido2 VARCHAR(150),
IdRol VARCHAR(50),
FechaNacimiento DATE,
Direccion VARCHAR(255),
Telefono VARCHAR(20),
FOREIGN KEY (IdRol) REFERENCES Roles(IdRol),
);
CREATE TABLE Especialidades(
IdEspecialidad VARCHAR(50) PRIMARY KEY,
IdPersona VARCHAR(50),
Nombre VARCHAR(50),
FOREIGN KEY (IdPersona) REFERENCES Personas(IdPersona),
);
CREATE TABLE HistorialMedico (
IdHistorial VARCHAR(50) PRIMARY KEY,
IdPaciente VARCHAR(50),
IdMedico VARCHAR(50),
FechaEntrada DATE,
Diagnostico TEXT,
FOREIGN KEY (IdPaciente) REFERENCES Personas(IdPersona),
FOREIGN KEY (IdMedico) REFERENCES Personas(IdPersona)
);
CREATE TABLE Citas (
IdCita VARCHAR(50) PRIMARY KEY,
IdPaciente VARCHAR(50),
IdMedico VARCHAR(50),
IdConsultorio VARCHAR(50),
FechaHora DATETIME,
Motivo VARCHAR(200),
FOREIGN KEY (IdPaciente) REFERENCES Personas(IdPersona),
FOREIGN KEY (IdMedico) REFERENCES Personas(IdPersona),
FOREIGN KEY (IdConsultorio) REFERENCES Consultorios(IdConsultorio)
);
CREATE TABLE Prescripcion (
IdPrescripcion VARCHAR(50) PRIMARY KEY,
Fecha DATE,
IdCita VARCHAR(50),
IdMedico VARCHAR(50),
IdPaciente VARCHAR(50),
FOREIGN KEY (IdCita) REFERENCES Citas(IdCita),
FOREIGN KEY (IdMedico) REFERENCES Personas(IdPersona),
FOREIGN KEY (IdPaciente) REFERENCES Personas(IdPersona)
);
CREATE TABLE PrescripcionMedicamento (
IdPrescripcion VARCHAR(50) PRIMARY KEY,
IdMedicamento VARCHAR(50),
Dosis VARCHAR(50),
Frecuencia VARCHAR(50),
FOREIGN KEY (IdPrescripcion) REFERENCES Prescripcion(IdPrescripcion),
FOREIGN KEY (IdMedicamento) REFERENCES Medicamentos(IdMedicamento)
);
END;