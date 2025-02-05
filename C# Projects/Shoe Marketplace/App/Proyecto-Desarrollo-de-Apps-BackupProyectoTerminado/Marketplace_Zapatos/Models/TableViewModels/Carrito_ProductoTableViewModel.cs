using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.TableViewModels
{
    public class Carrito_ProductoTableViewModel
    {
        public int CarritoDeCompras_IdCarrito { get; set; }
        public int Producto_IdProducto { get; set; }
        public int Cantidad { get; set; }
        public string Modelo { get; set; }
        public int precio { get; set; }
        public int Stock { get; set; }
        public string NombreVendedor { get; set; }
        public Vendedor Vendedor { get; set; }
        public virtual Marca Marca { get; set; }
        public virtual Talla Talla { get; set; }
    }
}