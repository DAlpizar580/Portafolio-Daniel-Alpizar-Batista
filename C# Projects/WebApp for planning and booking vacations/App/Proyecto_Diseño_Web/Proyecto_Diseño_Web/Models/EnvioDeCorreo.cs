using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Net.Mail;
using System.Net;
using System.Web;
using System.Web.Mvc;

namespace Proyecto_Diseño_Web.Models
{
    public class EnvioDeCorreo
    {
        public void EnviarCorreo()
        {
            try
            {
                // Leer los datos de conexión desde el archivo de configuración (web.config)
                string CorreoEnviante = ConfigurationManager.AppSettings["CorreoEnviante"];
                string Contraseña = ConfigurationManager.AppSettings["Contraseña"];

                // Crear el objeto de mensaje de correo
                MailMessage correo = new MailMessage();
                SmtpClient smtpCliente = new SmtpClient();

                // Limpiar destinatarios y archivos adjuntos (por si se reutiliza)
                correo.To.Clear();
                correo.Attachments.Clear();

                // Asunto y cuerpo del correo
                correo.Subject = "Nuevo Paquete de Viaje";
                correo.Body = "Se ha añadido un nuevo paquete de viaje, no te pierdas de esta promo y adquierelo ahora mismo";
                correo.IsBodyHtml = true;

                // Destinatario
                correo.To.Add("dalpizar580@gmail.com");

                // Remitente
                correo.From = new MailAddress(CorreoEnviante);

                // Configuración del cliente SMTP
                smtpCliente.Credentials = new NetworkCredential(CorreoEnviante, Contraseña);
                smtpCliente.Host = "smtp.gmail.com";  // Corregir el host SMTP
                smtpCliente.Port = 587;  // Puerto adecuado para Gmail
                smtpCliente.EnableSsl = true;  // Habilitar SSL para seguridad

                // Enviar el correo
                smtpCliente.Send(correo);
            }
            catch (Exception ex)
            {
                // Enviar mensaje de error a la vista
                throw new Exception("Error - " + ex.Message);
            }
        }
    }
}