package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.tn.EventManagement.persistence.Ticket;

@Remote
public interface GestionTicketRemote {

	public String addTicket(Ticket p);
	public void deleteTicket(Ticket p);
	public void updateTicket(Ticket p);
	public Ticket findTicketById(int idTicket);
	public List<Ticket> findAllTickets();
	public List<Ticket> findTicketsByIdEvent(int idEvent);
}

