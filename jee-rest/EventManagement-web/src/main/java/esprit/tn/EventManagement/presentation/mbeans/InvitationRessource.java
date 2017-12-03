package esprit.tn.EventManagement.presentation.mbeans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import esprit.tn.EventManagement.persistence.Invitation;
import esprit.tn.EventManagement.services.InvitationServiceLocal;

@Path("/Invitation")
@RequestScoped
public class InvitationRessource {

	@Inject
	InvitationServiceLocal invitationLS;
    
	@DELETE
	@Path("{id}")
	@Consumes("application/json")
    public String deleteInvitation(@PathParam("id")int id){
    	return invitationLS.deleteInvitation(id);
    }
	
	@PUT
	@Produces("application/json")
    public String updateInvitationEtat(@QueryParam(value="id")int id,@QueryParam(value="etat")String etat){
    	return invitationLS.updateInvitationEtat(id, etat);
    }
	
	@GET
	@Produces("application/json")
    public List<Invitation> getAllInvitationsByInvited(@QueryParam(value="idInvited")int idInvited){
    	return invitationLS.getAllInvitationsByInvited(idInvited);
    }
	
}
