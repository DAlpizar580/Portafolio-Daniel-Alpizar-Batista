using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace ParqueoULACIT.Models.ViewModel
{
    public class MovimientoViewModel
    {
        public int ID_Movimiento { get; set; }

        [Required]
        [Display(Name = "Tipo de movimiento")]
        public string Tipo_Movimiento { get; set; }
    }
}