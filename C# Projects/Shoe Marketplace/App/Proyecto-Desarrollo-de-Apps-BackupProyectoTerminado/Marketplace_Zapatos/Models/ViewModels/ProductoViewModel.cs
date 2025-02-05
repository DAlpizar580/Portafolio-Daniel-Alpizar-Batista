using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class ProductoViewModel
    {
        public int IdProducto { get; set; }
        public string Modelo { get; set; }
        public int Precio { get; set; }
        public int Stock { get; set; }
        public string Color { get; set; }
        public string Disponibilidad { get; set; }
        public int Vendedor_IdVendedor { get; set; }
        public int Marca_IdMarca { get; set; }
        public int Talla_IdTalla { get; set; }
        public int Categoria_IdCategoria { get; set; }
        public bool Aprobado { get; set; }
        public int Administrador_IdAdministrador { get; set; }
        public virtual Administrador Administrador { get; set; }
        public virtual Categoria Categoria { get; set; }
        public virtual Marca Marca { get; set; }
        public virtual Imagenes_Producto Imagenes_Producto { get; set; }
        public virtual Talla Talla { get; set; }
        public virtual Vendedor Vendedor { get; set; }


    }
}