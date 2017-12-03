package esprit.tn.EventManagement.presentation.mbeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

import esprit.tn.EventManagement.persistence.Event;
import esprit.tn.EventManagement.services.EventServiceLocal;

@Path("/Event")
@RequestScoped
public class EventRessource {

	@Inject
	EventServiceLocal eventSL;
	
	@POST
	@Consumes("application/json")
	public void addEvent(Event e){
    	eventSL.addEvent(e);
    }
    
	@Path("{id}")
	@GET
	@Produces("application/json")
    public Event findEvent(@PathParam("id")int id){
    	return eventSL.findEventById(id);
    }
	
	
}
