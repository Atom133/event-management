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
import javax.ws.rs.core.Response;

import esprit.tn.EventManagement.persistence.Image;
import esprit.tn.EventManagement.services.GalerieEjbRemote;
import esprit.tn.EventManagement.services.GestionImageRemote;
import esprit.tn.EventManagement.services.UserServiceEJBRemote;

import javax.ws.rs.core.MediaType;

@Path("/image")
@RequestScoped
public class ImageRessource {
	@EJB
	GestionImageRemote metier;
	@EJB
	GalerieEjbRemote metier1;
	@EJB
	UserServiceEJBRemote metier2;
	
	

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getimage() {
		return Response.ok(metier.findAllImages()).build();
	}

	@POST
	@Path("add/{id}/{id1}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addimage(Image image, @PathParam("id") int id, @PathParam("id1") int id1) {
		image.setGallery(metier1.findGalerieById(id));
		image.setUser(metier2.findUserById(id1));
		metier.addImage(image);
		return Response.ok("ok").build();
	}

	@GET
	@Path("find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findImageById(@PathParam("id") int id) {
		return Response.ok("image est" + metier.findImageById(id)).build();
	}

	@DELETE
	@Path("delet/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteImage(@PathParam("id") int id) {

		metier.deleteImage(id);
		return Response.ok("image est effacer").build();
	}

	@PUT
	@Path("update/{id}/{id1}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateImage(Image image, @PathParam("id") int id, @PathParam("id1") int id1) {
		image.setGallery(metier1.findGalerieById(id));
		image.setUser(metier2.findUserById(id1));
		metier.updateImage(image);
		return Response.ok("image est modifier").build();
	}

	@GET
	@Path("listedeGalerie/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findbygalerieId(@PathParam("id") int id) {

		return Response.ok("la liste des image de cette galerier est " + metier.findImageById(id)).build();
	}

}
