using Marketplace_Zapatos.Models.TableViewModels;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class OrderViewModel
    {
        public decimal MontoTotal { get; set; }
        public int IdOrden { get; set; }
        public int PrecioEnvio { get; set; }
        public int CompradorID { get; set; }
        public int DireccionID { get; set; }
        public string NumeroTarjeta { get; set; } 
    }
}