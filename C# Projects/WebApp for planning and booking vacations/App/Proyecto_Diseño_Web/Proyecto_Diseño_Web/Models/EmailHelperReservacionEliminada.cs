using System;
using System.Configuration;
using System.Net;
using System.Net.Mail;

namespace Proyecto_Diseño_Web.Helpers
{
    public class EmailHelperReservacionEliminada
    {
        /// <summary>
        /// Envía un correo al usuario notificándole la eliminación de una reservación.
        /// </summary>
        /// <param name="destinatario">Correo del destinatario.</param>
        /// <param name="nombreReservacion">Nombre de la reservación eliminada.</param>
        /// <param name="fechaReservacion">Fecha de la reservación eliminada.</param>
        public void EnviarCorreoDeEliminacion(string destinatario, string nombreReservacion, DateTime fechaReservacion)
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
                        correo.Subject = "Confirmación de eliminación de reservación";
                        correo.Body = $"<h2>Estimado usuario,</h2>" +
                                      $"<p>La reservación con el nombre <strong>{nombreReservacion}</strong> ha sido eliminada exitosamente.</p>" +
                                      $"<p>Fecha de la reservación: {fechaReservacion.ToShortDateString()}</p>" +
                                      "<p>Si no solicitaste esta eliminación, por favor contacta con soporte.</p>" +
                                      "<p>Saludos,<br/>El equipo de Reservas</p>";
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

        public void EnviarCorreoDeCreacion(string destinatario, string nombreReservacion, DateTime fechaReservacion)
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
                        correo.Subject = "Confirmación de reservación";
                        correo.Body = $"<h2>Estimado usuario,</h2>" +
                                      $"<p>La reservación con el nombre <strong>{nombreReservacion}</strong> ha sido creada exitosamente.</p>" +
                                      $"<p>Fecha de la reservación: {fechaReservacion.ToShortDateString()}</p>" +
                                      "<p>Si no solicitaste esta reservacion, por favor contacta con soporte.</p>" +
                                      "<p>Saludos,<br/>El equipo de Reservas</p>";
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