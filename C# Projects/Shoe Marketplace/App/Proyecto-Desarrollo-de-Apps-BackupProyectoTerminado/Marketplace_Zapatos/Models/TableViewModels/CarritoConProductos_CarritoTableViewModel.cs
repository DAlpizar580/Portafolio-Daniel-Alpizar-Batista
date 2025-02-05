using Marketplace_Zapatos.Models.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.TableViewModels
{
    public class CarritoConProductos_CarritoTableViewModel
    {
        public List<Carrito_ProductoTableViewModel> Productos { get; set; }
        public CarritoDeCompras Carrito { get; set; }
    }
}