using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class CarritoProductoOriginalViewModel
    {
        public int CarritoDeCompras_IdCarrito { get; set; }
        public int Producto_IdProducto { get; set; }
        public int Cantidad { get; set; }
        public string Modelo { get; set; } // Assuming Modelo is a string
        public decimal Precio { get; set; } // Assuming Precio is a decimal

        public virtual CarritoDeCompras CarritoDeCompras { get; set; }
        public virtual Producto Producto { get; set; }
    }
}