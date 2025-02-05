using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Proyecto_Diseño_Web.Models.TableViewModels
{
    public class TarjetasTVM
    {
        public decimal IdTarjeta { get; set; }
        public decimal Numero_de_tarjeta { get; set; }
        public DateTime Fecha_de_vencimiento { get; set; }
        public decimal Codigo_de_seguridad { get; set; }
        public decimal Usuarios_Id { get; set; }
    }
}