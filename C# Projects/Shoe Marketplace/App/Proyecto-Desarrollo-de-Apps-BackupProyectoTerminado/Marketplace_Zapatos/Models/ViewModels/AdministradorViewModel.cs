using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class AdministradorViewModel
    {
        public int IdAdministrador { get; set; }
        public string Correo { get; set; }
        public string Nombre { get; set; }
        public string Password { get; set; }
        public int Telefono { get; set; }
        public int Edad { get; set; }
    }
}