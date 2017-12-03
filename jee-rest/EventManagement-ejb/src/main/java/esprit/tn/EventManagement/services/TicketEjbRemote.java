package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.tn.EventManagement.persistence.Ticket;





@Remote
public interface TicketEjbRemote {
     
	public void addUser(Ticket c);
	public List<Ticket> getTicket();
	public Ticket findTicketById(int idu,int ide);
	public void discount(int dis,int idu,int ide);
}
