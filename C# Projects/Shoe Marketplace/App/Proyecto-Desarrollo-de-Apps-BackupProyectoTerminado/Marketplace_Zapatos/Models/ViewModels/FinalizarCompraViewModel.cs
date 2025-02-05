using Marketplace_Zapatos.Models.TableViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class FinalizarCompraViewModel
    {
        public List<Carrito_ProductoTableViewModel> Productos { get; set; }
        public CarritoDeCompras Carrito { get; set; }
        public int CompradorID { get; set; }
        public int? DireccionID { get; set; }
        public string NumeroTarjeta { get; set; }
    }
}