using Marketplace_Zapatos.Models.TableViewModels;
using Marketplace_Zapatos.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Marketplace_Zapatos.Controllers
{
    public class HistorialPedidosController : Controller
    {
        public ActionResult Index()
        {
            var sesion = Sesion.GetSesion() as comprador;
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var totalPedidos = (from h in db.HistorialPedidos
                                    join o in db.Orden on h.Orden_IdOrden equals o.IdOrden
                                    where o.comprador_IdComprador == sesion.IdComprador
                                    select h.Orden_IdOrden).Distinct().Count();

                var historialVentas = (from h in db.HistorialPedidos
                                       join o in db.Orden on h.Orden_IdOrden equals o.IdOrden
                                       join c in db.comprador on o.comprador_IdComprador equals c.IdComprador
                                       where db.Producto.Any(p => o.comprador_IdComprador == sesion.IdComprador &&
                                                                  db.Producto_Orden.Any(op => op.Producto_IdProducto == p.IdProducto &&
                                                                                             op.Orden_IdOrden == o.IdOrden))
                                       select new
                                       {
                                           h.Orden_IdOrden,
                                           h.MetodoDePago,
                                           h.Fecha,
                                           o.Estado,
                                           o.MontoTotal,
                                           h.DireccionEnvio,
                                       }).ToList();

                var listaHistoriales = historialVentas.Select(h => new HistorialDeVentasTableViewModel
                {
                    IdOrden = h.Orden_IdOrden,
                    MetodoDePago = h.MetodoDePago,
                    Fecha = h.Fecha,
                    Direccion = h.DireccionEnvio,
                    Estado = h.Estado,
                    Productos = (from op in db.Producto_Orden
                                 join prod in db.Producto on op.Producto_IdProducto equals prod.IdProducto
                                 join m in db.Marca on prod.Marca_IdMarca equals m.IdMarca
                                 join t in db.Talla on prod.Talla_IdTalla equals t.IdTalla
                                 join v in db.Vendedor on prod.Vendedor_IdVendedor equals v.IdVendedor
                                 where op.Orden_IdOrden == h.Orden_IdOrden
                                 select new Orden_ProductoTableViewModel
                                 {
                                     idHistorial = h.Orden_IdOrden,
                                     Modelo = prod.Modelo,
                                     Cantidad = op.Cantidad,
                                     precio = prod.Precio,
                                     Marca = m,
                                     Talla = t,
                                 }).ToList(),
                    Vendedores = (from op in db.Producto_Orden
                                join prod in db.Producto on op.Producto_IdProducto equals prod.IdProducto
                                join v in db.Vendedor on prod.Vendedor_IdVendedor equals v.IdVendedor
                                where op.Orden_IdOrden == h.Orden_IdOrden
                                select v).ToList(),
                    TotalOrden = h.MontoTotal
                }).ToList();

                var model = new InformeDeVentasTableViewModel
                {
                    TotalOrdenes = totalPedidos,
                    Historiales = listaHistoriales
                };

                return View(model);
            }
        }
    }
}
