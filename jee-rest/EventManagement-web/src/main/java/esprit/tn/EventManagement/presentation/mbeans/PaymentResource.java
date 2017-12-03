package esprit.tn.EventManagement.presentation.mbeans;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import esprit.tn.EventManagement.persistence.Payment;
import esprit.tn.EventManagement.services.PaymentServiceEJB;
@Path("payment")
@RequestScoped
public class PaymentResource {
	@EJB
	PaymentServiceEJB paymentEjb;
	
	@GET   
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
			return Response.ok(paymentEjb.listAllPayment()).build();
	} 
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPayment(Payment e){
		if(paymentEjb.addPayment(e))
			return Response.status(Status.CREATED).build();
		return Response.status(Status.NOT_ACCEPTABLE).build();
    }
	@Path("find/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response confirmTask(@PathParam(value="id")int id){
		return Response.ok(paymentEjb.searchPaymentById(id)).build();
	}
	


	@Path("delete/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
    public Response deleteInvitation(@PathParam("id")int  id){
    	if(paymentEjb.deletePayment(id)){
    		return Response.status(Status.ACCEPTED).build();
    		}	
    	return  Response.status(Status.NOT_ACCEPTABLE).build();
    }
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePayment(Payment pay) {
		if(paymentEjb.modifyPayment(pay))
			return Response.status(Status.ACCEPTED).build();
		return  Response.status(Status.NOT_ACCEPTABLE).build();
	}

}
