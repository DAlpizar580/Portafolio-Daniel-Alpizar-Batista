using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ParqueoULACIT.Models
{
    public class Sesion
    {
        private const string SesionKey = "Sesion";
        private const string ParqueoKey = "SesionParqueo";

        public static void SetSesion(object value)
        {
            HttpContext.Current.Session[SesionKey] = value;
        }

        public static object GetSesion()
        {
            return HttpContext.Current.Session[SesionKey];
        }
        public static void SetParqueo(object value)
        {
            HttpContext.Current.Session[ParqueoKey] = value;
        }

        public static object GetParqueo()
        {
            return HttpContext.Current.Session[ParqueoKey];
        }

        //Acceder  a las variable de sesion:
        //Sesion del Usuario: var user = Sesion.GetSesion() as Usuario;
        //Sesion del Parqueo: var parqueo = Sesion.GetParqueo() as Parqueo;
    }
}