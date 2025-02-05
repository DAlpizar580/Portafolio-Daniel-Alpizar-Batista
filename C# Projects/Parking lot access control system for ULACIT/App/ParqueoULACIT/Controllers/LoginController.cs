using ParqueoULACIT.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Web;
using System.Web.Mvc;

namespace ParqueoULACIT.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Enter(string txtCorreo, string txtPassword)
        {
            try
            {
                using (var db = new SistemaParqueoEntities())
                {
                    var lst = from u in db.Usuario
                              where u.Correo == txtCorreo && u.Contrasena == txtPassword
                              select u;
                    if (lst.Count() > 0)
                    {
                        Usuario user = lst.First();

                        // Verificar si el usuario está activo
                        if (!user.Estado)
                        {
                            ViewBag.ErrorMessage = "El usuario está inactivo y no puede iniciar sesión.";
                            return View("Index");
                        }

                        // Guardar un valor en la sesión
                        Sesion.SetSesion(user);
                        if (user.Contrasena != "Ulacit123")
                        {

                            if (user.ID_Rol == 1)
                            {
                                return Redirect(Url.Content("~/Admin/Index")); /*ADMIN*/
                            }
                            else if (user.ID_Rol == 2)
                            {
                                return Redirect(Url.Content("~/Login/ElejirParqueo"));/*GUARDA*/
                            }
                            else if (user.ID_Rol == 3)
                            {
                                return Redirect(Url.Content("~/PersonalAdministrativo/Index"));
                            }
                            else if (user.ID_Rol == 4)
                            {
                                return Redirect(Url.Content("~/Estudiante/Index"));/*ESTUDIANTE*/
                            }
                        }
                        else
                        {
                            return Redirect(Url.Content("~/Login/CambioPassword"));
                        }
                    }
                    else
                    {
                        ViewBag.ErrorMessage = "Usuario o contraseña incorrecta";
                        return View("Index");
                    }
                }
            }
            catch (Exception ex)
            {
                ViewBag.ErrorMessage = $"Ocurrió un error. Error: {ex.Message}";
                return View("Index");
            }

            ViewBag.ErrorMessage = "Ocurrió un error";
            return View("Index");
        }

        [HttpGet]
        public ActionResult CambioPassword()
        {
            return View();
        }

        [HttpPost]
        public ActionResult CambioPassword(string txtNewPassword)
        {
            try
            {
                if (string.IsNullOrEmpty(txtNewPassword))
                {
                    ViewBag.ErrorMessage = "La contraseña no puede ser vacía";
                    return View();
                }
                if (txtNewPassword.Equals("Ulacit123"))
                {
                    ViewBag.ErrorMessage = "La contraseña no puede ser igual a la contraseña por defecto";
                    return View();
                }
                var user = Sesion.GetSesion() as Usuario;
                string txtCorreo = user.Correo;
                string txtPassword = user.Contrasena;
                using (var db = new SistemaParqueoEntities())
                {
                    var lst = from u in db.Usuario
                              where u.Correo == txtCorreo && u.Contrasena == txtPassword
                              select u;
                    if (lst.Count() > 0)
                    {
                        Usuario NewUser = lst.First();
                        NewUser.Contrasena = txtNewPassword;
                        db.SaveChanges();
                        return Redirect(Url.Content("~/Login/Index"));
                    }
                    return View();
                }
            }
            catch (Exception ex)
            {
                ViewBag.ErrorMessage = $"Ocurrió un error. Error: {ex.Message}";
                return View();
            }
        }

        [HttpGet]
        public ActionResult ElejirParqueo()
        {
            try
            {
                MostrarParqueo();
                return View();
            }
            catch
            {
                ViewBag.ErrorMessage = "Debes elegir un parqueo";
                return View(); // Devuelve la misma vista para mostrar el mensaje de error
            }
        }

        [HttpGet]
        public ActionResult MostrarParqueo()
        {
            try
            {
                using (var db = new SistemaParqueoEntities())
                {
                    var parqueos = db.Parqueo.Select(p => new { p.ID_Parqueo, p.Nombre }).ToList();
                    ViewBag.Parqueos = new SelectList(parqueos, "ID_Parqueo", "Nombre");
                }
                return View();
            }
            catch
            {
                ViewBag.ErrorMessage = $"Debes elejir un parqueo";
                return View("Index");
            }
        }

        [HttpPost]
        public ActionResult ElejirParqueo(string txtParqueo)
        {
            try
            {
                MostrarParqueo();
                if (string.IsNullOrEmpty(txtParqueo) || txtParqueo == "Selecciona un parqueo")
                {
                    ViewBag.ErrorMessage = "Debes elegir un parqueo";
                    return View();
                }
                using (var db = new SistemaParqueoEntities())
                {
                    var FindParqueo = db.Parqueo.Find(int.Parse(txtParqueo));
                    if (FindParqueo != null)
                    {
                        Parqueo parqueo = FindParqueo;
                        Sesion.SetParqueo(parqueo);
                    }
                    return Redirect(Url.Content("~/GuardiaDeSeguridad/Index"));
                }
            }
            catch
            {
                ViewBag.ErrorMessage = $"Debes elejir un parqueo";
                return View("Index");
            }
        }

        public ActionResult Logout()
        {
            Sesion.SetSesion(null);
            return RedirectToAction("Index", "Login");
        }
    }
}
