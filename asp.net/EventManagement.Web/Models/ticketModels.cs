using EventManagement.Domain.Entities;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace EventManagement.Web.Models
{
    public partial class ticketModels
    {
        public ticketModels()
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
