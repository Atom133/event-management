using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace EventManagement.Domain.Entities
{
    public partial class Event
    {
        public Event()
        {
            this.invitations = new List<invitation>();
            this.galleries = new List<gallery>();
            this.tickets = new List<ticket>();
            this.registrations = new List<registration>();
            this.tasks = new List<task>();
            this.propositons = new List<propositon>();
        }
        [Key]
        public int id { get; set; }
        public string InformationsOfTicket { get; set; }
        public string category { get; set; }
        public DateTime dateEvent { get; set; }
        public string description { get; set; }
        public string name { get; set; }
        public string place { get; set; }
        public int? createdBy { get; set; }
        public virtual ICollection<invitation> invitations { get; set; }
        public virtual ICollection<gallery> galleries { get; set; }
        public virtual user user { get; set; }
        public virtual ICollection<ticket> tickets { get; set; }
        public virtual ICollection<registration> registrations { get; set; }
        public virtual ICollection<task> tasks { get; set; }
        public virtual ICollection<propositon> propositons { get; set; }
    }
}
