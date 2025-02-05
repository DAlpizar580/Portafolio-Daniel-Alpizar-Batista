using System;
using System.ComponentModel.DataAnnotations;
using System.Text.RegularExpressions;

namespace ParqueoULACIT.Attributes
{
    public class EmailTrimAttribute : ValidationAttribute
    {
        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            if (value == null)
            {
                return new ValidationResult("Debe ingresar un correo electrónico.");
            }

            // Elimina los espacios en blanco del valor
            string email = value.ToString().Trim();

            // Patrón para un correo electrónico válido
            string emailRegex = @"^[^@\s]+@[^@\s]+\.[^@\s]+$";
            if (!Regex.IsMatch(email, emailRegex))
            {
                return new ValidationResult("Debe ingresar un correo electrónico válido.");
            }

            return ValidationResult.Success;
        }
    }
}
