using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Proyecto_Diseño_Web.Models.ViewModels
{
    public class CambiarContraseñaViewModel
    {
        public string Correo { get; set; }  // Correo del usuario, lo recibimos en la URL para identificar al usuario
        public string NuevaContraseña { get; set; }  // La nueva contraseña que el usuario desea establecer
        public string ConfirmarContraseña { get; set; }  // Para verificar que la contraseña ingresada sea la correcta
    }
}