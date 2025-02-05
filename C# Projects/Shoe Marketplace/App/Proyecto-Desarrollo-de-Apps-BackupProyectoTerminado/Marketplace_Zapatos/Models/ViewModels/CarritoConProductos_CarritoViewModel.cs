using Marketplace_Zapatos.Models.TableViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class CarritoConProductos_CarritoViewModel
    {
        public List<Carrito_ProductoViewModel> Productos { get; set; }

        public CarritoDeCompras Carrito { get; set; }
    }
}