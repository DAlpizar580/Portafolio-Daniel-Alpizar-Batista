using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class Imagenes_ProductoViewModel
    {
        public byte[] Imagen { get; set; }
        public int Producto_IdProducto { get; set; }

        public virtual Producto Producto { get; set; }
    }
}