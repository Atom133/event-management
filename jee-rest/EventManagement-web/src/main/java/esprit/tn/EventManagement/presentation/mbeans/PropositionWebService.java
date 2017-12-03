package esprit.tn.EventManagement.presentation.mbeans;

import java.util.List;

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

import esprit.tn.EventManagement.persistence.Propositon;
import esprit.tn.EventManagement.services.EvenManagementEJBLocal;
import esprit.tn.EventManagement.services.PServiceEJBLocal;
import esprit.tn.EventManagement.services.ParticipantServiceEJBLocal;

@Path("prws")
@RequestScoped
public class PropositionWebService {
	
	
	@EJB
	PServiceEJBLocal service; 
	@EJB
	ParticipantServiceEJBLocal serviceP;
	@EJB
	EvenManagementEJBLocal serviceE;
	
	@POST
	@Path("{idp}/{ide}")
	@Consumes("application/json")
	public Response addProposition(@PathParam("idp") int idp, @PathParam("ide") int ide,Propositon p)
	{
		
		p.setEvent(serviceE.getById(ide));
		p.setUser(serviceP.getById(idp));
		service.addProposition(p);
		return Response.ok().build();
		
	}
	
	@PUT
	@Produces("application/json")
	@Path("{description}/{id}")
	public Response updateProposition(@PathParam("id")int id,@PathParam("description") String description)
	{
		Propositon p =service.findById(id);
		p.setDescription(description);
		service.UpdateProposition(p);
		p=service.findById(1);
		p.setEvent(null);
		p.setUser(null);
		return Response.ok(p).build(); 
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteProposition(@PathParam("id") int id )
	{
		Propositon p=service.findById(id);
		service.DeleteProposition(p);
		return Response.ok("suppression effectué avec succée").build();
	}
	
	@GET
	@Produces("application/json")
	public Response findAll()
	{
		List<Propositon> p= service.findAll();
		for(Propositon p1  : p)
		{
			p1.setEvent(null);
			p1.setUser(null);
		}
		return Response.ok(p).build();
	}
	
	
	

}
