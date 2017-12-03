using EventManagement.Domain.Entities;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace EventManagement.Web.Models
{
    public partial class taskModels
    {
        [Key]
        public int id { get; set; }
        public int assignBy { get; set; }
        public DateTime? dateDebut { get; set; }
        public DateTime? dateFin { get; set; }
        public string description { get; set; }
        public int orderTo { get; set; }
        public string statutTask { get; set; }
        public int? event_id { get; set; }
        public int? organizer_id { get; set; }
        public virtual Event @event { get; set; }
        public virtual user user { get; set; }
    }
}
