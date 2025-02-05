 using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace ParqueoULACIT.Models.ViewModel
{
    public class VehiculoViewModel
    {
        public int ID_Vehiculo { get; set; }

        [Required]
        [StringLength(30, ErrorMessage = "El campo {0} debe tener un máximo de {1} caracteres")]
        public string Marca { get; set; }

        [Required]
        [StringLength(50, ErrorMessage = "El campo {0} debe tener un máximo de {1} caracteres")]
        public string Color { get; set; }

        [Required(ErrorMessage = "El número de placa es obligatorio")]
        [Display(Name = "Placa")]
        [StringLength(50, ErrorMessage = "El campo {0} debe tener un máximo de {1} caracteres")]
        // Validación de la placa de Costa Rica con expresión regular
        [RegularExpression(@"^(?:\d{6}|M\d{5}|C\d{6})$", ErrorMessage = "El formato de la placa no es válido. Debe ser 6 dígitos, M seguido de 5 dígitos, o C seguido de 6 dígitos.")]
        public string Numero_Placa { get; set; }












        [Required]
        [Display(Name = "Tipo")]
        public int ID_Tipo { get; set; }

        [Required]
        [Display(Name = "Propietario")]
        public int ID_Usuario { get; set; }

        [Required]
        [Display(Name = "Requiere espacio Ley 7600")]
        public bool Espacio_7600 { get; set; }

        [Required]
        public bool Estado { get; set; }

        //Listas para DropDownLists
        public List<TipoVehiculoViewModel> TiposVehiculo { get; set; }
        public List<UsuarioViewModel> Usuarios { get; set; }
    }
}