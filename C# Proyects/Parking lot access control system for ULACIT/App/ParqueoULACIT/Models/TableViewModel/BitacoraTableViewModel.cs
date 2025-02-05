using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace ParqueoULACIT.Models.TableViewModel
{
    public class BitacoraTableViewModel
    {
        public int ID_Bitacora { get; set; }
        public System.DateTime Fecha { get; set; }
        public System.TimeSpan Hora { get; set; }
        public string Numero_Placa { get; set; }
        public int ID_Movimiento { get; set; }
        public int ID_Parqueo { get; set; }
        public int ID_Tipo { get; set; }
    }
}