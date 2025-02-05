using Marketplace_Zapatos.Models.ViewModels;
using Marketplace_Zapatos.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data;

namespace Marketplace_Zapatos.Controllers
{
    public class PerfilController : Controller
    {
        [HttpGet]
        public ActionResult EditComprador()
        {
            var sesion = Sesion.GetSesion() as comprador;
            var model = new CompradorViewModel();

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var compradorTO = db.comprador.Find(sesion.IdComprador);

                model.IdComprador = compradorTO.IdComprador;
                model.Nombre = compradorTO.Nombre;
                model.Correo = compradorTO.Correo;
                model.Telefono = compradorTO.Telefono;
                model.Edad = compradorTO.Edad;
            }
            return View("EditComprador", model);
        }

        [HttpPost]
        public ActionResult EditComprador(CompradorViewModel model)
        {
            if (!ModelState.IsValid) return View(model);

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var sesion = Sesion.GetSesion() as comprador;
                var compradorTO = db.comprador.Find(sesion.IdComprador);

                compradorTO.Nombre = model.Nombre;
                compradorTO.Correo = model.Correo;
                compradorTO.Telefono = model.Telefono;
                compradorTO.Edad = model.Edad;

                db.Entry(compradorTO).State = EntityState.Modified;
                db.SaveChanges();
            }
            return Redirect(Url.Content("~/PincipalComprador/Index"));
        }

        [HttpGet]
        public ActionResult EditVendedor()
        {
            var sesion = Sesion.GetSesion() as Vendedor;
            var model = new VendedorViewModel();

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var vendedorTO = db.Vendedor.Find(sesion.IdVendedor);

                model.IdVendedor = vendedorTO.IdVendedor;
                model.Nombre = vendedorTO.Nombre;
                model.Correo = vendedorTO.Correo;
                model.Telefono = vendedorTO.Telefono;
                model.Edad = vendedorTO.Edad;
            }
            return View("EditVendedor", model);
        }

        [HttpPost]
        public ActionResult EditVendedor(VendedorViewModel model)
        {
            if (!ModelState.IsValid) return View(model);

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var sesion = Sesion.GetSesion() as Vendedor;
                var vendedorTO = db.Vendedor.Find(sesion.IdVendedor);

                vendedorTO.Nombre = model.Nombre;
                vendedorTO.Correo = model.Correo;
                vendedorTO.Telefono = model.Telefono;
                vendedorTO.Edad = model.Edad;

                db.Entry(vendedorTO).State = EntityState.Modified;
                db.SaveChanges();
            }
            return Redirect(Url.Content("~/Vendedor/Index"));
        }

        [HttpPost]
        public ActionResult DeleteComprador()
        {
            var sesion = Sesion.GetSesion() as comprador;

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var compradorTO = db.comprador.Find(sesion.IdComprador);
                if (compradorTO != null)
                {
                    db.comprador.Remove(compradorTO);
                    db.SaveChanges();
                }
            }

            // Borrar la variable de sesión
            Session.Abandon();

            return Redirect(Url.Content("~/Login/Index"));
        }

        [HttpPost]
        public ActionResult DeleteVendedor()
        {
            var sesion = Sesion.GetSesion() as Vendedor;

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var vendedorTO = db.Vendedor.Find(sesion.IdVendedor);
                if (vendedorTO != null)
                {
                    db.Vendedor.Remove(vendedorTO);
                    db.SaveChanges();
                }
            }

            // Borrar la variable de sesión
            Session.Abandon();

            return Redirect(Url.Content("~/Login/Index"));
        }
    }
}
