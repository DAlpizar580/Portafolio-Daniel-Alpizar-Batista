using Marketplace_Zapatos.Models.TableViewModels;
using Marketplace_Zapatos.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Security.Cryptography;

namespace Marketplace_Zapatos.Controllers
{
    public class VentasDelVendedorController : Controller
    {
        public ActionResult Index()
        {
            var sesion = Sesion.GetSesion() as Vendedor;
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var totalOrdenes = (from h in db.HistorialPedidos
                                    join o in db.Orden on h.Orden_IdOrden equals o.IdOrden
                                    join op in db.Producto_Orden on o.IdOrden equals op.Orden_IdOrden
                                    join p in db.Producto on op.Producto_IdProducto equals p.IdProducto
                                    where p.Vendedor_IdVendedor == sesion.IdVendedor
                                    select h.Orden_IdOrden).Distinct().Count();

                var montoTotalGanado = (from h in db.HistorialPedidos
                                        join o in db.Orden on h.Orden_IdOrden equals o.IdOrden
                                        join op in db.Producto_Orden on o.IdOrden equals op.Orden_IdOrden
                                        join p in db.Producto on op.Producto_IdProducto equals p.IdProducto
                                        where p.Vendedor_IdVendedor == sesion.IdVendedor
                                        select p.Precio * op.Cantidad).Sum();

                var historialVentas = (from h in db.HistorialPedidos
                                       join o in db.Orden on h.Orden_IdOrden equals o.IdOrden
                                       join c in db.comprador on o.comprador_IdComprador equals c.IdComprador
                                       where db.Producto.Any(p => p.Vendedor_IdVendedor == sesion.IdVendedor &&
                                                                  db.Producto_Orden.Any(op => op.Producto_IdProducto == p.IdProducto &&
                                                                                             op.Orden_IdOrden == o.IdOrden))
                                       select new
                                       {
                                           h.Orden_IdOrden,
                                           h.MetodoDePago,
                                           h.Fecha,
                                           o.Estado,
                                           h.DireccionEnvio,
                                           c.Correo,
                                           c.Nombre
                                       }).ToList();

                var listaHistoriales = historialVentas.Select(h => new HistorialDeVentasTableViewModel
                {
                    IdOrden = h.Orden_IdOrden,
                    MetodoDePago = h.MetodoDePago,
                    Fecha = h.Fecha,
                    Estado = h.Estado,
                    Direccion = h.DireccionEnvio,
                    CorreoComprador = h.Correo,
                    NombreComprador = h.Nombre,
                    Productos = (from op in db.Producto_Orden
                                 join prod in db.Producto on op.Producto_IdProducto equals prod.IdProducto
                                 join m in db.Marca on prod.Marca_IdMarca equals m.IdMarca
                                 join t in db.Talla on prod.Talla_IdTalla equals t.IdTalla
                                 where op.Orden_IdOrden == h.Orden_IdOrden && prod.Vendedor_IdVendedor == sesion.IdVendedor
                                 select new Orden_ProductoTableViewModel
                                 {
                                     idHistorial = h.Orden_IdOrden,
                                     Modelo = prod.Modelo,
                                     Cantidad = op.Cantidad,
                                     precio = prod.Precio,
                                     Marca = m,
                                     Talla = t
                                 }).ToList(),
                    TotalOrden = (from op in db.Producto_Orden
                                  join prod in db.Producto on op.Producto_IdProducto equals prod.IdProducto
                                  where op.Orden_IdOrden == h.Orden_IdOrden && prod.Vendedor_IdVendedor == sesion.IdVendedor
                                  select prod.Precio * op.Cantidad).Sum()
                }).ToList();

                var model = new InformeDeVentasTableViewModel
                {
                    TotalOrdenes = totalOrdenes,
                    MontoTotalGanado = montoTotalGanado,
                    Historiales = listaHistoriales
                };

                return View(model);
            }
        }
    }
}
