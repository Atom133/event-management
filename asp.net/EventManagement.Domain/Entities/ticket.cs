using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace EventManagement.Domain.Entities
{
    public partial class ticket
    {
        public ticket()
        {
            this.users = new List<user>();
        }
        [Key]
        public int id { get; set; }
        public int idEvent { get; set; }
        public int idUser { get; set; }
        public string description { get; set; }
        public float prix { get; set; }
        public virtual Event @event { get; set; }
        public virtual user user { get; set; }
        public virtual ICollection<user> users { get; set; }
    }
}
