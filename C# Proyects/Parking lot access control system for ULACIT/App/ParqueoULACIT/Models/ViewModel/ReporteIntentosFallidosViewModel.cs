using System;

namespace ParqueoULACIT.Models.ViewModel
{
    public class ReporteIntentosFallidosViewModel
    {
    public DateTime Fecha { get; set; }
    public TimeSpan Hora { get; set; }
    public string Numero_Placa { get; set; }
    public int ID_Movimiento { get; set; }
    public string TipoVehiculo { get; set; }
    }
}