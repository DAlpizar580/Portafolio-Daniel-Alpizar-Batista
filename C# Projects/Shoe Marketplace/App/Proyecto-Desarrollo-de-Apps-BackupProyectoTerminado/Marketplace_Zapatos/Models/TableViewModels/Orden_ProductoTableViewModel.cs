using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.TableViewModels
{
    public class Orden_ProductoTableViewModel
    {
        public int Cantidad { get; set; }
        public string Modelo { get; set; }
        public int precio { get; set; }
        public int idHistorial { get; set; }
        public virtual Marca Marca { get; set; }
        public virtual Talla Talla { get; set; }
        public Vendedor Vendedor { get; set; }
    }
}