using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class ReviewVendedorViewModel
    {
        public int IdReview { get; set; }
        public string Comentario { get; set; }
        public int Calificacion { get; set; }
        public int Vendedor_IdVendedor { get; set; }
        public int comprador_IdComprador { get; set; }

        public virtual comprador comprador { get; set; }
        public virtual Vendedor Vendedor { get; set; }

    }
}