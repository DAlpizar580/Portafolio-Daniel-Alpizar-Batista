using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Proyecto_Diseño_Web.Models.ViewModels
{
    public class CompletarInformacionViewModel
    {
        public decimal Id { get; set; }
        public string Nombre { get; set; }
        public string Apellidos { get; set; }
        public string Correo { get; set; }
        public decimal Telefono { get; set; }
        public DateTime? Fecha_de_nacimiento { get; set; }
        public string Genero { get; set; } // "M", "F", "O"
    }
}