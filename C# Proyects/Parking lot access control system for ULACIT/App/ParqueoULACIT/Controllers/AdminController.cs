using ParqueoULACIT.Filters;
using ParqueoULACIT.Models;
using ParqueoULACIT.Models.TableViewModel;
using ParqueoULACIT.Models.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ParqueoULACIT.Controllers
{
    [RolAutorizacion(1)] // Solo administradores
    public class AdminController : Controller

    {
        private readonly SistemaParqueoEntities _context;

        public AdminController()
        {
            _context = new SistemaParqueoEntities();
        }

        // GET: Admin
        public ActionResult Index()
        {
            List<Ocupacion> Ocupaciones = new List<Ocupacion>();

            using (var db = new SistemaParqueoEntities())
            {
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

                    Ocupaciones.Add(new Ocupacion
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
                    });                                   
                    
                }
            }

            return View(Ocupaciones);
        }

        // GET: Admin/Parqueo/Listar
        [HttpGet]
        public ActionResult ListarParqueos()
        {
            List<ParqueoTableViewModel> lstParqueos = null;

            using (var db = new SistemaParqueoEntities())
            {
                lstParqueos = (from p in db.Parqueo
                               select new ParqueoTableViewModel
                               {
                                   ID_Parqueo = p.ID_Parqueo,
                                   Nombre = p.Nombre,
                                   Capacidad_Espacios_Regulares = p.Capacidad_Espacios_Regulares,
                                   Capacidad_Espacios_Moto = p.Capacidad_Espacios_Moto,
                                   Capacidad_Espacios_7600 = p.Capacidad_Espacios_7600
                               }).ToList();
            }
            return View(lstParqueos);
        }


        // GET: Admin/Parqueo/Create
        [HttpGet]
        public ActionResult CreateParqueo()
        {
            return View();
        }

        // POST: Admin/Parqueo/Create
        [HttpPost]
        public ActionResult CreateParqueo(ParqueoViewModel model)
        {
            if (ModelState.IsValid)
            {
                var parqueo = new Parqueo
                {
                    Nombre = model.Nombre,
                    Capacidad_Espacios_Regulares = model.Capacidad_Espacios_Regulares,
                    Capacidad_Espacios_Moto = model.Capacidad_Espacios_Moto,
                    Capacidad_Espacios_7600 = model.Capacidad_Espacios_7600
                };

                _context.Parqueo.Add(parqueo);
                _context.SaveChanges();

               
                    ViewBag.Message = "Parqueo creado exitosamente.";                                                 
                
            }

            return View(model); // necesario asi para que sirva el sweet alert
        }


        // GET: Admin/Parqueo/Edit
        [HttpGet]
        public ActionResult EditarParqueo(int id)
        {
            var parqueo = _context.Parqueo.Find(id);
            if (parqueo == null)
            {
                return HttpNotFound();
            }

            var model = new ParqueoViewModel
            {
                ID_Parqueo = parqueo.ID_Parqueo,
                Nombre = parqueo.Nombre,
                Capacidad_Espacios_Regulares = parqueo.Capacidad_Espacios_Regulares,
                Capacidad_Espacios_Moto = parqueo.Capacidad_Espacios_Moto,
                Capacidad_Espacios_7600 = parqueo.Capacidad_Espacios_7600
            };

            return View(model);
        }

        // POST: Admin/Parqueo/Edit
        [HttpPost]        
        public ActionResult EditarParqueo(ParqueoViewModel model)
        {
            if (ModelState.IsValid)
            {
                var parqueo = _context.Parqueo.Find(model.ID_Parqueo);
                if (parqueo == null)
                {
                    return HttpNotFound();
                }

                parqueo.Nombre = model.Nombre;
                parqueo.Capacidad_Espacios_Regulares = model.Capacidad_Espacios_Regulares;
                parqueo.Capacidad_Espacios_Moto = model.Capacidad_Espacios_Moto;
                parqueo.Capacidad_Espacios_7600 = model.Capacidad_Espacios_7600;

                _context.Entry(parqueo).State = System.Data.EntityState.Modified;
                _context.SaveChanges();               
                   
                ViewBag.Message = "Parqueo editado exitosamente.";

            }

            return View(model); // Retorna la misma vista con los errores
        }                   

        [HttpGet]
        public ActionResult ListarUsuarios()
        {
            List<UsuarioTableViewModel> lstUsuarios = null;

            using (var db = new SistemaParqueoEntities())
            {
                lstUsuarios = (from u in db.Usuario
                               join r in db.Rol on u.ID_Rol equals r.ID_Rol
                               select new UsuarioTableViewModel
                               {
                                   ID_Usuario = u.ID_Usuario,
                                   Identificacion = u.Identificacion,
                                   Nombre = u.Nombre,
                                   Apellido_1 = u.Apellido_1,
                                   Apellido_2 = u.Apellido_2,
                                   Correo = u.Correo,
                                   Fecha_Nacimiento = u.Fecha_Nacimiento,
                                   Numero_Carne = u.Numero_Carne,
                                   Rol = r.Nombre_Rol,
                                   EstadoUsuario = u.Estado ? "Activo" : "Inactivo"
                               }).ToList();
            }
            return View(lstUsuarios);
        }



        [HttpGet]
        public ActionResult crearUsuario()
        {

            var usuarioLogueado = Sesion.GetSesion() as Usuario;


            if (usuarioLogueado == null || usuarioLogueado.ID_Rol != 1)
            {

                return RedirectToAction("Index", "Login");
            }


            ViewBag.Roles = new SelectList(_context.Rol.ToList(), "ID_Rol", "Nombre_Rol");
            return View();
        }


        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult crearUsuario(UsuarioViewModel model)
        {

            if (ModelState.IsValid)
            {

                if (_context.Usuario.Any(u => u.Correo == model.Correo.Trim()))
                {
                    ModelState.AddModelError("Correo", "El correo ya está registrado. Por favor, use uno diferente.");
                }

                else if (_context.Usuario.Any(u => u.Identificacion == model.Identificacion))
                {
                    ModelState.AddModelError("Identificacion", "La identificación ya está registrada. Por favor, use una diferente.");
                }

                else if (_context.Usuario.Any(u => u.Numero_Carne == model.Numero_Carne))
                {
                    ModelState.AddModelError("Numero_Carne", "El número de carné ya está registrado. Por favor, use uno diferente.");
                }
                else
                {

                    Usuario usuario = new Usuario
                    {
                        Nombre = model.Nombre,
                        Apellido_1 = model.Apellido_1,
                        Apellido_2 = model.Apellido_2,
                        Correo = model.Correo.Trim(),
                        Contrasena = "Ulacit123",
                        Fecha_Nacimiento = model.Fecha_Nacimiento,
                        Identificacion = model.Identificacion,
                        Numero_Carne = model.Numero_Carne,
                        ID_Rol = model.ID_Rol,
                        Estado = true
                    };

                    _context.Usuario.Add(usuario);
                    _context.SaveChanges();

                    ViewBag.Message = "Usuario registrado exitosamente.";
                                        
                }
            }
            

            ViewBag.Roles = new SelectList(_context.Rol.ToList(), "ID_Rol", "Nombre_Rol");
            return View(model);
        }

        [HttpGet]
        public ActionResult EditarUsuario(int id)
        {
            var usuario = _context.Usuario.Find(id);
            if (usuario == null)
            {
                return HttpNotFound();
            }

            var model = new UsuarioViewModel
            {
                ID_Usuario = usuario.ID_Usuario,
                Nombre = usuario.Nombre,
                Apellido_1 = usuario.Apellido_1,
                Apellido_2 = usuario.Apellido_2,
                Correo = usuario.Correo,
                Fecha_Nacimiento = usuario.Fecha_Nacimiento,
                Identificacion = usuario.Identificacion,
                Numero_Carne = usuario.Numero_Carne,
                ID_Rol = usuario.ID_Rol,
                Estado = usuario.Estado,
                Contrasena = usuario.Contrasena
            };

            ViewBag.Roles = new SelectList(_context.Rol.ToList(), "ID_Rol", "Nombre_Rol", model.ID_Rol);
            return View(model);
        }

        [HttpPost]        
        public ActionResult EditarUsuario(UsuarioViewModel model)
        {
            if (ModelState.IsValid)
            {
                var usuario = _context.Usuario.Find(model.ID_Usuario);
                if (usuario == null)
                {
                    return HttpNotFound();
                }

                // Verificar si el correo, identificación o número de carné están en uso por otro usuario
                if (_context.Usuario.Any(u => u.Correo == model.Correo.Trim() && u.ID_Usuario != model.ID_Usuario))
                {
                    ModelState.AddModelError("Correo", "El correo ya está registrado. Por favor, use uno diferente.");
                }
                else if (_context.Usuario.Any(u => u.Identificacion == model.Identificacion && u.ID_Usuario != model.ID_Usuario))
                {
                    ModelState.AddModelError("Identificacion", "La identificación ya está registrada. Por favor, use una diferente.");
                }
                else if (_context.Usuario.Any(u => u.Numero_Carne == model.Numero_Carne && u.ID_Usuario != model.ID_Usuario))
                {
                    ModelState.AddModelError("Numero_Carne", "El número de carné ya está registrado. Por favor, use uno diferente.");
                }
                else
                {
                    // Actualizar los campos del usuario
                    usuario.Nombre = model.Nombre;
                    usuario.Apellido_1 = model.Apellido_1;
                    usuario.Apellido_2 = model.Apellido_2;
                    usuario.Correo = model.Correo.Trim();
                    usuario.Fecha_Nacimiento = model.Fecha_Nacimiento;
                    usuario.Identificacion = model.Identificacion;
                    usuario.Numero_Carne = model.Numero_Carne;
                    usuario.ID_Rol = model.ID_Rol;
                    usuario.Estado = model.Estado;

                    _context.Entry(usuario).State = System.Data.EntityState.Modified;

                    // Si el estado del usuario es false, actualizar los vehículos asignados
                    if (!model.Estado)
                    {
                        var vehiculosAsignados = _context.Vehiculo
                            .Where(v => v.ID_Usuario == usuario.ID_Usuario && v.Estado == true)
                            .ToList();

                        foreach (var vehiculo in vehiculosAsignados)
                        {
                            vehiculo.Estado = false;
                            _context.Entry(vehiculo).State = System.Data.EntityState.Modified;
                        }
                    }

                    _context.SaveChanges();


                    ViewBag.Message = "Usuario editado exitosamente.";



                }
            }
            else
            {
                foreach (var error in ModelState.Values.SelectMany(v => v.Errors))
                {
                    Console.WriteLine(error.ErrorMessage);
                }
                
            }

            ViewBag.Roles = new SelectList(_context.Rol.ToList(), "ID_Rol", "Nombre_Rol", model.ID_Rol);
            return View(model);
        }

        // GET: Admin/ReporteIntentosFallidos
        [HttpGet]
        public ActionResult ReporteIntentosFallidos(DateTime? fechaInicio, DateTime? fechaFin)
        {
            if (!fechaInicio.HasValue) fechaInicio = DateTime.MinValue;
            if (!fechaFin.HasValue) fechaFin = DateTime.MaxValue;

            var intentosFallidos = _context.Bitacora
                .Where(b => (b.ID_Movimiento == 4 || b.ID_Movimiento == 5) && b.Fecha >= fechaInicio && b.Fecha <= fechaFin)
                .Select(b => new ReporteIntentosFallidosViewModel
                {
                    Fecha = b.Fecha,
                    Hora = b.Hora,
                    Numero_Placa = b.Numero_Placa,
                    ID_Movimiento = b.ID_Movimiento,
                    TipoVehiculo = _context.Tipo_Vehiculo.FirstOrDefault(tv => tv.ID_Tipo == b.ID_Tipo).Tipo
                })
                .ToList();

            if (!intentosFallidos.Any())
            {
                ViewBag.ErrorMessage = "No se encontraron intentos fallidos en el rango de fechas seleccionado.";
            }

            return View(intentosFallidos);
        }
    }
}

