using Proyecto_Diseño_Web.Models.TableViewModels;
using Proyecto_Diseño_Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Proyecto_Diseño_Web.Controllers
{
    public class PrincipalMapsController : Controller
    {
        public ActionResult BuscarDestinos(string searchBy, string search)
        {
            List<DestinosTVM> lstDestinos = null;

            try
            {
                using (var db = new Proyecto_Final_Diseño_WebEntities())
                {
                    var destinosQuery = from d in db.Destinos
                                        select new DestinosTVM
                                        {
                                            IdDestino = d.IdDestino,
                                            Nombre = d.Nombre,
                                            Provincia = d.Provincia,
                                            Categoria = d.Categoria,
                                            Precio_Minimo = d.Precio_Minimo,
                                            Precio_Maximo = d.Precio_Maximo,
                                            Descripcion = d.Descripcion,
                                            Direccion = d.Direccion,
                                            Imagen = d.Imagen
                                        };

                    // Agrega filtros si se proporcionan
                    if (!string.IsNullOrEmpty(search))
                    {
                        switch (searchBy)
                        {
                            case "Nombre":
                                destinosQuery = destinosQuery.Where(x => x.Nombre.Contains(search));
                                break;
                            case "Provincia":
                                destinosQuery = destinosQuery.Where(x => x.Provincia.Contains(search));
                                break;
                            case "Categoria":
                                destinosQuery = destinosQuery.Where(x => x.Categoria.Contains(search));
                                break;
                            case "Precio_Minimo":
                                if (decimal.TryParse(search, out var precioMin))
                                {
                                    destinosQuery = destinosQuery.Where(x => x.Precio_Minimo >= precioMin);
                                }
                                break;
                            case "Precio_Maximo":
                                if (decimal.TryParse(search, out var precioMax))
                                {
                                    destinosQuery = destinosQuery.Where(x => x.Precio_Maximo <= precioMax);
                                }
                                break;
                        }
                    }

                    // Asigna resultados a lstDestinos
                    lstDestinos = destinosQuery.OrderBy(x => x.Nombre).ToList();
                }
            }
            catch (Exception ex)
            {
                // Manejar errores y notificar a la vista
                ViewBag.ErrorMessage = "Ocurrió un error al buscar los destinos: " + ex.Message;
                lstDestinos = new List<DestinosTVM>(); // Inicializa la lista como vacía
            }

            // Si no se encuentran resultados, enviar mensaje
            if (lstDestinos == null || !lstDestinos.Any())
            {
                ViewBag.ErrorMessage = "No se encontraron resultados para la búsqueda.";
            }

            return View(lstDestinos);
        }
    }
}
