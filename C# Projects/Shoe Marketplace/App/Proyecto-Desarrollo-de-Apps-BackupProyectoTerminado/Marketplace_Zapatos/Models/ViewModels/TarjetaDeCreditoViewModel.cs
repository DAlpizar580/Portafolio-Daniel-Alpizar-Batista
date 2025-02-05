using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class TarjetaDeCreditoViewModel
    {
        public string NombreTarjetahabiente { get; set; }
        public System.DateTime FechaVencimiento { get; set; }
        public string NumeroTarjeta { get; set; }
        public int CVV { get; set; }
        public int comprador_IdComprador { get; set; }
    }
}