using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ParqueoULACIT.Models.TableViewModel
{
    public class ParqueoTableViewModel
    {
        public int ID_Parqueo { get; set; }
        public string Nombre { get; set; }
        public int Capacidad_Espacios_Regulares { get; set; }
        public int Capacidad_Espacios_Moto { get; set; }
        public int Capacidad_Espacios_7600 { get; set; }
    }
}