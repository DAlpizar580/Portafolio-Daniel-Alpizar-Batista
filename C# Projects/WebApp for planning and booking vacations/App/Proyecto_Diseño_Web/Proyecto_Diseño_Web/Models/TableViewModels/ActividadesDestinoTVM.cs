using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Proyecto_Diseño_Web.Models.TableViewModels
{
    public class ActividadesDestinoTVM
    {
        public decimal IdActividad { get; set; }
        public string Nombre { get; set; }
        public string Descripcion { get; set; }
        public DateTime? Fecha { get; set; }
        public decimal? Precio { get; set; }
        public decimal Destinos_IdDestino { get; set; }
        public decimal? IdDescuento { get; set; }
        public decimal? Descuento { get; set; }
    }
}