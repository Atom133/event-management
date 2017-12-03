using EventManagement.Domain.Entities;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace EventManagement.Data.Models.Mapping
{
    public class registrationMap : EntityTypeConfiguration<registration>
    {
        public registrationMap()
        {
            // Primary Key
            this.HasKey(t => t.id);

            // Properties
            this.Property(t => t.id)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            this.Property(t => t.InformationsOfTicket)
                .HasMaxLength(255);

            this.Property(t => t.etatPayment)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("registration");
            this.Property(t => t.id).HasColumnName("id");
            this.Property(t => t.InformationsOfTicket).HasColumnName("InformationsOfTicket");
            this.Property(t => t.dateRegistration).HasColumnName("dateRegistration");
            this.Property(t => t.etatPayment).HasColumnName("etatPayment");
            this.Property(t => t.invitedBy).HasColumnName("invitedBy");
            this.Property(t => t.priceTicket).HasColumnName("priceTicket");
            this.Property(t => t.event_id).HasColumnName("event_id");
            this.Property(t => t.participant_id).HasColumnName("participant_id");

            // Relationships
            this.HasOptional(t => t.@event)
                .WithMany(t => t.registrations)
                .HasForeignKey(d => d.event_id);
            this.HasOptional(t => t.user)
                .WithMany(t => t.registrations)
                .HasForeignKey(d => d.participant_id);

        }
    }
}
