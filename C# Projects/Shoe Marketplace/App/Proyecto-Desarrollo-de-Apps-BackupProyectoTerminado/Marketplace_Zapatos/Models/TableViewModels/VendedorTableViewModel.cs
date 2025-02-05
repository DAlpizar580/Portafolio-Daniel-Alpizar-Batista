using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.TableViewModels
{
    public class VendedorTableViewModel
    {
        public int IdVendedor { get; set; }
        public string Nombre { get; set; }
        public string Correo { get; set; }
        public string Password { get; set; }
        public int Telefono { get; set; }
        public int Edad { get; set; }
        

    }
}