using Microsoft.Ajax.Utilities;
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
    public class VehiculoController : Controller
    {        
        // GET: Vehiculo
        public ActionResult Index()
        {
            List<VehiculoTableViewModel> lstVehiculos = null;

            using (var db = new SistemaParqueoEntities())
            {
                lstVehiculos = (from v in db.Vehiculo
                                join t in db.Tipo_Vehiculo on v.ID_Tipo equals t.ID_Tipo
                                join u in db.Usuario on v.ID_Usuario equals u.ID_Usuario
                                select new VehiculoTableViewModel
                                {
                                    ID_Vehiculo = v.ID_Vehiculo,
                                    Marca = v.Marca,
                                    Color = v.Color,
                                    Numero_Placa = v.Numero_Placa,
                                    Tipo = t.Tipo,
                                    Usuario = u.Identificacion + " - " + u.Nombre + " " + u.Apellido_1 + " " + u.Apellido_2,
                                    OcupaEspacio7600 = v.Espacio_7600 ? "Sí" : "No",
                                    EstadoVehiculo = v.Estado ? "Activo" : "Inactivo"
                                }).ToList();
            }

            return View(lstVehiculos);
        }

        [HttpGet]
        public ActionResult Add()
        {
            VehiculoViewModel model = new VehiculoViewModel();

            CargarSelectLists(model);
            return View(model);

        }

        [HttpPost]
        public ActionResult Add(VehiculoViewModel model)
        {
            if (ModelState.IsValid)
            {
                using (var db = new SistemaParqueoEntities())
                {
                    var vehiculoExistente = db.Vehiculo.FirstOrDefault(v => v.Numero_Placa == model.Numero_Placa && v.ID_Tipo == model.ID_Tipo);
                    if (vehiculoExistente != null)
                    {
                        TempData["ErrorMessage"] = "Ya existe un vehiculo registrado con este numero de placa.";
                        CargarSelectLists(model);
                        return View(model);
                    }

                    var vehiculosActivos = db.Vehiculo.Count(v => v.ID_Usuario == model.ID_Usuario && v.Estado == true);
                    if (vehiculosActivos >= 2)
                    {
                        TempData["ErrorMessage"] = "El usuario ya tiene 2 vehiculos activos. No puede registrar mas vehiculos.";
                        CargarSelectLists(model);
                        return View(model);
                    }

                    Vehiculo vehiculoTO = new Vehiculo();
                    vehiculoTO.Marca = model.Marca;
                    vehiculoTO.Color = model.Color;
                    vehiculoTO.Numero_Placa = model.Numero_Placa;
                    vehiculoTO.ID_Tipo = model.ID_Tipo;
                    vehiculoTO.ID_Usuario = model.ID_Usuario;
                    vehiculoTO.Espacio_7600 = model.Espacio_7600;
                    vehiculoTO.Estado = true;

                    db.Vehiculo.Add(vehiculoTO);
                    db.SaveChanges();

                    TempData["SuccessMessage"] = "Vehiculo registrado exitosamente.";
                    return Redirect(Url.Content("~/Vehiculo/Add"));
                }                  
                
            }

            CargarSelectLists(model);
            return View(model);
        }

        [HttpGet]
        public ActionResult Edit(int Id)
        {
            VehiculoViewModel model = new VehiculoViewModel();

            using (var db = new SistemaParqueoEntities())
            {
                var vehiculoTO = db.Vehiculo.Find(Id);
                model.ID_Vehiculo = vehiculoTO.ID_Vehiculo;
                model.Marca = vehiculoTO.Marca;
                model.Color = vehiculoTO.Color;
                model.Numero_Placa = vehiculoTO.Numero_Placa;
                model.ID_Tipo = vehiculoTO.ID_Tipo;
                model.ID_Usuario = vehiculoTO.ID_Usuario;
                model.Espacio_7600 = vehiculoTO.Espacio_7600;
                model.Estado = vehiculoTO.Estado;

                CargarSelectLists(model, Id);
            }

            return View(model);
        }

        [HttpPost]
        public ActionResult Edit(VehiculoViewModel model)
        {
            if (!ModelState.IsValid)
            {
                CargarSelectLists(model, model.ID_Vehiculo);
                return View(model);
            }

            using (var db = new SistemaParqueoEntities())
            {
                var vehiculoExistente = db.Vehiculo.FirstOrDefault(v => v.Numero_Placa == model.Numero_Placa && v.ID_Tipo == model.ID_Tipo && v.ID_Vehiculo != model.ID_Vehiculo);
                if (vehiculoExistente != null)
                {
                    TempData["ErrorMessage"] = "Ya existe un vehiculo registrado con este numero de placa.";
                    CargarSelectLists(model, model.ID_Vehiculo);
                    return View(model);
                }

                var vehiculosActivos = db.Vehiculo.Count(v => v.ID_Usuario == model.ID_Usuario && v.Estado == true && v.ID_Vehiculo != model.ID_Vehiculo);
                if (vehiculosActivos >= 2)
                {
                    TempData["ErrorMessage"] = "El usuario ya tiene 2 vehiculos activos.";
                    CargarSelectLists(model, model.ID_Vehiculo);
                    return View(model);
                }

                var usuario = db.Usuario.FirstOrDefault(u => u.ID_Usuario == model.ID_Usuario);
                if (usuario != null && !usuario.Estado && model.Estado)
                {
                    // Si el usuario está inactivo y se intenta activar el vehículo
                    TempData["ErrorMessage"] = "El usuario asociado esta inactivo. No se puede activar el vehiculo.";
                    CargarSelectLists(model, model.ID_Vehiculo);
                    return View(model);
                }

                var vehiculoTO = db.Vehiculo.Find(model.ID_Vehiculo);
                vehiculoTO.Marca = model.Marca;
                vehiculoTO.Color = model.Color;
                vehiculoTO.Numero_Placa = model.Numero_Placa;
                vehiculoTO.ID_Tipo = model.ID_Tipo;
                vehiculoTO.ID_Usuario = model.ID_Usuario;
                vehiculoTO.Espacio_7600 = model.Espacio_7600;
                vehiculoTO.Estado = model.Estado;
                db.Entry(vehiculoTO).State = System.Data.EntityState.Modified;
                db.SaveChanges(); 
            }
            TempData["SuccessMessage"] = "Vehiculo editado exitosamente.";
            CargarSelectLists(model, model.ID_Vehiculo);
            return View(model);

        }


        // Método para cargar los SelectLists nuevamente
        private void CargarSelectLists(VehiculoViewModel model, int? idVehiculo = null)
        {
            using (var db = new SistemaParqueoEntities())
            {
                //Llenar las listas
                model.TiposVehiculo = db.Tipo_Vehiculo.Select(t => new TipoVehiculoViewModel
                {
                    ID_Tipo = t.ID_Tipo,
                    Tipo = t.Tipo
                }).ToList();

                // Obtener usuarios activos
                var usuariosActivos = db.Usuario
                    .Where(u => u.Estado == true)
                    .Select(u => new
                    {
                        ID_Usuario = u.ID_Usuario,
                        Identificacion = u.Identificacion,
                        Nombre = u.Nombre,
                        Apellido_1 = u.Apellido_1,
                        Apellido_2 = u.Apellido_2
                    }).ToList();

                var usuarios = usuariosActivos.Select(u => new UsuarioViewModel
                {
                    ID_Usuario = u.ID_Usuario,
                    DescripcionUsuario = $"{u.Identificacion} - {u.Nombre} {u.Apellido_1} {u.Apellido_2}"
                }).ToList();

                // Si se está editando un vehículo, agregar el propietario inactivo al DropDownList
                if (idVehiculo.HasValue)
                {
                    var vehiculo = db.Vehiculo.Find(idVehiculo.Value);
                    if (vehiculo != null)
                    {
                        var propietario = db.Usuario
                            .Where(u => u.ID_Usuario == vehiculo.ID_Usuario)
                            .Select(u => new
                            {
                                ID_Usuario = u.ID_Usuario,
                                Identificacion = u.Identificacion,
                                Nombre = u.Nombre,
                                Apellido_1 = u.Apellido_1,
                                Apellido_2 = u.Apellido_2,
                                Estado = u.Estado
                            })
                            .FirstOrDefault();

                        if (propietario != null && !propietario.Estado)
                        {
                            usuarios.Add(new UsuarioViewModel
                            {
                                ID_Usuario = propietario.ID_Usuario,
                                DescripcionUsuario = $"{propietario.Identificacion} - {propietario.Nombre} {propietario.Apellido_1} {propietario.Apellido_2} (Inactivo)"
                            });
                        }
                    }
                }

                // Asignar la lista de usuarios al modelo
                model.Usuarios = usuarios;

            }

            // Lógica para cargar marcas según el tipo de vehículo seleccionado
            List<string> marcas = new List<string>();
            if (model.ID_Tipo == 1) // Carro
            {
                marcas = new List<string>
                {
                    "Toyota", "Nissan", "Honda", "Ford", "Chevrolet", "Mazda",
                    "Volkswagen", "Hyundai", "BMW", "Mercedes-Benz", "Audi"
                };
            }
            else if (model.ID_Tipo == 2) // Moto
            {
                marcas = new List<string>
                {
                    "Yamaha", "Suzuki", "Harley-Davidson", "BMW", "Ducati",
                    "Kawasaki", "Honda", "Royal Enfield", "KTM", "Triumph"
                };
            }

            ViewBag.Marca = new SelectList(marcas, model.Marca);
        }

        public JsonResult ObtenerMarcas(int idTipo)
        {
            List<string> marcas = new List<string>();

            if (idTipo == 1) // Carro
            {
                marcas = new List<string>
                {
                    "Toyota", "Nissan", "Honda", "Ford", "Chevrolet", "Mazda",
                    "Volkswagen", "Hyundai", "BMW", "Mercedes-Benz", "Audi"
                };
            }
            else if (idTipo == 2) // Moto
            {
                marcas = new List<string>
                {
                    "Yamaha", "Suzuki", "Harley-Davidson", "BMW", "Ducati",
                    "Kawasaki", "Honda", "Royal Enfield", "KTM", "Triumph"
                };
            }

            return Json(marcas, JsonRequestBehavior.AllowGet);
        }
    }
}
