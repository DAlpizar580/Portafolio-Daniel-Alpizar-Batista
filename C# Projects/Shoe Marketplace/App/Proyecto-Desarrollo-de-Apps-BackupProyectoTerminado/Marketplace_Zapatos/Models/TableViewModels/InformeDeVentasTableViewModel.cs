using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.TableViewModels
{
    public class InformeDeVentasTableViewModel
    {
        public int TotalOrdenes { get; set; }
        public decimal MontoTotalGanado { get; set; }
        public List<HistorialDeVentasTableViewModel> Historiales { get; set; }
    }
}