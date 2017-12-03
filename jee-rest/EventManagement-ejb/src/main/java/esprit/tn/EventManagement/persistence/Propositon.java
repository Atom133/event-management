package esprit.tn.EventManagement.persistence;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Propositon
 *
 */
@Entity

public class Propositon implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String description;
	@ManyToOne
	//@JsonBackReference
	private Participant user;
	@ManyToOne
	//@JsonBackReference
	private Event event;
	private static final long serialVersionUID = 1L;

	public Propositon() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Participant getUser() {
		return user;
	}
	public void setUser(Participant user) {
		this.user = user;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
   
}
