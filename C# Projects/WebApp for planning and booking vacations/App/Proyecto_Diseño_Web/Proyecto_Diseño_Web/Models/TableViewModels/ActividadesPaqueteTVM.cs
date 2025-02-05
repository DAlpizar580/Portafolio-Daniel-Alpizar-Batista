using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Proyecto_Diseño_Web.Models.TableViewModels
{
    public class ActividadesPaqueteTVM
    {
        public decimal IdActividad { get; set; }
        public string Nombre_actividad { get; set; }
        public string Descripcion { get; set; }
        public decimal? Precio { get; set; }
        public decimal Paquetes_de_viaje_IdPaquete { get; set; }
    }
}