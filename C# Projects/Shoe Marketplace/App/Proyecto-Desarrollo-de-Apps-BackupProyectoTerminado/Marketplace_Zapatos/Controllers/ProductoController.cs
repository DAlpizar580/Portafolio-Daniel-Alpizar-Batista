using Marketplace_Zapatos.Models.TableViewModels;
using Marketplace_Zapatos.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Marketplace_Zapatos.Models.ViewModels;
using System.Data;
using System.Diagnostics;

namespace Marketplace_Zapatos.Controllers
{
    public class ProductoController : Controller
    {
        public ActionResult Index(int id)
        {
            // Initialize lists
            List<ProductoTableViewModel> lstProductos = new List<ProductoTableViewModel>();
            List<Imagenes_ProductoTableViewModel> lstimagenes = new List<Imagenes_ProductoTableViewModel>();
            List<ReviewProductoTableViewModel> lstReview = new List<ReviewProductoTableViewModel>();
            List<CarritoProductoOriginalTableViewModel> lstCarrito = new List<CarritoProductoOriginalTableViewModel>();
            var model = new ProductoConImagenesTableViewModel();

            // Retrieve session data

            var sesion = Sesion.GetSesion() as comprador;
            if (sesion == null)
            {
                // Handle the case where the session is null (e.g., redirect to login)
                return RedirectToAction("Index", "Login");
            }

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                // Get product details
                lstProductos = (from prod in db.Producto
                                join m in db.Marca on prod.Marca_IdMarca equals m.IdMarca
                                join t in db.Talla on prod.Talla_IdTalla equals t.IdTalla
                                join c in db.Categoria on prod.Categoria_IdCategoria equals c.IdCategoria
                                join v in db.Vendedor on prod.Vendedor_IdVendedor equals v.IdVendedor
                                where prod.IdProducto == id
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
                                }).ToList();

                // Get product images
                lstimagenes = (from img in db.Imagenes_Producto
                               where img.Producto_IdProducto == id
                               select new Imagenes_ProductoTableViewModel
                               {
                                   Producto_IdProducto = img.Producto_IdProducto,
                                   Imagen = img.Imagen
                               }).ToList();

                // Get product reviews
                lstReview = (from rev in db.ReviewProducto
                             join comp in db.comprador on rev.comprador_IdComprador equals comp.IdComprador
                             where rev.Producto_IdProducto == id
                             select new ReviewProductoTableViewModel
                             {
                                 Producto_IdProducto = rev.Producto_IdProducto,
                                 IdReviewProducto = rev.IdReviewProducto,
                                 Comentario = rev.Comentario,
                                 Calificacion = rev.Calificacion,
                                 comprador_IdComprador = rev.comprador_IdComprador,
                                 comprador = comp
                             }).ToList();

                // Get carrito details
                lstCarrito = (from cp in db.Carrito_Producto
                              where cp.Producto_IdProducto == id
                              select new CarritoProductoOriginalTableViewModel
                              {
                                  CarritoDeCompras_IdCarrito = cp.CarritoDeCompras_IdCarrito,
                                  Producto_IdProducto = cp.Producto_IdProducto,
                                  Cantidad = cp.Cantidad
                              }).ToList();

                var carrito = db.CarritoDeCompras.SingleOrDefault(c => c.IdCarrito == sesion.CarritoDeCompras_IdCarrito);
            }

            // Populate the model
            model.Productos = lstProductos;
            model.Imagenes = lstimagenes;
            model.Review = lstReview;
            model.Carritos = lstCarrito;

