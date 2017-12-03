using EventManagement.Domain.Entities;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace EventManagement.Data.Models.Mapping
{
    public class propositonMap : EntityTypeConfiguration<propositon>
    {
        public propositonMap()
        {
            // Primary Key
            this.HasKey(t => t.id);

            // Properties
            this.Property(t => t.description)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("propositon");
            this.Property(t => t.id).HasColumnName("id");
            this.Property(t => t.description).HasColumnName("description");
            this.Property(t => t.event_id).HasColumnName("event_id");
            this.Property(t => t.user_id).HasColumnName("user_id");

            // Relationships
            this.HasOptional(t => t.@event)
                .WithMany(t => t.propositons)
                .HasForeignKey(d => d.event_id);
            this.HasOptional(t => t.user)
                .WithMany(t => t.propositons)
                .HasForeignKey(d => d.user_id);

        }
    }
}
