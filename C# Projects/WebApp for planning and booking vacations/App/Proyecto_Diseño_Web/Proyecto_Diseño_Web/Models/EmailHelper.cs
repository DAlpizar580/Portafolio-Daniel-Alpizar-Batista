using System;
using System.Configuration;
using System.Net;
using System.Net.Mail;

namespace Proyecto_Diseño_Web.Helpers
{
    public class EmailHelper
    {
        /// <summary>
        /// Envía un correo electrónico con los parámetros especificados.
        /// </summary>
        /// <param name="destinatario">Correo del destinatario.</param>
        /// <param name="asunto">Asunto del correo.</param>
        /// <param name="mensaje">Mensaje del correo.</param>
        public void EnviarCorreo(string destinatario, string asunto, string mensaje)
        {
            try
            {
                // Obtener credenciales desde el archivo web.config
                string CorreoEnviante = ConfigurationManager.AppSettings["CorreoEnviante"];
                string Contraseña = ConfigurationManager.AppSettings["Contraseña"];

                // Configuración del cliente SMTP
                using (var smtp = new SmtpClient("smtp.gmail.com", 587))
                {
                    smtp.Credentials = new NetworkCredential(CorreoEnviante, Contraseña);
                    smtp.EnableSsl = true;

                    // Configuración del mensaje de correo
                    using (var correo = new MailMessage(CorreoEnviante, destinatario))
                    {
                        correo.Subject = asunto;
                        correo.Body = mensaje;
                        correo.IsBodyHtml = true;
                        smtp.Send(correo);
                    }
                }
            }
            catch (Exception ex)
            {
                throw new Exception($"Error al enviar el correo: {ex.Message}");
            }
        }
    }
}
