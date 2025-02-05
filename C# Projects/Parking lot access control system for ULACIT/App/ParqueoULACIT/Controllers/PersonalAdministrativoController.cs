using ParqueoULACIT.Models.TableViewModel;
using ParqueoULACIT.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using ParqueoULACIT.Filters;
using ParqueoULACIT.Models.ViewModel;

namespace ParqueoULACIT.Controllers
{
    [RolAutorizacion(3)] // Solo personal administrativo
    public class PersonalAdministrativoController : Controller
    {
        public ActionResult Index()
        {
            var usuarioSesion = Sesion.GetSesion() as Usuario;
            try
            {
                if (usuarioSesion == null || usuarioSesion.ID_Rol != 3)
                {
                    return RedirectToAction("Index", "Login");
                }

                using (var db = new SistemaParqueoEntities())
                {
                    // Obtener vehículos asociados al usuario administrativo
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

        private List<ParqueoTableViewModel> ObtenerParqueos()
        {
            List<ParqueoTableViewModel> parqueos = null;

            using (var db = new SistemaParqueoEntities())
            {
                parqueos = db.Parqueo
                    .Select(p => new ParqueoTableViewModel
                    {
                        ID_Parqueo = p.ID_Parqueo,
                        Nombre = p.Nombre
                    })
                    .ToList();
            }

       
            if (parqueos == null || parqueos.Count == 0)
            {
           
                parqueos = new List<ParqueoTableViewModel>();
            }

            return parqueos;
        }


        public List<BitacoraTableViewModel> ObtenerBitacora()
        {
            List<BitacoraTableViewModel> lstBitacoras = null;

            using (var db = new SistemaParqueoEntities()) 
            {
                lstBitacoras = (from b in db.Bitacora 
                                select new BitacoraTableViewModel
                                {
                                    ID_Bitacora = b.ID_Bitacora,
                                    Fecha = b.Fecha,
                                    Hora = b.Hora,
                                    Numero_Placa = b.Numero_Placa,
                                    ID_Movimiento = b.ID_Movimiento,
                                    ID_Parqueo = b.ID_Parqueo,
                                    ID_Tipo = b.ID_Tipo
                                }).ToList();
            }

            return lstBitacoras;
        }

        public ActionResult HistorialAdmin(int? mes, int? anio, int? idParqueo)
        {
            var usuarioSesion = Sesion.GetSesion() as Usuario;
            try
            {
                if (usuarioSesion == null || usuarioSesion.ID_Rol != 3) // Verificar si es personal administrativo
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

                    // Consultar las bitácoras con filtros opcionales
                    var bitacoras = db.Bitacora
                       .Where(b => placasUsuario.Contains(b.Numero_Placa) &&
                                    (!mes.HasValue || b.Fecha.Month == mes.Value) &&
                                    (!anio.HasValue || b.Fecha.Year == anio.Value) &&
                                    (!idParqueo.HasValue || b.ID_Parqueo == idParqueo.Value))
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

                    // Guardar los filtros seleccionados en ViewBag
                    ViewBag.MesSeleccionado = mes ?? DateTime.Now.Month;
                    ViewBag.AnioSeleccionado = anio ?? DateTime.Now.Year;
                    ViewBag.IdParqueoSeleccionado = idParqueo;

                    // Cargar la lista de parqueos
                    var parqueos = db.Parqueo
                        .Select(p => new ParqueoTableViewModel
                        {
                            ID_Parqueo = p.ID_Parqueo,
                            Nombre = p.Nombre
                        })
                        .ToList();

                    ViewBag.Parqueos = parqueos;

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