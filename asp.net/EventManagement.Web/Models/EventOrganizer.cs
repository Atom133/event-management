using EventManagement.Domain.Entities;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventManagement.Web.Models
{
     public class EventOrganizer
    {
        [Key]
        public int Id { get; set; }
        public int EventId { get; set; }
        public Event myevent { get; set; }
        public int organizerId { get; set; }
        public user organizer { get; set; }

        public user president { get; set; }
        [DataType(DataType.MultilineText)]
        public string message { get; set; }

        public string statutRequest { get; set; }
    }
}
