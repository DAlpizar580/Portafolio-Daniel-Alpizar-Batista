using Marketplace_Zapatos.Models;
using Marketplace_Zapatos.Models.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Marketplace_Zapatos.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public ActionResult EnterComprador(string txtCorreo, string txtPassword)
        {
            try
            {
                using (var db = new ProyectoDiseñoDeAplicacionesEntities())
                {
                    var lst = from c in db.comprador
                              where c.Correo == txtCorreo && c.Password == txtPassword
                              select c;

                    if (lst.Count() > 0)
                    {
                        comprador comprador = lst.First();
                        // Guardar un valor en la sesión
                        Sesion.SetSesion(comprador);
                        return Content("Ok");
                    }
                    else
                    {
                        return Content("Usuario o contraseña incorrecta");
                    }
                }
            }
            catch (Exception ex)
            {
                return Content($"Ocurrio un error. Error: {ex.Message}");
            }
        }
        [HttpPost]
        public ActionResult EnterVendedor(string txtCorreo, string txtPassword)
        {
            try
            {
                using (var db = new ProyectoDiseñoDeAplicacionesEntities())
                {
                    Console.WriteLine("Correo: " + txtCorreo);
                    Console.WriteLine("Password: " + txtPassword);
                    var lst = from v in db.Vendedor
                              where v.Correo == txtCorreo && v.Password == txtPassword
                              select v;

                    if (lst.Count() > 0)
                    {
                        Vendedor vendedor = lst.First();
                        Sesion.SetSesion(vendedor);
                        return Content("Ok");
                    }
                    else
                    {
                        return Content("Usuario o contraseña incorrecta");
                    }
                }
            }
            catch (Exception ex)
            {
                return Content($"Ocurrio un error. Error: {ex.Message}");
            }
        }
        [HttpPost]
        public ActionResult EnterAdministrador(string txtCorreo, string txtPassword)
        {
            try
            {
                using (var db = new ProyectoDiseñoDeAplicacionesEntities())
                {
                    var lst = from a in db.Administrador
                              where a.Correo == txtCorreo && a.Password == txtPassword
                              select a;

                    if (lst.Count() > 0)
                    {
                        Administrador administrador = lst.First();
                        Sesion.SetSesion(administrador);
                        return Content("Ok");
                    }
                    else
                    {
                        return Content("Usuario o contraseña incorrecta");
                    }
                }
            }
            catch (Exception ex)
            {
                return Content($"Ocurrio un error. Error: {ex.Message}");
            }
        }
        public ActionResult Logout()
        {
            Sesion.SetSesion(null);
            return RedirectToAction("Index", "Login");
        }

        [HttpGet]
        public ActionResult Add()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Add(PersonaViewModel model, string action)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                if (action == "Comprador")
                {
                    CarritoDeCompras carrito = new CarritoDeCompras
                    {
                        Precio = 0
                    };
                    db.CarritoDeCompras.Add(carrito);
                    comprador compradorTO = new comprador
                    {
                        Nombre = model.Nombre,
                        Correo = model.Correo,
                        Password = model.Password,
                        Telefono = model.Telefono,
                        Edad = model.Edad,
                        CarritoDeCompras_IdCarrito = carrito.IdCarrito
                    };
                    Console.WriteLine("Carrito: " + carrito.IdCarrito);
                    Console.WriteLine("Comprador: " + compradorTO.CarritoDeCompras_IdCarrito);
                    Console.WriteLine("Comprador: " + compradorTO.Nombre);
                    Console.WriteLine("Comprador: " + compradorTO.Correo);
                    Console.WriteLine("Comprador: " + compradorTO.Password);
                    Console.WriteLine("Comprador: " + compradorTO.Telefono);
                    Console.WriteLine("Comprador: " + compradorTO.Edad);

                    db.comprador.Add(compradorTO);
                    db.SaveChanges();
                }
                else if (action == "Vendedor")
                {
                    Vendedor vendedorTO = new Vendedor
                    {
                        Nombre = model.Nombre,
                        Correo = model.Correo,
                        Password = model.Password,
                        Telefono = model.Telefono,
                        Edad = model.Edad
                    };

                    db.Vendedor.Add(vendedorTO);
                    db.SaveChanges();
                }

                
            }

            return RedirectToAction("Index", "Login");
        }
    }
}