            // Return the view with the model
            return View(model);
        }


        public void CargarMarca()
        {
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var marca = db.Marca
                               .Select(p => new { p.IdMarca, p.Nombre })
                               .ToList();

                if (marca.Any())
                {
                    ViewBag.marca = new SelectList(marca, "IdMarca", "Nombre");
                }
                else
                {
                    ViewBag.marca = new List<SelectListItem>();
                }
            }
        }


        public void CargarCategoria()
        {
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var categoria = db.Categoria
                               .Select(p => new { p.IdCategoria, p.Nombre })
                               .ToList();

                if (categoria.Any())
                {
                    ViewBag.Categoria = new SelectList(categoria, "IdCategoria", "Nombre");
                }
                else
                {
                    ViewBag.Categoria = new List<SelectListItem>();
                }
            }
        }

        public void CargarTalla()
        {
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var talla = db.Talla.Where(t => t.TipoTalla == "Hombre").ToList();

                if (talla.Any())
                {
                    ViewBag.Talla = new SelectList(talla, "IdTalla", "Numero");
                }
                else
                {
                    ViewBag.Talla = new List<SelectListItem>();
                }
            }
        }


        [HttpPost]
        public ActionResult AddReview(int Producto_IdProducto, string Comentario,int Calificacion)
        {
            var sesion = Sesion.GetSesion() as comprador;
            if (sesion == null)
            {
                // Handle the case where the session is null (e.g., redirect to login)
                return RedirectToAction("Index", "Login");
            }

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var review = new ReviewProducto
                {
                    Producto_IdProducto = Producto_IdProducto,
                    Comentario = Comentario,
                    Calificacion = Calificacion, // Set a default rating or handle rating input
                    comprador_IdComprador = sesion.IdComprador
                };

                db.ReviewProducto.Add(review);
                db.SaveChanges();
            }

            // Redirect back to the product details page
            return RedirectToAction("Index", new { id = Producto_IdProducto });
        }

        [HttpPost]
        public ActionResult AddReviewVendedor(int Vendedor_IdVendedor, string Comentario, int Calificacion)
        {
            var sesion = Sesion.GetSesion() as comprador;
            if (sesion == null)
            {
                // Handle the case where the session is null (e.g., redirect to login)
                return RedirectToAction("Index", "Login");
            }

            try
            {
                using (var db = new ProyectoDiseñoDeAplicacionesEntities())
                {
                    var review = new ReviewVendedor
                    {
                        Vendedor_IdVendedor = Vendedor_IdVendedor,
                        Comentario = Comentario,
                        Calificacion = Calificacion, // Use the value from the form
                        comprador_IdComprador = sesion.IdComprador
                    };

                    db.ReviewVendedor.Add(review);
                    db.SaveChanges();
                }

                // Redirect to a relevant page after saving the review
                return RedirectToAction("ReviewVendedor", "Producto", new { id = Vendedor_IdVendedor });
            }
            catch (Exception ex)
            {
                // Log the exception (you can use a logging framework or simply debug)
                System.Diagnostics.Debug.WriteLine("Error adding review: " + ex.Message);
                // Optionally, return an error view or message
                return View("Error"); // Create an Error view if needed
            }
        }

        [HttpPost]
        public ActionResult AddToCart(int Producto_IdProducto, int Cantidad)
        {
            var sesion = Sesion.GetSesion() as comprador;
            if (sesion == null)
            {
                // Redirect to login if session is null
                return RedirectToAction("Index", "Login");
            }

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                // Retrieve or create the cart for the current user
                var carrito = db.CarritoDeCompras
                    .FirstOrDefault(c => c.IdCarrito == sesion.CarritoDeCompras_IdCarrito);

                if (carrito == null)
                {
                    carrito = new CarritoDeCompras
                    {
                        // Initialize any required properties here
                    };
                    db.CarritoDeCompras.Add(carrito);
                    db.SaveChanges();
                    sesion.CarritoDeCompras_IdCarrito = carrito.IdCarrito; // Update session with the new cart ID
                }

                // Add or update the product in the cart
                var existingItem = db.Carrito_Producto
                    .FirstOrDefault(cp => cp.CarritoDeCompras_IdCarrito == carrito.IdCarrito && cp.Producto_IdProducto == Producto_IdProducto);

                if (existingItem != null)
                {
                    // Update the quantity if the product is already in the cart
                    existingItem.Cantidad += Cantidad;
                }
                else
                {
                    // Add a new item to the cart
                    var newCartItem = new Carrito_Producto
                    {
                        CarritoDeCompras_IdCarrito = carrito.IdCarrito,
                        Producto_IdProducto = Producto_IdProducto,
                        Cantidad = Cantidad,
                    };
                    db.Carrito_Producto.Add(newCartItem);
                }

                db.SaveChanges();
            }

            // Redirect to the cart or another page after adding the product
            return RedirectToAction("Index", "Carrito");
        }

        [HttpGet]
        public ActionResult Edit(int id)
        {
            CargarCategoria();
            CargarMarca();
            CargarTalla();
            var sesion = Sesion.GetSesion() as Vendedor;
            var model = new EditTableViewModel();
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                // Fetch the product
                var producto = db.Producto
                                 .Where(p => p.IdProducto == id)
                                 .Select(p => new ProductoTableViewModel
                                 {
                                     IdProducto = p.IdProducto,
                                     Modelo = p.Modelo,
                                     Precio = p.Precio,
                                     Stock = p.Stock,
                                     Color = p.Color,
                                     Disponibilidad = p.Disponibilidad,
                                     Marca_IdMarca = p.Marca_IdMarca,
                                     Talla_IdTalla = p.Talla_IdTalla,
                                     Categoria_IdCategoria = p.Categoria_IdCategoria,

                                 }).SingleOrDefault();

                // Fetch images associated with the product
                var imagenes = db.Imagenes_Producto
                                 .Where(img => img.Producto_IdProducto == id)
                                 .Select(img => new Imagenes_ProductoTableViewModel
                                 {
                                     Producto_IdProducto = img.Producto_IdProducto,
                                     Imagen = img.Imagen
                                 }).ToList();

                if (producto == null)
                {
                    // Log an error or debug information
                    // For example: log.Error($"Product with ID {id} not found.");
                    return HttpNotFound();
                }

                // Populate the view model
                model.Producto = producto;
                model.Imagenes = imagenes;
                model.VendedorId = sesion.IdVendedor;
            }

            // Return the view with the populated model
            return View(model);
        }

        [HttpPost]
        public ActionResult Edit(EditTableViewModel model, IEnumerable<HttpPostedFileBase> NewImages, string[] DeleteImages)
        {
            CargarCategoria();
            CargarMarca();
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var producto = db.Producto.Find(model.Producto.IdProducto);
                if (producto != null)
                {
                    // Update product properties
                    producto.Modelo = model.Producto.Modelo;
                    producto.Precio = model.Producto.Precio;
                    producto.Stock = model.Producto.Stock;
                    producto.Color = model.Producto.Color;
                    producto.Disponibilidad = model.Producto.Disponibilidad;
                    producto.Marca_IdMarca = model.Producto.Marca_IdMarca;
                    producto.Talla_IdTalla = model.Producto.Talla_IdTalla;
                    producto.Categoria_IdCategoria = model.Producto.Categoria_IdCategoria;


                    // Handle image deletions
                    if (DeleteImages != null && DeleteImages.Any())
                    {
                        var idsToDelete = DeleteImages.Select(int.Parse).ToList();
                        foreach (var id in idsToDelete)
                        {
                            var imageToDelete = db.Imagenes_Producto.Find(id);
                            if (imageToDelete != null)
                            {
                                db.Imagenes_Producto.Remove(imageToDelete);
                            }
                        }
                    }

                    // Handle new images
                    if (NewImages != null && NewImages.Any())
                    {
                        foreach (var file in NewImages)
                        {
                            if (file != null && file.ContentLength > 0)
                            {

                                var imageBytes = ConvertToBytes(file);
                                var newImage = new Imagenes_Producto
                                {
                                    Producto_IdProducto = producto.IdProducto,
                                    Imagen = imageBytes
                                };
                                db.Imagenes_Producto.Add(newImage);
                            }
                        }
                    }

                    // Save changes to the database
                    db.Entry(producto).State = EntityState.Modified;
                    db.SaveChanges();
                }
                else
                {
                    ModelState.AddModelError("", "Product not found.");
                    return View(model);
                }
            }

            return RedirectToAction("Index", "Vendedor");
        }

        // Convertir el archivo subido a un arreglo de bytes
        private byte[] ConvertToBytes(HttpPostedFileBase file)
        {
            byte[] fileBytes = null;
            using (var reader = new System.IO.BinaryReader(file.InputStream))
            {
                fileBytes = reader.ReadBytes(file.ContentLength);
            }
            return fileBytes;
        }


        public ActionResult ReviewVendedor(int id)
        {
            var model = new VendedorConReviewTableViewModel();
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {

                model.Review = (from rev in db.ReviewVendedor
                                join vend in db.Vendedor on rev.Vendedor_IdVendedor equals vend.IdVendedor
                                join comp in db.comprador on rev.comprador_IdComprador equals comp.IdComprador
                                where rev.Vendedor_IdVendedor == id
                                select new ReviewVendedorTableViewModel
                                {
                                    IdReview = rev.IdReview,
                                    Comentario = rev.Comentario,
                                    Calificacion = rev.Calificacion,
                                    Vendedor_IdVendedor = rev.Vendedor_IdVendedor,
                                    comprador_IdComprador = rev.comprador_IdComprador,
                                    comprador = comp,
                                    Vendedor = vend

                                }).ToList();
            }
            return View(model);
        }


        public ActionResult IndexVendedor(int id)
        {
            List<ProductoTableViewModel> lstProductos = new List<ProductoTableViewModel>();
            List<Imagenes_ProductoTableViewModel> lstimagenes = new List<Imagenes_ProductoTableViewModel>();
            List<ReviewProductoTableViewModel> lstReview = new List<ReviewProductoTableViewModel>();
            var model = new ProductoConImagenesTableViewModel();

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                // Get product details
                lstProductos = (from prod in db.Producto
                                join m in db.Marca on prod.Marca_IdMarca equals m.IdMarca
                                join t in db.Talla on prod.Talla_IdTalla equals t.IdTalla
                                join c in db.Categoria on prod.Categoria_IdCategoria equals c.IdCategoria
                                join v in db.Vendedor on prod.Vendedor_IdVendedor equals v.IdVendedor
                                where prod.IdProducto == id
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
                                }).ToList();

                // Get product images
                lstimagenes = (from img in db.Imagenes_Producto
                               where img.Producto_IdProducto == id
                               select new Imagenes_ProductoTableViewModel
                               {
                                   Producto_IdProducto = img.Producto_IdProducto,
                                   Imagen = img.Imagen
                               }).ToList();

                // Get product reviews
                lstReview = (from rev in db.ReviewProducto
                             join comp in db.comprador on rev.comprador_IdComprador equals comp.IdComprador
                             where rev.Producto_IdProducto == id
                             select new ReviewProductoTableViewModel
                             {
                                 Producto_IdProducto = rev.Producto_IdProducto,
                                 IdReviewProducto = rev.IdReviewProducto,
                                 Comentario = rev.Comentario,
                                 Calificacion = rev.Calificacion,
                                 comprador_IdComprador = rev.comprador_IdComprador,
                                 comprador = comp
                             }).ToList();

                // Optionally handle cart details
                // Uncomment and use if needed
                // model.CarritoProducto = (from cp in db.Carrito_Producto
                //                           where cp.Producto_IdProducto == id
                //                           select new Carrito_ProductoTableViewModel
                //                           {
                //                               CarritoDeCompras_IdCarrito = cp.CarritoDeCompras_IdCarrito,
                //                               Producto_IdProducto = cp.Producto_IdProducto,
                //                               Cantidad = cp.Cantidad
                //                           }).ToList();
            }

            // Populate the model
            model.Productos = lstProductos;
            model.Imagenes = lstimagenes;
            model.Review = lstReview;

            // Return the view with the model
            return View(model);
        }

        [HttpPost]
        public JsonResult Delete(int id)
        {
            var sesion = Sesion.GetSesion() as Vendedor;
            if (sesion == null)
            {
                // Handle the case where the session is null (e.g., redirect to login)
                return Json("401"); // Unauthorized
            }

            try
            {
                using (var db = new ProyectoDiseñoDeAplicacionesEntities())
                {
                    // Find the product to delete
                    var producto = db.Producto.Find(id);
                    if (producto != null)
                    {
                        // Remove associated images
                        var imagenes = db.Imagenes_Producto.Where(img => img.Producto_IdProducto == id).ToList();
                        foreach (var img in imagenes)
                        {
                            db.Imagenes_Producto.Remove(img);
                        }

                        // Remove the product
                        db.Producto.Remove(producto);
                        db.SaveChanges();

                        // Return success status
                        return Json("200"); // Success
                    }
                    else
                    {
                        // Handle the case where the product is not found
                        return Json("404"); // Not Found
                    }
                }
            }
            catch (Exception ex)
            {
                // Log the exception and handle the error
                System.Diagnostics.Debug.WriteLine("Error deleting product: " + ex.Message);
                // Optionally, return an error message
                return Json("500"); // Internal Server Error
            }
        }

        [HttpGet]
        public ActionResult Add()
        {
            CargarMarca();
            CargarTalla();
            CargarCategoria();
            var model = new EditTableViewModel();
            return View(model);
        }

        // POST: Producto/Add
        [HttpPost]
        public ActionResult Add(EditTableViewModel model, IEnumerable<HttpPostedFileBase> NewImages)
        {
            if (ModelState.IsValid)
            {
                var sesion = Sesion.GetSesion() as Vendedor;
                using (var db = new ProyectoDiseñoDeAplicacionesEntities())
                {
                    var productoTO = new Producto
                    {
                        Modelo = model.Producto.Modelo,
                        Precio = model.Producto.Precio,
                        Stock = model.Producto.Stock,
                        Color = model.Producto.Color,
                        Disponibilidad = model.Producto.Disponibilidad,
                        Vendedor_IdVendedor = sesion.IdVendedor,
                        Marca_IdMarca = model.Producto.Marca_IdMarca,
                        Talla_IdTalla = model.Producto.Talla_IdTalla,
                        Categoria_IdCategoria = model.Producto.Categoria_IdCategoria,
                        Aprobado = false,
                        Administrador_IdAdministrador = 1,
                    };
                    db.Producto.Add(productoTO);
                    db.SaveChanges();
                    // Handling the image upload
                    if (NewImages != null && NewImages.Any())
                    {
                        foreach (var file in NewImages)
                        {
                            if (file != null && file.ContentLength > 0)
                            {
                                var imagenProducto = new Imagenes_Producto
                                {
                                    Imagen = new byte[file.ContentLength],
                                    Producto = productoTO // Associate it with the productoTO
                                };
                                file.InputStream.Read(imagenProducto.Imagen, 0, file.ContentLength);

                                db.Imagenes_Producto.Add(imagenProducto);
                            }
                        }
                    }
                    db.SaveChanges();

                    return RedirectToAction("Index", "Vendedor");
                }
            }
            return RedirectToAction("Index", "Vendedor");
        }
    }

}




