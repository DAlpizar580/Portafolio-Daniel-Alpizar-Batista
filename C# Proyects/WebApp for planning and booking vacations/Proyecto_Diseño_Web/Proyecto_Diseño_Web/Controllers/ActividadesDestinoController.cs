using Proyecto_Diseño_Web.Models.TableViewModels;
using Proyecto_Diseño_Web.Models.ViewModels;
using Proyecto_Diseño_Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data;
using System.IO;
using System.Collections;

namespace Proyecto_Diseño_Web.Controllers
{
    public class ActividadesDestinoController : Controller
    {
        // GET: ActividadesDestino
        public ActionResult Index(int idDestino, string searchBy, string search)
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

                // Aplicar el filtro de búsqueda
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
                lstActividades = actividadesQuery.OrderBy(x => x.Nombre).ToList();
            }
            if(lstActividades == null || lstActividades.Count == 0)
            {
                return RedirectToAction("Crear", "ActividadesDestino", new { idDestino = idDestino });
            }
            return View(lstActividades);
        }

        [HttpGet]
        public ActionResult Edit(int id)
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var actividad = db.Actividades_Destino
                                  .Where(a => a.IdActividad == id)
                                  .Select(a => new ActividadesDestinoTVM
                                  {
                                      IdActividad = a.IdActividad,
                                      Nombre = a.Nombre,
                                      Descripcion = a.Descripcion,
                                      Precio = a.Precio,
                                      Destinos_IdDestino = a.Destinos_IdDestino,
                                      Fecha = a.Fecha,
                                      Descuento = db.Descuentos
                                                    .Where(d => d.Actividades_Destino_IdActividad == a.IdActividad)
                                                    .Select(d => d.Porcentaje)
                                                    .FirstOrDefault()
                                  }).SingleOrDefault();

                if (actividad == null)
                {
                    return HttpNotFound();
                }

                return View(actividad);
            }
        }

        [HttpPost]
        public ActionResult Edit(ActividadesDestinoTVM model, HttpPostedFileBase NewImage)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var actividad = db.Actividades_Destino.Find(model.IdActividad);
                if (actividad != null)
                {
                    actividad.Nombre = model.Nombre;
                    actividad.Descripcion = model.Descripcion;
                    actividad.Precio = model.Precio;
                    actividad.Fecha = model.Fecha;

                    var descuento = db.Descuentos
                                      .FirstOrDefault(d => d.Actividades_Destino_IdActividad == model.IdActividad);
                    if (descuento != null)
                    {
                        descuento.Porcentaje = model.Descuento ?? 0;
                    }
                    else if (model.Descuento.HasValue)
                    {
                        db.Descuentos.Add(new Descuentos
                        {
                            Actividades_Destino_IdActividad = model.IdActividad,
                            Porcentaje = model.Descuento.Value
                        });
                    }

                    db.Entry(actividad).State = EntityState.Modified;
                    db.SaveChanges();
                }
                else
                {
                    ModelState.AddModelError("", "Actividad no encontrada.");
                    return View(model);
                }
            }

            return RedirectToAction("Index", "ActividadesDestino", new { idDestino = model.Destinos_IdDestino });
        }


        private byte[] ConvertToBytes(HttpPostedFileBase file)
        {
            using (var stream = file.InputStream)
            {
                var binaryReader = new BinaryReader(stream);
                return binaryReader.ReadBytes(file.ContentLength);
            }
        }

        // GET: Create
        [HttpGet]
        public ActionResult Crear(int idDestino)
        {
            var model = new ActividadesDestinoTVM
            {
                Destinos_IdDestino = idDestino
            };

            return View(model);
        }

        // POST: Create
        [HttpPost]
        public ActionResult Crear(ActividadesDestinoTVM model, HttpPostedFileBase NewImage)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }
            List<ActividadesDestinoTVM> lstActividades = null;
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var nuevaActividad = new Actividades_Destino
                {
                    Nombre = model.Nombre,
                    Descripcion = model.Descripcion,
                    Precio = model.Precio,
                    Fecha = model.Fecha,
                    Destinos_IdDestino = model.Destinos_IdDestino,
                };

                db.Actividades_Destino.Add(nuevaActividad);
                db.SaveChanges();

                var actividadesQuery = from a in db.Actividades_Destino
                                       where a.Destinos_IdDestino == model.Destinos_IdDestino
                                       select new ActividadesDestinoTVM
                                       {
                                           IdActividad = a.IdActividad,
                                           Nombre = a.Nombre,
                                           Descripcion = a.Descripcion,
                                           Fecha = a.Fecha,
                                           Precio = a.Precio,
                                           Destinos_IdDestino = a.Destinos_IdDestino
                                       };
                lstActividades = actividadesQuery.ToList();

                decimal idActividad = lstActividades.Last().IdActividad;

                var descuento = new Descuentos
                {
                    Porcentaje = 0,
                    Actividades_Destino_IdActividad = idActividad
                };

                db.Descuentos.Add(descuento);

                db.SaveChanges();
            }

            return RedirectToAction("Index", "ActividadesDestino", new { idDestino = model.Destinos_IdDestino });
        }

        [HttpPost, ActionName("Delete")]
        public ActionResult Delete(int id)
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var actividad = db.Actividades_Destino.Find(id);
                var descuento = db.Descuentos
                                      .FirstOrDefault(d => d.Actividades_Destino_IdActividad == id);
                if (actividad == null)
                {
                    return HttpNotFound();
                }

                db.Descuentos.Remove(descuento);
                db.SaveChanges();
                db.Actividades_Destino.Remove(actividad);
                db.SaveChanges();

                return RedirectToAction("Index", "ActividadesDestino", new { idDestino = actividad.Destinos_IdDestino });
            }
        }

        public ActionResult ActividadesReservar(int idDestino, string searchBy, string search)
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

                // Filtro de búsqueda
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
        public JsonResult Reservar(int idActividad)
        {
            var userId = Convert.ToDecimal(Session["UserId"]);
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                // Verificar si ya existe la reserva
                var reservaExistente = db.Reservas
                                         .FirstOrDefault(r => r.Usuarios_Id == userId &&
                                                              r.Actividades_Destino_IdActividad == idActividad);

                if (reservaExistente != null)
                {
                    return Json(new { success = false, message = "Ya has reservado esta actividad." });
                }
            }

            return Json(new { success = true, redirectUrl = Url.Action("RealizarPago", "Pago", new { idActividad = idActividad}) });
        }
    }
}

