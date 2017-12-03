using EventManagement.Domain.Entities;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace EventManagement.Data.Models.Mapping
{
    public class imageMap : EntityTypeConfiguration<image>
    {
        public imageMap()
        {
            // Primary Key
            this.HasKey(t => t.id_Image);

            // Properties
            this.Property(t => t.id_Image)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            this.Property(t => t.description)
                .HasMaxLength(255);

            this.Property(t => t.nom)
                .HasMaxLength(255);

            this.Property(t => t.url)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("image");
            this.Property(t => t.id_Image).HasColumnName("id_Image");
            this.Property(t => t.description).HasColumnName("description");
            this.Property(t => t.nom).HasColumnName("nom");
            this.Property(t => t.url).HasColumnName("url");
            this.Property(t => t.gallery_id_Gallery).HasColumnName("gallery_id_Gallery");
            this.Property(t => t.user_id).HasColumnName("user_id");

            // Relationships
            this.HasMany(t => t.users)
                .WithMany(t => t.images1)
                .Map(m =>
                    {
                        m.ToTable("user_image");
                        m.MapLeftKey("images_id_Image");
                        m.MapRightKey("User_id");
                    });

            this.HasOptional(t => t.gallery)
                .WithMany(t => t.images)
                .HasForeignKey(d => d.gallery_id_Gallery);
            this.HasOptional(t => t.user)
                .WithMany(t => t.images)
                .HasForeignKey(d => d.user_id);

        }
    }
}
