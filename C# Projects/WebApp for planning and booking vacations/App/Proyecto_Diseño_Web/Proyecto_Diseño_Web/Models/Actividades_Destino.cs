//------------------------------------------------------------------------------
// <auto-generated>
//    Este código se generó a partir de una plantilla.
//
//    Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//    Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Proyecto_Diseño_Web.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class Actividades_Destino
    {
        public Actividades_Destino()
        {
            this.Actividades_Itinerario = new HashSet<Actividades_Itinerario>();
            this.Actividades_Paquete = new HashSet<Actividades_Paquete>();
            this.Descuentos = new HashSet<Descuentos>();
            this.Reservas = new HashSet<Reservas>();
        }
    
        public decimal IdActividad { get; set; }
        public string Nombre { get; set; }
        public string Descripcion { get; set; }
        public Nullable<System.DateTime> Fecha { get; set; }
        public decimal Destinos_IdDestino { get; set; }
        public Nullable<decimal> Precio { get; set; }
    
        public virtual Destinos Destinos { get; set; }
        public virtual ICollection<Actividades_Itinerario> Actividades_Itinerario { get; set; }
        public virtual ICollection<Actividades_Paquete> Actividades_Paquete { get; set; }
        public virtual ICollection<Descuentos> Descuentos { get; set; }
        public virtual ICollection<Reservas> Reservas { get; set; }
    }
}
