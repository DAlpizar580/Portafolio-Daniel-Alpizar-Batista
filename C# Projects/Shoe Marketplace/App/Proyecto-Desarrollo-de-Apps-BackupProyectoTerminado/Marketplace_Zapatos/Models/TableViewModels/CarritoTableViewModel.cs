using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Marketplace_Zapatos.Models;

using Marketplace_Zapatos.Models.TableViewModels;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class CarritoTableViewModel
    {
        public int IdCarrito { get; set; }
        public int Precio { get; set; }
    }
}