using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Proyecto_Diseño_Web.Models.TableViewModels
{
    public class PagoPaqueteViewModel
    {
        public int IdPaquete { get; set; } 
        public List<int> IdActividades { get; set; } 
        public List<ActividadesDestinoTVM> Actividades { get; set; }
        public decimal? PrecioTotalOriginal { get; set; }
        public decimal? Descuento { get; set; } 
        public decimal? PrecioTotalFinal { get; set; }
        public int TarjetaId { get; set; } 
        public SelectList Tarjetas { get; set; }
    }
}