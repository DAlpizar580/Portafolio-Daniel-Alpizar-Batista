using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data.Entity;
using Marketplace_Zapatos.Models;
using Marketplace_Zapatos.Models.TableViewModels;
using Marketplace_Zapatos.Models.ViewModels;
using System.Runtime.InteropServices;

namespace Marketplace_Zapatos.Controllers
{
    public class CarritoController : Controller
    {
        // GET: Carrito
        public ActionResult Index()
        {
            var sesion = Sesion.GetSesion() as comprador;

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var productosEnCarrito = (from cp in db.Carrito_Producto
                                          join p in db.Producto on cp.Producto_IdProducto equals p.IdProducto
                                          join m in db.Marca on p.Marca_IdMarca equals m.IdMarca
                                          join t in db.Talla on p.Talla_IdTalla equals t.IdTalla
                                          where cp.CarritoDeCompras_IdCarrito == sesion.CarritoDeCompras_IdCarrito
                                          select new Carrito_ProductoTableViewModel
                                          {
                                              Modelo = p.Modelo,
                                              Cantidad = cp.Cantidad,
                                              Producto_IdProducto = cp.Producto_IdProducto,
                                              CarritoDeCompras_IdCarrito = cp.CarritoDeCompras_IdCarrito,
                                              Stock = p.Stock,
                                              precio = p.Precio,
                                              Vendedor = p.Vendedor,
                                              Marca = m,
                                              Talla = t
                                          }).ToList();

                int totalPrecioCarrito = productosEnCarrito.Sum(producto => (int)(producto.precio * producto.Cantidad));

                var carrito = db.CarritoDeCompras.SingleOrDefault(c => c.IdCarrito == sesion.CarritoDeCompras_IdCarrito);

                if (carrito != null)
                {
                    carrito.Precio = totalPrecioCarrito;
                    db.SaveChanges();
                }
                var model = new CarritoConProductos_CarritoTableViewModel
                {
                    Productos = productosEnCarrito,
                    Carrito = carrito
                };
                return View(model);
            }
        }

        [HttpPost]
        public ActionResult Eliminar(int CarritoDeCompras_IdCarrito, int Producto_IdProducto)
        {
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var productoParaActualizar = db.Carrito_Producto
                    .FirstOrDefault(p => p.Producto_IdProducto == Producto_IdProducto &&
                                         p.CarritoDeCompras_IdCarrito == CarritoDeCompras_IdCarrito);

                if (productoParaActualizar != null)
                {
                    productoParaActualizar.Cantidad -= 1;
                    if (productoParaActualizar.Cantidad <= 0)
                    {
                        db.Carrito_Producto.Remove(productoParaActualizar);
                    }
                    db.SaveChanges();
                }
            }
            return RedirectToAction("Index");
        }
        [HttpPost]
        public ActionResult Agregar(int CarritoDeCompras_IdCarrito, int Producto_IdProducto, int Stock)
        {
            TempData["ErrorMessage"] = null;
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var productoParaActualizar = db.Carrito_Producto
                    .FirstOrDefault(p => p.Producto_IdProducto == Producto_IdProducto &&
                                         p.CarritoDeCompras_IdCarrito == CarritoDeCompras_IdCarrito);
                if ((productoParaActualizar.Cantidad + 1) <= Stock)
                {
                    if (productoParaActualizar != null)
                    {
                        productoParaActualizar.Cantidad += 1;
                        db.SaveChanges();
                    }
                }
                else
                {
                    TempData["ErrorMessage"] = "Ya no hay mas stock del producto";
                }

            }
            return RedirectToAction("Index");
        }


        


    }
}