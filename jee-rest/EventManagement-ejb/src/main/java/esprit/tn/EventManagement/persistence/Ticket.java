package esprit.tn.EventManagement.persistence;

import java.io.Serializable;
import java.lang.String;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ticket
 *
 */
@Entity

public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	//private Integer ticket_Id;
	private TicketPk ticketPK;
	
	private String description;
	private float prix;
	
	private Event event;
	private User user;
	
	

	public Ticket() {
		super();
	}   
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@ManyToOne
	@JoinColumn(name="idEvent", referencedColumnName="id",
				insertable=false, updatable=false)
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@ManyToOne
	@JoinColumn(name="idUser", referencedColumnName="id",
				insertable=false, updatable=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@EmbeddedId
	public TicketPk getTicketPK() {
		return ticketPK;
	}

	public void setTicketPK(TicketPk ticketPK) {
		this.ticketPK = ticketPK;
	}
   
}
