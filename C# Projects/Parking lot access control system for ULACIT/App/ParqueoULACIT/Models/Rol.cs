//------------------------------------------------------------------------------
// <auto-generated>
//    Este código se generó a partir de una plantilla.
//
//    Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//    Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace ParqueoULACIT.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class Rol
    {
        public Rol()
        {
            this.Usuario = new HashSet<Usuario>();
        }
    
        public int ID_Rol { get; set; }
        public string Nombre_Rol { get; set; }
    
        public virtual ICollection<Usuario> Usuario { get; set; }
    }
}
