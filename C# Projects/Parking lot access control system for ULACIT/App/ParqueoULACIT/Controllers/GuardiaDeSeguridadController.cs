using ParqueoULACIT.Filters;
using ParqueoULACIT.Models;
using ParqueoULACIT.Models.TableViewModel;
using System;
using System.Collections.Generic;
using System.Data.Entity.Infrastructure;
using System.Data.Entity.Validation;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ParqueoULACIT.Controllers
{
    [RolAutorizacion(2)] // Solo guardas
    public class GuardiaDeSeguridadController : Controller
    {
        // GET: GuardiaDeSeguridad
        public ActionResult Index()
        {
            MostrarTipoVehiculo();
            return View();
        }

        public ActionResult MostrarTipoVehiculo()
        {
            try
            {
                using (var db = new SistemaParqueoEntities())
                {
                    var TipoVehiculo = db.Tipo_Vehiculo
                                         .Select(tv => new { tv.ID_Tipo, tv.Tipo })
                                         .ToList();
                    if (TipoVehiculo.Any())
                    {
                        ViewBag.TipoVehiculo = new SelectList(TipoVehiculo, "ID_Tipo", "Tipo");
                    }
                    else
                    {
                        ViewBag.TipoVehiculo = new SelectList(new List<SelectListItem>());
                    }
                }
                return View("Index");
            }
            catch
            {
                ViewBag.ErrorMessage = $"Debes elegir un tipo de vehiculo";
                return View("Index");
            }
        }

        [HttpPost]
        public ActionResult VerificarEntrada(string placa, int IdTipoVehiculo)
        {
            MostrarTipoVehiculo();

            using (var db = new SistemaParqueoEntities())
            {
                var parqueo = Sesion.GetParqueo() as Parqueo;

                int entradasCarro = 0, entradasMoto = 0, entradas7600 = 0;
                int salidasCarro = 0, salidasMoto = 0, salidas7600 = 0;

                var lstEntradas = db.Bitacora
                                    .Where(b => b.ID_Parqueo == parqueo.ID_Parqueo
                                             && (b.ID_Movimiento == 1 || b.ID_Movimiento == 3))
                                    .ToList();

                var lstSalidas = db.Bitacora
                                   .Where(b => b.ID_Parqueo == parqueo.ID_Parqueo && b.ID_Movimiento == 2)
                                   .ToList();

                foreach (var entrada in lstEntradas)
                {
                    // Verificar si el vehículo ocupa espacio 7600 
                    if (db.Vehiculo.Any(v => v.Numero_Placa == entrada.Numero_Placa
                                             && v.ID_Tipo == entrada.ID_Tipo
                                             && v.Espacio_7600))
                    {
                        entradas7600++;
                    }
                    else
                    {
                        // Incrementar según el tipo de vehículo
                        if (entrada.ID_Tipo == 1)
                        {
                            entradasCarro++;
                        }
                        else
                        {
                            entradasMoto++;
                        }
                    }
                }

                foreach (var salida in lstSalidas)
                {
                    // Verificar si el vehículo ocupa espacio 7600 
                    if (db.Vehiculo.Any(v => v.Numero_Placa == salida.Numero_Placa
                                             && v.ID_Tipo == salida.ID_Tipo
                                             && v.Espacio_7600))
                    {
                        salidas7600++; 
                    }
                    else
                    {
                        // Incrementar según el tipo de vehículo
                        if (salida.ID_Tipo == 1)
                        {
                            salidasCarro++;
                        }
                        else
                        {
                            salidasMoto++;
                        }
                    }
                }

                int ocupadosCarro = entradasCarro - salidasCarro;
                int ocupadosMoto = entradasMoto - salidasMoto;
                int ocupados7600 = entradas7600 - salidas7600;

                bool vehiculoRegistrado = db.Vehiculo.Any(v => v.Numero_Placa == placa && v.ID_Tipo == IdTipoVehiculo);
                bool hayEspacio = false;

                if (vehiculoRegistrado)
                {
                    // Si está registrado, verificar si ocupa espacio 7600
                    bool ocupaEspacio7600 = db.Vehiculo.Any(v => v.Numero_Placa == placa && v.ID_Tipo == IdTipoVehiculo && v.Espacio_7600);

                    if (ocupaEspacio7600)
                    {
                        // Validar espacio 7600
                        hayEspacio = ocupados7600 < parqueo.Capacidad_Espacios_7600;
                    }
                    else
                    {
                        // Validar espacio para carros o motos según tipo
                        hayEspacio = (IdTipoVehiculo == 1 && ocupadosCarro < parqueo.Capacidad_Espacios_Regulares) ||
                                     (IdTipoVehiculo == 2 && ocupadosMoto < parqueo.Capacidad_Espacios_Moto);
                    }
                }
                else
                {
                    // Si no está registrado, validar directamente según tipo
                    hayEspacio = (IdTipoVehiculo == 1 && ocupadosCarro < parqueo.Capacidad_Espacios_Regulares) ||
                                 (IdTipoVehiculo == 2 && ocupadosMoto < parqueo.Capacidad_Espacios_Moto);
                }

                var verificarEntrada = db.Bitacora
                                            .Where(b => b.Numero_Placa == placa
                                                        && (b.ID_Movimiento == 1 || b.ID_Movimiento == 2 || b.ID_Movimiento == 3)
                                                        && b.ID_Tipo == IdTipoVehiculo)
                                            .OrderByDescending(b => b.Fecha)
                                            .ThenByDescending(b => b.Hora)
                                            .FirstOrDefault();

                Bitacora registro = new Bitacora
                {
                    Fecha = DateTime.Now.Date,
                    Hora = DateTime.Now.TimeOfDay,
                    Numero_Placa = placa,
                    ID_Parqueo = parqueo.ID_Parqueo,
                    ID_Tipo = IdTipoVehiculo
                };

                if (verificarEntrada == null || verificarEntrada.ID_Movimiento == 2 )
                {
                    if (hayEspacio)
                    {
                        if (vehiculoRegistrado)
                        {
                            ViewBag.Mensaje = "Puede ingresar";
                            registro.ID_Movimiento = 1; // Ingreso exitoso
                        }
                        else
                        {
                            var ingresoTemporal = db.Bitacora
                                                    .Any(b => b.Numero_Placa == placa && b.ID_Tipo == IdTipoVehiculo && b.ID_Movimiento == 3);

                            if (!ingresoTemporal)
                            {
                                ViewBag.Mensaje = "Puede ingresar (Ingreso Temporal primer vez)";
                                registro.ID_Movimiento = 3; // Ingreso temporal
                            }
                            else
                            {
                                ViewBag.Mensaje = "No puede ingresar (vehículo no registrado y ya ha ingresado temporalmente anteriormente)";
                                registro.ID_Movimiento = 5; // Intento fallido - vehículo no registrado
                            }
                        }
                    }
                    else
                    {
                        ViewBag.Mensaje = "No puede ingresar (parqueo lleno)";
                        registro.ID_Movimiento = 4; // Intento fallido - parqueo lleno
                    }
                }
                else if (verificarEntrada.ID_Movimiento == 1 || verificarEntrada.ID_Movimiento == 3)
                {
                    ViewBag.Mensaje = "Este vehiculo ya se encuentra dentro del parqueo";
                    return View("Index");
                }

                db.Bitacora.Add(registro);
                db.SaveChanges();

                return View("Index");
            }
        }

        public ActionResult RegistrarSalida()
        {
            return View();
        }

        [HttpPost]
        public ActionResult RegistrarSalida(string placa, int tipo)
        {
            try
            {
                using (var db = new SistemaParqueoEntities())
                {
                    var parqueo = Sesion.GetParqueo() as Parqueo;

                    var vehiculoEntrada = db.Bitacora
                                            .Where(b => b.Numero_Placa == placa 
                                                        && (b.ID_Movimiento == 1 || b.ID_Movimiento == 3)
                                                        && b.ID_Tipo == tipo)
                                            .OrderByDescending(b => b.Fecha)
                                            .ThenByDescending(b => b.Hora)
                                            .FirstOrDefault();

                    if (vehiculoEntrada != null)
                    {
                        bool salidaYaRegistrada = db.Bitacora
                                                     .Any(b => b.Numero_Placa == placa 
                                                               && b.ID_Movimiento == 2
                                                               && b.ID_Tipo == tipo
                                                               && b.Fecha >= vehiculoEntrada.Fecha
                                                               && b.Hora >= vehiculoEntrada.Hora);

                        if (!salidaYaRegistrada)
                        {
                            if(vehiculoEntrada.ID_Parqueo == parqueo.ID_Parqueo)
                            {
                                Bitacora salida = new Bitacora
                                {
                                    Fecha = DateTime.Now.Date,
                                    Hora = DateTime.Now.TimeOfDay,
                                    Numero_Placa = placa,
                                    ID_Movimiento = 2, // Salida exitosa
                                    ID_Parqueo = parqueo.ID_Parqueo,
                                    ID_Tipo = tipo
                                };

                                db.Bitacora.Add(salida);
                                db.SaveChanges();

                                ViewBag.Mensaje = "Salida registrada exitosamente.";
                            }
                            else
                            {
                                var nombreParqueoEntrada = db.Parqueo
                                                      .Where(p => p.ID_Parqueo == vehiculoEntrada.ID_Parqueo)
                                                      .Select(p => p.Nombre)
                                                      .FirstOrDefault();

                                var nombreParqueoActual = db.Parqueo
                                                            .Where(p => p.ID_Parqueo == parqueo.ID_Parqueo)
                                                            .Select(p => p.Nombre)
                                                            .FirstOrDefault();

                                ViewBag.Mensaje = $"El vehículo se encuentra dentro del parqueo '{nombreParqueoEntrada}' y no puede ser retirado desde el parqueo actual '{nombreParqueoActual}'. Por favor diríjase al parqueo correspondiente para realizar la salida.";
                            }                            
                        }
                        else
                        {
                            ViewBag.Mensaje = "El vehículo no se encuentra dentro del parqueo.";
                        }
                    }
                    else
                    {
                        ViewBag.Mensaje = "No se encontró un registro de entrada para el vehículo con esa placa y tipo.";
                    }
                }
            }
            catch (Exception ex)
            {
                ViewBag.Mensaje = "Ocurrió un error inesperado: " + ex.Message;
            }

            return View("RegistrarSalida");
        }

        public ActionResult OcuapacionDeParqueos()
        {
            List<Ocupacion> Ocupaciones = new List<Ocupacion>();
            Ocupacion parqueoActualOcupacion = null;

            using (var db = new SistemaParqueoEntities())
            {
                var parqueoActual = Sesion.GetParqueo() as Parqueo;

                var parqueos = db.Parqueo.ToList();
                
                foreach (var parqueo in parqueos)
                {
                    int entradasCarro = 0, entradasMoto = 0, entradas7600 = 0;
                    int salidasCarro = 0, salidasMoto = 0, salidas7600 = 0;

                    var lstEntradas = db.Bitacora
                               .Where(b => b.ID_Parqueo == parqueo.ID_Parqueo
                                        && (b.ID_Movimiento == 1 || b.ID_Movimiento == 3))
                               .ToList();

                    var lstSalidas = db.Bitacora
                               .Where(b => b.ID_Parqueo == parqueo.ID_Parqueo
                                        && b.ID_Movimiento == 2)
                               .ToList();

                    foreach (var entrada in lstEntradas)
                    {
                        bool ocupaEspacio7600 = db.Vehiculo.Any(v => v.Numero_Placa == entrada.Numero_Placa
                                                                    && v.ID_Tipo == entrada.ID_Tipo
                                                                    && v.Espacio_7600);

                        if (ocupaEspacio7600)
                        {
                            entradas7600++;
                        }
                        else if (entrada.ID_Tipo == 1)
                        {
                            entradasCarro++;
                        }
                        else if (entrada.ID_Tipo == 2)
                        {
                            entradasMoto++;
                        }
                    }

                    foreach (var salida in lstSalidas)
                    {
                        bool ocupaEspacio7600 = db.Vehiculo.Any(v => v.Numero_Placa == salida.Numero_Placa
                                                                    && v.ID_Tipo == salida.ID_Tipo
                                                                    && v.Espacio_7600);

                        if (ocupaEspacio7600)
                        {
                            salidas7600++;
                        }
                        else if (salida.ID_Tipo == 1)
                        {
                            salidasCarro++;
                        }
                        else if (salida.ID_Tipo == 2)
                        {
                            salidasMoto++;
                        }
                    }

                    int ocupadosCarro = entradasCarro - salidasCarro;
                    int ocupadosMoto = entradasMoto - salidasMoto;
                    int ocupados7600 = entradas7600 - salidas7600;

                    var ocupacion = new Ocupacion
                    {
                        NombreParqueo = parqueo.Nombre,
                        EspaciosOcupados = new List<List<string>>
                        {
                            new List<string> {
                                "Carros",                                
                                parqueo.Capacidad_Espacios_Regulares.ToString(),
                                ocupadosCarro.ToString(),
                                (parqueo.Capacidad_Espacios_Regulares - ocupadosCarro).ToString()
                            },
                            new List<string> {
                                "Motos",                                
                                parqueo.Capacidad_Espacios_Moto.ToString(),
                                ocupadosMoto.ToString(),
                                (parqueo.Capacidad_Espacios_Moto - ocupadosMoto).ToString()
                            },
                            new List<string> {
                                "Espacios 7600",                               
                                parqueo.Capacidad_Espacios_7600.ToString(),
                                ocupados7600.ToString(),
                                (parqueo.Capacidad_Espacios_7600 - ocupados7600).ToString()
                            }
                        }
                    };

                    if (parqueoActual != null && parqueo.ID_Parqueo == parqueoActual.ID_Parqueo)
                    {
                        parqueoActualOcupacion = ocupacion;
                    }
                    else
                    {
                        Ocupaciones.Add(ocupacion);
                    }

                }
            }

            ViewBag.ParqueoActual = parqueoActualOcupacion;
            return View(Ocupaciones);
        }
    }
}