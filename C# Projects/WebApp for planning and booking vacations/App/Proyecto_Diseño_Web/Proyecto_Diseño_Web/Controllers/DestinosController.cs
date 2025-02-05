using Proyecto_Diseño_Web.Models;
using Proyecto_Diseño_Web.Models.TableViewModels;
using Proyecto_Diseño_Web.Models.ViewModels;
using System;
using System.Collections.Generic;
using System.Data;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Proyecto_Diseño_Web.Controllers
{
    public class DestinosController : Controller
    {
        // GET: Destinos
        public ActionResult Index(int id)
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var destino = db.Destinos
                                .Where(d => d.IdDestino == id)
                                .Select(d => new DestinosTVM
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
                                }).SingleOrDefault();

                if (destino == null)
                {
                    return HttpNotFound();
                }
                return View(destino);
            }
        }

        [HttpGet]
        public ActionResult Edit(int id, string searchBy, string search)
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var destino = db.Destinos
                                .Where(d => d.IdDestino == id)
                                .Select(d => new DestinosTVM
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
                                }).SingleOrDefault();

                if (destino == null)
                {
                    return HttpNotFound();
                }
                return View(destino);
            }

        }

        [HttpPost]
        public ActionResult Edit(DestinosTVM model, HttpPostedFileBase NewImage)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var destino = db.Destinos.Find(model.IdDestino);
                if (destino != null)
                {
                    destino.Nombre = model.Nombre;
                    destino.Provincia = model.Provincia;
                    destino.Categoria = model.Categoria;
                    destino.Precio_Minimo = model.Precio_Minimo;
                    destino.Precio_Maximo = model.Precio_Maximo;
                    destino.Descripcion = model.Descripcion;
                    destino.Direccion = model.Direccion;

                    if (NewImage != null && NewImage.ContentLength > 0)
                    {
                        destino.Imagen = ConvertToBytes(NewImage);
                    }
                    else
                    {
                        destino.Imagen = destino.Imagen ?? destino.Imagen; 
                    }

                    db.Entry(destino).State = EntityState.Modified;
                    db.SaveChanges();
                }
                else
                {
                    ModelState.AddModelError("", "Destino no encontrado.");
                    return View(model);
                }
            }

            return RedirectToAction("Index", "Admin");
        }

        [HttpGet]
        public ActionResult Crear()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Crear(DestinosTVM model, HttpPostedFileBase NewImage)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var destino = new Destinos
                {
                    Nombre = model.Nombre,
                    Provincia = model.Provincia,
                    Categoria = model.Categoria,
                    Precio_Minimo = model.Precio_Minimo,
                    Precio_Maximo = model.Precio_Maximo,
                    Descripcion = model.Descripcion,
                    Direccion = model.Direccion,
                };

                if (NewImage != null && NewImage.ContentLength > 0)
                {
                    destino.Imagen = ConvertToBytes(NewImage);
                }

                db.Destinos.Add(destino);
                db.SaveChanges();
            }

            return RedirectToAction("Index", "Admin");
        }

        [HttpPost]
        public ActionResult Delete(int id)
        {
            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var destino = db.Destinos.Find(id);
                if (destino != null)
                {
                    db.Destinos.Remove(destino);
                    db.SaveChanges();
                }
            }

            return RedirectToAction("Index", "Admin");
        }


        private byte[] ConvertToBytes(HttpPostedFileBase file)
        {
            using (var stream = file.InputStream)
            {
                var binaryReader = new BinaryReader(stream);
                return binaryReader.ReadBytes(file.ContentLength);
            }
        }
    }
}
