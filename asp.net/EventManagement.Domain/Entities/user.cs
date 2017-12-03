using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.EntityFramework;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Security.Claims;
using System.Threading.Tasks;


namespace EventManagement.Domain.Entities
{
    public partial class user : IdentityUser<int, CustomUserLogin, CustomUserRole, CustomUserClaim>
    {
        public user()
        {
            this.events = new List<Event>();
            this.images = new List<image>();
            this.invitations = new List<invitation>();
            this.propositons = new List<propositon>();
            this.registrations = new List<registration>();
            this.tasks = new List<task>();
            this.tickets = new List<ticket>();
            this.videos = new List<video>();
            this.images1 = new List<image>();
            this.tickets1 = new List<ticket>();
            this.videos1 = new List<video>();
        }

        public string DTYPE { get; set; }
      //  [Key]
     //   public int id { get; set; }
        public string address { get; set; }
        public long cin { get; set; }
        public Nullable<System.DateTime> dateOfBirth { get; set; }
        public Nullable<System.DateTime> dateRegistration { get; set; }
    //    public string email { get; set; }
        public string firstName { get; set; }
        public string lastName { get; set; }
  //      public string login { get; set; }
    //    public string phoneNumber { get; set; }
        public string pwd { get; set; }
        public string role { get; set; }
        public string statutUser { get; set; }
        public Nullable<float> points { get; set; }
        public Nullable<int> nbrTask { get; set; }
        public string societe { get; set; }
        public virtual ICollection<Event> events { get; set; }
        public virtual ICollection<image> images { get; set; }
        public virtual ICollection<invitation> invitations { get; set; }
        public virtual ICollection<propositon> propositons { get; set; }
        public virtual ICollection<registration> registrations { get; set; }
        public virtual ICollection<task> tasks { get; set; }
        public virtual ICollection<ticket> tickets { get; set; }
        public virtual ICollection<video> videos { get; set; }
        public virtual ICollection<image> images1 { get; set; }
        public virtual ICollection<ticket> tickets1 { get; set; }
        public virtual ICollection<video> videos1 { get; set; }
        public async Task<ClaimsIdentity> GenerateUserIdentityAsync(UserManager<user, int> manager)
        {
            // Note the authenticationType must match the one defined in
            // CookieAuthenticationOptions.AuthenticationType 
            var userIdentity = await manager.CreateIdentityAsync(this, DefaultAuthenticationTypes.ApplicationCookie);
            // Add custom user claims here 
            return userIdentity;
        }


    }
}


public class CustomUserLogin : IdentityUserLogin<int>
{
    public int Id { get; set; }

}
public class CustomUserRole : IdentityUserRole<int>
{
    public int Id { get; set; }
}
public class CustomUserClaim : IdentityUserClaim<int>
{

}
public class CustomRole : IdentityRole<int, CustomUserRole>
{
    public CustomRole() { }
    public CustomRole(string name) { Name = name; }
}
