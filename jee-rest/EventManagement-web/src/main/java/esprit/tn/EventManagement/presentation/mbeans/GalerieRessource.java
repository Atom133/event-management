package esprit.tn.EventManagement.presentation.mbeans;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import esprit.tn.EventManagement.persistence.*;

import esprit.tn.EventManagement.persistence.Gallery;
import esprit.tn.EventManagement.services.EventServiceRemote;
import esprit.tn.EventManagement.services.GalerieEjbRemote;
import esprit.tn.EventManagement.services.GestionImageRemote;
import esprit.tn.EventManagement.services.GestionVideoRemote;
import esprit.tn.EventManagement.services.UserServiceEJBRemote;


@Path("/galerie")
@RequestScoped
public class GalerieRessource {
	@EJB
	GestionVideoRemote metier1;
	@EJB
	GalerieEjbRemote metier;
	@EJB
	 UserServiceEJBRemote metier2;
	@EJB
	GestionImageRemote metier3;
	@EJB
	EventServiceRemote metier4;
	
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllGalerie(){
		return Response.ok(metier.findAllGalerie()).build();
	}
	@POST
	@Path("add/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addGalerie(Gallery  galerie,@PathParam("id") int id){
		galerie.setEvent(metier4.findEventById(id));
		
		metier.addGalerie(galerie);
		return Response.ok("tehani etzed").build();
	}
	@GET
	@Path("find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findGalerieById(@PathParam("id")int id){
		return Response.ok("galerie est" + metier.findGalerieById(id)).build();
	}
	@DELETE
	@Path("delet")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteImage(Gallery galerie){
		metier.deleteGalerie(galerie);
		return Response.ok("galerie est effacer" ).build();
	}

	@PUT
	@Path("update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateGalerie(Gallery galerie,@PathParam("id") int id){
		galerie.setEvent(metier4.findEventById(id));
		metier.updateGalerie(galerie);
		return Response.ok("galerie est modifier" ).build();
	}
	
}
