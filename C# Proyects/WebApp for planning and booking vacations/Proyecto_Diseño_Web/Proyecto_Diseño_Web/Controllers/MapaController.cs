using Proyecto_Diseño_Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;


namespace Proyecto_Diseño_Web.Controllers
{
    public class MapaController : Controller
    {
        public ActionResult Interactivo()
        {
            return View();
        }


        /* Acción para obtener destinos por lugar específico
        public JsonResult GetDestinosPorLugar(int id)
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var destino = db.Destinos
                                .Where(d => d.IdDestino == id)
                                .Select(d => new
                                {
                                    d.IdDestino,
                                    d.Nombre,
                                    d.Categoria,
                                    d.Precio_Minimo,
                                    d.Precio_Maximo,
                                    d.Descripcion,
                                    d.Direccion
                                }).FirstOrDefault();

                return Json(destino, JsonRequestBehavior.AllowGet);
            }
        }*/

        // Nueva acción: Mapa interactivo con lista de paquetes de viaje
        public ActionResult InteractivoConPaquetes()
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                // Obtener todos los paquetes de viaje
                var paquetes = db.Paquetes_de_viaje.ToList();

                return View(paquetes); // Enviar los paquetes a la vista
            }
        }

        // Acción para obtener destinos por nombre (si es necesario en el mapa)
        public JsonResult GetDestinosPorLugar(string nombre)
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var destinos = db.Destinos
                                 .Where(d => d.Nombre.Contains(nombre))
                                 .Select(d => new
                                 {
                                     d.IdDestino,
                                     d.Nombre,
                                     d.Provincia,
                                     d.Categoria,
                                     d.Precio_Minimo,
                                     d.Precio_Maximo,
                                     d.Descripcion,
                                     d.Direccion
                                 }).ToList();

                return Json(destinos, JsonRequestBehavior.AllowGet);
            }
        }
    }
}
