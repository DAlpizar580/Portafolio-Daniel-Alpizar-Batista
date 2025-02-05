using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Proyecto_Diseño_Web.Models;
using System.Web.Mvc;
using System.Data.SqlClient;
using Proyecto_Diseño_Web.Models.ViewModels;
using Proyecto_Diseño_Web.Helpers;
using System.Net.Http;
using System.Threading.Tasks;
using Google.Apis.Auth;
using Newtonsoft.Json;
using Google.Apis.Auth.OAuth2;
using System.Net.Http.Headers;
using System.Data.Entity.Validation;



namespace Proyecto_Diseño_Web.Controllers
{

    public class UsuarioController : Controller
    {
        //Empieza lo de Google
        private readonly string ClientId = "612104623554-0nas24s1l3g4fr13796jj0hc1u8j2uv0.apps.googleusercontent.com";
        private readonly string ClientSecret = "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";

        [HttpGet]
        public ActionResult SolicitarCedulaGoogle()
        {
            return View();
        }

        // Método para recibir la cédula e iniciar el proceso de login con Google
        [HttpPost]
        public ActionResult SolicitarCedulaGoogle(string cedula)
        {
            if (string.IsNullOrEmpty(cedula))
            {
                ViewBag.Error = "Por favor, ingrese su cédula.";
                return View();
            }

            // Almacenar la cédula en la sesión
            Session["CedulaGoogle"] = cedula;

            // Redirigir a la acción que maneja el login con Google
            return RedirectToAction("LoginGoogle");
        }
        public ActionResult LoginGoogle()
        {
            var googleAuthUrl = $"https://accounts.google.com/o/oauth2/v2/auth?client_id={ClientId}&redirect_uri=https://localhost:44304/Usuario/LoginGoogleCallback&response_type=code&scope=email profile";
            return Redirect(googleAuthUrl);
        }

        // Callback después de la autenticación con Google
        [HttpGet]
        public async Task<ActionResult> LoginGoogleCallback(string code)
        {
            if (string.IsNullOrEmpty(code))
            {
                return RedirectToAction("Login");
            }

            var token = await GetGoogleTokenAsync(code);
            var userInfo = await GetGoogleUserInfoAsync(token);
            var cedula = Session["CedulaGoogle"] as string;

            var dbp = new Proyecto_Final_Diseño_WebEntities();
            decimal newId = (dbp.Usuarios.Any() ? dbp.Usuarios.Max(u => u.Id) : 0) + 1;

            // Aquí puedes guardar los datos del usuario en la base de datos si es necesario
            var usuario = new Usuarios
            {
                Id = newId,
                Cedula = cedula,
                Nombre = userInfo.GivenName,
                Apellidos = userInfo.FamilyName,
                Correo = userInfo.Email,
                Contraseña = "",
                Rol = "U" // Usuario por defecto
            };

            try
            {
                using (var db = new Proyecto_Final_Diseño_WebEntities())
                {
                    db.Usuarios.Add(usuario);
                    db.SaveChanges();
                }
            }
            catch (DbEntityValidationException ex)
            {
                List<string> validationErrors = new List<string>();

                // Recorrer todos los errores de validación y agregar los mensajes a la lista
                foreach (var validationError in ex.EntityValidationErrors)
                {
                    foreach (var error in validationError.ValidationErrors)
                    {
                        validationErrors.Add($"Property: {error.PropertyName}, Error: {error.ErrorMessage}");
                    }
                }

                // Pasar los errores a la vista
                ViewBag.ValidationErrors = validationErrors;

                ViewBag.Error = "Hubo un error al guardar los datos. Por favor, revisa los detalles.";

                return View("CompletarRegistro", usuario);
            }

            return View("Login");

        }

