using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ParqueoULACIT.Models.ViewModel
{
    public class HistorialEstudianteViewModel
    {
        public DateTime Fecha { get; set; }
        public TimeSpan Hora { get; set; }
        public string Numero_Placa { get; set; }
        public string Parqueo { get; set; }
        public string MovimientoNombre { get; set; }
        public string TipoNombre { get; set; }
    }
}