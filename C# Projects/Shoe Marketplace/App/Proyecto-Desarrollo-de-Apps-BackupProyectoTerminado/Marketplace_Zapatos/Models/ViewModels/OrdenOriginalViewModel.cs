using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class OrdenOriginalViewModel
    {
        public decimal MontoTotal { get; set; }
        public string Estado { get; set; }
        public int IdOrden { get; set; }
        public int PrecioEnvio { get; set; }
        public int comprador_IdComprador { get; set; }
        public string FormaDePago { get; set; }
    }
}