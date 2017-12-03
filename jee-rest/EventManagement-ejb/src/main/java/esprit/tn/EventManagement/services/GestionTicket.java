package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import esprit.tn.EventManagement.persistence.Ticket;

/**
 * Session Bean implementation class GestionTicket
 */
@Stateless
@LocalBean
public class GestionTicket implements GestionTicketRemote {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionTicket() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String addTicket(Ticket p) {
		em.persist(p);
		return "ok";
	}

	@Override
	public void deleteTicket(Ticket p) {
		em.remove(p);
		
	}

	@Override
	public void updateTicket(Ticket p) {
		em.merge(p);
		
	}

	@Override
	public Ticket findTicketById(int idTicket) {
		return em.find(Ticket.class, idTicket);
	}

	@Override
	public List<Ticket> findTicketsByIdEvent(int idEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> findAllTickets() {
		return em.createQuery("SELECT c FROM Client c",Ticket.class).getResultList();
	}

}
