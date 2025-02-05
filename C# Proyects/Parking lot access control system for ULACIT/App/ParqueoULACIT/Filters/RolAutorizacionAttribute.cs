using ParqueoULACIT.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ParqueoULACIT.Filters
{
    public class RolAutorizacionAttribute : AuthorizeAttribute
    {
        private readonly int[] _rolesPermitidos;

        public RolAutorizacionAttribute(params int[] roles)
        {
            _rolesPermitidos = roles;
        }

        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            var usuario = Sesion.GetSesion() as Usuario;

            // Si no hay usuario logueado, no autorizar
            if (usuario == null)
                return false;

            // Validar si el rol del usuario está permitido
            return Array.Exists(_rolesPermitidos, rol => rol == usuario.ID_Rol);
        }

        protected override void HandleUnauthorizedRequest(AuthorizationContext filterContext)
        {
            var usuario = Sesion.GetSesion() as Usuario;

            if (usuario == null)
            {
                // Si no hay usuario logueado, redirige al inicio de sesión
                filterContext.Result = new RedirectToRouteResult(
                    new System.Web.Routing.RouteValueDictionary(
                        new { controller = "Login", action = "Index" }
                    )
                );
            }
            else
            {
                // Si el usuario no tiene el rol requerido, redirige a una página de acceso denegado
                filterContext.Result = new RedirectToRouteResult(
                    new System.Web.Routing.RouteValueDictionary(
                        new { controller = "Home", action = "AccesoDenegado" }
                    )
                );
            }
        }

    }
}