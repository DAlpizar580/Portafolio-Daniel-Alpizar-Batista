using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Proyecto_Diseño_Web.Models.ViewModels
{
    public class RecuperacionViewModel
    {
        public string Correo { get; set; }
        public string Cedula { get; set; }
        public int CodigoRecuperacion { get; set; }
        public DateTime FechaExpiracionCodigo { get; set; }
    }
}