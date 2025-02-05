using Marketplace_Zapatos.Models.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.TableViewModels
{
    public class ProductoConImagenesTableViewModel
    {
        public List<ProductoTableViewModel> Productos { get; set; }
        public List<Imagenes_ProductoTableViewModel> Imagenes { get; set; }
        public List<ReviewProductoTableViewModel> Review {  get; set; }
        public List<CarritoProductoOriginalTableViewModel> Carritos {  get; set; }

    }
}