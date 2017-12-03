package esprit.tn.EventManagement.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: President
 *
 */
@Entity
public class President extends User implements Serializable {

	
	private String societe;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="president")
	@JsonIgnore
	private List<Event> events;

	public President() {
		super();
	}   

	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}


	public String getSociete() {
		return this.societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}
   
}
