using Marketplace_Zapatos.Models;
using Marketplace_Zapatos.Models.TableViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Marketplace_Zapatos.Controllers
{
    public class AdminController : Controller
    {
        public ActionResult Index(string searchBy, string search)
        {
            List<ProductoTableViewModel> lstProductos = null;
            List<Imagenes_ProductoTableViewModel> lstimagenes = null;

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var productosQuery = from prod in db.Producto
                                     join m in db.Marca on prod.Marca_IdMarca equals m.IdMarca
                                     join t in db.Talla on prod.Talla_IdTalla equals t.IdTalla
                                     join c in db.Categoria on prod.Categoria_IdCategoria equals c.IdCategoria
                                     join v in db.Vendedor on prod.Vendedor_IdVendedor equals v.IdVendedor
                                     where !prod.Aprobado
                                     select new ProductoTableViewModel
                                     {
                                         IdProducto = prod.IdProducto,
                                         Modelo = prod.Modelo,
                                         Precio = prod.Precio,
                                         Stock = prod.Stock,
                                         Color = prod.Color,
                                         Disponibilidad = prod.Disponibilidad,
                                         Vendedor_IdVendedor = prod.Vendedor_IdVendedor,
                                         Marca_IdMarca = prod.Marca_IdMarca,
                                         Talla_IdTalla = prod.Talla_IdTalla,
                                         Categoria_IdCategoria = prod.Categoria_IdCategoria,
                                         Aprobado = prod.Aprobado,
                                         Administrador_IdAdministrador = prod.Administrador_IdAdministrador,
                                         Marca = m,
                                         Talla = t,
                                         Categoria = c,
                                         Vendedor = v
                                     };

                lstProductos = productosQuery.OrderBy(x => x.Modelo).ToList();

                // Obtener imágenes de los productos
                lstimagenes = (from img in db.Imagenes_Producto
                               join prod in db.Producto on img.Producto_IdProducto equals prod.IdProducto
                               select new Imagenes_ProductoTableViewModel
                               {
                                   Producto_IdProducto = img.Producto_IdProducto,
                                   Imagen = img.Imagen,
                                   Producto = prod
                               }).ToList();
            }

            var model = new ProductoConImagenesTableViewModel
            {
                Productos = lstProductos,
                Imagenes = lstimagenes
            };

            return View(model);
        }

        [HttpPost]
        public ActionResult Aprobar(int ProductoID)
        {
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var productoTO = db.Producto.Find(ProductoID);

                productoTO.Aprobado = true;

                db.Entry(productoTO).State = System.Data.EntityState.Modified;
                db.SaveChanges();
            }
            return Redirect(Url.Content("~/Admin/Index"));
        }

    }
}
