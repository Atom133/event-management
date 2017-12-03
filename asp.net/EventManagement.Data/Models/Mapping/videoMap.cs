using EventManagement.Domain.Entities;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace EventManagement.Data.Models.Mapping
{
    public class videoMap : EntityTypeConfiguration<video>
    {
        public videoMap()
        {
            // Primary Key
            this.HasKey(t => t.id_Video);

            // Properties
            this.Property(t => t.id_Video)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            this.Property(t => t.description)
                .HasMaxLength(255);

            this.Property(t => t.nom)
                .HasMaxLength(255);

            this.Property(t => t.url)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("video");
            this.Property(t => t.id_Video).HasColumnName("id_Video");
            this.Property(t => t.description).HasColumnName("description");
            this.Property(t => t.nom).HasColumnName("nom");
            this.Property(t => t.url).HasColumnName("url");
            this.Property(t => t.gallery_id_Gallery).HasColumnName("gallery_id_Gallery");
            this.Property(t => t.user_id).HasColumnName("user_id");

            // Relationships
            this.HasMany(t => t.galleries)
                .WithMany(t => t.videos1)
                .Map(m =>
                    {
                        m.ToTable("gallery_video");
                        m.MapLeftKey("videos_id_Video");
                        m.MapRightKey("Gallery_id_Gallery");
                    });

            this.HasMany(t => t.users)
                .WithMany(t => t.videos1)
                .Map(m =>
                    {
                        m.ToTable("user_video");
                        m.MapLeftKey("videos_id_Video");
                        m.MapRightKey("User_id");
                    });

            this.HasOptional(t => t.gallery)
                .WithMany(t => t.videos)
                .HasForeignKey(d => d.gallery_id_Gallery);
            this.HasOptional(t => t.user)
                .WithMany(t => t.videos)
                .HasForeignKey(d => d.user_id);

        }
    }
}
