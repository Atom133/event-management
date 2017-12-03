
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace EventManagement.Domain.Entities
{
    public partial class gallery
    {
        public gallery()
        {
            this.videos = new List<video>();
            this.images = new List<image>();
            this.images1 = new List<image>();
            this.videos1 = new List<video>();
        }
        [Key]
        public int id_Gallery { get; set; }
        public string description { get; set; }
        public string nom { get; set; }
        public Nullable<int> event_id { get; set; }
        public virtual Event @event { get; set; }
        public virtual ICollection<video> videos { get; set; }
        public virtual ICollection<image> images { get; set; }
        public virtual ICollection<image> images1 { get; set; }
        public virtual ICollection<video> videos1 { get; set; }
    }
}
