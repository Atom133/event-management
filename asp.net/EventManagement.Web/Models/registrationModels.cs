using EventManagement.Domain.Entities;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace EventManagement.Web.Models
{
    public partial class registrationModels
    {
        [Key]
        public int id { get; set; }
        public string InformationsOfTicket { get; set; }
        public DateTime? dateRegistration { get; set; }
        public string etatPayment { get; set; }
        public int invitedBy { get; set; }
        public Nullable<double> priceTicket { get; set; }
        public Nullable<int> event_id { get; set; }
        public int? participant_id { get; set; }
        public virtual Event @event { get; set; }
        public virtual user user { get; set; }
    }
}
