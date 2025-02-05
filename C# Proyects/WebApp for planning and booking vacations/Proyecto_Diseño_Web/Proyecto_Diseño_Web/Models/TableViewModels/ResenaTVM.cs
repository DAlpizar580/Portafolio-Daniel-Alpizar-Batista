using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Proyecto_Diseño_Web.Models.TableViewModels
{
    public class ResenaTVM
    {
        public decimal IdReseña { get; set; }
        public decimal? Calificacion { get; set; }
        public string Comentario { get; set; }
        public string UsuarioNombre { get; set; }
        public decimal Destinos_IdDestino { get; set; }
        public decimal Usuarios_Id { get; set; }
    }
}