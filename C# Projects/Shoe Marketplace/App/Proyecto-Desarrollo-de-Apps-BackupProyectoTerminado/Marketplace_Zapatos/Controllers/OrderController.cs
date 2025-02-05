using Marketplace_Zapatos.Models.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Mail;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Marketplace_Zapatos.Models;
using Marketplace_Zapatos.Models.TableViewModels;

namespace Marketplace_Zapatos.Controllers
{
    public class OrderController : Controller
    {
        private int idComprador;
        public ActionResult Index()
        {
            var sesion = Sesion.GetSesion() as comprador;
            this.idComprador = sesion.IdComprador;
            var productosEnCarrito = new List<Carrito_ProductoTableViewModel>();
            var carrito = new CarritoDeCompras();
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                productosEnCarrito = (from cp in db.Carrito_Producto
                                          join p in db.Producto on cp.Producto_IdProducto equals p.IdProducto
                                          join m in db.Marca on p.Marca_IdMarca equals m.IdMarca
                                          join t in db.Talla on p.Talla_IdTalla equals t.IdTalla
                                          where cp.CarritoDeCompras_IdCarrito == sesion.CarritoDeCompras_IdCarrito
                                          select new Carrito_ProductoTableViewModel
                                          {
                                              Modelo = p.Modelo,
                                              Cantidad = cp.Cantidad,
                                              Producto_IdProducto = cp.Producto_IdProducto,
                                              precio = p.Precio,
                                              Vendedor = p.Vendedor,
                                              Marca = m,
                                              Talla = t
                                          }).ToList();

                int totalPrecioCarrito = productosEnCarrito.Sum(producto => (int)(producto.precio * producto.Cantidad));

                carrito = db.CarritoDeCompras.SingleOrDefault(c => c.IdCarrito == sesion.CarritoDeCompras_IdCarrito);
            }

            var model = new FinalizarCompraViewModel
            {
                Productos = productosEnCarrito,
                Carrito = carrito,
                CompradorID = sesion.IdComprador
            };
            MostrarDirecciones();
            MostrarTarjetasDeCredito();
            return View(model);
        }

        [HttpPost]
        public ActionResult FinalizarCompra(OrderViewModel model, List<Carrito_ProductoTableViewModel> Productos)
        {
            if (!ModelState.IsValid)
            {
                MostrarDirecciones();
                MostrarTarjetasDeCredito();
                return RedirectToAction("Index", "Order");
            }

            var sesion = Sesion.GetSesion() as comprador;
            Console.WriteLine(sesion.IdComprador);
            OrdenOriginalViewModel orden = new OrdenOriginalViewModel
            {
                MontoTotal = model.MontoTotal,
                Estado = "Pendiente",
                PrecioEnvio = model.PrecioEnvio,
                comprador_IdComprador = model.CompradorID,
                FormaDePago = model.NumeroTarjeta
            };

            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                db.SaveChanges(); 
                var nuevaOrden = new Orden
                {
                    MontoTotal = orden.MontoTotal,
                    Estado = orden.Estado,
                    PrecioEnvio = orden.PrecioEnvio,
                    comprador_IdComprador = orden.comprador_IdComprador,
                    FormaDePago = orden.FormaDePago
                };

                db.Orden.Add(nuevaOrden);
                db.SaveChanges(); 


                var ordenTO = db.Orden.OrderByDescending(o => o.IdOrden).FirstOrDefault();
                Console.WriteLine(ordenTO.IdOrden);
                int ordenId = ordenTO.IdOrden;


                var productosEnCarrito = (from cp in db.Carrito_Producto
                                          join p in db.Producto on cp.Producto_IdProducto equals p.IdProducto
                                          join m in db.Marca on p.Marca_IdMarca equals m.IdMarca
                                          join t in db.Talla on p.Talla_IdTalla equals t.IdTalla
                                          join v in db.Vendedor on p.Vendedor_IdVendedor equals v.IdVendedor
                                          where cp.CarritoDeCompras_IdCarrito == sesion.CarritoDeCompras_IdCarrito
                                          select new Carrito_ProductoTableViewModel
                                          {
                                              Modelo = p.Modelo,
                                              Cantidad = cp.Cantidad,
                                              Producto_IdProducto = cp.Producto_IdProducto,
                                              precio = p.Precio,
                                              Vendedor = p.Vendedor,
                                              NombreVendedor = v.Nombre,
                                              Marca = m,
                                              Talla = t
                                          }).ToList();

                Console.WriteLine(productosEnCarrito.Count);
                foreach (var producto in productosEnCarrito)
                {

                    var productoOrden = new Producto_Orden
                    {
                        Producto_IdProducto = producto.Producto_IdProducto,
                        Orden_IdOrden = ordenId,
                        Cantidad = producto.Cantidad
                    };

                    db.Producto_Orden.Add(productoOrden);
                }


                foreach (var producto in productosEnCarrito)
                {
                    var productoEnCarrito = db.Carrito_Producto
                        .FirstOrDefault(cp => cp.CarritoDeCompras_IdCarrito == sesion.CarritoDeCompras_IdCarrito
                         && cp.Producto_IdProducto == producto.Producto_IdProducto);

                    if (productoEnCarrito != null)
                    {
                        db.Carrito_Producto.Remove(productoEnCarrito);
                    }
                }
                string vendedores = "vacio";
                var direccionTO = db.DireccionComprador.Find(model.DireccionID);

                var nuevoHistorial = new HistorialPedidos
                {
                    Vendedor = vendedores,
                    DireccionEnvio = direccionTO.Descripcion, 
                    Fecha = DateTime.Now,
                    MetodoDePago = model.NumeroTarjeta, 
                    Orden_IdOrden = ordenId
                };

                db.HistorialPedidos.Add(nuevoHistorial);

                db.SaveChanges(); 


                string destinatario = sesion.Correo; 
                string asunto = "Confirmación de Compra";
                string cuerpo = $"<h1>Gracias por tu compra!</h1>" +
                                $"<p>Tu orden con ID {ordenId} ha sido procesada exitosamente.</p>" +
                                $"<p>Resumen de la compra:</p>" +
                                $"<p>Total: ₡{model.MontoTotal}</p>" +
                                $"<p>Envío: ₡{model.PrecioEnvio}</p>" +
                                $"<p>Estado: Pendiente</p>";
            }

