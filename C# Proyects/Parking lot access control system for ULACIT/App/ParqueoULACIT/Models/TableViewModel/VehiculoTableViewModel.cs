using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ParqueoULACIT.Models.TableViewModel
{
    public class VehiculoTableViewModel
    {
        public int ID_Vehiculo { get; set; }
        public string Marca { get; set; }
        public string Color { get; set; }
        public string Numero_Placa { get; set; }
        public int ID_Tipo { get; set; }
        public int ID_Usuario { get; set; }
        public bool Espacio_7600 { get; set; }
        public bool Estado { get; set; }

        public string Tipo { get; set; }
        public string Usuario { get; set; }
        public string OcupaEspacio7600 { get; set; }
        public string EstadoVehiculo { get; set; }

    }
}