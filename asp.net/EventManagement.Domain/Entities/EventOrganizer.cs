using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventManagement.Domain.Entities
{
     public class EventOrganizer
    {

        public EventOrganizer()
        {

        }

        [Key]
        public int Id { get; set; }
        public int EventId { get; set; }
        public Event myevent { get; set; }
        public int organizerId { get; set; }
        public virtual user organizer { get; set; }

        public virtual user president { get; set; }
        [DataType(DataType.MultilineText)]
        public string message { get; set; }

        public  string  statutRequest { get; set; }
    }
}
