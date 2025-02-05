using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Proyecto_Diseño_Web.Models.TableViewModels
{
    public class ReseñaTVM
    {
        public decimal IdReseña { get; set; }
        public int Calificacion { get; set; }
        public string Comentario { get; set; }
        public decimal Destinos_IdDestino { get; set; }
        public decimal Usuarios_Id { get; set; }
    }
}