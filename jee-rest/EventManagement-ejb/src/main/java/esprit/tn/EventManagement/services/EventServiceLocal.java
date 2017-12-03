package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Local;

import esprit.tn.EventManagement.persistence.Event;

@Local
public interface EventServiceLocal {

	public void addEvent(Event e);
	public List<Event> getEvent();
	public String deleteEvent(int id);
	public String updateEvent(Event e);
	public Event findEventById(int id);
	public List<Event> findEventByName(String	n);
	public List<Event> findEventByMonth(String month);
	public List<Event> findEventByYear(String year);
	public List<Event> findEventByType(String t);
	public List<Event> findEventByPlace(String p);
	public List<Event> findEventByCategorie(String c);
}
