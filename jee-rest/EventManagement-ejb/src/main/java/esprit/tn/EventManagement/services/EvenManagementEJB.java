package esprit.tn.EventManagement.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import esprit.tn.EventManagement.persistence.Event;

/**
 * Session Bean implementation class EvenManagementEJB
 */
@Stateless
public class EvenManagementEJB implements EvenManagementEJBRemote, EvenManagementEJBLocal {

   @PersistenceContext
   	EntityManager em;
    public EvenManagementEJB() {
    	
    	
    }

	@Override
	public String seeDetailsAboutEvent(int id) {
		return em.find(Event.class,id).getDescription();
	}

	@Override
	public Event getById(int id) {
		return em.find(Event.class,id);
	}

}
