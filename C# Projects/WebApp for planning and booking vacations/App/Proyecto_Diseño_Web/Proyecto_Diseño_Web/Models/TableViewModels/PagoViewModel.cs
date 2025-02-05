using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Proyecto_Diseño_Web.Models.TableViewModels
{
    public class PagoViewModel
    {
        public decimal IdActividad { get; set; }
        public Actividades_Destino Actividad { get; set; }
        public decimal? PrecioOriginal { get; set; }
        public decimal? Descuento { get; set; }
        public decimal? PrecioFinal { get; set; }
        public int TarjetaId { get; set; }
        public SelectList Tarjetas { get; set; }
    }
}