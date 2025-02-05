using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Proyecto_Diseño_Web.Models.ViewModels
{
    public class DestinosVM
    {
        public decimal IdDestino { get; set; }
        public string Nombre { get; set; }
        public string Provincia { get; set; }
        public string Categoria { get; set; }
        public Nullable<decimal> Precio_Minimo { get; set; }
        public Nullable<decimal> Precio_Maximo { get; set; }
        public string Descripcion { get; set; }
        public string Direccion { get; set; }
        public byte[] Imagen { get; set; }
    }
}