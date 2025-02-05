using Proyecto_Diseño_Web.Models;
using Proyecto_Diseño_Web.Models.TableViewModels;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.UI.WebControls;

namespace Proyecto_Diseño_Web.Controllers
{
    public class PaquetesDeViajeController : Controller
    {
        // GET: PaquetesDeViaje
        public ActionResult Index(int idDestino, string searchBy, string search)
        {
            List<PaquetesDestinoTVM> lstPaquetes = null;
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var paquetesQuery = from p in db.Paquetes_de_viaje
                                    where p.Destinos_IdDestino == idDestino
                                    select new PaquetesDestinoTVM
                                    {
                                        IdPaquete = p.IdPaquete,
                                        Nombre_del_paquete = p.Nombre_del_paquete,
                                        Descripcion = p.Descripcion,
                                        Precio = p.Precio,
                                        Destinos_IdDestino = p.Destinos_IdDestino
                                    };

                // Aplicar el filtro de búsqueda
                if (!string.IsNullOrEmpty(search))
                {
                    if (searchBy == "Nombre")
                    {
                        paquetesQuery = paquetesQuery.Where(x => x.Nombre_del_paquete.Contains(search));
                    }
                    else if (searchBy == "Descripcion")
                    {
                        paquetesQuery = paquetesQuery.Where(x => x.Descripcion.Contains(search));
                    }
                    else if (searchBy == "Precio")
                    {
                        if (decimal.TryParse(search, out var precio))
                        {
                            paquetesQuery = paquetesQuery.Where(x => x.Precio <= precio);
                        }
                    }
                }
                lstPaquetes = paquetesQuery.OrderBy(x => x.Nombre_del_paquete).ToList();
            }
            if (lstPaquetes == null || lstPaquetes.Count == 0)
            {
                return RedirectToAction("Crear", "PaquetesDeViaje", new { idDestino = idDestino });
            }

            return View(lstPaquetes);
        }
        [HttpGet]
        public ActionResult Edit(int id)
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var paquete = db.Paquetes_de_viaje
                                .Where(p => p.IdPaquete == id)
                                .Select(p => new PaquetesDestinoTVM
                                {
                                    IdPaquete = p.IdPaquete,
                                    Nombre_del_paquete = p.Nombre_del_paquete,
                                    Descripcion = p.Descripcion,
                                    Precio = p.Precio,
                                    Destinos_IdDestino = p.Destinos_IdDestino
                                }).SingleOrDefault();

