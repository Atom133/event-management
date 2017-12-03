using EventManagement.Domain.Entities;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace EventManagement.Data.Models.Mapping
{
    public class galleryMap : EntityTypeConfiguration<gallery>
    {
        public galleryMap()
        {
            // Primary Key
            this.HasKey(t => t.id_Gallery);

            // Properties
            this.Property(t => t.id_Gallery)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            this.Property(t => t.description)
                .HasMaxLength(255);

            this.Property(t => t.nom)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("gallery");
            this.Property(t => t.id_Gallery).HasColumnName("id_Gallery");
            this.Property(t => t.description).HasColumnName("description");
            this.Property(t => t.nom).HasColumnName("nom");
            this.Property(t => t.event_id).HasColumnName("event_id");

            // Relationships
            this.HasMany(t => t.images1)
                .WithMany(t => t.galleries)
                .Map(m =>
                    {
                        m.ToTable("gallery_image");
                        m.MapLeftKey("Gallery_id_Gallery");
                        m.MapRightKey("images_id_Image");
                    });

            this.HasOptional(t => t.@event)
                .WithMany(t => t.galleries)
                .HasForeignKey(d => d.event_id);

        }
    }
}
