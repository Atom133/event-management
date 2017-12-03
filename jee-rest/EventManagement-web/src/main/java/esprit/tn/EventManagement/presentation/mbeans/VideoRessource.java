package esprit.tn.EventManagement.presentation.mbeans;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import esprit.tn.EventManagement.persistence.Video;
import esprit.tn.EventManagement.services.EventServiceRemote;
import esprit.tn.EventManagement.services.GalerieEjbRemote;
import esprit.tn.EventManagement.services.GestionImageRemote;
import esprit.tn.EventManagement.services.GestionVideoRemote;
import esprit.tn.EventManagement.services.UserServiceEJBRemote;

@Path("/video")
@RequestScoped
public class VideoRessource {
	@EJB
	GestionVideoRemote metier;
	@EJB
	GalerieEjbRemote metier1;
	@EJB
	UserServiceEJBRemote metier2;

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVideo() {
		return Response.ok(metier.findAllVideos()).build();
	}

	@POST
	@Path("add/{id}/{id1}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addvideo(Video video, @PathParam("id") int id, @PathParam("id1") int id1) {
		video.setGallery(metier1.findGalerieById(id));
		video.setUser(metier2.findUserById(id1));
		metier.addVideo(video);
		return Response.ok("oki").build();
	}

	@GET
	@Path("find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findImageById(@PathParam("id") int id) {
		return Response.ok("video est" + metier.findVideoById(id)).build();
	}

	@DELETE
	@Path("delet/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteImage(@PathParam("id") int id) {
		metier.deleteVideo(id);
		return Response.ok("video est effacer").build();
	}

	@PUT
	@Path("update/{id}/{id1}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateImage(Video video, @PathParam("id") int id, @PathParam("id1") int id1) {
		video.setGallery(metier1.findGalerieById(id));
		video.setUser(metier2.findUserById(id1));
		metier.updateVideo(video);
		return Response.ok("video est modifier").build();
	}

	@GET
	@Path("listedeGalerie/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findbygalerieId(@PathParam("id") int id) {

		return Response.ok("la liste des image de cette galerier est " + metier.findVideoById(id)).build();
	}
}
