using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using EventManagement.Data.Models.Mapping;
using EventManagement.Data.Models;
using EventManagement.Domain.Entities;
using Microsoft.AspNet.Identity.EntityFramework;
using System.Data.Entity.Migrations.History;

namespace EventManagement.Data
{
    public partial class event_managementContext : IdentityDbContext<user, CustomRole, int, CustomUserLogin, CustomUserRole, CustomUserClaim>
    {
              static event_managementContext()
               {
                   Database.SetInitializer<event_managementContext>(null);
               }


        public static event_managementContext Create()
        {
            return new event_managementContext();
        }


        public event_managementContext()
            : base("Name=event_managementContext")
        {
        }

        public DbSet<Event> events { get; set; }
       public DbSet<gallery> galleries { get; set; }
       public DbSet<image> images { get; set; }
        public DbSet<invitation> invitations { get; set; }
        public DbSet<payment> payments { get; set; }
        public DbSet<propositon> propositons { get; set; }
        public DbSet<registration> registrations { get; set; }
        public DbSet<task> tasks { get; set; }
        public DbSet<ticket> tickets { get; set; }
    //    public DbSet<user> utilisateurs { get; set; }
        public DbSet<video> videos { get; set; }

        public DbSet<EventOrganizer> event_organizer { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new eventMap());
            modelBuilder.Configurations.Add(new galleryMap());
            modelBuilder.Configurations.Add(new imageMap());
            modelBuilder.Configurations.Add(new invitationMap());
            modelBuilder.Configurations.Add(new paymentMap());
            modelBuilder.Configurations.Add(new propositonMap());
            modelBuilder.Configurations.Add(new registrationMap());
            modelBuilder.Configurations.Add(new taskMap());
            modelBuilder.Configurations.Add(new ticketMap());
            modelBuilder.Configurations.Add(new userMap());
            modelBuilder.Configurations.Add(new videoMap());



            /***************************************************************************************/



            //  modelBuilder.Entity<Client>().Property(r => r.Id).HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity);
            //  modelBuilder.Entity<CustomUserClaim>().Property(r => r.Id).HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity);
            // modelBuilder.Entity<CustomUserRole>().Property(r => r.Id).HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity);

            modelBuilder.Entity<user>().Property(r => r.UserName).HasColumnName("Login");
            //  modelBuilder.Entity<Client>().Property(r => r.Id).HasColumnName("id_User");
            modelBuilder.Entity<user>().Property(r => r.PasswordHash).HasColumnName("password");
         //   modelBuilder.Entity<user>().ToTable("users");


            modelBuilder.Entity<IdentityUserRole>()
            .HasKey(r => new { r.UserId, r.RoleId })
            .ToTable("AspNetUserRoles");

            //modelBuilder.Entity<IdentityUserLogin>()
            //    .HasKey(l => new { l.LoginProvider, l.ProviderKey, l.UserId })
            //    .ToTable("AspNetUserLogins");
            modelBuilder.Entity<HistoryRow>().HasKey(h => h.MigrationId);
            modelBuilder.Entity<HistoryRow>().Property(h => h.MigrationId).HasMaxLength(100).IsRequired();
            modelBuilder.Entity<HistoryRow>().Property(h => h.ContextKey).HasMaxLength(200).IsRequired();
            //  modelBuilder.Entity<Microsoft.AspNet.Identity.EntityFramework.IdentityRole>()
            //    .Property(c => c.Name).HasMaxLength(128).IsRequired();

            //base.OnModelCreating(modelBuilder);

            //   modelBuilder.Entity<ApplicationUser>().ToTable("Clients");

            //   modelBuilder.Entity<IdentityUserClaim>().ToTable("identityroles");
            //modelBuilder.Entity<IdentityUserRole>().ToTable("identityuserclaims");





        }
    }









    public class Twin : DropCreateDatabaseAlways<event_managementContext>
    {
        protected override void Seed(event_managementContext context) // initialisation lel base de donnée
        {

        }
    }









}