                if (paquete == null)
                {
                    return HttpNotFound();
                }
                ViewBag.IdPaquete = paquete.IdPaquete;
                return View(paquete);
            }
        }
        [HttpPost]
        public ActionResult Edit(PaquetesDestinoTVM model)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var paquete = db.Paquetes_de_viaje.Find(model.IdPaquete);

                if (paquete != null)
                {
                    paquete.Nombre_del_paquete = model.Nombre_del_paquete;
                    paquete.Descripcion = model.Descripcion;
                    paquete.Precio = model.Precio;
                    paquete.Destinos_IdDestino = model.Destinos_IdDestino;

                    db.Entry(paquete).State = EntityState.Modified;
                    db.SaveChanges();
                }
                else
                {
                    ModelState.AddModelError("", "Paquete de viaje no encontrado.");
                    return View(model);
                }
                return RedirectToAction("Index", "PaquetesDeViaje", new { idDestino = paquete.Destinos_IdDestino });
            }


        }
        [HttpGet]
        public ActionResult Crear(int idDestino)
        {
            var model = new PaquetesDestinoTVM
            {
                Destinos_IdDestino = idDestino
            };

            return View(model);
        }

        // POST: Crear
        [HttpPost]
        public ActionResult Crear(PaquetesDestinoTVM model)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var nuevoPaquete = new Paquetes_de_viaje
                {
                    Nombre_del_paquete = model.Nombre_del_paquete,
                    Descripcion = model.Descripcion,
                    Precio = model.Precio,
                    Destinos_IdDestino = model.Destinos_IdDestino
                };

                db.Paquetes_de_viaje.Add(nuevoPaquete);
                db.SaveChanges();
            }

            EnvioDeCorreo correo = new EnvioDeCorreo();
            correo.EnviarCorreo();

            return RedirectToAction("Index", "PaquetesDeViaje", new { idDestino = model.Destinos_IdDestino });
        }

        [HttpPost, ActionName("Delete")]
        public ActionResult Delete(int id)
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var paquete = db.Paquetes_de_viaje.Find(id);
                if (paquete == null)
                {
                    return HttpNotFound();
                }

                db.Paquetes_de_viaje.Remove(paquete);
                db.SaveChanges();

                return RedirectToAction("Index", "PaquetesDeViaje", new { idDestino = paquete.Destinos_IdDestino });
            }
        }

        public ActionResult ActividadesPaquete(int idDestino, int idPaquete, string searchBy, string search)
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var actividadesQuery = from a in db.Actividades_Destino
                                       where a.Destinos_IdDestino == idDestino
                                       select new ActividadesDestinoTVM
                                       {
                                           IdActividad = a.IdActividad,
                                           Nombre = a.Nombre,
                                           Descripcion = a.Descripcion,
                                           Fecha = a.Fecha,
                                           Precio = a.Precio,
                                           Destinos_IdDestino = a.Destinos_IdDestino
                                       };

                if (!string.IsNullOrEmpty(search))
                {
                    if (searchBy == "Nombre")
                    {
                        actividadesQuery = actividadesQuery.Where(x => x.Nombre.Contains(search));
                    }
                    else if (searchBy == "Descripcion")
                    {
                        actividadesQuery = actividadesQuery.Where(x => x.Descripcion.Contains(search));
                    }
                    else if (searchBy == "Fecha")
                    {
                        if (DateTime.TryParse(search, out var fecha))
                        {
                            actividadesQuery = actividadesQuery.Where(x => x.Fecha == fecha);
                        }
                    }
                    else if (searchBy == "Precio")
                    {
                        if (decimal.TryParse(search, out var precio))
                        {
                            actividadesQuery = actividadesQuery.Where(x => x.Precio <= precio);
                        }
                    }
                }

                var actividadesEnPaquete = db.Actividades_Paquete
                    .Where(ap => ap.Paquetes_de_viaje_IdPaquete == idPaquete)
                    .Select(ap => ap.Actividades_Destino_IdActividad)
                    .ToHashSet();

                var actividades = actividadesQuery.ToList();

                var actividadesIncluidas = actividades.Where(a => actividadesEnPaquete.Contains(a.IdActividad)).ToList();
                var actividadesNoIncluidas = actividades.Where(a => !actividadesEnPaquete.Contains(a.IdActividad)).ToList();

                ViewBag.ActividadesIncluidas = actividadesIncluidas;
                ViewBag.IdPaquete = idPaquete;
                ViewBag.IdDestino = idDestino;

                return View(actividadesNoIncluidas);
            }
        }



        [HttpPost]
        public ActionResult ActividadesPaquete(int idDestino, int IDActividad, int IDPaquete)
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var existeRelacion = db.Actividades_Paquete.Any(ap =>
                    ap.Paquetes_de_viaje_IdPaquete == IDPaquete &&
                    ap.Actividades_Destino_IdActividad == IDActividad);

                if (!existeRelacion)
                {
                    db.Database.ExecuteSqlCommand(
                        "EXEC InsertActividadesPaquete @Paquetes_de_viaje_IdPaquete, @Actividades_Destino_IdActividad, @nulo",
                        new SqlParameter("@Paquetes_de_viaje_IdPaquete", IDPaquete),
                        new SqlParameter("@Actividades_Destino_IdActividad", IDActividad),
                        new SqlParameter("@nulo", (object)DBNull.Value)
                    );
                }
            }

            return RedirectToAction("ActividadesPaquete", "PaquetesDeViaje", new { idDestino = idDestino, idPaquete = IDPaquete });
        }


        [HttpPost]
        public ActionResult EliminarActividadDelPaquete(int idDestino, int IDActividad, int IDPaquete)
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                db.Database.ExecuteSqlCommand(
                    "EXEC DeleteActividadesPaquete @Paquetes_de_viaje_IdPaquete, @Actividades_Destino_IdActividad",
                    new SqlParameter("@Paquetes_de_viaje_IdPaquete", IDPaquete),
                    new SqlParameter("@Actividades_Destino_IdActividad", IDActividad)
                );
            }

            return RedirectToAction("ActividadesPaquete", "PaquetesDeViaje", new { idDestino = idDestino, idPaquete = IDPaquete });
        }
        
        public ActionResult PaquetesReservar(int idDestino, string searchBy, string search)
        {
            List<PaquetesDestinoTVM> lstPaquetes = null;
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var paquetesQuery = from p in db.Paquetes_de_viaje
                                    where p.Destinos_IdDestino == idDestino
                                    select new PaquetesDestinoTVM
                                    {
                                        IdPaquete = p.IdPaquete,
                                        Nombre_del_paquete = p.Nombre_del_paquete,
                                        Descripcion = p.Descripcion,
                                        Precio = p.Precio,
                                        Destinos_IdDestino = p.Destinos_IdDestino
                                    };

                // Filtro de búsqueda
                if (!string.IsNullOrEmpty(search))
                {
                    if (searchBy == "Nombre")
                    {
                        paquetesQuery = paquetesQuery.Where(x => x.Nombre_del_paquete.Contains(search));
                    }
                    else if (searchBy == "Descripcion")
                    {
                        paquetesQuery = paquetesQuery.Where(x => x.Descripcion.Contains(search));
                    }
                    else if (searchBy == "Precio" && decimal.TryParse(search, out var precio))
                    {
                        paquetesQuery = paquetesQuery.Where(x => x.Precio <= precio);
                    }
                }

                lstPaquetes = paquetesQuery.OrderBy(x => x.Nombre_del_paquete).ToList();
            }

            return View(lstPaquetes);
        }

        [HttpPost]
        public JsonResult Reservar(int idPaquete)
        {
            var userId = Convert.ToDecimal(Session["UserId"]);
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                // Obtener todas las actividades del paquete
                var actividadesDelPaquete = db.Actividades_Paquete
                                               .Where(ap => ap.Paquetes_de_viaje_IdPaquete == idPaquete)
                                               .Select(ap => ap.Actividades_Destino_IdActividad)
                                               .ToList();

                // Verificar si alguna actividad ya está reservada por el usuario
                var actividadesReservadas = db.Reservas
                                               .Where(r => r.Usuarios_Id == userId &&
                                                           actividadesDelPaquete.Contains(r.Actividades_Destino_IdActividad))
                                               .ToList();

                if (actividadesReservadas.Any())
                {
                    return Json(new
                    {
                        success = false,
                        message = "Ya tienes actividades de este paquete reservadas. Por favor, revisa tus reservas."
                    });
                }

            }

            return Json(new { success = true, redirectUrl = Url.Action("RealizarPagoPaquete", "Pago", new { idPaquete = idPaquete }) });
        }

        public ActionResult ActividadesReservar(int idPaquete, string searchBy, string search)
        {
            List<ActividadesPaqueteTVM> lstActividades = null;
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var actividadesQuery = from a in db.Actividades_Destino
                                       join ap in db.Actividades_Paquete on a.IdActividad equals ap.Actividades_Destino_IdActividad
                                       where ap.Paquetes_de_viaje_IdPaquete == idPaquete
                                       select new ActividadesPaqueteTVM
                                       {
                                           IdActividad = a.IdActividad,
                                           Nombre_actividad = a.Nombre,
                                           Descripcion = a.Descripcion,
                                           Precio = a.Precio,
                                           Paquetes_de_viaje_IdPaquete = ap.Paquetes_de_viaje_IdPaquete
                                       };

                // Filtro de búsqueda
                if (!string.IsNullOrEmpty(search))
                {
                    if (searchBy == "Nombre")
                    {
                        actividadesQuery = actividadesQuery.Where(x => x.Nombre_actividad.Contains(search));
                    }
                    else if (searchBy == "Descripcion")
                    {
                        actividadesQuery = actividadesQuery.Where(x => x.Descripcion.Contains(search));
                    }
                    else if (searchBy == "Precio" && decimal.TryParse(search, out var precio))
                    {
                        actividadesQuery = actividadesQuery.Where(x => x.Precio <= precio);
                    }
                }

                lstActividades = actividadesQuery.OrderBy(x => x.Nombre_actividad).ToList();
            }

            return View(lstActividades);
        }


    }
}
