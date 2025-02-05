using Marketplace_Zapatos.Models.TableViewModels;
using Marketplace_Zapatos.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Marketplace_Zapatos.Models.ViewModels;

namespace Marketplace_Zapatos.Controllers
{
    public class VendedorController : Controller
    {
        // GET: Vendedor
        public ActionResult Index(string searchBy, string search)
        {
            List<ProductoTableViewModel> lstProductos = null;
            List<Imagenes_ProductoTableViewModel> lstimagenes = null;

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                // Assume Sesion.GetSesion() returns the current logged-in Vendedor
                var vendedor = Sesion.GetSesion() as Vendedor;
                if (vendedor == null)
                {
                    // Handle the case where the vendedor is not logged in or found
                    return RedirectToAction("Login", "Account"); // or appropriate redirection
                }

                var vendedorId = vendedor.IdVendedor;

                var productosQuery = from prod in db.Producto
                                     join m in db.Marca on prod.Marca_IdMarca equals m.IdMarca
                                     join t in db.Talla on prod.Talla_IdTalla equals t.IdTalla
                                     join c in db.Categoria on prod.Categoria_IdCategoria equals c.IdCategoria
                                     where prod.Vendedor_IdVendedor == vendedorId && prod.Aprobado
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
                                         Categoria = c
                                     };

                // Apply the search filter
                if (!string.IsNullOrEmpty(search))
                {
                    if (searchBy == "Modelo")
                    {
                        productosQuery = productosQuery.Where(x => x.Modelo.Contains(search));
                    }
                    else if (searchBy == "Marca")
                    {
                        productosQuery = productosQuery.Where(x => x.Marca.Nombre.Contains(search));
                    }
                    else if (searchBy == "Talla")
                    {
                        int tallaBusqueda = int.Parse(search);
                        productosQuery = productosQuery.Where(x => x.Talla.Numero == tallaBusqueda);
                    }
                    else if (searchBy == "Categoria")
                    {
                        productosQuery = productosQuery.Where(x => x.Categoria.Nombre.Contains(search));
                    }
                    else if (searchBy == "Color")
                    {
                        productosQuery = productosQuery.Where(x => x.Color.Contains(search));
                    }
                    else if (searchBy == "Precio")
                    {
                        int precioBusqueda = int.Parse(search);
                        productosQuery = productosQuery.Where(x => x.Precio == precioBusqueda);
                    }
                }

                lstProductos = productosQuery.OrderBy(x => x.Modelo).ToList();

                lstimagenes = (from img in db.Imagenes_Producto
                               join prod in db.Producto on img.Producto_IdProducto equals prod.IdProducto
                               where prod.Vendedor_IdVendedor == vendedorId
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

        

        }
    }

