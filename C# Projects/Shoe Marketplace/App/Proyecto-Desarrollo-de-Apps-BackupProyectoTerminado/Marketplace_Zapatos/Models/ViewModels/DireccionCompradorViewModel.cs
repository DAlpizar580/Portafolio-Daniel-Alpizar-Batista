using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class DireccionCompradorViewModel
    {
        public string Ciudad { get; set; }
        public int IdDirreccion { get; set; }
        public string Pais { get; set; }
        public int CodigoPostal { get; set; }
        public string Descripcion { get; set; }
        public Nullable<int> comprador_IdComprador { get; set; }
    }
}