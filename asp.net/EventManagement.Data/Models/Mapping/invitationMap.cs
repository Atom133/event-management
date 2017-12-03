using EventManagement.Domain.Entities;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace EventManagement.Data.Models.Mapping
{
    public class invitationMap : EntityTypeConfiguration<invitation>
    {
        public invitationMap()
        {
            // Primary Key
            this.HasKey(t => t.id);

            // Properties
            this.Property(t => t.id)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            this.Property(t => t.etat)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("invitation");
            this.Property(t => t.id).HasColumnName("id");
            this.Property(t => t.dateEnvoi).HasColumnName("dateEnvoi");
            this.Property(t => t.etat).HasColumnName("etat");
            this.Property(t => t.invited).HasColumnName("invited");
            this.Property(t => t.event_id).HasColumnName("event_id");
            this.Property(t => t.invitedBy).HasColumnName("invitedBy");

            // Relationships
            this.HasOptional(t => t.@event)
                .WithMany(t => t.invitations)
                .HasForeignKey(d => d.event_id);
            this.HasOptional(t => t.user)
                .WithMany(t => t.invitations)
                .HasForeignKey(d => d.invitedBy);

        }
    }
}
