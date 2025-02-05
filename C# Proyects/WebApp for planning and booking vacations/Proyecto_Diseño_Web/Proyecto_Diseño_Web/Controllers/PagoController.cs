using Proyecto_Diseño_Web.Helpers;
using Proyecto_Diseño_Web.Models;
using Proyecto_Diseño_Web.Models.TableViewModels;
using Proyecto_Diseño_Web.Models.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Proyecto_Diseño_Web.Controllers
{
    public class PagoController : Controller
    {

        [HttpGet]
        public ActionResult RealizarPago(int idActividad)
        {
            var userId = Convert.ToDecimal(Session["UserId"]);

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                // Obtener los detalles de la actividad
                var actividad = db.Actividades_Destino.SingleOrDefault(a => a.IdActividad == idActividad);

                if (actividad == null)
                {
                    return HttpNotFound();
                }

                // Obtener las tarjetas del usuario
                var tarjetas = db.Tarjetas.Where(t => t.Usuarios_Id == userId)
                                          .Select(t => new { t.IdTarjeta, t.Numero_de_tarjeta })
                                          .ToList();

                ViewBag.Tarjetas = new SelectList(tarjetas, "IdTarjeta", "Numero_de_tarjeta");

                // Crear un modelo de pago
                var modeloPago = new PagoViewModel
                {
                    IdActividad = actividad.IdActividad,
                    Actividad = actividad,
                    PrecioOriginal = actividad.Precio,
                    Descuento = db.Descuentos.SingleOrDefault(d => d.Actividades_Destino_IdActividad == actividad.IdActividad)?.Porcentaje,
                    PrecioFinal = CalcularPrecioFinal(actividad.Precio, db.Descuentos.SingleOrDefault(d => d.Actividades_Destino_IdActividad == actividad.IdActividad)?.Porcentaje),
                    Tarjetas = new SelectList(tarjetas, "IdTarjeta", "Numero_de_tarjeta") // Asignar las tarjetas al modelo como SelectList
                };

                return View(modeloPago);
            }
        }


        // POST: RealizarPago
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult RealizarPago(PagoViewModel model)
        {
            if (ModelState.IsValid)
            {
                var userId = Convert.ToDecimal(Session["UserId"]);
                using (var db = new Proyecto_Final_Diseño_WebEntities())
                {
                    // Obtener los detalles de la actividad y las tarjetas
                    var actividad = db.Actividades_Destino.SingleOrDefault(a => a.IdActividad == model.IdActividad);
                    var tarjeta = db.Tarjetas.SingleOrDefault(t => t.IdTarjeta == model.TarjetaId && t.Usuarios_Id == userId);

                    if (actividad == null || tarjeta == null)
                    {
                        return HttpNotFound();
                    }

                    // Crear una nueva reserva
                    var nuevaReserva = new Reservas
                    {
                        Fecha_de_inicio = actividad.Fecha,
                        Fecha_final = actividad.Fecha.Value.AddDays(1), // Puede ajustarse según sea necesario
                        Tipo_de_servicio = actividad.Nombre, // Esto puede ser personalizado
                        Precio = model.PrecioFinal,
                        Estado_de_la_reserva = "Confirmada", // Asumiendo que se crea con estado confirmado
                        Actividades_Destino_IdActividad = actividad.IdActividad,
                        Usuarios_Id = userId
                    };

                    var emailHelper = new EmailHelperReservacionEliminada();
                    emailHelper.EnviarCorreoDeCreacion(Session["CorreoRecuperacion"].ToString(), nuevaReserva.Tipo_de_servicio, (DateTime)nuevaReserva.Fecha_de_inicio);

                    db.Reservas.Add(nuevaReserva);
                    db.SaveChanges();

                    return RedirectToAction("Index", "Home", new { idReserva = nuevaReserva.IdReserva });
                }
                
            }

            // Si hay errores de validación, recargar la vista
            return View(model);
        }

        private decimal? CalcularPrecioFinal(decimal? precioOriginal, decimal? descuento)
        {
            if (descuento.HasValue)
            {
                return precioOriginal * (1 - (descuento.Value / 100));
            }
            return precioOriginal;
        }

        [HttpGet]
        public ActionResult RealizarPagoPaquete(int idPaquete)
        {
            var userId = Convert.ToDecimal(Session["UserId"]);

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                // Obtener las actividades asociadas al paquete
                var actividades = db.Actividades_Destino
                    .Join(db.Actividades_Paquete,
                        ad => ad.IdActividad,
                        ap => ap.Actividades_Destino_IdActividad,
                        (ad, ap) => new { ad, ap })
                    .Where(joined => joined.ap.Paquetes_de_viaje_IdPaquete == idPaquete)
                    .Select(joined => new ActividadesDestinoTVM
                    {
                        IdActividad = joined.ad.IdActividad,
                        Nombre = joined.ad.Nombre,
                        Precio = joined.ad.Precio ?? 0, // Manejar nulos
                        Fecha = joined.ad.Fecha
                    })
                    .ToList(); // Materializar en memoria

                if (!actividades.Any())
                {
                    return HttpNotFound("No se encontraron actividades para este paquete.");
                }

                // Obtener los descuentos aplicables
                var idsActividades = actividades.Select(a => a.IdActividad).ToList(); // IDs de las actividades
                var descuentos = db.Descuentos
                    .Where(d => idsActividades.Contains(d.Actividades_Destino_IdActividad))
                    .ToList(); // Materializar en memoria

                // Calcular precio total y descuentos
                var precioTotalOriginal = actividades.Sum(a => a.Precio);
                var porcentajeDescuento = descuentos.Sum(d => d.Porcentaje ?? 0); // Manejar nulos
                var precioTotalFinal = actividades.Sum(a =>
                    CalcularPrecioFinal(a.Precio, descuentos.FirstOrDefault(d => d.Actividades_Destino_IdActividad == a.IdActividad)?.Porcentaje));

                var tarjetas = db.Tarjetas
                    .Where(t => t.Usuarios_Id == userId)
                    .Select(t => new { t.IdTarjeta, t.Numero_de_tarjeta })
                    .ToList(); // Materializar en memoria

                ViewBag.Tarjetas = new SelectList(tarjetas, "IdTarjeta", "Numero_de_tarjeta");

                // Crear el modelo
                var modeloPago = new PagoPaqueteViewModel
                {
                    IdPaquete = idPaquete,
                    Actividades = actividades,
                    PrecioTotalOriginal = precioTotalOriginal,
                    Descuento = porcentajeDescuento,
                    PrecioTotalFinal = precioTotalFinal,
                    Tarjetas = new SelectList(tarjetas, "IdTarjeta", "Numero_de_tarjeta") // Asignar las tarjetas al modelo como SelectList
                };

                return View(modeloPago);
            }
        }

        // POST: RealizarPago
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult RealizarPagoPaquete(PagoPaqueteViewModel model)
        {
            if (ModelState.IsValid)
            {
                var userId = Convert.ToDecimal(Session["UserId"]);
                using (var db = new Proyecto_Final_Diseño_WebEntities())
                {
                    // Obtener las actividades asociadas al paquete
                    var actividades = db.Actividades_Paquete
                        .Where(ap => ap.Paquetes_de_viaje_IdPaquete == model.IdPaquete)
                        .Select(ap => ap.Actividades_Destino)
                        .ToList();

                    var tarjeta = db.Tarjetas.SingleOrDefault(t => t.IdTarjeta == model.TarjetaId && t.Usuarios_Id == userId);

                    if (!actividades.Any() || tarjeta == null)
                    {
                        return HttpNotFound("No se encontraron actividades o tarjeta no válida.");
                    }

                    // Crear una reserva para cada actividad
                    foreach (var actividad in actividades)
                    {
                        var nuevaReserva = new Reservas
                        {
                            Fecha_de_inicio = actividad.Fecha,
                            Fecha_final = actividad.Fecha.Value.AddDays(1),
                            Tipo_de_servicio = actividad.Nombre,
                            Precio = CalcularPrecioFinal(actividad.Precio, db.Descuentos.SingleOrDefault(d => d.Actividades_Destino_IdActividad == actividad.IdActividad)?.Porcentaje),
                            Estado_de_la_reserva = "Confirmada",
                            Actividades_Destino_IdActividad = actividad.IdActividad,
                            Usuarios_Id = userId
                        };

                        var emailHelper = new EmailHelperReservacionEliminada();
                        emailHelper.EnviarCorreoDeCreacion(Session["CorreoRecuperacion"].ToString(), nuevaReserva.Tipo_de_servicio, (DateTime)nuevaReserva.Fecha_de_inicio);

                        db.Reservas.Add(nuevaReserva);
                    }

                    db.SaveChanges();



                    return RedirectToAction("Index", "Home");
                }
            }

            return View(model);
        }


        // GET: Crear Tarjeta
        [HttpGet]
        public ActionResult CrearTarjeta(int idActividad)
        {
            ViewBag.IdActividad = idActividad;
            return View();
        }

        // POST: Crear tarjeta
        [HttpPost]
        public ActionResult CrearTarjeta(FormCollection form, int idActividad)
        {
            // Obtener los datos del formulario
            var numeroTarjeta = form["Numero_de_tarjeta"];
            var fechaVencimiento = form["Fecha_de_vencimiento"];
            var codigoSeguridad = form["Codigo_de_seguridad"];

            //var userId = Convert.ToDecimal(Session["UserId"]);
            var userId = Convert.ToDecimal(Session["UserId"]);

            // Validación básica
            if (string.IsNullOrEmpty(numeroTarjeta) || string.IsNullOrEmpty(fechaVencimiento) || string.IsNullOrEmpty(codigoSeguridad))
            {
                ModelState.AddModelError("", "Todos los campos son requeridos.");
                return View();
            }

            // Validación de longitud para el número de tarjeta y el código de seguridad
            if (numeroTarjeta.Length != 16)
            {
                ModelState.AddModelError("Numero_de_tarjeta", "El número de tarjeta debe tener 16 dígitos.");
            }

            if (codigoSeguridad.Length != 3)
            {
                ModelState.AddModelError("Codigo_de_seguridad", "El código de seguridad debe tener 3 dígitos.");
            }

            // Si hay errores en la validación, devolver la vista con los mensajes de error
            if (!ModelState.IsValid)
            {
                return View();
            }

            // Si la validación es correcta, proceder a guardar la tarjeta
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var nuevaTarjeta = new Tarjetas
                {
                    Numero_de_tarjeta = Convert.ToDecimal(numeroTarjeta),
                    Fecha_de_vencimiento = Convert.ToDateTime(fechaVencimiento),
                    Codigo_de_seguridad = Convert.ToDecimal(codigoSeguridad),
                    Usuarios_Id = userId
                };

                db.Tarjetas.Add(nuevaTarjeta);
                db.SaveChanges();
            }

            return RedirectToAction("RealizarPago", "Pago", new { idActividad = idActividad });
        }

        // GET: Crear Tarjeta
        [HttpGet]
        public ActionResult CrearTarjetaPaquete(int idPaquete)
        {
            ViewBag.IdPaquete = idPaquete;
            return View();
        }

        // POST: Crear tarjeta
        [HttpPost]
        public ActionResult CrearTarjetaPaquete(FormCollection form, int idPaquete)
        {
            // Obtener los datos del formulario
            var numeroTarjeta = form["Numero_de_tarjeta"];
            var fechaVencimiento = form["Fecha_de_vencimiento"];
            var codigoSeguridad = form["Codigo_de_seguridad"];

            //var userId = Convert.ToDecimal(Session["UserId"]);
            var userId = Convert.ToDecimal(Session["UserId"]);

            // Validación básica
            if (string.IsNullOrEmpty(numeroTarjeta) || string.IsNullOrEmpty(fechaVencimiento) || string.IsNullOrEmpty(codigoSeguridad))
            {
                ModelState.AddModelError("", "Todos los campos son requeridos.");
                return View();
            }

            // Validación de longitud para el número de tarjeta y el código de seguridad
            if (numeroTarjeta.Length != 16)
            {
                ModelState.AddModelError("Numero_de_tarjeta", "El número de tarjeta debe tener 16 dígitos.");
            }

            if (codigoSeguridad.Length != 3)
            {
                ModelState.AddModelError("Codigo_de_seguridad", "El código de seguridad debe tener 3 dígitos.");
            }

            // Si hay errores en la validación, devolver la vista con los mensajes de error
            if (!ModelState.IsValid)
            {
                return View();
            }

            // Si la validación es correcta, proceder a guardar la tarjeta
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var nuevaTarjeta = new Tarjetas
                {
                    Numero_de_tarjeta = Convert.ToDecimal(numeroTarjeta),
                    Fecha_de_vencimiento = Convert.ToDateTime(fechaVencimiento),
                    Codigo_de_seguridad = Convert.ToDecimal(codigoSeguridad),
                    Usuarios_Id = userId
                };

                db.Tarjetas.Add(nuevaTarjeta);
                db.SaveChanges();
            }

            return RedirectToAction("RealizarPagoPaquete", "Pago", new { idPaquete = idPaquete });
        }


        [HttpGet]
        public ActionResult ListarTarjetasPaquete(int idPaquete)
        {
            // Obtener el UserId desde la sesión
            var userId = Convert.ToDecimal(Session["UserId"]);
            List<TarjetasTVM> tarjetas;

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                // Obtener las tarjetas del usuario y mapearlas al modelo TarjetasTVM
                tarjetas = db.Tarjetas
                    .Where(t => t.Usuarios_Id == userId)
                    .Select(t => new TarjetasTVM
                    {
                        IdTarjeta = t.IdTarjeta,
                        Numero_de_tarjeta = t.Numero_de_tarjeta,
                        Fecha_de_vencimiento = t.Fecha_de_vencimiento,
                        Codigo_de_seguridad = t.Codigo_de_seguridad,
                        Usuarios_Id = t.Usuarios_Id
                    })
                    .ToList();
            }

            // Pasar las tarjetas y el idPaquete a la vista
            ViewBag.IdPaquete = idPaquete;
            return View(tarjetas);
        }

        // POST: Eliminar tarjeta
        [HttpPost]
        public ActionResult EliminarTarjetaPaquete(decimal idTarjeta, int idPaquete)
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var tarjeta = db.Tarjetas.FirstOrDefault(t => t.IdTarjeta == idTarjeta);

                if (tarjeta != null)
                {
                    db.Tarjetas.Remove(tarjeta);
                    db.SaveChanges();
                    TempData["Success"] = "La tarjeta se eliminó correctamente.";
                }
                else
                {
                    TempData["Error"] = "La tarjeta no existe o ya fue eliminada.";
                }
            }

            // Redirigir nuevamente a la lista de tarjetas con el idPaquete
            return RedirectToAction("ListarTarjetasPaquete", new { idPaquete });
        }
    }

}

