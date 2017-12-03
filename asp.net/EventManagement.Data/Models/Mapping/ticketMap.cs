using EventManagement.Domain.Entities;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace EventManagement.Data.Models.Mapping
{
    public class ticketMap : EntityTypeConfiguration<ticket>
    {
        public ticketMap()
        {
            // Primary Key
            this.HasKey(t => new { t.idEvent, t.idUser });

            // Properties
            this.Property(t => t.idEvent)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            this.Property(t => t.idUser)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            this.Property(t => t.description)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("ticket");
            this.Property(t => t.idEvent).HasColumnName("idEvent");
            this.Property(t => t.idUser).HasColumnName("idUser");
            this.Property(t => t.description).HasColumnName("description");
            this.Property(t => t.prix).HasColumnName("prix");

            // Relationships
            this.HasMany(t => t.users)
                .WithMany(t => t.tickets1)
                .Map(m =>
                    {
                        m.ToTable("user_ticket");
                        m.MapLeftKey("tickets_idEvent", "tickets_idUser");
                        m.MapRightKey("User_id");
                    });

            this.HasRequired(t => t.@event)
                .WithMany(t => t.tickets)
                .HasForeignKey(d => d.idEvent);
            this.HasRequired(t => t.user)
                .WithMany(t => t.tickets)
                .HasForeignKey(d => d.idUser);

        }
    }
}
