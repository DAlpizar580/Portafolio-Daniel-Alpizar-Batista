using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Proyecto_Diseño_Web.Models.TableViewModels
{
    public class ActividadesItinerarioTVM
    {
        public string Descripcion { get; set; }
        public DateTime? FechaActividad { get; set; }
        public string DestinoNombre { get; set; }
        public string ActividadNombre { get; set; } 
        public decimal ItinerarioId { get; set; }
        public decimal ActividadId { get; set; }
        public decimal DestinoId { get; set; }
    }
}