        // Método para obtener el token de acceso
        private async Task<string> GetGoogleTokenAsync(string code)
        {
            var url = "https://oauth2.googleapis.com/token";
            var client = new HttpClient();
            var content = new FormUrlEncodedContent(new[]
            {
                new KeyValuePair<string, string>("code", code),
                new KeyValuePair<string, string>("client_id", ClientId),
                new KeyValuePair<string, string>("client_secret", ClientSecret),
                new KeyValuePair<string, string>("redirect_uri", "https://localhost:44304/Usuario/LoginGoogleCallback"),
                new KeyValuePair<string, string>("grant_type", "authorization_code")
            });

            var response = await client.PostAsync(url, content);
            var responseBody = await response.Content.ReadAsStringAsync();
            var tokenResponse = JsonConvert.DeserializeObject<dynamic>(responseBody);
            return tokenResponse.access_token;
        }

        // Método para obtener los datos del usuario de Google
        private async Task<GoogleUserInfo> GetGoogleUserInfoAsync(string token)
        {
            var client = new HttpClient();
            client.DefaultRequestHeaders.Authorization = new System.Net.Http.Headers.AuthenticationHeaderValue("Bearer", token);

            var response = await client.GetStringAsync("https://www.googleapis.com/oauth2/v3/userinfo");
            var userInfo = JsonConvert.DeserializeObject<GoogleUserInfo>(response);
            return userInfo;
        }

        // Modelo para los datos de usuario de Google
        public class GoogleUserInfo
        {
            public string Email { get; set; }
            public string GivenName { get; set; }
            public string FamilyName { get; set; }
        }

        // Acción para completar el registro con más datos
        public ActionResult CompletarRegistro()
        {
            return View();
        }

        [HttpPost]
        public ActionResult CompletarRegistro(RegistroViewModel model)
        {
            // Procesa los datos adicionales si es necesario
            // Guardar los datos completos del usuario en la base de datos
            return RedirectToAction("Perfil");
        }
    
        //Termina lo de google

        // GET: Usuario/Login
        [HttpGet]
        public ActionResult Login()
        {
            return View();
        }

        // POST: Usuario/Verify
        [HttpPost]
        public ActionResult Verify(LoginViewModel model)
        {
            if (model == null || string.IsNullOrEmpty(model.Correo) || string.IsNullOrEmpty(model.Contraseña))
            {
                ViewBag.Error = "Por favor, complete todos los campos.";
                return View("Login");
            }

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var usuario = db.Usuarios
                                .Where(u => u.Correo == model.Correo && u.Contraseña == model.Contraseña)
                                .FirstOrDefault();
                Session["CorreoRecuperacion"] = model.Correo;

                if (usuario != null)
                {
                    if (usuario.Rol == "A")
                    {
                        // Almacenar el ID del usuario en la sesión
                        Session["UserId"] = usuario.Id;

                        return RedirectToAction("Index", "Admin");
                    }
                    else 
                    {
                        // Almacenar el ID del usuario en la sesión
                        Session["UserId"] = usuario.Id;

                        return RedirectToAction("Index", "Home");
                    }
                    
                }     
                else
                {
                    ViewBag.Error = "Correo o contraseña incorrectos.";
                    return View("Login");
                }
            }
        }


        // GET: Usuario/Registro
        [HttpGet]
        public ActionResult Registro()
        {
            return View();
        }

        // POST: Usuario/Registro
        [HttpPost]
        public ActionResult Registro(RegistroViewModel model)
        {
            if (ModelState.IsValid)
            {
                // Verificar si el correo ya está registrado
                using (var db = new Proyecto_Final_Diseño_WebEntities())
                {
                    var existingUser = db.Usuarios.FirstOrDefault(u => u.Correo == model.Correo);
                    if (existingUser != null)
                    {
                        ViewBag.Error = "El correo ya está registrado.";
                        return View(model);
                    }


                    // Get the highest ID and add 1
                    decimal newId = (db.Usuarios.Any() ? db.Usuarios.Max(u => u.Id) : 0) + 1;

                    // Crear nuevo usuario
                    var usuarios = new Usuarios
                    {
                        Id = newId,
                        Nombre = model.Nombre,
                        Apellidos = model.Apellidos,
                        Nombre_Completo = model.Nombre+" "+model.Apellidos ,
                        Cedula = model.Cedula,
                        Correo = model.Correo,
                        Telefono = model.Telefono,
                        Fecha_de_nacimiento = model.FechaDeNacimiento,
                        Genero = model.Genero,
                        Rol = "U",
                        Preferencias_de_Viaje = "Sin Preferencias",
                        Contraseña = model.Contraseña // Se guarda la contraseña tal cual

                    };

                    decimal newItId = (db.Itinerarios.Any() ? db.Itinerarios.Max(u => u.IdItinerario) : 0) + 1;

                    var itinerario = new Itinerarios
                    {
                        IdItinerario = newItId,
                        Nombre = "Nombre Itinerario",
                        Usuarios_Id = newId
                        

                    };

                    db.Usuarios.Add(usuarios);
                    db.Itinerarios.Add(itinerario);
                    db.SaveChanges();

                    // Redirigir al login
                    return RedirectToAction("Login", "Usuario");
                }
            }

            // Si el modelo no es válido, vuelve a mostrar el formulario
            ViewBag.Error = "Por favor, complete todos los campos correctamente.";
            return View(model);
        }


