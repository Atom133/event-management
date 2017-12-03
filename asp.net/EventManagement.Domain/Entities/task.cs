using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace EventManagement.Domain.Entities
{
    public partial class task
    {
        [Key]
        public int id { get; set; }
        public int assignBy { get; set; }
        [DataType(DataType.Date)]
        public DateTime? dateDebut { get; set; }
        [DataType(DataType.Date)]
        public DateTime? dateFin { get; set; }
        [DataType(DataType.MultilineText)]
        public string description { get; set; }
        public int orderTo { get; set; }
        public string statutTask { get; set; }
        public int? event_id { get; set; }
        public int? organizer_id { get; set; }
        public virtual Event @event { get; set; }
        public virtual user user { get; set; }
    }
}
