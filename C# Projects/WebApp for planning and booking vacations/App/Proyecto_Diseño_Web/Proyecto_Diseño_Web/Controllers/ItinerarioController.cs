using Proyecto_Diseño_Web.Models;
using Proyecto_Diseño_Web.Models.TableViewModels;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Proyecto_Diseño_Web.Controllers
{
    public class ItinerarioController : Controller
    {

        public ActionResult Index()
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var userId = Convert.ToDecimal(Session["UserId"]);

                var actividadesUsuario = (from ai in db.Actividades_Itinerario
                                          join ad in db.Actividades_Destino on ai.Actividades_Destino_IdActividad equals ad.IdActividad
                                          join d in db.Destinos on ai.Destinos_IdDestino equals d.IdDestino
                                          join i in db.Itinerarios on ai.Itinerarios_IdItinerario equals i.IdItinerario
                                          where i.Usuarios_Id == userId
                                          select new
                                          {
                                              ai.Descripcion,
                                              ai.Fecha_actividad,
                                              DestinoNombre = d.Nombre,
                                              ActividadNombre = ad.Nombre,
                                              ai.Itinerarios_IdItinerario,
                                              ai.Actividades_Destino_IdActividad,
                                              ai.Destinos_IdDestino
                                          }).ToList(); 

                var viewModel = actividadesUsuario.Select(ai => new Proyecto_Diseño_Web.Models.TableViewModels.ActividadesItinerarioTVM
                {
                    Descripcion = ai.Descripcion,
                    FechaActividad = ai.Fecha_actividad,
                    DestinoNombre = ai.DestinoNombre,
                    ActividadNombre = ai.ActividadNombre,
                    ItinerarioId = ai.Itinerarios_IdItinerario,
                    ActividadId = ai.Actividades_Destino_IdActividad,
                    DestinoId = ai.Destinos_IdDestino
                }).ToList();

                return View(viewModel);
            }


        }

        public ActionResult Destinos(string searchBy, string search)
        {
            List<DestinosTVM> lstDestinos = null;
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var destinosQuery = from d in db.Destinos
                                    select new DestinosTVM
                                    {
                                        IdDestino = d.IdDestino,
                                        Nombre = d.Nombre,
                                        Provincia = d.Provincia,
                                        Categoria = d.Categoria,
                                        Precio_Minimo = d.Precio_Minimo,
                                        Precio_Maximo = d.Precio_Maximo,
                                        Descripcion = d.Descripcion,
                                        Direccion = d.Direccion,
                                        Imagen = d.Imagen
                                    };

                // Aplicar el filtro de búsqueda
                if (!string.IsNullOrEmpty(search))
                {
                    if (searchBy == "Nombre")
                    {
                        destinosQuery = destinosQuery.Where(x => x.Nombre.Contains(search));
                    }
                    else if (searchBy == "Provincia")
                    {
                        destinosQuery = destinosQuery.Where(x => x.Provincia.Contains(search));
                    }
                    else if (searchBy == "Categoria")
                    {
                        destinosQuery = destinosQuery.Where(x => x.Categoria.Contains(search));
                    }
                    else if (searchBy == "Precio_Minimo")
                    {
                        if (decimal.TryParse(search, out var precioMin))
                        {
                            destinosQuery = destinosQuery.Where(x => x.Precio_Minimo >= precioMin);
                        }
                    }
                    else if (searchBy == "Precio_Maximo")
                    {
                        if (decimal.TryParse(search, out var precioMax))
                        {
                            destinosQuery = destinosQuery.Where(x => x.Precio_Maximo <= precioMax);
                        }
                    }
                }
                lstDestinos = destinosQuery.OrderBy(x => x.Nombre).ToList();
            }

            return View(lstDestinos);
        }

        public ActionResult ActividadesItinerario(int idDestino, string searchBy, string search)
        {
            List<ActividadesDestinoTVM> lstActividades = null;
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
                    else if (searchBy == "Fecha" && DateTime.TryParse(search, out var fecha))
                    {
                        actividadesQuery = actividadesQuery.Where(x => x.Fecha == fecha);
                    }
                    else if (searchBy == "Precio" && decimal.TryParse(search, out var precio))
                    {
                        actividadesQuery = actividadesQuery.Where(x => x.Precio <= precio);
                    }
                }

                lstActividades = actividadesQuery.OrderBy(x => x.Nombre).ToList();
            }

            return View(lstActividades);
        }

        [HttpPost]
        public JsonResult AgregarItinerario(int idActividad)
        {
            var userId = Convert.ToDecimal(Session["UserId"]);

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var itinerario = db.Itinerarios.FirstOrDefault(i => i.Usuarios_Id == userId);

                if (itinerario == null)
                {
                    return Json(new { success = false, message = "No tienes un itinerario asignado." });
                }

                var actividadExistente = db.Actividades_Itinerario
                                           .FirstOrDefault(ai => ai.Itinerarios_IdItinerario == itinerario.IdItinerario &&
                                                                 ai.Actividades_Destino_IdActividad == idActividad);

                if (actividadExistente != null)
                {
                    return Json(new { success = false, message = "Esta actividad ya está en tu itinerario." });
                }

                var actividad = db.Actividades_Destino.FirstOrDefault(a => a.IdActividad == idActividad);

                if (actividad == null)
                {
                    return Json(new { success = false, message = "Actividad no encontrada." });
                }

                db.Database.ExecuteSqlCommand(
                    "EXEC InsertActividadesItinerario @Descripcion, @Fecha_actividad, @Destinos_IdDestino, @Actividades_Destino_IdActividad, @Itinerarios_IdItinerario",
                    new SqlParameter("@Descripcion", actividad.Descripcion ?? (object)DBNull.Value),
                    new SqlParameter("@Fecha_actividad", actividad.Fecha ?? (object)DBNull.Value),
                    new SqlParameter("@Destinos_IdDestino", actividad.Destinos_IdDestino),
                    new SqlParameter("@Actividades_Destino_IdActividad", idActividad),
                    new SqlParameter("@Itinerarios_IdItinerario", itinerario.IdItinerario)
                );

                return Json(new { success = true, redirectUrl = Url.Action("Index", "Itinerario") });
            }
        }

        [HttpPost]
        public JsonResult Delete(int id, int idActividad, int idDestino)
        {
            var userId = Convert.ToDecimal(Session["UserId"]);

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var itinerario = db.Itinerarios.FirstOrDefault(i => i.Usuarios_Id == userId);

                if (itinerario == null)
                {
                    return Json(new { success = false, message = "No tienes un itinerario asignado." });
                }

                db.Database.ExecuteSqlCommand(
                    "EXEC DeleteActividadesItinerario @Destinos_IdDestino, @Actividades_Destino_IdActividad, @Itinerarios_IdItinerario",
                    new SqlParameter("@Destinos_IdDestino", idDestino),
                    new SqlParameter("@Actividades_Destino_IdActividad", idActividad),
                    new SqlParameter("@Itinerarios_IdItinerario", id)
                );

                return Json(new { success = true, message = "Actividad eliminada del itinerario con éxito." });
            }
        }

    }
}
