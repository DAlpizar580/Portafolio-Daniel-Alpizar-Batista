using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ParqueoULACIT.Models.TableViewModel
{
    public class Ocupacion
    {
        public string NombreParqueo;
        public List<List<string>> EspaciosOcupados = new List<List<string>>();
    }
}