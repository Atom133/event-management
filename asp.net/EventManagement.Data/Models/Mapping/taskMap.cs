using EventManagement.Domain.Entities;

using System.Data.Entity.ModelConfiguration;

namespace EventManagement.Data.Models.Mapping
{
    public class taskMap : EntityTypeConfiguration<task>
    {
        public taskMap()
        {
            // Primary Key
            this.HasKey(t => t.id);

            // Properties

            this.Property(t => t.description)
                .HasMaxLength(255);

            this.Property(t => t.statutTask)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("task");
            this.Property(t => t.id).HasColumnName("id");
            this.Property(t => t.assignBy).HasColumnName("assignBy");
            this.Property(t => t.dateDebut).HasColumnName("dateDebut");
            this.Property(t => t.dateFin).HasColumnName("dateFin");
            this.Property(t => t.description).HasColumnName("description");
            this.Property(t => t.orderTo).HasColumnName("orderTo");
            this.Property(t => t.statutTask).HasColumnName("statutTask");
            this.Property(t => t.event_id).HasColumnName("event_id");
            this.Property(t => t.organizer_id).HasColumnName("organizer_id");

            // Relationships
            this.HasOptional(t => t.@event)
                .WithMany(t => t.tasks)
                .HasForeignKey(d => d.event_id);
            this.HasOptional(t => t.user)
                .WithMany(t => t.tasks)
                .HasForeignKey(d => d.organizer_id);

        }
    }
}
