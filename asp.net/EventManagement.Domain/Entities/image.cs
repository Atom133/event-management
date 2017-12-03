using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace EventManagement.Domain.Entities
{
    public partial class image
    {
        public image()
        {
            this.galleries = new List<gallery>();
            this.users = new List<user>();
        }
        [Key]
        public int id_Image { get; set; }
        public string description { get; set; }
        public string nom { get; set; }
        public string url { get; set; }
        public Nullable<int> gallery_id_Gallery { get; set; }
        public Nullable<int> user_id { get; set; }
        public virtual gallery gallery { get; set; }
        public virtual user user { get; set; }
        public virtual ICollection<gallery> galleries { get; set; }
        public virtual ICollection<user> users { get; set; }
    }
}
