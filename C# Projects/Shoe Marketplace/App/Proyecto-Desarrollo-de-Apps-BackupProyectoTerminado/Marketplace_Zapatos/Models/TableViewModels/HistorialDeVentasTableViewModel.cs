using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.TableViewModels
{
    public class HistorialDeVentasTableViewModel
    {
        public int IdOrden { get; set; }
        public string MetodoDePago { get; set; }
        public DateTime Fecha { get; set; }
        public string Direccion { get; set; }
        public string Estado { get; set; }
        public string CorreoComprador { get; set; }
        public string NombreComprador { get; set; }
        public List<Orden_ProductoTableViewModel> Productos { get; set; }
        public List<Vendedor> Vendedores { get; set; }
        public decimal TotalOrden { get; set; }
    }
}