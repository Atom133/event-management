package esprit.tn.EventManagement.presentation.mbeans;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import esprit.tn.EventManagement.services.EvenManagementEJBLocal;

@Path("ews")
@RequestScoped
public class EventWebService 
{
	
	@EJB
	private EvenManagementEJBLocal  service;
	
	
	@GET
	@Path("{id}")
	public String seeDetailsAboutEvent(@PathParam("id") int id)
	{
		return service.seeDetailsAboutEvent(id);
	}
	
}
