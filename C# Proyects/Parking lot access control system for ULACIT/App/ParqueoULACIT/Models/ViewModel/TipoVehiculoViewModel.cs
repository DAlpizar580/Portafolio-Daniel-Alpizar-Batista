using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace ParqueoULACIT.Models.ViewModel
{
    public class TipoVehiculoViewModel
    {
        public int ID_Tipo { get; set; }

        [Required]
        [Display(Name = "Tipo de vehículo")]
        [StringLength(50, ErrorMessage = "El campo {0} debe tener un máximo de {1} caracteres")]
        public string Tipo { get; set; }
    }
}