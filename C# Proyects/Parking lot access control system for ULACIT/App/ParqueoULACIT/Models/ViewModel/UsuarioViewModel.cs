using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using ParqueoULACIT.Attributes;


namespace ParqueoULACIT.Models.ViewModel
{
    public class UsuarioViewModel
    {
        public int ID_Usuario { get; set; }

        [Required(ErrorMessage = "El nombre es obligatorio.")]
        [StringLength(50, ErrorMessage = "El campo {0} debe tener un máximo de {1} caracteres.")]
        [RegularExpression(@"^[a-zA-ZÁÉÍÓÚáéíóúñÑ\s]+$", ErrorMessage = "El nombre solo debe contener letras.")]
        public string Nombre { get; set; }


        [Required]
        [Display(Name = "Primer Apellido")]
        [StringLength(50, ErrorMessage = "El campo {0} debe tener un máximo de {1} caracteres")]
        public string Apellido_1 { get; set; }

        [Display(Name = "Segundo Apellido")]
        [StringLength(50, ErrorMessage = "El campo {0} debe tener un máximo de {1} caracteres")]
        public string Apellido_2 { get; set; }


        [Required(ErrorMessage = "El correo es obligatorio.")]
        [RegularExpression(@"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}\s*$", ErrorMessage = "Formato de correo no válido.")]

        public string Correo { get; set; }


        [Required]
        [Display(Name = "Contraseña")]
        [StringLength(200, ErrorMessage = "El campo {0} debe tener un máximo de {1} caracteres")]
        public string Contrasena { get; set; }

        [Required(ErrorMessage = "La fecha de nacimiento es obligatoria.")]
        [Display(Name = "Fecha de nacimiento")]
        [CustomValidation(typeof(UsuarioViewModel), nameof(ValidarEdad))]
        public DateTime Fecha_Nacimiento { get; set; }


        public static ValidationResult ValidarEdad(DateTime fechaNacimiento, ValidationContext context)
        {
            int edad = DateTime.Now.Year - fechaNacimiento.Year;
            if (fechaNacimiento > DateTime.Now.AddYears(-edad)) edad--;

            return edad >= 18
                ? ValidationResult.Success
                : new ValidationResult("Debe ser mayor de 18 años.");
        }







        [Required(ErrorMessage = "La identificación es obligatoria.")]
        [RegularExpression(@"^\d{9}$", ErrorMessage = "La cédula debe ser un número de 9 dígitos.")]
        public string Identificacion { get; set; }

        [Required]
        [Display(Name = "Número de Carné")]
        [StringLength(20, ErrorMessage = "El campo {0} debe tener un máximo de {1} caracteres")]
        public string Numero_Carne { get; set; }

        [Required]
        [Display(Name = "Rol")]
        public int ID_Rol { get; set; }

        [Required]
        public bool Estado { get; set; }

        public string DescripcionUsuario {  get; set; }
    }
}