            return RedirectToAction("Index", "PincipalComprador");
        }

        private void EnviarCorreoConfirmacion(string destinatario, string asunto, string cuerpo)
        {
            var smtpClient = new SmtpClient("smtp.tuservidor.com") // Cambia por tu servidor SMTP
            {
                Port = 587, // O el puerto que uses
                Credentials = new NetworkCredential("tuemail@tudominio.com", "tucontraseña"), // Cambia por tus credenciales
                EnableSsl = true,
            };

            var mailMessage = new MailMessage
            {
                From = new MailAddress("tuemail@tudominio.com"), // Cambia por tu dirección de correo
                Subject = asunto,
                Body = cuerpo,
                IsBodyHtml = true,
            };

            mailMessage.To.Add(destinatario);

            try
            {
                smtpClient.Send(mailMessage);
            }
            catch (Exception ex)
            {
                // Manejar excepciones si es necesario
                Console.WriteLine("No se pudo enviar el correo: " + ex.Message);
            }
        }


        [HttpGet]
        public ActionResult AddTarjetaDeCredito()
        {
            return View();
        }
        [HttpPost]
        public ActionResult AddTarjetaDeCredito(TarjetaDeCreditoViewModel model)
        {
            if (!ModelState.IsValid) return View(model);
            var sesion = Sesion.GetSesion() as comprador;
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                TarjetaCredito tarjetaTO = new TarjetaCredito();

                tarjetaTO.NombreTarjetahabiente = model.NombreTarjetahabiente;
                tarjetaTO.FechaVencimiento = model.FechaVencimiento;
                tarjetaTO.NumeroTarjeta = model.NumeroTarjeta;
                tarjetaTO.CVV = model.CVV;

                tarjetaTO.comprador_IdComprador = sesion.IdComprador;

                db.TarjetaCredito.Add(tarjetaTO);
                db.SaveChanges();
            }

            return Redirect(Url.Content("~/Perfil/EditComprador"));
        }

        [HttpGet]
        public ActionResult AddDireccion()
        {
            return View();
        }

        [HttpPost]
        public ActionResult AddDireccion(DireccionCompradorViewModel model)
        {
            if (!ModelState.IsValid) return View(model);
            var sesion = Sesion.GetSesion() as comprador;
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                DireccionComprador direccionTO = new DireccionComprador();

                direccionTO.Ciudad = model.Ciudad;
                direccionTO.Pais = model.Pais;
                direccionTO.CodigoPostal = model.CodigoPostal;
                direccionTO.Descripcion = model.Descripcion;

                direccionTO.comprador_IdComprador = sesion.IdComprador;

                db.DireccionComprador.Add(direccionTO);
                db.SaveChanges();
            }

            return Redirect(Url.Content("~/Perfil/EditComprador"));
        }

        private void MostrarTarjetasDeCredito()
        {
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var tarjetas = db.TarjetaCredito.Where(t => t.comprador_IdComprador == this.idComprador).ToList();
                if (tarjetas.Any())
                {
                    ViewBag.Tarjetas = new SelectList(tarjetas, "NumeroTarjeta", "NumeroTarjeta");
                }
                else
                {
                    ViewBag.Tarjetas = new SelectList(Enumerable.Empty<SelectListItem>(), "ValueField", "TextField");
                }
            }
        }

        private void MostrarDirecciones()
        {
            using (var db = new ProyectoDiseñoDeAplicacionesEntities())
            {
                var direcciones = db.DireccionComprador.Where(d => d.comprador_IdComprador == this.idComprador).ToList();
                if (direcciones.Any())
                {
                    ViewBag.Direcciones = new SelectList(direcciones, "IdDirreccion", "Descripcion");
                }
                else
                {
                    ViewBag.Direcciones = new SelectList(Enumerable.Empty<SelectListItem>(), "ValueField", "TextField");
                }
            }
        }
    }
}
