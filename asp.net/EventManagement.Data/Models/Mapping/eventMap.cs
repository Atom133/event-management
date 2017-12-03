using EventManagement.Domain.Entities;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;


namespace EventManagement.Data.Models.Mapping
{
    public class eventMap : EntityTypeConfiguration<Event>
    {
        public eventMap()
        {
            // Primary Key
            this.HasKey(t => t.id);

            // Properties
            this.Property(t => t.id)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            this.Property(t => t.InformationsOfTicket)
                .HasMaxLength(255);

            this.Property(t => t.category)
                .HasMaxLength(255);

            this.Property(t => t.description)
                .HasMaxLength(255);

            this.Property(t => t.name)
                .HasMaxLength(255);

            this.Property(t => t.place)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("event");
            this.Property(t => t.id).HasColumnName("id");
            this.Property(t => t.InformationsOfTicket).HasColumnName("InformationsOfTicket");
            this.Property(t => t.category).HasColumnName("category");
            this.Property(t => t.dateEvent).HasColumnName("dateEvent");
            this.Property(t => t.description).HasColumnName("description");
            this.Property(t => t.name).HasColumnName("name");
            this.Property(t => t.place).HasColumnName("place");
            this.Property(t => t.createdBy).HasColumnName("createdBy");

            // Relationships
            this.HasOptional(t => t.user)
                .WithMany(t => t.events)
                .HasForeignKey(d => d.createdBy);

        }
    }
}
