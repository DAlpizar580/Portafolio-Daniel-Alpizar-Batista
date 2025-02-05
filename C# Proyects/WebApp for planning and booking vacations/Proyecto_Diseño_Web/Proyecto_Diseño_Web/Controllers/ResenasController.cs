using Proyecto_Diseño_Web.Models.TableViewModels;
using Proyecto_Diseño_Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Proyecto_Diseño_Web.Controllers
{
    public class ResenasController : Controller
    {
        public ActionResult VerResenas(int idDestino)
        {
            List<ResenaTVM> lstReseñas = null;

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var reseñasQuery = from r in db.Reseñas
                                   join u in db.Usuarios on r.Usuarios_Id equals u.Id
                                   where r.Destinos_IdDestino == idDestino
                                   select new ResenaTVM
                                   {
                                       IdReseña = r.IdReseña,
                                       Calificacion = r.Calificacion,
                                       Comentario = r.Comentario,
                                       UsuarioNombre = u.Nombre,
                                       Usuarios_Id = r.Usuarios_Id,
                                       Destinos_IdDestino = r.Destinos_IdDestino
                                   };

                lstReseñas = reseñasQuery.ToList();
                if (lstReseñas == null || lstReseñas.Count() == 0)
                {
                    var reseña = new ResenaTVM
                    {
                        IdReseña = 0,
                        Calificacion = 0,
                        Comentario = "No hay reseñas para este destino",
                        UsuarioNombre = "N/A",
                        Usuarios_Id = 0,
                        Destinos_IdDestino = idDestino
                    };
                    lstReseñas.Add(reseña);
                    return View(lstReseñas);
                }
            }
            

            return View(lstReseñas);
        }

        [HttpPost]
        public ActionResult EliminarResena(decimal idReseña)
        {
            var userId = Convert.ToDecimal(Session["UserId"]);
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var reseña = db.Reseñas.Find(idReseña);
                if (reseña != null && reseña.Usuarios_Id == userId)
                {
                    db.Reseñas.Remove(reseña);
                    db.SaveChanges();
                }

                return RedirectToAction("VerResenas", new { idDestino = reseña.Destinos_IdDestino });
            }
        }

        [HttpGet]
        public ActionResult Crear(int idDestino)
        {
            var userId = Convert.ToDecimal(Session["UserId"]);

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var tieneReserva = db.Reservas
                    .Any(r => r.Usuarios_Id == userId && r.Actividades_Destino.Destinos_IdDestino == idDestino);

                if (!tieneReserva)
                {
                 
                    TempData["Error"] = "No puedes crear una reseña si no has reservado alguna actividad en este destino.";
                    return RedirectToAction("VerResenas", "Resenas", new { idDestino = idDestino }); 
                }
            }

            var model = new ReseñaTVM
            {
                Destinos_IdDestino = idDestino,
                Usuarios_Id = userId
            };

            return View(model);
        }

        [HttpPost]
        public ActionResult Crear(ReseñaTVM model)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            var userId = Convert.ToDecimal(Session["UserId"]);

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var tieneReserva = db.Reservas
                    .Any(r => r.Usuarios_Id == userId && r.Actividades_Destino.Destinos_IdDestino == model.Destinos_IdDestino);

                if (!tieneReserva)
                {
                    ModelState.AddModelError("", "No puedes crear una reseña sin haber reservado una actividad en este destino.");
                    return View(model);
                }

                var nuevaReseña = new Reseñas
                {
                    Calificacion = model.Calificacion,
                    Comentario = model.Comentario,
                    Destinos_IdDestino = model.Destinos_IdDestino,
                    Usuarios_Id = model.Usuarios_Id,
                };

                db.Reseñas.Add(nuevaReseña);
                db.SaveChanges();
            }

            return RedirectToAction("VerResenas", "Resenas", new { idDestino = model.Destinos_IdDestino });
        }


    }
}
