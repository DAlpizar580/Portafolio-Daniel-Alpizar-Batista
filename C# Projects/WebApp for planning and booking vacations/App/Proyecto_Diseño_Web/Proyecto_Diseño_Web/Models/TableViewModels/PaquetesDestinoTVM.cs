using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Proyecto_Diseño_Web.Models.TableViewModels
{
    public class PaquetesDestinoTVM
    {
        public decimal IdPaquete { get; set; }
        public string Nombre_del_paquete { get; set; }
        public string Descripcion { get; set; }
        public decimal? Precio { get; set; }
        public decimal Destinos_IdDestino { get; set; }
    }
}