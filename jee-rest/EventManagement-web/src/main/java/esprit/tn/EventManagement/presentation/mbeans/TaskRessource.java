package esprit.tn.EventManagement.presentation.mbeans;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
import esprit.tn.EventManagement.services.TaskServiceEJB;


@Path("task")
@RequestScoped
public class TaskRessource {
	@EJB
	TaskServiceEJB metier;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response ConsultAllTasks(){
		return Response.ok(metier.consultAllTasks()).build();
	}
	
	@Path("{idOrg}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response ConsultTasksByOrganizer(@PathParam("idOrg")int idOrg){
		return Response.ok(metier.consultAllTasksByOrganizer(2)).build();
	}
	
	@Path("confirm/{idTask}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response confirmTask(@PathParam(value="idTask")int idTask){
		return Response.ok(metier.confirmTask(idTask)).build();
	}
	
	@Path("reject/{idTask}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response rejectTask(@PathParam(value="idTask")int idTask){
		return Response.ok(metier.rejectTask(idTask)).build();
	}
	
	
	@Path("view/{idTask}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewTask (@PathParam(value="idTask")int idTask){
		return Response.ok(metier.viewDetailTask(idTask)).build();
	}



	
	
	

}
