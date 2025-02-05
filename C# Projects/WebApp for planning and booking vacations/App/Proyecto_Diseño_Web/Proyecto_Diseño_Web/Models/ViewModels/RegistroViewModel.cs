
using System;
using System.ComponentModel.DataAnnotations;

namespace Proyecto_Diseño_Web.Models.ViewModels
{
    public class RegistroViewModel
    {


        public string Cedula { get; set; }
        public string Correo { get; set; }
        public int Telefono { get; set; }
        public DateTime FechaDeNacimiento { get; set; }
        public string Genero { get; set; }
        public string Contraseña { get; set; }

        // Nuevos campos
        public string Nombre_Completo { get; set; }
        public string Preferencias_de_Viaje { get; set; }
        public string Nombre { get; set; }
        public string Apellidos { get; set; }




        //[Required(ErrorMessage = "La cédula es obligatoria.")]
        //public string Cedula { get; set; }

        //[Required(ErrorMessage = "El correo es obligatorio.")]
        //[EmailAddress(ErrorMessage = "Correo electrónico no válido.")]
        //public string Correo { get; set; }

        //[Required(ErrorMessage = "El teléfono es obligatorio.")]
        //public int Telefono { get; set; }

        //[Required(ErrorMessage = "La fecha de nacimiento es obligatoria.")]
        //[DataType(DataType.Date, ErrorMessage = "Fecha de nacimiento no válida.")]
        //public DateTime FechaDeNacimiento { get; set; }

        //[Required(ErrorMessage = "El género es obligatorio.")]
        //public string Genero { get; set; }

        //[Required(ErrorMessage = "La contraseña es obligatoria.")]
        //[StringLength(100, ErrorMessage = "La contraseña debe tener al menos 6 caracteres.", MinimumLength = 6)]
        //public string Contraseña { get; set; }

        //[Required(ErrorMessage = "Debe confirmar la contraseña.")]
        //[Compare("Contraseña", ErrorMessage = "Las contraseñas no coinciden.")]
        //public string ConfirmarContraseña { get; set; }
    }
}
