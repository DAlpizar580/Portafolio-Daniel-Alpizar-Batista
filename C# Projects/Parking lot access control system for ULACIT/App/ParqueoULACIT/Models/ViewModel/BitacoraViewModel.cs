using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace ParqueoULACIT.Models.ViewModel
{
    public class BitacoraViewModel
    {
        public int ID_Bitacora { get; set; }

        [Required]
        public System.DateTime Fecha { get; set; }

        [Required]
        public System.TimeSpan Hora { get; set; }

        [Required]
        [Display(Name = "Placa")]
        public string Numero_Placa { get; set; }

        [Required]
        [Display(Name = "Movimiento")]
        public int ID_Movimiento { get; set; }

        [Required]
        [Display(Name = "Parqueo")]
        public int ID_Parqueo { get; set; }

        [Required]
        [Display(Name = "Tipo de vehículo")]
        public int ID_Tipo { get; set; }
    }
}