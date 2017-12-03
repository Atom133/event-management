package esprit.tn.EventManagement.presentation.mbeans;

import java.util.ArrayList;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import esprit.tn.EventManagement.persistence.User;
import esprit.tn.EventManagement.services.UserServiceEJB;

@Path("users")
@RequestScoped
public class UserResource {
	@EJB
	UserServiceEJB metier;

	static List<User> users = new ArrayList<User>();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetUsers() {
		if (users == null) {
			return Response.status(Status.NO_CONTENT).build();
		}
		return Response.status(Status.FOUND).entity(metier.findAllUsers()).build();
	}

	@GET
	@Path("byid/{idUser}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUserById(@PathParam("idUser") int id) {
		return Response.status(Status.OK).entity(metier.findUserById(id)).build();
	}

	@GET
	@Path("bycin/{idCin}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUserByCin(@PathParam("idCin") int idCin) {
		return Response.status(Status.FOUND).entity(metier.findUserByCin(idCin)).build();
	}

	@GET
	@Path("byname/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUserByName(@PathParam("name") String name) {
		return Response.status(Status.FOUND).entity(metier.findUserByName(name)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		return Response.status(Status.CREATED).entity(metier.createUser(user)).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(User user) {
		return Response.status(Status.OK).entity(metier.updateUser(user)).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUser(User user) {
		return Response.status(Status.OK).entity(metier.deleteUser(user)).build();
	}

	@PUT
	@Path("block/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response BlockUser(@PathParam(value = "id") int id) {
		return Response.status(Status.OK).entity(metier.BlockUser(id)).build();
	}

	@PUT
	@Path("activate/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ActivateUser(@PathParam(value = "id") int id) {
		return Response.status(Status.OK).entity(metier.ActivateUser(id)).build();
	}
	
	@GET
	@Path("authentificate/{login}/{pwd}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response authentificate(@PathParam(value = "login") String login,@PathParam(value = "pwd") String pwd) {
		return Response.status(Status.ACCEPTED).entity(metier.authentificate(login,pwd)).build();
	}

}
