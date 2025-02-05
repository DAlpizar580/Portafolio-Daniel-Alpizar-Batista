using Marketplace_Zapatos.Models.TableViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class ProductoConImagenesViewModel
    {
        public List<ProductoTableViewModel> Productos { get; set; }
        public List<Imagenes_ProductoTableViewModel> Imagenes { get; set; }
        public List<ReviewProductoTableViewModel> Review { get; set; }
    }
}