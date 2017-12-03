using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace EventManagement.Domain.Entities
{
    public partial class propositon
    {
        [Key]
        public int id { get; set; }
        public string description { get; set; }
        public Nullable<int> event_id { get; set; }
        public Nullable<int> user_id { get; set; }
        public virtual Event @event { get; set; }
        public virtual user user { get; set; }
    }
}
