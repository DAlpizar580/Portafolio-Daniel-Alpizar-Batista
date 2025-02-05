using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace ParqueoULACIT.Models.ViewModel
{
    public class ParqueoViewModel
    {
        public int ID_Parqueo { get; set; }

        [Required]
        [StringLength(100, ErrorMessage = "El campo {0} debe tener un máximo de {1} caracteres")]
        public string Nombre { get; set; }

        [Required]
        [Range(0, double.MaxValue, ErrorMessage = "El valor debe ser mayor o igual a 0")]
        [Display(Name = "Capacidad de espacios regulares")]
        public int Capacidad_Espacios_Regulares { get; set; }

        [Required]
        [Range(0, double.MaxValue, ErrorMessage = "El valor debe ser mayor o igual a 0")]
        [Display(Name = "Capacidad de espacios para motos")]
        public int Capacidad_Espacios_Moto { get; set; }

        [Required]
        [Range(0, double.MaxValue, ErrorMessage = "El valor debe ser mayor o igual a 0")]
        [Display(Name = "Capacidad de espacios Ley 7600")]
        public int Capacidad_Espacios_7600 { get; set; }
    }
}