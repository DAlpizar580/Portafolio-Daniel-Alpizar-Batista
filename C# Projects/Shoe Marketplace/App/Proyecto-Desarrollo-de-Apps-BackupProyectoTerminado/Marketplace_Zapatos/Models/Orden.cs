//------------------------------------------------------------------------------
// <auto-generated>
//    Este código se generó a partir de una plantilla.
//
//    Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//    Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Marketplace_Zapatos.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class Orden
    {
        public Orden()
        {
            this.HistorialPedidos = new HashSet<HistorialPedidos>();
            this.Producto_Orden = new HashSet<Producto_Orden>();
            this.Vendedor = new HashSet<Vendedor>();
        }
    
        public decimal MontoTotal { get; set; }
        public string Estado { get; set; }
        public int IdOrden { get; set; }
        public int PrecioEnvio { get; set; }
        public int comprador_IdComprador { get; set; }
        public string FormaDePago { get; set; }
    
        public virtual comprador comprador { get; set; }
        public virtual ICollection<HistorialPedidos> HistorialPedidos { get; set; }
        public virtual ICollection<Producto_Orden> Producto_Orden { get; set; }
        public virtual ICollection<Vendedor> Vendedor { get; set; }
    }
}
