package esprit.tn.EventManagement.presentation.mbeans;


import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import esprit.tn.EventManagement.persistence.Participant;
import esprit.tn.EventManagement.services.ParticipantServiceEJBLocal;

@Path("pws")
@RequestScoped
public class ParticipantWebService {
	
@EJB
private ParticipantServiceEJBLocal  service;

@GET
@Produces("application/json")
public List<Participant> get()
{	
	return  service.countParticipantPoints() ;
}


@POST
public String addParticipant()
{
	if(service.addParticipant())
			{
					return "ok";
			}
	return "ko";
}

}
