package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

import esprit.tn.EventManagement.persistence.Event;

/**
 * Session Bean implementation class EventService
 */
@Stateless
@LocalBean
public class EventService implements EventServiceRemote, EventServiceLocal {

	@PersistenceContext(unitName="EventManagement-ejb")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public EventService() {
        // TODO Auto-generated constructor stub
    }
    
    public void addEvent(Event e){
    	em.persist(e);
    }
    
    public Event findEventById(int id){
    	return em.find(Event.class, id);
    }
    
    @Override
	public String deleteEvent(int param) {
		
		em.createQuery("DELETE FROM Event e WHERE e.id = "+param);
		
		
		return "deleted with success";
	}

	@Override
	public String updateEvent(Event e) {
		em.merge(e);
		return "event updated with success";
	}

	@Override
	public List<Event> findEventByName(String n) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT e FROM Event e WHERE e.name LIKE '%"+n+"%'",Event.class)
				
		        .getResultList();
	}

	@Override
	public List<Event> findEventByMonth(String month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> findEventByYear(String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> findEventByType(String t) {
return em.createQuery("SELECT e FROM Event e WHERE e.name LIKE '%"+t+"%'",Event.class)
				
		        .getResultList();
	}

	@Override
	public List<Event> findEventByPlace(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> findEventByCategorie(String c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEvent() {
		
		return em.createQuery("SELECT e FROM Event e ").getResultList();
		
	}

}
