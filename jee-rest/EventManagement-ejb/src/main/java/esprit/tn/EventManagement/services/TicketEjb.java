package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import esprit.tn.EventManagement.persistence.Ticket;
import esprit.tn.EventManagement.persistence.TicketPk;



/**
 * Session Bean implementation class TicketEjb
 */
@Stateless
@LocalBean
public class TicketEjb implements TicketEjbRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager em;
    public TicketEjb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void discount(int dis,int idu,int ide) {
		Ticket tc =new Ticket();
		tc = findTicketById(idu, ide);
	//	tc.setDiscount(dis);
		float p=(tc.getPrix()*dis)/100;
		tc.setPrix(p);
		
	}

	@Override
	public void addUser(Ticket c) {
		em.persist(c);
		
	}

	@Override
	public List<Ticket> getTicket() {
		// TODO Auto-generated method stub
		 return em.createQuery("From Ticket").getResultList();
	}

	
	

	@Override
	public Ticket findTicketById(int idu, int ide) {
//       TicketPk tf =new TicketPk();
//       tf.setIdEvent(ide);
//       tf.setIdUser(idu);
//		return em.find(Ticket.class);
		return null;
	}


	

}
