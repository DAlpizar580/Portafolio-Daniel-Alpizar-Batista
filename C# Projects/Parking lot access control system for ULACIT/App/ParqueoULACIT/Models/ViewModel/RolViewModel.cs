using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace ParqueoULACIT.Models.ViewModel
{
    public class RolViewModel
    {
        public int ID_Rol { get; set; }

        [Required]
        [Display(Name = "Rol")]
        [StringLength(50, ErrorMessage = "El campo {0} debe tener un máximo de {1} caracteres")]
        public string Nombre_Rol { get; set; }
    }
}