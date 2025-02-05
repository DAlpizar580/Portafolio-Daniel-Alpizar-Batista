using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Proyecto_Diseño_Web.Models.ViewModels
{
    public class PerfilViewModel
    {
        public string Nombre { get; set; }
        public string Apellidos { get; set; }
        public string Correo { get; set; }
        public decimal Telefono { get; set; }
        public DateTime? FechaDeNacimiento { get; set; }
        public string Genero { get; set; }
        public string PreferenciasDeViaje { get; set; }
        public List<Reservas> Reservas { get; set; }

    }
}