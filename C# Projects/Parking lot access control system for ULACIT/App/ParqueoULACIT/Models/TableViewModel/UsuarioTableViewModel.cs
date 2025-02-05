using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ParqueoULACIT.Models.TableViewModel
{
    public class UsuarioTableViewModel
    {
        public int ID_Usuario { get; set; }
        public string Nombre { get; set; }
        public string Apellido_1 { get; set; }
        public string Apellido_2 { get; set; }
        public string Correo { get; set; }
        public string Contrasena { get; set; }
        public System.DateTime Fecha_Nacimiento { get; set; }
        public string Identificacion { get; set; }
        public string Numero_Carne { get; set; }
        public int ID_Rol { get; set; }
        public bool Estado { get; set; }
        public string Rol { get; set; }
        public string EstadoUsuario { get; set; }
    }
}