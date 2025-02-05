using ParqueoULACIT.Models.ViewModel;
using ParqueoULACIT.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using ParqueoULACIT.Filters;
using ParqueoULACIT.Models.TableViewModel;

namespace ParqueoULACIT.Controllers
{
    [RolAutorizacion(4)] // Solo estudiantes
    public class EstudianteController : Controller
    {
        // GET: Estudiante
        public ActionResult Index()
        {
            var usuarioSesion = Sesion.GetSesion() as Usuario;
            try
            {
                if (usuarioSesion == null || usuarioSesion.ID_Rol != 4)
                {
                    return RedirectToAction("Index", "Login");
                }

                using (var db = new SistemaParqueoEntities())
                {
                    
                    var vehiculos = db.Vehiculo
                        .Where(v => v.ID_Usuario == usuarioSesion.ID_Usuario)
                        .Select(v => new VehiculoTableViewModel
                        {
                            ID_Vehiculo = v.ID_Vehiculo,
                            Marca = v.Marca,
                            Color = v.Color,
                            Numero_Placa = v.Numero_Placa,
                            ID_Tipo = v.ID_Tipo,
                            ID_Usuario = v.ID_Usuario,
                            Espacio_7600 = v.Espacio_7600,
                            Estado = v.Estado,
                            Tipo = db.Tipo_Vehiculo
                                .Where(t => t.ID_Tipo == v.ID_Tipo)
                                .Select(t => t.Tipo)
                                .FirstOrDefault(),
                            OcupaEspacio7600 = v.Espacio_7600 ? "Sí" : "No",
                            EstadoVehiculo = v.Estado ? "Activo" : "Inactivo"
                        })
                        .ToList(); 

                    return View(vehiculos); // Pasamos los datos a la vista
                }
            }
            catch (Exception ex)
            {
                ViewBag.ErrorMessage = "Ocurrió un error al cargar los vehículos: " + ex.Message;
                return View(new List<VehiculoTableViewModel>()); // Retornamos una lista vacía en caso de error
            }
        }


        public ActionResult HistorialEstudiante(int? mes, int? anio)
        {
            var usuarioSesion = Sesion.GetSesion() as Usuario;
            try
            {
                if (usuarioSesion == null || usuarioSesion.ID_Rol != 4)
                {
                    return RedirectToAction("Index", "Login");
                }

                using (var db = new SistemaParqueoEntities())
                {
                    var placasUsuario = db.Vehiculo
                        .Where(v => v.ID_Usuario == usuarioSesion.ID_Usuario)
                        .Select(v => v.Numero_Placa)
                        .ToList();

                    if (placasUsuario.Count == 0)
                    {
                        ViewBag.ErrorMessage = "No tienes vehículos registrados.";
                        return View(new List<HistorialEstudianteViewModel>());
                    }

                    // Generar el historial del estudiante con el parqueo
                    var bitacoras = db.Bitacora
                        .Where(b => placasUsuario.Contains(b.Numero_Placa) &&
                                    (!mes.HasValue || b.Fecha.Month == mes.Value) &&
                                    (!anio.HasValue || b.Fecha.Year == anio.Value))
                        .Join(db.Movimiento, // Unir con la tabla Movimiento
                              b => b.ID_Movimiento,
                              m => m.ID_Movimiento,
                              (b, m) => new { Bitacora = b, MovimientoNombre = m.Tipo_Movimiento })
                        .Join(db.Tipo_Vehiculo, // Unir con la tabla Tipo_Vehiculo
                              bm => bm.Bitacora.ID_Tipo,
                              t => t.ID_Tipo,
                              (bm, t) => new { bm.Bitacora, bm.MovimientoNombre, TipoNombre = t.Tipo })
                        .Join(db.Parqueo, // Unir con la tabla Parqueo
                              bmt => bmt.Bitacora.ID_Parqueo,
                              p => p.ID_Parqueo,
                              (bmt, p) => new HistorialEstudianteViewModel
                              {
                                  Fecha = bmt.Bitacora.Fecha,
                                  Hora = bmt.Bitacora.Hora,
                                  Numero_Placa = bmt.Bitacora.Numero_Placa,
                                  MovimientoNombre = bmt.MovimientoNombre,
                                  TipoNombre = bmt.TipoNombre,
                                  Parqueo = p.Nombre
                              })
                        .ToList();

                    if (bitacoras.Count == 0)
                    {
                        ViewBag.ErrorMessage = "No se encontraron registros para los filtros seleccionados.";
                    }

                    return View(bitacoras);
                }
            }
            catch (Exception ex)
            {
                ViewBag.ErrorMessage = "Ocurrió un error al procesar la solicitud: " + ex.Message;
                return View(new List<HistorialEstudianteViewModel>());
            }
        }

    }

}
       
    