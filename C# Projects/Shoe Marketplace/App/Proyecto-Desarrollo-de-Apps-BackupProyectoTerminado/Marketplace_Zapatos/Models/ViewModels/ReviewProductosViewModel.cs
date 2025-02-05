using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class ReviewProductosViewModel
    {
        public int IdReviewProducto { get; set; }
        public string Comentario { get; set; }
        public int Calificacion { get; set; }
        public int comprador_IdComprador { get; set; }
        public int Producto_IdProducto { get; set; }

        public virtual comprador comprador { get; set; }
        public virtual Producto Producto { get; set; }

    }
}