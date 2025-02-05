using Marketplace_Zapatos.Models.TableViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Marketplace_Zapatos.Models.ViewModels
{
    public class VendedorConReviewViewModel
    {
        public List<ReviewVendedorTableViewModel> Review { get; set; }
        public List<VendedorTableViewModel> Vendedor { get; set; }
        public List<CompradorTableViewModel> comprador { get; set; }
    }
}