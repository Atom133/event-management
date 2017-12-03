namespace EventManagement.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class identity : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.EventOrganizers",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        EventId = c.Int(nullable: false),
                        organizerId = c.Int(nullable: false),
                        message = c.String(unicode: false),
                        statutRequest = c.String(unicode: false),
                        president_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.event", t => t.EventId, cascadeDelete: true)
                .ForeignKey("dbo.user", t => t.organizerId, cascadeDelete: true)
                .ForeignKey("dbo.user", t => t.president_Id)
                .Index(t => t.EventId)
                .Index(t => t.organizerId)
                .Index(t => t.president_Id);
            
            CreateTable(
                "dbo.event",
                c => new
                    {
                        id = c.Int(nullable: false),
                        InformationsOfTicket = c.String(maxLength: 255, storeType: "nvarchar"),
                        category = c.String(maxLength: 255, storeType: "nvarchar"),
                        dateEvent = c.DateTime(nullable: false, precision: 0),
                        description = c.String(maxLength: 255, storeType: "nvarchar"),
                        name = c.String(maxLength: 255, storeType: "nvarchar"),
                        place = c.String(maxLength: 255, storeType: "nvarchar"),
                        createdBy = c.Int(),
                    })
                .PrimaryKey(t => t.id)
                .ForeignKey("dbo.user", t => t.createdBy)
                .Index(t => t.createdBy);
            
            CreateTable(
                "dbo.gallery",
                c => new
                    {
                        id_Gallery = c.Int(nullable: false),
                        description = c.String(maxLength: 255, storeType: "nvarchar"),
                        nom = c.String(maxLength: 255, storeType: "nvarchar"),
                        event_id = c.Int(),
                    })
                .PrimaryKey(t => t.id_Gallery)
                .ForeignKey("dbo.event", t => t.event_id)
                .Index(t => t.event_id);
            
            CreateTable(
                "dbo.image",
                c => new
                    {
                        id_Image = c.Int(nullable: false),
                        description = c.String(maxLength: 255, storeType: "nvarchar"),
                        nom = c.String(maxLength: 255, storeType: "nvarchar"),
                        url = c.String(maxLength: 255, storeType: "nvarchar"),
                        gallery_id_Gallery = c.Int(),
                        user_id = c.Int(),
                    })
                .PrimaryKey(t => t.id_Image)
                .ForeignKey("dbo.gallery", t => t.gallery_id_Gallery)
                .ForeignKey("dbo.user", t => t.user_id)
                .Index(t => t.gallery_id_Gallery)
                .Index(t => t.user_id);
            
            CreateTable(
                "dbo.user",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DTYPE = c.String(nullable: false, maxLength: 31, storeType: "nvarchar"),
                        address = c.String(maxLength: 255, storeType: "nvarchar"),
                        cin = c.Long(nullable: false),
                        dateOfBirth = c.DateTime(precision: 0),
                        dateRegistration = c.DateTime(precision: 0),
                        firstName = c.String(maxLength: 255, storeType: "nvarchar"),
                        lastName = c.String(maxLength: 255, storeType: "nvarchar"),
                        pwd = c.String(maxLength: 255, storeType: "nvarchar"),
                        role = c.String(maxLength: 255, storeType: "nvarchar"),
                        statutUser = c.String(maxLength: 255, storeType: "nvarchar"),
                        points = c.Single(),
                        nbrTask = c.Int(),
                        societe = c.String(maxLength: 255, storeType: "nvarchar"),
                        Email = c.String(unicode: false),
                        EmailConfirmed = c.Boolean(nullable: false),
                        password = c.String(unicode: false),
                        SecurityStamp = c.String(unicode: false),
                        PhoneNumber = c.String(unicode: false),
                        PhoneNumberConfirmed = c.Boolean(nullable: false),
                        TwoFactorEnabled = c.Boolean(nullable: false),
                        LockoutEndDateUtc = c.DateTime(precision: 0),
                        LockoutEnabled = c.Boolean(nullable: false),
                        AccessFailedCount = c.Int(nullable: false),
                        Login = c.String(unicode: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.CustomUserClaims",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        UserId = c.Int(nullable: false),
                        ClaimType = c.String(unicode: false),
                        ClaimValue = c.String(unicode: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.user", t => t.UserId, cascadeDelete: true)
                .Index(t => t.UserId);
            
            CreateTable(
                "dbo.invitation",
                c => new
                    {
                        id = c.Int(nullable: false),
                        dateEnvoi = c.DateTime(precision: 0),
                        etat = c.String(maxLength: 255, storeType: "nvarchar"),
                        invited = c.Int(nullable: false),
                        event_id = c.Int(),
                        invitedBy = c.Int(),
                    })
                .PrimaryKey(t => t.id)
                .ForeignKey("dbo.event", t => t.event_id)
                .ForeignKey("dbo.user", t => t.invitedBy)
                .Index(t => t.event_id)
                .Index(t => t.invitedBy);
            
            CreateTable(
                "dbo.CustomUserLogins",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        LoginProvider = c.String(unicode: false),
                        ProviderKey = c.String(unicode: false),
                        UserId = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.user", t => t.UserId, cascadeDelete: true)
                .Index(t => t.UserId);
            
            CreateTable(
                "dbo.propositon",
                c => new
                    {
                        id = c.Int(nullable: false, identity: true),
                        description = c.String(maxLength: 255, storeType: "nvarchar"),
                        event_id = c.Int(),
                        user_id = c.Int(),
                    })
                .PrimaryKey(t => t.id)
                .ForeignKey("dbo.event", t => t.event_id)
                .ForeignKey("dbo.user", t => t.user_id)
                .Index(t => t.event_id)
                .Index(t => t.user_id);
            
            CreateTable(
                "dbo.registration",
                c => new
                    {
                        id = c.Int(nullable: false),
                        InformationsOfTicket = c.String(maxLength: 255, storeType: "nvarchar"),
                        dateRegistration = c.DateTime(precision: 0),
                        etatPayment = c.String(maxLength: 255, storeType: "nvarchar"),
                        invitedBy = c.Int(nullable: false),
                        priceTicket = c.Double(),
                        event_id = c.Int(),
                        participant_id = c.Int(),
                    })
                .PrimaryKey(t => t.id)
                .ForeignKey("dbo.event", t => t.event_id)
                .ForeignKey("dbo.user", t => t.participant_id)
                .Index(t => t.event_id)
                .Index(t => t.participant_id);
            
            CreateTable(
                "dbo.CustomUserRoles",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        UserId = c.Int(nullable: false),
                        RoleId = c.Int(nullable: false),
                        CustomRole_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.user", t => t.UserId, cascadeDelete: true)
                .ForeignKey("dbo.CustomRoles", t => t.CustomRole_Id)
                .Index(t => t.UserId)
                .Index(t => t.CustomRole_Id);
            
            CreateTable(
                "dbo.task",
                c => new
                    {
                        id = c.Int(nullable: false, identity: true),
                        assignBy = c.Int(nullable: false),
                        dateDebut = c.DateTime(precision: 0),
                        dateFin = c.DateTime(precision: 0),
                        description = c.String(maxLength: 255, storeType: "nvarchar"),
                        orderTo = c.Int(nullable: false),
                        statutTask = c.String(maxLength: 255, storeType: "nvarchar"),
                        event_id = c.Int(),
                        organizer_id = c.Int(),
                    })
                .PrimaryKey(t => t.id)
                .ForeignKey("dbo.event", t => t.event_id)
                .ForeignKey("dbo.user", t => t.organizer_id)
                .Index(t => t.event_id)
                .Index(t => t.organizer_id);
            
            CreateTable(
                "dbo.ticket",
                c => new
                    {
                        idEvent = c.Int(nullable: false),
                        idUser = c.Int(nullable: false),
                        id = c.Int(nullable: false),
                        description = c.String(maxLength: 255, storeType: "nvarchar"),
                        prix = c.Single(nullable: false),
                    })
                .PrimaryKey(t => new { t.idEvent, t.idUser })
                .ForeignKey("dbo.event", t => t.idEvent, cascadeDelete: true)
                .ForeignKey("dbo.user", t => t.idUser, cascadeDelete: true)
                .Index(t => t.idEvent)
                .Index(t => t.idUser);
            
            CreateTable(
                "dbo.video",
                c => new
                    {
                        id_Video = c.Int(nullable: false),
                        description = c.String(maxLength: 255, storeType: "nvarchar"),
                        nom = c.String(maxLength: 255, storeType: "nvarchar"),
                        url = c.String(maxLength: 255, storeType: "nvarchar"),
                        gallery_id_Gallery = c.Int(),
                        user_id = c.Int(),
                    })
                .PrimaryKey(t => t.id_Video)
                .ForeignKey("dbo.gallery", t => t.gallery_id_Gallery)
                .ForeignKey("dbo.user", t => t.user_id)
                .Index(t => t.gallery_id_Gallery)
                .Index(t => t.user_id);
            
            CreateTable(
                "dbo.payment",
                c => new
                    {
                        id = c.Int(nullable: false, identity: true),
                        email = c.String(maxLength: 255, storeType: "nvarchar"),
                        firstName = c.String(maxLength: 255, storeType: "nvarchar"),
                        lastName = c.String(maxLength: 255, storeType: "nvarchar"),
                        priceTicket = c.Double(),
                        typePayment = c.String(maxLength: 255, storeType: "nvarchar"),
                    })
                .PrimaryKey(t => t.id);
            
            CreateTable(
                "dbo.CustomRoles",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(unicode: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.AspNetUserRoles",
                c => new
                    {
                        UserId = c.String(nullable: false, maxLength: 128, storeType: "nvarchar"),
                        RoleId = c.String(nullable: false, maxLength: 128, storeType: "nvarchar"),
                    })
                .PrimaryKey(t => new { t.UserId, t.RoleId });
            
            CreateTable(
                "dbo.HistoryRows",
                c => new
                    {
                        MigrationId = c.String(nullable: false, maxLength: 100, storeType: "nvarchar"),
                        ContextKey = c.String(nullable: false, maxLength: 200, storeType: "nvarchar"),
                        Model = c.Binary(),
                        ProductVersion = c.String(unicode: false),
                    })
                .PrimaryKey(t => t.MigrationId);
            
            CreateTable(
                "dbo.user_ticket",
                c => new
                    {
                        tickets_idEvent = c.Int(nullable: false),
                        tickets_idUser = c.Int(nullable: false),
                        User_id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.tickets_idEvent, t.tickets_idUser, t.User_id })
                .ForeignKey("dbo.ticket", t => new { t.tickets_idEvent, t.tickets_idUser }, cascadeDelete: true)
                .ForeignKey("dbo.user", t => t.User_id, cascadeDelete: true)
                .Index(t => new { t.tickets_idEvent, t.tickets_idUser })
                .Index(t => t.User_id);
            
            CreateTable(
                "dbo.gallery_video",
                c => new
                    {
                        videos_id_Video = c.Int(nullable: false),
                        Gallery_id_Gallery = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.videos_id_Video, t.Gallery_id_Gallery })
                .ForeignKey("dbo.video", t => t.videos_id_Video, cascadeDelete: true)
                .ForeignKey("dbo.gallery", t => t.Gallery_id_Gallery, cascadeDelete: true)
                .Index(t => t.videos_id_Video)
                .Index(t => t.Gallery_id_Gallery);
            
            CreateTable(
                "dbo.user_video",
                c => new
                    {
                        videos_id_Video = c.Int(nullable: false),
                        User_id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.videos_id_Video, t.User_id })
                .ForeignKey("dbo.video", t => t.videos_id_Video, cascadeDelete: true)
                .ForeignKey("dbo.user", t => t.User_id, cascadeDelete: true)
                .Index(t => t.videos_id_Video)
                .Index(t => t.User_id);
            
            CreateTable(
                "dbo.user_image",
                c => new
                    {
                        images_id_Image = c.Int(nullable: false),
                        User_id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.images_id_Image, t.User_id })
                .ForeignKey("dbo.image", t => t.images_id_Image, cascadeDelete: true)
                .ForeignKey("dbo.user", t => t.User_id, cascadeDelete: true)
                .Index(t => t.images_id_Image)
                .Index(t => t.User_id);
            
            CreateTable(
                "dbo.gallery_image",
                c => new
                    {
                        Gallery_id_Gallery = c.Int(nullable: false),
                        images_id_Image = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Gallery_id_Gallery, t.images_id_Image })
                .ForeignKey("dbo.gallery", t => t.Gallery_id_Gallery, cascadeDelete: true)
                .ForeignKey("dbo.image", t => t.images_id_Image, cascadeDelete: true)
                .Index(t => t.Gallery_id_Gallery)
                .Index(t => t.images_id_Image);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.CustomUserRoles", "CustomRole_Id", "dbo.CustomRoles");
            DropForeignKey("dbo.EventOrganizers", "president_Id", "dbo.user");
            DropForeignKey("dbo.EventOrganizers", "organizerId", "dbo.user");
            DropForeignKey("dbo.EventOrganizers", "EventId", "dbo.event");
            DropForeignKey("dbo.event", "createdBy", "dbo.user");
            DropForeignKey("dbo.gallery_image", "images_id_Image", "dbo.image");
            DropForeignKey("dbo.gallery_image", "Gallery_id_Gallery", "dbo.gallery");
            DropForeignKey("dbo.user_image", "User_id", "dbo.user");
            DropForeignKey("dbo.user_image", "images_id_Image", "dbo.image");
            DropForeignKey("dbo.image", "user_id", "dbo.user");
            DropForeignKey("dbo.user_video", "User_id", "dbo.user");
            DropForeignKey("dbo.user_video", "videos_id_Video", "dbo.video");
            DropForeignKey("dbo.video", "user_id", "dbo.user");
            DropForeignKey("dbo.video", "gallery_id_Gallery", "dbo.gallery");
            DropForeignKey("dbo.gallery_video", "Gallery_id_Gallery", "dbo.gallery");
            DropForeignKey("dbo.gallery_video", "videos_id_Video", "dbo.video");
            DropForeignKey("dbo.user_ticket", "User_id", "dbo.user");
            DropForeignKey("dbo.user_ticket", new[] { "tickets_idEvent", "tickets_idUser" }, "dbo.ticket");
            DropForeignKey("dbo.ticket", "idUser", "dbo.user");
            DropForeignKey("dbo.ticket", "idEvent", "dbo.event");
            DropForeignKey("dbo.task", "organizer_id", "dbo.user");
            DropForeignKey("dbo.task", "event_id", "dbo.event");
            DropForeignKey("dbo.CustomUserRoles", "UserId", "dbo.user");
            DropForeignKey("dbo.registration", "participant_id", "dbo.user");
            DropForeignKey("dbo.registration", "event_id", "dbo.event");
            DropForeignKey("dbo.propositon", "user_id", "dbo.user");
            DropForeignKey("dbo.propositon", "event_id", "dbo.event");
            DropForeignKey("dbo.CustomUserLogins", "UserId", "dbo.user");
            DropForeignKey("dbo.invitation", "invitedBy", "dbo.user");
            DropForeignKey("dbo.invitation", "event_id", "dbo.event");
            DropForeignKey("dbo.CustomUserClaims", "UserId", "dbo.user");
            DropForeignKey("dbo.image", "gallery_id_Gallery", "dbo.gallery");
            DropForeignKey("dbo.gallery", "event_id", "dbo.event");
            DropIndex("dbo.gallery_image", new[] { "images_id_Image" });
            DropIndex("dbo.gallery_image", new[] { "Gallery_id_Gallery" });
            DropIndex("dbo.user_image", new[] { "User_id" });
            DropIndex("dbo.user_image", new[] { "images_id_Image" });
            DropIndex("dbo.user_video", new[] { "User_id" });
            DropIndex("dbo.user_video", new[] { "videos_id_Video" });
            DropIndex("dbo.gallery_video", new[] { "Gallery_id_Gallery" });
            DropIndex("dbo.gallery_video", new[] { "videos_id_Video" });
            DropIndex("dbo.user_ticket", new[] { "User_id" });
            DropIndex("dbo.user_ticket", new[] { "tickets_idEvent", "tickets_idUser" });
            DropIndex("dbo.video", new[] { "user_id" });
            DropIndex("dbo.video", new[] { "gallery_id_Gallery" });
            DropIndex("dbo.ticket", new[] { "idUser" });
            DropIndex("dbo.ticket", new[] { "idEvent" });
            DropIndex("dbo.task", new[] { "organizer_id" });
            DropIndex("dbo.task", new[] { "event_id" });
            DropIndex("dbo.CustomUserRoles", new[] { "CustomRole_Id" });
            DropIndex("dbo.CustomUserRoles", new[] { "UserId" });
            DropIndex("dbo.registration", new[] { "participant_id" });
            DropIndex("dbo.registration", new[] { "event_id" });
            DropIndex("dbo.propositon", new[] { "user_id" });
            DropIndex("dbo.propositon", new[] { "event_id" });
            DropIndex("dbo.CustomUserLogins", new[] { "UserId" });
            DropIndex("dbo.invitation", new[] { "invitedBy" });
            DropIndex("dbo.invitation", new[] { "event_id" });
            DropIndex("dbo.CustomUserClaims", new[] { "UserId" });
            DropIndex("dbo.image", new[] { "user_id" });
            DropIndex("dbo.image", new[] { "gallery_id_Gallery" });
            DropIndex("dbo.gallery", new[] { "event_id" });
            DropIndex("dbo.event", new[] { "createdBy" });
            DropIndex("dbo.EventOrganizers", new[] { "president_Id" });
            DropIndex("dbo.EventOrganizers", new[] { "organizerId" });
            DropIndex("dbo.EventOrganizers", new[] { "EventId" });
            DropTable("dbo.gallery_image");
            DropTable("dbo.user_image");
            DropTable("dbo.user_video");
            DropTable("dbo.gallery_video");
            DropTable("dbo.user_ticket");
            DropTable("dbo.HistoryRows");
            DropTable("dbo.AspNetUserRoles");
            DropTable("dbo.CustomRoles");
            DropTable("dbo.payment");
            DropTable("dbo.video");
            DropTable("dbo.ticket");
            DropTable("dbo.task");
            DropTable("dbo.CustomUserRoles");
            DropTable("dbo.registration");
            DropTable("dbo.propositon");
            DropTable("dbo.CustomUserLogins");
            DropTable("dbo.invitation");
            DropTable("dbo.CustomUserClaims");
            DropTable("dbo.user");
            DropTable("dbo.image");
            DropTable("dbo.gallery");
            DropTable("dbo.event");
            DropTable("dbo.EventOrganizers");
        }
    }
}
