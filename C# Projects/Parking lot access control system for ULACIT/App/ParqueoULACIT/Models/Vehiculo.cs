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
    
    public partial class Vehiculo
    {
        public int ID_Vehiculo { get; set; }
        public string Marca { get; set; }
        public string Color { get; set; }
        public string Numero_Placa { get; set; }
        public int ID_Tipo { get; set; }
        public int ID_Usuario { get; set; }
        public bool Espacio_7600 { get; set; }
        public bool Estado { get; set; }
    
        public virtual Tipo_Vehiculo Tipo_Vehiculo { get; set; }
        public virtual Usuario Usuario { get; set; }
    }
}
