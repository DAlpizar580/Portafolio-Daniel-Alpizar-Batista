using Proyecto_Diseño_Web.Models;
using Proyecto_Diseño_Web.Models.TableViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Proyecto_Diseño_Web.Controllers
{
    public class AdminController : Controller
    {
        public ActionResult Index(string searchBy, string search)
        {
            List<DestinosTVM> lstDestinos = null;
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
            
                // Aplicar el filtro de búsqueda
                if (!string.IsNullOrEmpty(search))
                {
                    if (searchBy == "Nombre")
                    {
                        destinosQuery = destinosQuery.Where(x => x.Nombre.Contains(search));
                    }
                    else if (searchBy == "Provincia")
                    {
                        destinosQuery = destinosQuery.Where(x => x.Provincia.Contains(search));
                    }
                    else if (searchBy == "Categoria")
                    {
                        destinosQuery = destinosQuery.Where(x => x.Categoria.Contains(search));
                    }
                    else if (searchBy == "Precio_Minimo")
                    {
                        if (decimal.TryParse(search, out var precioMin))
                        {
                            destinosQuery = destinosQuery.Where(x => x.Precio_Minimo >= precioMin);
                        }
                    }
                    else if (searchBy == "Precio_Maximo")
                    {
                        if (decimal.TryParse(search, out var precioMax))
                        {
                            destinosQuery = destinosQuery.Where(x => x.Precio_Maximo <= precioMax);
                        }
                    }
                }
                lstDestinos = destinosQuery.OrderBy(x => x.Nombre).ToList();
            }

            return View(lstDestinos);
        }
        
    }
}
