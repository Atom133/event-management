using EventManagement.Domain.Entities;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace EventManagement.Data.Models.Mapping
{
    public class userMap : EntityTypeConfiguration<user>
    {
        public userMap()
        {
            // Primary Key
            //this.HasKey(t => t.id);

            // Properties
            this.Property(t => t.DTYPE)
                .IsRequired()
                .HasMaxLength(31);

            this.Property(t => t.address)
                .HasMaxLength(255);

         //   this.Property(t => t.email)
           //     .HasMaxLength(255);

            this.Property(t => t.firstName)
                .HasMaxLength(255);

            this.Property(t => t.lastName)
                .HasMaxLength(255);

      //      this.Property(t => t.login)
        //        .HasMaxLength(255);

       //     this.Property(t => t.phoneNumber)
         //       .HasMaxLength(255);

            this.Property(t => t.pwd)
                .HasMaxLength(255);

            this.Property(t => t.role)
                .HasMaxLength(255);

            this.Property(t => t.statutUser)
                .HasMaxLength(255);

            this.Property(t => t.societe)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("user");
            this.Property(t => t.DTYPE).HasColumnName("DTYPE");
          //  this.Property(t => t.id).HasColumnName("id");
            this.Property(t => t.address).HasColumnName("address");
            this.Property(t => t.cin).HasColumnName("cin");
            this.Property(t => t.dateOfBirth).HasColumnName("dateOfBirth");
            this.Property(t => t.dateRegistration).HasColumnName("dateRegistration");
           // this.Property(t => t.email).HasColumnName("email");
            this.Property(t => t.firstName).HasColumnName("firstName");
            this.Property(t => t.lastName).HasColumnName("lastName");
        //    this.Property(t => t.login).HasColumnName("login");
         //   this.Property(t => t.phoneNumber).HasColumnName("phoneNumber");
            this.Property(t => t.pwd).HasColumnName("pwd");
            this.Property(t => t.role).HasColumnName("role");
            this.Property(t => t.statutUser).HasColumnName("statutUser");
            this.Property(t => t.points).HasColumnName("points");
            this.Property(t => t.nbrTask).HasColumnName("nbrTask");
            this.Property(t => t.societe).HasColumnName("societe");
        }
    }
}
