
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace EventManagement.Domain.Entities
{
    public partial class video
    {
        public video()
        {
            this.galleries = new List<gallery>();
            this.users = new List<user>();
        }
        [Key]
        public int id_Video { get; set; }
        public string description { get; set; }
        public string nom { get; set; }
        public string url { get; set; }
        public Nullable<int> gallery_id_Gallery { get; set; }
        public int? user_id { get; set; }
        public virtual gallery gallery { get; set; }
        public virtual user user { get; set; }
        public virtual ICollection<gallery> galleries { get; set; }
        public virtual ICollection<user> users { get; set; }
    }
}
