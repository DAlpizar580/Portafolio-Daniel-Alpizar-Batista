using Microsoft.Ajax.Utilities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models
{
    public class Sesion
    {
        private const string SesionKey = "Sesion";

        public static void SetSesion(object value)
        {
            HttpContext.Current.Session[SesionKey] = value;
        }

        public static object GetSesion()
        {
            return HttpContext.Current.Session[SesionKey];
        }

        //Acceder  a las variable de sesion:
        //var comprador = Sesion.GetSesion() as Administrador;  Aqui se puede cambiar administrador por el nombre de la clase que se necesite
    }
}