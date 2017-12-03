using EventManagement.Domain.Entities;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace EventManagement.Web.Models
{
    public partial class invitationModels
    {
        [Key]
        public int id { get; set; }
        public Nullable<System.DateTime> dateEnvoi { get; set; }
        public string etat { get; set; }
        public int invited { get; set; }
        public Nullable<int> event_id { get; set; }
        public Nullable<int> invitedBy { get; set; }
        public virtual Event @event { get; set; }
        public virtual user user { get; set; }
    }
}
