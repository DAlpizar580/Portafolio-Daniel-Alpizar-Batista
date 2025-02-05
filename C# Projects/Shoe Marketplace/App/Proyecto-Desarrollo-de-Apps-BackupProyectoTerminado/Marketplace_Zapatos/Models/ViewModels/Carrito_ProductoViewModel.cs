using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class Carrito_ProductoViewModel
    {
        public int CarritoDeCompras_IdCarrito { get; set; }
        public int Producto_IdProducto { get; set; }
        public int Cantidad { get; set; }

        public int precio { get; set; }

        public virtual Marca Marca { get; set; }
        public virtual Talla Talla { get; set; }
    }
}