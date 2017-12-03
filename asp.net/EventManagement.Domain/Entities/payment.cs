using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace EventManagement.Domain.Entities
{
    public partial class payment
    {
        [Key]
        public int id { get; set; }
        public string email { get; set; }
        public string firstName { get; set; }
        public string lastName { get; set; }
        public Nullable<double> priceTicket { get; set; }
        public string typePayment { get; set; }
    }
}