        // GET: Usuario/Perfil
        public ActionResult Perfil()
        {
            if (Session["UserId"] == null)
            {
                // Si no hay sesión activa, redirigir al login
                return RedirectToAction("Login", "Usuario");
            }

            // Convertir el ID al tipo correcto
            var userId = Convert.ToDecimal(Session["UserId"]); // Cambiar a decimal si es necesario

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var usuario = db.Usuarios.FirstOrDefault(u => u.Id == userId);

                if (usuario == null)
                    return HttpNotFound();

                var model = new PerfilViewModel
                {
                    Nombre = usuario.Nombre,
                    Apellidos = usuario.Apellidos,
                    Correo = usuario.Correo,
                    //Telefono = usuario.Telefono,
                    FechaDeNacimiento = usuario.Fecha_de_nacimiento,
                    Genero = usuario.Genero,
                    PreferenciasDeViaje = usuario.Preferencias_de_Viaje,
                    Reservas = db.Reservas.Where(r => r.Usuarios_Id == userId).ToList()

                };

                return View(model);
            }
        }


        [HttpPost]
        public ActionResult EditarPreferencias(string preferencias)
        {
            if (Session["UserId"] == null)
            {
                // Si no hay sesión activa, redirigir al login
                return RedirectToAction("Login", "Usuario");
            }

            var userId = Convert.ToDecimal(Session["UserId"]); // Convertimos el ID al tipo correcto

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                var usuario = db.Usuarios.FirstOrDefault(u => u.Id == userId);

                if (usuario == null)
                    return HttpNotFound();

                // Actualizamos las preferencias de viaje
                usuario.Preferencias_de_Viaje = preferencias;
                db.SaveChanges();

                // Redirigir al perfil para ver los cambios
                return RedirectToAction("Perfil");
            }
        }

        public ActionResult RecuperarContrasena()
        {
            return View();
        }

        public ActionResult IngresarCodigoRecuperacion()
        {
            return View();
        }


        [HttpPost]
        public ActionResult EnviarCodigo(RecuperacionViewModel model)
        {
            var db = new Proyecto_Final_Diseño_WebEntities();

            var usuario = db.Usuarios.FirstOrDefault(u => u.Correo == model.Correo && u.Cedula == model.Cedula);

            if (usuario == null)
            {
                ViewBag.Error = "No se encontró un usuario con esos datos.";
                return View(model);
            }

            // Generar el código de recuperación
            Random random = new Random();
            model.CodigoRecuperacion = random.Next(100000, 999999); // Código de 6 dígitos

            // Establecer fecha de expiración para el código (por ejemplo, 15 minutos)
            model.FechaExpiracionCodigo = DateTime.Now.AddMinutes(15);

            // Enviar el correo con el código de recuperación
            var correo = new EmailHelper();
            correo.EnviarCorreo(model.Correo, "Código de Recuperación", $"Tu código de recuperación es: {model.CodigoRecuperacion}");

            // Almacenar el código y la fecha en la sesión
            Session["CodigoRecuperacion"] = model.CodigoRecuperacion;
            Session["CorreoRecuperacion"] = model.Correo;
            Session["FechaExpiracionCodigo"] = model.FechaExpiracionCodigo;

            ViewBag.Mensaje = "Se ha enviado un código de recuperación a tu correo.";
            return RedirectToAction("IngresarCodigoRecuperacion");
        }

        [HttpPost]
        public ActionResult VerificarCodigo(RecuperacionViewModel model)
        {
            // Recuperar el código y la fecha de expiración desde la sesión
            var codigoGuardado = Session["CodigoRecuperacion"];
            var fechaExpiracionGuardada = Session["FechaExpiracionCodigo"];

            if (codigoGuardado == null || fechaExpiracionGuardada == null)
            {
                ViewBag.Error = "La sesión de recuperación ha expirado. Intenta nuevamente.";
                return View(model);
            }

            // Verificar si el código es correcto y si no ha expirado
            if ((int)codigoGuardado == model.CodigoRecuperacion && (DateTime)fechaExpiracionGuardada > DateTime.Now)
            {
                return RedirectToAction("CambiarContraseña", new { correo = Session["CorreoRecuperacion"].ToString() });

            }
            else
            {
                ViewBag.Error = "El código es incorrecto o ha expirado.";
                return View(model);
            }
        }

        public ActionResult CambiarContraseña(string correo)
        {
            // Crear el modelo y pasar el correo
            var model = new CambiarContraseñaViewModel
            {
                Correo = correo
            };

            return View(model);
        }


        [HttpPost]
        public ActionResult CambiarContraseña(CambiarContraseñaViewModel model)
        {
            var db = new Proyecto_Final_Diseño_WebEntities();

            // Verificar que las contraseñas coinciden
            if (model.NuevaContraseña != model.ConfirmarContraseña)
            {
                ViewBag.Error = "Las contraseñas no coinciden.";
                return View(model);
            }

            // Buscar al usuario por correo
            var usuario = db.Usuarios.FirstOrDefault(u => u.Correo == model.Correo);

            if (usuario == null)
            {
                return HttpNotFound();
            }

            // Actualizar la contraseña
            usuario.Contraseña = model.NuevaContraseña;
            db.SaveChanges();

            // Redirigir al login
            return RedirectToAction("Login");
        }

        public ActionResult Logout()
        {
            // Limpiar toda la sesión
            Session.Clear();
            Session.Abandon();

            // Redirigir al login
            return RedirectToAction("Login");
        }

        [HttpPost]
        public ActionResult EliminarReservacion(int reservacionId)
        {
            if (Session["UserId"] == null)
            {
                // Si no hay sesión activa, redirigir al login
                return RedirectToAction("Login", "Usuario");
            }

            // Obtener el ID del usuario actual desde la sesión
            var userId = Convert.ToDecimal(Session["UserId"]);

            using (var db = new Proyecto_Final_Diseño_WebEntities())
            {
                // Buscar la reservación por ID
                var reservacion = db.Reservas.FirstOrDefault(r => r.IdReserva == reservacionId);

                if (reservacion == null)
                {
                    // Si no se encuentra la reservación, redirigir al perfil
                    TempData["Error"] = "No se encontró la reservación.";
                    return RedirectToAction("Perfil");
                }

                // Verificar que la reservación pertenece al usuario actual
                if (reservacion.Usuarios_Id != userId)
                {
                    TempData["Error"] = "No tienes permiso para eliminar esta reservación.";
                    return RedirectToAction("Perfil");
                }

                // Eliminar la reservación
                db.Reservas.Remove(reservacion);
                db.SaveChanges();

                // Enviar correo notificando la eliminación
                var emailHelper = new EmailHelperReservacionEliminada();
                emailHelper.EnviarCorreoDeEliminacion(Session["CorreoRecuperacion"].ToString(), reservacion.Tipo_de_servicio, (DateTime)reservacion.Fecha_de_inicio);

                TempData["Success"] = "Reservación eliminada con éxito.";
                // Redirigir al perfil del usuario
                return RedirectToAction("Perfil");
            }
        }






    }


}